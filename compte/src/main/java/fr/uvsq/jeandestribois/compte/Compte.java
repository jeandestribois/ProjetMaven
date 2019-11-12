package fr.uvsq.jeandestribois.compte;

public class Compte {

	private int solde;
	Compte() {
		this.solde = 0;
	}
	Compte(int s) {
		if(s<0) this.solde = 0;
		else this.solde = s;
	}
	public int getSolde() {
		return this.solde;
	}
	public void credit(int s) {
		if(s>0) this.solde += s;
	}
	public void debit(int s) {
		if(s>0 && s<=this.solde) this.solde -= s;
	}
	public void virement(Compte c, int s) {
		if(s>0 && s<=this.solde) {
			this.debit(s);
			c.credit(s);
		}
	}
}
