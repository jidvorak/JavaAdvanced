import enumpkg.BasicColorsEnum;
import org.junit.jupiter.api.Test;
import threads.GunFight;
import threads.MyRunnable;
import threads.MyThread;
import threads.PrintDemo;


import java.util.Optional;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Stream;

public class ThreadExampleTest {

    @Test
    public void threadTest() throws Exception{

        // thread 01 - vytvorima a nastartujemae vlakno
        MyThread thread1 = new MyThread("   - THREAD 01", 10);
        thread1.start();

        // thread 02 - vytvorima a nastartujemae vlakno
        MyThread thread2 = new MyThread("   - THREAD 02", 20);
        thread2.start();

        thread1.join(); // ceka na ukonceni vlakna 1
        thread2.join(); // ceka na ukonceni vlakna 1

        // pokud prohram bezi dal jako zde - neni treba cekat na ukonceni (join)
        /*
        for (int i = 0; i < 100; i++) {
            try {
                Thread.sleep(100);
                System.out.println("              - " + i );
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        */
    }
    @Test
    public void runableTest() throws Exception {

        // vlakna je mozne spoustet i pomoci runnable
        // pouziti tridy implementujici runnable
        Thread t1 = new Thread(new MyRunnable());
        t1.start();
        // implementace runnable
        Thread t2 =  new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("Implementace runable 02");
            }
        });
        t2.start();

        t1.join(); // ceka na ukonceni vlakna 1
        t2.join(); // ceka na ukonceni vlakna 1
    }


    @Test
    public void serializableTestNew() throws Exception{
        // TODO
        PrintDemo PD = new PrintDemo();

    }

    @Test
    public void waitNotifTest(){

        // ukazka komunikace mezi thready cekani/pokracovani
        GunFight gunFight = new GunFight();
        // prvni vlakno vola metodu file objektu gunFight- ta se púo chvili zastavi a ceka
        new Thread() {
            @Override public void run() {
                // thread 1 (zavola metodu fire a ukonci se)
                // ale je v ni volana metoda wait proto uvnitr ceka
                gunFight.fire(30, 60); }
        }
        .start();

        // druhe vlakno vola reload cimz zajisti pokracovani metody v objektu gunFight
        new Thread() {
            @Override public void run() {
                // thread 2 (zavola metodu reload a ukonci se)
                gunFight.reload(); }
        }.start();
    }

        /* //  moznosti vytvareni ruznych typu Executor service
           // *********************************************************
         final ExecutorService singleThreadES = Executors.newSingleThreadExecutor(); // single thread pool
         final ExecutorService executorService = Executors.newFixedThreadPool(cpus); // pool with threads equal to cpu
         final ExecutorService cachedES = Executors.newCachedThreadPool();           // cached thread pool
         final ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(cpus); // scheduled thread pool with cpu equal number of threads
        * */
    @Test
    public void ExecutorTest() {
        // spravuje nase vlakna v nasi aplikaci
        ExecutorService executor = Executors.newFixedThreadPool(10);
        executor.execute(new Runnable() {
            public void run() {
                while(true) {
                    System.out.println("Asynchronous task 01 ");
                    try{
                        Thread.sleep(10);
                    }catch (Throwable t){

                    }
                }
            }
        });
        executor.execute(new Runnable() {
            public void run() {
                while(true) {
                    System.out.println("Asynchronous task 02 ");
                    try{
                        Thread.sleep(10);
                    }catch (Throwable t){

                    }
                }
            }
        });


    }

    }
