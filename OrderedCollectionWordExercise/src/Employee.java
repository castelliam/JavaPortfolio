
/**
 * An Employee record includes three types of
 * data. A list of Employees may need to be 
 * ordered according to any of the three data fields.
 * An Employee is-a Comparable, thus must implement
 * a compareTo method
 * 
 * @author (McCauley) 
 * @version (March 16, 2009)
 */
public class Employee implements Comparable<Employee>
{
    String name;
    int empIDNum;
    double salary;

    /**
     * Constructor for objects of class 
     */
    public Employee(String name, int empIDNum, double salary)
    {
        this.name = name;
        this.empIDNum = empIDNum;
        this.salary = salary;
    }

    // Only one compareTo method, with the required
    // signature can be available at a time. Uncomment
    // the one that compares Employee records according
    // to the field of interest to you.


    // compare Employees according to ID num
    // if this < e.empIDNum returns negative value
    //    this == e.empIDNum returns zero
    //    this > e.empIDNum returns positive number
    // retults in ascending order of empIDNum
/*    public int compareTo(Employee e)
    {
        return empIDNum - e.empIDNum;
        
    }
 
 */  
    // compare Employees according to last name only
    // String's "compareTo" applies alphabetical ordering
    public int compareTo(Employee e)
    {   
       
        return name.compareTo(e.name);
    }
    

    
    
   // Compare based on salary
   // if this > e.salary returns positive value
   //    this == e.salary returns 0
   //    this < e.salary returns negative value
 /*  public int compareTo(Employee e)
   {       
      return (int) (salary - e.salary);
   } 
   */

  
    public String toString()
    {
        String returnStr = "";
        returnStr += "Employee #: " + empIDNum + "\t";
        returnStr += "   " + name + ",\t" + salary;
        return returnStr;
        
    }

    
   
}
