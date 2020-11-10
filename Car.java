import javafx.util.Pair;

import java.awt.Color;
import java.lang.*;

/**
 * Abstract class Car is a template for any car model
 */
public abstract class Car implements Movable{
	
    protected int nrDoors; // Number of doors on the car
    protected double enginePower; // Engine power of the car
    protected double currentSpeed; // The current speed of the car
    protected Color color; // Color of the car
    protected double direction=0; //the angle of the car. direction=0 is along the y-axis and
    protected double xcord=0;
    protected double ycord=0;
    public String modelName; // The car model name

    /**
     * move moves the object by the distance currentSpeed in the direction of direction
     */
    public void move(){
        xcord = xcord + Math.sin(Math.toRadians(direction))*currentSpeed;
        ycord = ycord + Math.cos(Math.toRadians(direction))*currentSpeed;
    }
    /**
     * Turns direction 90 degrees counter clockwise
     */
    public void turnLeft(){
        direction = direction-90;
    }

    /**
     * Turns direction 90 degrees clockwise
     */
    public void turnRight(){
        direction = direction+90;
    }

    /**
     * Returns Pair where getKey and getValue corresponds to x and y coordinates respectively
     */
    public Pair getPosition(){
        Pair positions= new Pair(xcord,ycord);
        return positions;
    }

    /**
     * int representing number of doors
     * @return nrDoors
     */
    public int getNrDoors(){
        return nrDoors;
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
     * color of object
     * @return color
     */
    public Color getColor(){
        return color;
    }

    /**
     * Set the color of object
     * @param clr
     */
    public void setColor(Color clr){
	    color = clr;
    }

    /**
     * Set currentSpeed to default starting value
     */
    public void startEngine(){
	    currentSpeed = 0.1;
    }

    /**
     * Set currentSpeed to zero.
     */
    public void stopEngine(){
	    currentSpeed = 0;
    }

    /**
     * Increases currentSpeed by double fed as parameter.
     * @param amount
     */
    public abstract void incrementSpeed(double amount);

    /**
     * Decreases currentSpeed by double fed as parameter.
     * @param amount
     */
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
