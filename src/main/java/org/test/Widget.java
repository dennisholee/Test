package org.test;

public interface Widget<T> {
	T build();

	Widget setLabel(String label);
	
	Widget setURL(String url);
}
