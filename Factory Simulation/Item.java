
public class Item
{ 
    /*
    This is the item class that represents the items produced in the factory,
    Either there is only one type of item or prices of all the items produced are same
    according to the implementation      
    */
    
    Item()
    {
	  this(numberOfItems);
    }
    
    Item(int id)
    {
	  numberOfItems+=1;
	  this.id=id;
    }
    
    private int id;
    static int numberOfItems;
 
    
    public int getId()
    {
	  return id;
    }
    
    /*
    public void setId(int id)
    {
	  id = this.id;
    }    
    I was supposed to implement this method but being able to
    change an ID that was set before is not really a good idea
    */  
}
