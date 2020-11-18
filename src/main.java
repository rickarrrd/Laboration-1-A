import java.sql.SQLOutput;

public class main {
    /**
     * Main method is used to create objects and run commands.
     * @param args
     */
    public static void main(String[] args) {
        WalmartCarCarrier walmartCarCarrier = new WalmartCarCarrier();
        walmartCarCarrier.lowerRamp();

        Saab95 saab95 = new Saab95();
        walmartCarCarrier.loadCar(saab95);

        walmartCarCarrier.gas(1.0);
        walmartCarCarrier.move();
        walmartCarCarrier.brake(1);
        System.out.println("Current speed of carrier " + walmartCarCarrier.getCurrentSpeed());

        walmartCarCarrier.unloadCar();
        System.out.println("saab position after unload " + saab95.getYcord() + " " + saab95.getXcord());
    }
}
