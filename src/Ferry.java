import java.util.ArrayList;

public class Ferry extends Vehicle implements IHasInventory{

    private CarInventory carInventory;
    private double speedFactor;
    private boolean firstInFirstOut= true;
    private int loadableMaxAmount;

    public Ferry(){
        super("Ferry",200,false,false);
        loadableMaxAmount=100;
        this.carInventory=new CarInventory(this, loadableMaxAmount);
        speedFactor=1;
    }

    public void load(ILoadable ILoadable){
        if(ILoadable.getTruckSized() || ILoadable.getCarSized() || isReadyToBeLoaded()){
            carInventory.load(ILoadable);
        }
    }

    public void unload(ILoadable ILoadable){
        carInventory.unload(firstInFirstOut);
    }

    public double getSpeedFactor(){
        return speedFactor;
    }

    public ArrayList<ILoadable> getCarriedCars(){
        return carInventory.getCarriedTransportables();
    }

    public void lowerRamp(){
        carInventory.lowerRamp();
    }


}
