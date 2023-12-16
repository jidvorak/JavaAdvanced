import enumerations.ColorsEnum;
import org.junit.jupiter.api.Test;

public class EnumTests {

    private static final String COLOR_RED  = "RED";
    private static final String COLOR_BLUE  = "BLUE";

    @Test
    public void constTest(){

        String color = COLOR_BLUE;

        if(color.equalsIgnoreCase(COLOR_BLUE)){
            System.out.println("je to modrá");
        }else if(color.equalsIgnoreCase(COLOR_RED)){
            System.out.println("je to červená");
        }

    }

    @Test
    public void enmTest(){

        // obdrzime enum, treba ve vstupním parametru
        ColorsEnum clrsenum = ColorsEnum.BLACK;

        // na základě jeho typu (enumu) provedeme nějakou cinnost
        if(clrsenum == ColorsEnum.BLUE){
            System.out.println("je to modrá");
        }else if(clrsenum == ColorsEnum.BLUE){
            System.out.println("je to červená");
        }else
            System.out.println("jina barva");

        // enum má v sobě i popis tak ho vytiskneme
        System.out.println("caption in enum for color is="+clrsenum.getColorName());

    }


}
