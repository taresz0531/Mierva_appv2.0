package hu.tarnai.minerva.languages;

import java.util.HashMap;

import javax.servlet.http.HttpSession;

public class EngLang {
	private HashMap<String, String> eng;

	public EngLang() {
		eng = new HashMap<String, String>();
		eng.put("foldal_napimenu", "Current week menu.");
		eng.put("foldal_nincs", "There is no daily menu for this day!");
		eng.put("foldal_leves", "Soup");
		eng.put("foldal_fetel", "Main course");
		eng.put("foldal_koret", "Side dish");
		
		eng.put("footer_contact", "Contacts:");
		eng.put("footer_address", "Phone: 52-646-846; Email: minerva@minerva.hu; Address: Debrecen, Kossuth Lalyos street 52.");
		
		eng.put("menu_pansio", "Minerva Pansion");
		eng.put("menu_etterem", "Restaurant");
		eng.put("menu_napi", "Daily menu");
		eng.put("menu_etlap", "Menu");
		eng.put("menu_galeria", "Gallery");
		eng.put("menu_info", "Information");
		eng.put("menu_szolgaltat", "Our services");
		eng.put("menu_arak", "Prices");
		eng.put("menu_varos", "City's information");
		eng.put("menu_gyik", "FaQ");
		eng.put("menu_ajanlat", "Offer");
		eng.put("menu_kapcsolat", "Contact");
		
		eng.put("heti_cim", "Heti menü");
		eng.put("heti_cim2", "Minerva Étterem");
		eng.put("heti_cim3", "4024 Debrecen, Kossuth U. 59. Tel.: (52) 531-363");
		eng.put("heti_utalvany", "Erzsébet utalványt, SZÉP kártyát, étkezési jegyeket elfogadunk!");
		eng.put("heti_parkolo", "Az étterem elõtt gépkocsi parkolók találhatók.");
		eng.put("heti_menuar", "MENÜ ÁR bruttó 1.050,- Ft/nap");
		eng.put("heti_savanyu", "A menühöz kis adag csemege uborka, káposztasaláta rendelhető bruttó 170,- Ft/adag áron.");
		eng.put("heti_csere", "Amennyiben a levest nem szereti, azt felár nélkül cseréljük csontlevesre.");
		eng.put("heti_jog", "A változtatás jogát fenntartjuk!");
		eng.put("heti_elojegyzes", "Elõjegyzést felveszünk!");
		eng.put("heti_nap", "Nap");
		eng.put("heti_leves", "Leves");
		eng.put("heti_foetel", "Főétel");
		eng.put("heti_koret", "Köret");
	}
	
	public static void set(HttpSession session) {
		EngLang lang = new EngLang();
		for(String key:lang.eng.keySet()) {
			session.setAttribute(key, lang.getEng().get(key));
		}
	}

	public HashMap<String, String> getEng() {
		return eng;
	}

	public void setEng(HashMap<String, String> eng) {
		this.eng = eng;
	}
}
