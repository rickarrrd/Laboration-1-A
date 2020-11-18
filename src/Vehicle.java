
import java.util.Vector;

public abstract class Vehicle implements Movable, IStructureWithCarrierBed{
   
    private double enginePower; // Engine power of the car
    /**
     * The current speed of the car.
     */

    private boolean isRegularSized;
    private double currentSpeed; // The current speed of the car
    /**
     * Color of the  car.
     */
    private int direction=0; //the angle of the car. direction=0 is along the y-axis and
    /**
     * Specifies the x coordinate of the position of the car.
     */
    private double xcord=0;
    /**
     * Specifies the y coordinate of the position of the car.
     */
    private double ycord=0;
    /**
     * Specifies the model name of the car.
     */

    /**
     * wheter or not the veichle is currently being transported.
     */
    private boolean beingTransported=false;


    private String modelName; // The car model name
   
  //Måste vi inte sätta this.xcord=xcord???
    public Vehicle(String modelName, double enginePower, boolean isRegularSized){
        this.modelName=modelName;
        setEnginePower(enginePower);
        this.isRegularSized=isRegularSized;
    }

    public boolean getBeingTransported(){
        return beingTransported;
    }

    public boolean getRegularSize(){
        return isRegularSized;
    }

    public void setBeingTransported(boolean beingTransported){
        this.beingTransported=beingTransported;
    }

    public double getXcord(){
        return xcord;
    }

    public double getYcord(){
        return ycord;
    }

    public double getDirection(){
        return direction;
    }

    public void setCurrentlyTransported(){
        beingTransported=true;
    }
    public void dropOffTransport(){
        beingTransported=false;
    }

    public void setPositionDuringTransport(double xcord, double ycord){
        if(beingTransported=false){
            System.out.println("The veicle must be in transport in order to set its position");
            return;
        }
        System.out.println("newXcord is " + xcord);
        System.out.println("newYcord is " + ycord);
        this.xcord=xcord;
        this.ycord=ycord;
    }

    /**
     * move moves the object by the distance currentSpeed in the direction of direction
     */
    public void move(){
        if(beingTransported==true){
            System.out.println("Cannot move during transport");
            return;
        }
        xcord = xcord + Math.sin(Math.toRadians(direction))*currentSpeed;
        ycord = ycord + Math.cos(Math.toRadians(direction))*currentSpeed;
    }
    /**
     * Turns direction 90 degrees counter clockwise
     */
    public void turnLeft(){
        if(beingTransported==true){
            System.out.println("Cannot turn during transport");
            return;
        }
        direction = (direction+270) % 360;
    }

    /**
     * Turns direction 90 degrees clockwise
     */
    public void turnRight(){
        if(beingTransported==true){
            System.out.println("Cannot turn during transport");
            return;
        }
        direction = (direction+90)%360;
    }

    /**
     * Private setter for constructor with conditions for the set value
     * @param enginePower
     */
    private void setEnginePower(double enginePower){
        this.enginePower=enginePower;
        if(enginePower<0){
            this.enginePower=0;
        }
    }
   
    /**
     * double representing engine power in fake units
     * @return enginePower
     */
    public double getEnginePower(){
        return enginePower;
    }

    /**
     * current speed in fake units
     * @return currentSpeed
     */
    public double getCurrentSpeed(){
        return currentSpeed;
    }

    /**
     * Set currentSpeed to default starting value
     */
    public void startEngine(){
        if(beingTransported==true){
            System.out.println("Cannot start engine during transport");
            return;
        }
        currentSpeed = 0.1;
    }
    /**
     * Set currentSpeed to zero.
     */
    public void stopEngine(){
	    currentSpeed = 0;
    }

    public abstract double getSpeedFactor();
    /**
     * Increments the currentSpeed by adding amount multiplied by speedFactor.
    * @param amount Specifies amount of which to increment speed.
     */
    public void incrementSpeed(double amount){
        if(beingTransported==true){
            System.out.println("Cannot drive during transport");
            return;
        }

        double newSpeed= Math.min(getCurrentSpeed() + getSpeedFactor() * amount,getEnginePower());
        currentSpeed=newSpeed;
    }

    /**
     * Decreases the currentSpeed by subtracting amount multiplied by speedFactor.
     * @param amount Specifies amount of which to decrement speed.
     */
    public void decrementSpeed(double amount){
        double newSpeed= Math.min(getCurrentSpeed() - getSpeedFactor() * amount,0);
        currentSpeed=newSpeed;
    }

    /**
     * Calls incrementSpeed(amount) if amount is between 0 and 1. Otherwise printing error message.
     * @param amount Specifies amount of which to increment speed.
     */
    public void gas(double amount){
        if(beingTransported==true){
            System.out.println("Cannot drive during transport");
            return;
        }
        else if(amount>1.0 || amount<0.0) {
            System.out.println(amount + " was an invalid input since the input has to be a double between 0 and 1");
            return;
        }
        incrementSpeed(amount);
    }


    /**
     * Calls decrementSpeed(amount) if amount is between 0 and 1. Otherwise printing error message.
     * @param amount Specifies amount of which to decrement speed.
     */
    public void brake(double amount){
        if(amount>1.0 || amount<0.0) {
            System.out.println(amount + " was an invalid input since the input has to be a double between 0 and 1");
            return;
        }
        decrementSpeed(amount);
    }
}
