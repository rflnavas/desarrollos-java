package java7training.patterns;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestingPatterns1 {
	public static void main(String[] args) {
		//possibly yesterday
		//It works 2 erfectly and flawlessly. Nice!
		Pattern p = Pattern.compile("\\wy\\b");
		Matcher m = p.matcher("possibly  ly yesterday");
		
		while(m.find()){
			System.out.println(m.start() + ":" +  m.group());
		}
		
		String talk = "Pick a little, talk a little, pick a little, talk a"+
		"little, cheep cheep cheep, talk a lot, pick a little more";
		String eat = talk.replaceAll("talk","eat").replace("cheep", "burp");
		System.out.println(eat);
	}
}


















