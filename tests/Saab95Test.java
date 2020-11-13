import org.junit.Test;

import static org.junit.Assert.*;

public class Saab95Test {

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
    }

    @Test
    public void decrementSpeed() {
    }
}