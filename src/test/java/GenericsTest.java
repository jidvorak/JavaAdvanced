import colections.DataClass;
import generisc.Box;
import generisc.GenBox;
import interfacebest.Child;
import interfacebest.ManInteface;
import interfacebest.OldMan;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class GenericsTest {

    // negenerika ---------------------------------------------------------------------

    @Test
    public void nogenTest(){
        // vytvarime Box, nastavujeme mu item ktery muze byt libovolneho typu
        Box box = new Box();
        box.setItem("polozka v boxu");
        Box box2 = new Box();
        box2.setItem(11);
        noGenProcBox(box);
    }
    // predavame Box, ten ma item a nevíme jakého je datového typu
    public void noGenProcBox(Box b){
        Object o = b.getItem(); // o = neznamy typ
    }

    // generika ---------------------------------------------------------------------
    @Test
    public void genUsing(){

        // pouzivame u kolekci
        List<Integer> intList = new ArrayList<>();
        intList.add(11);
        Integer i = intList.get(0);

        List<String> strList = new ArrayList<>();
        //strList.add(11); // nejde
        strList.add("retezec");
        String s = strList.get(0);

        List<DataClass> dcList = new ArrayList<>();
        //strList.add(11); // nejde
        dcList.add(new DataClass("name", 44));
        DataClass dc = dcList.get(0);

        // tento list pracuje s rozhranim ManInteface
        // lze do nej vkladat i tridy ktere ho implementuji

        ManInteface ma = new OldMan("TO SU JA ");

        List<ManInteface> manIntList = new ArrayList<>();
        manIntList.add(new OldMan());
        manIntList.add(ma);
        manIntList.add(new Child());

        for (ManInteface mi : manIntList) {
            mi.printName();
        }
    }

    // vlastni generika ---------------------------------------------------------------------

    @Test
    public void genTest() {

        // vlastni genericka trida - kde pri zadání typu definujeme
        // s jakým datovým typem s bude pracovat. zde to je String - definuje se : GenBox<String>
        GenBox<String> stringBox = new GenBox<>();
        stringBox.setItem("string here");
        // stringBox.setItem(11); // spatny typ
        genericProcBox(stringBox);

        GenBox<Integer> intBox = new GenBox<>();
        intBox.setItem(11);
        // genericProcBox(intBox); // to nejde

        // pracujeme s tridou DataClass
        GenBox<DataClass> dataCBox = new GenBox<>();
        dataCBox.setItem(new DataClass("name", 22));

        // pracujeme s rozhranim a vkladame tridu Child ktera ho implementuje
        GenBox<ManInteface> manBox = new GenBox<>();
        manBox.setItem(new Child());

    }
    // zpracuje pouze generickou tridu ktera pracuje s typem String
    public void genericProcBox(GenBox<String> b){
        String strInBox = b.getItem(); //  typ retezec

    }


}

