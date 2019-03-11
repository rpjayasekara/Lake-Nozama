public class Treasure implements GridItem
{
    private int xPosition;
    private int yPosition;
    public Treasure()
    {
        xPosition=5;
        yPosition=5;
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
