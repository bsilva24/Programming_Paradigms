package threadss;

import apllication.MiniLoja;

public class Limpeza extends Thread{             // Classe Limpeza que herda Thread

	private MiniLoja loja;                       // Variavel loja do tipo Miniloja

	public Limpeza(MiniLoja loja) {              // Construtor Limpeza com o parametro loja do tipo MiniLoja
		this.loja = loja;
	}
	
	public void run(){                           // Metodo Run()
		
		int consumo = 1;
		System.out.println(this.getName() + " Esperando na entrada da miniloja.\n");     // Saida do metodo
		
		for(int i = 0; i < consumo; i++){          // Ciclo que implenta a Thread a cada interaçaã
			try {
				Thread.sleep(2000);                // Tempo que a thread espera
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			loja.limpar();                         // Chamada do metodo limpar()
			
		}
	}
	
	
	
}

