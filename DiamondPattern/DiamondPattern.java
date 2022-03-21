import java.util.Scanner;

public class DiamondPattern
{
    /*
    Name:Mustafa Tunahan BAŞ
    ID:150199055

    This program takes a letter input from the user and prints the alphabet
    from A to the input letter in a diamond shaped pattern
    */
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        String letter = scan.nextLine();
        if(letter.length()!=1)
            System.out.println("Invalid Input!");
        //Just an ordinary input control
        else
        {
           char temp = letter.toCharArray()[0];
           char[][] tempDiamond = constructDiamond(temp);

          if(tempDiamond==null)
              System.out.println("Invalid Input");
          //Another control
          else
          {
      	  System.out.println();
      	  System.out.println();
      	  //Just shifting down the cursor a little so that the diamond will not touch the input line
              printDiamond(tempDiamond);
          }
        }
    }

    public static char[][] constructDiamond(char letter)
    {
	  char placeHolder = '.';
       int order = GetOrder(letter);
       if(order==-1)
        return null;

       char[][] shape = new char[(2*order)+1][(2*order)+1];

        int letters=1;
        int rows=0;
        int spaceCount,letterCount,gap,counter;
        boolean halfRows = false;

        while(letters!=0)
        {
                spaceCount=order-GetOrder((char) (64+letters));
                letterCount= (GetOrder((char)(64+letters))==0)? 1 :2;
                gap = (2*order+1) - letterCount-(2*spaceCount);
                //Calculating the space counts and letter counts
                counter=0;
            for(int spaceCounter=0;spaceCounter<spaceCount;spaceCounter++)
            {
                shape[rows][counter] = placeHolder;
                counter++;
            }
            //Printing(passing the chars to the array) first spaces

            shape[rows][counter] = (char) (64+letters);
            counter++;
            //Printing the first letter
            for(int spaceCounter=0;spaceCounter<gap;spaceCounter++)
            {
                shape[rows][counter] = placeHolder;
                counter++;
            }
            //Printing the gaps(spaces) between letters on same rows if the letter is not A
            if(letterCount==2)
            {
                shape[rows][counter]=(char) (64+letters);
                counter++;
            }
            //Printing the second letter on a row is it exists(if it's not 'A')
            for(int spaceCounter=0;spaceCounter<spaceCount;spaceCounter++)
            {
                shape[rows][counter] = placeHolder;
                counter++;
            }
            //Same code as the one above,it would be awesome if I had a local function(method inside method)
            if(letters==order+1)
                halfRows=true;
            //Checking if the destination letter (input letter) is reached and if so check boolean will be assigned true.
            if(halfRows)
                letters--;
            else
                letters++;
            /*
            If the destination letter is not reached,letters will increment by 1
            and if the destination letter is reached then letters will decrease by 1
            So that letters on each row will be printed right,and
            the while loop will be able to end which is the primary purpose of the
            algorithm.
             */

            rows++;
        }

       return shape;
    }
    public static void printDiamond(char[][] diamond)
    {
        for(int i=0;i<diamond.length;i++)
        {
            System.out.println(diamond[i]);
            /*
            The point is to realize that a 2 dimensional char array is actually
            an array of char arrays,and a char array is simply a String,
            so each time the loop iterates another line will be printed.
            The best benefits of doing this way are avoiding nested for loops
            which means avoiding more lines and avoiding the use of '\n' character
            which will only confuse.
             */
        }
    }
    public static int GetOrder(char letter)
    {
        if(letter>=97 && letter<=122)
            letter-=32;
        else if(letter>=65 && letter<=90)
        {

        }
        else
            return -1;// invalid letter

        return letter-65;

        /*
        This method determines the distance between a letter and letter 'A'
        If parameter letter is not a capital letter,it will be first converted to its capital equivalent
        If parameter is not an English letter,then it will return -1
         */
    }
}
