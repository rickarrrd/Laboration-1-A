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


    /**
     * Sets the parameters of the Workshop
     * @param vehicleMaxAmount max capacity of cars
     * @param whitelistedCarModels which car models are allowed
     * @param xCord The x coordinate of the workshop
     * @param yCord The y coordinate of the workshop
     * @param direction
     */
    public Workshop(int vehicleMaxAmount, ArrayList<Vehicle> whitelistedCarModels, int xCord, int yCord, int direction){
        this.carCarrierBed= new CarCarrierBed( this,vehicleMaxAmount);
        this.vehicleCarrierBedHelper = new VehicleCarrierBedHelper(carCarrierBed, this);
        this.vehicleMaxAmount=vehicleCarrierBedHelper.setVehicleMaxAmount(vehicleMaxAmount);
        this.whitelistedCarModels=whitelistedCarModels;
        this.xCord=xCord;
        this.yCord=yCord;
        this.direction=direction;
    }

    /**
     * Load a car into the workshop
     * @param vehicle the car to be loaded
     */
    public void loadVehicle(Vehicle vehicle){
        if(this.checkIfInWhitelist(whitelistedCarModels,vehicle)) {
            carCarrierBed.loadVehicle(vehicle);
        }
    }

    /**
     * Check wheter or not a car is allowed
     * @param whitelistedCarModels cars allowed
     * @param vehicleToBeChecked the car to be checked
     * @return wheter or not the car is allowed or not
     */
    private boolean checkIfInWhitelist(ArrayList<Vehicle> whitelistedCarModels, Vehicle vehicleToBeChecked){
        for(Vehicle whitelistedCarModel : whitelistedCarModels){
            if(vehicleToBeChecked.getClass() == whitelistedCarModel.getClass()){
                return true;
            }
        }
        return false;
    }

    /**
     * Release a car from the workshop
     */
    public void unloadVehicle() {
        carCarrierBed.unloadVehicle();
    }

    /**
     * @return the x coordinate of the workshop
     */
    public double getXcord(){
        return xCord;
    }

    /**
     * @return the y coordinate of the workshop
     */
    public double getYcord(){
        return yCord;
    }

    /**
     * @return the direction of the workshop
     */
    public double getDirection(){
        return direction;
    }
//Ugh fy fan, hatar att ha den här här
    public double getCurrentSpeed(){
        return 0;
    }

    public boolean getBedAccessible(double currentSpeed, boolean isBedRaised) {
        return true;
    }

    public int getCarsMaxAmount(){
        return vehicleMaxAmount;
    }

    /**
     * @return list of all stored cars
     */
    public ArrayList<Vehicle> getCarriedVehicles(){
        return carCarrierBed.getCarriedVehicles();
    }

    /**
     * Add a vehicle to the workshop
     * @param vehicle the vehicle to be added
     */
    public void addVehicle(Vehicle vehicle){
        carCarrierBed.addVehicle(vehicle);
    }
}
