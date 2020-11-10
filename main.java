public class main {
    public static void main(String[] args) {

        System.out.println("Volvo:");
        Volvo240 volvo = new Volvo240();
        System.out.println("X position: " + volvo.getPosition().getKey() + "  "
                         + "Y position: " + volvo.getPosition().getValue());
        volvo.incrementSpeed(5);
        volvo.move();
        volvo.getPosition();
        volvo.turnLeft();
        volvo.move();
        volvo.getPosition();


        System.out.println("Saab:");
        Saab95 saab = new Saab95();
        saab.getPosition();
        saab.incrementSpeed(2);
        saab.turnRight();
        saab.move();
        saab.getPosition();
        
    }
}
