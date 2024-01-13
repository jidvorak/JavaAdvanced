import accessmodifier.MyClass;
import org.junit.jupiter.api.Test;



public class ClassInClasInMethodTest {



    @Test
    public void xxx(){

        TestCls.InClassStatic incls = new TestCls.InClassStatic();
        incls.jmeno = "karel";

        MyClass m = new MyClass(222);
        m.setCislo(33);
        //m.cislo=33;

    }

    public void createPair(String key, int value) {
        class Pair {
            String key;
            int value;
        }

        Pair pair = new Pair();
        pair.key = key;
        pair.value = value;


    }
    // trida Pair neni videt zde, da se pouzit jen v metode kde je deklarována
    //public void delejNeco(Pair p){}


}
