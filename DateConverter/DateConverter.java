import java.util.Scanner;

public class DateConverter
{
    public static void main(String[] args)
    {
        /*
        Name:Mustafa Tunahan BAS
        Student ID: 150119055


        This program converts dates which are given in days to years,months and days
        Like 400 days is equivalent to 1 year 1 month and 4 days
         */
        Scanner scan = new Scanner(System.in);
        System.out.print("Please enter the day value which you want as year-mont-week-day : ");
        int days = scan.nextInt();
        if(days < 0)//checking if the number is negative
        {
            System.out.print("The value was negative!");
        }
        else
        {
            int years = days / 365;//finds years 
            int remainingdays = days % 365;//finds how many days are remaining after converting them to years
            int months = remainingdays / 31;//finds months
            remainingdays = remainingdays % 31;//finds how many days are remaining after converting them to months

            System.out.print("Year: " + years + ",Month: " + months + ",Day: " + remainingdays);
        }
    }
}
