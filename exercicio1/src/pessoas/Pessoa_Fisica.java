package pessoas;

public class Pessoa_Fisica extends TaxPayer{
	
	protected double health_Exp;

	public Pessoa_Fisica(String name, double annual_income, double health_Exp) {
		super(name, annual_income);
		this.health_Exp = health_Exp;
	}
	
	public double getHealth_Exp() {
		return health_Exp;
	}

	public void setHealth_Exp(double health_Exp) {
		this.health_Exp = health_Exp;
	}

@Override
	public double calc_tax(){
		if(annual_income < 20000 && health_Exp > 0){
			return ((annual_income * 0.15)-(health_Exp * 0.50));
		}
		else if (annual_income > 20000 && health_Exp > 0){
			return ((annual_income * 0.25)-(health_Exp * 0.50));
		}
		else if (annual_income > 20000 && health_Exp <= 0){
			return annual_income * 0.25;
		}else{
			return annual_income * 0.15;
		}
	}
}
