package apcsa;

public class DefaultMill extends LumberMill{
	// DefaultMill (NOT a Validator)
	// 1. DefaultMill implements chop() by looking through the instance variable for
	// the substring "o". Whenever it finds an "o" that is not followed by an "o" OR
	// "d", it swaps the "o" with the next character.

	public DefaultMill(String str) {
		super(str);
	}
	
	public void chop() {
		String str = getStr();
		int index = str.indexOf("o");
		while(index !=-1) {
			if(index==str.length()-1) {
				index = -1;
			}else if(index == 0) {
				str = str.substring(index+1, index+2) + str.substring(index, index+1) + str.substring(index+2);
				index = str.indexOf("o", index+2);
			}else if(str.substring(index+1, index+2).equals("o")  || str.substring(index+1, index+2).equals("d")) {
				index = str.indexOf("o", index+1);
			}else {
				str = str.substring(0, index) + str.substring(index+1, index+2) + str.substring(index, index+1) + str.substring(index+2);
				index = str.indexOf("o", index+2);
			}
			setStr(str);
		}

	}
}
