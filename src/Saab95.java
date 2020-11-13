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
        nrDoors = 2;
        color = Color.red;
        enginePower = 125;
	    turboOn = false;
        modelName = "Saab95";
        stopEngine();
    }

    /**
     * Get turbo status.
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
        return enginePower * 0.01 * turbo;
    }

    /**
     * Increments the currentSpeed by adding amount multiplied by speedFactor.
     * @param amount Specifies amount of which to increment speed.
     */
    public void incrementSpeed(double amount){
	    currentSpeed = Math.min(getCurrentSpeed() + speedFactor() * amount,enginePower);
    }

    /**
     * Decreases the currentSpeed by subtracting amount multiplied by speedFactor.
     * @param amount Specifies amount of which to decrement speed.
     */
    public void decrementSpeed(double amount){
        currentSpeed = Math.max(getCurrentSpeed() - speedFactor() * amount,0);
    }
    
}
