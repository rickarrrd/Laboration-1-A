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
    }

    public double getSpeedFactor(){
        return (this.getEnginePower()*0.01);
    }



    
}
