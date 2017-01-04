package br.com.tatica.entities;

import java.util.HashMap;
import java.util.Map;

public class InterfacesDB {
	
	private static InterfacesDB instance;
	private static Map<String, PhysicalInterface> physicalInterfaces;
	
	private InterfacesDB() {
		physicalInterfaces = new HashMap<String,PhysicalInterface>();
	}
	
	public static InterfacesDB get() {
		if (InterfacesDB.instance == null) {
			InterfacesDB.instance = new InterfacesDB();
		}
		return InterfacesDB.instance;
	}
	
	public static void addPhysicalInterface(PhysicalInterface physicalInterface) {
		physicalInterfaces.put(physicalInterface.getDescription(), physicalInterface);
	}
	
	public static void addLogicalInterface(LogicalInterface logicalInterface) {
		PhysicalInterface physicalInterface = null;
		physicalInterface = physicalInterfaces.get(logicalInterface.getPhysicalPrefix());
		
		if (physicalInterface != null) {
			physicalInterface.addLogicalInterface(logicalInterface);
		}
	}
}
