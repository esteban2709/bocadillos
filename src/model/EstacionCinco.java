package model;

import java.util.Random;

public class EstacionCinco {
	//lonjasCaja
	public double[] listAT, listAAT, listWT, listST, listET;
	public int cantidadCajas; // cada caja contiene 8 bocadillos
	public double tiempo;
	public Random random;
	
	public EstacionCinco(int lonjasCaja) {
		listAT = new double[lonjasCaja];
		listAAT = new double[lonjasCaja];
		listWT = new double[lonjasCaja];
		listST = new double[lonjasCaja];
		listET = new double[lonjasCaja];
		random = new Random();
	}
	
	public void startStation(int lonjasCaja) {
		empacarBocadilloCaja(lonjasCaja);
		fillList(lonjasCaja);
	}

	private void fillList(double lonjasCaja) {
		for (int i = 0; i < lonjasCaja; i++) {
			if (i==0) {
				listAT[i]= 3+(random.nextDouble()*8);
				listAAT[i]= listAT[0];
				listWT[i] = 0;
				listST[i] = 3+(Math.random()*5);
				listET[i]= listAT[i]+listWT[i]+listST[i];
			}else {
				listAT[i] = 3+(random.nextDouble()*8);
				listAAT[i]= listAAT[i-1]+listAT[i];
				listWT[i] = (Math.max(listET[i-1], listAAT[i]))-listAAT[i];
				listST[i] = 3+(Math.random()*5);
				listET[i]= listAAT[i]+listWT[i]+listST[i];
			}
		}
	}
	
	public void empacarBocadilloCaja(int lonjasCaja) {
		cantidadCajas = lonjasCaja / 8;
		
		for (int i = 0; i < cantidadCajas; i++) {
			tiempo += 5; // se demoran 5 min aproximadamente empacando 8 bocadillos en una caja 
		}
	}
	
	public double getTime() {
		return (tiempo+listET[listET.length-1]);
	}
}
