package model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
public class Prodavac extends User {
	
	private int pib;

	public int getPib() {
		return pib;
	}

	public void setPib(int pib) {
		this.pib = pib;
	}

}
