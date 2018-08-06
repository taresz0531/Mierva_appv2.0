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
		
		hun.put("galeria_cim", "Galéria");
		
		hun.put("szolg_cim", "Szolgáltatásaink");
		
		hun.put("szolg_szoba", "Szobák");
		hun.put("szolg_tagas", "tágas, kényelmes");
		hun.put("szolg_mini", "minibár");
		hun.put("szolg_wifi", "wi-fi és vezetékes internet-csatlakozási lehetőség");
		hun.put("szolg_tv", "műholdas, televízió");
		hun.put("szolg_zuhany", "zuhanyzós fürdõszoba");
		hun.put("szolg_kondi", "légkondició");
		hun.put("szolg_dohany", "szobáink nem dohányzók");
		hun.put("szolg_baba", "bababarát");
		hun.put("szolg_akadaly", "akadálymentesített épület-szoba");
		
		hun.put("szolg_etterem", "Étterem");
		hun.put("szolg_sved", "svédasztalos reggeli – igény esetén térítés ellenében");
		hun.put("szolg_kondi2", "légkondició");
		hun.put("szolg_wifi2", "wi-fi -s internet csatlakozási lehetõség");
		hun.put("szolg_jegy", "étkezési  jegy, üdülési csekk elfogadás");
		
		hun.put("szolg_konferencia", "Konferenciaterem");
		hun.put("szolg_rend", "rendezvények lebonyolítására");
		hun.put("szolg_kondi3", "légkondicionált helyiség");
		hun.put("szolg_technika", "technikai eszközök biztosítása");
		
		hun.put("szolg_tovabb", "További");
		hun.put("szolg_eloter", "a szobák elõterében társalgó");
		hun.put("szolg_zart", "zárt, belsõ udvari parkoló");
		hun.put("szolg_recept", "24 órás recepció");
		hun.put("szolg_hitel", "hitelkártyás / bankkártyás fizetési lehetõség");
		hun.put("szolg_udules", "üdülési csekk elfogadás");
		
		hun.put("ar_cim", "Áraink");
		hun.put("ar_11", "1 ágyas szoba: 9.500 Ft/éj (szobaszám: 11)");
		hun.put("ar_12", "1 ágyas szoba: 9.900 Ft/éj (szobaszám: 2)");
		hun.put("ar_21", "2 ágyas szoba: 12.500 Ft/éj (szobaszám: 4, 5, 6, 7)");
		hun.put("ar_22", "2 ágyas szoba 1 főre: 10.500 Ft/éj (szobaszám: 4, 5 ,6 ,7)");
		hun.put("ar_23", "2 ágyas szoba az új épületszárnyban: 13.500 Ft/éj (szobaszám: Új 1, Új 2)");
		hun.put("ar_24", "2 ágyas szoba 1 főre az új épületszárnyban: 11.500 Ft/éj (szobaszám: Új 1, Új 2)");
		hun.put("ar_3", "3 ágyas szoba: 16.500 Ft/éj (szobaszám: 8, 9)");
		hun.put("ar_4", "4 ágyas szoba: 8.500 Ft/éj (szobaszám: 10)");
		hun.put("ar_apart", "Apartman (2+2 ágyas): 21.500 Ft/éj (apartman: 1 és 3)");
		hun.put("ar_pot", "Pótágy igény esetén biztosítható, melynek ára  4.500 Ft/éj.");
		
		hun.put("ar_afa", "Az árak az idegenforgalmi adót és az ÁFÁ-t tartalmazzák.");
		hun.put("ar_idegen", "Az idegenforgalmi adót 18. életévet betöltött magánszemélyeknek kell megfizetni.");
		hun.put("ar_idegen2", "Az idegenforgalmi adó mértéke 400 Ft/fő/éj.");
		hun.put("ar_reggeli", "Reggeli igény esetén biztosítható, melynek ára bruttó 1.500 Ft/fő/alkalom.");
		hun.put("ar_reggeli2", "A reggeli 3 éves kor alatt ingyenes.");
		hun.put("ar_fel", "Félpanzió igény esetén biztosítható, melynek ára bruttó 4.400 Ft/fő/alkalom.");
		
		hun.put("ar_idegen3", "Idegenforgalmi adómentesség jogcíme (tartózkodás indoka)");
		hun.put("ar_nem", "Nem töltötte be a 18. életévet");
		hun.put("ar_gyogy", "Gyógyintézetben fekvőbeteg szakellátásban részesül vagy szociális intézményben kap ellátást");
		hun.put("ar_tanul", "Közép- és felsőfokú oktatási intézménynél tanulói, hallgatói viszony alapján Debrecen illetékességi területén tartózkodik (Oktatási intézmény neve, címe, diákigazolvány száma)");
		hun.put("ar_hatosag", "Hatóság vagy bíróság intézkedése folytán Debrecen illetékességi területén tartózkodik");
		hun.put("ar_szak", "Szakképzés keretében Debrecen illetékességi területén tartózkodik");
		hun.put("ar_szolgalat", "Szolgálati kötelezettség teljesítése céljából Debrecen illetékességi területén tartózkodik vagy ezen vállalkozó munkavállalójaként folytatott munkavégzés céljából Debrecen illetékességi területén tartózkodik (Vállalkozás neve, székhelyének,telephelyének címe, adószáma)");
		hun.put("ar_vallalat", "Debrecenben székhellyel vagy telephellyel rendelkező vállalkozó esetén vállalkozási tevékenység vagy ezen vállalkozó munkavállalójaként folytatott munkavégzés céljából Debrecen illetékességi területén tartózkodik (Vállalkozás neve, székhelyének,telephelyének címe, adószáma)");
		hun.put("ar_udulo", "Debrecen illetékességi területén lévő üdülő tulajdonosa vagy bérlője, továbbá a használati jogosultság időtartamára a lakásszövetkezet tulajdonában álló üdülő használati jogával rendelkező lakásszövetkezeti tag, illetőleg a tulajdonos , a bérlő hozzátartozója, valamint a lakásszövetkezet tulajdonában álló üdülő használati jogával rendelkező lakásszövetkezeti tag használati jogosultságának időtartamának annak hozzátartozója");
		hun.put("ar_idenleges", "Debrecenben ideiglenes jellegű iparűzési tevékenységet folytató vállalkozó vagy alkalmazottja az önkormányzati adóhatóság igazolása alapján (a 45/2013.(XI.28.) önkormányzati rendelet 4. melléklete)");
		hun.put("ar_egyhaz", "Az egyházi jogi személy tulajdonában lévő épületben,telken – kizárólag az egyházi jogi személy hitéleti tevékenységéhez kapcsolódó részvétel céljából – egyházi");
		hun.put("ar_tajekoztat", "A feltüntetett árak tájékoztató jellegűek, azoktól kiemelt időszakokban, illetve egyedi megállapodások esetén eltérhetünk!");
		
		hun.put("vinfo_cim", "Debrecen város látnivalói, érdekességei");
		hun.put("vinfo_info", "További információért kattintson ");
		hun.put("vinfo_ide", "IDE");
		
		hun.put("vinfo_nagyt", "Református Nagytemplom");
		hun.put("vinfo_nagytleir", "Debrecen jelképe, az ország legnagyobb református temploma.");
		hun.put("vinfo_nagytlink", "https://www.debrecen.hu/hu/turista/latnivalok/reformatus-nagytemplom");
		
		hun.put("vinfo_egyetem", "A Debreceni Egyetem főépülete");
		hun.put("vinfo_egyetemleir", "A Debreceni Egyetem – mely az ország legrégebbi, folyamatosan működő felsőoktatási intézményei közé tartozik – egyike Magyarország kiemelt kutatóegyetemeinek, amely közel 30 ezer hallgatóval és 1500 oktatóval, 15 karával, 25 doktori iskolájával a legszélesebb hazai képzési kínálatot nyújtja.");
		hun.put("vinfo_egyetemlink", "https://www.debrecen.hu/hu/turista/latnivalok/debreceni-egyetem-foepulete");
		
		hun.put("vinfo_deri", "Déri Múzeum");
		hun.put("vinfo_derileir", "A Déri Múzeum Magyarország egyik legjelentősebb múzeuma. Az intézmény gazdag helytörténeti anyaga mellett Déri Frigyes egyetemes művelődéstörténeti gyűjteményével vált meghatározó jelentőségűvé.");
		hun.put("vinfo_derilink", "https://www.debrecen.hu/hu/turista/latnivalok/deri-muzeum");
	
		hun.put("vinfo_reform", "Református Kollégium");
		hun.put("vinfo_reformleir", "Az 1538 óta folyamatosan működő oktatási intézmény a magyar kultúra bölcsője, 2013 óta nemzeti emlékhely.");
		hun.put("vinfo_reformlink", "https://www.debrecen.hu/hu/turista/latnivalok/reformatus-kollegium");
		
		hun.put("vinfo_piac", "A Piac utca és a Kossuth tér");
		hun.put("vinfo_piacleir", "Debrecen főutcája, ahol a XVI. századtól 300 éven át tartották a híres debreceni vásárokat.");
		hun.put("vinfo_piaclink", "https://www.debrecen.hu/hu/turista/latnivalok/piac-utca-es-a-kossuth-ter");
		
		hun.put("vinfo_szent", "Szent Anna Székesegyház");
		hun.put("vinfo_szentleir", "Debrecen első katolikus temploma a 168 évig tartó vallási hegemónia után – ma a Debrecen-nyíregyházi Római Katolikus Egyházmegye székesegyháza.");
		hun.put("vinfo_szentlink", "https://www.debrecen.hu/hu/turista/latnivalok/szent-anna-szekesegyhaz");
		
		hun.put("vinfo_zsin", "Zsinagógák");
		hun.put("vinfo_zsinleir", "A Debreceni Zsidó Hitközség jelenleg Magyarország legnagyobb vidéki zsidó közössége.");
		hun.put("vinfo_zsinlink", "https://www.debrecen.hu/hu/turista/latnivalok/zsinagogak");
		
		hun.put("vinfo_aqua", "Aquaticum Spa");
		hun.put("vinfo_aqualeir", "A Nagyerdő csodálatos természeti környezetében található Aquaticum Spa fürdőkomplexum gyógyászati részleggel, széles körű szakorvosi szolgáltatásokkal, negyvenféle, gyógyvízre alapozott kezeléssel várja a regenerálódni, gyógyulni és kikapcsolódni vágyókat. A nyugodt pihenést és a felhőtlen kikapcsolódást a szálloda- és fürdőkomplexumban egész évben nyitva tartó termálfürdő, fedett mediterrán élményfürdő, csúszdapark, a szállodából közvetlen átjárással elérhető wellness-centrum és szaunavilág, valamint a fürdőt körülvevő rekreációs övezet garantálja.");
		hun.put("vinfo_aqualink", "https://www.debrecen.hu/hu/turista/latnivalok/aquaticum-spa");
		
		hun.put("vinfo_kod", "Ködszínház");
		hun.put("vinfo_kodleir", "Kihagyhatatlan vízivarázslat, látványos fények és formák a Ködszínházban.");
		hun.put("vinfo_kodlink", "https://www.debrecen.hu/hu/turista/latnivalok/kodszinhaz");
		
		hun.put("vinfo_viz", "Nagyerdei Víztorony");
		hun.put("vinfo_vizleir", "A Nagyerdei park legújabb látványossága a Nagyerdei Víztorony tavasztól őszig megunhatatlan szórakozási lehetőségekkel várja az érdeklődőket.");
		hun.put("vinfo_vizlink", "https://www.debrecen.hu/hu/turista/latnivalok/nagyerdei-viztorony-3");
		
		hun.put("vinfo_agora", "Agóra Tudományos Élményközpont");
		hun.put("vinfo_agoraleir", "Az Agóra Tudományos Élményközpont mindennapi életünk csodáit magyarázza meg, mindenki számára közérthetően és élményszerűen.");
		hun.put("vinfo_agoralink", "https://www.debrecen.hu/hu/turista/latnivalok/agora-tudomanyos-elmenykozpont");
		
		hun.put("vinfo_erdo", "Nagyerdei park");
		hun.put("vinfo_erdoleir", "Minden jelentõs várost fémjelez egy híres park – Debrecent az ország elsõ természetvédelmi területének nyilvánított Nagyerdõben található park.");
		hun.put("vinfo_erdolink", "https://www.debrecen.hu/hu/turista/latnivalok/nagyerdei-park");
		
		hun.put("vinfo_ady", "Ady park");
		hun.put("vinfo_adyleir", "A debreceni sétát – vagy ahogy a helyiek nevezik, korzózást – a város zöld, szökőkutas terei teszik még kényelmesebbé.");
		hun.put("vinfo_adylink", "https://www.debrecen.hu/hu/turista/latnivalok/ady-park");
		
		hun.put("vinfo_deriter", "Déri tér");
		hun.put("vinfo_deriterleir", "Debrecen egyik leghangulatosabb, legintimebb belvárosi tere.");
		hun.put("vinfo_deriterlink", "https://www.debrecen.hu/hu/turista/latnivalok/deri-ter");
		
		hun.put("vinfo_emlek", "Emlékkert");
		hun.put("vinfo_emlekleir", "A Református Nagytemplom és a Kollégium között húzódó Emlékkertben található Bocskai István erdélyi fejedelem szobra, melyet 1906-ban, a hajdúk letelepítésének 300. évfordulóján emeltek.");
		hun.put("vinfo_emleklink", "https://www.debrecen.hu/hu/turista/latnivalok/emlekkert-3");
		
		hun.put("vinfo_hal", "Hal köz");
		hun.put("vinfo_halleir", "Az egykori hal- és tejpiac helyén található Debrecen egyik leghangulatosabb belvárosi tere.");
		hun.put("vinfo_hallink", "https://www.debrecen.hu/hu/turista/latnivalok/hal-koz");
		
		hun.put("vinfo_medgy", "Medgyessy sétány");
		hun.put("vinfo_medgyleir", "A Nagyerdő múzsák lakta vidék a poétáknak, s temérdek izgalmas kutatási témával szolgál a tudósok számára is.");
		hun.put("vinfo_medgylink", "https://www.debrecen.hu/hu/turista/latnivalok/medgyessy-setany");
		
		hun.put("vinfo_csoki", "Csokonai Nemzeti Színház");
		hun.put("vinfo_csokileir", "Az ország egyik legszínvonalasabb vidéki színházi társulatának otthont adó kőszínház 1865-ben nyitotta meg kapuit.");
		hun.put("vinfo_csokilink", "https://www.debrecen.hu/hu/turista/latnivalok/csokonai-nemzeti-szinhaz");
		
		hun.put("vinfo_botanik", "Egyetemi botanikus kert");
		hun.put("vinfo_botanikleir", "A Diószegi Sámuel és Fazekas Mihály által 1807-ben megálmodott, a Református Kollégium botanikai oktatását szolgáló Füvészkert megszűnése után, 1928-ban alapították az egyetemi botanikus kertet.");
		hun.put("vinfo_botaniklink", "https://www.debrecen.hu/hu/turista/latnivalok/egyetemi-botanikus-kert");
		
		hun.put("vinfo_veres", "Verestemplom");
		hun.put("vinfo_veresleir", "Közép-Európa egyik legkülönlegesebb református temploma.");
		hun.put("vinfo_vereslink", "https://www.debrecen.hu/hu/turista/latnivalok/verestemplom");
		
		hun.put("vinfo_kultur", "Nagyerdei Kultúrpark állat- és növénykertje");
		hun.put("vinfo_kulturleir", "Itt található az ország első vidéki állat- és növénykertje, melyet 1958-ban alapítottak. A kicsiket vidámpark is várja, amit egy kisvasút köt össze az állatkerttel. A vonatból megcsodálhatjuk a dámszarvasokat és a tevéket, de akár szurkolhatunk a dodzsemezőknek is.");
		hun.put("vinfo_kulturlink", "https://www.debrecen.hu/hu/turista/latnivalok/nagyerdei-kulturpark-allat-es-novenykertje");
		
		hun.put("vinfo_modem", "Modem Modern és Kortárs Művészeti Központ");
		hun.put("vinfo_modemleir", "A Modem Közép-Európa egyik legizgalmasabb kortárs művészeti kiállítóhelye, mely 2006-tól várja színvonalas képzőművészeti kiállításokkal és társművészeti programokkal az érdeklődőket.");
		hun.put("vinfo_modemlink", "https://www.debrecen.hu/hu/turista/latnivalok/modem-modern-es-kortars-muveszeti-kozpont");
		
		hun.put("vinfo_hort", "Hortobágy");
		hun.put("vinfo_hortleir", "A Hortobágy szó több jelentéssel is bír: jelöli a települést, a tájegységet és az azon kanyargó folyót. Ami összeköti ezeket, az a Kilenclyukú híd, az ország leghosszabb épített közúti kőhídja, és a híd közvetlen szomszédságában található tradicionális vendéglátóhely, a Hortobágyi Nagycsárda. Bárki részese lehet a pusztai életérzésnek egy fogatozás keretében: megtekintheti az állatokat eredeti élőhelyükön, és arra is választ kaphat, miért termett lóra a magyar ember.");
		hun.put("vinfo_hortlink", "https://www.debrecen.hu/hu/turista/latnivalok/hortobagy-5");
		
		hun.put("gyik_cim", "Gyakori kérdések");
		hun.put("gyik_01", "Hány órától foglalhatók el a szobák?");
		hun.put("gyik_01l", "A szobákat az érkezés napján 14.00 órától tudja elfoglalni. Amennyiben az Ön szobájában az adott nap nem volt távozó vendég, akkor természetesen a szobát korábban is az Ön rendelkezésére tudjuk bocsátani. Kérjük ezért, ha korábban érkezik, a kellemetlenségek elkerülése érdekében telefonon vagy megelõzõ nap emailen - érdeklõdjön munkatársainktól, hogy a szoba elfoglalható-e 14.00 óra elõtt. Ha korábban érkezik és a szoba még nem áll rendelkezésre a csomagokat le tudja adni nálunk, szívesen õrizzük, addig Ön tehet egy rövid sétát a belvárosban.");
		hun.put("gyik_02", "Meddig kell a távozás napján a szobákat elhagyni?");
		hun.put("gyik_02l", "A szoba a távozás napján 11.00 óráig áll az Ön rendelkezésére. Kérjük ezt az idõpontot szíveskedjen betartani, annak érdekében, hogy az Ön után érkezõ vendégek számára is tisztán és pontosan tudjuk átadni azt. Persze ha még egy rövid kirándulást szeretne tenni a városban vagy egyéb elintéznivalója van, a csomagjait szívesen õrizzük a távozás napján is, valamint a gépjármû is a belsõ parkolónkban hagyható.");
		hun.put("gyik_03", "A panzióba érkezéskor mi a teendõ?");
		hun.put("gyik_03l", "A panzióba érkezéskor a recepción munkatársunk fogadja Önt. Bejelentkezéskor szükségünk lesz Öntõl néhány adatra (név, cím, személyi igazolvány szám, stb.), kérjük ezért, hogy személyi igazolványukat maguknál tartani szíveskedjenek. Természetesen az adatait bizalmasan kezeljük.");
		hun.put("gyik_04", "Kaphatunk-e a panzióban reggelit?");
		hun.put("gyik_04l", "Kérhetõ reggeli. A szobaár nem tartalmazza a reggelit. Minden reggel 7 órától 9.30-ig bõséges svédasztalos reggelivel várjuk Önt.");
		hun.put("gyik_05", "Van-e vacsorázási lehetõség a panzióban?");
		hun.put("gyik_05l", "Természetesen, hiszen a panziónk étteremmel egybeépült létesítmény. Lehetõsége van a la carte ételfogyasztásra, illetve panziónk biztosítja Vendégei számára a félpanziós ellátást is, amennyiben igényt tartanak rá. Az étterem déli 11-tõl egészen este 21 óráig áll a Vendégek rendelkezésére. Ez idõtartamon belül bármikor elfogyaszthatják ebédjüket, illetve vacsorájuk");
		hun.put("gyik_06", "Van-e törölközõ a szobához?");
		hun.put("gyik_06l", "Igen. Minden szobához biztosítunk törölközõt.");
		hun.put("gyik_07", "Milyen a szobák felszereltsége?");
		hun.put("gyik_07l", "A szobák televízióval, minibárral, telefonnal, internet csatlakozási lehetõséggel felszereltek, klimatizáltak. Minden szobához zuhanyzóval ellátott fürdõszoba tartozik.");
		hun.put("gyik_08", "Milyen parkolási lehetõség áll a Vendégek részére?");
		hun.put("gyik_08l", "A Panzió külön kialakított, nyitott parkolóval rendelkezik. A panzió Vendégei számára a parkolás ingyenes.");
		hun.put("gyik_09", "Van-e lehetõség dohányzásra?");
		hun.put("gyik_09l", "Az épületben a dohányzás a nemdohányzókra való tekintettel nem megengedett. Dohányzásra lehetõség csak az arra kijelölt helyen van.");
		hun.put("gyik_10", "Meddig kell a távozás napján a szobákat elhagyni?");
		hun.put("gyik_10l", "Igen. Panziónkban és éttermünkben egyaránt elfogadunk üdülési csekket.");
		hun.put("gyik_11", "Mivel lehet még fizetni a panzióban?");
		hun.put("gyik_11l", "A szolgáltatások ellenértékének kiegyenlítése lehetséges üdülési csekken túl");
		hun.put("gyik_kp", "Készpénzzel");
		hun.put("gyik_bank", "Bankkártyával");
		hun.put("gyik_utal", "Elõzetes írásbeli megegyezés esetén átutalással");
		hun.put("gyik_meleg", "Ételfogyasztás esetén elfogadunk meleg étkezési utalványokat");
		hun.put("gyik_kerdes", "Maradt még kérdése? Keressen minket a 06-30/9-787-485-ös számon vagy írja meg e-mailen a konfer74@freemail.hu címre.");
		
		hun.put("ajan_cim", "Ajánlatkérés");
		hun.put("ajan_nev", "Teljes név:");
		hun.put("ajan_tel", "Elérhetőség(tel. vagy e-mail):");
		hun.put("ajan_szemely", "Személyek száma:");
		hun.put("ajan_szoba", "Szoba típusa:");
		hun.put("ajan_mind", "Mindegy");
		hun.put("ajan_egy", "Egy ágyas");
		hun.put("ajan_ketto", "Két ágyas");
		hun.put("ajan_harom", "Három ágyas");
		hun.put("ajan_negy", "Négy ágyas");
		hun.put("ajan_apart", "Apartman");
		hun.put("ajan_erkez", "Érkezés:");
		hun.put("ajan_tavoz", "Távozás:");
		hun.put("ajan_reggel", "Reggeli:");
		hun.put("ajan_kerek", "Kérek");
		hun.put("ajan_megj", "Megjegyzés:");
		hun.put("ajan_kuld", "Küldés");
		
		hun.put("eler_cim", "Elérhetőségek:");
		hun.put("eler_nemhely", "Nem adott meg tartozkodási helyet!");
		hun.put("eler_tel", "Tel.:");
		hun.put("eler_fax", "fax.:");
		hun.put("eler_igazgat", "Ügyvezető igazgató");
		hun.put("eler_igazhely", "Igazgatóhelyettes");
		hun.put("eler_utvonal", "Útvonaltervezés");
		hun.put("eler_terkep", "Térkép");
		hun.put("eler_hely", "Indulási hely:");
		hun.put("eler_terv", "Tervezés");
		hun.put("eler_ad", "Adja meg a helyét!");
		
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
