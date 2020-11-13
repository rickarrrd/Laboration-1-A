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
    private int nrDoors; // Number of doors on the car
    /**
     * Engine power of the car.
     */
    private double enginePower; // Engine power of the car
    /**
     * The current speed of the car.
     */
    private double currentSpeed; // The current speed of the car
    /**
     * Color of the  car.
     */
    private Color color; // Color of the car
    /**
     * Direction of the car. Direction =0 points the car along positive y-axis.
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
    private String modelName; // The car model name

    /**
     *
     * @param color Color of car.
     * @param enginePower Specifies engine power.
     * @param nrDoors Number of doors on car.
     * @param ModelName Model name of the car.
     */
    public Car(Color color, double enginePower, int nrDoors, String ModelName){
        this.color=color;
        this.modelName=modelName;
        setDoors(nrDoors);
        setEnginePower(enginePower);
    }

    /**
     * Private setter for constructor with conditions for the set value
     * @param nrdoors
     */
    private void setDoors(int nrdoors){
        this.nrDoors=nrdoors;
        if(nrDoors<0){
            this.nrDoors=0;
        }
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
        direction = (direction+270) % 360;
    }

    /**
     * Turns direction 90 degrees clockwise
     */
    public void turnRight(){
        direction = (direction+90)%360;
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
     * set speed in fake units
     * @param currentSpeed
     */
    public void setCurrentSpeed(double currentSpeed){
        this.currentSpeed=currentSpeed;
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
