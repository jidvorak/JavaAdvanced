import annotations.SimpleAnotation;
import classesinheritence.Car;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ReflectionTestClass {


    @Test
    public void testDepric() throws Exception {
        TridaDepricated t = new TridaDepricated();
        t.tiskni("ahoj"); // depricated
        t.tiskniLepe("ahoj");
    }

    @Test
    public void testReflect() throws Exception {

        //Car car01 = new Car(); // klasicka tvorba
        //car01.stringCar = "abc";

        Class<?> carClass = Class.forName("classesinheritence.Car");

        // Car car = (Car) carClass.newInstance();
        // vytvorime instanci z tridy - nackene pomoci retezce "classesinheritence.Car"
        Car car = (Car) carClass.getDeclaredConstructor().newInstance();

        Field field = carClass.getDeclaredField("stringCar"); // ziskame field (protected String stringCar;) z Car
        field.setAccessible(true); // nastavime pristupnost
        field.set(car, " NOVAHODNOTA "); // nastavime hodnotu

        // nacteme metodu z tridy
        Method printT = carClass.getDeclaredMethod("printType");
        printT.invoke(car); // zavolame metodu z instance "car"

        // vypsani vsech metod tridy
        Method[] methods = carClass.getDeclaredMethods();
        Field[] fields = carClass.getDeclaredFields();
        System.out.println("Available methods: ");
        for (Method method : methods) {
            System.out.println(method);
        }
        // vypsani vsech fields tridy
        System.out.println("Available fields: ");
        for (Field fieldX : fields) {
            System.out.println(fieldX);
        }
        // precteni anotace z tridy
        SimpleAnotation simpleanotation = (SimpleAnotation)carClass.getAnnotation(SimpleAnotation.class);
        if(simpleanotation!=null) {
            System.out.println("----------------------------------------");
            System.out.println("Ano trida je anotovana @SimpleAnotation");
            System.out.println("----------------------------------------");
        }else
            System.out.println("Trida neni anotovana @SimpleAnotation");
    }

    // jen pro zajimavost - vypys vsech trid z baliko
    @Test
    public void findAllAuthEnumClasses() throws Exception {
        String packageName="classesinheritence";
        InputStream stream = ClassLoader.getSystemClassLoader()
                .getResourceAsStream(packageName.replaceAll("[.]", "/"));
        BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
        while(true) {
            String line = reader.readLine();
            if(line==null)
                break;
            if (line.endsWith(".class")) {
                String classname = packageName + "." + line.substring(0, line.length()-6);
                Class<?> cls = Class.forName(classname); // ziskame odkaz na tridu
                processClass(cls);
            }
        }
    }

    protected void processClass(Class<?> cls){
        System.out.println(cls.getName());
        //
        Method[] methods = cls.getDeclaredMethods();
        Field[] fields = cls.getDeclaredFields();
        for (Method method : methods) {
            System.out.println("    method - " + method);
        }

    }


}
