public class CommandsStack {
    
    private Command[] commands;
    private int index;
    
    //Constructor de la clase CommandsStack
    public CommandsStack() {
        commands = new Command[14];
        index = 0;
    }
    
    //Método push para añadir un comando a la pila
    public void push(Command command) {
        if (!isFull()) {
            commands[index] = command;
            index++;
        }
    }
    
    //Método pop para obtener el último comando ejecutado    
    public Command pop() {
        if (isEmpty()) {
            return new NoCommand();
        }
        index--;
        return commands[index];
    }
    
    //Método isEmpty para saber si la pila está vacía
    public boolean isEmpty() {
        return index == 0;
    }

    public boolean isFull() {
        return index == commands.length;
    }

    //Método toString para imprimir el contenido de la pila
    public String toString() {
        StringBuffer stringBuff = new StringBuffer();
        stringBuff.append("\n------ Commands Stack -------\n");
        for (int i = 0; i < index; i++) {
            stringBuff.append("[slot " + i + "] " + commands[i].getClass().getName() + "\n");
        }
        return stringBuff.toString();
    }
}
