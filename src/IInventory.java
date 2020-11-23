import java.util.ArrayList;

public interface IInventory {

    void load(Loadable loadable);

    void unloadVehicle();

    void raiseRamp();

    void lowerRamp();

    boolean getBedAccessible(double currentSpeed, boolean isBedRaised);

    void addLoadable(Loadable loadable);

    ArrayList<Vehicle> getCarriedVehicles();

    int getCarsMaxAmount();

    boolean getIsRaised();
}
