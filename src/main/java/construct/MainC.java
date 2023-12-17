package construct;

public class MainC {

    private String name = "";
    private DataClass data;

    public MainC() {
        name = "empty name";
    }
    public MainC(DataClass datac) {
        data = datac;
    }

    public MainC(DataClass datac, String aname) {
        data = datac;
        name = aname;
    }
    public MainC(String aName){
        name = aName;
    }
    public MainC(String prefix, String aName){
        name = prefix + ": " + aName;
    }
    public String getName() {
        return name;
    }

}
