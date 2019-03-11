import java.util.Random;

public class LotusFlower implements GridItem
{
    private int noOfpetals;
    private int xPosition;
    private int yPosition;
    public LotusFlower()
    {
        noOfpetals=100;
        Random random=new Random();
        xPosition=random.nextInt(10);
        yPosition=random.nextInt(10);
    }
    public void allowsToPluck()
    {
        noOfpetals--;
    }
    @Override
    public int getX() {
        return xPosition;
    }

    @Override
    public int getY() {
        return yPosition;
    }
}
