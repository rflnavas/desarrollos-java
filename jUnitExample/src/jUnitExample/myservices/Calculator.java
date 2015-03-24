package jUnitExample.myservices;

public class Calculator {
	
	
	public static final int add(String numbers){
		if(numbers == null || "".equals(numbers.trim())){
			return 0;
		}else{
			String [] tokenNumbers = numbers.split(",");
			if(tokenNumbers.length > 0){
				int val = 0;
				for(int  i = 0 ; i < tokenNumbers.length; i++){
					int num = Integer.parseInt(tokenNumbers[i]);
					val += num;
				}
				
				return val;
			}else{
				throw new RuntimeException("Sólo 2 números como máximo");
			}
		}
	}
	
	public static int add(int a, int b){
		return a + b;
	}
	
	public static double divide(double a, double b){
		return a/b;
	}
	
	public int add(){
		return 0;
	}
	
}
