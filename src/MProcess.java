public class MProcess {

    private int duration, priority, start;

    private int durationLeft;
    private boolean finished;
    private String name;

    public MProcess(int duration, int priority, int start, String name){
        this.duration = duration;
        this.priority = priority;
        this.start = start;
        this.name = name;
        this.durationLeft = duration;
        finished = false;

    }

    public String getName() {
        return name;
    }

    public boolean isFinished() {
        return finished;
    }

    public void setFinished(boolean finished) {
        this.finished = finished;
    }

    public void setDurationLeft(int durationLeft) {
        this.durationLeft = durationLeft;
    }

    public int getDurationLeft() {
        return durationLeft;
    }

    public int getDuration() {
        return duration;
    }

    public int getPriority() {
        return priority;
    }

    public int getStart() {
        return start;
    }

    public void lowerDurationBy(int by) {
        this.durationLeft = this.durationLeft - by;
    }
}
