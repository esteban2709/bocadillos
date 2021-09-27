package view;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import controller.Controller;

public class MainWindow extends JFrame{

	private static final long serialVersionUID = 1L;
	private JTableWindow jtTableWindow,jtTableWindow1,jtTableWindow2,jtTableWindow3,jtTableWindow4;
	private JTabbedPane jTabbedPane;
	private PanelSuperior panelSuperior;
	
	public MainWindow(Controller controller) {
		setTitle("Bocadillo Simuador");
		setSize(700, 500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setLayout(new BorderLayout());
		jTabbedPane = new JTabbedPane();
		initComponents(controller);
		setVisible(true);
	}
	
	private void initComponents(Controller controller) {
		this.panelSuperior = new PanelSuperior(controller);
		this.add(this.panelSuperior , BorderLayout.NORTH);
		
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
		add(jTabbedPane , BorderLayout.CENTER);
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
		return this.panelSuperior.getHorasTrabajo();
	}
	public int getDiasTrabajo() {
		return this.panelSuperior.getDiasTrabajo();
	}

}
