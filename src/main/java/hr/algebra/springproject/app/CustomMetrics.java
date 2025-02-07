package hr.algebra.springproject.app;

import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.Timer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadMXBean;

@Component
public class CustomMetrics {

    private final MeterRegistry meterRegistry;


    @Autowired
    public CustomMetrics(MeterRegistry meterRegistry) {
        this.meterRegistry = meterRegistry;
        Timer.builder("thread.count")
                .description("Number of active threads")
                .register(meterRegistry);
    }

    @Scheduled(fixedRate = 5000)
    public void recordActiveThreads() {
        ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();
        meterRegistry.gauge("thread.count", threadMXBean.getThreadCount());
    }
}