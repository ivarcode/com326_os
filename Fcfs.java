/**
 * author: team OS Ninjas
 * class: Operaring Systems
 * This class simulates how a Fcfs algorithm works
 * It uses a queue implemented on a list to go through all the process in
 * queue to figure out the waitTimes
 */
import java.util.*;
public class Fcfs{
  LinkedList<Process>readyQueue = new LinkedList<Process>();
  int IOtime = 5;


  public Fcfs(Memory<Process> queue){
   readyQueue = queue.processQueue();


  }

  /** calculates the waiting times of each processes. returns the total waiting time **/
  public int findWaitingTime(){
    int wt = 0;

    for (Process process : readyQueue){
      // relevant variables
      int at = process.getArrivalTime();
      int bt = process.getBurstTime();
      int IOfreq = process.getIOtimeFreq();

      //except for the first process whose wait is 0, the wait for the others are total wait time so far
      //minus the arrival time of that process
      process.setWaitTime(wt - at);
      try{
        if (bt % IOfreq == 0)
          wt = wt + process.getBurstTime() + (bt/IOfreq - 1)*IOtime;
        else
          wt = wt + process.getBurstTime() + (bt/IOfreq)*IOtime;
      }
      catch(ArithmeticException e){
        System.out.println(IOfreq);
        wt = wt + process.getBurstTime();

      }
    }

    return wt;

  }
  public int findTurnAroundTime(){
    //for (int i = 0 ; i < n; i++){
      //tat[i] = bt[i-1] + wt[i-1];
    //}
    int tat = 0;
    for (Process process : readyQueue){
      // setting up turn around times
      process.setTurnATime(tat+process.getWaitTime());
    }
    return tat;
  }
  public float findAvgTime(){
    int n = readyQueue.size();
    return findWaitingTime()/n;
  }
  public String toString(){
    String processOrder = "";
    String waitTimes = "";
    int n =1;
    findWaitingTime();
    for(Process process: readyQueue){
      if (n == 1){
        process.setWaitTime(0);
      }
      processOrder = processOrder + "P" + Integer.toString(n) + " ";
      n++;


      waitTimes += Integer.toString(process.getWaitTime()) + " ";
    }
    //System.out.println(waitTimes);
    return processOrder + "\n" + waitTimes;
  }
  public String toString2() {
  	  int[] waitTimes = new int[6];
	  int[] completedProcesses = new int[6];
	  Process[] proc = new Process[6];
	  int i = 0;
	  for (Process process : readyQueue) {
	  	  proc[i] = process;
		  System.out.println("proc " + (i+1) + ": arr = " + proc[i].getArrivalTime() + ", burst = " + proc[i].getBurstTime() + ", iofr = " + proc[i].getIOtimeFreq());
		  i++;
	  }
	  int[] runtime = new int[1000];
	  for (int j = 0; j < 1000; j++) {
	  	  runtime[j] = 10000;
	  }
	  int index = 0;
	  int proc_index = 0;
	  while (true) {
	  	  runtime[index] = proc_index;
		  int iof = proc[proc_index].getIOtimeFreq();
		  int done = 0;
		  for (int m = 0; m < index+1; m++) {
		  	  if (runtime[m] == proc_index) {
			  	  done++;
			  }
		  }
		  if (done == proc[proc_index].getBurstTime()) {
		  	  completedProcesses[proc_index] = 1;
			  proc_index = 0;
			  while (completedProcesses[proc_index] == 1) {
			  	  proc_index++;
			  }
		  }
		  int inarow = 0;
		  for (int m = 0; m < index+1; m++) {
		  	  if (runtime[m] == proc_index) {
			  	  inarow++;
			  } else {
			  	  inarow = 0;
			  }
			  if (inarow == iof) {
			  	  runtime[index+1] = 99;
				  runtime[index+2] = 99;
				  index += 2;
				  proc_index++;
			  }
		  }
		  index++;
		  if (completedProcesses[0] == 1 && completedProcesses[1] == 1 && completedProcesses[2] == 1 && completedProcesses[3] == 1 && completedProcesses[4] == 1 && completedProcesses[5] == 1) {
		  	  break;
		  }
	  }
	  //calculate all of it
	  int inc = 0;
	  int[] finishTime = new int[6];
	  for (int x = 0; x < 6; x++) {
	  	  int inde = 0;
		  while (true) {
        if (inde == 100) {
          break;
        }
		  	  if (runtime[inde] == x) {
			  	  inc++;
			  }
			  if (inc == proc[x].getBurstTime()) {
			  	  finishTime[x] = inde;
            break;
			  }

			  inde++;
		  }
		  inc = 0;
	  }
	  String finishOrder = "";
	  for (int x = 0; x < 6; x++) {
	  	  int curr = 0;
		  int next = 1;
		  while (next < 6) {
		  	  if (finishTime[curr] < finishTime[next]) {
			  	  curr = next;
			  }
			  next++;
		  }
		  finishTime[curr] = 9999;
		  finishOrder += ((curr+1) + " ");
	  }

	  return finishOrder;

  }
  /**
  public static void main(String[] args){
    Fcfs test = new Fcfs();
    int [] processes = {1,2,3, 4};
    int [] burstTime = {21, 3, 6, 2};
    int [] waitTime = new int[burstTime.length];

    test.findWaitingTime(burstTime, burstTime.length, waitTime);
    System.out.println(test.findAvgTime(waitTime, burstTime.length));
    System.out.println(test.toString(waitTime));
  }
  **/
}
