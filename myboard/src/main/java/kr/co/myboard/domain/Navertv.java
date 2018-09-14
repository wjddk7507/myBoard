package kr.co.myboard.domain;

public class Navertv {
	private String title;
	private String src;
	private String img;
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getSrc() {
		return src;
	}
	public void setSrc(String src) {
		this.src = src;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	@Override
	public String toString() {
		return "Navertv [title=" + title + ", src=" + src + ", img=" + img + "]";
	}
}
