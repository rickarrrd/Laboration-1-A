public class VehicleCarrierBedHelper {

    private IVehicleCarrierBed CarrierBedInNeedOfHelp;

    public VehicleCarrierBedHelper(IVehicleCarrierBed CarrierBedInNeedOfHelp){
        this.CarrierBedInNeedOfHelp=CarrierBedInNeedOfHelp;
    }

    public int setVehicleMaxAmount(int amount){
        if(amount<1){
            System.out.println("Capacity must exceed zero cars");
            return 1;
        }
        return amount;
    }

    public void loadVehicle() {

    }

    public void unloadVehicle() {

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
