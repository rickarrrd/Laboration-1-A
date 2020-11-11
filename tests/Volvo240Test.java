import org.junit.Test;

import static org.junit.Assert.*;

public class Volvo240Test {

    @Test
    public void speedFactor(){
        Volvo240 volvo240test = new Volvo240();
        assertEquals(1.25, volvo240test.speedFactor(), 0.01);
    }
}