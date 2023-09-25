public class SecurityCameraOnCommand implements Command {
    SecurityCamera securityCamera;
 
	public SecurityCameraOnCommand(SecurityCamera securityCamera) {
		this.securityCamera = securityCamera;
	}
 
	public void execute() {
		securityCamera.turnOn();
	}

	public void undo() {
		securityCamera.turnOff();
	}
}
