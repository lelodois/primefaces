package br.com.lelo.precojsf.model;

public class Comprador extends Usuario {

	private static final long serialVersionUID = -5850040161105005863L;

	private int rating;

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

}