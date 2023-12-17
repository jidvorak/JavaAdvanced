package exceptions;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ExcClass {


    public static void exceptHandle(String s){
        System.out.println(">>>>start metody<<<<");
        System.out.println("---------------------");
        try{
            System.out.println("start try");

            printStringCheckNull(s);
            printString(s);

            System.out.println("end try");

        }catch (Exception t){

            System.out.println("exception");
            System.out.println(t.getMessage());
        }
        System.out.println("------------------------");
        System.out.println(">>>> konec metody <<<<<");
    }

    // exception se musí deklarovat u metody
    public static void printStringCheckNull(String s) throws Exception {
        if(s!=null) {
            System.out.println(s);
            System.out.println(s.length());
        }else
            throw new Exception("Moje chyba : text chyby >>> string si nulllllllll");
    }

    // runtime exception se nemusí deklarovat u metody
    public static void printStringCheckNull02(String s) {
        if(s!=null) {
            System.out.println(s);
            System.out.println(s.length());
        }else
            throw new RuntimeException("Moje chyba : text chyby >>> string si nulllllllll");
    }

    public static void printString(String s){
        System.out.println(s);
        System.out.println(s.length());
    }





    public void mainMethod() throws Exception {
        throw new Exception();
    }

    public String readFirstLineFromFile(String path) {
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            return br.readLine();
        } catch (IOException e) {
            return "FAILED";
        }
    }
}
