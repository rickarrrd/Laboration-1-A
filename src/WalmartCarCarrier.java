import java.awt.*;
import java.util.ArrayList;

public class WalmartCarCarrier extends Car{

    private int carsMaxAmount;


    /**
     * Creates the carrier bed of the truck
     */
    private CarInventory carInventory;

    private boolean bedRaised = true;

    /**
     * Sets parameters of the truck
     */
    public WalmartCarCarrier(){
        super(
                false,
                 Color.white,
                600,
                2,
                "Truck"
        );
        this.carsMaxAmount=6;
        this.carInventory = new CarInventory(this, carsMaxAmount);
    }

    /**
     * Returns the speedfactor of the truck
     * @return speedfactor the acceleration of the truck
     */
    public double getSpeedFactor(){
        return (getEnginePower()*0.01);
    }

    public boolean isReadyToBeLoaded(){
        if(getCurrentSpeed()>0.01){
            return false;
        }
        return true;
    }

    /**
     * Raise the ramp of the truck
     */
    public void raiseRamp(){
        carInventory.raiseRamp();
    }
    /**
     * Lower the ramp of the truck
     */
    public void lowerRamp(){
        carInventory.lowerRamp();
    }

    /**
     * Load a car unto the truck
     * @param car the car to be loaded
     */
    public void load(Loadable loadable){
        carInventory.load(loadable);
    }

    /**
     * Unload a car from the truck
     */
    public void unloadCar(){
        carInventory.unloadVehicle();
    }

    /**
     * @return all the cars currenly being transported
     */
    public ArrayList<Loadable> getCarriedCars(){
        return carInventory.getCarriedLoadables();
    }
    
}
