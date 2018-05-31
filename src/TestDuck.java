
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

import java.io.PrintStream;
import java.io.ByteArrayOutputStream;

public class TestDuck {

    static Duck d;  // Every test needs a Duck object

    // These fields are used to redirect and capture System.out
    static PrintStream originalOut;
    static ByteArrayOutputStream baos;
    static PrintStream newOut;

    @BeforeEach
    void init() {
	d = new Duck("me");

	originalOut = System.out;     // save to restore later

	baos = new ByteArrayOutputStream();
	newOut = new PrintStream(baos);
	System.setOut(newOut);
    }

    @AfterEach
    void tearDown() {
	System.setOut(originalOut);  // restore 
    }

   
    @Test
    void testDisplay() {
	String expectedOutput = "I'm a duck named me.\n";

	// method writes to System.out which has been redirected
	d.display();
	System.out.flush();
	String actualOutput = baos.toString();
	
	assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void testFly() {
	String expectedOutput = "me is flying!!\n";

	// method writes to System.out which has been redirected
	d.fly();
	System.out.flush();
	String actualOutput = baos.toString();
	
	assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void testQuack() {
	String expectedOutput = "me says Quack.\n";

	// method writes to System.out which has been redirected
	d.quack();
	System.out.flush();
	String actualOutput = baos.toString();
	
	assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void testSwim() {
	String expectedOutput = "me's webbed feet a paddlin'...\n";

	// method writes to System.out which has been redirected
	d.swim();
	System.out.flush();
	String actualOutput = baos.toString();
	
	assertEquals(expectedOutput, actualOutput);
    }
}
