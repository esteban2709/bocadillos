package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;

import controller.Controller;


public class WindowPrincipal extends JDialog{

	private static final long serialVersionUID = 1L;
	private PanelCentral panelCentral;
	
	public WindowPrincipal(Controller controller, JFrame parent) {
		super(parent);
		this.getContentPane().setBackground(Color.WHITE);
		setTitle("Bocadillo Simuador");
		this.setSize(1280, 530);
		this.setResizable(false);
	
		setLayout(new java.awt.GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		
		createGrid(c);
		
		c.gridy=0;//ubicacione en y 
		c.weightx=0.05;
		c.gridx=4;//desde donde inicia y solo hasta 12
		c.gridwidth=4;// numero de cuadros a tomar 
		JLabel lbTitle = new JLabel("FABRICA DE BOCADILLOS");
		lbTitle.setFont(new Font("Helvetica", Font.BOLD, 50));
		lbTitle.setBorder(null);
		lbTitle.setForeground(Color.decode("#ff9d01"));
		add(lbTitle, c);
		
		c.gridy=1;
		c.weightx=1;
		c.gridx=0;
		c.gridwidth=12;
		JLabel lbWhite = new JLabel();
		add(lbWhite,c);

		c.gridy=2;
		c.weightx=1;
		c.gridx=2;
		c.gridwidth=8;
		JLabel lbOne = new JLabel("Resultados para la ultima iteracion");
		add(lbOne,c);
		
		c.gridy=3;
		c.weightx=1;
		c.gridx=2;
		c.gridwidth=8;
		panelCentral = new PanelCentral(controller);
		add(panelCentral,c);
		
		
		

		c.gridy=3;
		c.weightx=0.05;
		c.gridx=4;
		c.gridwidth=4;
		JLabel space2 = new JLabel("Hola2");
		space2.setBackground(Color.YELLOW);
		add(space2, c);
		
		
		
		setVisible(true);
	}

	public void createGrid(GridBagConstraints c) {
		c.fill = GridBagConstraints.BOTH;
		c.weightx=1;
		c.gridwidth=1;
//		c.weighty=0.01;
		for (int i = 0; i < 12; i++) {
			c.gridx = i;
			add(new JLabel(""),c);
		}
	}
	
}
