

public class GarageDoor {
	String location;

	public GarageDoor(String location) {
		this.location = location;
	}

	public void up() {
		System.out.println("\n" +location + "Garage Door is Up");
	}

	public void down() {
		System.out.println("\n" +location + "Garage Door is Down");
	}

	public void stop() {
		System.out.println("\n" +location + "garage Door is Stopped");
	}

	public void lightOn() {
		System.out.println("\n" +location + "garage light is on");
	}

	public void lightOff() {
		System.out.println("\n" +location + "garage light is off");
	}
}
