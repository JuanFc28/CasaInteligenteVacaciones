public class SecurityCameraOffCommand implements Command {
    SecurityCamera securityCamera;
 
	public SecurityCameraOffCommand(SecurityCamera securityCamera) {
		this.securityCamera = securityCamera;
	}
 
	public void execute() {
		securityCamera.turnOff();
	}

	public void undo() {
		securityCamera.turnOn();
	}
}
