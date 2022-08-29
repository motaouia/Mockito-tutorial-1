package org.medmota.mockitodemo.exptest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;

public class MockitoSpyWithListTest {
	// demonstrates of the spy function
	@Test
	void ensureSpyForListWorks() {
		var list = new ArrayList<String>();
		var spiedList = spy(list);

		doReturn("42").when(spiedList).get(99);
		String value = (String) spiedList.get(99);

		assertEquals("42", value);
	}

	@Test
	public void testForIOException() throws IOException {
		// create an configure mock
		OutputStream mockStream = mock(OutputStream.class);
		doThrow(new IOException()).when(mockStream).close();

		// use mock
		OutputStreamWriter streamWriter = new OutputStreamWriter(mockStream);

		assertThrows(IOException.class, () -> streamWriter.close());
	}

}
