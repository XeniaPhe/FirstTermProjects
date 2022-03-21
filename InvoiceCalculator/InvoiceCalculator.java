import java.util.Scanner;

public class InvoiceCalculator
{
    /*
    Name:Mustafa Tunahan BAŞ
    ID:150119055

    This program calculates the invoices of each flat in an apartment.The first input is
    simply the flat count in the apartment and the following n(total flat count) inputs
    are consumption amount of each flat.The last input is the total bill of the apartment.
    30 percent of the bill amount will be shared equally by the flats and remaining 70 percent
    will be separated according to the consumption of each flat.
    */
 public static void main(String[] args)
 {
     Scanner scan = new Scanner(System.in);

     //Taking the inputs
     byte flatCount = scan.nextByte(); //I don't think there will be more more than 127 flats in an apartment
     double[] consumptions = new double[flatCount];
     short counter=0;

     while(counter<flatCount)
     {
         consumptions[counter] = scan.nextDouble();
         counter++;
     }
     /*
     Actually,here I wanted to check if user enters an invalid value which will cause a runtime
     error but then I realized it prevents serial input entry in the console so I had to write it
     this simple way
      */
     double totalBill =scan.nextDouble();

     printBills(calculateTheInvoice(consumptions,totalBill));

 }

 public static double[] calculateTheInvoice(double[] flats,double totalInvoice)
 {
     double[] invoices = new double[flats.length];
     double sum = SumElements(flats);
     for(int flat=0;flat<flats.length;flat++)
     {
         invoices[flat] = CalculateInvoiceofFlat(totalInvoice,flats[flat],CalculatePercentage(flats[flat],sum),(byte) flats.length);
     }
     //Method for calculating invoices
     return invoices;
 }

 public static double CalculatePercentage(double flatConsumption,double totalConsumption)
 {
     return  flatConsumption/totalConsumption ;
     //Method for calculating a flat's consumption percentage over the apartment
 }

 public static double CalculateInvoiceofFlat(double totalInvoice,double flatConsumption,double percentage,byte numberofFlats)
 {
     double invoice = (totalInvoice*0.3)/numberofFlats + (totalInvoice*0.7*percentage) ;
     return invoice;
     //Method for calculating a flat's invoice
 }

 public static double SumElements(double[] array)
 {
     double sum=0;

     for(double item : array)
     {
         sum+=item;
     }
     //Method for summing up the items in a double array
     //also the method that reminded me how useful LINQ technology is
     return sum;
 }

 public static void printBills(double[] invoices)
 {
     for(int flat =1;flat<=invoices.length;flat++)
     {
         System.out.println(flat + "." + "Flat: " + ((int)((invoices[flat-1]*100)))/100.00);
     }
     //The method for printing flats' invoices
 }
}
