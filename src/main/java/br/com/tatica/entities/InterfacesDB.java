package br.com.tatica.entities;

import java.util.ArrayList;
import java.util.List;

public class InterfacesDB {
	
	private static InterfacesDB instance;
	private static List<PhysicalInterface> physicalInterfaces;
	
	private InterfacesDB() {
		physicalInterfaces = new ArrayList<PhysicalInterface>();
	}
	
	public static InterfacesDB get() {
		if (InterfacesDB.instance == null) {
			InterfacesDB.instance = new InterfacesDB();
		}
		return InterfacesDB.instance;
	}
	
	public static void addInterface(PhysicalInterface physicalInterface) {
		physicalInterfaces.add(physicalInterface);
	}
}
