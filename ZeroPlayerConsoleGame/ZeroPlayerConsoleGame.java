
public class ZeroPlayerConsoleGame
{
    final static int N =10;
    final static int M=20;
    
    public static void main(String[] args)
    {
	  /* 150119055 Mustafa Tunahan BA?

	  I acknowledge that I will not share my work (not even a part of it) with my friends; I will be responsible 
	  for what has been submitted. In case of any form of copying and cheating on solutions, I know that I will 
	  get ZERO on all homework and quizzes of the course!

	  */
	  
	  startGame(generatePlayers());
	  
    }
    

    public static int[][] generatePlayers()
    {
        
        int[][] players  = new int[10][];
    
        for(int i=0;i<10;i++)
        {
            for(int pos=0;pos<2;pos++)
            {
                players[i][pos]=(int)(Math.random()*M);
            }
	}
    
        return players;
    }

    public static void startGame(int[][] players)
    {
        int player = (int)(Math.random()*players.length);
        int[] caughtList = new int[] {player};
        System.out.println("#Selected: Player" + player +" (" + players[player][0] + "," + players[player][1] + ")");
    
        double closestDistance=Integer.MAX_VALUE;
        int catchindex=0;
        
        while(true)
	{
	    for(int i=0;i<players.length;i++)
            {
		boolean check=true;
		for(int x=0;x<caughtList.length;x++)
		{
                    if(caughtList[x]==i)
                    {
			check=false;
			break;
                    }
		}
            
            
                if(check==true)
                {
                    double temp = distance(players[player][0],players[player][1],players[i][0],players[i][1]);
                    if(temp<closestDistance)
                    {
                        closestDistance=temp;
                        catchindex=i;
                    }
					     
                }
            }
            
            System.out.println(">Catch: Player" + catchindex + " (" + players[catchindex][0] + "," + players[catchindex][1] + ")" + "Distance = " + closestDistance);

            if (caughtList.length == N)
                break;
	}
    }

    public static double distance(int x1, int y1, int x2, int y2)
    {
        int temp = ((x2-x1)*(x2-x1) + (y2-y1)*(y2-y1));
    
        return Math.sqrt(temp);
    }
}