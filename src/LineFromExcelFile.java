
public class LineFromExcelFile {
	private String account_number;
	private String iktato;
	private String erintett_szolgaltatasok;
	private String hibabejelentes_kategoriaja;
	private String hiba_oka;
	private String kivizsgalas_eredmenye;
	private String tovabbitas_hdra;
	private String megjegyzes;
	private String ccss_contact_id;
	private String name;
	private String ugyfeltipus;
	private String phone2;
	private String phone1;
	private String folyamat_indulasa;
	private String fazis_neve;
	private String folyamat_inditoja;
	private String szolgaltatasi_cim;
	private String fazis_indulasa;
	private String DB_TYPE;
	private String MEGJ_HOSSZ;
	private String BEZ;
	private String ANGOL;
	private String VUI;
	private String megjegyzes_2;
	private String phone3;
	
	
	public int mezoIndexVissza(String s) {
		
		if (s.equals("account_number")) { return 0;}
		if (s.equals("iktato")) { return 1;}
		if (s.equals("erintett_szolgaltatasok")) { return 2;}
		if (s.equals("hibabejelentes_kategoriaja")) { return 3;}
		if (s.equals("hiba_oka")) { return 4;}
		if (s.equals("kivizsgalas_eredmenye")) { return 5;}
		if (s.equals("tovabbitas_hdra")) { return 6;}
		if (s.equals("megjegyzes")) { return 7;}
		if (s.equals("ccss_contact_id")) { return 8;}
		if (s.equals("name")) { return 9;}
		if (s.equals("ugyfeltipus")) { return 10;}
		if (s.equals("phone2")) { return 11;}
		if (s.equals("phone1")) { return 12;}
		if (s.equals("folyamat_indulasa")) { return 13;}
		if (s.equals("fazis_neve")) { return 14;}
		if (s.equals("folyamat_inditoja")) { return 15;}
		if (s.equals("szolgaltatasi_cim")) { return 16;}
		if (s.equals("fazis_indulasa")) { return 17;}
		if (s.equals("DB_TYPE")) { return 18;}
		if (s.equals("MEGJ_HOSSZ")) { return 19;}
		if (s.equals("BEZ")) { return 20;}
		if (s.equals("ANGOL")) { return 21;}
		if (s.equals("VUI")) { return 22;}
		if (s.equals("megjegyzes_2")) { return 23;}
		if (s.equals("phone3")) { return 24;}
		
		return 1000;
		
	}
	
	
	public String getValueOf(String mezo) {
		
		return getMezoIndex(mezoIndexVissza(mezo));
	}
	
