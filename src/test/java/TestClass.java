import exceptions.ExcClass;
import org.junit.jupiter.api.Test;
import sun.jvm.hotspot.utilities.Assert;


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
