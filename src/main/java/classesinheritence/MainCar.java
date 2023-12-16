package classesinheritence;

// hlavni trida ze ktere budeme dedit
public class MainCar {

    // trida definovana v tride
    protected class DataClass {
        public String stringCar;
        public String SPZ = "";
    }
    protected DataClass dataclass = new DataClass();

    public MainCar(String aStrCar){
        dataclass.stringCar = aStrCar;
    }

    public void printType(){
        System.out.println(dataclass.stringCar + " nespecifikovane vozidlo");
    }

    public void setSPZ(String SPZ) {
        this.dataclass.SPZ = SPZ;
    }


}
