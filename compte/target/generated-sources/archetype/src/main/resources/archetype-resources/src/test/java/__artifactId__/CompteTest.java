#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.${artifactId};

import org.junit.Test;

import junit.framework.TestCase;

public class CompteTest extends TestCase {
	
	@Test
	public void testConstructeur() {
		Compte c1 = new Compte();
		Compte c2 = new Compte(-1);
		Compte c3 = new Compte(40);
		
		assertEquals(c1.getSolde(), 0);
		assertEquals(c1.getSolde(), c2.getSolde());
		assertEquals(c3.getSolde(), 40);
	}
	
	@Test
	public void testDebit() {
		Compte c1 = new Compte(40);
		c1.debit(-20);
		assertEquals(c1.getSolde(), 40);
		c1.debit(100);
		assertEquals(c1.getSolde(), 40);
		c1.debit(10);
		assertEquals(c1.getSolde(), 30);
	}
	
	@Test
	public void testCredit() {
		Compte c1 = new Compte(40);
		c1.credit(-20);
		assertEquals(c1.getSolde(), 40);
		c1.credit(20);
		assertEquals(c1.getSolde(), 60);
	}
	
	@Test
	public void testVirement() {
		Compte c1 = new Compte(40);
		Compte c2 = new Compte(60);
		c1.virement(c2, 50);
		assertEquals(c1.getSolde(), 40);
		assertEquals(c2.getSolde(), 60);
		
		c1.virement(c2, -20);
		assertEquals(c1.getSolde(), 40);
		assertEquals(c2.getSolde(), 60);
		
		c1.virement(c2, 10);
		assertEquals(c1.getSolde(), 30);
		assertEquals(c2.getSolde(), 70);
	}
}
