package com.jercodes.api;

import com.badlogic.gdx.utils.Array;

public class Signal<T> {
	private Array<Listener<T>> listeners;
	
	
	public Signal(){		
		listeners =  new Array<Listener<T>>();
	}
	
	public void dispatch(T data){
		for (int i = 0; i < listeners.size; i++) {
			listeners.get(i).receive(this, data);
		}
	}
	
	public void add(Listener<T> newListener){
		listeners.add(newListener);
	}
}
