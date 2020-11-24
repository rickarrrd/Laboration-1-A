import java.util.ArrayList;

public interface IInventory {

    void load(Loadable loadable);

    void unloadVehicle();

    void raiseRamp();

    void lowerRamp();


    void addLoadable(Loadable loadable);

    ArrayList<Loadable> getCarriedLoadables();

    public boolean isReadyToBeLoaded();

    int getCarsMaxAmount();

    boolean getIsRaised();
}
