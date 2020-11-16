import java.awt.*;

/**
 * non abstract class Volvo240 extends Car with added specific parameters to the car model.
 */
public class Volvo240 extends Car{

    private final static double trimFactor = 1.25; //multiplier that affects speedFactor

    /**
     * Sets parameters for Volvo240.
     */
    public Volvo240(){
        super(
            Color.black,
            100,
            4,
            "Volvo 240"
        );
        stopEngine();
    }

    /**
     * speedFactor is one percent of enginePower multiplied by the trimFactor.
     * @return speedFactor
     */
    public double getSpeedFactor(){
        return getEnginePower() * 0.01 * trimFactor;
    }

    /**
     * Increments currentSpeed by adding amount multiplied by speedFactor,
     * or sets currentSpeed to enginePower if enginePower is smaller whichever result is smaller
     * @param amount Specifies amount of which to increment speed.
     */
    public void incrementSpeed(double amount){
        double newSpeed = Math.min(getCurrentSpeed() + getSpeedFactor() * amount, getEnginePower());
        setCurrentSpeed(newSpeed);
    }

    /**
     * Decreases currentSpeed by speedFactor multiplied by amount, only if it is larger than zero.
     * If the result would be smaller than zero, currentSpeed is instead set to zero.
     * @param amount Specifies amount of which to decrement speed.
     */
    public void decrementSpeed(double amount){
        double newSpeed= Math.max(getCurrentSpeed() - getSpeedFactor() * amount,0);
        setCurrentSpeed(newSpeed);
    }
}
