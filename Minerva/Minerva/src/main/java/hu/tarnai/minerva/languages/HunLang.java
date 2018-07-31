package hu.tarnai.minerva.languages;

import java.util.HashMap;

import javax.servlet.http.HttpSession;

public class HunLang {
	private HashMap<String, String> hun;

	public HunLang() {
		hun = new HashMap<String, String>();
		hun.put("foldal_napimenu", "Aktuális heti menünk.");
		hun.put("foldal_nincs", "Erre a napra nincsen napimenü!");
		hun.put("foldal_leves", "Leves");
		hun.put("foldal_fetel", "Főétel");
		hun.put("foldal_koret", "Köret");
		
		hun.put("footer_contact", "Elérhetőségek:");
		hun.put("footer_address", "Tel: 52-646-846; Email: minerva@minerva.hu; Cím: Debrecen, Kossuth Lalyos utca 52.");
		
		hun.put("menu_pansio", "Minerva Panzió");
		hun.put("menu_etterem", "Étterem");
		hun.put("menu_napi", "Heti menü");
		hun.put("menu_etlap", "Étlap");
		hun.put("menu_galeria", "Galéria");
		hun.put("menu_info", "Információk");
		hun.put("menu_szolgaltat", "Szolgáltatásaink");
		hun.put("menu_arak", "Árak");
		hun.put("menu_varos", "Város információ");
		hun.put("menu_gyik", "Gyakori kérdések");
		hun.put("menu_ajanlat", "Ájánlatkérés");
		hun.put("menu_kapcsolat", "Kapcsolatok");
		
		hun.put("heti_cim", "Heti menü");
		hun.put("heti_cim2", "Minerva Étterem");
		hun.put("heti_cim3", "4024 Debrecen, Kossuth U. 59. Tel.: (52) 531-363");
		hun.put("heti_utalvany", "Erzsébet utalványt, SZÉP kártyát, étkezési jegyeket elfogadunk!");
		hun.put("heti_parkolo", "Az étterem elõtt gépkocsi parkolók találhatók.");
		hun.put("heti_menuar", "MENÜ ÁR bruttó 1.050,- Ft/nap");
		hun.put("heti_savanyu", "A menühöz kis adag csemege uborka, káposztasaláta rendelhető bruttó 170,- Ft/adag áron.");
		hun.put("heti_csere", "Amennyiben a levest nem szereti, azt felár nélkül cseréljük csontlevesre.");
		hun.put("heti_jog", "A változtatás jogát fenntartjuk!");
		hun.put("heti_elojegyzes", "Elõjegyzést felveszünk!");
		hun.put("heti_nap", "Nap");
		hun.put("heti_leves", "Leves");
		hun.put("heti_foetel", "Főétel");
		hun.put("heti_koret", "Köret");
		
		hun.put("etlap_cim", "Étlap");
		hun.put("etlap_etel", "Étel");
		hun.put("etlap_alergen", "Allergének");
		hun.put("etlap_ar", "Ár");
		hun.put("etlap_kep", "Kép");
		hun.put("etlap_nincs_kep", "Nincs kép");
	}
	
	public static void set(HttpSession session) {
		HunLang lang = new HunLang();
		for(String key:lang.hun.keySet()) {
			session.setAttribute(key, lang.getHun().get(key));
		}
	}

	public HashMap<String, String> getHun() {
		return hun;
	}

	public void setHun(HashMap<String, String> hun) {
		this.hun = hun;
	}
	
	
	
	
}
