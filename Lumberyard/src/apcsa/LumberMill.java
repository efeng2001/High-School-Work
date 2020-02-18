package apcsa;

public abstract class LumberMill {

	// LumberMill
	// 1. LumberMill's constructor takes one parameter, a String, and stores this
	// String in an instance variable
	// 2. LumberMill has one abstract method, chop(), that has no parameters or
	// return value
	// 3. LumberMill has a non-abstract method, woodify(), that has no parameters
	// or return value. This method replaces all occurrences of "plastic" in the
	// instance variable with "owod" AND all occurrences of "mercury" in the
	// instance variable with "chuck".
	// 4. LumberMill also has two non-abstract methods, getStr() and setStr(String
	// str), that get or set the value of the instance variable. 
	
	private String str;
	
	public LumberMill(String str) {
		this.str = str;
	}
	
	public abstract void chop();
	
	public void woodify() {
		while(str.indexOf("plastic")!=-1) {
			str = str.substring(0, str.indexOf("plastic")) + "owod" + str.substring(str.indexOf("plastic")+7);
		}
		while(str.indexOf("mercury")!=-1) {
			str = str.substring(0, str.indexOf("mercury")) + "chuck" + str.substring(str.indexOf("mercury")+7);
		}
	}
	
	public String getStr() {
		return str;
	}
	
	public void setStr(String str) {
		this.str = str;
	}
	
	
	
}
