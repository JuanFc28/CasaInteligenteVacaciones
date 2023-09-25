public class SecurityCamera {
    String location;

    public SecurityCamera(String location) {
        this.location = location;
    }

    public void turnOn() {
        System.out.println(location + " Security Camera is turned on");
    }

    public void turnOff() {
        System.out.println(location + " Security Camera is turned off");
    }
}
