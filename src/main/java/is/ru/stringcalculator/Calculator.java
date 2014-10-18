package is.ru.stringcalculator;

import java.util.ArrayList;

public class Calculator {

	public static int add(String text){
			String delimeter = ",|\n";
			if(text.startsWith("//")){
				delimeter = text.substring(2,3);
				text = text.substring(4);
				return sum(splitNumbers(text, delimeter));
			}
			else if(text.equals("")){
				return 0;
			}
			else if(text.contains(",")||(text.contains("\n"))){
				return sum(splitNumbers(text, delimeter));
			}
			else
				return 1;
	}

	private static int toInt(String number){
		return Integer.parseInt(number);
	}

	private static String[] splitNumbers(String numbers, String delimeter){
	return numbers.split(delimeter);
	}

	private static int sum(String[] numbers){
		int  total = 0;
		ArrayList<Integer> al = new ArrayList<Integer>();		
		for(String number : numbers){
			int numberToInt = toInt(number);
			if(numberToInt < 0){
				al.add(numberToInt);
			}
			total += numberToInt;
		}
		if(al.size() != 0){
			throw new IllegalArgumentException("Negative number not allowed: " + al.toString());
		}
		return total;
	}
}