

public class Tv {
    String location;

	public Tv(String location) {
		this.location = location;
	}

    public void on(){
        System.out.println("\n" +location + " tv is on");
    }

    public void off(){
        System.out.println("\n" +location + " tv is off");
    }
}
