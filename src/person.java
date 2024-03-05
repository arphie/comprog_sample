
public class person {
	private String name;
	private int age;
	
	public String lastname;
	
	public int sample;
	
	public person( String n, String l, int a) {
		name = n;
		age = a;
		lastname = l;
		sample = age + 12;
	} 
	
    public void walk() {
		System.out.println(name + "is walking.");
	}
    
    public void talk() {
		System.out.println(name + "is talking.");
	}
    
    public String getName() {
    	return this.name;
    }
    
    public int getAge() {
    	return age;
    }
    
    public void setName(String n) {
		name = n;
	}
    
    public void setAge(int a) {
		age = a;
	}
}
