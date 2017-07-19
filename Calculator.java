package git.Calculator;

public class Calculator {

	public static void main(String[] args) {
		System.out.println(parseTerm("1*2+2*-8"));
	}

	public static int findLastMinus(String s, int lastIndex) {
		int index = s.lastIndexOf('-', lastIndex);
		if (index <= 0) // -1: can't find -ve sign; 0: 1st num is -ve
			return -1;
		else if (s.charAt(index - 1) == '+' || s.charAt(index - 1) == '-' || s.charAt(index - 1) == '*'
				|| s.charAt(index - 1) == '/')
			return findLastMinus(s, index - 1);
		else
			return index;
	}

	public static String parseTerm(String evaluate) {

		int opIndex = evaluate.length() - 1;
		if (evaluate.contains("+")) {
			if (opIndex == evaluate.length() - 1 || evaluate.lastIndexOf('+') > opIndex)
				opIndex = evaluate.lastIndexOf('+');
		}
		if (evaluate.contains("-")) {
			int tmp = findLastMinus(evaluate, evaluate.length() - 1);
			if ((opIndex == evaluate.length() - 1 || tmp > opIndex) && tmp != -1) {
				opIndex = tmp;
			}
		}
		if (opIndex == evaluate.length() - 1) {
			return parseFactor(evaluate);
		} else {
			String left = parseTerm(evaluate.substring(0, opIndex));
			String right = parseTerm(evaluate.substring(opIndex + 1));
			return opAddSub(parseTerm(left), parseTerm(right), evaluate.charAt(opIndex));
		}
	}

	public static String parseFactor(String evaluate) {
		int opIndex = evaluate.length() - 1;
		if (evaluate.contains("*")) {
			if (opIndex == evaluate.length() - 1 || evaluate.lastIndexOf('*') > opIndex)
				opIndex = evaluate.lastIndexOf('*');
		}
		if (evaluate.contains("/")) {
			if (opIndex == evaluate.length() - 1 || evaluate.lastIndexOf('/') > opIndex) {
				opIndex = evaluate.lastIndexOf('/');
			}
		}
		if (opIndex == evaluate.length() - 1) {
			return evaluate;
		} else {
			String left = parseTerm(evaluate.substring(0, opIndex));
			String right = parseTerm(evaluate.substring(opIndex + 1));
			return opMulDiv(parseFactor(left), parseFactor(right), evaluate.charAt(opIndex));
		}
	}

	public Double calculate(String evaluate) {
		// TODO Auto-generated method stub
		if (evaluate.isEmpty()) {
			return new Double(0);
		}
		return Double.parseDouble(parseTerm(evaluate));
	}

	public static String opAddSub(String num1, String num2, char op) {
		Double result = new Double(0);
		switch (op) {
		case '+':
			result = Double.parseDouble(num1) + Double.parseDouble(num2);
			break;
		case '-':
			result = Double.parseDouble(num1) - Double.parseDouble(num2);
			break;
		}
		return result.toString();
	}

	public static String opMulDiv(String num1, String num2, char op) {
		Double result = new Double(0);
		switch (op) {
		case '*':
			result = Double.parseDouble(num1) * Double.parseDouble(num2);
			break;
		case '/':
			result = Double.parseDouble(num1) / Double.parseDouble(num2);
			break;
		}
		return result.toString();
	}

}