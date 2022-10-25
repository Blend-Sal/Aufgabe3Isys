package echo.actor;

import actor.AbstractActor;
import actor.Actor;
import fpinjava.Result;

public class EchoActor extends AbstractActor<String> {

    public EchoActor(String id, Type type) {
        super(id, type);

    }


    // empfangene Textnachricht an den Absender zurücksendet.
    @Override
    public void onReceive(String message, Result<Actor<String>> sender)
    {
        sender.forEach(actor->actor.tell(message,self()));
    }
}


