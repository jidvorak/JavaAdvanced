import classesinheritence.MainCar;
import classesinheritence.PersonalCar;
import classesinheritence.VanBigger;
import classesinheritence.VanCar;
import org.junit.jupiter.api.Test;

public class CarrTestClass {

    @Test
    public void doTestCarr(){

        MainCar carclas = new MainCar(">>>nespecifikovano<<< ");
        carclas.printType();
        // ********************************************************************
        PersonalCar personal01 = new PersonalCar(">>>SPECIF STR<<< ");
        personal01.printType();
        // ********************************************************************
        PersonalCar personal = new PersonalCar();
        personal.printType();
        // ********************************************************************
        VanCar van = new VanCar(">>>VAN<<<");
        van.printType();
        van.printSize();
        // ********************************************************************
        VanBigger vanBigger = new VanBigger();
        vanBigger.setSPZ("SPZZZZZZZ");

        vanBigger.printType();
        vanBigger.printSize();


    }

}
