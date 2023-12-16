package accessmodifier.mainpkg;

import java.util.Random;

public class AccModifMainObject {

    public Integer randomInteger = 0;


    // default (nezadano) = pristup ze stejne tridy a trid stejneho paliku
    // public = pristup libovolny,
    // private = pristup jen ze stejne tridy
    // protected = jako default + pristup ze vsech potomku teteo tridy


    public AccModifMainObject(){

        Random rand = new Random();
        randomInteger = rand.nextInt(1000);
    }
}
