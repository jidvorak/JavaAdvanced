import colections.CollectionClass;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Set;

public class CollectionTestClass {

    @Test
    public void colTst(){

        Set<String> set = CollectionClass.getStrSet();
        for(String setitem : set){
            System.out.println(setitem);
        }
        if(set.contains("bbb")){
            System.out.println("obsahuje becka");
        }
        if(!set.contains("xxx")){
            System.out.println("neobsahuje x-ka");
        }
    }

    @Test
    public void colListTst() {
        List<String> list = CollectionClass.getStrList();
        for (String setitem : list) {
            System.out.println(setitem);
        }
    }
}
