package actor;

import stream.Stream;

import static actor.ActorReaderWriter.actorReaderWriter;

public class AskStream {


    public static Stream<String> ask(Actor<String> actor, String message, long timeout) {
        ActorReaderWriter aRW = actorReaderWriter("arW", actor, timeout);
        aRW.print(message);
        return aRW.readLines();
    }

    public static Stream<String> ask(Writer transceiver, String message, long timeout) {
        ActorReaderWriter actorReaderWriter = actorReaderWriter("arW", transceiver, timeout);
        transceiver.start(actorReaderWriter.self());
        transceiver.tell(message, actorReaderWriter);
        return actorReaderWriter.readLines();
    }

}
