import org.junit.jupiter.api.Test;
import serialized.MySerializeClass;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class InputOutputSerialization {

    @Test
    public void serializeTest() throws Exception{

        String filename = "C:/JavaIO/serializable/serialized.binary";

        MySerializeClass serializeClass = new MySerializeClass("Jiri", 44, "London" );
        serializeClass.getStrList().add("hodnota1");
        serializeClass.getStrList().add("hodnota2");
        serializeClass.getStrList().add("hodnota888");

        System.out.println("serialize object : "  + serializeClass);
        serialize(serializeClass, filename);


        MySerializeClass newClass = deserialize(filename);
        System.out.println("deserialized object : "  + newClass);

    }

    // serializuje libovolny objekt ktery implementuje rozhrani Serialize
    public void serialize(Object serializeClass, String filename) throws Exception{
        FileOutputStream fileOutputStream = new FileOutputStream(filename); // vytvarime file output stream - data se budou zapisouvat do souboru
        ObjectOutputStream outputStream = new ObjectOutputStream(fileOutputStream); // objekt serializuje a zapisuje do fileOutStream
        outputStream.writeObject(serializeClass); // serializace objektu
        outputStream.flush(); // vyprazdneni bufferu do souboru
        outputStream.close(); // uzavreni proudu
        fileOutputStream.close(); // uzavreni proudu
    }

    // TODO udelat generiku
    public MySerializeClass deserialize(String filename) throws Exception{
        FileInputStream fileIn = new FileInputStream(filename); // vstupni stream ze souboru
        ObjectInputStream in = new ObjectInputStream(fileIn); // deserializacni stream
        MySerializeClass deserialized = (MySerializeClass) in.readObject(); // deserializce
        in.close(); // uzavirani
        fileIn.close(); // uzavirani
        return deserialized;
    }


}
