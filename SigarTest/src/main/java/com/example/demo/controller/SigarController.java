package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SigarController {

	@GetMapping("/hello")
	public String hello() {
		return "testing";
	}
	
	private final Sigar sigar;

    public SigarController() {
        this.sigar = new Sigar();
    }

    @GetMapping("/cpu-usage")
    public double getCpuUsage() throws SigarException {
        CpuPerc cpuPerc = sigar.getCpuPerc();
        return cpuPerc.getCombined() * 100; // CPU usage as a percentage
    }
}
