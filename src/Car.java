import javafx.util.Pair;

import java.awt.Color;
import java.lang.*;
import java.text.BreakIterator;

/**
 * Abstract class Car is a template for any car model
 */
public abstract class Car implements Movable{
    /**
     * Number of doors on the car.
     */
    protected int nrDoors; // Number of doors on the car
    /**
     * Engine power of the car.
     */
    protected double enginePower; // Engine power of the car
    /**
     * The current speed of the car.
     */
    protected double currentSpeed; // The current speed of the car
    /**
     * Color of the  car.
     */
    protected Color color; // Color of the car
    /**
     * Direction of the car. Direction =0 points the car along positive y-axis.
     */
    protected double direction=0; //the angle of the car. direction=0 is along the y-axis and
    /**
     * Specifies the x coordinate of the position of the car.
     */
    protected double xcord=0;
    /**
     * Specifies the y coordinate of the position of the car.
     */
    protected double ycord=0;
    /**
     * Specifies the model name of the car.
     */
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
     * @return positions
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
     * @param clr color of object
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
     * @param amount Specifies the amount of which to increment speed.
     */
    public abstract void incrementSpeed(double amount);

    /**
     * @param amount Specifies the amount of which to decrement speed.
     */
    public abstract void decrementSpeed(double amount);

    // TODO fix this method according to lab pm

    /**
     * Calls incrementSpeed(amount) if amount is between 0 and 1. Otherwise printing error message.
     * @param amount Specifies amount of which to increment speed.
     */
    public void gas(double amount){
        if(amount>=1.0 || amount<=0.0) {
            System.out.println(amount + " was an invalid input since the input has to be a double between 0 and 1");
            return;
        }
        incrementSpeed(amount);
    }

    // TODO fix this method according to lab pm

    /**
     * Calls decrementSpeed(amount) if amount is between 0 and 1. Otherwise printing error message.
     * @param amount Specifies amount of which to decrement speed.
     */
    public void brake(double amount){
        if(amount>=1.0 || amount<=0.0) {
            System.out.println(amount + " was an invalid input since the input has to be a double between 0 and 1");
            return;
        }
        decrementSpeed(amount);
    }

}
