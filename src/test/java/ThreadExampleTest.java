import enumpkg.BasicColorsEnum;
import org.junit.jupiter.api.Test;
import threads.MyRunnable;
import threads.MyThread;

public class ThreadExampleTest {

    @Test
    public void threadTest() throws Exception{

        // thread 01 - vytvorima a nastartujemae vlakno
        MyThread thread1 = new MyThread("   - new thread 01", 10);
        thread1.start();

        // thread 02 - vytvorima a nastartujemae vlakno
        MyThread thread2 = new MyThread("   - second thread 02", 20);
        thread2.start();


        thread1.join(); // ceka na ukonceni vlakna 1
        thread2.join(); // ceka na ukonceni vlakna 1

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



    }
