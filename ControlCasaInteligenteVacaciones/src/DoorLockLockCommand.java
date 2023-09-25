public class DoorLockLockCommand implements Command {
    DoorLock doorLock;
 
	public DoorLockLockCommand(DoorLock doorLock) {
		this.doorLock = doorLock;
	}
 
	public void execute() {
		doorLock.lock();
	}

	public void undo() {
		doorLock.unlock();
	}
}
