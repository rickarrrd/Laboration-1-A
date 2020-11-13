import java.awt.*;

/**
 * non abstract class Saab95 extends Car with added specific parameters to the car model.
 */
public class Saab95 extends Car{

    protected boolean turboOn; // Determines turbo on if true, off otherwise.

    /**
     * Sets parameters for saab95.
     */
    public Saab95(){
        super(
            Color.red,
            2,
            125,
            "Saab 95"
        );
	    turboOn = false;
        stopEngine();
    }

    /**
     * Getter for turbo status
     * @return turboOn
     */
    public boolean getTurbo(){
        return turboOn;
    }

    /**
     * Sets turboOn to true.
     */
    public void setTurboOn(){
	    turboOn = true;
    }

    /**
     * Sets turboOn to false.
     */
    public void setTurboOff(){
	    turboOn = false;
    }

    /**
     * speedFactor is one percent of enginePower multiplied by the turbo.
     * @return speedFactor
     */
    public double speedFactor(){
        double turbo = 1;
        if(turboOn) turbo = 1.3;
        return getEnginePower()* 0.01 * turbo;
    }

    /**
     * Increments the currentSpeed by adding amount multiplied by speedFactor.
     * @param amount Specifies amount of which to increment speed.
     */
    public void incrementSpeed(double amount){
        double newSpeed= Math.min(getCurrentSpeed() + speedFactor() * amount,getEnginePower());
        setCurrentSpeed(newSpeed);
    }

    /**
     * Decreases the currentSpeed by subtracting amount multiplied by speedFactor.
     * @param amount Specifies amount of which to decrement speed.
     */
    public void decrementSpeed(double amount){
        double newSpeed= Math.min(getCurrentSpeed() - speedFactor() * amount,0);
        setCurrentSpeed(newSpeed);
    }
}
