package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.EstacionCinco;
import model.EstacionCuatro;
import model.EstacionDos;
import model.EstacionTres;
import model.EstacionUno;
import view.MainWindow;
import view.WindowPrincipal;

public class Controller implements ActionListener{
	

	public int numCajasE,numCajasB;
	
	public EstacionUno estacionUno;
	public EstacionDos estacionDos;
	public EstacionTres estacionTres;
	public EstacionCuatro estacionCuatro;
	public EstacionCinco estacionCinco;
	public double horasAcumuladas; //horas
	public double diasAcumulados; //dias
	public double TOTAL_DIAS = 25; //dias
	public double HORAS_TRABAJO_DIAS=8; //horas- jornada de trabajo diaria
	public WindowPrincipal windowPrincipal;
	public MainWindow mainWindow;
	public int stockCajas;
	public int lonjasTotal;
	public int cajasEntran;
	
	public Controller() {
		mainWindow = new MainWindow(this);
		start();
	}
	
	
	private void actualizar() {
		System.out.println("Se ha presionado el boton actualizar");
		diasAcumulados=0;
		horasAcumuladas=0;
		stockCajas=0;
		lonjasTotal=0;
		HORAS_TRABAJO_DIAS=mainWindow.getHorasTrabajo();
		TOTAL_DIAS=mainWindow.getDiasTrabajo();
		mainWindow.dispose();
		start();
		mainWindow = new MainWindow(this);
		mainWindow.refreshTable1(estacionUno.listAT, estacionUno.listAAT, estacionUno.listWT, estacionUno.listST, estacionUno.listET);
		mainWindow.refreshTable2(estacionDos.listAT, estacionDos.listAAT, estacionDos.listWT, estacionDos.listST, estacionDos.listET);
		mainWindow.refreshTable3(estacionTres.listAT, estacionTres.listAAT, estacionTres.listWT, estacionTres.listST, estacionTres.listET);
		mainWindow.refreshTable4(estacionCuatro.listAT, estacionCuatro.listAAT, estacionCuatro.listWT, estacionCuatro.listST, estacionCuatro.listET);
		mainWindow.refreshTable5(estacionCinco.listAT, estacionCinco.listAAT, estacionCinco.listWT, estacionCinco.listST, estacionCinco.listET);
	}

