package colections;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CollectionClass {

    public static Set<String> getStrSet(){
        // sada unikatnich retezcu - nejde vlozit 2x stejny retezec
        Set<String> set = new HashSet<>();
        set.add("aaa");
        set.add("bbb");
        set.add("ccc");
        set.add("ccc"); // toto se tam nedostane, ccc uz tam je
        set.add("ddd");
        return set;
        /*
        HashSet: pořadí položek není dodrženo ukládá informace do hash tabulky
        TreeSet: pořadí prvků je zachováno podle tzv. přirozeného řádu nebo podle nějakého [Comparator] (collections.md # comparator)
            ukládá data do červeno-černého stromu
        LinkedHashSet: ukládá informace o pořadí přidávání jednotlivých prvků implementace je založena na hashovací tabulce s podporou propojených seznamů
        */
    }
    public static Set<DataClass> getDataClassSet(){
        // sada unikatnich dat
        Set<DataClass> set = new HashSet<>();
        set.add(new DataClass("Karel", 25));
        set.add(new DataClass("Josef", 28));
        return set;
    }

    public static List<String> getStrList(){
        List<String> list = new ArrayList<>();
        list.add("aaa-list");
        list.add("bbb-list");
        list.add("ccc-list");
        list.add("ccc-list"); // toto se dostane, nereci duplicity
        list.add("ddd-list");
        return list;
    }

}
