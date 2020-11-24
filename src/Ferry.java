public class Ferry extends Vehicle implements IHasInventory{

    private CarInventory carInventory;
    private double speedFactor;

    public Ferry(String modelName, double enginePower){
        super(modelName,enginePower,false,false);
        speedFactor=1;
    }

    public void load(Loadable loadable){
        if(loadable.getTruckSized() || loadable.getCarSized()){
            carInventory.load(loadable);
        }

    }

    public double getSpeedFactor(){
        return speedFactor;
    }




}
