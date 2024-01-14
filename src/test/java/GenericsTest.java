import colections.DataClass;
import generisc.*;
import interfacebest.Child;
import interfacebest.ManInteface;
import interfacebest.OldMan;
import org.junit.jupiter.api.Test;

import java.lang.management.ManagementPermission;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    }

    // zpracuje pouze generickou tridu ktera pracuje s typem String
    public void genericProcBox(GenBox<String> b){
        String strInBox = b.getItem(); //  typ retezec
    }

    @Test
    public void testTypickePouziti(){

        // pracujeme s rozhranim a vkladame tridu Child ktera ho implementuje
        // asi nejlepsi pouziti

        GenBox<ManInteface> manBox = new GenBox<>();
        manBox.setItem(new Child());

        GenBox<ManInteface> manBox02 = new GenBox<>();
        manBox02.setItem(new OldMan());

        genericProcInterfaceBox(manBox);
        genericProcInterfaceBox(manBox02);

    }

    public void genericProcInterfaceBox(GenBox<ManInteface> genBox){

        ManInteface manInt = genBox.getItem();
        manInt.printName();

    }

    @Test
    public void testConstructor() {

        // genericka trida ktere v konstruktoru predavame data
        ManInteface man = new OldMan();
        GenCup<ManInteface> cup = new GenCup<>(man);

        GenCup<ManInteface> cup02 = new GenCup<>(new Child());

        GenCup<Integer> cup03 = new GenCup<>(11);

    }

    @Test
    public void pairTest(){

        // vytvoreni genericke tridy klic/hodnota s typy Integer/DataClass
        Pair<Integer, DataClass> pair = new Pair<>();
        pair.setKey(1); // nastaveni klice
        pair.setValue(new DataClass("first", 11)); // nastaveni hodnoty
        Integer key01 = pair.getKey(); // precteni klice
        DataClass dataClass01 = pair.getValue(); // precteni hodnoty
        System.out.println("klic=" + key01 + " - hodnota=" + dataClass01);

        // stejne je konstruovana mapa (do mapy se dá přidávat více záznamů - je to kolekce)
        Map<Integer, DataClass> map = new HashMap<>();

    }

    @Test
    public void pairChils(){

        // Potomek muze pracovat klicem definovanym zde jako <String>
        // hodnota byla definovana jako Integer pri dedeni v tride PairChild01
        PairChild01<String> child01 = new PairChild01<>();
        child01.setKey("some string11");
        child01.setValue(555);

        // potomek muze pracovat jen s <Integer, String>
        // to bylo deklarovano v tride PairChild02 ( extends Pair<Integer, String> )
        PairChild02 pchild = new PairChild02();
        pchild.setKey(11);
        pchild.setValue("stingX");

    }

    @Test
    public void genMethod(){

        // generická metoda převezme jen takové typy parametrů, jaké jsou deklarovány
        // v promenné ( Pair<Integer, String> firstPair ) tedy Integer + String
        Pair<Integer, String> firstPair = GeneriMethod.generatePair(1, "abcd");
        Pair<Integer, DataClass> nextPair = GeneriMethod.generatePair(1, new DataClass("name", 11));

        // TODO - dodelat
        /*
        String str = GeneriMethod.getString("teststr");
        String s2 = GeneriMethod.getString(111);
         */
    }

    @Test
    public void genLimits(){

        // genericka trida NumericBox definuje generiku jako <T extends Number>
        // proto jdou pouzit jen typy zdedene z Number

        // Integer jde pouzit, dedi z Number
        NumericBox<Integer> numBox = new NumericBox<>();
        numBox.setItem(11);
        // Double jde pouzit, dedi z Number
        NumericBox<Double> numDabBox = new NumericBox<>();
        numDabBox.setItem(11.1);

        /*
        // nejde pouzit String - nededi z Number
        NumericBox<String> numStrBox = new NumericBox<>();
        numStrBox.setItem("");*/

    }


}
