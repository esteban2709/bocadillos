package view;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

public class JTableWindow extends JPanel {

	private static final long serialVersionUID = 1L;
	private DefaultTableModel model;
	private JTable table;
	private JScrollPane scroll;
	
	public JTableWindow() {
		setLayout(new BorderLayout());
		setSize(900, 900);
		model = new DefaultTableModel();
		table = new JTable(model);
		table.setRowHeight(25);
		init();
		scroll = new JScrollPane(table);
		add(scroll, BorderLayout.CENTER);
	}
		
	
	public void refreshTable(double[] at,double[] aat,double[] wt,double[] st,double[] et) {
		model.setRowCount(0);
		for (int i = 0; i < at.length; i++) {
			model.addRow(new Object[] {at[i],aat[i],wt[i],st[i],et[i]});
		}
	}		
	
	public void init(){
		model.setColumnIdentifiers(new Object[]{"AT","AAT","WT","ST","ET"});
	}
}
