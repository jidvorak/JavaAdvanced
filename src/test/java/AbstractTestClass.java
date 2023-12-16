import abstractclasses.MainAbstractCar;
import abstractclasses.PersonalCarChildAbs;
import abstractclasses.VanCarChildAbs;
import org.junit.jupiter.api.Test;

public class AbstractTestClass {

    @Test
    public void absTest() {

        PersonalCarChildAbs absPersonal = new PersonalCarChildAbs();
        System.out.println(absPersonal.getCarrInfo());

        VanCarChildAbs absvan = new VanCarChildAbs();
        System.out.println(absvan.getCarrInfo());
    }

    // použití anonymní třídy
    @Test
    public void absAnonymTest() {
        MainAbstractCar abs = new MainAbstractCar() {
            @Override
            protected String carInfoFromChild() {
                return "ANONYM INFO";
            }

            @Override
            protected Integer carInfoLength() {
                return 1;
            }

            @Override
            protected Integer carInfoWidth() {
                return 2;
            }
        };
        System.out.println(abs.getCarrInfo());
    }
}



