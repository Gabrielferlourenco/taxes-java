package entities;

public class Individual extends TaxPayer {
	
	
	private Double healthExpenditures;
	
	public Individual() {
		super();
	}
	
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
	public double tax() {
		double amount = 0.0;
		
		if(getAnualIncome() < 20000.00) {
			amount = getAnualIncome() * 0.15;
		}
		else {
			amount = getAnualIncome() * 0.25;
		}
		
		return amount - (getHealthExpenditures() * 0.5);
	}

}
