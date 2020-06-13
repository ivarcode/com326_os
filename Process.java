// create this using a file. we'll customize our file the way we want
public class Process{
    private int id;
    private int arrivalTime;
    private int burstTime;
    private int waitTime;
    private int turnATime;
    private int IOfreq;
    private int remBurstTime;


    public Process(int pid, int bt, int at, int wt, int IO){
     id = pid;
     burstTime = bt;
     waitTime = wt;
     arrivalTime = at;
     IOfreq = IO;
     remBurstTime = bt;

    }

    public int getID(){
      return id;
    }

    public int getRemBurstTime(){
      return remBurstTime;

    }
    public int getBurstTime(){
      return burstTime;
    }
    public int getWaitTime(){
      return waitTime;
    }
    public int getArrivalTime(){
      return arrivalTime;
    }
    public int getIOtimeFreq(){
      return IOfreq;
    }
    public void setBurstTime(int time){
      burstTime = time;
    }
    public void setWaitTime(int time){
      waitTime = time;
    }
    public void setTurnATime(int time){
      turnATime = time;

    }
    public void setRemBurstTime(int time){
      remBurstTime = time;
    }
    public String toString(){
      return Integer.toString(getRemBurstTime());
    }
}
