public class Fcfs{

  public void findWaitingTime(int[] bt, int n, int[] wt){
    wt[0] = 0;
    for (int i = 1; i < n; i++){
      wt[i] = bt[i-1] + wt[i-1];
    }
  }
  public void findTurnAroundTime(int[] bt, int n,
                                    int[] wt, int[] tat){
    for (int i = 0 ; i < n; i++){
      tat[i] = bt[i-1] + wt[i-1];
    }
  }
  public float findAvgTime(int[] wt, int n){
    int totalWaitingTime = 0;
    for (int i = 0; i < n; i++){
      totalWaitingTime += wt[i];
    }
    return totalWaitingTime/n;
  }
  public String toString(int[] wt){
    String waitTimes = "";
    for(int i = 0; i < wt.length; i++){
      waitTimes += Integer.toString(wt[i]) + " ";
    }
    System.out.println(waitTimes);
    return waitTimes;
  }
  public static void main(String[] args){
    Fcfs test = new Fcfs();
    int [] processes = {1,2,3, 4};
    int [] burstTime = {21, 3, 6, 2};
    int [] waitTime = new int[burstTime.length];

    test.findWaitingTime(burstTime, burstTime.length, waitTime);
    System.out.println(test.findAvgTime(waitTime, burstTime.length));
    System.out.println(test.toString(waitTime));
  }
}
