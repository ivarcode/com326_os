public class PCB{
  int pid;
  int memReq;
  //memory location ? should be a pointer to the location where the process is located
  int memloc; //index of our linked list
  int priority;
  String processState;
  Process process;

  public PCB(int id, int bt, int wt, String state){
    process = new Process(id, bt, wt);
  }

  public PCB(Process process, String state){
    pid = process.getPid();
    processState = state;
  }

  public int getPid(){
    return pid;
  }

  public int getMemReq(){
    return memReq;
  }

  public int getPriority(){
    return priority;
  }

  public String getProcessState(){
    return processState;
  }

  public void setProcessState(String state){
    processState = state;

  }
  public static void main(String[] args){
    PCB one = new PCB(1, 10, 12, "ready");
    System.out.println(one.getProcessState());
  }
}
