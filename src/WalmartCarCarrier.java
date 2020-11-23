import java.awt.*;
import java.util.ArrayList;

public class WalmartCarCarrier extends Car{

    private int carsMaxAmount;


    /**
     * Creates the carrier bed of the truck
     */
    private CarCarrierBed carCarrierBed;

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
        this.carCarrierBed = new CarCarrierBed(this, carsMaxAmount);
    }

    /**
     * Returns the speedfactor of the truck
     * @return speedfactor the acceleration of the truck
     */
    public double getSpeedFactor(){
        return (getEnginePower()*0.01);
    }

    /**
     * Raise the ramp of the truck
     */
    public void raiseRamp(){
        carCarrierBed.raiseRamp();
    }
    /**
     * Lower the ramp of the truck
     */
    public void lowerRamp(){
        carCarrierBed.lowerRamp();
    }

    /**
     * Load a car unto the truck
     * @param car the car to be loaded
     */
    public void loadCar(Car car){
        carCarrierBed.loadVehicle(car);
    }

    /**
     * Unload a car from the truck
     */
    public void unloadCar(){
        carCarrierBed.unloadVehicle();
    }

    /**
     * @return all the cars currenly being transported
     */
    public ArrayList<Vehicle>getCarriedCars(){
        return carCarrierBed.getCarriedVehicles();
    }
    
}
