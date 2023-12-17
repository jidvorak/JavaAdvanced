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
                return "";
            }

            @Override
            protected Integer carInfoLength() {
                return 5;
            }

            @Override
            protected Integer carInfoWidth() {
                return 4;
            }
        };

        System.out.println(abs.getCarrInfo());
    }
}



