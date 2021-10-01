package model;

import java.util.Random;

public class EstacionCuatro {

	public double[] listAT, listAAT, listWT, listST, listET;
	public double tiempo;
	public int lonjasCaja;
	public Random random;

	public EstacionCuatro(int numMoldes){
		listAT = new double[numMoldes];
		listAAT = new double[numMoldes];
		listWT = new double[numMoldes];
		listST = new double[numMoldes];
		listET = new double[numMoldes];
		random = new Random();
	}

	public void startStation(int numMoldes) {
		longear(numMoldes);
		fillLists(numMoldes);
	}

	public void fillLists(int numMoldes) {
		for (int i = 0; i < numMoldes; i++) {
			if(i==0) {
				listAT[i] = 2+(random.nextDouble()*5);
				listAAT[i]= listAT[0];
				listWT[i] = 0;
				listST[i] = 8+(Math.random()*12);
				listET[i]= listAT[i]+listWT[i]+listST[i];
			}else {
				listAT[i] = 2+(random.nextDouble()*5);
				listAAT[i]= listAAT[i-1]+listAT[i];
				listWT[i] = (Math.max(listET[i-1], listAAT[i]))-listAAT[i];
				listST[i] = 8+(Math.random()*12);
				listET[i]= listAAT[i]+listWT[i]+listST[i];
			}
		}
	}

	public void longear(int numMoldes) {
		lonjasCaja= numMoldes*8;
		for (int i = 0; i < lonjasCaja; i++) {
			tiempo++;
		}
		tiempo += 720; //minutos que se demora secando (12 horas)
	}

	public double getTime() {
		double time = 0;
		try {
			time = (tiempo+listET[listET.length-1]);
		} catch (Exception e) {
			System.out.println("#######Error######");
		}
		return time;
	}
}
