/**
 * author: team OS Ninjas
 * class: Operaring Systems
 * This class simulates how a Fcfs algorithm works
 * It uses a queue implemented on a list to go through all the process in
 * queue to figure out the waitTimes
 */
 import java.util.*;
 public class RoundRobin{
   private LinkedList<Process> readyQueue = new LinkedList<Process>();
  // private LinkedList<Process> waitQueue = new LinkedList<Process>();
   private int IOtime = 5;
   private int quantum = 2;
   private int contextSwitch = 0;

   public RoundRobin(Memory<Process> queue){
    readyQueue = queue.processQueue();
  }
  //return remaining service time after running quantum
  public int runQuantum(int remBtTime){
    if (remBtTime >=  quantum){
      return remBtTime - quantum;

    }
    else
      return 0;
  }
  public int addTimer(int remBtTime){
    if (remBtTime > quantum)
      return quantum;
    else
      return remBtTime;
  }




  public String findWaitingTime(){
    // setting up variables
    String processList = "";
    String waitTimes = "";
    int total = 0;
    int n = readyQueue.size();
    // setting the arrival time of the first process to the timer
    int timer = readyQueue.getFirst().getArrivalTime();
    int wt = 0;
    int IOfreq =0 ;
    int arrivalTime;

    while(true)
    {
      // this boolean does the basic check for running the while loop
      boolean done = true;
      //System.out.println(readyQueue);
      for (Process process : readyQueue){

        // variable for IO handling
        IOfreq = process.getIOtimeFreq();
        arrivalTime = process.getArrivalTime();
        //System.out.println(arrivalTime);
        //System.out.println(timer);
        //remaining burst time for the processes
        int remBtTime =  process.getRemBurstTime();


        //only run the process that have already arrived
        if (arrivalTime <= timer){
          if (remBtTime > 0){
            processList = processList + "P" + Integer.toString(process.getID())+ " ";
            //System.out.println(1);
            done = false;
            // check for remaing time > than quantum
            if (remBtTime > quantum){
              try{
                if (quantum % IOfreq == 0 ){
                  timer += quantum + (quantum/IOfreq - 1)*(IOtime+contextSwitch);
                  process.setRemBurstTime(remBtTime-quantum);
                  remBtTime = remBtTime - quantum;
                }
                else{
                  timer += quantum + (quantum/IOfreq)*IOtime*(IOtime + contextSwitch);
                  process.setRemBurstTime(remBtTime-quantum);
                  remBtTime = remBtTime - quantum;
                }
              }
              catch (ArithmeticException e){
                //catches the exception where IOfreq is 0
              }
            }
            // just add the remaining time to timer if it is less or equal to quantum
            else{

              timer = timer + remBtTime;
              wt  = timer -  process.getBurstTime();
              process.setWaitTime(wt);
              total = total +  wt;
              remBtTime = 0 ;
              process.setRemBurstTime(remBtTime);

            }
          }
        }
        //adding context Switch times to the timer
        //timer = timer + contextSwitch;

      }
      if (done == true)
        break;

    }
    return processList;

  }
  public String waitTimePerProcess(){
    findWaitingTime();
    String waitTimes= "";
    for (Process process : readyQueue){
      waitTimes = waitTimes + " " + Integer.toString(process.getWaitTime());

    }
    return waitTimes;
  }
  // public String findWaitingTime1(){
  //   //accumulator for checking how many processes done
  //   int done = 0;
  //   // start with the first process on the ready queue
  //   System.out.println(readyQueue);
  //   Process running = readyQueue.pop();
  //   //setting timers
  //   int timer = running.getArrivalTime();
  //   int remBtTime = 0;
  //   //int remTime =0;
  //   // process defined by burstTime for now
  //   String processSeq = Integer.toString(running.getBurstTime());
  //   int n = readyQueue.size();
  //   System.out.println(n);
  //   while (true){
  //     try{
  //
  //       remBtTime = running.getRemBurstTime();
  //       remBtTime = runQuantum(remBtTime);
  //
  //       timer = timer + addTimer(remBtTime);
  //
  //       if (remBtTime <= 0){
  //         done++;
  //         System.out.println(done);
  //         // process ended
  //         running =null;
  //       }
  //       else{
  //         running.setRemBurstTime(remBtTime);
  //       }
  //       while (readyQueue.getFirst() != null){
  //         if(readyQueue.getFirst().getRemBurstTime() < timer){
  //           System.out.println(1);
  //           waitQueue.push(readyQueue.pop());
  //         }
  //       }
  //
  //     // add the current running process to the end of the queue
  //       if (running != null)
  //         waitQueue.push(running);
  //       if (waitQueue.getLast() != null)
  //         running = waitQueue.removeLast();
  //
  //       if (running != null)
  //         processSeq = processSeq + " " + Integer.toString(running.getBurstTime());
  //
  //         // all processes finish
  //       if (done == n)
  //       break;
  //
  //     }
  //     catch(NoSuchElementException e){
  //       System.out.println("excption!");
  //     }
  //     catch(NullPointerException e){
  //     //
  //       System.out.println("excrptipn!!");
  //     }
  //   }
  //     return processSeq;
  // }

  public String toString(){
    //return Integer.toString(findWaitingTime());
    return "processes in order " + findWaitingTime()+"\n WaitTimes for processes"+waitTimePerProcess();
  }
}
