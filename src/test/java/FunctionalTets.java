import functional.Employee;
import functional.FuncInterface;
import functional.FuncInterface02;
import functional.FuncInterface03;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class FunctionalTets {

    @Test
    public void funTest(){

        // pouziti funkcniho rozhrani -----------------------------------------
        // nadefinujeme promennou typu FuncInterface
        FuncInterface funcInterface;

        // nadefinujeme metodu (abstractFun) ktera vynasobi vstup X2 a vypise ho;
        funcInterface = (int x)->System.out.println(2*x); // lambda výraz s jedním příkazem (nemusí být v {})
        // zavolame metodu funkcniho rozhrani
        funcInterface.abstractFun(5);

        // -----------------------------------------------------------------
        // nadefinujeme metodu (abstractFun) ktera vynasobi vstup X2 a vypise ho;
        funcInterface = (int x)->{ // lambda výraz s více řádky
            System.out.print("krat tri - ");
            System.out.println(3*x);
        };
        // zavolame metodu funkcniho rozhrani
        funcInterface.abstractFun(5);

    }

    @Test
    public void funTest02(){

        // deklarujeme metodu zde
        FuncInterface02 fobj02 = (int x, int y)->{ // dva parametry // lambda výraz
            System.out.println(x+y);
        };
        fobj02.abstractFun(5, 12);
    }

    @Test
    public void funTest03(){

        FuncInterface03 fobj03;
        // --------------------------------------
        fobj03 = (String s)->{ // deklarace metody ktera ma i navratovou hodnotu // lambda výraz s více řádky
            System.out.println("ahoj");
            return new String(s + "-sufix");
        };
        String resultStr = fobj03.abstractFun("ahoj"); // volani metody
        System.out.println(resultStr); // vypis vysledku
    }

    // *******************************************************************************
    // FUNCTION funkční rozhraní
    // generické funkční rozhraní, které přebírá objekt libovolného typu ( T)
    // a vrací objekt libovolného typu ( R). Metoda applyje zodpovědná za volání implementované akce.
    @Test
    public void funtest() {

        // slozitejsi
        /*
         //  v paxi dela lambda toto
         String funkceLAmbdy(Employee mujZamestnanec){
                return mujZamestnanec.getName();
        }*/

        Function<Employee, String> employeeToString = (mujZamestnanec) -> mujZamestnanec.getName(); // deklarace funkcniho rozhrani (typ objektu / datovy typ navratu)
        // toto rozhrani deklaruje volani metody employee.getName()

        // slozitejsi
        Function<Employee, String> employeeToStringSuf = (employee) -> employee.getNameAndSuffix(); // deklarace funkcniho rozhrani (typ objektu / datovy typ navratu)
        // toto rozhrani deklaruje volani metody employee.getNameAndSuffix()

        List<Employee> employeesList = Arrays.asList( // pole dvou objektu typu Employee
                new Employee("test"),
                new Employee("test2"));

        showEmployee(employeesList, employeeToString); // volame pomocnou funkci ktera zpracuje List a funkcni rozhrani
        showEmployee(employeesList, employeeToStringSuf); // volame pomocnou funkci ktera zpracuje List a funkcni rozhrani
    }
    // pomocna funkce
    static void showEmployee(List<Employee> employees, Function<Employee, String> showFunction) {
        // prochazi ve smycce list objektu Employee
        for (Employee employee : employees) {
            // volame funkcni rozhrani ktere ma deklarovanou funkci employee.getName() a ty vypisuje jmeno
            System.out.println(showFunction.apply(employee)); // Metoda apply je zodpovědná za volání implementované akce
        }
    }


    // xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
    // SUPPLIER dodavatel
    // obecné funkční rozhraní, jehož odpovědností je poskytovat hodnotu objektu typu T.
    // Metoda getvrací hodnotu implementovanou v rozhraní.
    @Test
    public void supltest() {
        getValue(() -> "supplier test!"); // do metody posíláme lambdu
    }

    static void getValue(Supplier<String> supplier){
        System.out.println(supplier.get()); //  Metoda getvrací hodnotu implementovanou v rozhraní.
    }

    // *******************************************************************************
    // Consumer - spotřebitel - je další obecné funkční rozhraní.
    // Představuje operaci, která přijímá jeden vstupní argument a nevrací žádný výsledek
    @Test
    public void consumtest() {
        Consumer<String> stringTrim = (s) -> {
            s = s.trim();
            System.out.println(s);
        }; // Consumer implementation using multi-line lambda

        trimValue(stringTrim, "   text    ");
    }

    static void trimValue(Consumer<String> trimAction, String s) {
        trimAction.accept(s);
    }

    // *******************************************************************************
    // Predicate - prtedikát
    // představuje operaci, která přijímá jeden argument a vrací logickou hodnotu založenou na předaném parametru
    @Test
    public void predictest() {
        Predicate<Integer> predicate = (value) -> {
            return value >= 0;
        };
        checkTest(predicate);
    }
    static void checkTest(Predicate<Integer> predicate) {
        System.out.println(predicate.test(-1));
    }

    // *******************************************************************************
    // Optional
    @Test
    public void optionaltest() {
        Optional<String> optStr00 = Optional.empty();
        Optional<String> optStr01 = Optional.of("ahoj");

        /*
        - isPresent vrací true/ falsev závislosti na tom, zda Optionalobsahuje nějaký objekt
        - isEmpty vrací hodnotu opačnou k hodnotě vrácené metodou isPresent, tj. dává informaci, zda Optional neukládá objekt
        - ifPresent bere Consumer jako argument rozhraní funkce. To consumer bude voláno pouze v případě, že Optional obsahuje odkaz na objekt.
        */

        if(optStr00.isPresent()){

        }

        optStr00.ifPresent(s -> {
            System.out.println("00 neni null;");
        });
        optStr01.ifPresent(s -> {
            System.out.println("01 neni null;");
        });

        /*
         - get vrátí hodnotu uloženou v objektu, nebo v případě null vyvolá výjimku:NoSuchElementException
         - orElse vrací hodnotu uloženou v Optional nebo hodnotu označenou jako argument metody v případě prázdné Optional
         - orElseGetvrací hodnotu uloženou v Optionalnebo hodnotu označenou Supplier, což je vstupní argument.
        * */

        String object = null;
        String name = Optional.ofNullable(object).orElse("john");
        System.out.println(name); // the value john will be printed on the screen

        String object02 = null;
        String name02 = Optional.ofNullable(object).orElseGet(() -> "john 02");
        System.out.println(name02); // String john reappears on the screen

    }

}
