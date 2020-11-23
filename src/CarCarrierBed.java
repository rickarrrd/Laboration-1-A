import java.util.ArrayList;


public class CarCarrierBed implements IVehicleCarrierBed{

    /**
     * Creates the helper for the CarrierBed functions
     */
    private VehicleCarrierBedHelper vehicleCarrierBedHelper;

    private boolean isRaised;
    private int carsMaxAmount;

    private ArrayList<Vehicle> carriedCars= new ArrayList<Vehicle>();

    private IStructureWithCarrierBed bedOwner;

    /**
     * Set parameters for the CarrierBed
     * @param bedOwner the owner of the carrierbed
     * @param carsMaxAmount the max capacity of cars
     */
    public CarCarrierBed(IStructureWithCarrierBed bedOwner,int carsMaxAmount){
        vehicleCarrierBedHelper = new VehicleCarrierBedHelper(this, bedOwner);
        this.isRaised=false;
        this.bedOwner=bedOwner;
        this.setCarsMaxAmount(carsMaxAmount);
    }

    /**
     * Sets max capacity
     */
    private void setCarsMaxAmount(int carsMaxAmount){
        this.carsMaxAmount=vehicleCarrierBedHelper.setVehicleMaxAmount(carsMaxAmount);
    }

    /**
     * @return the max capacity of the bed
     */
    public int getCarsMaxAmount(){
        return this.carsMaxAmount;
    }

    /**
     * @return the current cars on the bed
     */
    public ArrayList<Vehicle>getCarriedVehicles(){
        return carriedCars;
    }

    /**
     * @return wheter or not the bed ramp isRaised
     */
    public boolean getIsRaised(){
        return isRaised;
    }

    /**
     * Raise the ramp of the bed
     */
    public void raiseRamp(){
        isRaised=vehicleCarrierBedHelper.raiseRamp();
    }

    /**
     * Lower the ramp of the bed
     */
    public void lowerRamp(){
        isRaised=vehicleCarrierBedHelper.lowerRamp();
    }

    /**
     *
     * @param currentSpeed of the car
     * @param isRaised whether or not the bed barrier is raised
     * @return wheter or not the bed is accessible
     */
    public boolean getBedAccessible(double currentSpeed,boolean isRaised){
        return vehicleCarrierBedHelper.getBedAccessible(currentSpeed, isRaised);
    }

    /**
     * Loads a car onto the carrier bed
     * @param car the car which is about to get loaded
     */
    public void loadVehicle(Vehicle car){
        if(car.getRegularSize()==false){
            System.out.println("The truck is only able to transport regular sized cars");
            return;
        }
        vehicleCarrierBedHelper.loadVehicle(car);
    }

    /**
     *
      * @param vehicle
     */

    public void addVehicle(Vehicle vehicle){
        if(vehicle instanceof Car) {
            carriedCars.add((Car)vehicle);
            return;
        }
        System.out.println("Can only add cars");
    }

    public void unloadVehicle(){
        if(!getBedAccessible(bedOwner.getCurrentSpeed(), isRaised)){
            return;
        }
        Vehicle car = carriedCars.get(carriedCars.size()-1);

        //The distance between the truck and the car will be 1 unit at dropoff
        //Is this math correct?
        double direction = bedOwner.getDirection();
        double newYcord = bedOwner.getXcord()-1*Math.cos(Math.toRadians(direction));
        double newXcord = bedOwner.getYcord()-1*Math.sin(Math.toRadians(direction));

        System.out.println("newXcord is " + newXcord);
        System.out.println("newYcord is " + newYcord);
        car.setPositionDuringTransport(newXcord, newYcord);
        car.dropOffTransport();
        carriedCars.remove(carriedCars.size()-1);
    }
}