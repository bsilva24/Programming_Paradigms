package calculo;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import pessoas.Pessoa_Fisica;
import pessoas.Pessoa_Juridica;
import pessoas.TaxPayer;

public class Programa {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		
		List<TaxPayer> pessoas = new ArrayList<>();
		
		Scanner sc = new Scanner (System.in);
		
		System.out.print("Enter the number of tax payers: ");
		int nPessoas = sc.nextInt();
		
		for(int i = 1; i <= nPessoas; i++){
			System.out.println("Tax payer #" + i + " data: ");
			System.out.print("Individual or company (i/c)? ");
			
			char tipoPessoa = sc.next().charAt(0);
			System.out.print("Name: ");
			sc.nextLine();
			String name = sc.nextLine();
			System.out.print("Anual income: ");
			double anual_income = sc.nextDouble();
			
			if (tipoPessoa == 'i'){
				
				System.out.print("Health expenditures: ");
				double health_Exp = sc.nextDouble();
				pessoas.add(new Pessoa_Fisica(name, anual_income, health_Exp));
				
			} else {
				
				System.out.print("Number of employees: ");
				int number_Emp = sc.nextInt();
				pessoas.add(new Pessoa_Juridica(name, anual_income, number_Emp));
			}
		}
		
		double sum = 0;
		System.out.println(" ");
		System.out.println("TAXES PAID: ");
		for(TaxPayer lista : pessoas) {
			
			System.out.printf(lista.getName() + ": $ %.2f \n", lista.calc_tax());
			sum = sum + lista.calc_tax();
		}
		
		System.out.printf("\nTOTAL TAXES: $ %.2f", sum);

	sc.close();	
	}

}
