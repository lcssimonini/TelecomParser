package br.com.tatica.entities;

import java.util.ArrayList;
import java.util.List;

//interface física com sua regex de descrição
public class PhysicalInterface {

	public static String descriptionPattern = "\\w{1,}-\\d{1,2}/\\d{1,2}/\\d{1,2},";

	private String description;
	private List<LogicalInterface> logicalInterfaces = null;

	public PhysicalInterface(String description) {
		this.description = description.substring(0, description.length() - 1);
		this.logicalInterfaces = new ArrayList<LogicalInterface>();
	}

	public void addLogicalInterface(LogicalInterface logicalInterface) {
		this.logicalInterfaces.add(logicalInterface);
	}

	public String getDescription() {
		return description;
	}

	@Override
	public String toString() {
		String eol = System.lineSeparator();
		StringBuilder builder = new StringBuilder();
		builder.append("Interface física: " + this.description + eol);

		if (this.logicalInterfaces.isEmpty()) {
			builder.append("nenhuma interface lógica" + eol);
		} else {
			builder.append("Interfaces Lógicas: " + eol);
			for (LogicalInterface logicalInterface : this.logicalInterfaces) {
				builder.append(logicalInterface.getDescription() + eol);
			}
		}

		return builder.toString();
	}
}
