package exceptions;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ExcClass {

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
