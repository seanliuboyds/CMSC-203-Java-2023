import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class GradeBookTest {
	
	GradeBook scores1 = new GradeBook(5);
	
	GradeBook scores2 = new GradeBook(5);

	@BeforeEach
	public void setUp()  {
		
		scores1.addScore(100.0);
		scores1.addScore(200.0);
		scores2.addScore(300.0);
		scores2.addScore(400.0);
		scores2.addScore(500.0);
	}

	@AfterEach
	public void tearDown() {
		scores1 = null;
		scores2 = null;
	}

	@Test
	void testAddScore() {
		assertTrue(scores1.toString().equals("100.0 200.0"));
		assertTrue(scores2.toString().equals("300.0 400.0 500.0"));
	}

	@Test
	void testSum() {
		assertEquals(300.0, scores1.sum(), 0.0001);
		assertEquals(1200.0, scores2.sum(), 0.0001);
	}

	@Test
	void testMinimum() {
		assertEquals(100.0, scores1.minimum(), 0.0001);
		assertEquals(300.0, scores2.minimum(), 0.0001);
	}

	@Test
	void testFinalScore() {
		assertEquals(scores1.sum() + scores2.sum() - scores1.minimum() - scores2.minimum(),scores1.finalScore() + scores2.finalScore(), 0.0001);
	}
}
