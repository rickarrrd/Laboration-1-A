public interface IVehicleCarrierBed {

    void loadVehicle(Vehicle vehicle);

    void unloadVehicle();

    void raiseRamp();

    void lowerRamp();

    boolean getBedAccessible(double currentSpeed, boolean isBedRaised);

}
