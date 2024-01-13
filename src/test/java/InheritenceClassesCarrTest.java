import classesinheritence.Car;
import classesinheritence.PersonalCar;
import classesinheritence.VanBigger;
import classesinheritence.VanCar;
import org.junit.jupiter.api.Test;
import overideexample.Child01;
import overideexample.Child02;
import overideexample.Child03;

public class InheritenceClassesCarrTest {

    @Test
    public void doTestCarr(){

        Car carclas = new Car(">>>nespecifikovano<<< ");
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

    @Test
    public void testX() throws Exception {

        Child01 ch1 = new Child01();
        Child02 ch2 = new Child02();
        Child03 ch3 = new Child03();

        System.out.println(ch1.getName());
        System.out.println(ch2.getName());
        System.out.println(ch3.getName());

    }

}
