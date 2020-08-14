import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class MyThreadPool {
    private volatile boolean RUNNING = true;
    private static BlockingQueue<Runnable> queue = null;
    private final HashSet<Worker> workers = new HashSet<>();
    private final List<Thread> threadList = new ArrayList<>();

    int poolSize = 0;
    int coreSize = 0;
    boolean shutdown = false;

    class Worker implements Runnable {

        public Worker(Runnable runnable) {
            queue.offer(runnable);
        }

        @Override
        public void run() {
            while (true && RUNNING) {
                if (shutdown) {
                    Thread.interrupted();
                }
                Runnable task = null;
                try {
                    task = getTask();
                    task.run();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        public Runnable getTask() throws InterruptedException {
            return queue.take();
        }

        public void interruptIfIdle() {
            for (Thread thread : threadList) {
                System.out.println(thread.getName() + " interrupt");
                thread.interrupt();
            }
        }
    }

    public MyThreadPool(int poolSize) {
        this.poolSize = poolSize;
        queue = new LinkedBlockingQueue<>(poolSize);
    }

    public void exec(Runnable runnable) {
        if (runnable == null) throw new NullPointerException();
        if (coreSize < poolSize) {
            addThread(runnable);
        } else {
            //System.out.println("offer" +  runnable.toString() + "   " + queue.size());
            try {
                queue.put(runnable);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void addThread(Runnable runnable){
        coreSize ++;
        Worker worker = new Worker(runnable);
        workers.add(worker);
        Thread t = new Thread(worker);
        threadList.add(t);
        try {
            t.start();
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    public void shutdown() {
        RUNNING = false;
        if(!workers.isEmpty()){
            for (Worker worker : workers){
                worker.interruptIfIdle();
            }
        }
        shutdown = true;
        Thread.currentThread().interrupt();
    }

    public static void main(String[] args) throws InterruptedException {
        MyThreadPool excutor = new MyThreadPool(3);
        for (int i = 0; i < 10; i++) {
            excutor.exec(new Runnable() {
                @Override
                public void run() {
                    System.out.println("线程 " + Thread.currentThread().getName() + " 在帮我干活");
                }
            });
        }
        excutor.shutdown();
    }
}

