public class VehicleCarrierBedHelper {

    private IVehicleCarrierBed carrierBedInNeedOfHelp;
    private IStructureWithCarrierBed BedOwner;
    public VehicleCarrierBedHelper(IVehicleCarrierBed carrierBedInNeedOfHelp, IStructureWithCarrierBed BedOwner){
        this.carrierBedInNeedOfHelp=carrierBedInNeedOfHelp;
        this.BedOwner=BedOwner;
    }

    public int setVehicleMaxAmount(int amount){
        if(amount<1){
            System.out.println("Capacity must exceed zero cars");
            return 1;
        }
        return amount;
    }

    public void loadVehicle(Vehicle vehicle) {

        double distance = Math.sqrt(Math.pow(BedOwner.getXcord()-vehicle.getXcord(),2)+Math.pow(BedOwner.getYcord()-vehicle.getYcord(),2));

        if(distance>1){
            System.out.println("The Vehicle is to far away to be loaded");
            return;
        }
        else if(carrierBedInNeedOfHelp.getCarriedVehicles().size()>=carrierBedInNeedOfHelp.getCarsMaxAmount()) {
            System.out.println("The Carrier is full, cannot add another car");
            return;
        }
        else if(carrierBedInNeedOfHelp.getBedAccessible(BedOwner.getCurrentSpeed(),carrierBedInNeedOfHelp.getIsRaised())==false) {
            return;
        }
        this.carrierBedInNeedOfHelp.addVehicle(vehicle);
        vehicle.setCurrentlyTransported();
        vehicle.setPositionDuringTransport(vehicle.getXcord(), vehicle.getYcord());
    }

    public void unloadVehicle() {

        Vehicle vehicleToBeDroppedOff = carrierBedInNeedOfHelp.getCarriedVehicles().get(carrierBedInNeedOfHelp.getCarriedVehicles().size()-1);

        if(BedOwner instanceof Movable) {
            if (getBedAccessible(BedOwner.getCurrentSpeed(), carrierBedInNeedOfHelp.getIsRaised()) == false) {
                return;
            }

            double direction = BedOwner.getDirection();
            double newYcord = BedOwner.getXcord()-1*Math.cos(Math.toRadians(direction));
            double newXcord = BedOwner.getYcord()-1*Math.sin(Math.toRadians(direction));
            //The distance between the truck and the car will be 1 unit at dropoff
            //Is this math correct?

            System.out.println("newXcord is " + newXcord);
            System.out.println("newYcord is " + newYcord);
            vehicleToBeDroppedOff.setPositionDuringTransport(newXcord, newYcord);
            vehicleToBeDroppedOff.dropOffTransport();
        }


        carrierBedInNeedOfHelp.getCarriedVehicles().remove(carrierBedInNeedOfHelp.getCarriedVehicles().size()-1);
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
