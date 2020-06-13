import java.io.*;
import java.util.*;

/** This is the test file for all test cases **/
public class TestFile{
    public static void main(String[] args)throws Exception {
      //file to read
      File file = new File("testFile.txt");
      BufferedReader br = new BufferedReader(new FileReader(file));

      String st;
      int pid = 1;
      Memory<Process> mem = new Memory<Process>();
      while ((st = br.readLine()) != null) {
        //getting relevant numbers and setting them to varibles
        String[] processInfo = st.split(",");
        String bt = processInfo[2];
        String at = processInfo[1];
        String IO = processInfo[3];


        int burstTime = Integer.parseInt(processInfo[2].substring(bt.length()-1));
        int IOfreq = Integer.parseInt(processInfo[3].substring(IO.length()-1));
        int arrivalTime = Integer.parseInt(processInfo[1].substring(at.length()-1));
        Process processes = new Process(pid, burstTime, arrivalTime, 0, IOfreq);
        PCB tracker = new PCB(pid, "ready", processes);
        mem.addProcess(processes);
        pid++;
        // System.out.println(mem.getLength());
        // System.out.println(mem);


        // add new process to list
      }
      // setting up fcfs simulator
      Fcfs simulateFcfs = new Fcfs(mem);
      RoundRobin simulateRoundRobin = new RoundRobin(mem);
      //mem.remProcess(mem.getProcess(4));
      //System.out.println(mem.getLength());

      System.out.println("terminal: 'q' to quit, \n'1' to add process, \n'2' to remove process, \n'3' to print memory \n'4'run FCFS \n '5' Run Round Robin");
      System.out.print("\n:: ");
      Scanner scanner = new Scanner(new InputStreamReader(System.in));
      String str = "";
      str = scanner.nextLine();
      while (!str.equals("q")) {
        // operate on str

        if (str.equals("1")) {
          // add process
          System.out.print("burst time, arrival time, IOfreq : ");
          str = scanner.nextLine();
          String[] times = str.split(",");

          mem.addProcess(new Process(pid, Integer.parseInt(times[0]),Integer.parseInt(times[1]), 0, Integer.parseInt(times[3])));
          pid++; 
          System.out.println("process added");
          System.out.println(mem.getLength());
        }
        else if (str.equals("2")) {
          //removing processes
          System.out.print("at what index? : ");
          str = scanner.nextLine();
          mem.remProcess(mem.getProcess(Integer.parseInt(str)));
          System.out.println("process removed");
          System.out.println(mem.getLength());
        } else if (str.equals("3")) {

            System.out.println(mem);
        }
        else if (str.equals("4")){
          // simulating fcfs
            System.out.println(simulateFcfs);
        }
        else if (str.equals("5")){
          // simulating round robin
          System.out.println(simulateRoundRobin);


        }

        // loop
        System.out.print("\n:: ");
        str = scanner.nextLine();
      }
      //System.out.println(mem);


      // PRINT PROCESS QUEUE

      // simulate
    }
}
