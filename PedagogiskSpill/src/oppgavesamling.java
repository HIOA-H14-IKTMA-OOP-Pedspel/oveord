/**
 * @author Torbjorn
 *
 */

import java.awt.Panel;
import java.awt.Window;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class oppgavesamling {

	private Scanner fil;
	private oppgavetype_input oppgaver[];
	private Panel grensesnitt;
	private int oppgaver_sorteringsliste[]; // Innheld sorteringsrekkef�lga, produsert av metode sorter()

	
	public oppgavesamling(Scanner fil) {
		/*
		 * Konstrukt�ren 
		 */
		super();
		// Muligens redundant, kan sikker hente ut filnavnet fr� this.fil, men tek med inntil vidare: 
		this.fil = fil; // Hentar inn "innlesteOppgaver.txt" (el.l.), som Kristina produserer i sin klasse
		this.lesInnOppgaveObjekt();  // Lag objekt p� bakgrunn av fila
		this.sorterOppgaver("alfabetisk");  // Sorter dei
		/* 
		 * "Alfabetisk" b�r helst velgast via l�rar si innlegging, eller om l�rar vil, v�re eit alternativ i oppgavesamling-grensesnittet. 
		 */
		this.avgrensUtvalget(10);
		/*
		 * Avgrensing b�r v�re lagt inn av l�rar, eller kunne velgast av spelar, akkurat som sortering. 
		 */
	}
	
	private void lesInnOppgaveObjekt() {
		int oppgaveTeller=1;
		while(this.fil.hasNext()){
			// instansier eit oppgave-objekt, i oppgaver-matrisen. For objektet med data fr� input-fila. 
			oppgaver[oppgaveTeller] = new oppgavetype_input(this.fil.next(), this.fil.next(), Integer.parseInt(this.fil.next()) );
		}
	}
	
	private void sorterOppgaver(String type){
		/*
		 * Endar med at arrayen oppgaver_sorteringsliste har ID'en til oppgave-objekta, "riktig" sortert inni seg (alfabetisk eller...)
		 */
		switch(type){
			case	"random":
				for(int i=1;i>this.oppgaver.length;i++){ // Loop og lag ei tilfeldig liste
					oppgaver_sorteringsliste[i] = (int) Math.random()*this.oppgaver.length; 
				}
				break;
			case 	"alfabetisk":
				// Sorter elementa i array alfabetisk.
				break;
			default: 
				// Sorter elementa slik dei vart skrive inn av l�raren, alts� etter key i oppgave-arrayen. 
		}	
	}

	private void avgrensUtvalget(int antal){
		// kutt arrayen etter "antall" element, alts� skal vi ikkje n�dvendigvis vise alle oppgaver fra tekstfila
	}
	
	public Panel visOppgave(){		
		/* 
		 *  
		 */
		for (int oppgaveNummer : oppgaver_sorteringsliste){
			Panel aktivtOppgavePanel = oppgaver[oppgaveNummer].visOppgave();
			grensesnitt.add(aktivtOppgavePanel);
			while(oppgaver[oppgaveNummer].getBesvart()){
				// vente, dette er muligens ikkje s� smart. 
			}
			grensesnitt.remove(aktivtOppgavePanel); // Fjernar det, s� neste oppg�ve kan visast
		}
		grensesnitt.add( visOppgaveSporsmaalet() ); // Vi legg til sp�rsm�ldelen.
		grensesnitt.add( visOppgaveSvarInputPanel() ); // Og svardelen...
		grensesnitt.add( visSvarPaaOppgavePanel() ); // Og send-svar-delen. 
		return grensesnitt; 
	}	
}

