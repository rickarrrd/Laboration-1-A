import java.util.ArrayList;

public class Workshop implements IStructureWithCarrierBed{

    private CarCarrierBed carCarrierBed;

    private VehicleCarrierBedHelper vehicleCarrierBedHelper;
    private int vehicleMaxAmount;
    private ArrayList<String> whitelistedCarModels;
    //private ArrayList<Vehicle> carriedVehicles;
    private double xCord;
    private double yCord;
    private int direction;

    public Workshop(int vehicleMaxAmount, ArrayList<String> whitelistedCarModels, int xCord, int yCord, double direction){
        this.carCarrierBed= new CarCarrierBed( this,vehicleMaxAmount);
        this.vehicleCarrierBedHelper = new VehicleCarrierBedHelper(carCarrierBed, this);
        this.vehicleMaxAmount=vehicleCarrierBedHelper.setVehicleMaxAmount(vehicleMaxAmount);
        this.whitelistedCarModels=whitelistedCarModels;
        this.xCord=xCord;
        this.yCord=yCord;

    }


    public void loadVehicle(Vehicle vehicle) {

    }

    public void unloadVehicle() {

    }

    public double getXcord(){
        return xCord;
    }

    public double getYcord(){
        return yCord;
    }

    public double getDirection(){
        return direction;
    }

    public double getCurrentSpeed(){
        return 0;
    }

    public void raiseRamp() {
        return;
    }

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
        return carCarrierBed.getCarriedVehicles();
    }

    public void addVehicle(Vehicle vehicle){
        carCarrierBed.addVehicle(vehicle);
    }
}
