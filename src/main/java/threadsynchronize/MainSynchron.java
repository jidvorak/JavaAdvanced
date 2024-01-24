package threadsynchronize;

// Ukazka synchronnizace vlaken
public class MainSynchron {
    public static void main(String args[]){

        // Vytvorime jeden objekt typu Table
        // objekt ma metodu printTable kterou volaji vlakna

        Table obj = new Table();

        // predame ho do dvou vlaken
        // obe vlakna volaji jednu metodu (printTable) objektu Table
        // pokud tuto metodu definujeme jako synchronized zmeni se chovani
        MyThread1 t1=new MyThread1(obj);
        MyThread2 t2=new MyThread2(obj);
        // start vlaken
        t1.start();
        t2.start();
    }
}
