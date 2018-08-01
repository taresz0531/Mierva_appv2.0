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
		eng.put("heti_cim2", "Minerva Resturant");
		eng.put("heti_cim3", "4024 Debrecen, Kossuth street 59. Phone: (52) 531-363");
		eng.put("heti_utalvany", "Erzsébet utalványt, SZÉP kártyát, étkezési jegyeket elfogadunk!");
		eng.put("heti_parkolo", "Az étterem elõtt gépkocsi parkolók találhatók.");
		eng.put("heti_menuar", "MENÜ ÁR bruttó 1.050,- Ft/nap");
		eng.put("heti_savanyu", "A menühöz kis adag csemege uborka, káposztasaláta rendelhető bruttó 170,- Ft/adag áron.");
		eng.put("heti_csere", "Amennyiben a levest nem szereti, azt felár nélkül cseréljük csontlevesre.");
		eng.put("heti_jog", "A változtatás jogát fenntartjuk!");
		eng.put("heti_elojegyzes", "Elõjegyzést felveszünk!");
		eng.put("heti_nap", "Day");
		eng.put("heti_leves", "Soup");
		eng.put("heti_foetel", "Main course");
		eng.put("heti_koret", "Side dish");
		
		eng.put("etlap_cim", "Menu");
		eng.put("etlap_etel", "Meal");
		eng.put("etlap_alergen", "Allergens");
		eng.put("etlap_ar", "Price");
		eng.put("etlap_kep", "Picture");
		eng.put("etlap_nincs_kep", "No picture");
		
		eng.put("galeria_cim", "Gallery");
		
		eng.put("szolg_cim", "Our services");
		
		eng.put("szolg_szoba", "Rooms");
		eng.put("szolg_tagas", "tágas, kényelmes");
		eng.put("szolg_mini", "mini-bar");
		eng.put("szolg_wifi", "wi-fi és vezetékes internet-csatlakozási lehetőség");
		eng.put("szolg_tv", "műholdas, televízió");
		eng.put("szolg_zuhany", "zuhanyzós fürdõszoba");
		eng.put("szolg_kondi", "air conditioner");
		eng.put("szolg_dohany", "szobáink nem dohányzók");
		eng.put("szolg_baba", "bababarát");
		eng.put("szolg_akadaly", "akadálymentesített épület-szoba");
		
		eng.put("szolg_etterem", "Restaurant");
		eng.put("szolg_sved", "svédasztalos reggeli – igény esetén térítés ellenében");
		eng.put("szolg_kondi2", "air conditioner");
		eng.put("szolg_wifi2", "wi-fi -s internet csatlakozási lehetõség");
		eng.put("szolg_jegy", "étkezési  jegy, üdülési csekk elfogadás");
		
		eng.put("szolg_konferencia", "Conference room");
		eng.put("szolg_rend", "rendezvények lebonyolítására");
		eng.put("szolg_kondi3", "légkondicionált helyiség");
		eng.put("szolg_technika", "technikai eszközök biztosítása");
		
		eng.put("szolg_tovabb", "Additional services");
		eng.put("szolg_eloter", "a szobák elõterében társalgó");
		eng.put("szolg_zart", "zárt, belsõ udvari parkoló");
		eng.put("szolg_recept", "24 órás recepció");
		eng.put("szolg_hitel", "hitelkártyás / bankkártyás fizetési lehetõség");
		eng.put("szolg_udules", "üdülési csekk elfogadás");
		
		eng.put("ar_cim", "Price");
		eng.put("ar_11", "1 ágyas szoba: 9.500 Ft/éj (szobaszám: 11)");
		eng.put("ar_12", "1 ágyas szoba: 9.900 Ft/éj (szobaszám: 2)");
		eng.put("ar_21", "2 ágyas szoba: 12.500 Ft/éj (szobaszám: 4, 5, 6, 7)");
		eng.put("ar_22", "2 ágyas szoba 1 főre: 10.500 Ft/éj (szobaszám: 4, 5 ,6 ,7)");
		eng.put("ar_23", "2 ágyas szoba az új épületszárnyban: 13.500 Ft/éj (szobaszám: Új 1, Új 2)");
		eng.put("ar_24", "2 ágyas szoba 1 főre az új épületszárnyban: 11.500 Ft/éj (szobaszám: Új 1, Új 2)");
		eng.put("ar_3", "3 ágyas szoba: 16.500 Ft/éj (szobaszám: 8, 9)");
		eng.put("ar_4", "4 ágyas szoba: 8.500 Ft/éj (szobaszám: 10)");
		eng.put("ar_apart", "Apartman (2+2 ágyas): 21.500 Ft/éj (apartman: 1 és 3)");
		eng.put("ar_pot", "Pótágy igény esetén biztosítható, melynek ára  4.500 Ft/éj.");
		
		eng.put("ar_afa", "Az árak az idegenforgalmi adót és az ÁFÁ-t tartalmazzák.");
		eng.put("ar_idegen", "Az idegenforgalmi adót 18. életévet betöltött magánszemélyeknek kell megfizetni.");
		eng.put("ar_idegen2", "Az idegenforgalmi adó mértéke 400 Ft/fő/éj.");
		eng.put("ar_reggeli", "Reggeli igény esetén biztosítható, melynek ára bruttó 1.500 Ft/fő/alkalom.");
		eng.put("ar_reggeli2", "A reggeli 3 éves kor alatt ingyenes.");
		eng.put("ar_fel", "Félpanzió igény esetén biztosítható, melynek ára bruttó 4.400 Ft/fő/alkalom.");
		
		eng.put("ar_idegen3", "Idegenforgalmi adómentesség jogcíme (tartózkodás indoka)");
		eng.put("ar_nem", "Nem töltötte be a 18. életévet");
		eng.put("ar_gyogy", "Gyógyintézetben fekvőbeteg szakellátásban részesül vagy szociális intézményben kap ellátást");
		eng.put("ar_tanul", "Közép- és felsőfokú oktatási intézménynél tanulói, hallgatói viszony alapján Debrecen illetékességi területén tartózkodik (Oktatási intézmény neve, címe, diákigazolvány száma)");
		eng.put("ar_hatosag", "Hatóság vagy bíróság intézkedése folytán Debrecen illetékességi területén tartózkodik");
		eng.put("ar_szak", "Szakképzés keretében Debrecen illetékességi területén tartózkodik");
		eng.put("ar_szolgalat", "Szolgálati kötelezettség teljesítése céljából Debrecen illetékességi területén tartózkodik vagy ezen vállalkozó munkavállalójaként folytatott munkavégzés céljából Debrecen illetékességi területén tartózkodik (Vállalkozás neve, székhelyének,telephelyének címe, adószáma)");
		eng.put("ar_vallalat", "Debrecenben székhellyel vagy telephellyel rendelkező vállalkozó esetén vállalkozási tevékenység vagy ezen vállalkozó munkavállalójaként folytatott munkavégzés céljából Debrecen illetékességi területén tartózkodik (Vállalkozás neve, székhelyének,telephelyének címe, adószáma)");
		eng.put("ar_udulo", "Debrecen illetékességi területén lévő üdülő tulajdonosa vagy bérlője, továbbá a használati jogosultság időtartamára a lakásszövetkezet tulajdonában álló üdülő használati jogával rendelkező lakásszövetkezeti tag, illetőleg a tulajdonos , a bérlő hozzátartozója, valamint a lakásszövetkezet tulajdonában álló üdülő használati jogával rendelkező lakásszövetkezeti tag használati jogosultságának időtartamának annak hozzátartozója");
		eng.put("ar_idenleges", "Debrecenben ideiglenes jellegű iparűzési tevékenységet folytató vállalkozó vagy alkalmazottja az önkormányzati adóhatóság igazolása alapján (a 45/2013.(XI.28.) önkormányzati rendelet 4. melléklete)");
		eng.put("ar_egyhaz", "Az egyházi jogi személy tulajdonában lévő épületben,telken – kizárólag az egyházi jogi személy hitéleti tevékenységéhez kapcsolódó részvétel céljából – egyházi");
		eng.put("ar_tajekoztat", "A feltüntetett árak tájékoztató jellegűek, azoktól kiemelt időszakokban, illetve egyedi megállapodások esetén eltérhetünk!");
		
		eng.put("vinfo_cim", "Debrecen város látnivalói, érdekességei");
		eng.put("vinfo_info", "További információért kattintson ");
		eng.put("vinfo_ide", "IDE");
		
		eng.put("vinfo_nagyt", "Református Nagytemplom");
		eng.put("vinfo_nagytleir", "Debrecen jelképe, az ország legnagyobb református temploma.");
		eng.put("vinfo_nagytlink", "https://www.debrecen.hu/hu/turista/latnivalok/reformatus-nagytemplom");
		
		eng.put("vinfo_egyetem", "A Debreceni Egyetem főépülete");
		eng.put("vinfo_egyetemleir", "A Debreceni Egyetem – mely az ország legrégebbi, folyamatosan működő felsőoktatási intézményei közé tartozik – egyike Magyarország kiemelt kutatóegyetemeinek, amely közel 30 ezer hallgatóval és 1500 oktatóval, 15 karával, 25 doktori iskolájával a legszélesebb hazai képzési kínálatot nyújtja.");
		eng.put("vinfo_egyetemlink", "https://www.debrecen.hu/hu/turista/latnivalok/debreceni-egyetem-foepulete");
		
		eng.put("vinfo_deri", "Déri Múzeum");
		eng.put("vinfo_derileir", "A Déri Múzeum Magyarország egyik legjelentősebb múzeuma. Az intézmény gazdag helytörténeti anyaga mellett Déri Frigyes egyetemes művelődéstörténeti gyűjteményével vált meghatározó jelentőségűvé.");
		eng.put("vinfo_derilink", "https://www.debrecen.hu/hu/turista/latnivalok/deri-muzeum");
	
		eng.put("vinfo_reform", "Református Kollégium");
		eng.put("vinfo_reformleir", "Az 1538 óta folyamatosan működő oktatási intézmény a magyar kultúra bölcsője, 2013 óta nemzeti emlékhely.");
		eng.put("vinfo_reformlink", "https://www.debrecen.hu/hu/turista/latnivalok/reformatus-kollegium");
		
		eng.put("vinfo_piac", "A Piac utca és a Kossuth tér");
		eng.put("vinfo_piacleir", "Debrecen főutcája, ahol a XVI. századtól 300 éven át tartották a híres debreceni vásárokat.");
		eng.put("vinfo_piaclink", "https://www.debrecen.hu/hu/turista/latnivalok/piac-utca-es-a-kossuth-ter");
		
		eng.put("vinfo_szent", "Szent Anna Székesegyház");
		eng.put("vinfo_szentleir", "Debrecen első katolikus temploma a 168 évig tartó vallási hegemónia után – ma a Debrecen-nyíregyházi Római Katolikus Egyházmegye székesegyháza.");
		eng.put("vinfo_szentlink", "https://www.debrecen.hu/hu/turista/latnivalok/szent-anna-szekesegyhaz");
		
		eng.put("vinfo_zsin", "Zsinagógák");
		eng.put("vinfo_zsinleir", "A Debreceni Zsidó Hitközség jelenleg Magyarország legnagyobb vidéki zsidó közössége.");
		eng.put("vinfo_zsinlink", "https://www.debrecen.hu/hu/turista/latnivalok/zsinagogak");
		
		eng.put("vinfo_aqua", "Aquaticum Spa");
		eng.put("vinfo_aqualeir", "A Nagyerdő csodálatos természeti környezetében található Aquaticum Spa fürdőkomplexum gyógyászati részleggel, széles körű szakorvosi szolgáltatásokkal, negyvenféle, gyógyvízre alapozott kezeléssel várja a regenerálódni, gyógyulni és kikapcsolódni vágyókat. A nyugodt pihenést és a felhőtlen kikapcsolódást a szálloda- és fürdőkomplexumban egész évben nyitva tartó termálfürdő, fedett mediterrán élményfürdő, csúszdapark, a szállodából közvetlen átjárással elérhető wellness-centrum és szaunavilág, valamint a fürdőt körülvevő rekreációs övezet garantálja.");
		eng.put("vinfo_aqualink", "https://www.debrecen.hu/hu/turista/latnivalok/aquaticum-spa");
		
		eng.put("vinfo_kod", "Ködszínház");
		eng.put("vinfo_kodleir", "Kihagyhatatlan vízivarázslat, látványos fények és formák a Ködszínházban.");
		eng.put("vinfo_kodlink", "https://www.debrecen.hu/hu/turista/latnivalok/kodszinhaz");
		
		eng.put("vinfo_viz", "Nagyerdei Víztorony");
		eng.put("vinfo_vizleir", "A Nagyerdei park legújabb látványossága a Nagyerdei Víztorony tavasztól őszig megunhatatlan szórakozási lehetőségekkel várja az érdeklődőket.");
		eng.put("vinfo_vizlink", "https://www.debrecen.hu/hu/turista/latnivalok/nagyerdei-viztorony-3");
		
		eng.put("vinfo_agora", "Agóra Tudományos Élményközpont");
		eng.put("vinfo_agoraleir", "Az Agóra Tudományos Élményközpont mindennapi életünk csodáit magyarázza meg, mindenki számára közérthetően és élményszerűen.");
		eng.put("vinfo_agoralink", "https://www.debrecen.hu/hu/turista/latnivalok/agora-tudomanyos-elmenykozpont");
		
		eng.put("vinfo_erdo", "Nagyerdei park");
		eng.put("vinfo_erdoleir", "Minden jelentõs várost fémjelez egy híres park – Debrecent az ország elsõ természetvédelmi területének nyilvánított Nagyerdõben található park.");
		eng.put("vinfo_erdolink", "https://www.debrecen.hu/hu/turista/latnivalok/nagyerdei-park");
		
		eng.put("vinfo_ady", "Ady park");
		eng.put("vinfo_adyleir", "A debreceni sétát – vagy ahogy a helyiek nevezik, korzózást – a város zöld, szökőkutas terei teszik még kényelmesebbé.");
		eng.put("vinfo_adylink", "https://www.debrecen.hu/hu/turista/latnivalok/ady-park");
		
		eng.put("vinfo_deriter", "Déri tér");
		eng.put("vinfo_deriterleir", "Debrecen egyik leghangulatosabb, legintimebb belvárosi tere.");
		eng.put("vinfo_deriterlink", "https://www.debrecen.hu/hu/turista/latnivalok/deri-ter");
		
		eng.put("vinfo_emlek", "Emlékkert");
		eng.put("vinfo_emlekleir", "A Református Nagytemplom és a Kollégium között húzódó Emlékkertben található Bocskai István erdélyi fejedelem szobra, melyet 1906-ban, a hajdúk letelepítésének 300. évfordulóján emeltek.");
		eng.put("vinfo_emleklink", "https://www.debrecen.hu/hu/turista/latnivalok/emlekkert-3");
		
		eng.put("vinfo_hal", "Hal köz");
		eng.put("vinfo_halleir", "Az egykori hal- és tejpiac helyén található Debrecen egyik leghangulatosabb belvárosi tere.");
		eng.put("vinfo_hallink", "https://www.debrecen.hu/hu/turista/latnivalok/hal-koz");
		
		eng.put("vinfo_medgy", "Medgyessy sétány");
		eng.put("vinfo_medgyleir", "A Nagyerdő múzsák lakta vidék a poétáknak, s temérdek izgalmas kutatási témával szolgál a tudósok számára is.");
		eng.put("vinfo_medgylink", "https://www.debrecen.hu/hu/turista/latnivalok/medgyessy-setany");
		
		eng.put("vinfo_csoki", "Csokonai Nemzeti Színház");
		eng.put("vinfo_csokileir", "Az ország egyik legszínvonalasabb vidéki színházi társulatának otthont adó kőszínház 1865-ben nyitotta meg kapuit.");
		eng.put("vinfo_csokilink", "https://www.debrecen.hu/hu/turista/latnivalok/csokonai-nemzeti-szinhaz");
		
		eng.put("vinfo_botanik", "Egyetemi botanikus kert");
		eng.put("vinfo_botanikleir", "A Diószegi Sámuel és Fazekas Mihály által 1807-ben megálmodott, a Református Kollégium botanikai oktatását szolgáló Füvészkert megszűnése után, 1928-ban alapították az egyetemi botanikus kertet.");
		eng.put("vinfo_botaniklink", "https://www.debrecen.hu/hu/turista/latnivalok/egyetemi-botanikus-kert");
		
		eng.put("vinfo_veres", "Verestemplom");
		eng.put("vinfo_veresleir", "Közép-Európa egyik legkülönlegesebb református temploma.");
		eng.put("vinfo_vereslink", "https://www.debrecen.hu/hu/turista/latnivalok/verestemplom");
		
		eng.put("vinfo_kultur", "Nagyerdei Kultúrpark állat- és növénykertje");
		eng.put("vinfo_kulturleir", "Itt található az ország első vidéki állat- és növénykertje, melyet 1958-ban alapítottak. A kicsiket vidámpark is várja, amit egy kisvasút köt össze az állatkerttel. A vonatból megcsodálhatjuk a dámszarvasokat és a tevéket, de akár szurkolhatunk a dodzsemezőknek is.");
		eng.put("vinfo_kulturlink", "https://www.debrecen.hu/hu/turista/latnivalok/nagyerdei-kulturpark-allat-es-novenykertje");
		
		eng.put("vinfo_modem", "Modem Modern és Kortárs Művészeti Központ");
		eng.put("vinfo_modemleir", "A Modem Közép-Európa egyik legizgalmasabb kortárs művészeti kiállítóhelye, mely 2006-tól várja színvonalas képzőművészeti kiállításokkal és társművészeti programokkal az érdeklődőket.");
		eng.put("vinfo_modemlink", "https://www.debrecen.hu/hu/turista/latnivalok/modem-modern-es-kortars-muveszeti-kozpont");
		
		eng.put("vinfo_hort", "Hortobágy");
		eng.put("vinfo_hortleir", "A Hortobágy szó több jelentéssel is bír: jelöli a települést, a tájegységet és az azon kanyargó folyót. Ami összeköti ezeket, az a Kilenclyukú híd, az ország leghosszabb épített közúti kőhídja, és a híd közvetlen szomszédságában található tradicionális vendéglátóhely, a Hortobágyi Nagycsárda. Bárki részese lehet a pusztai életérzésnek egy fogatozás keretében: megtekintheti az állatokat eredeti élőhelyükön, és arra is választ kaphat, miért termett lóra a magyar ember.");
		eng.put("vinfo_hortlink", "https://www.debrecen.hu/hu/turista/latnivalok/hortobagy-5");
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
