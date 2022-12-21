public class Process {
    private String name;
    private int arrival, burst, priority, waiting_time, turnaround_time, completion_time, burstCpy;

    public int getWaiting_time() {
        return waiting_time;
    }

    public void setWaiting_time() {
        this.waiting_time = completion_time - burstCpy - arrival;
    }

    public int getCompletion_time() {
        return completion_time;
    }

    public void setCompletion_time(int completion_time) {
        this.completion_time = completion_time;
    }

    public int getTurnaround_time() {
        return turnaround_time;
    }

    public void setTurnaround_time() {
        this.turnaround_time = waiting_time + burstCpy;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getArrival() {
        return arrival;
    }

    public void setArrival(int arrival) {
        this.arrival = arrival;
    }

    public int getBurst() {
        return burst;
    }

    public void setBurst(int burst) {
        this.burst = burst;
    }

    public void setBurstCpy(int burst) {
        this.burstCpy = burst;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }
}
