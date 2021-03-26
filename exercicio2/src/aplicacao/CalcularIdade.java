package aplicacao;

import concorrencia.ClasseLayout;
import concorrencia.ConRun;

public class CalcularIdade {
	
	public static void main(String[] args) {
		
		ClasseLayout c = new ClasseLayout();
		
		ConRun segundos2 = new ConRun();
		Thread contarSegundos = new Thread(segundos2);
		
		c.editarLayout();
		c.mostrarMensagem();
		
		contarSegundos.start();
		
	}
}