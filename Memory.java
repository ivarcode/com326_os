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
    memCount--;

  }
  public E getProcess(int index){
      return processes.get(index);
  }
  public int getLength(){
    return processes.size();
  }
  public String toString(){
    String processInfo = "";
    int i =1;
    for(E process : processes){
      processInfo = processInfo +"processID " + i +  ", burstTime = " + process.toString()+"\n";
      i++;
    }
    return processInfo;

  }

}
