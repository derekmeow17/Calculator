package git.Calculator;

public class Controller {
	private final View view;
	private Validator validator;
	
	public Controller(View view, Validator validator) {
		this.view = view;
		this.validator = validator;
	}
	
	public void execute() {
		String input = view.getInput();
		validator.validate(input);
	}
}