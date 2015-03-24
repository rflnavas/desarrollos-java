package com.mongoapp.test;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Stream;

public class Test {
	public static void main(String[] args) {
		List<Integer> li = new LinkedList<>();
		li.add(1);li.add(2);li.add(6);li.add(3);li.add(5);
		System.out.println(li.toString());
		
		li.stream().filter(u -> u%2 == 0).forEach(u->System.out.println(u));
		
		String msg = String.format("%s %s %s", 1, "r", new Date());
		System.out.println(msg);
	}
}
