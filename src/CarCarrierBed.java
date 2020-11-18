import java.util.ArrayList;


public class CarCarrierBed implements IVehicleCarrierBed{

    private VehicleCarrierBedHelper vehicleCarrierBedHelper;

    private boolean isRaised;
    private int carsMaxAmount;

    private ArrayList<Vehicle> carriedCars= new ArrayList<Vehicle>();

    private IStructureWithCarrierBed bedOwner;

    public CarCarrierBed(IStructureWithCarrierBed bedOwner,int carsMaxAmount){
        vehicleCarrierBedHelper = new VehicleCarrierBedHelper(this, bedOwner);
        this.isRaised=false;
        this.bedOwner=bedOwner;
        this.setCarsMaxAmount(carsMaxAmount);
    }

    private void setCarsMaxAmount(int carsMaxAmount){
        this.carsMaxAmount=vehicleCarrierBedHelper.setVehicleMaxAmount(carsMaxAmount);
    }

    public int getCarsMaxAmount(){
        return this.carsMaxAmount;
    }

    public ArrayList<Vehicle>getCarriedVehicles(){
        return carriedCars;
    }

    public void raiseRamp(){
        isRaised=vehicleCarrierBedHelper.raiseRamp();
    }

    public void lowerRamp(){
        isRaised=vehicleCarrierBedHelper.lowerRamp();
    }

    public boolean getBedAccessible(double currentSpeed,boolean isRaised){
        return vehicleCarrierBedHelper.getBedAccessible(currentSpeed, isRaised);
    }

    public void loadVehicle(Vehicle car){

        if(car.getRegularSize()==false){
            System.out.println("The truck is only able to transport regular sized cars");
            return;
        }

        vehicleCarrierBedHelper.loadVehicle(car);

    }

    public boolean getIsRaised(){
        return isRaised;
    }

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