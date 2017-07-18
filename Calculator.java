package com.app.calculator;

public class Calculator {

	public String resolveBracket(String evaluate) {
		if(evaluate.contains("(")) {
			int start = evaluate.indexOf('(');
			int end = evaluate.lastIndexOf(')');
			return evaluate.substring(start, end);
		} else
			return evaluate;
	}

	public Double calculate(String evaluate) {
		// TODO Auto-generated method stub
		if(evaluate.isEmpty()) {
			return new Double(0);
		}
		
		if(evaluate.contains("*")) {
			int indexOfMinusSymbol = evaluate.indexOf('*');
			String left = evaluate.substring(0, indexOfMinusSymbol);
			String right = evaluate.substring(indexOfMinusSymbol+1);
			return Double.parseDouble(left) * Double.parseDouble(right);
		} else if(evaluate.contains("/")) {
			int indexOfMinusSymbol = evaluate.indexOf('/');
			String left = evaluate.substring(0, indexOfMinusSymbol);
			String right = evaluate.substring(indexOfMinusSymbol+1);
			return Double.parseDouble(left) / Double.parseDouble(right);
		} else if(evaluate.contains("+")) {
			int indexOfMinusSymbol = evaluate.indexOf('+');
			String left = evaluate.substring(0, indexOfMinusSymbol);
			String right = evaluate.substring(indexOfMinusSymbol+1);
			return Double.parseDouble(left) + Double.parseDouble(right);
		} if(evaluate.contains("-")) {
			int indexOfMinusSymbol = evaluate.indexOf('-');
			String left = evaluate.substring(0, indexOfMinusSymbol);
			String right = evaluate.substring(indexOfMinusSymbol+1);
			return Double.parseDouble(left) - Double.parseDouble(right);
		}
		return Double.parseDouble(evaluate);
	}

}