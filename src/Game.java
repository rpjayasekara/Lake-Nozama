import java.io.*;
import java.util.ArrayList;

public class Game
{
    private FileWriter writer;
    private double time1;
    private double time2;
    private double time3;
    private double time4;
    private Warrior winner;
    private ArrayList<GridItem> gameCharacters; // to keep track on all game characters
    private Grid grid;
    private Warrior[] warriors; //to keep track on warriors
    private Fish[] fish; // to keep track on fish
    private LotusFlower[] lotusFlowers; //to keep track on lotus flowers
    private Treasure treasure; //to keep a reference to the Treasure
    private Thread warrior1;
    private Thread warrior2;
    private Thread warrior3;
    private Thread warrior4;
    public Game() throws IOException {
        writer= new FileWriter("results.txt",true);
        gameCharacters=new ArrayList<GridItem>();
        grid=new Grid();
        warriors=new Warrior[4];
        warriors[0]=new Warrior("Flash");
        warriors[1]=new Warrior("AquaMan");
        warriors[2]=new SuperWarrior("WonderWoman");
        warriors[3]=new SuperWarrior("BatMan");
        warriors[0].addObserver(warriors[1]);
        warriors[0].addObserver(warriors[2]);
        warriors[0].addObserver(warriors[3]);
        warriors[1].addObserver(warriors[0]);
        warriors[1].addObserver(warriors[2]);
        warriors[1].addObserver(warriors[3]);
        warriors[2].addObserver(warriors[0]);
        warriors[2].addObserver(warriors[1]);
        warriors[2].addObserver(warriors[3]);
        warriors[3].addObserver(warriors[0]);
        warriors[3].addObserver(warriors[1]);
        warriors[3].addObserver(warriors[2]);
        for(int i=0;i<4;i++)
        {
            grid.gridLocations[warriors[i].getX()][warriors[i].getY()].setItem(warriors[i]); // set the warriors to appropriate Grid location
            gameCharacters.add(warriors[i]);
        }
        fish=new Fish[6];
        fish[0]=new KillerFish();
        fish[1]=new KillerFish();
        fish[2]=new RubberEatingFish();
        fish[3]=new RubberEatingFish();
        fish[4]=new InnocentFish();
        fish[5]=new InnocentFish();
        for(int i=0;i<6;i++)
        {
            //System.out.println(fish[i].getX()+" "+fish[i].getY());
            grid.gridLocations[fish[i].getX()][fish[i].getY()].setItem(fish[i]); // set the fish to appropriate grid location
            gameCharacters.add(fish[i]);
        }
        lotusFlowers=new LotusFlower[5];
        for(int i=0;i<5;i++)
        {
            lotusFlowers[i]=new LotusFlower();
            grid.gridLocations[lotusFlowers[i].getX()][lotusFlowers[i].getY()].setItem(lotusFlowers[i]);
            gameCharacters.add(lotusFlowers[i]);
        }
        treasure=new Treasure();
        grid.gridLocations[treasure.getX()][treasure.getY()].setItem(treasure);

    }
    public void play() throws InterruptedException, IOException {
        System.out.println("-------WARRIOR GAME-------");
        warrior1=new Thread(new Runnable() {
            @Override
            public void run()
            {
                double start=System.currentTimeMillis();
                try
                {
                    while (true&&warriors[0].gethasSwimfin())
                    {
                        if (warriors[0].getGameover())
                        {
                            break;
                        }
                        try
                        {
                            Thread.sleep(1);
                        } catch (InterruptedException e)
                        {
                            e.printStackTrace();
                        }
                        synchronized (grid.gridLocations[warriors[0].getX()][warriors[0].getY()])
                        {
                            warriors[0].swim(grid.gridLocations);
                            if (grid.gridLocations[warriors[0].getX()][warriors[0].getY()].checkFish()) {
                                //System.out.println("fish availble");
                                grid.gridLocations[warriors[0].getX()][warriors[0].getY()].getFish().fishBehaviour(warriors, 0);
                            }
                        }
                        if(warriors[0].win)
                        {
                            //System.out.println("won!!!!!!!!");
                            winner=warriors[0];
                        }

                    }
                }catch (NullPointerException e)
                {

                }
                try {
                    double end = System.currentTimeMillis();
                    time1 = end - start;
                    warriors[0].setTime(time1);
                }catch (NullPointerException e)
                {

                }
            }
        });
        warrior1.start();
        warrior2=new Thread(new Runnable() {
            @Override
            public void run()
            {
                double start=System.currentTimeMillis();
                try
                {
                    while (true&&warriors[1].gethasSwimfin()) {
                        if (warriors[0].getGameover())
                        {
                            break;
                        }
                        try
                        {
                            Thread.sleep(1);
                        } catch (InterruptedException e)
                        {
                            e.printStackTrace();
                        }
                        synchronized (grid.gridLocations[warriors[1].getX()][warriors[1].getY()])
                        {
                            warriors[1].swim(grid.gridLocations);
                            if (grid.gridLocations[warriors[1].getX()][warriors[1].getY()].checkFish()) {
                                if (warriors[0].getGameover()) {
                                    break;
                                }
                                //System.out.println("fish availble");
                                grid.gridLocations[warriors[1].getX()][warriors[1].getY()].getFish().fishBehaviour(warriors, 1);
                            }
                        }
                        if(warriors[1].win)
                        {
                            //System.out.println("won!!!!!!!!");
                            winner=warriors[1];
                        }
                    }
                }catch (NullPointerException e)
                {

                }
                try {
                    double end = System.currentTimeMillis();
                    time2 = end - start;
                    warriors[1].setTime(time2);
                }catch (NullPointerException e)
                {

                }
            }
        });
        warrior2.start();
        warrior3=new Thread(new Runnable() {
            @Override
            public void run()
            {
               // System.out.println("Hey i am warrior 3");
                double start=System.currentTimeMillis();
                try
                {
                    while (true&&warriors[2].gethasSwimfin())
                    {
                        if (warriors[2].getGameover())
                        {
                            break;
                        }
                        try
                        {
                            Thread.sleep(1);
                        } catch (InterruptedException e)
                        {
                            e.printStackTrace();
                        }
                        synchronized (grid.gridLocations[warriors[2].getX()][warriors[2].getY()])
                        {
                            warriors[2].swim(grid.gridLocations);
                            if (grid.gridLocations[warriors[2].getX()][warriors[2].getY()].checkFish()) {
                                //System.out.println("fish availble");
                                grid.gridLocations[warriors[2].getX()][warriors[2].getY()].getFish().fishBehaviour(warriors, 2);
                            }
                        }
                        if(warriors[2].win)
                        {
                            //System.out.println("won!!!!!!!!");
                            winner=warriors[2];
                        }

                    }
                }catch (NullPointerException e)
                {

                }
                try {
                    double end = System.currentTimeMillis();
                    time3 = end - start;
                    warriors[2].setTime(time3);
                }catch (NullPointerException e)
                {

                }
            }
        });
        warrior3.start();
        warrior4=new Thread(new Runnable() {
            @Override
            public void run()
            {
                double start=System.currentTimeMillis();
                //System.out.println("Hey i am warrior 4");
                try
                {
                    while (true&&warriors[3].gethasSwimfin())
                    {
                        if (warriors[3].getGameover())
                        {
                            break;
                        }
                        try
                        {
                            Thread.sleep(1);
                        } catch (InterruptedException e)
                        {
                            e.printStackTrace();
                        }
                        synchronized (grid.gridLocations[warriors[3].getX()][warriors[3].getY()])
                        {
                            warriors[3].swim(grid.gridLocations);
                            if (grid.gridLocations[warriors[3].getX()][warriors[3].getY()].checkFish()) {
                                //System.out.println("fish availble");
                                grid.gridLocations[warriors[3].getX()][warriors[3].getY()].getFish().fishBehaviour(warriors, 3);
                            }
                        }
                        if(warriors[3].win)
                        {
                            //System.out.println("won!!!!!!!!");
                            winner=warriors[3];
                        }

                    }
                }catch (NullPointerException e)
                {

                }
                try {
                    double end = System.currentTimeMillis();
                    time4 = end - start;
                    warriors[3].setTime(time4);
                }catch (NullPointerException e)
                {

                }
            }
        });
        warrior4.start();
        warrior1.join();
        warrior2.join();
        warrior3.join();
        warrior4.join();
        if(winner instanceof Warrior)
        {

            System.out.println("_______GAME OVER_______");
            System.out.println("WINNER IS "+winner.getName());
            System.out.println("Time elapsed "+winner.getTime()+"ms");
            writer.write("The winner is "+winner.getName()+" time elapsed "+winner.getTime()+"ms"+"\n");
            writer.write(System.getProperty( "line.separator" ));
            writer.close();
        }else{
            System.out.println("_______GAME OVER_______");
            System.out.println("NO ONE WON");
            writer.write("No one won \n");
            writer.write(System.getProperty( "line.separator" ));
            writer.close();
        }
    }


}
