package apcsa;

public class LastMill extends LumberMill implements Validator{
	// LastMill (Validator)
	// 1. LastMill overrides woodify(), which replaces LAST occurrence of
	// "could" in the instance variable with "wood".
	// 2. LastMill implements chop() by swapping the first and last word in the
	// instance variable
	// 3. choppable() returns true if there are only two words in the instance
	// variable
	public LastMill(String str) {
		super(str);
	}
	
	public void woodify() {
		String str = getStr();
		int index = str.indexOf("could");
		if(index != -1) {
			while(str.indexOf("could", index+1) != -1) {
				index = str.indexOf("could", index+1); 
			}
			str = str.substring(0, index) + "wood" + str.substring(index+5);
			
		}
		setStr(str);
	}
	
	public void chop(){
		String str = getStr();
		int index = str.indexOf(" ");
		str = str.substring(index+1) + " " +str.substring(0, index);
		setStr(str);
	}
	
	public boolean choppable() {
		String str = getStr();
		int count = 0;
		int index = str.indexOf(" ");
		while(index != -1) {
			index = str.indexOf(" ", index+1);
			count++;
		}
		if(count == 1) {
			return true;
		}
		return false;
	}
	
}
