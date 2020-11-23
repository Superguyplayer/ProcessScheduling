import java.util.ArrayList;

public class Scheduler {

    public static void PriorityQueuing(ArrayList<MProcess> MProcesses, boolean withInterruption) {
        int time = 0;
        boolean finished = false;
        int stepSize = 2;
        MProcess lastProcess = null;

        ArrayList<MProcess> activeProcesses = new ArrayList<>();

        while (!finished) { //WOW

            //sind neue Prozesse aktiv?
            for (MProcess process : MProcesses) {
                if (!activeProcesses.contains(process)) {
                    if (process.getStart() <= time && !process.isFinished()) {
                        activeProcesses.add(process);
                        System.out.println("Process " + process.getName() + " is now in Queue at Time " + time + " with a duration of " + process.getDuration() + "ms and a Prio of " + process.getPriority());
                    }

                }

                //sind fertige Prozesse in der aktiven Liste
                if (activeProcesses.contains(process) && process.getDurationLeft() <= 0) {
                    process.setFinished(true);
                    activeProcesses.remove(process);
                    System.out.println(process.getName() + " finished at Time: " + time + "\n\tIt took " + (time - process.getStart()) + " ms");
                }


            }

            //sind wir fertig?
            if (activeProcesses.isEmpty()) {
                finished = true;
                System.out.println("done\nTotal Time: " + time + "ms");
                break;

            }
            // wichtigsten Prozes finden
            int indexOfMostPrio = -1;

            for (int i = 0; i < activeProcesses.size(); i++) {
                if (indexOfMostPrio == -1) {
                    indexOfMostPrio = i;
                } else if (activeProcesses.get(indexOfMostPrio).getPriority() > activeProcesses.get(i).getPriority()) {
                    indexOfMostPrio = i;
                }
            }

            //Prozess "bearbeiten"

            if (withInterruption) {
                activeProcesses.get(indexOfMostPrio).lowerDurationBy(stepSize);
            } else {

                if (activeProcesses.contains(lastProcess)) {
                    lastProcess.lowerDurationBy(stepSize);
                } else {

                    activeProcesses.get(indexOfMostPrio).lowerDurationBy(stepSize);

                    lastProcess = activeProcesses.get(indexOfMostPrio);

                }
            }

            //Ausgabe
            /*
            System.out.println("Time: " + time + "ms");
            for (MProcess process : activeProcesses) {
                System.out.println("\t" + process.getName() + ", Time left: " + process.getDurationLeft() + "ms\tPrio: " + process.getPriority());
            }

*/
            //Die Zeit läuft
            time = time + stepSize;


        }
    }


    public static void ShortestJobFirst(ArrayList<MProcess> MProcesses) {
        int time = 0;
        boolean finished = false;
        int stepSize = 2;
        MProcess lastProcess = null;

        ArrayList<MProcess> activeProcesses = new ArrayList<>();

        while (!finished) { //WOW

            //sind neue Prozesse aktiv?
            for (MProcess process : MProcesses) {
                if (!activeProcesses.contains(process)) {
                    if (process.getStart() <= time && !process.isFinished()) {
                        activeProcesses.add(process);
                        System.out.println("Process " + process.getName() + " is now in Queue at Time " + time + " with a duration of " + process.getDuration());
                    }

                }

                //sind fertige Prozesse in der aktiven Liste
                if (activeProcesses.contains(process) && process.getDurationLeft() <= 0) {
                    process.setFinished(true);
                    activeProcesses.remove(process);
                    System.out.println(process.getName() + " finished at Time: " + time + "\n\tIt took " + (time - process.getStart()) + " ms");
                }


            }

            //sind wir fertig?
            if (activeProcesses.isEmpty()) {
                finished = true;
                System.out.println("done\nTotal Time: " + time + "ms");
                break;

            }
            // kuerzesten Prozes finden
            int indexOfShortest = -1;

            for (int i = 0; i < activeProcesses.size(); i++) {
                if (indexOfShortest == -1) {
                    indexOfShortest = i;
                } else if (activeProcesses.get(indexOfShortest).getDuration() > activeProcesses.get(i).getDuration()) {
                    indexOfShortest = i;
                }
            }

            //Prozess "bearbeiten"
            if (activeProcesses.contains(lastProcess)) {
                lastProcess.lowerDurationBy(stepSize);
            } else {

                activeProcesses.get(indexOfShortest).lowerDurationBy(stepSize);

                lastProcess = activeProcesses.get(indexOfShortest);

            }

            /*Ausgabe
            System.out.println("Time: " + time + "ms");
            for (MProcess process : activeProcesses) {
                System.out.println("\t" + process.getName() + ", Time left: " + process.getDurationLeft() + "ms");
            }

*/
            //Die Zeit läuft
            time = time + stepSize;


        }

    }


