package apllication;

import java.util.Scanner;

import threadss.Consumidor;
import threadss.Produtor;

public class Deposito {
	
	private int items = 0;
	private boolean leitura = true; // variável condicional
	
	/*método sincronizado permite que só uma thread de cada vez invoque este método
	para atribuir o valor para um objeto*/
	public synchronized void retirar() {
		//como não é a vez do produtor, a thread que chamou este método precisa de esperar*/
		while(leitura){
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();}
		}
		items--;
		System.out.println("Consumidor " + Thread.currentThread().getName() + " retirou 1 lâmpada. Lâmpadas em stock: " + items);
		
		//Indica que o consumidor pode consumir
		leitura = true;
		
		//notifica todas as threads em espera para ficarem prontas
		notifyAll();
		}
	
	/*método sincronizado permite que só uma thread de cada vez invoque este método
	para atribuir o valor para um objeto*/
	public synchronized void colocar () {
		
		/*como não é a vez do consumidor, a thread que chamou este método precisa de esperar*/
		while (!leitura) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();}
		}
		items++;
		System.out.println("Produtor " + Thread.currentThread().getName() + " colocou 1 lâmpada. Lâmpadas em stock: " + items);
		
		//indica que o consumidor não pode consumir 
		leitura = false;
		
		//notifica todas as threads em espera para ficarem prontas
		notifyAll();
		}
	
	public static void main(String[] args) throws InterruptedException {
	
		Scanner sc = new Scanner(System.in);
			
		System.out.println("Cada produtor produzirá 10 lâmpadas.");
		System.out.println("Quantos produtores pretende adicionar? (Mínimo 1) ");
		int prod = sc.nextInt();
		
		System.out.println("Qual o tempo de consumo (em seg)? ");
		int prodseg = sc.nextInt();
			
		System.out.println("Cada consumidor consumirá 5 lâmpadas. Para a quantidade"
					+ " de produtores selecionada, deverá escolher entre 0 e 2 consumidores.");
		
		System.out.println("Quantos consumidores pretende adicionar? ");
		int cons = sc.nextInt();
		
		int totalProd = prod * 10;
		int totalCons = cons * totalProd / cons;
		int totalC = totalProd / 5;
		
		System.out.println("Qual o tempo de consumo (em seg)? ");
		int consseg = sc.nextInt();
			
		System.out.println("\nNo total serão produzidas " + totalProd + " lâmpadas, das quais " + totalCons + " serão consumidas.\n");
	
		//criação do objeto Depósito
		Deposito dep = new Deposito();
		
		//ciclo que vai indicar o número de produtores
		for(int i = 1; i <= prod; i++){
			
			//criação do objeto Produtor
			Produtor pt = new Produtor(dep, prodseg);
			String s = Integer.toString(i);
			
			//criação do objeto da Thread produtor
			Thread p = new Thread(pt);
			p.setName(s);
			
			//inicia a thread produtor
			p.start();
		}
		
		//ciclo que vai indicar o número de consumidores
		for(int j = 1; j <= totalC; j++){
			
			//criação do objeto Consumidor
			Consumidor c = new Consumidor(dep, consseg);
			String se = Integer.toString(j);
			c.setName(se);
			
			//inicia a thread produtor
			c.start();
		}
		
		sc.close();

	}
	}

