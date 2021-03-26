package apllication;


import java.util.Random;
import java.util.Scanner;

import threadss.Cliente;
import threadss.Limpeza;


public class MiniLoja {
	
	private boolean sujo = true;                             // Condicao booleana para testar nos blocos sincronizados
	
	public synchronized void limpar() {                      // Metodo sincronizado limpar()
		while(!sujo){                                        // Enquanto for falso a Thread espera
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();}
		}
		
		System.out.println(Thread.currentThread().getName() + " entrando na miniloja");                     // Saida que indica que Limpeza entra na loja 
		System.out.println(Thread.currentThread().getName() + " desinfetando a miniloja, espere!\n");       // Saida que indica que Limpeza está a desinfetar a loja
		try {
			Thread.sleep(2000);                              // Tempo espera da Thread
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		sujo = false;                                        // Coloca a condicao booleana como falsa 
		
		notifyAll();                                         // notifica as threads que estao a espera que podem retomar
		}

	public synchronized void entrar () {                     // Metodo sincronizado entrar()
		
		while (sujo) {                                       // Enquanto for verdade a Thread espera
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();}
		}
		System.out.println(Thread.currentThread().getName() + " Entrando na miniloja e desinfetando as mãos");  //
		System.out.println(Thread.currentThread().getName() + " Fazendo atividade 1");                          //
		System.out.println(Thread.currentThread().getName() + " Pagando as compras");                           // Saidas das accoes do cliente
		System.out.println(Thread.currentThread().getName() + " Desinfetando as mãos");                         //
		System.out.println(Thread.currentThread().getName() + " Saindo da miniloja\n");                         //
		try {
			Thread.sleep(2000);                              // Tempo espera da Thread
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		sujo = false;                                        // Coloca a condicao booleana como falsa, o que faz com a Limpeza não necesite de entrar mais do que 1 vez             
		 
		notifyAll();                                         // notifica as threads que estao a espera que podem retomar 
		}
	
	public static void main(String[] args) throws InterruptedException {    // Metodo main()
	
		Scanner sc = new Scanner(System.in);                                // Scanner para inputs
		
		System.out.print("Introduza o número de Clientes: ");
		int nrClientes = sc.nextInt();                                      // Variavel que indica o numero de clientes da loja
		System.out.println();
		
		MiniLoja loja = new MiniLoja();                                     // Criacao do objecto loja do tipo MiniLoja
		Random rand = new Random();                                         // Variavel rand para obter o nome da lista de forma random
		String nome;                                                        // Variavel nome
		int nomeRand;
		
		String [] listaNomes = {"Ana", "Nuno", "Maria", "Pedro", "Sara", "Bruno", "Raquel",    // Lista com nomes de clientes
				"João", "Elsa", "David", "Isabel", "Nelson", "Gabriela", "Ricardo", "Helena", 
				"Manuel", "Gloria", "José", "Bruna", "Daniel", "Daniela", "António"};
		
		for (int i = 0; i < nrClientes; i++) {   // Ciclo que cria e inicia a Thread cliente
			
			nomeRand = rand.nextInt(22);
			nome = listaNomes[nomeRand];
			Cliente cliente = new Cliente(loja);        // Objecto cliente do tipo Cliente com o parametro loja
			Thread novoCliente = new Thread(cliente);   // Por implementar a interface Runnable necessita de criar uma Thread
			novoCliente.setName(nome);                  // Coloca o nome da Thread como o nome aleatorio econtrado 
			novoCliente.start();                        // inicia a Thread
		}
		
		for(int j = 0; j < 1; j++){                     // Ciclo que cria e inicia a Thread Limpeza
			
			Limpeza c = new Limpeza(loja);              // Objecto c do tipo Limpeza com o parametro loja 
			c.setName("Limpeza");                       // Coloca o nome da Thread como Limpeza 
			
			c.start();                                  // Inicia a Thread
		}
		
		sc.close();

	}
	}

