package common;
import java.text.DecimalFormat;
public class StringCommon {
	public static String convertNumberToString(long number, int digit) {
		number = number + 10000000000000000L; // 16 chá»¯ sá»‘ 0
		
		String returnedStr = String.valueOf(number); // CÃ³ chiá»�u dÃ i lÃ  17 chá»¯ sá»‘
		return returnedStr.substring(returnedStr.length() - digit);
    }
	public static String convertDoubleToString(double d) {
		return new DecimalFormat("#").format(d);
	}
	public static String convertDoubleToStringWithComma(double d) {
		return new DecimalFormat("###,###").format(d);
	}


	public static void main(String[] args) {
		System.out.println(convertNumberToString(12378, 9));
	}
}
