package classesinheritence;

// potomet hlavni tridy
public class VanCar extends MainCar {

    public VanCar(String aStrCar){
        super(aStrCar);
    }

    @Override
    public void printType(){
        System.out.println(dataclass.stringCar + " nakladni vozidlo obecne");
    }

    public void printSize(){
        System.out.println("           - nespecifikovano");
    }

}
