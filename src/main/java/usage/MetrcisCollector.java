package usage;

public class MetrcisCollector {
    private long startTime, endTime, startMemory, endMemory;

    public void start() {
        startTime = System.currentTimeMillis();
        Runtime runtime = Runtime.getRuntime();
        startMemory = runtime.totalMemory() - runtime.freeMemory();
    }
    public void end() {
        endTime = System.currentTimeMillis();
        Runtime runtime = Runtime.getRuntime();
        endMemory = runtime.totalMemory() - runtime.freeMemory();
    }

    public long getTime() {
        return endTime - startTime;
    }

    public long getUsedMemory() {
        return endMemory - startMemory;
    }

    public String getMetricsString() {
        return "Total time (ms): " + getTime() + "\n" +
                "Total memory (b) : " + getUsedMemory() + "\n";
    }
}
