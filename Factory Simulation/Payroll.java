
public class Payroll
{
   /*
   This is the payroll class that represents the payrolls of employees
   There are two data fields(workHour and itemCount) it holds,
   these data fields are used to calculate the salary of an employee
   in the calculateSalary method 
   */

    Payroll()
    {
	  this(0,0);
    }
    
    Payroll(int workHour,int itemCount)
    {
	  this.workHour=workHour;
	  this.itemCount=itemCount;
    }
    
        
    private int workHour;
    private int itemCount;
    
    public int getWorkHour()
    {
	  return workHour;
    }
    
    public void setWorkHour(int workHour)
    {
	  this.workHour=workHour;
    }
    
    public int getItemCount()
    {
	  return itemCount;
    }
    
    public void setItemCount(int itemCount)
    {
	  this.itemCount=itemCount;
    }
       
    
    public int calculateSalary()
    {
	  return (3*workHour) + (2*itemCount);
    }
    
    @Override
    public String toString()
    {
        return "The work hour is " + workHour + " and the produced item count is " + itemCount + ".";
    }
    
}