	public void start() {
		while (diasAcumulados<TOTAL_DIAS) {
			//Cajas que ingresan
			numCajasB = findCajas();
			System.out.println("Número de cajas que no se dañaron "+numCajasB);
			cajasEntran+=numCajasB;
			//Estacion Uno
			System.out.println("********* Estacion 1 **********");
			estacionUno = new EstacionUno(numCajasB);
			estacionUno.startStation();
			diasAcumulados++;//
			horasAcumuladas +=estacionUno.getTime()/60;//calcula tiempo en horas
			//valida que no pasen 8 horas
			System.out.println("Se lavaron "+ numCajasB+" y se gasto "+ estacionUno.getTime()/60 + " horas");
			if(horasAcumuladas>HORAS_TRABAJO_DIAS) {
				horasAcumuladas= (horasAcumuladas-HORAS_TRABAJO_DIAS);
				diasAcumulados++;
			}
			if(diasAcumulados>=TOTAL_DIAS) {
				System.out.println("Paro en la estación Uno");
				break;
			}
			mainWindow.refreshTable1(estacionUno.listAT, estacionUno.listAAT,
					estacionUno.listWT, estacionUno.listST, estacionUno.listET);
			
			//Estacion Dos
			System.out.println("********* Estacion 2 **********");
			estacionDos = new EstacionDos(numCajasB);
			estacionDos.startStation();
			horasAcumuladas +=estacionDos.getTime()/60;
			System.out.println("Se obtuvo "+ estacionDos.getTotalPulpa()+" kg de pulpa y se gasto "+ estacionDos.getTime()/60 + " horas");
			if(horasAcumuladas>HORAS_TRABAJO_DIAS) {
				horasAcumuladas= (horasAcumuladas-HORAS_TRABAJO_DIAS);
				diasAcumulados++;
			}
			if(diasAcumulados>=TOTAL_DIAS) {
				System.out.println("Paro en la estación dos");
				break;
			}
			mainWindow.refreshTable2(estacionDos.listAT, estacionDos.listAAT,
					estacionDos.listWT, estacionDos.listST, estacionDos.listET);
			
			//Estacion Tres
			System.out.println("********* Estacion 3 **********");
			estacionTres = new EstacionTres(estacionDos.getTotalPulpa());
			estacionTres.startStation(estacionDos.getTotalPulpa());
			horasAcumuladas +=estacionTres.getTime()/60;
			System.out.println("Se obtuvo "+ estacionTres.numMoldes+" moldes y se gasto "+ estacionTres.getTime()/60 + " horas");
			if(horasAcumuladas>HORAS_TRABAJO_DIAS) {
				horasAcumuladas= (horasAcumuladas-HORAS_TRABAJO_DIAS);
				diasAcumulados++;
			}
			if(diasAcumulados>=TOTAL_DIAS) {
				System.out.println("Paro en la estación tres");
				break;
			}
			diasAcumulados = diasAcumulados+2;
			mainWindow.refreshTable3(estacionTres.listAT, estacionTres.listAAT,
					estacionTres.listWT, estacionTres.listST, estacionTres.listET);
			
			//Estacion Cuatro
			System.out.println("********* Estacion 4 **********");
			estacionCuatro = new EstacionCuatro(estacionTres.numMoldes);
			estacionCuatro.startStation(estacionTres.numMoldes);
			horasAcumuladas += estacionCuatro.getTime()/60;
			System.out.println("Se obtuvo "+ estacionCuatro.lonjasCaja+" lonjas repartidas en "
					+ estacionTres.numMoldes+" moldes, y se gasto "+estacionCuatro.getTime()/60 + " horas");
			if(horasAcumuladas>HORAS_TRABAJO_DIAS) {
				horasAcumuladas= (horasAcumuladas-HORAS_TRABAJO_DIAS);
				diasAcumulados++;
			}
			if(diasAcumulados>=TOTAL_DIAS) {
				System.out.println("Paro en la estación cuatro");
				break;
			}
			mainWindow.refreshTable4(estacionCuatro.listAT, estacionCuatro.listAAT,
					estacionCuatro.listWT, estacionCuatro.listST, estacionCuatro.listET);
			
			//Estacion Cinco
			System.out.println("********* Estacion 5 **********");
			estacionCinco = new EstacionCinco(estacionCuatro.lonjasCaja);
			estacionCinco.startStation(estacionCuatro.lonjasCaja);
			horasAcumuladas += estacionCinco.getTime()/60;
			System.out.println("Se obtuvo "+estacionCinco.cantidadCajas+" cajas cada una con 8 bocadillos, y en total hay "
					+ estacionCuatro.lonjasCaja+ " lonjas de caja, y se gasto "+ estacionCinco.getTime()/60+" horas");
			if(horasAcumuladas>HORAS_TRABAJO_DIAS) {
				horasAcumuladas= (horasAcumuladas-HORAS_TRABAJO_DIAS);
				diasAcumulados++;
			}
			if(diasAcumulados>=TOTAL_DIAS) {
				System.out.println("Paro en la estación cinco");
				break;
			}
			lonjasTotal += estacionCuatro.lonjasCaja;
			stockCajas += estacionCinco.cantidadCajas;
			mainWindow.refreshTable5(estacionCinco.listAT, estacionCinco.listAAT,
					estacionCinco.listWT, estacionCinco.listST, estacionCinco.listET);
			
			System.out.println("Finalizo proceso");
			System.out.println("************************");
			System.out.println("************************");
			System.out.println("************************");
			System.out.println("************************");
			System.out.println("************************");
		}
		
		System.out.println("transcurrieron "+diasAcumulados+ " dias y fueron "+horasAcumuladas);
		System.out.println("al final ingresaron "+ cajasEntran+" cajas");
		System.out.println("y se obtuvo en todos esos días "+stockCajas+ "cajas con 8 lonjas cada una, dando un total de "+lonjasTotal+" bocadillos de guayaba");
		//
		
	}
	
	
	
	/**
	 * Metodo encargado de obtener cajas, y tener una probabilidad
	 * de que se dañe de 0.85 (85%)
	 * @return una cantidad de cajas 
	 */
	public int findCajas() {
		numCajasE = 4 + (int)(Math.random()*10);
		System.out.println("Número de cajas que entran a bodega "+numCajasE);
		int countCajas=0;
		for (int i = 0; i < numCajasE; i++) {
			if(Math.random()<0.85) {
				countCajas++;
			}else {
				System.out.println("Caja dañada");
			}
		}
		return countCajas;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		
		if(e.getActionCommand().equalsIgnoreCase("mas informacion")) {
			windowPrincipal= new WindowPrincipal(this);
		}
		
		if(e.getActionCommand().equalsIgnoreCase("Actualizar")) {
			actualizar();
		}
		
		
	}
	
}
