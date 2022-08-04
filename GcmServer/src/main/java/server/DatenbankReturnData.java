package main.java.server;

import main.java.server.DatenbankReturn;

public class DatenbankReturnData<T> extends DatenbankReturn {
	private T data;

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}
	
}
