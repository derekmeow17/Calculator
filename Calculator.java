package git.Calculator;

public class Calculator {

	public static void main(String[] args) {
		System.out.println(parseExp(""));
	}

	public static int findLastMinus(String s, int lastIndex) {
		int index = s.lastIndexOf('-', lastIndex);
		if (index <= 0) // -1: can't find -ve sign; 0: 1st num is -ve
			return -1;
		else if (s.charAt(index - 1) == '+' || s.charAt(index - 1) == '-' || s.charAt(index - 1) == '*'
				|| s.charAt(index - 1) == '/' || s.charAt(index - 1) == '^')
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
			String left = evaluate.substring(0, opIndex);
			String right = evaluate.substring(opIndex + 1);
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
			return parsePow(evaluate);
		} else {
			String left = evaluate.substring(0, opIndex);
			String right = evaluate.substring(opIndex + 1);
			return opMulDiv(parseFactor(left), parseFactor(right), evaluate.charAt(opIndex));
		}
	}

	public static String parsePow(String evaluate) {
		int opIndex = evaluate.indexOf('^');
		if (opIndex == -1)
			return evaluate;
		else {
			String left = evaluate.substring(0, opIndex);
			String right = evaluate.substring(opIndex + 1);
			return opPow(parsePow(left), parsePow(right));
		}
	}

	public static String parseExp(String evaluate) {
		int openBracketIndex = evaluate.lastIndexOf('(');
		int closeBracketIndex = evaluate.indexOf(')', openBracketIndex);
		if (openBracketIndex == -1 && closeBracketIndex == -1)
			return parseTerm(evaluate);
		else {
			String tmp; // To store current bracket and contents inside
			if (closeBracketIndex == evaluate.length() - 1)
				tmp = evaluate.substring(openBracketIndex);
			else
				tmp = evaluate.substring(openBracketIndex, closeBracketIndex + 1);
			return parseExp(evaluate.replace(tmp, parseExp(tmp.substring(1, tmp.length() - 1))));
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

	public static String opPow(String s1, String s2) {
		double num1 = Double.parseDouble(s1);
		double num2 = Double.parseDouble(s2);
		return calculatePow(num1, (int) num2).toString();
	}

	public static Double calculatePow(double num1, double num2) {
		if (num1 == 0)
			return new Double(0);
		else if (num2 == 0)
			return new Double(1);

		if (num2 == 1)
			return num1;
		else if (num2 == -1)
			return num1;
		else {
			if (num2 > 1)
				return num1 * calculatePow(num1, num2 - 1);
			else
				return 1 / num1 / calculatePow(num1, num2 + 1);
		}
	}

}