    public static void FCFS(ArrayList<MProcess> MProcesses) {
        int time = 0;
        int index = 0;
        boolean finished = false;
        int stepSize = 2;

        ArrayList<MProcess> activeProcesses = new ArrayList<>();

        while (!finished) { //WOW

            //sind neue Prozesse aktiv?
            for (MProcess process : MProcesses) {
                if (!activeProcesses.contains(process)) {
                    if (process.getStart() <= time && !process.isFinished()) {
                        activeProcesses.add(process);
                        System.out.println("Process " + process.getName() + " is now in Queue at Time " + time + " with a duration of " + process.getDuration());
                    }

                }

                //sind fertige Prozesse in der aktiven Liste
                if (activeProcesses.contains(process) && process.getDurationLeft() <= 0) {
                    process.setFinished(true);
                    activeProcesses.remove(process);
                    System.out.println(process.getName() + " finished at Time: " + time + "\n\tIt took " + (time - process.getStart()) + " ms");
                }


            }


            //sind wir fertig?
            if (activeProcesses.isEmpty()) {
                finished = true;
                System.out.println("done\nTotal Time: " + time + "ms");
                break;

            }

            //Prozess "bearbeiten"
            activeProcesses.get(index).lowerDurationBy(stepSize);


            /*Ausgabe
            System.out.println("Time: " + time + "ms");
            for (MProcess process : activeProcesses) {
                System.out.println("\t" + process.getName() + ", Time left: " + process.getDurationLeft() + "ms");
            }
*/

            //Die Zeit läuft
            time = time + stepSize;


        }

    }

    public static void RoundRobin(ArrayList<MProcess> MProcesses) {
        int time = 0;
        int index = 0;
        boolean finished = false;
        int stepSize = 2;

        ArrayList<MProcess> activeProcesses = new ArrayList<>();


        while (!finished) { //WOW

            //sind neue Prozesse aktiv?
            for (MProcess process : MProcesses) {
                if (!activeProcesses.contains(process)) {
                    if (process.getStart() <= time && !process.isFinished()) {
                        activeProcesses.add(process);
                        System.out.println("Process " + process.getName() + " is now in Queue at Time " + time + " with a duration of " + process.getDuration());
                    }

                }

                //sind fertige Prozesse in der aktiven Liste
                if (activeProcesses.contains(process) && process.getDurationLeft() <= 0) {
                    process.setFinished(true);
                    activeProcesses.remove(process);
                    System.out.println(process.getName() + " finished at Time: " + time + "\n\tIt took " + (time - process.getStart()) + " ms");
                }


            }

            //roundRobin....wieder nach vorne springen
            if (activeProcesses.size() <= index) {
                index = 0;
            }

            //sind wir fertig?
            if (activeProcesses.isEmpty()) {
                finished = true;
                System.out.println("done\nTotal Time: " + time + "ms");
                break;

            }

            //Prozess "bearbeiten"
            activeProcesses.get(index).lowerDurationBy(stepSize);


            index++;

            /*Ausgabe
            System.out.println("Time: " + time + "ms");
            for (MProcess process : activeProcesses) {
                System.out.println("\t" + process.getName() + ", Time left: " + process.getDurationLeft() + "ms");
            }
            */

            //Die Zeit läuft
            time = time + stepSize;


        }


    }


}
