public class TiltableBed extends TruckBed{

    private double angle;

    public TiltableBed(){
        this.angle=0;
    }

    public void setTilt(double amount){
        if(amount>70 || amount<0){
            System.out.println("Tilt can only be between 0 and 70 degrees");
            return;
        }
        angle=amount;
    }

    public double getAngle(){
        return angle;
    }
    
}