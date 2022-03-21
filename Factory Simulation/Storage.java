
public class Storage
{
    
    /*
    This is the Storage class that represents the storages in the factory,
    A storage has items and a capacity.
    */
    Storage()
    {
	  this((int)Math.random()*100);
    }
    
    Storage(int capacity)
    {
	  this.capacity=capacity;
	  items = new Item[capacity];
    }
    
       
    private int capacity;
    private Item[] items;
    
    public int getCapacity()
    {
	  return capacity;
    }
    //Setting capacity is unnecessary since addItem method already changes the capacity in a safe manner

    public Item[] getItems()
    {
	  return items;
    }
    
    //Setting items is not safe and there is already a method to add items.
    
    public void addItem(Item item)
    {
	  int addIndex = resizeArray();	  
	  items[addIndex] = item;	  
    }
    
    
    /*
    public static Object[] ResizeArray(Object[] array)
    {
	  int itemCount = 0;
	  
	  for(Object element:array)
		{
		    if(element!=null)
			  itemCount++;
		}

	  if(itemCount==array.length)
		{
		   Object[] temp = new Object[array.length+1];
		    for(int i=0;i<array.length;i++)
			  {
				temp[i] = array[i];
			  }
		    		 
		    array=temp;
		}
	  Object[] returnvalue = new Object[] {array,itemCount};
	  
	  return returnvalue;
	  
	   
	   This method checks if the array is full or not.
	   When we have an array say called foo,since foo.length actually 	  
	   not gives us the item count in the array but the initial size we defined while creating the foo variable,we can not use 
	   it to add new items to an array without knowing which index we should add to.So this method simply finds the first null occurrence
	   in the array and returns its index where we should be adding our new item to.The index will be returned either way but if the 
	   not-null item count is equal to length of the array,then the size of the array will be increased by 1.Actually it does not increase the 
	   size of the array but changes the reference of the array to another array's whose size is greater.
	   Increasing the size by 1 is not an optimal solution,instead of this the size could be increased by,say 4 as in list generic(that happens automatically),
	   Or not restricting our virtual database(array) by giving it an initial size would be even a better option(using list generic).
	   And since I had to resize arrays in different classes with different types,I decided to create only one method that will
	   resize my array,and it is static since it does not require to have a Storage object to resize an array.
	   I could either create a static class for this extra helper method or create the same method in other classes with specific types
	   both which are not good options in this particular project.The first one requires an extra class and since this is a homework I could not
	   add an extra class which was not supposed to be,and the second way would not be practical.So I decided to create this method
	   inside a class that has nothing specific to do with this method since I had no other option.  
	   
	   Note:Changing the reference did not work out of the method as I expected,so I decided the method to return an object array whose first
	   item will be the new array,and the second item will be adding index.
	  
	  	   
    }
    
    It did not work :/
    Instead of it I will create same methods for different classes
    which I still find pretty redundant and impractical but that's all I can do with these stuff
    */
    
    private int resizeArray()
    {
	  int itemCount=0;
	  
	  for(Item element:items)
		{
		    if(element!=null)
			  itemCount++;
		}
	  
	  if(itemCount==capacity)
		{
		    capacity+=1;
		    Item[] temp = new Item[capacity];
		    
		    for(int i=0;i<items.length;i++)
			  {
				temp[i] = items[i];
			  }
		    items=temp;
		}
	  
	  return itemCount;
	  
	  //This is the method I wrote after the method above did not work,the functionality is same,the only difference is,
	  //this method does not require parameters since it's specific for the class.
	  //And this method will be copied to other classes that require resizing arrays.
    }
    
    
}
