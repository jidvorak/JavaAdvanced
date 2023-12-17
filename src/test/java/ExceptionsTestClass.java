import exceptions.ExcClass;
import exceptions.MyException;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

public class ExceptionsTestClass {

    @Test
    public void excTest(){

        //ExcClass.exceptHandle(null);
        //ExcClass.exceptHandle("retezec");
        ExcClass.smyckaCatchException();

    }

    @Test
    public void exError(){
        // spíse nepoužívat
        // throw new Error();
        /*
        Hashtable<Integer, String> tb = new Hashtable<>();
        List<String> namesList = new ArrayList<>();
        namesList.add("prvni");
        namesList.add("druhy");
        String[] names02 = new String[5];
         */
    }

    @Test
    public void exTest2(){
        try{

            ExcClass exc = new ExcClass();
            exc.customException("AHOJ");

        } catch (MyException e) {
            System.out.println("MY EXCEPTION   : " + e.getMessage());
            System.out.println("    - class    : " + e.getClassName());
            System.out.println("    - datetime : " + e.getDate());
            System.out.println("    - exitcode : " + e.getExitcode());
        }
    }
}
