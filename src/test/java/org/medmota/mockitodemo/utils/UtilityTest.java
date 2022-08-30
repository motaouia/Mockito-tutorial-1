package org.medmota.mockitodemo.utils;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

class UtilityTest {

	@Test
	void shouldMockStaticMethod() {
		try (MockedStatic<Utility> mockedStatic = Mockito.mockStatic(Utility.class)) {

			mockedStatic.when(() -> Utility.getDatabaseConnection(Mockito.eq("test"))).thenReturn("testing");
			mockedStatic.when(() -> Utility.getDatabaseConnection(Mockito.eq("prod"))).thenReturn("production");

			String result1 = Utility.getDatabaseConnection("test");

			assertEquals("testing", result1);
			String result2 = Utility.getDatabaseConnection("prod");
			assertEquals("production", result2);

		}

	}
}
