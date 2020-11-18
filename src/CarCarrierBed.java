import java.util.ArrayList;


public class CarCarrierBed extends TruckBed{

    private boolean isRaised;
    private int carsMaxAmount;

    private ArrayList<Car> carriedCars= new ArrayList<Car>();


    public CarCarrierBed(int carsMaxAmount){
        this.isRaised=false;
        setCarsMaxAmount(carsMaxAmount);
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

    public boolean isLoadable(){
        if(isRaised=true){
            System.out.println("The ramp must be down in order to load cars or unload cars");
            return false;
        }
        return true;
    }

    public void loadCar(Car car){
        if(carriedCars.size()>=carsMaxAmount){
            System.out.println("The Carrier is full, cannot add another car");
            return;
        }else if(car.getRegularSize()==false){
            System.out.println("The truck is only able to transport regular sized cars");
            return;
        }else if(isLoadable()==false){
            return;
        }
        car.setBeingTransported(true);
        car.setLoadedCarPosition(xcord, ycord);
        carriedCars.add(car);
    }

    public void unloadCar(){
        if(isLoadable()=false){
            return;
        }


    }
}