import java.awt.*;

public class Scania extends Car{

    private TiltableBed tiltableBed;

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

    public double getSpeedFactor(){
        return (this.getEnginePower()*0.01);
    }

    public void setTilt(double amount){
        tiltableBed.setTilt(amount);
    }

    public double getAngle(){
        return tiltableBed.getAngle();
    }

    @Override
    public void gas(double amount){
        if(tiltableBed.getAngle()>0.01){
            System.out.println("Gas may only be applied when bed angle is set to 0");
            return;
        }
        super.gas(amount);
    }
}
