package br.com.tatica.entities;

import java.util.List;

public class PhysicalInterface {
	
	public static String descriptionPattern = "Physical interface:\\s\\w{1,}-\\d{1,2}/\\d{1,2}/\\d{1,2}";
	public static String linePattern = "Physical interface:\\s" + descriptionPattern;
	private String description;
	private List<LogicalInterface> logicalInterfaces;
	
	public PhysicalInterface(String description){
		this.description = description;
	}
	
	public void addLogicalInterface(LogicalInterface logicalInterface) {
		logicalInterfaces.add(logicalInterface);
	}

	public String getDescription() {
		return description;
	}
	
	@Override
	public String toString() {
		String eol = System.lineSeparator();
		StringBuilder builder = new StringBuilder();
		builder.append("Interface física: "+ this.description + eol);
		builder.append("Interfaces Lógicas: " + eol);
		
		for (LogicalInterface logicalInterface : logicalInterfaces) {
			builder.append(logicalInterface.getDescription() + eol);
		}
		
		return builder.toString();
	}
}
