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
		
		for (String line : fileLines) {
//			System.out.println(string);
			regexCkecher("", line);
		}
		
	}
	
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
