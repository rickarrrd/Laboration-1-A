import java.util.ArrayList;

public class Workshop implements IStructureWithCarrierBed{

    private CarCarrierBed carCarrierBed;

    private VehicleCarrierBedHelper vehicleCarrierBedHelper;
    private int vehicleMaxAmount;
    private ArrayList<Vehicle> whitelistedCarModels;
    //private ArrayList<Vehicle> carriedVehicles;
    private double xCord;
    private double yCord;
    private int direction;

    public Workshop(int vehicleMaxAmount, ArrayList<Vehicle> whitelistedCarModels, int xCord, int yCord, int direction){
        this.carCarrierBed= new CarCarrierBed( this,vehicleMaxAmount);
        this.vehicleCarrierBedHelper = new VehicleCarrierBedHelper(carCarrierBed, this);
        this.vehicleMaxAmount=vehicleCarrierBedHelper.setVehicleMaxAmount(vehicleMaxAmount);
        this.whitelistedCarModels=whitelistedCarModels;
        this.xCord=xCord;
        this.yCord=yCord;
        this.direction=direction;
    }



    public void loadVehicle(Vehicle vehicle){
        if(this.checkIfInWhitelist(whitelistedCarModels,vehicle)) {
            carCarrierBed.loadVehicle(vehicle);
        }
    }

    private boolean checkIfInWhitelist(ArrayList<Vehicle> whitelistedCarModels, Vehicle vehicleToBeChecked){
        for(Vehicle whitelistedCarModel : whitelistedCarModels){
            if(vehicleToBeChecked.getClass() == whitelistedCarModel.getClass()){
                return true;
            }
        }
        return false;
    }

    public void unloadVehicle() {
        carCarrierBed.unloadVehicle();
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

    public boolean getBedAccessible(double currentSpeed, boolean isBedRaised) {
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
