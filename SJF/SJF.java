import java.time.temporal.ChronoUnit;
import java.util.Vector;

public class SJF {
    Vector<String> execution_order;
    private double Avg_Waiting;
    private double Avg_Turnaround;
    private Process Current_Process;
    private double Total_Burst;
    private int Switch;

    public SJF() {
        Total_Burst = 0;
        Switch = 0;
        execution_order = new Vector<String>();
    }

    public void setSwitch(int aSwitch) {
        Switch = aSwitch;
    }

    public Vector<String> getExecution_order() {
        return execution_order;
    }

    public double getAvg_Waiting(Process[] processes) {
        double sum = 0;
        for (int i = 0; i < processes.length; ++i) {
            sum += processes[i].getWaiting_time();
        }
        Avg_Waiting=(sum / processes.length);
        return Avg_Waiting;
    }

    public double getAvg_Turnaround(Process[] processes) {
        double sum = 0;
        for (int i = 0; i < processes.length; ++i) {
            sum += processes[i].getTurnaround_time();
        }
        Avg_Turnaround=(sum / processes.length);
        return Avg_Turnaround;
    }

    public void Total_Burst(Process[] processes) {
        for (int i = 0; i < processes.length; ++i) {
            Total_Burst += processes[i].getBurst();
        }
    }

    public Process Shortest_Process(Process[] processes, int k) {
        double min = 1e9;
        for (int i = 0; i < processes.length; ++i) {
            if (processes[i].getArrival() <= k) {
                if (processes[i].getBurst() < min && processes[i].getBurst() != 0) {
                    min = processes[i].getBurst();
                }
            }
        }
        for (int i = 0; i < processes.length; ++i) {
            if (processes[i].getArrival() <= k) {
                if (processes[i].getBurst() == min) {
                    return processes[i];
                }
            }
        }
        return null;
    }

    public void scheduling(Process[] processes) {
        Total_Burst(processes);
        int k = 0;
        while (Total_Burst != 0) {
            Process p = Shortest_Process(processes, k);

            if (Current_Process == null && p != null) {
                Current_Process = p;
                execution_order.addElement(Current_Process.getName());
                k+=Switch;
            } else if (Current_Process != null && p != null) {
                if (Current_Process.getBurst() > p.getBurst()) {
                    Current_Process = p;
                    execution_order.addElement(Current_Process.getName());
                    k+=Switch;

                }
            }
            k++;
            if (Current_Process != null) {
                Current_Process.setBurst(Current_Process.getBurst() - 1);
                if (Current_Process.getBurst() == 0) {
                    Current_Process.setCompletion_time(k);
                    Current_Process.setWaiting_time();
                    Current_Process.setTurnaround_time();
                    Current_Process = null;
                }
                Total_Burst--;
            }
        }
    }
}