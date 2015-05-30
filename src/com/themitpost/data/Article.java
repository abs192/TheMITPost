package com.themitpost.data;

import java.util.Date;

public class Article {

	String title, body, url, imageUrl;
	Author author;
	Date date;
	boolean featured;

	public Article(String title, String body, String url, String imageUrl,
			Author author, Date date) {
		super();
		this.title = title;
		this.body = body;
		this.url = url;
		this.imageUrl = imageUrl;
		this.author = author;
		this.date = date;
	}

	public boolean isFeatured() {
		return featured;
	}

	public void setFeatured(boolean featured) {
		this.featured = featured;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

}
