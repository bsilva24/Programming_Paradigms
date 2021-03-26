package threadss;

import apllication.Deposito;

public class Consumidor extends Thread{

	private Deposito dep;
	private int segundos;
	int items = 0;

	/*Construtor da classe Consumidor, 
	inicializa o objeto thread consumidor*/
	public Consumidor(Deposito dep, int segundos) {
		this.dep = dep;
		this.segundos = segundos;
	}
	
	public void run(){
		int consumo = 5;
		System.out.println("Consumidor " + this.getName() + " foi iniciado.");
		System.out.println("Consumidor " + this.getName() + " consumir� no total " + consumo + " l�mpadas.");
		
		/*A	thread	Consumidor repete um la�o at� 5 ,
		  o que significa que cada consumidor vai consumir 5x */
		for(int i = 0; i < consumo; i++){
			try {
				/*
				 A thread consumidor fica a dormir
				 durante por x segundos
				 */
				Thread.sleep(segundos * 1000);
				System.out.println("Consumidor " + Thread.currentThread().getName() + " aguarda por l�mpadas dispon�veis."
						+ " L�mpadas em stock: " + items);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			//chamada do m�todo retirar
			dep.retirar();
		}
		System.out.println("O Consumidor " + this.getName() + " terminou o consumo.");
	}
	
	
	
}

