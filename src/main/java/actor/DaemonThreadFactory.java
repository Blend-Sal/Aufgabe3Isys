package actor;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

public class DaemonThreadFactory implements ThreadFactory {


    public Thread newThread(Runnable runnableTask) {
        Thread thread = Executors.defaultThreadFactory().newThread(runnableTask);
        thread.setDaemon(true);
        return thread;
    }
}

// Ein ExecutorService ist eine API, die das Ausführen von Aufgaben in asynchronus vereinfacht.
// Sie stellt dem ExecutorService automatisch einen Pool von Threads und eine API bereit, um ihm Aufgaben zuzuweisen.

//Das Daemon - Thread ist ein Thread, welches User-Threads bedient, indem es im Hintergrund läuft und Dienste bereitstellt.
//Das User - Thread ist ein Thread, welches im Vordergrund läuft und Operationen ausführen kann.

//Die Message - Queue wird abstrahiert. Sie befindet sich in der Klasse Executors, die vom ExecutorService erweitert wird.

//Ein Semaphor stellt sicher, dass nur eine bestimmte Anzahl von Threads auf ein Objekt zugreifen können.

//Das Semaphor wird eingesetzt, damit das Programm nach der Ausführung nicht sofort terminiert.

