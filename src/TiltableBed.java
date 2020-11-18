public class TiltableBed extends TruckBed{

    private double angle;
    private Scania bedOwner;
    public TiltableBed(Scania bedOwner) {
        this.angle=0;
        this.bedOwner=bedOwner;
    }

    public void setTilt(double amount){
        if(amount>70 || amount<0){
            System.out.println("Tilt can only be between 0 and 70 degrees");
            return;
        }
        if(bedOwner.getCurrentSpeed()>0.01 && amount >0.01){
            System.out.println("Tilt angle grater than 0 may only be set if the car is stationary.");
            return;
        }
        angle=amount;
    }

    public double getAngle(){
        return angle;
    }


}