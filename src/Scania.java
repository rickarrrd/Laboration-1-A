import java.awt.*;

public class Scania extends Car{

    /**
    * created the bed object
     */
    private TiltableBed tiltableBed;

    /**
     * Sets parameters for Scania
     */
    public Scania(){
        super(
                false,
                 Color.black,
                400,
                2,
                "Scania"
        );
        this.tiltableBed = new TiltableBed(this);
    }
    /**
     *
     * @return the current available acceleration
     */
    public double getSpeedFactor(){
        return (this.getEnginePower()*0.01);
    }
    /**
     * Sets the tilt of the bed.
     */
    public void setTilt(double amount){
        tiltableBed.setTilt(amount);
    }
    /**
     *
     * @return the current tilt of the bed
     */
    public double getAngle(){
        return tiltableBed.getAngle();
    }

    /**
     * Checks if the Vehicle can gas before doing so
     */

    @Override
    public void gas(double amount){
        if(InventoryHelper.gasAvailable(amount)){
            super.gas(amount);
        }
    }
}
