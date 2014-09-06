package com.calculadoraromanos;

public class Roman {
	
	private int value=0; 
	private String Visual; 
	
	Roman (int Value, String Vis){
	this.value=Value; 
	this.Visual=Vis; 
	}
	
	public String getVis(){
		return Visual;		
	}
	public int getValue(){
		return value;		
	}

	public void setValue(int vl) {
	this.value=vl; 		
	}
	
}
