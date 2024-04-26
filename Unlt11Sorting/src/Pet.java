public class Pet implements Comparable{
    private String name;
    private int age;//in years
    private double weight;//in pounds

    public Pet ()
    {
	name = "Pet" + (int)((Math.random()*900) + 100);    
        age = (int)(Math.random()*12); 
        weight = Math.random()*50 + 10;
    }
    public Pet(String n, int a, double w)
    {
	name = n;    
        age = a; 
        weight = w;
    }


    public void set(String newName)
    {
        name = newName;
        //age and weight are unchanged.
    } 
   
    public void set(int newAge)
    {
        if (newAge <= 0)
        {
            System.out.println("Error: illegal age.");
            System.exit(0);
        }
        else
            age = newAge;
        //name and weight are unchanged. 
    }

    public void set(double newWeight)
    {
        if (newWeight <= 0)
        {
            System.out.println("Error: illegal weight.");
            System.exit(0);
        }
        else
            weight = newWeight;
        //name and age are unchanged. 
    }


    public String getName()
    {
        return name;
    }

    public int getAge()
    {
        return age;
    }
     public double getWeight()
    {
        return weight;
    }
    public String toString(){
		return name + " is " + age + " years old. and weighs " + weight + " pounds.";
	}
    
    public int compareTo(Object o) {
		Pet other = (Pet)o;
		if(this.age>= 10 && this.age>other.age) {
			return 1;
		}
		if(other.age>= 10 && this.age<other.age) {
			return -1;
		}
		return this.name.substring(3).compareTo(other.name.substring(3));
	}
    
    
    
//	public int compareTo(Object o) {
//		Pet other = (Pet)o;
//		if(this.age != other.age) {
//			return this.age - other.age;
//		}
//		return (int) (this.weight - other.weight);
//	}
}