package CalculateBonus;

public class CalculateBonus {

	private final int RANK_A = 9;
	private final int RANK_B = 7;
	private final int RANK_C = 5;
	/**
	 * @param salary  phải  >=1000 và <= 3000000
	 * @param workingDay ngày làm việc phải >= 0 và <= 31
	 * @param staffPoint điểm của nhân viên phải >=1  và <= 10
	 * @param level cấp bậc nhân viên phải >0 và phải <= 7
	 * @return  if result is < 0 mean there is an error
	 */
	public double calculate(long salary, int workingDay, int staffPoint, int level) {
		double bonusRate = 1;
		if (level <=0 || level > 7 
			|| staffPoint < 1 || staffPoint > 10
			|| workingDay < 0 || workingDay > 31
			|| salary < 1000 || salary > 3000000) {
			return -1;
		}	
		//Staff point
		if(staffPoint >= RANK_A) {
			bonusRate = bonusRate * 1.3; 
		} else if(staffPoint >= RANK_B && staffPoint < RANK_A) {
			bonusRate = bonusRate * 1.1;
		} else if(staffPoint >= RANK_C && staffPoint < RANK_B) {
			bonusRate = bonusRate * 1.0;
		} else  {
			bonusRate = bonusRate * 0;
		}
		// Check salary
		if(salary >= 1000 && salary < 5000) {
			bonusRate = bonusRate * 1.5;
		} else if (salary >= 5000 && salary < 10000) {
			bonusRate = bonusRate * 1.3;
		} else if (salary >=10000 && salary < 20000) {
			bonusRate = bonusRate * 1.1;
		} else {
			bonusRate = bonusRate * 1.0;
		} 
		//Level
		if(level > 5) {
			bonusRate = bonusRate * 1.0;
		} else {
			bonusRate = bonusRate * 1.1;
		}
		return bonusRate * salary;
	}
}