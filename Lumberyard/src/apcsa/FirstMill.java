package apcsa;

public class FirstMill extends LumberMill implements Validator{
	// FirstMill (Validator)
	// 1. DefaultMill overrides woodify(), which replaces the FIRST occurrence of
	// "could" in the instance variable with "wood".
	// 2. DefaultMill implements chop(), which reverses order of the characters in
	// the instance variable
	// 3. The method choppable() returns true if the instance variable has a length
	// of at least 20.
	
	public FirstMill(String str) {
		super(str);
	}
	
	public void woodify() {
		String str = getStr();
		int index = str.indexOf("could");
		if(index != -1) {
			str = str.substring(0, index) + "wood" + str.substring(index+5);
		}
		setStr(str);
	}
	
	public void chop() {
		String str = getStr();
		String temp = "";
		for (int i = str.length()-1; i >=0; i--) {
			temp += str.substring(i,  i+1);
		}
		str = temp;
		setStr(str);
	}
	
	public boolean choppable() {
		String str = getStr();
		if(str.length()>=20) {
			return true;
		}
		return false;
	}
}
