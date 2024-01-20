import org.junit.jupiter.api.Test;

import java.io.File;

public class InputOutputTests {

    protected static final String C_ROOTDIR = "C:/JavaIO";

    @Test
    public void basicIOTest() throws Exception {

        File file = new File(C_ROOTDIR + "/textfile.txt");
        if (file.exists()) { // test existence
            System.out.println("file exists");
            file.delete(); // smazani
        } else {
            System.out.println("file NOT exists");
        }
        file.createNewFile();

        //file.renameTo(new File(C_ROOTDIR + "/textfile_new_name.txt"));
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
}