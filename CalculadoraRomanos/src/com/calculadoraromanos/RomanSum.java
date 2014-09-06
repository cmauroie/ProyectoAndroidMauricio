package com.calculadoraromanos;

import android.util.Log;

public class RomanSum {
	
	
    private	String Add1; 
    private String Add2; 
    private String Result; 
    private int iAdd1; 
    private int iAdd2; 
    private int iResult; 
	
	public RomanSum(String add1, String add2) {
		this.Add1=add1; 
		this.Add2=add2; 
		this.iAdd1=convertRomToInt(Add1); 
		this.iAdd2=convertRomToInt(Add2);
		this.iResult=iAdd1+iAdd2;
		Log.i("Add1", ""+Add1);
		Log.i("Add2", ""+Add2); 

		Log.i("iResult", ""+iResult); 
		this.Result=convertIntToRom(iResult); 
		Log.i("Result", Result); 
	
	}
	public RomanSum(String Sigleroman){
		this.iResult=convertRomToInt(Sigleroman); 
	}
	
	public int getIntResult(){
		return iResult; 
	}
	public String getStringResult(){
		return Result; 
	}
	
	private String convertIntToRom(int input){
		
	    if (input < 1 || input > 3999)
	        return "Numero Romano >3999";
	    String s = "";
	    while (input >= 1000) {
	        s += "M";
	        input -= 1000;        }
	    while (input >= 900) {
	        s += "CM";
	        input -= 900;
	    }
	    while (input >= 500) {
	        s += "D";
	        input -= 500;
	    }
	    while (input >= 400) {
	        s += "CD";
	        input -= 400;
	    }
	    while (input >= 100) {
	        s += "C";
	        input -= 100;
	    }
	    while (input >= 90) {
	        s += "XC";
	        input -= 90;
	    }
	    while (input >= 50) {
	        s += "L";
	        input -= 50;
	    }
	    while (input >= 40) {
	        s += "XL";
	        input -= 40;
	    }
	    while (input >= 10) {
	        s += "X";
	        input -= 10;
	    }
	    while (input >= 9) {
	        s += "IX";
	        input -= 9;
	    }
	    while (input >= 5) {
	        s += "V";
	        input -= 5;
	    }
	    while (input >= 4) {
	        s += "IV";
	        input -= 4;
	    }
	    while (input >= 1) {
	        s += "I";
	        input -= 1;
	    }    
	    return s;
	}
	  
	 	
	
	private static int convertRomToInt(String romanNum) {
		 
		 int result = 0;
		 int mediator = 0;
		 
		 int length = romanNum.length();  
		 
		   
		 for (int i = 0; i < length - 1; i++) {     
		 
		  if (getInt(romanNum.charAt(i)) > getInt(romanNum.charAt(i + 1))) {
		 
		   result = result + getInt(romanNum.charAt(i)) + mediator;
		   mediator = 0;
		 
		  } else if (getInt(romanNum.charAt(i)) == getInt(romanNum.charAt(i + 1))) {
		 
		   mediator = mediator + getInt(romanNum.charAt(i));
		 
		  } else if (getInt(romanNum.charAt(i)) < getInt(romanNum.charAt(i + 1))) {
		 
		   mediator = -mediator - getInt(romanNum.charAt(i));
		 
		  }
		 
		 }
		 
		 result = result + mediator + getInt(romanNum.charAt(length - 1));
		 
		 return result;
		 
		}
		 
		private static int getInt(char romanChar) {
		 
		 if (romanChar == 'I')
		  return 1;
		 else if (romanChar == 'V') {
		  return 5;
		 } else if (romanChar == 'X') {
		  return 10;
		 } else if (romanChar == 'L') {
		  return 50;
		 } else if (romanChar == 'C') {
		  return 100;
		 } else if (romanChar == 'D') {
		  return 500;
		 } else if (romanChar == 'M') {
		  return 1000;
		 }
		 return (Integer) null;
		}	
	

}
