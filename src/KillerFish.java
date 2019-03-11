import java.util.Random;

public class KillerFish extends Fish
{
    private int xPosition;
    private int yPosition;
    public KillerFish()
    {
        Random random=new Random();
        xPosition=random.nextInt(10);
        yPosition=random.nextInt(10);
    }
    @Override
    public void fishBehaviour(Warrior[] warriors,int i) //kill the warrior
    {
        if(!warriors[i].immortality)
        {
            System.out.println("--------------------------------\n"+warriors[i].getName()+" is killed by a Fish");
            warriors[i] = null;
        }
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
