import java.io.*;
import java.util.*;

public class TestFile{
    public static void main(String[] args)throws Exception {
      File file = new File("processes.txt");
      BufferedReader br = new BufferedReader(new FileReader(file));

      String st;
      int pid = 0;
      Memory<Process> mem = new Memory<Process>();
      while ((st = br.readLine()) != null) {
        //System.out.println(st);
        String[] processInfo = st.split(",");
        int burstTime = Integer.parseInt(processInfo[1]);
        Process processes = new Process(burstTime, 0);
        PCB tracker = new PCB(pid, "ready", processes);
        mem.addProcess(processes);
        // System.out.println(mem.getLength());
        // System.out.println(mem);


        // add new process to list
      }
      mem.remProcess(mem.getProcess(4));
      System.out.println(mem.getLength());

      System.out.println("terminal: 'q' to quit, \n'1' to add process, \n'2' to remove process, \n'3' to print memory");
      System.out.print("\n:: ");
      Scanner scanner = new Scanner(new InputStreamReader(System.in));
      String str = "";
      str = scanner.nextLine();
      while (!str.equals("q")) {
        // operate on str
        if (str.equals("1")) {
          // add process
          System.out.print("burst time : ");
          str = scanner.nextLine();
          mem.addProcess(new Process(Integer.parseInt(str),0));
          System.out.println("process added");
          System.out.println(mem.getLength());
        } else if (str.equals("2")) {

          System.out.print("at what index? : ");
          str = scanner.nextLine();
          mem.remProcess(mem.getProcess(Integer.parseInt(str)));
          System.out.println("process removed");
          System.out.println(mem.getLength());
        } else if (str.equals("3")) {

            System.out.println(mem);
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
