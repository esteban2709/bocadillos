package view;

import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import controller.Controller;

public class PanelSuperior extends JPanel{
	
	private JButton masInfo;
	private JTextField txHorasTrabajo;
	private JTextField txDiasTrabajo;
	private JButton btnActualizar; 
	private static final long serialVersionUID = 1L;
	
	public PanelSuperior(Controller controller) {
		this.setLayout(new FlowLayout());
		this.addItems(controller);
		this.setVisible(true);
	}
	
	private void addItems(Controller controller) {
		this.masInfo = new JButton("Mas informacion");
		this.masInfo.setBackground(Color.decode("#eab02c"));
		this.masInfo.setForeground(Color.white);
		masInfo.setActionCommand("mas informacion");
		masInfo.addActionListener(controller);
		this.add(masInfo);
		
		txHorasTrabajo = new JTextField(17);
		this.txHorasTrabajo.setBackground(Color.decode("#adb646"));
		txHorasTrabajo.setBorder(BorderFactory.createTitledBorder("Horas trabajo/diarias"));
		add(txHorasTrabajo);
		
		txDiasTrabajo = new JTextField(17);
		txDiasTrabajo.setBackground(Color.decode("#adb646"));
		txDiasTrabajo.setBorder(BorderFactory.createTitledBorder("Dias a simular"));
		add(txDiasTrabajo);
		
		this.btnActualizar = new JButton("Actualizar");
		this.btnActualizar.setBackground(Color.decode("#eab02c"));
		this.btnActualizar.setForeground(Color.white);
		btnActualizar.setActionCommand("Actualizar");
		btnActualizar.addActionListener(controller);
		add(btnActualizar);
	}
	
	public int getHorasTrabajo() {
		return Integer.parseInt(txHorasTrabajo.getText());
	}
	public int getDiasTrabajo() {
		return Integer.parseInt(txDiasTrabajo.getText());
	}

	
}
