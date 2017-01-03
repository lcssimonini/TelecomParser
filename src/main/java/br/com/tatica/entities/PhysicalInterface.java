package br.com.tatica.entities;

import java.util.List;

public class PhysicalInterface {
	
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
		builder.append(this.description + eol);
		
		for (LogicalInterface logicalInterface : logicalInterfaces) {
			builder.append(logicalInterface.getDescription() + eol);
		}
		
		return builder.toString();
	}
}
