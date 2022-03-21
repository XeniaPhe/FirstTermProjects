import java.util.Scanner;

public class TaxCalculator
{
        public static void main(String[] args)
        {
           /*
           Name : Mustafa Tunahan BAÞ
           Student ID : 150119055

           This program takes two inputs from the user such that one of them is income and the other one is
           the year which the tax amount will be calculated according to,and produces an output for tax amount.
            */

            Scanner scan = new Scanner(System.in);

            //System.out.print("Which year you want to calculate your yearly tax amount for (2017-2018-2019-2020) : ");
            int year = scan.nextInt();

            //System.out.print("What is the amount of your yearly income : ");
            double income = scan.nextDouble();

            if(!(year == 2017 || year == 2018 || year == 2019 || year == 2020))
            {
                System.out.print("Undefined year value!");
                System.exit(1);
            }
            //Taking year input from the user and checking if it exceeds the limits(2017-2020)
            //if it does,then the program will be terminated
            if(income <= 0)
            {
                System.out.print("Income must be > 0!");
                System.exit(1);
            }
            //Taking income input from the user and checking if it is negative
            //if it's negative,then the program will be terminated

            double totaltaxamount = 0;
            double tempincome = income;

            switch(year)
            {
                case 2017:
                    if(tempincome > 110000)
                    {
                        totaltaxamount = ((tempincome - 110000) * (35 / 100.0));
                        tempincome = 110000;
                    }
                    if(tempincome > 30000)
                    {
                        totaltaxamount += ((tempincome - 30000) * (27 / 100.0));
                        tempincome = 30000;
                    }
                    if(tempincome > 13000)
                    {
                        totaltaxamount += ((tempincome - 13000) * (20 / 100.0));
                        tempincome = 13000;
                    }

                    totaltaxamount += (tempincome * (15 / 100.0));

                    break;

                case 2018:
                    if(tempincome > 120000)
                    {
                        totaltaxamount = ((tempincome - 120000) * (35 / 100.0));
                        tempincome = 120000;
                    }
                    if(tempincome > 34000)
                    {
                        totaltaxamount += ((tempincome - 34000) * (27 / 100.0));
                        tempincome = 34000;
                    }
                    if(tempincome > 14800)
                    {
                        totaltaxamount += ((tempincome - 14800) * (20 / 100.0));
                        tempincome = 14800;
                    }

                    totaltaxamount += (tempincome * (15 / 100.0));
                    break;
                case 2019:
                    if(tempincome > 500000)
                    {
                        totaltaxamount = ((tempincome - 500000) * (40 / 100.0));
                        tempincome = 500000;
                    }
                    if(tempincome > 148000)
                    {
                        totaltaxamount += ((tempincome - 148000) * (35 / 100.0));
                        tempincome = 148000;
                    }
                    if(tempincome > 40000)
                    {
                        totaltaxamount += ((tempincome - 40000) * (27 / 100.0));
                        tempincome = 40000;
                    }
                    if(tempincome > 18000)
                    {
                        totaltaxamount += ((tempincome - 18000) * (20 / 100.0));
                        tempincome = 18000;
                    }

                    totaltaxamount += (tempincome * (15 / 100.0));
                    break;
                case 2020:
                    if(tempincome > 600000)
                    {
                        totaltaxamount = ((tempincome - 600000) * (40 / 100.0));
                        tempincome = 600000;
                    }
                    if(tempincome > 180000)
                    {
                        totaltaxamount += ((tempincome - 180000) * (35 / 100.0));
                        tempincome = 180000;
                    }
                    if(tempincome > 49000)
                    {
                        totaltaxamount += ((tempincome - 49000) * (27 / 100.0));
                        tempincome = 49000;
                    }
                    if(tempincome > 22000)
                    {
                        totaltaxamount += ((tempincome - 22000) * (20 / 100.0));
                        tempincome = 22000;
                    }

                    totaltaxamount += (tempincome * (15 / 100.0));
                    break;
                    /*
                    The way each case statement works is so simple;
                    It first checks whether the amount is greater than the limit,
                    If it is greater,then it calculates (Income-Limit)*(Tax Percentage) and then
                    assigns the lower limit value to the temporary income variable so that other
                    if statements will be executed correctly too.
                    If it is not greater than the first limit,it will execute the first if statement
                    for which the income amount is greater than the limit.
                    Once an if statement is executed,the following if statements have to be executed.
                    The rest is just about math :)
                     */
            }
            

            /*System.out.printf("%s%1.2f\n", "Income: ",income);
            System.out.printf("%s%1.2f\n", "Tax amount: ",totaltaxamount);
            System.out.printf("%s%1.2f\n", "Income after tax: ",(income - totaltaxamount));
            double realtaxrate = (totaltaxamount / income) * 100;
            System.out.printf("%s%1.2f%%", "Real tax rate: ",realtaxrate);
            
            I was going to use this but there was slightly a difference in rounding,
            The one the instructor used is I suppose the method of multiplying by 100 and dividing back
            so it just truncates the decimal part after second digit so even if the number is 0.769 it rounds down to 0.76
            but this rounds up or down according to the situation,so mine yielded slight different results,and so in the end
            I had to use the following
            */

            System.out.println("Income: " + (int)(income*100)/100.0);
            System.out.println("Tax amount: " + (int)(totaltaxamount*100)/100.0);
            System.out.println("Income after tax: " + (int)((income-totaltaxamount)*100)/100.0);
            double realtaxrate = (int)((totaltaxamount/income)*10000)/100.00;
            System.out.println("Real tax rate: " + realtaxrate + "%");

        }
    }