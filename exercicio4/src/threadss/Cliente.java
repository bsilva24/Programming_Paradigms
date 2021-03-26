package threadss;

import apllication.MiniLoja;

public class Cliente implements Runnable{                      // Classe Cliente implementa Runnable
	
	private MiniLoja loja;                                 // Variavel loja do tipo MiniLoja
	
	public Cliente(MiniLoja loja) {                        // Contrutor da classe Cliente com parametro Miniloja loja
			
		this.loja = loja;
	}
	
	@Override
	public void run() {                                   // Metodo Run() que a cada iteracao executa o metodo entrar()
		System.out.println(Thread.currentThread().getName() + " Esperando na entrada da miniloja.");
		for(int i = 0; i < 1; i++){
			
			loja.entrar();
			
		}
	}
}

	
