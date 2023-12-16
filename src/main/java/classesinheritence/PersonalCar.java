package classesinheritence;

// potomet hlavni tridy
public class PersonalCar extends MainCar {

    public PersonalCar(String aStrCar) {
        super(aStrCar);
    }

    public PersonalCar(){
        super(">>DEF<< ");
    }

    @Override
    public void printType(){
        System.out.println(dataclass.stringCar + " osobni vozidlo");
    }
}
