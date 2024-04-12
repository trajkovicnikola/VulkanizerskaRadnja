package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import auto_radnja.Radnja;
import auto_radnja.gume.AutoGuma;

public abstract class RadnjaTest {
	
	Radnja r;
	AutoGuma g1,g2;
	
	public abstract Radnja getInstance();

	@BeforeEach
	void setUp() throws Exception {
		r=getInstance();
		g1=new AutoGuma("BMW 116d",18,200,90);
		g2=new AutoGuma("BMW 118d",19,200,90);
	}

	@AfterEach
	void tearDown() throws Exception {
		r=null;
		g1=null;
		g2=null;
	}

	@Test
	void testDodajGumuNull() {
		assertThrows(java.lang.NullPointerException.class,()->{
			r.dodajGumu(null);
		});
	}
	
	@Test
	void testDodajGumuDuplikat() {
		r.dodajGumu(g1);
		assertThrows(java.lang.RuntimeException.class,()->{
			r.dodajGumu(g1);
		});
	}
	
	@Test
	void testDodajGumu() {
		r.dodajGumu(g1);
		List<AutoGuma> sve=r.vratiSveGume();
		assertEquals(g1, sve.get(0));
		assertEquals(1,sve.size());
	}

	
	@Test
	void testDodajGumuVise() {
		r.dodajGumu(g1);
		r.dodajGumu(g2);
		List<AutoGuma> sve=r.vratiSveGume();
		assertEquals(g1, sve.get(0));
		assertEquals(g2, sve.get(1));
		assertEquals(2,sve.size());
	}
	
	
	@Test
	void testPronadjiGumuNull() {
		assertNull(r.pronadjiGumu(null));
	}
	
	@Test
	void testPronadjiGumuNema() {
		r.dodajGumu(g1);
		r.dodajGumu(g2);
		List<AutoGuma> iste=r.pronadjiGumu("BMW 120d");
		assertEquals(0,iste.size());
		
	}
	
	@Test
	void testPronadjiGumu() {
		r.dodajGumu(g1);
		g2.setMarkaModel("BMW 116d");
		g2.setPrecnik(20);
		r.dodajGumu(g2);
		List<AutoGuma> iste=r.pronadjiGumu("BMW 116d");
		assertEquals(2, iste.size());
	}

	
}
