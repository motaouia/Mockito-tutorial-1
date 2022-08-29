package org.medmota.mockitodemo.service;

import org.medmota.mockitodemo.config.ConnectionDatabase;

public class Service {
	private ConnectionDatabase connectionDatabase;

	public Service(ConnectionDatabase connectionDatabase) {
		this.connectionDatabase = connectionDatabase;
	}

	public boolean query(String query) {
		return connectionDatabase.isAvailable();
	}

	@Override
	public String toString() {
		return "Using ConnectionDatabase with id: " + String.valueOf(connectionDatabase.getUniqueId());
	}

}
