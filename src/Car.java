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
    private Color color; // Color of the car
    /**
     * Direction of the car. Direction =0 points the car along positive y-axis.
    */
    /**
     * wheter or not the veichle is currently being transported. 
     */
    private boolean beingTransported=false;

    /**
     * wheter the car is a regular sized car or not.
     */
    private boolean isRegularSized;
    /**
     *
     * @param color Color of car.
     * @param enginePower Specifies engine power.
     * @param nrDoors Number of doors on car.
     * @param ModelName Model name of the car.
     */
    public Car(boolean isRegularSized, Color color, int nrDoors){
        this.isRegularSized=isRegularSized;
        this.color=color;
        setDoors(nrDoors);
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
     * int representing number of doors
     * @return nrDoors
     */
    public int getNrDoors(){
        return nrDoors;
    }
/**
 * set the car to be under transport 
 */
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
        this.xcord=xcord;
        this.ycord=ycord;
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
}