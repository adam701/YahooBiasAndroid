package com.example.yahoobias;

public class NewsDataModel {

	private String title;
	private String author;
	private String source;
	private String ImageUrl;
	private String ImageUrl1;
	private boolean isAds;
	
	public NewsDataModel(String title, String author, String source,
			String imageUrl, String imageUrl1, String isAds) {
		super();
		this.title = title;
		this.author = author;
		this.source = source;
		ImageUrl = imageUrl;
		this.ImageUrl1 = imageUrl1;
		this.isAds = Boolean.valueOf(isAds);
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public void setImageUrl(String imageUrl) {
		ImageUrl = imageUrl;
	}

	public String getTitle() {
		return title;
	}

	public String getAuthor() {
		return author;
	}

	public String getSource() {
		return source;
	}

	public String getImageUrl() {
		return ImageUrl;
	}

	public void setImageUrl1(String imageUrl1) {
		ImageUrl1 = imageUrl1;
	}

	public void setAds(boolean isAds) {
		this.isAds = isAds;
	}

	public String getImageUrl1() {
		return ImageUrl1;
	}

	public boolean isAds() {
		return isAds;
	}
	
	
}
