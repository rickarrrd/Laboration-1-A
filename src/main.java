import java.util.ArrayList;
import java.util.Arrays;

public class main {
    /**
     * Main method is used to create objects and run commands.
     * @param args
     */
    public static void main(String[] args) {



        Workshop workshop1 = new Workshop(10,new ArrayList<ILoadable>(Arrays.asList(new Volvo240())),
                0, 0, 0);

        Saab95 saab95 = new Saab95();
        Volvo240 volvo240 = new Volvo240();

        workshop1.load(volvo240);
        workshop1.load(volvo240);
        //workshop1.loadVehicle(saab95);
        System.out.println(workshop1.getCarriedVehicles());
    }
}
