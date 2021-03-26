package pessoas;

public class Pessoa_Juridica extends TaxPayer{
	
	protected int number_Emp;
	
	public Pessoa_Juridica(String name, double annual_income, int number_Emp) {
		super(name, annual_income);
		this.number_Emp = number_Emp;
	}

	public int getNumber_Emp() {
		return number_Emp;
	}

	public void setNumber_Emp(int number_Emp) {
		this.number_Emp = number_Emp;
	}
	
@Override
	public double calc_tax(){
		if(number_Emp <= 10){
			return annual_income * 0.16;
		} else{
			return annual_income * 0.14;
		}
		
	}
}
