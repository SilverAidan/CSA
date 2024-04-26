public class Puppy {
	private String name; private int age; private String breed;
	private static int puppyCount;
	public Puppy() {
		puppyCount++;
		name = "Puppy" + puppyCount; age = 0; breed = "Dog";
	}
	public Puppy(String name)
	{
		this();
		this.name = name;
		
	}
	public Puppy(String name, int age)
	{
		this(name);
		this.age = age;
		
	}
	public String speak()
	{
		return "Bark";
	}
	
	public String speak(int count)
	{
		String output = "";
		for(int i = 0; i<count; i++)
			output +=this.speak() + " ";
		return output;
	}
	public String speak(int count, String newSpeak)
	{
		return this.speak(count).replaceAll("Bark", newSpeak);
	}
	public String speak(String word1, String word2, int count)
	{
		return this.speak(count,word1)+this.speak(count,word2);
	}
	public String getName() {
		return name;
	}
	public Puppy setName(String name) {
		this.name = name;
		return this;
	}
	public int getAge() {
		return age;
	}
	public Puppy setAge(int age) {
		this.age = age;
		return this;
	}
	public String getBreed() {
		return breed;
	}
	public Puppy setBreed(String breed) {
		this.breed = breed;
		return this;
	}
}