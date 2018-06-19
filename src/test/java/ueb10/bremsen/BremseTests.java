package ueb10.bremsen;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import static org.junit.jupiter.api.Assertions.*;

class BremseTests {

	@Test
	void testForHierarchy() throws NoSuchMethodException {
		// Bremse must now be abstract class!
		assertFalse(Bremse.class.isInterface());
		assertTrue(Modifier.isAbstract(Bremse.class.getModifiers()));

		// ...must have two String attributes
		int nstr = 0;
		for (Field f : Bremse.class.getDeclaredFields()) {
			// must be string _and_ private
			if (f.getType().equals(String.class) && Modifier.isPrivate(f.getModifiers()))
				nstr++;
		}
		assertEquals(2, nstr);

		// ...and require `bremsen` as abstract method
		assertTrue(Modifier.isAbstract(Bremse.class.getMethod("bremsen").getModifiers()));

		// brakes must now extend Bremse!
		assertEquals(Cantileverbremse.class.getSuperclass(), Bremse.class);
		assertEquals(Scheibenbremse.class.getSuperclass(), Bremse.class);
		assertEquals(Trommelbremse.class.getSuperclass(), Bremse.class);
	}
}