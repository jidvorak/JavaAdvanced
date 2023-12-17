package exceptions;

import java.io.BufferedReader;
import java.io.FileReader;

public class ExcClosable {

    // konstrukce hlídání chyby u oběktu který implementuje rozhraní closable
    // nemusíme pro jeho uzavření používat blok finally
    public String readFirstLineFromFile(String path) {
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            return br.readLine();
        } catch (Exception e) {
            return "FAILED";
        }
    }

}
