import org.junit.Test;

import static org.junit.Assert.*;

public class Saab95Test {
    double incrementTestHighAmount=500;
    double delta=0.01;
    double engineOffSpeed=0; //Newly created volvo currently starts with engine off speed, ie currentSpeed=0
    double startEngineSpeed=0.1;
    double enginePower= 125;
    double incrementTestAmount=0.5;
    double turboOn;
    
    @Test
    public void setTurboOn() {
        Saab95 newSaab = new Saab95();
        newSaab.setTurboOn();
        assertEquals(true, newSaab.getTurbo());
    }

    @Test
    public void setTurboOff() {
        Saab95 newSaab = new Saab95();
        newSaab.setTurboOff();
        assertEquals(false, newSaab.getTurbo());
    }

    @Test
    public void speedFactor() {
        Saab95 newSaab = new Saab95();
        assertEquals(enginePower*0.01, newSaab.speedFactor());

        newSaab.setTurboOn();
        assertEquals(enginePower*0.01*1.3, newSaab.speedFactor());
        
    }
    
    @Test
    public void getCurrentSpeed() {
        Saab95 newSaab = new Saab95();
        assertEquals(engineOffSpeed, newSaab.getCurrentSpeed());

        newSaab.startEngine();
        assertEquals(startEngineSpeed, newSaab.getCurrentSpeed());

        newSaab.incrementSpeed(incrementTestAmount);
        assertEquals(incrementTestAmount*enginePower*0.01+startEngineSpeed, newSaab.getCurrentSpeed());

        

    }

    @Test
    public void incrementSpeed() {
        Saab95Test newSaab = new Saab95();

        newSaab.incrementSpeed(incrementTestAmount);
        assertsEquals(engineOffSpeed+newSaab.speedFactor()*incrementTestAmount, newSaab.getCurrentSpeed(),delta);

        newSaab.incrementSpeed(incrementTestHighAmount);
        assertsEquals(enginePower, newSaab.getCurrentSpeed(), delta);

    }

    @Test
    public void decrementSpeed() {

        Saab95Test newSaab = new Saab95();

        newSaab.decrementSpeed(incrementTestAmount);
        assertsEquals(engineOffSpeed+newSaab.speedFactor()*incrementTestAmount, newSaab.getCurrentSpeed(),delta);
    }

    @Test
    public void gas(){ //Assuming incrementSpeed() works as intendet (earlier test)
        Saab95 newSaab = new Saab95();
        newSaab.gas(incrementTestAmount);
        double speedOfFirstIncrement=newSaab.getCurrentSpeed();
        assertEquals(newSaab.incrementSpeed(incrementTestAmount),
                speedOfFirstIncrement,delta);

        newSaab.gas(1.5);
        assertEquals(speedOfFirstIncrement,
                newSaab.getCurrentSpeed(),delta);
    }

    @Test
    public void brake(){
        Saab95 newSaab = new Saab95();

        newSaab.brake(0.5);
        double speedOfFirstDecrement=newSaab.getCurrentSpeed();
        assertEquals(speedOfFirstDecrement,Saab95.getCurrentSpeed(),delta);

        newSaab.brake(1.5);
        assertEquals(speedOfFirstDecrement,newSaab.getCurrentSpeed(),delta);
    }

}