	public String getMezoIndex(int i) {
		
		
		switch(i) {	


		case 0: return account_number;
		case 1: return iktato;
		case 2: return erintett_szolgaltatasok;
		case 3: return hibabejelentes_kategoriaja;
		case 4: return hiba_oka;
		case 5: return kivizsgalas_eredmenye;
		case 6: return tovabbitas_hdra;
		case 7: return megjegyzes;
		case 8: return ccss_contact_id;
		case 9: return name;
		case 10: return ugyfeltipus;
		case 11: return phone2;
		case 12: return phone1;
		case 13: return folyamat_indulasa;
		case 14: return fazis_neve;
		case 15: return folyamat_inditoja;
		case 16: return szolgaltatasi_cim;
		case 17: return fazis_indulasa;
		case 18: return DB_TYPE;
		case 19: return MEGJ_HOSSZ;
		case 20: return BEZ;
		case 21: return ANGOL;
		case 22: return VUI;
		case 23: return megjegyzes_2;
		case 24: return phone3;
		
		default: return "1000";

	}
		
	}
	/**
	 * @return the account_number
	 */
	public String getAccount_number() {
		return account_number;
	}
	/**
	 * @param account_number the account_number to set
	 */
	public void setAccount_number(String account_number) {
		this.account_number = account_number;
	}
	/**
	 * @return the iktato
	 */
	public String getIktato() {
		return iktato;
	}
	/**
	 * @param iktato the iktato to set
	 */
	public void setIktato(String iktato) {
		this.iktato = iktato;
	}
	public String getErintett_szolgaltatasok() {
		return erintett_szolgaltatasok;
	}
	public void setErintett_szolgaltatasok(String erintett_szolgaltatasok) {
		this.erintett_szolgaltatasok = erintett_szolgaltatasok;
	}
	public String getHibabejelentes_kategoriaja() {
		return hibabejelentes_kategoriaja;
	}
	public void setHibabejelentes_kategoriaja(String hibabejelentes_kategoriaja) {
		this.hibabejelentes_kategoriaja = hibabejelentes_kategoriaja;
	}
	public String getHiba_oka() {
		return hiba_oka;
	}
	public void setHiba_oka(String hiba_oka) {
		this.hiba_oka = hiba_oka;
	}
	public String getKivizsgalas_eredmenye() {
		return kivizsgalas_eredmenye;
	}
	public void setKivizsgalas_eredmenye(String kivizsgalas_eredmenye) {
		this.kivizsgalas_eredmenye = kivizsgalas_eredmenye;
	}
	public String getTovabbitas_hdra() {
		return tovabbitas_hdra;
	}
	public void setTovabbitas_hdra(String tovabbitas_hdra) {
		this.tovabbitas_hdra = tovabbitas_hdra;
	}
	public String getMegjegyzes() {
		return megjegyzes;
	}
	public void setMegjegyzes(String megjegyzes) {
		this.megjegyzes = megjegyzes;
	}
	public String getCcss_contact_id() {
		return ccss_contact_id;
	}
	public void setCcss_contact_id(String ccss_contact_id) {
		this.ccss_contact_id = ccss_contact_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUgyfeltipus() {
		return ugyfeltipus;
	}
	public void setUgyfeltipus(String ugyfeltipus) {
		this.ugyfeltipus = ugyfeltipus;
	}
	public String getPhone2() {
		return phone2;
	}
	public void setPhone2(String phone2) {
		this.phone2 = phone2;
	}
	public String getPhone1() {
		return phone1;
	}
	public void setPhone1(String phone1) {
		this.phone1 = phone1;
	}
	public String getFolyamat_indulasa() {
		return folyamat_indulasa;
	}
	public void setFolyamat_indulasa(String folyamat_indulasa) {
		this.folyamat_indulasa = folyamat_indulasa;
	}
	public String getFazis_neve() {
		return fazis_neve;
	}
	public void setFazis_neve(String fazis_neve) {
		this.fazis_neve = fazis_neve;
	}
	public String getFolyamat_inditoja() {
		return folyamat_inditoja;
	}
	public void setFolyamat_inditoja(String folyamat_inditoja) {
		this.folyamat_inditoja = folyamat_inditoja;
	}
	public String getSzolgaltatasi_cim() {
		return szolgaltatasi_cim;
	}
	public void setSzolgaltatasi_cim(String szolgaltatasi_cim) {
		this.szolgaltatasi_cim = szolgaltatasi_cim;
	}
	public String getFazis_indulasa() {
		return fazis_indulasa;
	}
	public void setFazis_indulasa(String fazis_indulasa) {
		this.fazis_indulasa = fazis_indulasa;
	}
	public String getDB_TYPE() {
		return DB_TYPE;
	}
	public void setDB_TYPE(String dB_TYPE) {
		DB_TYPE = dB_TYPE;
	}
	public String getMEGJ_HOSSZ() {
		return MEGJ_HOSSZ;
	}
	public void setMEGJ_HOSSZ(String mEGJ_HOSSZ) {
		MEGJ_HOSSZ = mEGJ_HOSSZ;
	}
	public String getBEZ() {
		return BEZ;
	}
	public void setBEZ(String bEZ) {
		BEZ = bEZ;
	}
	public String getANGOL() {
		return ANGOL;
	}
	public void setANGOL(String aNGOL) {
		ANGOL = aNGOL;
	}
	public String getVUI() {
		return VUI;
	}
	public void setVUI(String vÜI) {
		VUI = vÜI;
	}
	public String getMegjegyzes_2() {
		return megjegyzes_2;
	}
	public void setMegjegyzes_2(String megjegyzes_2) {
		this.megjegyzes_2 = megjegyzes_2;
	}
	public String getPhone3() {
		return phone3;
	}
	public void setPhone3(String phone3) {
		this.phone3 = phone3;
	}

	
	public String toString() {
		
		return " " +  account_number
				+ " " +  iktato
				+ " " +  erintett_szolgaltatasok
				+ " " +  hibabejelentes_kategoriaja
				+ " " +  hiba_oka
				+ " " +  kivizsgalas_eredmenye
				+ " " +  tovabbitas_hdra
				+ " " +  megjegyzes
				+ " " +  ccss_contact_id
				+ " " +  name
				+ " " +  ugyfeltipus
				+ " " +  phone2
				+ " " +  phone1
				+ " " +  folyamat_indulasa
				+ " " +  fazis_neve
				+ " " +  folyamat_inditoja
				+ " " +  szolgaltatasi_cim
				+ " " +  fazis_indulasa
				+ " " +  DB_TYPE
				+ " " +  MEGJ_HOSSZ
				+ " " +  BEZ
				+ " " +  ANGOL
				+ " " +  VUI
				+ " " +  megjegyzes_2
				+ " " +  phone3;
	}

}
