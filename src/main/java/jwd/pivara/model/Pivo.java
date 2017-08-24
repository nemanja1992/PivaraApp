package jwd.pivara.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;




@Entity
@Table
public class Pivo {
	@Id
	@GeneratedValue
	@Column
	private Long id;
	@Column
	private String naziv;
	@Column
	private double procenatAlkohola;
	@Column
	private double ibu;
	@Column
	private Integer kolicina;
	@ManyToOne(fetch=FetchType.EAGER)
	private Pivara pivara;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNaziv() {
		return naziv;
	}
	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}
	public double getProcenatAlkohola() {
		return procenatAlkohola;
	}
	public void setProcenatAlkohola(double procenatAlkohola) {
		this.procenatAlkohola = procenatAlkohola;
	}
	public double getIbu() {
		return ibu;
	}
	public void setIbu(double ibu) {
		this.ibu = ibu;
	}
	public Integer getKolicina() {
		return kolicina;
	}
	public void setKolicina(Integer kolicina) {
		this.kolicina = kolicina;
	}
	public Pivara getPivara() {
		return pivara;
	}
	public void setPivara(Pivara pivara) {
		this.pivara = pivara;
		if(pivara!=null && !pivara.getPiva().contains(this)){
			pivara.getPiva().add(this);
		}
	}
}
