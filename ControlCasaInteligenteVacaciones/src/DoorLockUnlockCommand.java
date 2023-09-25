public class DoorLockUnlockCommand implements Command {
    DoorLock doorLock;
 
	public DoorLockUnlockCommand(DoorLock doorLock) {
		this.doorLock = doorLock;
	}
 
	public void execute() {
		doorLock.unlock();
	}

	public void undo() {
		doorLock.lock();
	}
}
