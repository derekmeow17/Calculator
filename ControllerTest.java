package git.Calculator;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ControllerTest {
	private Calculator calculator;
	private Controller controller;
	private View view;
	private Validator validator;
	
	@Before
	public void setUp() {
		calculator = mock(Calculator.class);
		view = mock(View.class);
		validator = mock(Validator.class);
		controller = new Controller(view, validator, calculator);
	}
	
	@Test
	public void controller_should_get_times_123_from_view_and_send_to_be_validated() throws InvalidOpException {
		// When this action occurs make the mock object return the literal string billy
		when(view.getInput()).thenReturn("*123");
		
		doThrow(new InvalidOpException()).when(validator).validate("*123");
		controller.execute();
		
		//verify(view).display("Invalid operators. Please check if operands miss.");
	}
	
}