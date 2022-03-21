package sudoku.com;


public class SudokuChecker
{

    public static void main(String[] args)
    {
	int[][] sudoku = {
                    {5, 3, 4, 6, 7, 8, 9, 1, 2},
                    {6, 7, 2, 1, 9, 5, 3, 4, 8},
                    {1, 9, 8, 3, 4, 2, 5, 6, 7},
                    {8, 5, 9, 7, 6, 1, 4, 2, 3},
                    {4, 2, 6, 8, 5, 3, 7, 9, 1},
                    {7, 1, 3, 9, 2, 4, 8, 5, 6},
                    {9, 6, 1, 5, 3, 7, 2, 8, 4},
                    {2, 8, 7, 4, 1, 9, 6, 3, 5},
                    {3, 4, 5, 2, 8, 6, 1, 7, 9}};
	  
	 
	boolean IsCorrect= Sudoku(sudoku);
	  
	if (IsCorrect)
	{
            System.out.print("Congrats,you have solved that sudoku puzzle 100 per cent correctly");
	}
	else
	{
            System.out.print("Wrongly Solved Sudooku!");
	}
	  
    }
    
    
    static boolean Controller(int[] box)
    {
 	boolean returnvalue=true;
	int[] temp = {0,0,0,0,0,0,0,0,0};
	for (int i : box)
	{				
            switch (i)
            {
		case 1:
		    temp[0]++;
		    break;
		case 2:
		    temp[1]++;
		    break;
		case 3:
		    temp[2]++;
		    break;
		case 4:
		    temp[3]++;
		    break;
		case 5:
		    temp[4]++;
		    break;
		case 6:
		    temp[5]++;
		    break;
		case 7:
		    temp[6]++;
		    break;
		case 8:
		    temp[7]++;
		    break;
		case 9:
		    temp[8]++;
		    break;
		default:
                    return false;
            }
	}
	 
	for (int i = 0; i < temp.length; i++)
	{
            if(temp[i]!=1)
            {
		returnvalue=false;
            }		
	}
	if(returnvalue)
	    return true;
	else 
	    return false;
    }

    static boolean Sudoku(int[][] sudoku)
    {
	  
	for (int i = 0; i < sudoku.length; i++)
        {
            for (int j = 0; j < sudoku.length; j++)
            {
		if(i%3==0 && j%3==0)
		{
                    int[] temp =  new int[9];
                    int counter =0;
                    for (int j2 = 0; j2 <= 2; j2++)
                    {
			for (int k = 0; k <= 2; k++)
			{
                            temp[counter] = sudoku[i+j2][j+k];
                            counter++;
			}
                    }
                    if(Controller(temp)==false)
			return false;
		}
            }
	}
	  
	for (int i = 0; i < sudoku.length; i++)
	{
            int[] temp = new int[9];
		    
            for (int j = 0; j < sudoku.length; j++)
            {
		temp[j] = sudoku[i][j];				
            }
            if(Controller(temp)==false)
		return false;
	}
	  
	for (int i = 0; i < sudoku.length; i++)
	{
            int[] temp = new int[9];
		    
            for (int j = 0; j < sudoku.length; j++)
            {
		temp[j]=sudoku[j][i];	
            }
            if(Controller(temp)==false)
		return false;
	}
	  
	return true;
    }
}