import java.util.ArrayList;


public class CarCarrierBed implements IVehicleCarrierBed{

    private VehicleCarrierBedHelper vehicleCarrierBedHelper;

    private boolean isRaised;
    private int carsMaxAmount;

    private ArrayList<Car> carriedCars= new ArrayList<Car>();

    WalmartCarCarrier BedOwner;

    public CarCarrierBed(WalmartCarCarrier BedOwner,int carsMaxAmount){
        this.isRaised=false;
        this.BedOwner=BedOwner;
        this.setCarsMaxAmount(carsMaxAmount);
        vehicleCarrierBedHelper = new VehicleCarrierBedHelper(this);
    }

    private void setCarsMaxAmount(int carsMaxAmount){
        this.carsMaxAmount=vehicleCarrierBedHelper.setVehicleMaxAmount(carsMaxAmount);
    }

    public ArrayList<Car>getCarriedCars(){
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

        double distance = Math.sqrt(Math.pow(BedOwner.getXcord()-car.getXcord(),2)+Math.pow(BedOwner.getYcord()-car.getYcord(),2));

        if(distance>1){
            System.out.println("The Vehicle is to far away to be loaded");
            return;
        }
        else if(carriedCars.size()>=carsMaxAmount){
            System.out.println("The Carrier is full, cannot add another car");
            return;
        }else if(car.getRegularSize()==false){
            System.out.println("The truck is only able to transport regular sized cars");
            return;
        }else if(getBedAccessible(BedOwner.getCurrentSpeed(),isRaised)==false) {
            System.out.println("Bed is currently not accessible");
            return;
        }
        car.setCurrentlyTransported();
        car.setPositionDuringTransport(car.getXcord(), car.getYcord());
        //Probably bad below?
        if(car instanceof Car) {
            carriedCars.add((Car)car);
        }
        System.out.println("Can only add cars.");
    }

    public void unloadVehicle(){
        if(getBedAccessible(BedOwner.getCurrentSpeed(), isRaised)==false){
            return;
        }
        Car car = carriedCars.get(carriedCars.size()-1);

        //The distance between the truck and the car will be 1 unit at dropoff
        //Is this math correct?
        double direction = BedOwner.getDirection();
        double newYcord = BedOwner.getXcord()-1*Math.cos(Math.toRadians(direction));
        double newXcord = BedOwner.getYcord()-1*Math.sin(Math.toRadians(direction));

        System.out.println("newXcord is " + newXcord);
        System.out.println("newYcord is " + newYcord);
        car.setPositionDuringTransport(newXcord, newYcord);
        car.dropOffTransport();
        carriedCars.remove(carriedCars.size()-1);
    }
}