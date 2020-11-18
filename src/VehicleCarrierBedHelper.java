public class VehicleCarrierBedHelper {

    //Static methods in here? So no constructor cus why

    public void loadVehicle() {

    }

    public void unloadVehicle() {

    }

    public static boolean raiseRamp(){
        return true;
    }

    public static boolean lowerRamp() {
        return false;
    }

    public void getBedAccessible() {

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
