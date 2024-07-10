package com.example.demo.config;

import java.lang.management.ManagementFactory;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.sun.management.OperatingSystemMXBean;

import io.micrometer.core.instrument.MeterRegistry;

@Configuration
public class MetricsConfig {
	@Bean
	MeterRegistryCustomizer<MeterRegistry> metricsCommonTags() {
		return registry -> registry.config().commonTags("application", "your-application-name");
	}
}

class SystemMetricsService {
	public double getCPUUsage() {
		OperatingSystemMXBean operatingSystemMXBean = (OperatingSystemMXBean) ManagementFactory
				.getOperatingSystemMXBean();
		return operatingSystemMXBean.getSystemCpuLoad();
	}
}