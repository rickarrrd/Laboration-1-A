import java.awt.Color;
import java.lang.*;


public abstract class Car implements Movable{
	
    protected int nrDoors; // Number of doors on the car
    protected double enginePower; // Engine power of the car
    protected double currentSpeed; // The current speed of the car
    protected Color color; // Color of the car
    protected double direction=0; //the angle of the car. direction=0 is along the y-axis and
    protected double xcord=0;
    protected double ycord=0;
    public String modelName; // The car model name

    public void move(){
        xcord = xcord + Math.sin(Math.toRadians(direction))*currentSpeed;
        ycord = ycord + Math.cos(Math.toRadians(direction))*currentSpeed;
    }
    public void turnLeft(){
        direction = direction-90;
    }
    public void turnRight(){
        direction = direction+90;
    }
    public void getPosition(){
        System.out.println("x:" +  xcord + " y:" + ycord);
    }
	
    public int getNrDoors(){
        return nrDoors;
    }
    public double getEnginePower(){
        return enginePower;
    }

    public double getCurrentSpeed(){
        return currentSpeed;
    }

    public Color getColor(){
        return color;
    }

    public void setColor(Color clr){
	    color = clr;
    }

    public void startEngine(){
	    currentSpeed = 0.1;
    }

    public void stopEngine(){
	    currentSpeed = 0;
    }
    
    public abstract void incrementSpeed(double amount);

    public abstract void decrementSpeed(double amount);
    
    // TODO fix this method according to lab pm
    public void gas(double amount){
        incrementSpeed(amount);
    }

    // TODO fix this method according to lab pm
    public void brake(double amount){
        decrementSpeed(amount);
    }

}
