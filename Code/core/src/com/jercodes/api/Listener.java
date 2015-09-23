package com.jercodes.api;

public interface Listener<T> {

	public void receive(Signal<T> signal, T data);
}
