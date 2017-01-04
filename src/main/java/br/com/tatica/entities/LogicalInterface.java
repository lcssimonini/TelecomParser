package br.com.tatica.entities;

public class LogicalInterface {
	
	public static String descriptionPattern = "\\w{1,}-\\d{1,2}/\\d{1,2}/\\d{1,2}.\\d{1,}";
	public static String linePattern = "Logical interface\\s" + descriptionPattern;
	
	private String description;
	
	public LogicalInterface(String description) {
		this.description = description;
	}

	public String getDescription() {
		return description;
	}
	
	public String getPhysicalPrefix() {
		return description.substring(0, description.indexOf(".") + 1);
	}
}
