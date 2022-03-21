import java.util.Scanner;

public class DnaComparer
{

    public static void main(String[] args)
    {
	  /* 150119055 & Mustafa Tunahan BAS

	  I acknowledge that I will not share my work (not even a part of it) with my friends; 
	  I will be responsible for what has been submitted. In case of any form of copying and cheating on solutions, 
	  I know that I will get ZERO on all homework and quizzes of the course!

	  */
	  System.out.print("Enter the first DNA strand: ");
	  Scanner scan = new Scanner(System.in);
	  
	  String dna1 =  scan.next();	 
	  //taking the input of the first DNA sample from the user
	  System.out.print("Enter the second DNA strand: ");
	  String dna2 = scan.next();
	  //taking the input of the second DNA sample from the user
	
	if(dna1.length()!=dna2.length())
	{
	    System.out.print("\nStrings should be of the same length!");
	    System.exit(0);
	}
	//Checking if DNA samples' lengths are same or not
	dna1 = dna1.toUpperCase();
	dna2 = dna2.toUpperCase();
	//Making all the characters uppercase so that there will be no mistake
	int hammingDistance=0;
	
	for(int i=0;i<dna1.length();i++)
	{
	    if(dna1.charAt(i)!=dna2.charAt(i))
		hammingDistance++;
	}
	
	System.out.println("The Hamming distance is : " + hammingDistance);
	
    }

}
