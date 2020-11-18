import java.sql.SQLOutput;

public class main {
    /**
     * Main method is used to create objects and run commands.
     * @param args
     */
    public static void main(String[] args) {


        WalmartCarCarrier walmartCarCarrier = new WalmartCarCarrier();
        Volvo240 volvo240 = new Volvo240();
        walmartCarCarrier.lowerRamp();
        walmartCarCarrier.loadCar(volvo240);
        System.out.println(walmartCarCarrier.getCarriedCars());
        walmartCarCarrier.unloadCar();
        System.out.println(walmartCarCarrier.getCarriedCars());

    }
}
