import java.util.ArrayList;


public class CarCarrierBed{

    private boolean isRaised;
    private int carsMaxAmount;

    private ArrayList<Car> carriedCars= new ArrayList<Car>();

    WalmartCarCarrier BedOwner;
    public CarCarrierBed(WalmartCarCarrier BedOwner,int carsMaxAmount){
        this.isRaised=false;
        setCarsMaxAmount(carsMaxAmount);
        this.BedOwner=BedOwner;
    }

    private void setCarsMaxAmount(int carsMaxAmount){
        if(carsMaxAmount<1){
            System.out.println("Capacity must exceed zero car");
            return;
        }
        this.carsMaxAmount=carsMaxAmount;
    }

    public void raiseRamp(){
        isRaised=true;
    }

    public void lowerRamp(){
       isRaised=false; 
    }

    public void loadVehicle(Car car){
        if(carriedCars.size()>=carsMaxAmount){
            System.out.println("The Carrier is full, cannot add another car");
            return;
        }else if(car.getRegularSize()==false){
            System.out.println("The truck is only able to transport regular sized cars");
            return;
        }else if(getBedAccessible(BedOwner.getCurrentSpeed(),isRaised)==false){
            System.out.println("Bed is currently not accessible");
            return;
        }
        car.setBeingTransported(true);
        car.setPositionDuringTransport(car.getXcord(), car.getYcord());
        carriedCars.add(car);
    }

    public ArrayList<Car>getCarriedCars(){
        return carriedCars;
    }


    public boolean getBedAccessible(double currentSpeed,boolean isRaised){
        if(currentSpeed > 0.01 || isRaised == true){
            System.out.println("The bed is currently not accessible");
            return false;
        }
        return true;
    }

    public void unloadVehicle(){
        if(getBedAccessible(BedOwner.getCurrentSpeed(), isRaised)==false){
            return;
        }
    }
}