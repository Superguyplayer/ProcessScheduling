import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        ArrayList<MProcess> MProcesses = new ArrayList<>();

        /*Initialize(MProcesses);
        System.out.println("RoundRobin\n");
        Scheduler.RoundRobin(MProcesses);
        System.out.println("\n\n\nFCFS\n");
        Initialize(MProcesses);
        Scheduler.FCFS(MProcesses);
        System.out.println("\n\n\nShortest Job First\n");
        Initialize(MProcesses);
        Scheduler.ShortestJobFirst(MProcesses);
        System.out.println("\n\n\nPQ with Interruptions\n");  */
        Initialize(MProcesses);
        Scheduler.PriorityQueuing(MProcesses, true);
        System.out.println("\n\n\nPQ without Interruptions\n");
        Initialize(MProcesses);
        Scheduler.PriorityQueuing(MProcesses, false);



    }


    private static void Initialize(ArrayList<MProcess> MProcesses) {


        MProcess p1 = new MProcess(10, 1, 0, "p1");
        MProcess p2 = new MProcess(6, 2, 0, "p2");
        MProcess p3 = new MProcess(16, 3, 20, "p3");
        MProcess p4 = new MProcess(12, 4, 22, "p4");
        MProcess p5 = new MProcess(15, 5, 12, "p5");
        MProcess p6 = new MProcess(1, 6, 30, "p6");
        MProcess p7 = new MProcess(18, 7, 30, "p7");
        MProcess p8 = new MProcess(10, 8, 10, "p8");
        MProcess p9 = new MProcess(4, 9, 8, "p9");
        MProcess p10 = new MProcess(12, 10, 16, "p10");


        MProcesses.add(p1);
        MProcesses.add(p2);
        MProcesses.add(p3);
        MProcesses.add(p4);
        MProcesses.add(p5);
        MProcesses.add(p6);
        MProcesses.add(p7);
        MProcesses.add(p8);
        MProcesses.add(p9);
        MProcesses.add(p10);

    }

}
