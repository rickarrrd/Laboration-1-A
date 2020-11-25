import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class main {
    /**
     * Main method is used to create objects and run commands.
     * @param args
     */
    public static void main(String[] args) {

        Workshop<Volvo240> workshop = new Workshop<>(10, 0,0,0 );
        Volvo240 volvo240 = new Volvo240();
        Saab95 saab95 = new Saab95();
        WalmartCarCarrier walmartCarCarrier=new WalmartCarCarrier();
        workshop.load(volvo240);

        System.out.println(workshop.getCarriedCars());

    }
}
