public class Ferry extends Vehicle implements IHasInventory{

    private CarInventory carInventory;
    private double speedFactor;
    private boolean firstInFirstOut= true;
    private int loadableMaxAmount;

    public Ferry(){
        super("Ferry",200,false,false);
        speedFactor=1;
        loadableMaxAmount=100;
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


}
