package ueb10.formen;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import static org.junit.jupiter.api.Assertions.*;

class VolumenTests {
	@Test
	void testAbstrakt() throws NoSuchMethodException {

		// Volumen muss abstract sein
		assertFalse(Volumen.class.isInterface());
		assertTrue(Modifier.isAbstract(Volumen.class.getModifiers()));

		// ...und `double volumen()` ohne Argumente implementieren
		Method vol = Volumen.class.getDeclaredMethod("volumen");
		assertEquals(vol.getReturnType(), double.class);
		assertEquals(vol.getParameterCount(), 0);
		assertFalse(Modifier.isAbstract(vol.getModifiers()));

		// und muss eine abstrakte Methode haben, welche die Grundfläche implementiert
		Method abstr = null;
		for (Method m : Volumen.class.getDeclaredMethods()) {
			// nicht diese...
			if (m.getName().equals("volumen"))
				continue;

			// auch nicht diese...
			if (m.getParameterCount() > 0)
				continue;

			// Wir suchen: abstract [double|float] grundflaeche()
			if (Modifier.isAbstract(m.getModifiers()) &&
					(m.getReturnType().equals(double.class) || m.getReturnType().equals(float.class))) {
				// darf noch nicht gesetzt sein, wir brauchen genau eine Methode
				assertNull(abstr);
				abstr = m;
			}
		}

		// andere Klassen muessen direkt erben und konkret sein (ergo volumen implementieren)
		assertEquals(DreiecksPrisma.class.getSuperclass(), Volumen.class);
		assertFalse(Modifier.isAbstract(DreiecksPrisma.class.getModifiers()));

		assertEquals(Quader.class.getSuperclass(), Volumen.class);
		assertFalse(Modifier.isAbstract(Quader.class.getModifiers()));

		assertEquals(Zylinder.class.getSuperclass(), Volumen.class);
		assertFalse(Modifier.isAbstract(Zylinder.class.getModifiers()));

		assertEquals(ZylindrischesRohr.class.getSuperclass(), Volumen.class);
		assertFalse(Modifier.isAbstract(ZylindrischesRohr.class.getModifiers()));
	}

}