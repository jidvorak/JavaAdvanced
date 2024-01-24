package threadsynchronize;

public class Table{

    /*synchronized*/ void printTable(String str){//synchronized method
    // odkomentovanim synchronized se zmeni chovani, metoda se nebude volat najednou

        for(int i=1;i<=5;i++){
            System.out.println(str + i);
            try{
                Thread.sleep(400);
            }catch(Exception e){System.out.println(e);}
        }

    }
}