import cdba.Application;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.springframework.boot.test.OutputCapture;

public class ApplicationTests {

	@Rule
	public OutputCapture outputCapture = new OutputCapture();


	@Test
	public void testSqlToTimeExecutor() throws Throwable {
		Application.main(new String[0]);
		String output = this.outputCapture.toString();
        System.out.println(output);
    }
}
