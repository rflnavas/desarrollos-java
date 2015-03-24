package com.rnr.springtutorial.beans;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(value="prototype")
public class Gun{
	
	private int zoom;
	
	public Gun() {
	}
	

	/* (non-Javadoc)
	 * @see com.rnr.springtutorial.beans.Weapon#shoot()
	 */
	public void shoot() throws Exception {
		System.out.println("BANG!");
		
		throw new Exception("The gun doesn't work!");
	}
	
	public void shoot(int bullets){
		StringBuffer sb = new StringBuffer();
		for(int i = 0 ; i < bullets ; i++){
			sb.append("Bang! ");
		}
		System.out.println(sb.toString());
	}
	
	public void shoot(String param){
		System.out.println("param : " + param);
	}


	public int getZoom() {
		return zoom;
	}

	public void setZoom(int zoom) {
		this.zoom = zoom;
	}
	
	public void reload() {
		System.out.println("Reloading!");
	}
	
	public static void showUselessText(){
		System.out.println("This is an ordinary gun");
	}
	
}
