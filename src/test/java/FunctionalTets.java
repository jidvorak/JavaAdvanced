import functional.FuncInterface;
import functional.FuncInterface02;
import functional.FuncInterface03;
import org.junit.jupiter.api.Test;

public class FunctionalTets {

    @Test
    public void funTest(){

        // pouziti funkcniho rozhrani -----------------------------------------
        // nadefinujeme promennou typu FuncInterface
        FuncInterface funcInterface;

        // nadefinujeme metodu (abstractFun) ktera vynasobi vstup X2 a vypise ho;
        funcInterface = (int x)->System.out.println(2*x);
        // zavolame metodu funkcniho rozhrani
        funcInterface.abstractFun(5);

        // -----------------------------------------------------------------
        // nadefinujeme metodu (abstractFun) ktera vynasobi vstup X2 a vypise ho;
        funcInterface = (int x)->{
            System.out.print("krat tri - ");
            System.out.println(3*x);
        };
        // zavolame metodu funkcniho rozhrani
        funcInterface.abstractFun(5);

    }

    @Test
    public void funTest02(){

        FuncInterface02 fobj02;
        // --------------------------------------
        // deklarujeme metodu zde
        fobj02 = (int x, int y)->{ // dva parametry
            System.out.println(x+y);
        };
        fobj02.abstractFun(5, 12);
    }

    @Test
    public void funTest03(){

        FuncInterface03 fobj03;
        // --------------------------------------
        fobj03 = (String s)->{ // deklarace metody ktera ma i navratovou hodnotu
            return new String(s + "-sufix");
        };
        String resultStr = fobj03.abstractFun("ahoj"); // volani metody
        System.out.println(resultStr); // vypis vysledku
    }
}
