import java.util.*;

public class Memory<E>{
  LinkedList<E> processes;
  int memCount = 0;
  public Memory(){
    processes = new LinkedList<E>();
  }

  public void addProcess(E newProcess){
    if (memCount < 100){
      processes.add(newProcess);
      memCount++;
      //return processes.newProcess;
    }
    //return -1;
  }

  public void remProcess(E oldProcess){
    processes.remove(oldProcess);
  }
}
