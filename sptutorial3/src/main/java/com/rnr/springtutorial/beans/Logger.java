package com.rnr.springtutorial.beans;

public class Logger {
	
	
	public void logGun(){
		System.out.println("Gun has been used!");
	}
	
	public void chargingSpecialBullet(){
		System.out.println("Reloading gun with special bullets");
	}
	
	public void aboutToShoot() {
		System.out.println("About to shoot...");
	}
	
	public void shot(){
		System.out.println("--->");
	}

}
