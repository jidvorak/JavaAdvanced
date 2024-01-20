package serialized;

import java.io.Serializable;

public class MySerializeClass implements Serializable {

    private String name = "";
    private Integer age = 0;
    private String address = "";

    public MySerializeClass(String aname, Integer aage, String aaddress){
        name = aname;
        age = aage;
        address = aaddress;
    }
    @Override
    public String toString(){
        return name + " - " + age.toString() + " - " + address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
