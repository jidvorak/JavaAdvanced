package abstractclasses;

public class PersonalCarChildAbs extends MainAbstractCar {

    @Override
    protected String carInfoFromChild() {
        return getCar() + ">>personal car<<";
    }

    @Override
    protected Integer carInfoLength() {
        return 4;
    }

    @Override
    protected Integer carInfoWidth() {
        return 4;
    }


}
