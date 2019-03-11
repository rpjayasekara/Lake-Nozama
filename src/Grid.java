public class Grid
{
    GridLocation[][] gridLocations;
    public Grid()
    {
        gridLocations=new GridLocation[11][11];
        for(int i=0;i<gridLocations.length;i++)
        {
            for(int j=0;j<gridLocations[i].length;j++)
            {
                gridLocations[i][j]=new GridLocation();
            }
        }

    }
}
