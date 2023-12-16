import exceptions.ExcClass;
import org.junit.jupiter.api.Test;


public class TestClass {

    // https://github.com/jidvorak/JavaAdvanced
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
