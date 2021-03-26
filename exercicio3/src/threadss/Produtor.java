package threadss;

import apllication.Deposito;

public class Produtor implements Runnable{
	
	private Deposito dep;
	private int segundos;
	
	/*Construtor da classe produtor,
	 inicializa o objeto thread produtor
	 */
	public Produtor(Deposito dep, int segundos) {
			
		this.dep = dep;
		this.segundos = segundos;
	}
	
	@Override
	public void run() {
		int consumo = 10;
		System.out.println("Produtor " + Thread.currentThread().getName() + " foi iniciado.");
		/*Thread produtor repete um laço até 10,
		 o que quer dizer que cada produtor vai produzir 10x 
		 */
		for(int i = 0; i < consumo; i++){
			try {
				/* A thread produtor fica a dormir
				 durante por x segundos
				 */
				Thread.sleep(segundos * 1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			//chamada do método colocar
			dep.colocar();
		}
	}
}

	
