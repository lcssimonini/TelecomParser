package br.com.tatica.entities;

import java.util.HashMap;
import java.util.Map;

public class InterfacesDB {
	
	private static Map<String, PhysicalInterface> physicalInterfaces = new HashMap<String,PhysicalInterface>();
	
	public static void addPhysicalInterface(PhysicalInterface physicalInterface) {
		physicalInterfaces.put(physicalInterface.getDescription(), physicalInterface);
	}
	
	public static void addLogicalInterface(LogicalInterface logicalInterface) {
		PhysicalInterface physicalInterface = physicalInterfaces.get(logicalInterface.getPhysicalPrefix());
		
		if (physicalInterface != null) {
			physicalInterface.addLogicalInterface(logicalInterface);
		}
	}
	
	public static void printAllInterfaces() {
		for (PhysicalInterface physicalInterface : physicalInterfaces.values()) {
			System.out.println(physicalInterface.toString());
			System.out.println("=========================================");
		}
	}
}
