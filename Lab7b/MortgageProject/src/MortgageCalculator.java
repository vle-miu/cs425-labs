import java.time.LocalDate;
import java.time.Period;
import java.util.Arrays;
import java.util.List;

public class MortgageCalculator {
	
	public double computeMaxMortgage(LocalDate birthday, double monthlyIncome, boolean isMarried, double monthlyIncomePartner, String profession) {
		double result = 0;
		
		// calculate age
		Period p = Period.between(birthday, LocalDate.now());
		int age = p.getYears();
		System.out.println(age);
		
		if (age < 18) {
			return 0;
		}

		double totalIncome = monthlyIncome;
		if (isMarried) {
			totalIncome = monthlyIncome + monthlyIncomePartner * 0.94;
		}

		if (2000 <= totalIncome && totalIncome < 3000) {
			if (isExistProfression(profession, Arrays.asList(ProfessionEnum.DEVELOPER.getValue(), ProfessionEnum.ARCHITECT.getValue(), ProfessionEnum.SCRUM_MASTER.getValue()))) return 160000;
			if (isExistProfression(profession, Arrays.asList(ProfessionEnum.TESTER.getValue(), ProfessionEnum.SYSTEM_ADMINISTRATOR.getValue(), ProfessionEnum.TECHNICAL_WRITER.getValue()))) return 120000;
			if (isExistProfression(profession, Arrays.asList(ProfessionEnum.DEPARTMENT_HEAD.getValue(), ProfessionEnum.PROFESSOR.getValue()))) return  220000;
		}

		if (3000 <= totalIncome && totalIncome < 5000) {
			if (isExistProfression(profession, Arrays.asList(ProfessionEnum.DEVELOPER.getValue(), ProfessionEnum.ARCHITECT.getValue(), ProfessionEnum.SCRUM_MASTER.getValue()))) return 180000;
			if (isExistProfression(profession, Arrays.asList(ProfessionEnum.TESTER.getValue(), ProfessionEnum.SYSTEM_ADMINISTRATOR.getValue(), ProfessionEnum.TECHNICAL_WRITER.getValue()))) return 140000;
			if (isExistProfression(profession, Arrays.asList(ProfessionEnum.DEPARTMENT_HEAD.getValue(), ProfessionEnum.PROFESSOR.getValue()))) return 250000;
		}

		if (5000 <= totalIncome) {
			if (isExistProfression(profession, Arrays.asList(ProfessionEnum.DEVELOPER.getValue(), ProfessionEnum.ARCHITECT.getValue(), ProfessionEnum.SCRUM_MASTER.getValue()))) return 220000;
			if (isExistProfression(profession, Arrays.asList(ProfessionEnum.TESTER.getValue(), ProfessionEnum.SYSTEM_ADMINISTRATOR.getValue(), ProfessionEnum.TECHNICAL_WRITER.getValue()))) return 160000;
			if (isExistProfression(profession, Arrays.asList(ProfessionEnum.DEPARTMENT_HEAD.getValue(), ProfessionEnum.PROFESSOR.getValue()))) return 280000;
		}

		return 0;
	}

	private static boolean isExistProfression(String profession, List<String> professions) {
		return professions.contains(profession);
	}

}
