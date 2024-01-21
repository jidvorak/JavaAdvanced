public class BuilderTestClass {

    // navrhovy hzor builder
    private String name;
    private String age;
    private String address;

    @Override
    public String toString(){
        return "[name=" + name + "; age=" + age + "; address=" + address + "]";
    }

    public BuilderTestClass setName(String name) {
        this.name = name;
        return this;
    }

    public BuilderTestClass setAge(String age) {
        this.age = age;
        return this;
    }

    public BuilderTestClass setAddress(String address) {
        this.address = address;
        return this;
    }
}
