
public class Factory
{
     /*
     ID:150119055 Mustafa Tunahan BAŞ
     
     This program is simply a factory automation simulation on console,
     It consists of 5 classes :Factory,Storage,Employee,Item,Payroll.
     It helps adding employees,removing employees,calculating payrolls,
     calculating revenues,viewing/setting item price,adding items and a lot more 
     just like a regular automation program.    
     */
    
      /*
      This is the Factory class that represents factories.
      There are name,employees,storage,payrolls,itemprice fields
      in a Factory object.
      */
    Factory(String name)
    {
	  this(name,0,0);
    }
    
    Factory(String name,int capacity)
    {
	  this(name,capacity,0);
    }
    
    Factory(String name,double itemPrice)
    {
	  this(name,0,itemPrice);
    }    
    Factory(String name,int capacity,double itemPrice)
    {
	  employees = new Employee[0];
	  payrolls = new Payroll[0];
	  storage = new Storage(capacity);
	  this.name=name;
	  this.itemPrice=itemPrice;	  
    }
    
    private String name;
    private Employee[] employees;
    private Storage storage;
    private Payroll[] payrolls;
    private double itemPrice;
    
    public String getName()
    {
		return name;
    }
    
    public void setName(String name)
    {
		this.name = name;
    }
    
    public Employee[] getEmployees()
    {
		return employees;
    }
    
    //There is no setEmployees method since it is done in addEmployee and removeEmployee methods in a safe manner 
    
    public Storage getStorage()
    {
		return storage;
    }
    
    //There is no setStorage method due to security reasons
        
    public Payroll[] getPayrolls()
    {
		return payrolls;
    }
    
    //There's no setPayroll method since it's done in addPayrol method in a secure manner
    
    public double getItemPrice()
    {
		return itemPrice;
    }
    
    public void setItemPrice(double itemPrice)
    {
		this.itemPrice = itemPrice;
    }
    
    public double getRevenue()
    {
	 Item[] items = storage.getItems();
	 int itemCount=0;
	 for(Item item:items)
	     {
		   if(item!=null)
			 itemCount++;
	     }
	  
	 return itemCount*itemPrice;
	  	 
	 /*
	  This method returns the revenue but does not adjust the number to 2 decimal places or whatsoever,
	  If 2 decimal places are required,then the programmer is free to change the return value of the method
	  What I mean is,adjusting floating numbers' decimal digits is not the job of this function.
	  */
    }
    
    
    public double getPaidSalaries()
    {
	  double returnValue=0;
	  
	  for(Payroll item: payrolls)
		{
		   returnValue+= item.calculateSalary();
		}
	  return returnValue;
    }
    
    public void addEmployee(Employee employee)
    {
	 int addIndex = resizeArray(1);
	 employees[addIndex] = employee;
	 Item[] items = employee.startShift();
	 
	 for(Item item:items)
	     {
		   storage.addItem(item);
	     }
    }
    
    public Employee removeEmployee(int id)
    {
	  Employee returnvalue =null;
	  boolean check=false;
	  int removeIndex=0;
	  int employeeCount=resizeArray(1);
	 for(int i=0;i<employeeCount;i++)
	     {
		   if(employees[i].getId()==id)
			 {
			     check=true;
			     removeIndex=i;
			     break;
			 }
	     }
	 
	 if(employeeCount==0)
	     {
		   System.out.println("There are no employees!");
	     }
	 else if(check==false)
	     {
		   System.out.println("Employee does not exist!");
	     }
	 else 
	     {
		   Employee[] temp = new Employee[employees.length-1];
		   
		   for(int i=0;i<temp.length;i++)
			 {
			     if(i<removeIndex)
				   temp[i] = employees[i];
			     else if(i==removeIndex)
				   continue;
			     else
				   temp[i-1] =employees[i]; 			     
			 }
		   
		   returnvalue = employees[removeIndex];
		   addPayroll(returnvalue.endShift());
		   
		   employees=temp;		   
	     }
	 
	 
	  return returnvalue;
    }
    
    public void addPayroll(Payroll payroll)
    {
	 int addIndex = resizeArray(0);
	 payrolls[addIndex] = payroll;
    }
    
    private int resizeArray(int x) // 0 is for payrolls,1 is for employees
    {
	  int itemCount=0;
	  
	  if(x==0)
		{
		    for(Payroll element:payrolls)
				{
				    if(element!=null)
					  itemCount++;
				}
			  
			  if(itemCount==payrolls.length)
				{		    
				    Payroll[] temp = new Payroll[payrolls.length+1];
				    
				    for(int i=0;i<payrolls.length;i++)
					  {
						temp[i] = payrolls[i];
					  }
				    payrolls=temp;
				}
		}
	  else if(x==1)
		{
		    for(Employee element:employees)
				{
				    if(element!=null)
					  itemCount++;
				}
			  
			  if(itemCount==employees.length)
				{		    
				    Employee[] temp = new Employee[employees.length+1];
				    
				    for(int i=0;i<employees.length;i++)
					  {
						temp[i] = employees[i];
					  }
				    employees=temp;
				}
		}
	  
	  return itemCount;
    }
    
}
