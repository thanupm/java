package com.ibm.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="musics")

@NamedQueries({
	@NamedQuery(name="music", query="from Music")
})
public class Music {

	@Id
	private int id;
	@Column(length = 20)
	private String artist;
	@Column(length = 20)
	private String genre;
	private double rating;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getArtist() {
		return artist;
	}
	public void setArtist(String artist) {
		this.artist = artist;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public double getRating() {
		return rating;
	}
	public void setRating(double rating) {
		this.rating = rating;
	}
	@Override
	public String toString() {
		return "Music [id=" + id + ", artist=" + artist + ", genre=" + genre + ", rating=" + rating + "]";
	}
	
	

}
