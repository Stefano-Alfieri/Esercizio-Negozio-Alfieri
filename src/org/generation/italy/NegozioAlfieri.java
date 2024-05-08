package org.generation.italy;
//importo scanner
import java.util.Scanner;

public class NegozioAlfieri {

	public static void main(String[] args) {
		// inizio main

		// creazione scanner
		Scanner sc = new Scanner(System.in);
		//benvenuto lato gestore
		System.out.println("Benvenuto nel tuo negozio");
		System.out.println("Inserire il numero di prodotti in vendità:");
		//richiesta prodfotti in vendita
		int numeroArticoli = sc.nextInt();
		sc.nextLine();
		//creazione dati e array
		String[] nomiProdotti = new String[numeroArticoli];
		double[] prezzoProdotti = new double[numeroArticoli];
		int[] quantitaProdotti = new int[numeroArticoli];
		int i = 0;
		String rispAcquisto;
		//inizio ciclo for per inserimento elementi in array
		for (i = 0; i < numeroArticoli; i++) {
			System.out.println("inserire il nome dell'articolo:");
			nomiProdotti[i] = sc.nextLine().toLowerCase();
			System.out.println("inserire il prezzo dell'articolo inserito:");
			prezzoProdotti[i] = sc.nextDouble();
			sc.nextLine();
			System.out.println("inserire il quantità disponibile dell'articolo:");
			quantitaProdotti[i] = sc.nextInt();
			sc.nextLine();

		}
		// inizio lato utente
		System.out.println("Buongiorno, inserire il nome del prodotto che si vuole acquistare?");
		int quantitaScelta = 0;
		int indiceProdotto = -1;
		//ciclo DO-WHILE
		do {
			//variabile con nomi elementi da cercare
			String daCercare = sc.nextLine();
			//ciclo for  per ricerca prodotti in array
			for (i = 0; i < nomiProdotti.length; i++) {
				//condizione per ricerca elemento contenuto
				if (nomiProdotti[i].contains(daCercare)) {
					indiceProdotto = i;
				}
			} //condizione inserimento quantità articoli da comprare
			if (indiceProdotto != -1) {
				System.out.println("inserire la quantità da acquistare del prodotto scelto:");
				quantitaScelta = sc.nextInt();
				sc.nextLine();
				//condizione di verifica disponibilità sufficente
				if (quantitaScelta <= quantitaProdotti[indiceProdotto]) {
					//elementi rimossi dalla quantità prodotto
					quantitaProdotti[indiceProdotto] -= quantitaScelta;
					//importo totale
					double importoTotale = prezzoProdotti[indiceProdotto] * quantitaScelta;
					System.out.println("Acquisto avvenuto con successo, importo da pagare: " + importoTotale);
					//condizione quanttità insufficente
				} else {
					System.out.println("Quantità non disponibile per l'acquisto");
				}
				//condizione prodotto non trovato in array
			} else {
				System.out.println("Prodotto non trovato nel negozio");
			}
			//richiesta altri acquisti
			System.out.println("vuoi acquistare altri prodotti?");
			rispAcquisto = sc.nextLine();
			//condizione restart
			if (rispAcquisto.equalsIgnoreCase("si") || rispAcquisto.equalsIgnoreCase("sì")) {
				System.out.println("inserire il nome del nuovo articolo che si vuole acquistare:");
			}
			//condizione di ritorno nel ciclo do while
		} while (rispAcquisto.equalsIgnoreCase("si") || rispAcquisto.equalsIgnoreCase("sì"));
		//fine ciclo do while
		System.out.println("grazie, arrivederci");
		
	}// fine main

}// fine progetto
