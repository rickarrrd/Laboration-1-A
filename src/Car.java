import java.awt.Color;
import java.lang.*;

/**
 * Abstract class Car is a template for any car model
 */
public abstract class Car extends Vehicle implements Movable{
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
     * wheter the car is a regular sized car or not.
     */

    public abstract double getSpeedFactor();

    /**
     *
     * @param color Color of car.
     * @param enginePower Specifies engine power.
     * @param nrDoors Number of doors on car.
     * @param modelName Model name of the car.
     */

    public Car(boolean isRegularSizedCar, Color color,double enginePower, int nrDoors, String modelName){
        super(modelName,enginePower,isRegularSizedCar);
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