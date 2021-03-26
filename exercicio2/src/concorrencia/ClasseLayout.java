package concorrencia;

import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

public class ClasseLayout extends JFrame {

	private static final long serialVersionUID = 1L;
		
		JLabel tempo = new JLabel();
		JLabel idade = new JLabel();

	public void editarLayout() {
		Font fonte = new Font("Arial", Font.BOLD, 50);
		Font fonte2 = new Font("Arial", Font.BOLD, 30);
		add(BorderLayout.NORTH, tempo);
		add(BorderLayout.CENTER, idade);
		tempo.setHorizontalAlignment(SwingConstants.CENTER);
		idade.setHorizontalAlignment(SwingConstants.CENTER);
		idade.setFont(fonte);
		tempo.setFont(fonte2);
		setSize(600, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	public void mostrarMensagem() {
		
		long inicio = System.nanoTime();
		
		int anoNasc = Integer.parseInt(JOptionPane.showInputDialog("Qual é o seu ano de nascimento?"));
		int anoAtual = Integer.parseInt(JOptionPane.showInputDialog("Qual é o ano atual?"));
		
		int resultado = anoAtual - anoNasc;
		
		long fim = System.nanoTime();
		long total = (fim -inicio) / 1000000000;
		
		JOptionPane.showMessageDialog(null, "você gastou " + total + " segundos para responder");
		
		long fim2 = System.nanoTime();
		long total2 = ((fim2 - fim) / 1000000000) + total;
		
		tempo.setText("Tempo total de cálculo: " + total2 + " segundos");
		
		idade.setText("A sua idade é: " + resultado + " anos");
	}
}
