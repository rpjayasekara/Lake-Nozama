import java.util.ArrayList;

public class GridLocation
{
    private Warrior warrior;
    private ArrayList<Fish> fish;
    private ArrayList<LotusFlower> lotusFlowers;
    private Treasure treasure;
    public GridLocation()
    {
        fish=new ArrayList<>();
        lotusFlowers=new ArrayList<>();
    }
    public void setItem(GridItem item)
    {
        if(item instanceof Warrior)
        {
            warrior=(Warrior)item;
        }else if(item instanceof Fish)
        {
            fish.add((Fish)item);
        }else if(item instanceof LotusFlower)
        {
            lotusFlowers.add((LotusFlower)item);
        }else if(item instanceof Treasure)
        {
            treasure=(Treasure)item;
        }
    }
    public boolean checkWarrior()
    {
        if(warrior instanceof Warrior)
        {
            return true;
        }else
        {
            return false;
        }
    }
    public boolean checkFish()
    {
        if(fish.size()>0)
        {
            return true;
        }else
        {
            return false;
        }
    }
    public boolean checkLotus()
    {
        if(lotusFlowers.size()!=0)
        {
            return true;
        }else
        {
            return false;
        }
    }
    public void removeItem(GridItem item)
    {
        if(item instanceof Warrior)
        {
            warrior=null;
        }

    }
    public Warrior getWarrior()
    {
        if (warrior instanceof Warrior) {
            return warrior;
        } else {
            return null;
        }
    }
    public Fish getFish()
    {
        if (fish.size()>0) {
            return fish.get(0);
        } else {
            return null;
        }
    }
    public Treasure getTreasure()
    {
        return treasure;
    }
}
