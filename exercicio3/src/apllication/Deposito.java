package apllication;

import java.util.Scanner;

import threadss.Consumidor;
import threadss.Produtor;

public class Deposito {
	
	private int items = 0;
	private boolean leitura = true; // vari�vel condicional
	
	/*m�todo sincronizado permite que s� uma thread de cada vez invoque este m�todo
	para atribuir o valor para um objeto*/
	public synchronized void retirar() {
		//como n�o � a vez do produtor, a thread que chamou este m�todo precisa de esperar*/
		while(leitura){
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();}
		}
		items--;
		System.out.println("Consumidor " + Thread.currentThread().getName() + " retirou 1 l�mpada. L�mpadas em stock: " + items);
		
		//Indica que o consumidor pode consumir
		leitura = true;
		
		//notifica todas as threads em espera para ficarem prontas
		notifyAll();
		}
	
	/*m�todo sincronizado permite que s� uma thread de cada vez invoque este m�todo
	para atribuir o valor para um objeto*/
	public synchronized void colocar () {
		
		/*como n�o � a vez do consumidor, a thread que chamou este m�todo precisa de esperar*/
		while (!leitura) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();}
		}
		items++;
		System.out.println("Produtor " + Thread.currentThread().getName() + " colocou 1 l�mpada. L�mpadas em stock: " + items);
		
		//indica que o consumidor n�o pode consumir 
		leitura = false;
		
		//notifica todas as threads em espera para ficarem prontas
		notifyAll();
		}
	
	public static void main(String[] args) throws InterruptedException {
	
		Scanner sc = new Scanner(System.in);
			
		System.out.println("Cada produtor produzir� 10 l�mpadas.");
		System.out.println("Quantos produtores pretende adicionar? (M�nimo 1) ");
		int prod = sc.nextInt();
		
		System.out.println("Qual o tempo de consumo (em seg)? ");
		int prodseg = sc.nextInt();
			
		System.out.println("Cada consumidor consumir� 5 l�mpadas. Para a quantidade"
					+ " de produtores selecionada, dever� escolher entre 0 e 2 consumidores.");
		
		System.out.println("Quantos consumidores pretende adicionar? ");
		int cons = sc.nextInt();
		
		int totalProd = prod * 10;
		int totalCons = cons * totalProd / cons;
		int totalC = totalProd / 5;
		
		System.out.println("Qual o tempo de consumo (em seg)? ");
		int consseg = sc.nextInt();
			
		System.out.println("\nNo total ser�o produzidas " + totalProd + " l�mpadas, das quais " + totalCons + " ser�o consumidas.\n");
	
		//cria��o do objeto Dep�sito
		Deposito dep = new Deposito();
		
		//ciclo que vai indicar o n�mero de produtores
		for(int i = 1; i <= prod; i++){
			
			//cria��o do objeto Produtor
			Produtor pt = new Produtor(dep, prodseg);
			String s = Integer.toString(i);
			
			//cria��o do objeto da Thread produtor
			Thread p = new Thread(pt);
			p.setName(s);
			
			//inicia a thread produtor
			p.start();
		}
		
		//ciclo que vai indicar o n�mero de consumidores
		for(int j = 1; j <= totalC; j++){
			
			//cria��o do objeto Consumidor
			Consumidor c = new Consumidor(dep, consseg);
			String se = Integer.toString(j);
			c.setName(se);
			
			//inicia a thread produtor
			c.start();
		}
		
		sc.close();

	}
	}

