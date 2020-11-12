import javafx.util.Pair;
import org.junit.Test;

import static org.junit.Assert.*;

public class Volvo240Test {
    double delta=0.01;
    double engineOffSpeed=0; //Newly created volvo currently starts with engine off speed, ie currentSpeed=0
    double startEngineSpeed=0.1;
    double trimFactor = 1.25;
    double enginePower= 100;
    double incrementTestAmount=0.5;
    @Test
    public void getSpeedFactor(){
        Volvo240 volvo240test = new Volvo240();
        assertEquals(trimFactor*enginePower*0.01, volvo240test.getSpeedFactor(), delta);
    }
    @Test
    public void getCurrentSpeed(){
        Volvo240 volvo240test = new Volvo240();
        assertEquals(engineOffSpeed, volvo240test.getCurrentSpeed(), delta);

        volvo240test.startEngine();
        assertEquals(startEngineSpeed,volvo240test.getCurrentSpeed(),delta);

        volvo240test.incrementSpeed(incrementTestAmount);
        assertEquals(trimFactor*incrementTestAmount+startEngineSpeed,volvo240test.getCurrentSpeed(),delta);

    }
    @Test
    public void incrementSpeed(){
        Volvo240 volvo240test = new Volvo240();

        volvo240test.incrementSpeed(incrementTestAmount);
        assertEquals(engineOffSpeed + volvo240test.getSpeedFactor()*incrementTestAmount,
                     volvo240test.getCurrentSpeed(),delta);

        volvo240test.incrementSpeed(enginePower);
        assertEquals(100, volvo240test.getCurrentSpeed(),delta);

    }
    @Test
    public void decrementSpeed(){
        Volvo240 volvo240test = new Volvo240();

        volvo240test.decrementSpeed(incrementTestAmount);
        assertEquals(-0.625,volvo240test.getCurrentSpeed(),delta);
    }
    @Test
    public void move(){
        Volvo240 volvo240test = new Volvo240();

        volvo240test.move();
        assertEquals(0.0,volvo240test.getPosition().getKey());
        assertEquals(0.0,volvo240test.getPosition().getValue());

        volvo240test.incrementSpeed(1);
        volvo240test.move();
        assertEquals(0.0,volvo240test.getPosition().getKey());
        assertEquals(1.25,volvo240test.getPosition().getValue());

        volvo240test.turnRight();
        volvo240test.move();
        assertEquals(1.25,volvo240test.getPosition().getKey());
        assertEquals(1.25,volvo240test.getPosition().getValue());

        volvo240test.turnLeft();
        volvo240test.move();
        assertEquals(1.25,volvo240test.getPosition().getKey());
        assertEquals(2.5,volvo240test.getPosition().getValue());
    }

    @Test
    public void getNrDoors(){
        Volvo240 volvo240test = new Volvo240();
        assertEquals(4,volvo240test.getNrDoors());
    }
}