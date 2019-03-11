import java.util.Random;

public class InnocentFish extends Fish
{
    private int xPosition;
    private int yPosition;
    public InnocentFish()
    {
        Random random=new Random();
        xPosition=random.nextInt(10);
        yPosition=random.nextInt(10);
    }
    @Override
    public void fishBehaviour(Warrior[] warriors,int i) // do nothing
    {

    }
    public int getX()
    {
        return xPosition;
    }
    public int getY()
    {
        return yPosition;
    }
}
