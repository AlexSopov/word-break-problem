package usage;

public class MetrcisCollector {
    private long startTime, endTime, startMemory, endMemory;

    public void Start() {
        startTime = System.currentTimeMillis();
        Runtime runtime = Runtime.getRuntime();
        startMemory = runtime.totalMemory() - runtime.freeMemory();
    }
    public void End() {
        endTime = System.currentTimeMillis();
        Runtime runtime = Runtime.getRuntime();
        endMemory = runtime.totalMemory() - runtime.freeMemory();
    }

    public long getTime() {
        return endTime - startTime;
    }

    public long getUsedMemory() {
        Runtime runtime = Runtime.getRuntime();
        runtime.gc();

        return endMemory - startMemory;
    }

    public String getMetricsString() {
        return "Total time (ms): " + getTime() + "\n" +
                "Total memory (b) : " + getUsedMemory() + "\n";
    }
}
