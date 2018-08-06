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
		
		eng.put("vinfo_cim", "The sights and attractions of Debrecen");
		eng.put("vinfo_info", "For more information, ");
		eng.put("vinfo_ide", "click HERE");
		
		eng.put("vinfo_nagyt", "Debrecen Reformed College");
		eng.put("vinfo_nagytleir", "Having functioned continuously as an educational institution since its establishment in 1538, the college is the cradle of Hungarian civilization.");
		eng.put("vinfo_nagytlink", "https://www.debrecen.hu/en/tourist/places/reformed-big-church");
		
		eng.put("vinfo_egyetem", "Main Building of the University of Debrecen");
		eng.put("vinfo_egyetemleir", "One of the nation’s five research universities, UD celebrated its centenary in 2012.");
		eng.put("vinfo_egyetemlink", "https://www.debrecen.hu/en/tourist/places/main-building-of-the-university-of-debrecen");
		
		eng.put("vinfo_deri", "Déri Museum");
		eng.put("vinfo_derileir", "The Déri Museum is one of Hungary’s foremost establishments of its kind. In addition to its exhibits of local cultural interest, it has become renowned for the huge collection of items, brought together by Frigyes Déri, which represents various aspects of universal human civilization.");
		eng.put("vinfo_derilink", "https://www.debrecen.hu/en/tourist/places/deri-museum");
	
		eng.put("vinfo_reform", "Debrecen Reformed College");
		eng.put("vinfo_reformleir", "Having functioned continuously as an educational institution since its establishment in 1538, the college is the cradle of Hungarian civilization.");
		eng.put("vinfo_reformlink", "https://www.debrecen.hu/en/tourist/places/debrecen-reformed-college");
		
		eng.put("vinfo_piac", "Piac Street and Kossuth Square");
		eng.put("vinfo_piacleir", "Debrecen’s Main Street - Piac Street - was the proud venue of the famous town fairs for 300 years starting in the 16th century.");
		eng.put("vinfo_piaclink", "https://www.debrecen.hu/en/tourist/places/piac-street-and-kossuth-square");
		
		eng.put("vinfo_szent", "St. Anne’s Cathedral");
		eng.put("vinfo_szentleir", "Built in Baroque and Louis Seize style, the church was elevated to cathedral rank by Pope John Paul II in 1993.");
		eng.put("vinfo_szentlink", "https://www.debrecen.hu/en/tourist/places/st-annes-cathedral");
		
		eng.put("vinfo_zsin", "Synagogues");
		eng.put("vinfo_zsinleir", "Debrecen Jewish Congregation is Hungary’s largest Israelite community outside the capital.");
		eng.put("vinfo_zsinlink", "https://www.debrecen.hu/en/tourist/places/synagogues");
		
		eng.put("vinfo_aqua", "Aquaticum Spa");
		eng.put("vinfo_aqualeir", "Located in an area of scenic beauty in Big Forest, the spa complex offers an entire unit of medical facilities and a wide range of specialist consultations to guests who seek regeneration, healing, or relaxation. Your comfort and enjoyment will be guaranteed by the attractions of the Thermal Bath, the Indoor Mediterranean Pleasure Bath, “water-chute park,” wellness center (directly accessible from the hotel unit) as well as the “sauna world.” All this in an area of natural beauty set aside for public recreational use.");
		eng.put("vinfo_aqualink", "https://www.debrecen.hu/en/tourist/places/aquaticum-spa");
		
		eng.put("vinfo_kod", "Mist Theater");
		eng.put("vinfo_kodleir", "In the immediate vicinity of Nagyerdei Arena, a one-of-a-kind attraction beckons from spring through fall.");
		eng.put("vinfo_kodlink", "https://www.debrecen.hu/en/tourist/places/mist-theater");
		
		eng.put("vinfo_viz", "Water Tower");
		eng.put("vinfo_vizleir", "The newest attraction of Nagyerdei park is the Water Tower Adventure Center.");
		eng.put("vinfo_vizlink", "https://www.debrecen.hu/en/tourist/places/water-tower-2");
		
		eng.put("vinfo_agora", "Agora Scientific Adventure Center");
		eng.put("vinfo_agoraleir", "Agora presents serious scientific knowledge and the little wonders of everyday life in a fun and easy-to-understand way.");
		eng.put("vinfo_agoralink", "https://www.debrecen.hu/en/tourist/places/agora-scientific-adventure-center");
		
		eng.put("vinfo_erdo", "Nagyerdei Park");
		eng.put("vinfo_erdoleir", "All great cities can be identified by famous parks. In the case of Debrecen, this is called Nagyerdei Park Forest, the nation’s first conservation area. Only a ten-minute ride from downtown, the park offers total peace and quiet in the shade of hundred-year-old trees as well as countless entertainment options.");
		eng.put("vinfo_erdolink", "https://www.debrecen.hu/en/tourist/places/nagyerdei-park");
		
		eng.put("vinfo_ady", "Ady park");
		eng.put("vinfo_adyleir", "The newest, open in the summer of 2015, is a vibrant, youthful and enchanting spot.");
		eng.put("vinfo_adylink", "https://www.debrecen.hu/en/tourist/places/ady-park");
		
		eng.put("vinfo_deriter", "Déri Square");
		eng.put("vinfo_deriterleir", "This is one of the most ambient and intimate squares of Debrecen.");
		eng.put("vinfo_deriterlink", "https://www.debrecen.hu/en/tourist/places/deri-square");
		
		eng.put("vinfo_emlek", "Memorial Garden");
		eng.put("vinfo_emlekleir", "The Memorial Garden occupies the leafy plot between the Big Church and the College.");
		eng.put("vinfo_emleklink", "https://www.debrecen.hu/en/tourist/places/memorial-garden");
		
		eng.put("vinfo_hal", "Hal köz");
		eng.put("vinfo_halleir", "Located at the place of the old fish (“hal”) and dairy market, this is one of Debrecen’s most pleasant downtown piazzas.");
		eng.put("vinfo_hallink", "https://www.debrecen.hu/en/tourist/places/704-1");
		
		eng.put("vinfo_medgy", "Medgyessy Promenade");
		eng.put("vinfo_medgyleir", "Big Forest has long been inhabited by the Muses of poetry and served as a rich hunting ground for academics in pursuit of exciting research topics.");
		eng.put("vinfo_medgylink", "https://www.debrecen.hu/en/tourist/places/medgyessy-promenade");
		
		eng.put("vinfo_csoki", "Csokonai National Theatre");
		eng.put("vinfo_csokileir", "One of the finest repertory theaters of the country opened its gates in 1865, so 2015 witnesses the celebrations of its 150th anniversary.");
		eng.put("vinfo_csokilink", "https://www.debrecen.hu/en/tourist/places/csokonai-national-theater");
		
		eng.put("vinfo_botanik", "Botanical Garden at UD");
		eng.put("vinfo_botanikleir", "UD’s Botanical Garden behind the main campus building was established in 1928 when the original garden that had belonged to the Reformed College ceased to exist.");
		eng.put("vinfo_botaniklink", "https://www.debrecen.hu/en/tourist/places/botanical-garden-at-ud");
		
		eng.put("vinfo_veres", "Veres (Red) Church");
		eng.put("vinfo_veresleir", "This is one of Central Europe's most unique Reformed churches.");
		eng.put("vinfo_vereslink", "https://www.debrecen.hu/en/tourist/places/veres-red-church");
		
		eng.put("vinfo_kultur", "Nagyerdei Entertainment Complex");
		eng.put("vinfo_kulturleir", "This complex covers an area of 17 hectares under the canopy of Big Forest’s grand old trees.");
		eng.put("vinfo_kulturlink", "https://www.debrecen.hu/en/tourist/places/nagyerdei-entertainment-complex");
		
		eng.put("vinfo_modem", "MODEM Center of Modern & Contemporary Art");
		eng.put("vinfo_modemleir", "MODEM is one of Central Europe’s greatest museums of modern and contemporary art.");
		eng.put("vinfo_modemlink", "https://www.debrecen.hu/en/tourist/places/modem-center-of-modern-contemporary-art");
		
		eng.put("vinfo_hort", "Hortobágy");
		eng.put("vinfo_hortleir", "Proudly bearing its title of UNESCO World Heritage Site, Hortobágy National Park is the perfect archetype of pristine natural landscapes. This is the place where everyone longs to find refuge from the monotony of modern human existence.");
		eng.put("vinfo_hortlink", "https://www.debrecen.hu/en/tourist/places/hortobagy-2");
		
		eng.put("gyik_cim", "Gyakori kérdések");
		eng.put("gyik_01", "Hány órától foglalhatók el a szobák?");
		eng.put("gyik_01l", "A szobákat az érkezés napján 14.00 órától tudja elfoglalni. Amennyiben az Ön szobájában az adott nap nem volt távozó vendég, akkor természetesen a szobát korábban is az Ön rendelkezésére tudjuk bocsátani. Kérjük ezért, ha korábban érkezik, a kellemetlenségek elkerülése érdekében telefonon vagy megelõzõ nap emailen - érdeklõdjön munkatársainktól, hogy a szoba elfoglalható-e 14.00 óra elõtt. Ha korábban érkezik és a szoba még nem áll rendelkezésre a csomagokat le tudja adni nálunk, szívesen õrizzük, addig Ön tehet egy rövid sétát a belvárosban.");
		eng.put("gyik_02", "Meddig kell a távozás napján a szobákat elhagyni?");
		eng.put("gyik_02l", "A szoba a távozás napján 11.00 óráig áll az Ön rendelkezésére. Kérjük ezt az idõpontot szíveskedjen betartani, annak érdekében, hogy az Ön után érkezõ vendégek számára is tisztán és pontosan tudjuk átadni azt. Persze ha még egy rövid kirándulást szeretne tenni a városban vagy egyéb elintéznivalója van, a csomagjait szívesen õrizzük a távozás napján is, valamint a gépjármû is a belsõ parkolónkban hagyható.");
		eng.put("gyik_03", "A panzióba érkezéskor mi a teendõ?");
		eng.put("gyik_03l", "A panzióba érkezéskor a recepción munkatársunk fogadja Önt. Bejelentkezéskor szükségünk lesz Öntõl néhány adatra (név, cím, személyi igazolvány szám, stb.), kérjük ezért, hogy személyi igazolványukat maguknál tartani szíveskedjenek. Természetesen az adatait bizalmasan kezeljük.");
		eng.put("gyik_04", "Kaphatunk-e a panzióban reggelit?");
		eng.put("gyik_04l", "Kérhetõ reggeli. A szobaár nem tartalmazza a reggelit. Minden reggel 7 órától 9.30-ig bõséges svédasztalos reggelivel várjuk Önt.");
		eng.put("gyik_05", "Van-e vacsorázási lehetõség a panzióban?");
		eng.put("gyik_05l", "Természetesen, hiszen a panziónk étteremmel egybeépült létesítmény. Lehetõsége van a la carte ételfogyasztásra, illetve panziónk biztosítja Vendégei számára a félpanziós ellátást is, amennyiben igényt tartanak rá. Az étterem déli 11-tõl egészen este 21 óráig áll a Vendégek rendelkezésére. Ez idõtartamon belül bármikor elfogyaszthatják ebédjüket, illetve vacsorájuk");
		eng.put("gyik_06", "Van-e törölközõ a szobához?");
		eng.put("gyik_06l", "Igen. Minden szobához biztosítunk törölközõt.");
		eng.put("gyik_07", "Milyen a szobák felszereltsége?");
		eng.put("gyik_07l", "A szobák televízióval, minibárral, telefonnal, internet csatlakozási lehetõséggel felszereltek, klimatizáltak. Minden szobához zuhanyzóval ellátott fürdõszoba tartozik.");
		eng.put("gyik_08", "Milyen parkolási lehetõség áll a Vendégek részére?");
		eng.put("gyik_08l", "A Panzió külön kialakított, nyitott parkolóval rendelkezik. A panzió Vendégei számára a parkolás ingyenes.");
		eng.put("gyik_09", "Van-e lehetõség dohányzásra?");
		eng.put("gyik_09l", "Az épületben a dohányzás a nemdohányzókra való tekintettel nem megengedett. Dohányzásra lehetõség csak az arra kijelölt helyen van.");
		eng.put("gyik_10", "Meddig kell a távozás napján a szobákat elhagyni?");
		eng.put("gyik_10l", "Igen. Panziónkban és éttermünkben egyaránt elfogadunk üdülési csekket.");
		eng.put("gyik_11", "Mivel lehet még fizetni a panzióban?");
		eng.put("gyik_11l", "A szolgáltatások ellenértékének kiegyenlítése lehetséges üdülési csekken túl");
		eng.put("gyik_kp", "Készpénzzel");
		eng.put("gyik_bank", "Bankkártyával");
		eng.put("gyik_utal", "Elõzetes írásbeli megegyezés esetén átutalással");
		eng.put("gyik_meleg", "Ételfogyasztás esetén elfogadunk meleg étkezési utalványokat");
		eng.put("gyik_kerdes", "Maradt még kérdése? Keressen minket a 06-30/9-787-485-ös számon vagy írja meg e-mailen a konfer74@freemail.hu címre.");
		
		eng.put("ajan_cim", "Request for");
		eng.put("ajan_nev", "Full name:");
		eng.put("ajan_tel", "Contact(phone. or e-mail):");
		eng.put("ajan_szemely", "Number of personal:");
		eng.put("ajan_szoba", "Type of room:");
		eng.put("ajan_mind", "Any");
		eng.put("ajan_egy", "Single room");
		eng.put("ajan_ketto", "Double room");
		eng.put("ajan_harom", "Three bedroom");
		eng.put("ajan_negy", "Four bedroom");
		eng.put("ajan_apart", "Apartman");
		eng.put("ajan_erkez", "Arrival:");
		eng.put("ajan_tavoz", "Getaway:");
		eng.put("ajan_reggel", "Breakfast:");
		eng.put("ajan_kerek", "Yes");
		eng.put("ajan_megj", "Notice:");
		eng.put("ajan_kuld", "Send");
		
		eng.put("eler_cim", "Contacts:");
		eng.put("eler_nemhely", "Provide your place of residence");
		eng.put("eler_tel", "Phone:");
		eng.put("eler_fax", "fax.:");
		eng.put("eler_igazgat", "Managing director");
		eng.put("eler_igazhely", "Deputy Director");
		eng.put("eler_utvonal", "Get directions");
		eng.put("eler_terkep", "Map");
		eng.put("eler_hely", "Departure location:");
		eng.put("eler_terv", "Planning");
		eng.put("eler_ad", "Give it a place!");
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
