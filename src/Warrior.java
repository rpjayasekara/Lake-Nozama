import java.util.Observable;
import java.util.Random;

public class Warrior extends Human implements GridItem
{
    private double time;
    public boolean win;
    private boolean hasSwimfins;
    private boolean gameOver;
    private Treasure treasure;
    private String name;
    private static int noOfWarriors=0; // to count the number of Warriors and give them an unique id
    private int id;
    private int xPosition; //current x position
    private int yPosition; //current y position
    private int direction;
    boolean immortality; //keep the state of immoratal or not
    SwimFin[] swimfins; //keep the warriors 2 swim fins
    public Warrior(String name)
    {
        win=false;
        hasSwimfins=true;
        gameOver=false;
        this.name=name;
        noOfWarriors+=1;
        id=noOfWarriors;
        swimfins=new SwimFin[2];
        swimfins[0]=new SwimFin();
        swimfins[1]=new SwimFin();
        immortality=false;
        Random random = new Random();
        int method=random.nextInt(4);//0-{0,0-10} 1-(0-10,0) 2-(10,0-10) 3-(0-10,10) Randomly gives a start position in the border of the grid.
        if(method==0)
        {
            xPosition=0;
            yPosition=random.nextInt(11);
        }else if(method==1)
        {
            xPosition=random.nextInt(11);
            yPosition=0;
        }else if(method==2)
        {
            xPosition=10;
            yPosition=random.nextInt(11);
        }else
        {
            xPosition=random.nextInt(11);
            yPosition=10;
        }

    }

    @Override
    public void eat()
    {
        System.out.println("Noraml warrior eating");
    }

    @Override
    public void sleep()
    {
        System.out.println("Noraml warrior sleeping");
    }

    public void swim(GridLocation[][] gridLocations)
    {
        if(swimfins[1]!=null)
        {
            gridLocations[xPosition][yPosition].removeItem(this); // remove the warrior from previous grid location
            Random random = new Random();
            //System.out.println(xPosition+" "+yPosition);
            while (true)
            {
                direction = random.nextInt(4);// if direction=0 up , direction=1 down , direction=2 right , direction=3 left
                if (direction == 0 && yPosition != 10) {
                    yPosition++;
                    if (gridLocations[xPosition][yPosition].checkWarrior()) {
                        yPosition--;
                        continue;
                    }
                    break;
                } else if (direction == 1 && yPosition != 0) {
                    yPosition--;
                    if (gridLocations[xPosition][yPosition].checkWarrior()) {
                        yPosition++;
                        continue;
                    }
                    break;
                } else if (direction == 2 && xPosition != 10) {
                    xPosition++;
                    if (gridLocations[xPosition][yPosition].checkWarrior()) {
                        xPosition--;
                        continue;
                    }
                    break;
                } else if (direction == 3 && xPosition != 0) {
                    xPosition--;
                    if (gridLocations[xPosition][yPosition].checkWarrior()) {
                        xPosition++;
                        continue;
                    }
                    break;
                }

            }
            System.out.println(this.name+" current location "+"("+xPosition+","+yPosition+")");
            gridLocations[xPosition][yPosition].setItem(this); // set warrior to the new grid location
            if(xPosition==5&&yPosition==5)
            {
                win=true;
                //System.out.println("-------"+this.name+" won!!!!!------");
                treasure=gridLocations[xPosition][yPosition].getTreasure();
                this.setChanged();
                this.notifyObservers();
                gameOver=true;
            }
            pluckPetal(gridLocations);

        }
    }
    public boolean getGameover()
    {
        return gameOver;
    }
    public int getX() {
        return xPosition;
    }
    public int getY() {
        return yPosition;
    }
    public int getId()
    {
        return id;
    }
    public void pluckPetal(GridLocation[][] gridLocations)
    {
        if(gridLocations[xPosition][yPosition].checkLotus())
        {
            if(!immortality)
            {
                System.out.println("--------------");
                System.out.println(this.name+" becomes immortal!!!!");
                immortality = true;
            }
        }
    }
    public String getName()
    {
        return name;
    }

    @Override
    public void update(Observable o, Object arg)
    {
        //System.out.println("notiied "+this.name);
        gameOver=true;
    }
    public boolean gethasSwimfin()
    {
        return hasSwimfins;
    }
    public void setHasSwimfins(boolean state)
    {
        this.hasSwimfins=state;
    }
    public double getTime()
    {
        return time;
    }
    public void setTime(double time)
    {
        this.time=time;
    }
}
