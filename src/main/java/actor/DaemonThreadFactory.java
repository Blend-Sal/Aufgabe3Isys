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



