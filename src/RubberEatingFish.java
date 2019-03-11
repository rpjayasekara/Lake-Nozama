import java.util.Random;

public class RubberEatingFish extends Fish
{
    private int xPosition;
    private int yPosition;
    public RubberEatingFish()
    {
        Random random=new Random();
        xPosition=random.nextInt(10);
        yPosition=random.nextInt(10);
    }
    @Override
    public void fishBehaviour(Warrior[] warriors,int i)
    {
        if(warriors[i].swimfins[1]!=null)
        {
            System.out.println("--------------------------------\n"+warriors[i].getName()+" lost a swimfin");
            warriors[i].setHasSwimfins(false);
            warriors[i].swimfins[1]=null;
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
