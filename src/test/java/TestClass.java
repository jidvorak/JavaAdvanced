import exceptions.ExcClass;
import org.junit.jupiter.api.Test;


public class TestClass {

    @Test
    public void exceptionsTest(){
        ExcClass ec = new ExcClass();
        try {
            ec.mainMethod();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
