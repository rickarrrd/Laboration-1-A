public class InventoryHelper {

    private IInventory inventoryInNeedOfHelp;
    private IHasInventory bedOwner;
    public InventoryHelper(IInventory inventoryInNeedOfHelp, IHasInventory bedOwner){
        this.inventoryInNeedOfHelp = inventoryInNeedOfHelp;
        this.bedOwner=bedOwner;
    }

    public int setVehicleMaxAmount(int amount){
        if(amount<1){
            System.out.println("Capacity must exceed zero cars");
            return 1;
        }
        return amount;
    }

    public void load(Loadable loadable) {

        double distance = Math.sqrt(Math.pow(bedOwner.getXcord()-loadable.getXcord(),2)+
                Math.pow(bedOwner.getYcord()-loadable.getYcord(),2));

        if(distance>1){
            System.out.println("The Vehicle is to far away to be loaded");
            return;
        }
        else if(inventoryInNeedOfHelp.getCarriedVehicles().size()>= inventoryInNeedOfHelp.getCarsMaxAmount()) {
            System.out.println("The Carrier is full, cannot add another car");
            return;
        }
        else if(!inventoryInNeedOfHelp.getBedAccessible(bedOwner.getCurrentSpeed(), inventoryInNeedOfHelp.getIsRaised())) {
            return;
        }
        this.inventoryInNeedOfHelp.addLoadable(loadable);
        //loadable.setCurrentlyTransported();
        //loadable.setPositionDuringTransport(loadable.getXcord(), loadable.getYcord());
    }

    public void unloadVehicle() {

        Vehicle vehicleToBeDroppedOff = inventoryInNeedOfHelp.getCarriedVehicles().get(inventoryInNeedOfHelp.getCarriedVehicles().size()-1);

        if(bedOwner instanceof Movable) {
            if (getBedAccessible(bedOwner.getCurrentSpeed(), inventoryInNeedOfHelp.getIsRaised()) == false) {
                return;
            }

            double direction = bedOwner.getDirection();
            double newYcord = bedOwner.getXcord()-1*Math.cos(Math.toRadians(direction));
            double newXcord = bedOwner.getYcord()-1*Math.sin(Math.toRadians(direction));
            //The distance between the truck and the car will be 1 unit at dropoff
            //Is this math correct?

            System.out.println("newXcord is " + newXcord);
            System.out.println("newYcord is " + newYcord);
            vehicleToBeDroppedOff.setPositionDuringTransport(newXcord, newYcord);
            vehicleToBeDroppedOff.dropOffTransport();
        }


        inventoryInNeedOfHelp.getCarriedVehicles().remove(inventoryInNeedOfHelp.getCarriedVehicles().size()-1);
    }

    public boolean raiseRamp(){
        return true;
    }

    public boolean lowerRamp() {
        return false;
    }

    public boolean getBedAccessible(double currentSpeed, boolean isRaised) {
        if(currentSpeed > 0.01 || isRaised == true){
            System.out.println("The bed is currently not accessible");
            return false;
        }
        return true;
    }

    public static boolean gasAvailable(double bedAngle) {
        if(bedAngle<0.01 && bedAngle>-0.01){
            System.out.println("Gas may only be applied when bed angle is set to 0");
            return true;
        }
        return false;
    }


    public static boolean gasAvailable(boolean isRaised){

        if(isRaised){
            return true;
        }
        return false;
    }


}