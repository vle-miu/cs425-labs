import static org.junit.Assert.*;

import org.junit.Test;

import java.time.LocalDate;

public class MortgageTest {

	@Test
	public void test1() {
		MortgageCalculator mc = new MortgageCalculator();
		double result = mc.computeMaxMortgage(LocalDate.of(1967, 5, 2),3000, false, 0, ProfessionEnum.ARCHITECT.getValue());
	    assertEquals(180000, result, 0.001);
	}
	
	@Test
	public void test2() {
		MortgageCalculator mc = new MortgageCalculator();
		double result = mc.computeMaxMortgage(LocalDate.of(2001, 5, 2), 3000, false, 0, ProfessionEnum.ARCHITECT.getValue());
	    assertEquals(0, result, 0.001);
	}
	
	@Test
	public void test3() {
		MortgageCalculator mc = new MortgageCalculator();
		double result = mc.computeMaxMortgage(LocalDate.of(1977, 12, 2), 4000, true, 2000, ProfessionEnum.DEVELOPER.getValue());
	    assertEquals(220000, result, 0.001);
	}
	
	@Test
	public void test4() {
		MortgageCalculator mc = new MortgageCalculator();
		double result = mc.computeMaxMortgage(LocalDate.of(1954, 5, 12), 5500, false, 0, ProfessionEnum.PROFESSOR.getValue());
	    assertEquals(280000, result, 0.001);
	}

}
