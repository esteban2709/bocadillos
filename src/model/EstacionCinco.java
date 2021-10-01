package model;

import java.util.Random;

/**
 * Estacion 5: embalado y etiquetado
 *
 */
public class EstacionCinco {
	public double[] listAT, listAAT, listWT, listST, listET;
	public int cantidadCajas; // cada caja contiene 8 bocadillos
	public double tiempo;
	public Random random;
	
	/**
	 * Constructor que inicialia las listas de la estacion
	 * @param lonjasCaja
	 */
	public EstacionCinco(int lonjasCaja) {
		listAT = new double[lonjasCaja];
		listAAT = new double[lonjasCaja];
		listWT = new double[lonjasCaja];
		listST = new double[lonjasCaja];
		listET = new double[lonjasCaja];
		random = new Random();
	}
	
	/**
	 * Inicia el proceso de la quinta estacion
	 * @param lonjasCaja numero de lonjas
	 */
	public void startStation(int lonjasCaja) {
		empacarBocadilloCaja(lonjasCaja);
		fillList(lonjasCaja);
	}

	/**
	 * Proceso de las colas con un tiempo de arribo de entre 3 y 12 minutos
	 * y un servicio de 3 a 5 minutos
	 * @param lonjasCaja
	 */
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
	/**
	 * Empaca las lonjas en cajas 
	 * @param lonjasCaja
	 */
	public void empacarBocadilloCaja(int lonjasCaja) {
		cantidadCajas = lonjasCaja / 8;
		for (int i = 0; i < cantidadCajas; i++) {
			tiempo += 5; // se demoran 5 min aproximadamente empacando 8 bocadillos en una caja 
		}
	}
	
	/**
	 * retorna el tiempo total que tomo esta estacion
	 * @return
	 */
	public double getTime() {
		return (tiempo+listET[listET.length-1]);
	}
}
