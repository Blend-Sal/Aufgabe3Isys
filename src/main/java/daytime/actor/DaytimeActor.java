package daytime.actor;

import java.util.Date;

import actor.AbstractActor;
import actor.Actor;

import actor.AskStream;
import fpinjava.Result;
import inout.ConsoleWriter;


class Daytime extends AbstractActor<String> {

    public Daytime(String id, Type type) {
        super(id, type);
    }

    // Reaktion auf eine beliebige Textnachricht:
    // Ausgeben der aktuellen Systemzeit
    @Override
    public void onReceive(String message, Result<Actor<String>> sender) {

        sender.forEach(a -> a.tell(new Date().toString(), a));
    }

    public static void main(String[] args) throws InterruptedException {
        Daytime daytime = new Daytime("daytime", Type.SERIAL);
        ConsoleWriter output = ConsoleWriter.stdout();
        AskStream.ask(daytime, "zeit", 500);

    }

}
