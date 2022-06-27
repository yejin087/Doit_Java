package com.example.myapp09;

public class Movie {
	private int albumId;
	private int id;
	private String title;
	private String url;
	private String tumbnailUrl;
	
	public Movie(int albumId, int id, String title, String url, String tumbnailUrl) {
		this.albumId = albumId;
		this.id = id;
		this.title = title;
		this.url = url;
		this.tumbnailUrl = tumbnailUrl;
	}
	
	public int getAlbumId() {
		return albumId;
	}
	
	public void setAlbumId(int albumId) {
		this.albumId = albumId;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getUrl() {
		return url;
	}
	
	public void setUrl(String url) {
		this.url = url;
	}
	
	public String getTumbnailUrl() {
		return tumbnailUrl;
	}
	
	public void setTumbnailUrl(String tumbnailUrl) {
		this.tumbnailUrl = tumbnailUrl;
	}
}
