package git.Calculator;

public class Controller {
	private final View view;
	private final Validator validator;
	private final Calculator calculator;
	
	public Controller(View view, Validator validator, Calculator calculator) {
		this.view = view;
		this.validator = validator;
		this.calculator = calculator;
	}
	
	public void execute() {
		String input = "*123";
		try {
			validator.checkInvalidOp(input);
		} catch (InvalidOpException i) {
			view.display("Invalid operators. Please check if operands miss.");
		}
		// calculator.calculate(input);
	}

}