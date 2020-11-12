import java.awt.*;

/**
 * non abstract class Volvo240 extends Car with added specific parameters to the car model.
 */
public class Volvo240 extends Car{

    protected final static double trimFactor = 1.25; //multiplier that affects speedFactor

    /**
     * Sets parameters for Volvo240.
     */
    public Volvo240(){
        nrDoors = 4;
        color = Color.black;
        enginePower = 100;
        modelName = "Volvo240";
        stopEngine();
    }

    /**
     * speedFactor is one percent of enginePower multiplied by the trimFactor.
     * @return speedFactor
     */
    public double getSpeedFactor(){
        return enginePower * 0.01 * trimFactor;
    }

    /**
     * Increments currentSpeed by adding amount multiplied by speedFactor,
     * or sets currentSpeed to enginePower if enginePower is smaller whichever result is smaller
     * @param amount Specifies amount of which to increment speed.
     */
    public void incrementSpeed(double amount){
	    currentSpeed = Math.min(getCurrentSpeed() + getSpeedFactor() * amount,enginePower);
    }

    /**
     * Decreases currentSpeed by speedFactor multiplied by amount, only if it is larger than zero.
     * If the result would be smaller than zero, currentSpeed is instead set to zero.
     * @param amount Specifies amount of which to decrement speed.
     */
    public void decrementSpeed(double amount){
        currentSpeed = getCurrentSpeed() - getSpeedFactor() * amount;
    }


}
