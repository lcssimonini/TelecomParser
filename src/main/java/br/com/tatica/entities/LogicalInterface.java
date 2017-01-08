package br.com.tatica.entities;

// interface lógica com sua regex de descrição
public class LogicalInterface {

	public static String descriptionPattern = "\\w{1,}-\\d{1,2}/\\d{1,2}/\\d{1,2}.\\d{1,}";

	private String description;

	public LogicalInterface(String description) {
		this.description = description;
	}

	public String getDescription() {
		return description;
	}

	public String getPhysicalPrefix() {
		return description.substring(0, description.indexOf("."));
	}

	@Override
	public String toString() {
		return "Logical interface: " + this.description;
	}
}
