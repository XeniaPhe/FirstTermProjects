
public class Employee
{
    
    /*
    This is the employee class that represents the employees working in the factory 
    An employee has a name,surname,id,workhour,speed,items,payroll data fields
    that are all understandable from their names
    */
    Employee(String name,String surname)
    {
	  this(name,surname,0,0);
    }
    
    Employee(String name,String surname,int workHour,int speed)
    {
	  this(employeeCount,name,surname,workHour,speed);
    }
    Employee(int id,String name,String surname,int workHour,int speed)
    {
	  setItems(new Item[0]);
	  payroll=new Payroll(workHour, speed);
	  this.id=id;
	  this.name=name;
	  this.surname=surname;
	  this.workHour=workHour;
	  this.setSpeed(speed);
	  employeeCount+=1;
    }
    
    
    private int id;
    private static int employeeCount;
    private String name;
    private String surname;
    private int workHour;
    private int speed;
    private Item[] items;
    private Payroll payroll;
    
    public int getId()
    {
	  return id;
    }
    
    //Setting id is unnecessary and unsafe
    
    public String getName()
    {
	  return name;
    }
    
    public void setName(String name)
    {
	  this.name=name;
    }
    
    public String getSurname()
    {
	  return surname;
    }
    
    public void setSurname(String surname)
    {
	  this.surname = surname;
    }
    
    public String getFullName()
    {
	  return name + " " + surname;
    }
    
    public int getWorkHour()
    {
	  return workHour;
    }
    
    public void setWorkHour(int workhour)
    {
	  this.workHour=workhour;
    }
    
    public int getSpeed()
    {
	  return speed;
    }

    public void setSpeed(int speed)
    {
	  this.speed = speed;
    }
    
    public Item[] getItems()
    {
	  return items;
    }

    public void setItems(Item[] items)
    {
	  this.items = items;
    }

    public Payroll getPayroll()
    {
	  return payroll;
    }

    public void setPayroll(Payroll payroll)
    {
	  this.payroll = payroll;
    }

    public Item[] startShift()
    {
	  int totalItems=workHour*speed;
	  Item[] temp = new Item[totalItems];
	  
	  for(int i=0;i<totalItems;i++)
		{
		    temp[i] = new Item((int)Math.random()*100);
		}
	  setItems(temp);
	  return getItems();
    }
    
    public Payroll endShift()
    {
	  payroll.setItemCount(items.length);
	  payroll.setWorkHour(workHour);
	  
	  return getPayroll();
    }
    
    @Override
    public String toString()
    {
        return "This is the employee with id " + getId() + " speed " + getSpeed() +"." + "The work hour is " + 
      	    getWorkHour() + " and the produced item count is " + items.length +".";      	    	
    }
    
}
