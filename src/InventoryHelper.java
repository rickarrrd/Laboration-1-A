import java.util.ArrayList;

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

    public ArrayList<ILoadable> load(ILoadable loadable) {

        double distance = Math.sqrt(Math.pow(bedOwner.getXcord()- loadable.getXcord(),2)+
                Math.pow(bedOwner.getYcord()- loadable.getYcord(),2));

        if(distance>1){
            System.out.println("The Vehicle is to far away to be loaded");
            return inventoryInNeedOfHelp.getCarriedTransportables();
        }
        else if(inventoryInNeedOfHelp.getCarriedTransportables().size()>= inventoryInNeedOfHelp.getCarsMaxAmount()) {
            System.out.println("The Carrier is full, cannot add another car");
            return inventoryInNeedOfHelp.getCarriedTransportables();
        }

        ArrayList<ILoadable> newCarriedILoadables = new ArrayList<ILoadable> (inventoryInNeedOfHelp.getCarriedTransportables());
        newCarriedILoadables.add(loadable);
        return newCarriedILoadables;
        //loadable.setCurrentlyTransported();
        //loadable.setPositionDuringTransport(bedOwner.getXcord(), bedOwner.getYcord());
    }

    public ArrayList<ILoadable> unload(int indexOfLoadable) {

        ILoadable ILoadable = inventoryInNeedOfHelp.getCarriedTransportables().get(indexOfLoadable);

        if(!inventoryInNeedOfHelp.isReadyToBeLoaded()){
            return inventoryInNeedOfHelp.getCarriedTransportables();
        }


        //The distance between the truck and the car will be 1 unit at dropoff
        //Is this math correct?
        double direction = bedOwner.getDirection();
        double newYcord = bedOwner.getXcord()-1*Math.cos(Math.toRadians(direction));
        double newXcord = bedOwner.getYcord()-1*Math.sin(Math.toRadians(direction));

        System.out.println("newXcord is " + newXcord);
        System.out.println("newYcord is " + newYcord);


        ArrayList<ILoadable> newCarriedILoadables =inventoryInNeedOfHelp.getCarriedTransportables();
        newCarriedILoadables.remove(indexOfLoadable);

        return newCarriedILoadables;
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