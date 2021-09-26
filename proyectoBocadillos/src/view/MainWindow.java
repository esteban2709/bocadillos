package view;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

import controller.Controller;

public class MainWindow extends JFrame{

	private static final long serialVersionUID = 1L;
	private JTableWindow jtTableWindow,jtTableWindow1,jtTableWindow2,jtTableWindow3,jtTableWindow4;
	private JTabbedPane jTabbedPane;
	private JTextField txHorasTrabajo;
	private JTextField txDiasTrabajo;
	
	public MainWindow(Controller controller) {
		setTitle("Bocadillo Simuador");
		setSize(700, 500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setLayout(null);
		jTabbedPane = new JTabbedPane();
		initComponents(controller);
		setVisible(true);
	}
	
	private void initComponents(Controller controller) {
		JButton jbuton = new JButton("Mas informacion");
		jbuton.setActionCommand("mas informacion");
		jbuton.addActionListener(controller);
		jbuton.setBounds(10, 50, 140, 50);
		add(jbuton);
		txHorasTrabajo = new JTextField();
		txHorasTrabajo.setBorder(BorderFactory.createTitledBorder("Horas trabajo/diarias"));
		txHorasTrabajo.setBounds(20, 120, 140, 50);
		add(txHorasTrabajo);
		txDiasTrabajo = new JTextField();
		txDiasTrabajo.setBorder(BorderFactory.createTitledBorder("Dias a simular"));
		txDiasTrabajo.setBounds(20, 180, 140, 50);
		add(txDiasTrabajo);
		JButton btnActualizar = new JButton("Actualizar");
		btnActualizar.setActionCommand("Actualizar");
		btnActualizar.addActionListener(controller);
		btnActualizar.setBounds(20, 300, 140, 50);
		add(btnActualizar);
		
		JPanel aux = new JPanel();
		jtTableWindow = new JTableWindow();
		jtTableWindow1 = new JTableWindow();
		jtTableWindow2 = new JTableWindow();
		jtTableWindow3 = new JTableWindow();
		jtTableWindow4 = new JTableWindow();
		JScrollPane scroll =new JScrollPane(jtTableWindow);
		JScrollPane scroll1 =new JScrollPane(jtTableWindow1);
		JScrollPane scroll2 =new JScrollPane(jtTableWindow2);
		JScrollPane scroll3 =new JScrollPane(jtTableWindow3);
		JScrollPane scroll4 =new JScrollPane(jtTableWindow4);
		jTabbedPane.addTab("Estacion 1", scroll);
		jTabbedPane.addTab("Estacion 2", scroll1);
		jTabbedPane.addTab("Estacion 3", scroll2);
		jTabbedPane.addTab("Estacion 4", scroll3);
		jTabbedPane.addTab("Estacion 5", scroll4);
		aux.add(jTabbedPane);
		aux.setBounds(-120, 0, 1100, 1100);
		add(aux);
	}
	
	public void refreshTable1(double[] at,double[] aat,double[] wt,double[] st, double[] et) {
		jtTableWindow.refreshTable(at,aat,wt,st,et);
	}
	
	public void refreshTable2(double[] at,double[] aat,double[] wt,double[] st, double[] et) {
		jtTableWindow1.refreshTable(at,aat,wt,st,et);
	}
	
	public void refreshTable3(double[] at,double[] aat,double[] wt,double[] st, double[] et) {
		jtTableWindow2.refreshTable(at,aat,wt,st,et);
	}
	
	public void refreshTable4(double[] at,double[] aat,double[] wt,double[] st, double[] et) {
		jtTableWindow3.refreshTable(at,aat,wt,st,et);
	}
	
	public void refreshTable5(double[] at,double[] aat,double[] wt,double[] st, double[] et) {
		jtTableWindow4.refreshTable(at,aat,wt,st,et);
	}
	
	public int getHorasTrabajo() {
		return Integer.parseInt(txHorasTrabajo.getText());
	}
	public int getDiasTrabajo() {
		return Integer.parseInt(txDiasTrabajo.getText());
	}

}
