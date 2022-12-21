import java.util.Arrays;
import java.util.Vector;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {

        int processes_num, RR_time, context_switching;
        Scanner input = new Scanner(System.in);
        System.out.println("Enter processes number, RR time, context switching");
        processes_num = input.nextInt();
        RR_time = input.nextInt();
        context_switching = input.nextInt();
        Process[] processes = new Process[processes_num];

        for (int i = 0; i < processes_num; ++i) {
            // System.out.println("Enter process name, arrival, burst, priority");
            input.nextLine();
            processes[i] = new Process();
            processes[i].setName(input.nextLine());
            processes[i].setArrival(input.nextInt());
            processes[i].setBurst(input.nextInt());
            processes[i].setBurstCpy(processes[i].getBurst());
            //  processes[i].setPriority(input.nextInt());
        }

        SJF scheduler = new SJF();
        scheduler.setSwitch(context_switching);

        scheduler.scheduling(processes);

        Vector<String> execution = scheduler.getExecution_order();
        System.out.println(execution);

        for (int i = 0; i < processes_num; ++i) {
            System.out.print(processes[i].getName());
            System.out.print(" ");
            System.out.print("Waiting time: ");
            System.out.print(processes[i].getWaiting_time());
            System.out.print(" ");
            System.out.print("Turnaround time: ");
            System.out.print(processes[i].getTurnaround_time());
            System.out.println();
        }
        System.out.println();

        System.out.print("avg. waiting time ");
        System.out.print(scheduler.getAvg_Waiting(processes));
        System.out.println();

        System.out.print("avg. turnaround time ");
        System.out.print(scheduler.getAvg_Turnaround(processes));
        System.out.println();
    }
}
