package org.medmota.mockitodemo.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.medmota.mockitodemo.config.ConnectionDatabase;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

/*
 	Tells Mockito to create the mocks based on the @Mock annotation, this requires JUnit 5, 
 	if you an oder version of JUnit, call Mock.init() in your setup method
 */
@ExtendWith(MockitoExtension.class)
public class ServiceTest {

	@Mock
	ConnectionDatabase connectionDatabase;

	@Test
	void testQuery() {
		assertNotNull(connectionDatabase);
		when(connectionDatabase.isAvailable()).thenReturn(true);
		Service service = new Service(connectionDatabase);
		assertTrue(service.query("Bla__Nothing"));
	}

	@Test
	void ensureMockitoReturnsTheConfiguredValue() {

		// define return value for method getUniqueId()
		when(connectionDatabase.getUniqueId()).thenReturn(42);

		Service service = new Service(connectionDatabase);
		// use mock in test....
		assertEquals("Using ConnectionDatabase with id: 42", service.toString());
	}

}
