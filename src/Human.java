import java.util.Observable;
import java.util.Observer;

public abstract class Human extends Observable implements Observer
{
    abstract public void eat();
    abstract public void sleep();
    abstract public void swim(GridLocation[][] gridLocations);
}
