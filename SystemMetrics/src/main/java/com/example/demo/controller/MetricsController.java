package com.example.demo.controller;

import java.lang.management.ManagementFactory;
import java.util.Map;

import javax.management.AttributeNotFoundException;
import javax.management.InstanceNotFoundException;
import javax.management.MBeanException;
import javax.management.MalformedObjectNameException;
import javax.management.ObjectName;
import javax.management.ReflectionException;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MetricsController {
	@SuppressWarnings("unchecked")
	@GetMapping("/metrics")
    public Map<String, Object> getMetrics() {
    	
        try {
			return (Map<String, Object>) ManagementFactory
					.getPlatformMBeanServer()
					.getAttribute(ObjectName
							.getInstance("java.lang:type=OperatingSystem"), "SystemMetrics");
		} catch (InstanceNotFoundException | AttributeNotFoundException | MalformedObjectNameException
				| ReflectionException | MBeanException | NullPointerException e) {
			e.printStackTrace();
		}
		return null;
    }
}