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
        else if(inventoryInNeedOfHelp.getCarriedLoadables().size()>= inventoryInNeedOfHelp.getCarsMaxAmount()) {
            System.out.println("The Carrier is full, cannot add another car");
            return;
        }
        this.inventoryInNeedOfHelp.addLoadable(loadable);
        //loadable.setCurrentlyTransported();
        //loadable.setPositionDuringTransport(bedOwner.getXcord(), bedOwner.getYcord());
    }

    public void unload() {

        Loadable loadableToBeDroppedOff = inventoryInNeedOfHelp.getCarriedLoadables().get(inventoryInNeedOfHelp.getCarriedLoadables().size()-1);

        inventoryInNeedOfHelp.getCarriedLoadables().remove(inventoryInNeedOfHelp.getCarriedLoadables().size()-1);
    }

    public boolean raiseRamp(){
        return true;
    }

    public boolean lowerRamp() {
        return false;
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