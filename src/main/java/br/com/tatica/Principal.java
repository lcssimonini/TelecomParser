package br.com.tatica;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;

import br.com.tatica.entities.InterfacesDB;
import br.com.tatica.entities.LogicalInterface;
import br.com.tatica.entities.PhysicalInterface;

public class Principal {
	
	// A classe main foi utilizada para fazer a leitura do arquivo e popular as classes PhysicalInterface e 
	// LogicalInterface caso sejam encontrados seus padrões no arquivo
	public static void main(String[] args) throws IOException {

		List<String> fileLines = Files.readAllLines(Paths.get("a-bb-rt-vrd-001-mx80.txt"));

		for (String line : fileLines) {
			String physicalPatternFound = patternFinder(PhysicalInterface.descriptionPattern, line);

			if (!StringUtils.isEmpty(physicalPatternFound)) {
				PhysicalInterface physicalInterface = new PhysicalInterface(physicalPatternFound);
				InterfacesDB.addPhysicalInterface(physicalInterface);
			}

			String logicalPatternFound = patternFinder(LogicalInterface.descriptionPattern, line);
			if (!StringUtils.isEmpty(logicalPatternFound)) {
				LogicalInterface logicalInterface = new LogicalInterface(logicalPatternFound);
				InterfacesDB.addLogicalInterface(logicalInterface);
			}
		}

		InterfacesDB.printAllInterfaces();
	}

//	verifica se a análise da regex retorna resultado
	private static String patternFinder(String regex, String source) {

		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(source);
		String resultado = "";
		
		while (matcher.find()) {
			if (!StringUtils.isEmpty(matcher.group())) {
				resultado = matcher.group();
			}
		}

		return resultado;
	}
}
