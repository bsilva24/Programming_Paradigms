package pessoas;

public class TaxPayer {
	
	protected String name;
	protected double annual_income;

	public TaxPayer(String name, double annual_income) {
		super();
		this.name = name;
		this.annual_income = annual_income;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getAnnual_income() {
		return annual_income;
	}

	public void setAnnual_income(double annual_income) {
		this.annual_income = annual_income;
	}
	
	public double calc_tax(){
		return annual_income * 0.15;
	}
	
}
