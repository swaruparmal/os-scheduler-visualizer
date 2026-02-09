package scheduler;

import model.Process;
import java.util.*;

public class FCFSScheduler {

    public static void schedule(List<Process> processes) {

        processes.sort(Comparator.comparingInt(p -> p.arrivalTime));

        int currentTime = 0;
        double totalWaiting = 0;
        double totalTurnaround = 0;

        System.out.println("Gantt Chart:");

        for (Process p : processes) {

            if (currentTime < p.arrivalTime) {
                currentTime = p.arrivalTime;
            }

            System.out.print("| P" + p.id + " ");

            p.completionTime = currentTime + p.burstTime;
            p.turnaroundTime = p.completionTime - p.arrivalTime;
            p.waitingTime = p.turnaroundTime - p.burstTime;

            currentTime = p.completionTime;

            totalWaiting += p.waitingTime;
            totalTurnaround += p.turnaroundTime;
        }

        System.out.println("\nProcess\tAT\tBT\tCT\tWT\tTAT");

        for (Process p : processes) {
            System.out.printf(
                    "P%d\t%d\t%d\t%d\t%d\t%d\n",
                    p.id,
                    p.arrivalTime,
                    p.burstTime,
                    p.completionTime,
                    p.waitingTime,
                    p.turnaroundTime
            );
        }


        int n = processes.size();
        System.out.println("\nAverage Waiting Time = " + (totalWaiting / n));
        System.out.println("Average Turnaround Time = " + (totalTurnaround / n));
    }
}
