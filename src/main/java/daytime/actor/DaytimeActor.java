package daytime.actor;

import java.util.Date;

import actor.AbstractActor;
import actor.Actor;
import actor.ActorReaderWriter;

import static actor.ActorReaderWriter.actorReaderWriter;

import fpinjava.Result;


class Daytime extends AbstractActor<String> {

    public Daytime(String id, Type type) {
        super(id, type);
    }

    // Reaktion auf eine beliebige Textnachricht die
    // aktuelle Systemzeit in Form einer Zeichenkette an den Absender zurücksendet.
    @Override
    public void onReceive(String message, Result<Actor<String>> sender) {

        sender.forEach(a -> a.tell(new Date().toString(), a));
    }

    public static void main(String[] args) throws InterruptedException {
        Daytime daytime = new Daytime("daytime", Type.SERIAL);
        ActorReaderWriter arw = actorReaderWriter("zeit", daytime, 500);


    }

}
