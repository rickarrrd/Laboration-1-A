import java.util.ArrayList;
import java.util.Arrays;

public class main {
    /**
     * Main method is used to create objects and run commands.
     * @param args
     */
    public static void main(String[] args) {
        Ferry ferry = new Ferry();
        Volvo240 volvo240 = new Volvo240();

        ferry.lowerRamp();
        ferry.load(volvo240);
        ferry.raiseRamp();

        ferry.startEngine();
        ferry.gas(0.9);
        ferry.move();
        System.out.println("Y coordinate of volvo " + volvo240.getYcord());
        ferry.move();
        System.out.println(ferry.getCarriedCars());

        ferry.stopEngine();
        ferry.lowerRamp();
        ferry.unload(volvo240);

        System.out.println("Y coordinate of volvo " + volvo240.getYcord());
    }
}
