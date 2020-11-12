import java.sql.SQLOutput;

public class main {
    /**
     * Main method is used to create objects and run commands.
     * @param args
     */
    public static void main(String[] args) {

        System.out.println("Volvo:");
        Volvo240 volvo = new Volvo240();
        System.out.println(volvo.getCurrentSpeed());
        System.out.println("X position: " + volvo.getPosition().getKey() + "  "
                         + "Y position: " + volvo.getPosition().getValue());
        volvo.incrementSpeed(5);
        volvo.move();
        System.out.println("X position: " + volvo.getPosition().getKey() + "  "
                         + "Y position: " + volvo.getPosition().getValue());
        volvo.turnLeft();
        volvo.move();
        System.out.println("X position: " + volvo.getPosition().getKey() + "  "
                         + "Y position: " + volvo.getPosition().getValue());


        System.out.println("Saab:");
        Saab95 saab = new Saab95();
        System.out.println("X position: " + saab.getPosition().getKey() + "  "
                         + "Y position: " + saab.getPosition().getValue());
        saab.incrementSpeed(2);
        saab.turnRight();
        saab.move();
        System.out.println("X position: " + saab.getPosition().getKey() + "  "
                         + "Y position: " + saab.getPosition().getValue());

    }
}
