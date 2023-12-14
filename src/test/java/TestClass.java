import exceptions.ExcClass;
import org.junit.jupiter.api.Test;


public class TestClass {
    // TOKEN
    // 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
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
