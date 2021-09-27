package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controller.Controller;

public class PanelCentral extends JPanel{

	private static final long serialVersionUID = 1L;
	
	public PanelCentral(Controller controller) {
		setLayout(new BorderLayout());
		setBorder(BorderFactory.createLineBorder(Color.decode("#008ce3")));
		this.setBackground(Color.WHITE);
//		model = new DefaultTableModel();
//		table = new JTable(model);
//		table.setRowHeight(25);
//		init();
//		model.addColumn(columnName);
		
		setLayout(new java.awt.GridBagLayout());
		
		GridBagConstraints c = new GridBagConstraints();
		
		createGrid(c);
		
		
			
		c.gridy=0;
		c.weightx=0.05;
		c.gridx=5;
		c.gridwidth=6;
		JLabel Estacion1= new JLabel();
		Estacion1.setText("Estacion 1");
		Estacion1.setForeground(Color.decode("#008ce3"));
		Estacion1.setFont(new Font("Helvetica", Font.BOLD, 30));
		add(Estacion1, c);
		
		c.gridy=1;
		c.weightx=0.05;
		c.gridx=5;
		c.gridwidth=6;
		JLabel lbResult1= new JLabel();
		lbResult1.setText("Se lavaron "+ controller.numCajasB+" cajas de guayaba y se gastaron "+ redondearDouble(controller.estacionUno.getTime()/60) + " horas");
		lbResult1.setForeground(Color.BLACK);
		lbResult1.setFont(new Font("Helvetica", Font.ITALIC, 19));
		add(lbResult1, c);
		
		c.gridy=2;
		c.weightx=0.05;
		c.gridx=5;
		c.gridwidth=6;
		JLabel Estacion2= new JLabel();
		Estacion2.setText("Estacion 2");
		Estacion2.setForeground(Color.decode("#008ce3"));
		Estacion2.setFont(new Font("Helvetica", Font.BOLD, 30));
		add(Estacion2, c);
		
		c.gridy=3;
		c.weightx=0.05;
		c.gridx=5;
		c.gridwidth=6;
		JLabel lbResult2= new JLabel();
		lbResult2.setText("Se obtuvo "+ controller.estacionDos.getTotalPulpa()+" kg de pulpa y se gastaron "+ redondearDouble(controller.estacionDos.getTime()/60) + " horas");
		lbResult2.setForeground(Color.BLACK);
		lbResult2.setFont(new Font("Helvetica", Font.ITALIC, 19));
		add(lbResult2, c);
		
		c.gridy=4;
		c.weightx=0.05;
		c.gridx=5;
		c.gridwidth=6;
		JLabel Estacion3= new JLabel();
		Estacion3.setText("Estacion 3");
		Estacion3.setForeground(Color.decode("#008ce3"));
		Estacion3.setFont(new Font("Helvetica", Font.BOLD, 30));
		add(Estacion3, c);
		
		c.gridy=5;
		c.weightx=0.05;
		c.gridx=5;
		c.gridwidth=6;
		JLabel lbResult3= new JLabel();
		lbResult3.setText("Se obtuvo "+ controller.estacionTres.numMoldes+" moldes y se gasto "+ redondearDouble(controller.estacionTres.getTime()/60) + " horas");
		lbResult3.setForeground(Color.BLACK);
		lbResult3.setFont(new Font("Helvetica", Font.ITALIC, 19));
		add(lbResult3, c);
		
		c.gridy=6;
		c.weightx=0.05;
		c.gridx=5;
		c.gridwidth=6;
		JLabel Estacion4= new JLabel();
		Estacion4.setText("Estacion 4");
		Estacion4.setForeground(Color.decode("#008ce3"));
		Estacion4.setFont(new Font("Helvetica", Font.BOLD, 30));
		add(Estacion4, c);
		
		c.gridy=7;
		c.weightx=0.05;
		c.gridx=5;
		c.gridwidth=6;
		JLabel lbResult4= new JLabel();
		lbResult4.setText("Se obtuvo "+ controller.estacionCuatro.lonjasCaja+" lonjas repartidas en "
				+ controller.estacionTres.numMoldes+" moldes, y se gasto "+redondearDouble(controller.estacionCuatro.getTime()/60) + " horas");
		lbResult4.setForeground(Color.BLACK);
		lbResult4.setFont(new Font("Helvetica", Font.ITALIC, 19));
		add(lbResult4, c);
		
		c.gridy=8;
		c.weightx=0.05;
		c.gridx=5;
		c.gridwidth=6;
		JLabel Estacion5= new JLabel();
		Estacion5.setText("Estacion 5");
		Estacion5.setForeground(Color.decode("#008ce3"));
		Estacion5.setFont(new Font("Helvetica", Font.BOLD, 30));
		add(Estacion5, c);
		
		c.gridy=9;
		c.weightx=0.05;
		c.gridx=5;
		c.gridwidth=6;
		JLabel lbResult5= new JLabel();
		lbResult5.setText("Se obtuvo "+controller.estacionCinco.cantidadCajas+" cajas cada una con 8 bocadillos, y en total hay "
				+ controller.estacionCuatro.lonjasCaja+ " lonjas de caja, y se gasto "+ redondearDouble(controller.estacionCinco.getTime()/60)+" horas");
		lbResult5.setForeground(Color.BLACK);
		lbResult5.setFont(new Font("Helvetica", Font.ITALIC, 19));
		add(lbResult5, c);
//	
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
	
	public double redondearDouble(double horas) {
		return Math.round(horas*100.0)/100.0;
	}
}
