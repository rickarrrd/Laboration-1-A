import java.util.ArrayList;

public class Workshop implements IVehicleCarrierBed{

    private VehicleCarrierBedHelper vehicleCarrierBedHelper;
    private int vehicleMaxAmount;
    private ArrayList<String> whitelistedCarModels;
    private ArrayList<Vehicle> carriedVehicles;
    public Workshop(int vehicleMaxAmount, ArrayList<String> whitelistedCarModels){
        this.vehicleCarrierBedHelper = new VehicleCarrierBedHelper(this);
        this.vehicleMaxAmount=vehicleCarrierBedHelper.setVehicleMaxAmount(vehicleMaxAmount);
        this.whitelistedCarModels=whitelistedCarModels;
    }


    public void loadVehicle(Vehicle vehicle) {

    }

    public void unloadVehicle() {

    }
    @Override
    public void raiseRamp() {
        return;
    }
    @Override
    public void lowerRamp() {
        return;
    }

    public boolean getBedAccessible(double currentSpeed, boolean isBedRaised) {
        return true;
    }

    public boolean getIsRaised(){
        return true;
    }

    public int getCarsMaxAmount(){
        return vehicleMaxAmount;
    }

    public ArrayList<Vehicle> getCarriedVehicles(){
        return carriedVehicles;
    }

    public void addVehicle(Vehicle vehicle){
        carriedVehicles.add(vehicle);
    }
}
