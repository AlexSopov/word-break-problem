import org.junit.Assert;
import org.junit.Test;
import usage.MetrcisCollector;

public class MetricsCollectorTest {
    @Test
    public void MetricCollectorsGetsTimeCorrect() {
        MetrcisCollector metricsCollector = new MetrcisCollector();
        metricsCollector.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Assert.fail();
        }
        metricsCollector.end();

        long time = metricsCollector.getTime();
        Assert.assertTrue(time > 700 && time < 1300);
    }

    @Test
    public void MetricCollectorGetsNotNegativeMemory() {
        MetrcisCollector metricsCollector = new MetrcisCollector();
        metricsCollector.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Assert.fail();
        }
        metricsCollector.end();

        long memory = metricsCollector.getUsedMemory();
        Assert.assertTrue(memory >= 0);
    }

    @Test
    public void MetricCollectorsReturnsNotEmptyVelues() {
        MetrcisCollector metricsCollector = new MetrcisCollector();
        metricsCollector.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Assert.fail();
        }
        metricsCollector.end();

        Assert.assertNotEquals(metricsCollector.getMetricsString(), "");
    }
}
