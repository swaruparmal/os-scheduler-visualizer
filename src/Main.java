import model.Process;
import scheduler.FCFSScheduler;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        List<Process> processes = new ArrayList<>();

        processes.add(new Process(1, 0, 5));
        processes.add(new Process(2, 1, 3));
        processes.add(new Process(3, 2, 8));
        processes.add(new Process(4, 3, 6));

        FCFSScheduler.schedule(processes);
    }
}

