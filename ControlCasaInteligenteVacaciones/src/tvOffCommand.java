

public class tvOffCommand implements Command {
	Tv tv;
 
	public tvOffCommand(Tv tv) {
		this.tv = tv;
	}
 
	public void execute() {
		tv.off();
	}

	public void undo() {
		tv.on();
	}

}
