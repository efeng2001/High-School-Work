package apcsa;

import java.util.ArrayList;
import java.util.List;

public class Main
{
	public static void main(String[] args)
	{
		List<LumberMill> lumberMills = new ArrayList<>();
		lumberMills.add(new LastMill("much How"));
		lumberMills.add(new DefaultMill("plastic oculd a plasticmercury mercury if a plasticmercury"));
		lumberMills.add(new LastMill("could chuck could?"));
		lumberMills.add(new FirstMill(",wap elttil sih ni was a dleh eh fI"));
		lumberMills.add(new DefaultMill("a otn"));
		lumberMills.add(new FirstMill("of could he could."));

		for(LumberMill mill: lumberMills) {
			mill.woodify();
		}
		
		for(LumberMill mill: lumberMills) {
			if(mill instanceof Validator) {
				if(((Validator) mill).choppable()) {
						mill.chop();
				}
			}else {
				mill.chop();
			}
		}
		
		for(LumberMill mill: lumberMills) {
			System.out.print(mill.getStr() + " ");
		}
		
		// TODO: Create the following:
		// 1. An abstract class called LumberMill
		// 2. An interface called Validator
		// 2. Three subclasses of LumberMill called DefaultMill, FirstMill, and LastMill
		// 3. FirstMill & LastMill are also Validators. DefaultMill is NOT a Validator.

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

		// Validator
		// Validator has one method, choppable(), which has no parameters or return
		// value

		// DefaultMill (NOT a Validator)
		// 1. DefaultMill implements chop() by looking through the instance variable for
		// the substring "o". Whenever it finds an "o" that is not followed by an "o" OR
		// "d", it swaps the "o" with the next character.

		// FirstMill (Validator)
		// 1. DefaultMill overrides woodify(), which replaces the FIRST occurrence of
		// "could" in the instance variable with "wood".
		// 2. DefaultMill implements chop(), which reverses order of the characters in
		// the instance variable
		// 3. The method choppable() returns true if the instance variable has a length
		// of at least 20.

		// LastMill (Validator)
		// 1. LastMill overrides woodify(), which replaces LAST occurrence of
		// "could" in the instance variable with "wood".
		// 2. LastMill implements chop() by swapping the first and last word in the
		// instance variable
		// 3. choppable() returns true if there are only two words in the instance
		// variable

		// TODO: For each LumberMill in lumberMills, first run woodify() then run
		// chop().

		// TODO: For LumberMills that are also Validators, only run chop() if choppable() returns true

		// TODO: Print out each String from lumberMills followed by a space. If the
		// message makes sense and there are no spelling mistakes, then you've succeded!
	}
}
