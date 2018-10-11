import java.io.*;

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
        System.out.println(mem.getLength());
        System.out.println(mem);


        // add new process to list
      }
      mem.remProcess(mem.getProcess(4));
      System.out.println(mem.getLength()); 


      //System.out.println(mem);


      // PRINT PROCESS QUEUE

      // simulate
    }
}
