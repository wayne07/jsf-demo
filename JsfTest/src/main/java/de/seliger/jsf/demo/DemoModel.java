package de.seliger.jsf.demo;

import javax.inject.Named;

@Named
public class DemoModel {

	public String getHelloWorld() {
		System.out.println("Test");
		return "Hallo Welt: Es grüsst das Bean!";
	}
	
}
