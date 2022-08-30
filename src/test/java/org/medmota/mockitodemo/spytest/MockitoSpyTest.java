package org.medmota.mockitodemo.spytest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.spy;

import java.util.LinkedList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class MockitoSpyTest {

	@Spy
	private List<String> myList = new LinkedList<>();

	@BeforeEach
	void setup() {
		// Alternative way of creating a spy
		// List<String> list = new LinkedList<>();
		// List<String> spy = spy(list);
	}

	@Test
	void testLinkedListSpyCorrect() {

		// when(myList.get(0)).thenReturn("foo");
		// would not work as the delegate it called so myList.get(0)
		// throws IndexOutOfBoundsException (list is still empty)

		// you have to use doReturn() for stubbing
		doReturn("foo").when(myList).get(0);

		assertEquals("foo", myList.get(0));
	}
}
