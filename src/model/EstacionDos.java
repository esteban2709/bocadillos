package model;

import java.util.Random;

/**
 * 
 * @author 
 *	Coresspondiente al proceso de Despulpado y Cocción: 
 *	Dependiendo de la cantidad de cajas se tendra y del 
 *	tamano de la paila se determina la cantidad de veces que se repirte el proceso 
 */
public class EstacionDos {

	public double[] listAT, listAAT, listWT, listST, listET;
	public double totalPulpa;
	public double tamanioPaila=7;//kg
	private Random random;

	public EstacionDos(int numCajas){
		totalPulpa = numCajas*(5 + (Math.random()*10));
		int numVeces = (int)(totalPulpa/tamanioPaila);
		//de cada caja salen un valor aleatorio entre 1 y 5 kg de pulpa
		listAT = new double[numVeces];
		listAAT = new double[numVeces];
		listWT = new double[numVeces];
		listST = new double[numVeces];
		listET = new double[numVeces];
		random = new Random();
	}

	public void startStation() {
		fillLists();
	}
	
	/**
	 * Calculado el numero de veces que se repite el proceso 
	 * se calcula aleatoriamente cuanto tiempo se demora en recibir el producto
	 * y se calcula entre un rango de 40 a 50 (pseudoaleatorio) el tiempo de coccion del producto
	 */
	public void fillLists() {
		int numVeces = (int)(totalPulpa/tamanioPaila);
		for (int i = 0; i < numVeces; i++) {
			if(i==0) {
				listAT[i] = 10+(random.nextDouble()*30);
				listAAT[i]= listAT[0];
				listWT[i] = 0;
				listST[i] = 40+(Math.random()*10);
				listET[i]= listAT[i]+listWT[i]+listST[i];
			}else {
				listAT[i] = 10+(random.nextDouble()*30);
				listAAT[i]= listAAT[i-1]+listAT[i];
				listWT[i] = (Math.max(listET[i-1], listAAT[i]))-listAAT[i];
				listST[i] = 40+(Math.random()*10);
				listET[i]= listAAT[i]+listWT[i]+listST[i];
			}
		}
	}
	
	/**
	 * Tiemṕo tardanza segun el numero de veces que se repite el proceso
	 * @return
	 */
	public double getTime() {
		double time = 0;
		try {
			time= listET[listET.length-1];
		} catch (Exception e) {
			System.out.println("#######Error######");
		}
		
		return time;
	}
	
	public double getTotalPulpa() {
		return totalPulpa;
	}
}
