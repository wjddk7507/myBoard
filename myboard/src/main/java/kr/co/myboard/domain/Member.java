package kr.co.myboard.domain;

import java.sql.Date;

public class Member {
	private String id;
	private String pw;
	private String nickname;
	private Date join_date;
	private String profile_img;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public Date getJoin_date() {
		return join_date;
	}
	public void setJoin_date(Date join_date) {
		this.join_date = join_date;
	}
	public String getProfile_img() {
		return profile_img;
	}
	public void setProfile_img(String profile_img) {
		this.profile_img = profile_img;
	}
	@Override
	public String toString() {
		return "Member [id=" + id + ", pw=" + pw + ", nickname=" + nickname + ", join_date=" + join_date
				+ ", profile_img=" + profile_img + "]";
	}
}
