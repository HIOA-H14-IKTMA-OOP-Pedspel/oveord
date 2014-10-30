package ToF_leikemappe;

import java.awt.Container;
import java.awt.Panel;

public class oppgavetype_input {

	private String oppgaveOrd;
	private String oppgaveSvar;
	private int nivaa;
	private boolean besvart; // True n�r spelar har besvart oppg�va (er ferdig)
	private Panel grensesnitt;
	
	
	public oppgavetype_input(String oppgaveOrd, String oppgaveSvar, int nivaa) {
		/*
		 * Konstrukt�ren. Initialiserer egenskapane til objektet. 
		 */
		super();
		this.oppgaveOrd = oppgaveOrd;
		this.oppgaveSvar = oppgaveSvar;
		this.nivaa = nivaa;
		this.setBesvart(true);
	}
	
	public Panel visOppgave(){
		
		/*  Inspirert av: http://cs.nyu.edu/~yap/classes/visual/03s/lect/l7/
		 * Ideen her, som kanskje ikkje er smart, er at denne metoden returnerer eit panel. 
		 * ut fr� tanken om at det er eit element som kan puttast inn i eit vindu. 
		 */ 
		grensesnitt.add( this.visOppgaveSporsmaalet() ); // Vi legg til sp�rsm�ldelen.
		grensesnitt.add( this.visOppgaveSvarInputPanel() ); // Og svardelen...
		grensesnitt.add( this.visSvarPaaOppgavePanel() ); // Og send-svar-delen. 
		return grensesnitt; 
	}
	
	private Panel visOppgaveSporsmaalet(){
		Panel oppgaveSporsmaalPanelet = null; // M� finne riktig type panel. 
		/*
		 * Intern metode for � lage layouten for sp�rsm�let, slik det blir presentert.
		 * Her blir det laga fleire panel, som blir organisert via ulike layouts. 
		 */
		return oppgaveSporsmaalPanelet; 
	}
	
	private Panel visOppgaveSvarInputPanel(){
		Panel oppgaveSvarInputPanelet = null; // M� finne riktig type panel. 
		/*
		 * Intern metode for � lage layouten for SVAR-input.
		 * Her blir det laga fleire panel, som blir organisert via ulike layouts. 
		 *	Det vil nok i versjon 1 v�re ein JOptionPane.showInputDialog(), berre for � f� inn data enkelt
		 */
		return oppgaveSvarInputPanelet;
		
	}
	private Panel visSvarPaaOppgavePanel(){
		Panel sendSvarPanelet = null; // M� finne riktig type panel. 
		/*
		 * Innheld ein "Send-svar" button, som har eventlistener p� � setje oppg�va "besvart"
		 * Overfl�dig i versjon 1 om en brukar JOptionPane.showInputDialog() til svaret. 
		 */
		return sendSvarPanelet;
		
	}

	public boolean getBesvart() {
		return besvart;
	}
	
}
