package actor;

import fpinjava.Result;

import java.util.concurrent.Semaphore;

public interface Actor<T> {
    static <T> Result<Actor<T>> noSender() {
        return Result.empty();
    }

    Result<Actor<T>> self();

    ActorContext<T> getContext();

    default void tell(T message) {
        tell(message, self());
    }

    void tell(T message, Result<Actor<T>> sender);

    void shutdown();

    default void tell(T message, Actor<T> sender) {
        tell(message, Result.of(sender));
    }

    enum Type {SERIAL, PARALLEL}


    Actor<Integer> referee =
            new AbstractActor<Integer>("Referee", Actor.Type.SERIAL) {
                @Override
                public void onReceive(Integer message, Result<Actor<Integer>> sender) {
                    System.out.println("Game ended after " + message + " shots");
                }
            };

    static class Player extends AbstractActor<Integer> {
        private final String sound;
        private final Actor<Integer> referee;

        public Player(String id, String sound, Actor<Integer> referee) {
            super(id, Actor.Type.SERIAL);
            this.referee = referee;
            this.sound = sound;
        }

        @Override
        public void onReceive(Integer message, Result<Actor<Integer>> sender) {
            System.out.println(sound + "-" + message);
            if (message >= 10) {
                referee.tell(message, sender);
            } else {
                sender.forEachOrFail(actor -> actor.tell(message + 1, self()))
                        .forEach(ignore -> referee.tell(message, sender));
            }
        }
    }

    static final Semaphore semaphore = new Semaphore(1);

    public static void main(String... args) throws InterruptedException {
        Actor<Integer> referee =
                new AbstractActor<Integer>("Referee", Actor.Type.SERIAL) {
                    @Override
                    public void onReceive(Integer message, Result<Actor<Integer>> sender) {
                        System.out.println("Game ended after " + message + " shots");
                        semaphore.release();
                    }
                };


        Actor<Integer> player1 = new Player("Player1", "Ping", referee);
        Actor<Integer> player2 = new Player("Player2", "Pong", referee);
        semaphore.acquire();
        player1.tell(1, Result.success(player2));
        semaphore.acquire();

        Thread.sleep(100);
        Actor<Integer> referee2 =
                new AbstractActor<Integer>("Referee2", Actor.Type.SERIAL) {
                    @Override
                    public void onReceive(Integer message, Result<Actor<Integer>> sender) {
                        System.out.println("Game ended after " + message + " shots");
                    }
                };
        Actor<Integer> player3 = new Player("Player3", "Ping", referee2);
        Actor<Integer> player4 = new Player("Player4", "Pong", referee2);
        player3.tell(1, Result.success(player4));

        //TODO um UserThreadFactory einzusetzen, ändert man die Funktion in AbstractActor.

    }
}



