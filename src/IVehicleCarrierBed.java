import java.util.ArrayList;

public interface IVehicleCarrierBed {

    void loadVehicle(Vehicle vehicle);

    void unloadVehicle();

    void raiseRamp();

    void lowerRamp();

    boolean getBedAccessible(double currentSpeed, boolean isBedRaised);

    void addVehicle(Vehicle vehicle);

    ArrayList<Vehicle> getCarriedVehicles();

    int getCarsMaxAmount();

    boolean getIsRaised();
}
