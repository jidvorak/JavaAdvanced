package accessmodifier;

public class MyClass {

    private Integer cislo;

    public MyClass(Integer aCislo){
        cislo = aCislo;
    }

    // nejaka funkcnost ktera manipuluje s promennou cislo je nekde v teto tride


    public Integer getCislo() {
        return cislo;
    }
}
