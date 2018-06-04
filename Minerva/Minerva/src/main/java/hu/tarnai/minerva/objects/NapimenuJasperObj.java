package hu.tarnai.minerva.objects;

public class NapimenuJasperObj {
	private String index;
	private String date;
	private String leves;
	private String foetel;
	private String koret;
	
	public NapimenuJasperObj(String index, String date, String leves, String foetel, String koret) {
		this.index = index;
		this.date = date;
		this.leves = leves;
		this.foetel = foetel;
		this.koret = koret;
	}

	public String getIndex() {
		return index;
	}

	public void setIndex(String index) {
		this.index = index;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getLeves() {
		return leves;
	}

	public void setLeves(String leves) {
		this.leves = leves;
	}

	public String getFoetel() {
		return foetel;
	}

	public void setFoetel(String foetel) {
		this.foetel = foetel;
	}

	public String getKoret() {
		return koret;
	}

	public void setKoret(String koret) {
		this.koret = koret;
	}
	
}
