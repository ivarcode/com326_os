// create this using a file. we'll customize our file the way we want
public class Process{
    private int burstTime;
    private int waitTime;

    public Process(int bt, int wt){
     burstTime = bt;
     waitTime = wt;
    }

    public int getBurstTime(){
      return burstTime;
    }
    public int getWaitTime(){
      return waitTime;
    }
    public void setBurstTime(int time){
      burstTime = time;
    }
    public void setWaitTime(int time){
      waitTime = time;
    }
}
