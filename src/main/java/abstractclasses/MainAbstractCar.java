package abstractclasses;

public abstract class MainAbstractCar {
    // -------------------------------------------
    public String getCarrInfo(){
        return " info=" + carInfoFromChild() + " len=" + carInfoLength();
    }
    public Integer getArea(){
        return carInfoLength() * carInfoWidth();
    }

    protected abstract String carInfoFromChild();
    protected abstract Integer carInfoLength();
    protected abstract Integer carInfoWidth();
    // --------------------------------------------------------
    protected String getCar(){
        return "CAR ";
    }

}
