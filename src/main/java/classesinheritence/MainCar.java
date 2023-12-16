package classesinheritence;

// hlavni trida ze ktere budeme dedit
public class MainCar {

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

    // class in method (nevidím rozumné použití)
    public void createPair(String key, int value) {
        class Pair {
            String key;
            int value;
        }
        Pair pair = new Pair();
        pair.key = key;
        pair.value = value;
    }




}
