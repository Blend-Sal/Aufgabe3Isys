package actor;

import stream.Stream;

public class AskStream {


   public static Stream<String> ask(Actor<String> actor, String message, long timeout) {
        ActorReaderWriter aRW = ActorReaderWriter.actorReaderWriter("arW", actor, timeout);
        aRW.print(message);
        return aRW.readLines();
    }
}
