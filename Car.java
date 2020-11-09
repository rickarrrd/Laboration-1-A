import java.awt.Color;

public abstract class Car implements Movable{
	
    protected int nrDoors; // Number of doors on the car
    protected double enginePower; // Engine power of the car
    protected double currentSpeed; // The current speed of the car
    protected Color color; // Color of the car
    protected double direction; //the angle of the car. direction=0 is along the y-axis and
    //direction=90 is along the x-axis
    protected double xcord;
    protected double ycord;
    public String modelName; // The car model name

    public void move(){
        
    }

    public void turnLeft(){

    }
    public void turnRight(){

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
