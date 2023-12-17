package classesinheritence;

// hlavni trida ze ktere budeme dedit
public class MainCar {

    protected String stringCar;
    protected String SPZ = "";

    public MainCar(String aStrCar){
        stringCar = aStrCar;
    }

    public void printType(){
        System.out.println(stringCar + " nespecifikovane vozidlo");
    }

    public void setSPZ(String SPZ) {
        SPZ = SPZ;
    }


}
