package fr.uvsq.jeandestribois.compte;

import junit.framework.TestCase;

public class CompteTest extends TestCase {
	
	public void testConstructeur() {
		Compte c1 = new Compte();
		Compte c2 = new Compte(0);
		Compte c3 = new Compte(-1);
		assertEquals(c1.getSolde(), c2.getSolde());
		assertEquals(c1.getSolde(), c3.getSolde());
	}
	
	public void testCredit() {
		Compte c1 = new Compte(20);
		c1.credit(-1);
		assertEquals(c1.getSolde(), 20);
		c1.credit(50);
		assertEquals(c1.getSolde(), 70);
	}
	
	public void testDebit() {
		Compte c1 = new Compte(20);
		c1.debit(-1);
		assertEquals(c1.getSolde(), 20);
		c1.debit(50);
		assertEquals(c1.getSolde(), 20);
		c1.debit(10);
		assertEquals(c1.getSolde(), 10);
	}
	
	public void testVirement() {
		Compte c1 = new Compte(20);
		Compte c2 = new Compte(40);
		c1.virement(c2, -1);
		assertEquals(c1.getSolde(), 20);
		assertEquals(c2.getSolde(), 40);
		c1.virement(c2, 40);
		assertEquals(c1.getSolde(), 20);
		assertEquals(c2.getSolde(), 40);
		c1.virement(c2, 10);
		assertEquals(c1.getSolde(), 10);
		assertEquals(c2.getSolde(), 50);
	}
}