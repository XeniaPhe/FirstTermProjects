import java.util.Scanner;

public class LuhnValidator
{

 public static void main(String[] args)
 {
     Scanner scan = new Scanner(System.in);
     String number = scan.nextLine();
     validateNumber(number);
    /*
    I actually ignored the value returned by the validateNumber() method since it
    has to return only a boolean value but not Dnumber and Lnumber values,and
    I did not want to create dNumber and lNumber strings in the scope of the class
    which is not a good practice
     */
 }

 public static boolean validateNumber(String number)
 {
     boolean returnvalue=true;
     number = RemoveSpaces(number);
     for(int ch=0;ch<number.length();ch++)
     {
        if(!isCharIntheRange(number.charAt(ch),(byte)48,(byte)57))
        {
            System.out.println("Invalid Input !");
            return false;
        }
            //the interval 48-57 represents numbers from 0 to 9 in ASCII
     }

     char[] chars = new char[number.length()];
     for(int i=0;i<number.length();i++)
         chars[i] = number.charAt(i);

     String[] temp = DandLNumbers(number);
     String numberD= temp[0];
     String numberL=temp[1];

     int sum=0;
     for(int x=0;x<numberL.length();x++)
     {
         sum += Integer.parseInt(numberL.charAt(x)+"");
     }

     if(sum%10!=0)
         returnvalue=false;

     System.out.println("DNumber:"+numberD +
                                "\n" + "LNumber:"+numberL + "\n" + ((returnvalue)? "Number is Valid" : "Number is Invalid"));
     return returnvalue;
     /*
     This method first checks if there is any invalid characters(non-numeric characters except for space)
     Then checks its validity for Luhn algorithm,prints dNumber and Lnumber to the console and returns a boolean value
      */
 }

 public static boolean isCharIntheRange(char c,byte min,byte max)
 {
     boolean returnvalue =false;
     if(c>=min && c<=max)
         returnvalue=true;

     return returnvalue;

     //This method checks if a char is in a range you want to test
 }



 public static String[] DandLNumbers(String number)
 {
     String dNumber="";
     String lNumber="";
     boolean isEven = (number.length()%2==0);
     for(int index=0;index<number.length();index++)
     {
         int doubleDigit=0;
         if((isEven && index%2==0) || (!isEven && index%2==1))
         {
             doubleDigit=Integer.parseInt(number.charAt(index)+"");
             doubleDigit=(2*doubleDigit>9) ? 2*doubleDigit-9: 2*doubleDigit;
             dNumber+= number.charAt(index);
             lNumber+=doubleDigit+"";
         }
         else
         {
             dNumber+="_";
             lNumber+=number.charAt(index);
         }
     }
     return new String[] {dNumber,lNumber};

     //This is the actual method that checks if a number is valid for Luhn algorithm
 }
 
 public static String RemoveSpaces(String str)
 {
     
	if(str!=null)
	    {
		  for(int i=0;i<str.length();i++)
			{
			    if(str.charAt(i)==' ')
				  str = str.substring(0,i) + str.substring(i+1,str.length());
			}
	    }
		       
	//This method removes spaces from a string
     return str;
 }
}
