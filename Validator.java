package git.Calculator;

public class Validator {
	void validate(String string) throws InvalidOpException {
		checkInvalidOp(string);
	}
	
	boolean checkInvalidOp(String evaluate) throws InvalidOpException {
		// if(evaluate.matches("[-+*/^][+*/^] | ^[+*/^]"))
			// return true;
		// else
			// return false;
		throw new InvalidOpException();
	}
}