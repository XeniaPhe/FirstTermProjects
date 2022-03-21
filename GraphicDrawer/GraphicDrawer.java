import java.util.Scanner;

public class GraphicDrawer
{

    public static void main(String[] args)
    {
	/*
        ID: 150119055
        Name: Mustafa Tunahan BAS

        This program creates a 16x16 coordinate system and shows the graphics of geometric equations and functions.
        Since it is on console screen,it can only show whole number values of the shape of the equation.
        So far it can calculate circle,parabola and linear equation systems.
        */
        System.out.print("Which shape would you like to draw?\n1. Line\n2. Parabola\n3. Circle\n4.Exit\n");
        Scanner scan = new Scanner(System.in);
        int choice = scan.nextInt();
        double a, b, c, r;
        String graph = "";
        //Since I'm not allowed to use arrays,I will use this string itself as my array
        //Anyways,it would be a lot easier to do that with a 2-D array :)


        //These nested loops simply create the coordinate system string without geometric shapes
        //Then I will calculate the indexes and replace chars with geometric shapes' accordingly.
        for(int vertical = 1; vertical <= 35; vertical++)
        {
            for(int horizontal = 1; horizontal <= 36; horizontal++)
            //Of course I could decrease the limit for horizontal but I kept it 36
            //To emphasize the total char count on each horizon of the string graph
            //So that I will not mistake the total char count.
            {
                if(horizontal==36)
                {
                    graph+="\n";
                    continue;
                }
                if(horizontal == 17)
                {
                    if(vertical == 1)
                        graph += "y";
                    else
                        graph += "|";
                    continue;
                }
                if(vertical == 18)
                {
                   if(horizontal == 34)
                        graph += " ";
                    else if(horizontal == 35)
                        graph += "x";
                    else
                        graph+="-";
                    continue;
                }
               graph+=" ";
            }
        }
        double y = 0;
        double y1=0;
        switch(choice)
        {
            case 1:
                System.out.print("Line formula is y = ax + b\n" + "Please enter coefficients a and b:");
                a = scan.nextDouble();
                b = scan.nextDouble();

                for(double x = - 16; x <= 16; x++)
                {
                    y = (a * x) + b;
                    //Solving the equation by substituting every integer x value on our coordinate system

                    //This following part of the project will be a little redundant since I'm not allowed to use methods;

                    //This first checks if y value fits our coordinate system and if y value is an integer
                    //Then it calculates the index accordingly if checks are passed successfully
                    if((y>=-16 && y<=16) && (y-(int)y==0))
                    {
                        int index=0;
                        if(y >= - 16 && y<0)
                            index = ((17+Math.abs((int)y))*36) + (int)x+16;
                        else if(y<=16 && y>=0)
                            index = ((17-(int)y)*36) + (int)x +16;
                       graph = graph.substring(0,index) + "*" + graph.substring(index+1,graph.length()-1);
                    }
                }
                break;
            case 2:
                System.out.print("Parabola formula is y = ax^2 + bx + c\n" + "Please enter coefficients a, b and c:");
                a = scan.nextDouble();
                b = scan.nextDouble();
                c = scan.nextDouble();
                for(double x = - 16; x <= 16; x++)
                {
                    y = (a * x*x) + (b*x) + c;
                    //Solving the equation by substituting every integer x value on our coordinate system
                    if((y>=-16 && y<=16) && (y-(int)y==0))
                    {
                        int index=0;
                        if(y >= - 16 && y<0)
                            index = ((17+Math.abs((int)y))*36) + (int)x+16;
                        else if(y<=16 && y>=0)
                            index = ((17-(int)y)*36) + (int)x +16;
                        graph = graph.substring(0,index) + "*" + graph.substring(index+1,graph.length()-1);
                    }
                }
                break;
            case 3:
                System.out.print("Circle formula is (x-a)^2 + (y-b)^2 = r^2\n" + "Please enter center's coordinates (a,b) and radius:");
                a = scan.nextDouble();
                b = scan.nextDouble();
                r = scan.nextDouble();

                for(double x = - 16; x <= 16; x++)
                {
                    double tempyminusb = Math.sqrt((r*r) - ((x-a)*(x-a)));
                    y=tempyminusb+b;
                    y1=b-tempyminusb;
                    //Solving the equation by substituting every integer x value on our coordinate system
                    for(int i=0;i<2;i++)
                    {
                        if((y>=-16 && y<=16) && (y-(int)y==0))
                        {
                            int index=0;
                            if(y >= - 16 && y<0)
                                index = ((17+Math.abs((int)y))*36) + (int)x+16;
                            else if(y<=16 && y>=0)
                                index = ((17-(int)y)*36) + (int)x +16;
                            graph = graph.substring(0,index) + "*" + graph.substring(index+1,graph.length()-1);
                        }
                        y=y1;
                    }
                }
                break;
            default:
                System.exit(1);
                break;
        }
        System.out.print(graph);
    }
}
