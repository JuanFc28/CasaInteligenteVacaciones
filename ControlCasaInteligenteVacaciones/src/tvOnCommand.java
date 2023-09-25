

public class tvOnCommand implements Command {
	Tv tv;
 
	public tvOnCommand(Tv tv) {
		this.tv = tv;
	}
 
	public void execute() {
		tv.on();
	}

	public void undo() {
		tv.off();
	}

}
