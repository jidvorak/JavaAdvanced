import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class InputOutputTests {

    protected static final String C_ROOTDIR = "C:/JavaIO";

    // **************** BASIC FILE *******************************

    @Test
    public void sysProperty(){
        // pouzity system property
        // vraci data dle opreracniho systemu WIN, MAC, LINUX
        System.out.println(System.getProperty("file.separator")); // oddelovac cesty k soubopru
        System.out.println(System.getProperty("line.separator")); // oddelovac radku textu

        // deklarace cesty s promenou prostredi dle operacniho systemu
        //protected static final String C_ROOTDIR = "C:" + System.getProperty("file.separator") + "JavaIO";
    }

    @Test
    public void basicIOTest() throws Exception {

        File file = new File(C_ROOTDIR + "/textfile.txt");
        if (file.exists()) { // test existence
            System.out.println("file exists");
            file.delete(); // smazani
        } else {
            System.out.println("file NOT exists");
        }
        file.createNewFile(); // prejmenovani

    }

    @Test
    public void renameTest() throws Exception {

        // trida file popisuje soubor ktery muze a nemusi existovat
        File file = new File(C_ROOTDIR + "/textfile.txt");
        if (file.exists()) { // pokud existuje

            // trida file popisuje novy soubor
            File newFile = new File(C_ROOTDIR + "/textfile_new_name.txt");
            if (newFile.exists()) { // pokud existuje
                newFile.delete(); // mazeme novy pokud existuje
            }
            file.renameTo(newFile); // stary soubor prejmenujeme na novy
        }
    }

    @Test
    public void genFilesTest() throws Exception {
        // vytvorime 10 souboru - generujeme nazev
        for(Integer i = 1; i<11; i++){
            File file = new File(C_ROOTDIR + "/file_" + i + ".txt");
            if (file.exists()) {
                file.delete();
            }
            file.createNewFile();
        }

    }

     // **************** STREAM *******************************

    @Test
    public void streamTest() throws Exception {
        FileInputStream in = null; // vstupni souborovy stream
        FileOutputStream out = null; // vystupni souborovy stream
        try{
            in = new FileInputStream(C_ROOTDIR + "/source.jpg"); // vytvoreni in strem s cestou ke zdrojovemu souboru
            out = new FileOutputStream(C_ROOTDIR + "/new.jpg"); // vytvoreni out strem s cetou k cilovamu souboru
            int c;
            while((c = in.read()) != -1){ // nacteme
                out.write(c); // vypiseme
            }
        }finally {
            if(in !=null){
                in.close();
            }
            if(out !=null){
                out.close();
            }
        }
    }


}