package functional;

/*
   @FunctionalInterface = Jakékoli rozhraní s SAM (Single Abstract Method) je funkční rozhraní
   a jeho implementace může být považována za výrazy lambda, muze obsahovat pouze jednu metodu
*/
@FunctionalInterface
public interface FuncInterface {
    void abstractFun(int x);

    default int min(int a, int b) {
        return a < b ? a : b;
    }
}
