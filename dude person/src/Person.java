public class Person {

	private String name;
	private int age;
	private char gender;
	private static String country = "Japan";
	private static int peopleCount;
	public static String getCountry() {
		return country;
	}
	
	public Person() {
		name = "";
		age = 0;
		gender = ' ';
		peopleCount++;
	}

	public Person(String Name, char Gender) {
		this(); name = Name; gender = Gender;
	}

	public Person(String Name, int Age, char Gender) {
		this(Name, Gender); age = Age;
	}

	public String GetName() {
		return name;
	}

	public int GetAge() {
		return age;
	}

	public char GetGender() {
		return gender;
	}

	public void Birthday() {
		age++;
	}
	public boolean hasBirthdayParty() {
		this.Birthday();
		return age % 5==0;
	}

	public void Introduction() {
		System.out.println("Hello, my name is " + name);
	}
	
	public String toString(){

		return "name: " + name + "\nage: " + age + "\ngender: " + gender + "\n";
	}

	public static int getPeopleCount() {
		return peopleCount;
	}


}
