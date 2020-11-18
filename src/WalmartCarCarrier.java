import java.awt.*;
import java.util.ArrayList;

public class WalmartCarCarrier extends Car{

    private int carsMaxAmount;

    private CarCarrierBed carCarrierBed;

    private boolean bedRaised = true;

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

    public double getSpeedFactor(){
        return (getEnginePower()*0.01);
    }

    public void raiseRamp(){
        carCarrierBed.raiseRamp();
    }
    public void lowerRamp(){
        carCarrierBed.lowerRamp();
    }
    public void loadCar(Car car){
        carCarrierBed.loadVehicle(car);
    }
    public void unloadCar(){
        carCarrierBed.unloadVehicle();
    }
    public ArrayList<Car>getCarriedCars(){
        return carCarrierBed.getCarriedCars();
    }
    
}
