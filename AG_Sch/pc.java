import java.util.Scanner;

class pc {

    public static void Output(Process[] processes, Scheduler scheduler, int processes_number) {
        System.out.println("Execution Order");
        System.out.println(scheduler.getExecution_order());

        for (int i = 0; i < processes_number; ++i) {
            System.out.print(processes[i].getName());
            System.out.print(", Waiting Time: ");
            System.out.print(processes[i].getWaiting_time());
            System.out.print(", Turnaround Time: ");
            System.out.print(processes[i].getTurnaround_time());
            System.out.println();
        }
        System.out.println();

        System.out.print("Avg. Waiting Time ");
        System.out.print(scheduler.getAvg_Waiting_time(processes));
        System.out.println();

        System.out.print("Avg. Turnaround Time ");
        System.out.print(scheduler.getAvg_Turnaround_time(processes));
        System.out.println();
    }
    public static void ShortestJobFirst(int context_switching, int processes_number, Process[] processes) {
        SJF_Scheduling scheduler = new SJF_Scheduling();
        scheduler.setContext_Switch(context_switching);

        scheduler.Shortest_Job_first_Scheduler(processes);

        Output(processes, scheduler, processes_number);
    }
    public static void AG(int processes_number, Process[] processes) {
        Scanner input = new Scanner(System.in);

        AG scheduler = new AG();
        scheduler.AG_Sch(processes);

        Output(processes, scheduler, processes_number);

        System.out.println("Quantum time history update per process");
        for (int i = 0; i < scheduler.getHistory_update().size(); i++) {
            System.out.print("Quantum ");
            System.out.println(scheduler.getHistory_update().get(i));
        }
    }

    public static void main(String[] args) {
        int processes_number,context_swiching;
        Scanner input = new Scanner(System.in);
        //System.out.println("Enter processes' number");
        processes_number = input.nextInt();
        context_swiching= input.nextInt();
        Process[] processes = new Process[processes_number];

        for (int i = 0; i < processes_number; ++i) {
            // System.out.println("Enter process name, arrival, burst, priority,Quantum");
            input.nextLine();
            processes[i] = new Process();
            processes[i].setName(input.nextLine()); //name
            processes[i].setArrival_time(input.nextInt()); //Arrival_Time
            processes[i].setBurst_time(input.nextInt());//Burst_Time
            processes[i].setBurst_timeCpy(processes[i].getBurst_time());
            processes[i].setPriority(input.nextInt());//Priority
            processes[i].setQuantum_time(input.nextInt());//Quantum

        }
        //System.out.println("SJF Scheduling");
        // ShortestJobFirst(context_swiching,  processes_number,  processes);
        System.out.println("************************************************************");
        System.out.println("AG Scheduling");
        AG(processes_number, processes);

    }
}
