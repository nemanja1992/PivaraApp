package jwd.pivara.web.dto;



public class PivoDTO {
	private Long id;
	private String naziv;
	private double procenatAlkohola;
	private double ibu;
	private Integer kolicina;
	private Long pivaraId;
	private String pivaraNaziv;
	private String pivaraPib;
	private String pivaraDrzava;
	private Long vrsteId;
	private String vrsteNaziv;
	
	
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
	public Long getPivaraId() {
		return pivaraId;
	}
	public void setPivaraId(Long pivaraId) {
		this.pivaraId = pivaraId;
	}
	public String getPivaraNaziv() {
		return pivaraNaziv;
	}
	public void setPivaraNaziv(String pivaraNaziv) {
		this.pivaraNaziv = pivaraNaziv;
	}
	public String getPivaraPib() {
		return pivaraPib;
	}
	public void setPivaraPib(String pivaraPib) {
		this.pivaraPib = pivaraPib;
	}
	public String getPivaraDrzava() {
		return pivaraDrzava;
	}
	public void setPivaraDrzava(String pivaraDrzava) {
		this.pivaraDrzava = pivaraDrzava;
	}
	public Long getVrsteId() {
		return vrsteId;
	}
	public void setVrsteId(Long vrsteId) {
		this.vrsteId = vrsteId;
	}
	public String getVrsteNaziv() {
		return vrsteNaziv;
	}
	public void setVrsteNaziv(String vrsteNaziv) {
		this.vrsteNaziv = vrsteNaziv;
	}
	
	
}
