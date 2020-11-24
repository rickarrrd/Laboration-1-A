import java.util.ArrayList;


public class CarInventory implements IInventory {

    /**
     * Creates the helper for the CarrierBed functions
     */
    private InventoryHelper inventoryHelper;
    private boolean isRaised;

    private int carsMaxAmount;

    private ArrayList<Loadable> carriedLoadables= new ArrayList<Loadable>();

    private IHasInventory bedOwner;

    /**
     * Set parameters for the CarrierBed
     * @param bedOwner the owner of the carrierbed
     * @param carsMaxAmount the max capacity of cars
     */
    public CarInventory(IHasInventory bedOwner, int carsMaxAmount){
        inventoryHelper = new InventoryHelper(this, bedOwner);
        this.bedOwner=bedOwner;
        this.setCarsMaxAmount(carsMaxAmount);
    }

    /**
     * Sets max capacity
     */
    private void setCarsMaxAmount(int carsMaxAmount){
        this.carsMaxAmount= inventoryHelper.setVehicleMaxAmount(carsMaxAmount);
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
    public ArrayList<Loadable> getCarriedLoadables(){
        return carriedLoadables;
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
        isRaised= inventoryHelper.raiseRamp();
    }

    /**
     * Lower the ramp of the bed
     */
    public void lowerRamp(){
        isRaised= inventoryHelper.lowerRamp();
    }

    /**
     *
     * @param currentSpeed of the car
     * @param isRaised whether or not the bed barrier is raised
     * @return wheter or not the bed is accessible
     */
    public boolean isReadyToBeLoaded() {
        if(!bedOwner.isReadyToBeLoaded()){
            System.out.println("The bed is currently not accessible");
            return false;
        }
        if(isRaised=true){
            return false;
        }
        return true;
    }

    /**
     * Loads a car onto the carrier bed
     * @param car the car which is about to get loaded
     */
    public void load(Loadable loadable){
        if(loadable.getRegularSize()==false){
            System.out.println("The truck is only able to transport regular sized cars");
            return;
        }
        inventoryHelper.load(loadable);
    }

    /**
     *
      * @param vehicle
     */

    public void addLoadable(Loadable loadable){
        if(loadable instanceof Car) {
            carriedLoadables.add((Loadable)loadable);
            return;
        }
        System.out.println("Can only add cars");
    }

    public void unloadVehicle(){
        if(!isReadyToBeLoaded()){
            return;
        }
        Loadable loadable = carriedLoadables.get(carriedLoadables.size()-1);

        //The distance between the truck and the car will be 1 unit at dropoff
        //Is this math correct?
        double direction = bedOwner.getDirection();
        double newYcord = bedOwner.getXcord()-1*Math.cos(Math.toRadians(direction));
        double newXcord = bedOwner.getYcord()-1*Math.sin(Math.toRadians(direction));

        System.out.println("newXcord is " + newXcord);
        System.out.println("newYcord is " + newYcord);
        loadable.setPositionDuringTransport(newXcord, newYcord);
        carriedLoadables.remove(carriedLoadables.size()-1);
        loadable.dropOff();
    }
}