import java.util.Random;

public class SuperWarrior extends Warrior
{
    private int xPosition;
    private int yPosition;
    private int direction;
    private boolean immortality;
    private SwimFin[] swimfins;
    private Binocular binocular;
    public SuperWarrior(String name)
    {
        super(name);
        binocular=new Binocular();
    }

    public void eat()
    {
        System.out.println("Super warrior eating");
    }
    public void sleep()
    {
        System.out.println("Super warrior sleeping");
    }
}
