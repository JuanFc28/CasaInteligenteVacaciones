public class DoorLock {
    String location;

    public DoorLock(String location) {
        this.location = location;
    }

    public void lock() {
        System.out.println(location + " Door Lock is locked");
    }

    public void unlock() {
        System.out.println(location + " Door Lock is unlocked");
    }
}
