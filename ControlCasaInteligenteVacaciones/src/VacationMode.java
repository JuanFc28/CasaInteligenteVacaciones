
import java.util.Queue;

public class VacationMode{
    public Queue<Object> fila;

    public VacationMode(){
       
    }

    public void enqueue (Command command){
        fila.add(command);  
    }

    public boolean isEmpty(){
        return fila.isEmpty();
    }

    public void printList(){
        System.out.println("La fila es: "+fila);
        System.out.println("\n");
    }
}
