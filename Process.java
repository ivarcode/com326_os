// create this using a file. we'll customize our file the way we want
public class Process{
    private int arrivalTime;
    private int burstTime;
    private int waitTime;
    private int turnATime;
    private int IOfreq;


    public Process(int bt, int at, int wt, int IO){
     burstTime = bt;
     waitTime = wt;
     arrivalTime = at;
     IOfreq = IO;

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
    public String toString(){
      return Integer.toString(getBurstTime());
    }
}
