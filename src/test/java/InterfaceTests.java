import interfaces.CarIntPersonal;
import interfaces.CarIntVan;
import interfaces.CarInterface;
import org.junit.jupiter.api.Test;

public class InterfaceTests {

    @Test
    public void intTest(){

        CarInterface carInterface01;

        carInterface01 = getInterface(1); // personal
        printInfo(carInterface01);

        carInterface01 = getInterface(10); // van
        printInfo(carInterface01);

    }

    // vytvori a vrati implementaci rozhrani dle parametru
    // implemntace je potomek CarIntPersonal nebo CarIntVan
    private CarInterface getInterface(int cartype){
        if(cartype==1)
            return new CarIntPersonal();
        else
            return new CarIntVan();
    }

    // metoda pouziva rozhrani nezavisle na tom co ji implementuje
    // CarIntPersonal nebo CarIntVan
    private void printInfo(CarInterface carInterface){
        System.out.println(carInterface.getSeparator());
        System.out.println(carInterface.getSPZ());
        System.out.println(carInterface.getCarType());
        System.out.println(carInterface.getLength());
        System.out.println(carInterface.getWith());

    }

}
