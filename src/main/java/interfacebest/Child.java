package interfacebest;

public class Child implements ManInteface {
    @Override
    public void printName() {
        System.out.println("child");
    }

    @Override
    public void printAge() {
        System.out.println(9);
    }
}