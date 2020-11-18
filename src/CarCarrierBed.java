import java.util.ArrayList;


public class CarCarrierBed{

    private boolean isRaised;
    private int carsMaxAmount;

    private ArrayList<Car> carriedCars= new ArrayList<Car>();

    WalmartCarCarrier BedOwner;

    public CarCarrierBed(WalmartCarCarrier BedOwner,int carsMaxAmount){
        this.isRaised=false;
        this.BedOwner=BedOwner;
        setCarsMaxAmount(carsMaxAmount);
    }

    private void setCarsMaxAmount(int carsMaxAmount){
        if(carsMaxAmount<1){
            System.out.println("Capacity must exceed zero car");
            return;
        }
        this.carsMaxAmount=carsMaxAmount;
    }

    public ArrayList<Car>getCarriedCars(){
        return carriedCars;
    }

    public void raiseRamp(){
        isRaised=true;
    }

    public void lowerRamp(){
        isRaised=false;
    }

    public boolean getBedAccessible(double currentSpeed,boolean isRaised){
        if(currentSpeed > 0.01 || isRaised == true){
            System.out.println("The bed is currently not accessible");
            return false;
        }
        return true;
    }

    public void loadVehicle(Car car){

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
        carriedCars.add(car);
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