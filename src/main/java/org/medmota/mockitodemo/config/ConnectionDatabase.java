package org.medmota.mockitodemo.config;

public class ConnectionDatabase {

	private int id;
	public boolean isAvailable() {
		// currently not implemented, as this is just demo used in a software test
		return false;
	}

	public int getUniqueId() {
		return 42;
	}
	
	public void setUniqueId(int id) {
		this.id = id;
	}

}
