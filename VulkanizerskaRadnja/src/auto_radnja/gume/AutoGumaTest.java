package auto_radnja.gume;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class AutoGumaTest {

	AutoGuma g;

	@BeforeEach
	void setUp() throws Exception {
		g = new AutoGuma();
	}

	@AfterEach
	void tearDown() throws Exception {
		g = null;
	}

	@Test
	void testAutoGuma() {
		assertNotNull(g);
		assertNull(g.getMarkaModel());
		assertEquals(-1, g.getPrecnik());
		assertEquals(-1, g.getSirina());
		assertEquals(-1, g.getVisina());
	}

	@Test
	void testAutoGumaStringIntIntInt() {
		g = new AutoGuma("BMW 116d", 18, 200, 90);
		assertNotNull(g);
		assertEquals("BMW 116d", g.getMarkaModel());
		assertEquals(18, g.getPrecnik());
		assertEquals(200, g.getSirina());
		assertEquals(90, g.getVisina());

	}

	@Test
	void testSetMarkaModelNull() {
		assertThrows(java.lang.NullPointerException.class, () -> {
			g.setMarkaModel(null);
		});
	}

	@Test
	void testSetMarkaModelPraznString() {
		assertThrows(java.lang.IllegalArgumentException.class, () -> {
			g.setMarkaModel("");
		});
	}

	@Test
	void testSetMarka() {
		g.setMarkaModel("BMW 116d");
		assertEquals("BMW 116d", g.getMarkaModel());
	}

	@ParameterizedTest
	@CsvSource({ "10", "30" })
	void testSetPrecnikVanOpsega(int precnik) {
		assertThrows(java.lang.IllegalArgumentException.class, () -> {
			g.setPrecnik(precnik);
		});
	}

	@Test
	void testSetPrecnik() {
		g.setPrecnik(18);
		assertEquals(18, g.getPrecnik());
	}

	@ParameterizedTest
	@CsvSource({ "100", "400" })
	void testSetSirinaVanOpsega(int sirina) {
		assertThrows(java.lang.IllegalArgumentException.class, () -> {
			g.setSirina(sirina);
		});
	}
	
	

	void testSetSirina() {
		g.setSirina(300);
		assertEquals(300, g.getSirina());
	}

	@Test
	void testSetVisina() {
		g.setVisina(70);
		assertEquals(70, g.getVisina());
	}
	
	@ParameterizedTest
	@CsvSource({ "20", "400" })
	void testVisinaVanOpsega(int visina) {
		assertThrows(java.lang.IllegalArgumentException.class, () -> {
			g.setSirina(visina);
		});
	}

	@Test
	void testToString() {
		g = new AutoGuma("BMW 116d", 18, 200, 90);
		String s=g.toString();
		assertTrue(s.contains("BMW 116d"));
		assertTrue(s.contains("18"));
		assertTrue(s.contains("200"));
		assertTrue(s.contains("90"));
	}

	@Test
	void testEqualsObjectIsti() {
		AutoGuma g2=g;
		assertTrue(g.equals(g2));
	}
	
	@ParameterizedTest
	@CsvSource({"BMW 116d,18,200,90,BMW 118d,18,200,90,false",
				"BMW 116d,18,200,90,BMW 116d,20,200,90,false",
				"BMW 116d,18,200,90,BMW 116d,18,205,90,false",
				"BMW 116d,18,200,90,BMW 116d,18,200,93,false",
				"BMW 116d,18,200,90,BMW 116d,18,200,90,true",
	})
	void testEqualsObjectSveOk(String markaModel1,int precnik1,int sirina1, int visina1,String markaModel2,int precnik2,int sirina2, int visina2,boolean eq) {
		g=new AutoGuma(markaModel1, precnik1, sirina1, visina1);
		AutoGuma g2=new AutoGuma(markaModel2, precnik2, sirina2, visina2);
		assertEquals(eq, g.equals(g2));
	}

}
