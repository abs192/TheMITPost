package com.themitpost.data;

public class Author {

	String name;
	int id;
	String alias;

	public Author(String name, int id, String alias) {
		this.name = name;
		this.id = id;
		this.alias = alias;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAlias() {
		return alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}

}
