package br.com.tatica;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;

public class Principal {
	
	public static void main(String[] args) throws IOException {
		
		List<String> fileLines = Files.readAllLines(Paths.get("a-bb-rt-vrd-001-mx80.txt"));
		
//		a-bb-rt-vrd-001-mx80
//		String regexPhysicalInterface = "Physical interface:\\s\\w{1,}-\\d{1,2}/\\d{1,2}/\\d{1,2}";
//		String regexLogicalInterface = "Logical interface\\s\\w{1,}-\\d{1,2}/\\d{1,2}/\\d{1,2}.\\d{1,}";
		
		String regexPhysicalInterface = "\\w{1,}-\\d{1,2}/\\d{1,2}/\\d{1,2}";
		String regexLogicalInterface = "\\w{1,}-\\d{1,2}/\\d{1,2}/\\d{1,2}.\\d{1,}";
		
		for (String line : fileLines) {
//			System.out.println(string);
			regexCkecher(regexPhysicalInterface, line);
			regexCkecher(regexLogicalInterface, line);
		}
		
	}
	
//	 Physical interface: lc-0/0/0,
//	 Logical interface pfe-0/0/0.16383 
	private static void regexCkecher(String regex, String source) {
		
		Pattern pattern = Pattern.compile(regex);
		
		Matcher matcher = pattern.matcher(source);
		
		while(matcher.find()) {
			if (!StringUtils.isEmpty(matcher.group())) {
				System.out.println(matcher.group());
			}
		}
	}

}
