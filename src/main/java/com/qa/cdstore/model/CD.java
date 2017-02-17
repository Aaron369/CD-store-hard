package com.qa.cdstore.model;

import javax.persistence.Entity;
import javax.persistence.Id;
@Entity
public class CD {
	
	@Id
	int Id;
	String artitst;
	String song;
	String genre;
	
	public CD(){
		
	};
	
	public CD(int id, String artitst, String song, String genre) {
		// TODO Auto-generated constructor stub
	}
	
	
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getArtitst() {
		return artitst;
	}
	public void setArtitst(String artitst) {
		this.artitst = artitst;
	}
	public String getSong() {
		return song;
	}
	public void setSong(String song) {
		this.song = song;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	
}
