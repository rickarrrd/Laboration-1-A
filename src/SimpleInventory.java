import java.util.ArrayList;


public class SimpleInventory implements ISimpleInventory {

    /**
     * Creates the helper for the CarrierBed functions
     */
    private InventoryHelper inventoryHelper;

    private int carsMaxAmount;

    private ArrayList<ILoadable> carriedTransportables= new ArrayList<ILoadable>();

    private IHasInventory bedOwner;

    /**
     * Set parameters for the CarrierBed
     * @param bedOwner the owner of the carrierbed
     * @param carsMaxAmount the max capacity of cars
     */
    public SimpleInventory(IHasInventory bedOwner, int carsMaxAmount){
        inventoryHelper = new InventoryHelper(this, bedOwner); //Doesn't work because Inventory Helper expects IInventory. Would be replaced by ISimpleInventory in fixed version.
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
    public ArrayList<ILoadable> getCarriedTransportables(){
        return carriedTransportables;
    }


    /**
     * Loads a car onto the carrier bed
     * @param loadable car which is about to get loaded
     */
    public void load(ILoadable loadable){

        carriedTransportables=inventoryHelper.load(loadable);
        //loadable.setCurrentlyTransported();
        //loadable.setPositionDuringTransport(bedOwner.getXcord(),bedOwner.getYcord());
        //This will now be a responsibility of the bedOwner to update the positions of carriedCars.
    }

    /**
     * unload the inventory
     * @param firstInFirstOut if unloading from front or back
     */
    public void unload(boolean firstInFirstOut){
        int indexOfLoadable;
        if(firstInFirstOut){
            indexOfLoadable=0;
        }else{
            indexOfLoadable= carriedTransportables.size()-1;
        }

        /*carriedTransportables.get(indexOfLoadable).setPositionDuringTransport(bedOwner.getXcord(),bedOwner.getYcord());
        carriedTransportables.get(indexOfLoadable).dropOff();*/
        carriedTransportables =inventoryHelper.unload(indexOfLoadable);
        //Shouldn't be necessary if move() does its job.
    }

    public void unload(int indexOfCarToBeUnloaded){
        carriedTransportables =inventoryHelper.unload(indexOfCarToBeUnloaded); //Specific for Workshop.
    }
}