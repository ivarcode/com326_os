public class process{
  int id;
  int burstTime;
  int memReq;
  public process(int id, int burstTime, int memReq){
    this.id = id;
    this.burstTime = burstTime;
    this.memReq = memReq;
  }
  public int getId(){
    return id;
  }
  public int getBurstTime(){
    return burstTime;
  }
  public int getMemReq(){
    return memReq;
  }
  public static void main(String[] args){
    process one = new process(1, 12, 34);
    System.out.println(one.getId());
  }
}
