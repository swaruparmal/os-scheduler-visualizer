package model;

public class Process {
    public int id;
    public int arrivalTime;
    public int burstTime;
    public int completionTime;
    public int waitingTime;
    public int turnaroundTime;

    public Process(int id, int arrivalTime, int burstTime) {
        this.id = id;
        this.arrivalTime = arrivalTime;
        this.burstTime = burstTime;
    }
}

