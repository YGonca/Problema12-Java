package entities;

public class Individual extends TaxPayer{
	
	private Double healthExpenditures;

	public Individual(String name, Double anualIncome, Double healthExpenditures) {
		super(name, anualIncome);
		this.healthExpenditures = healthExpenditures;
	}

	public Double getHealthExpenditures() {
		return healthExpenditures;
	}

	public void setHealthExpenditures(Double healthExpenditures) {
		this.healthExpenditures = healthExpenditures;
	}

	@Override
	public Double tax() {
		double tax;
		if(anualIncome < 20000)
			tax = anualIncome * 15 / 100;
		else 
			tax = anualIncome * 25 / 100;
		tax -= healthExpenditures / 2;
		return tax;
	}
}
