package com.bookstoreapi.config;

import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Scheduled;

@Configuration
public class MetricsConfig {

    @Bean
    public CustomMetrics customMetrics(MeterRegistry meterRegistry) {
        return new CustomMetrics(meterRegistry);
    }

    public static class CustomMetrics {

        private final MeterRegistry meterRegistry;

        public CustomMetrics(MeterRegistry meterRegistry) {
            this.meterRegistry = meterRegistry;
            initializeMetrics();
        }

        private void initializeMetrics() {
            // Example: Counter metric
            meterRegistry.counter("books.total", "type", "total");
        }

        @Scheduled(fixedRate = 60000)
        public void updateCustomMetrics() {
            // Example: Gauge metric
            meterRegistry.gauge("books.active", 100);
        }
    }
}
