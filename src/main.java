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

        ferry.load(volvo240);
        System.out.println(ferry.getCarriedCars());
    }
}
