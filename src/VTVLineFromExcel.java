
public class VTVLineFromExcel implements Comparable {
	
	private String iktato;
	private String subject;
	private String contactDate;
	private String eszkoz;
	private String erintett;
	private String vtvHiba;
	private String hibajelenseg;
	private String hibajelensegMegnevezese;
	private String hibaOka;
	private String kivizsgalasEredmenye;
	private String nemoOTGID;
	private String etID;
	private String eszkozellenorzesVolt;
	private String jelszintekRendben;
	private String selfInstal;
	private String eventusIDAzonosito;
	private String mlComplaintCoda;
	private String MIWOType;
	private String MIWOStatus;
	private String MIResolutionType;
	private String MIDesc;
	private String ugyMegnevezese;
	private String node;
	private String hibaKod;

	public String getIktato() {
		return iktato;
	}

	public void setIktato(String iktato) {
		this.iktato = iktato;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getContactDate() {
		return contactDate;
	}

	public void setContactDate(String contactDate) {
		this.contactDate = contactDate;
	}

	public String getEszkoz() {
		return eszkoz;
	}

	public void setEszkoz(String eszkoz) {
		this.eszkoz = eszkoz;
	}

	public String getErintett() {
		return erintett;
	}

	public void setErintett(String erintett) {
		this.erintett = erintett;
	}

	public String getVtvHiba() {
		return vtvHiba;
	}

	public void setVtvHiba(String vtvHiba) {
		this.vtvHiba = vtvHiba;
	}

	public String getHibajelenseg() {
		return hibajelenseg;
	}

	public void setHibajelenseg(String hibajelenseg) {
		this.hibajelenseg = hibajelenseg;
	}

	public String getHibajelensegMegnevezese() {
		return hibajelensegMegnevezese;
	}

	public void setHibajelensegMegnevezese(String hibajelensegMegnevezese) {
		this.hibajelensegMegnevezese = hibajelensegMegnevezese;
	}

	public String getHibaOka() {
		return hibaOka;
	}

	public void setHibaOka(String hibaOka) {
		this.hibaOka = hibaOka;
	}

	public String getKivizsgalasEredmenye() {
		return kivizsgalasEredmenye;
	}

	public void setKivizsgalasEredmenye(String kivizsgalasEredmenye) {
		this.kivizsgalasEredmenye = kivizsgalasEredmenye;
	}

	public String getNemoOTGID() {
		return nemoOTGID;
	}

	public void setNemoOTGID(String nemoOTGID) {
		this.nemoOTGID = nemoOTGID;
	}

	public String getEtID() {
		return etID;
	}

	public void setEtID(String etID) {
		this.etID = etID;
	}

	public String getEszkozellenorzesVolt() {
		return eszkozellenorzesVolt;
	}

	public void setEszkozellenorzesVolt(String eszkozellenorzesVolt) {
		this.eszkozellenorzesVolt = eszkozellenorzesVolt;
	}

	public String getJelszintekRendben() {
		return jelszintekRendben;
	}

	public void setJelszintekRendben(String jelszintekRendben) {
		this.jelszintekRendben = jelszintekRendben;
	}

	public String getSelfInstal() {
		return selfInstal;
	}

	public void setSelfInstal(String selfInstal) {
		this.selfInstal = selfInstal;
	}

	public String getEventusIDAzonosito() {
		return eventusIDAzonosito;
	}

	public void setEventusIDAzonosito(String eventusIDAzonosito) {
		this.eventusIDAzonosito = eventusIDAzonosito;
	}

	public String getMlComplaintCoda() {
		return mlComplaintCoda;
	}

	public void setMlComplaintCoda(String mlComplaintCoda) {
		this.mlComplaintCoda = mlComplaintCoda;
	}

	public String getMIWOType() {
		return MIWOType;
	}

	public void setMIWOType(String mIWOType) {
		MIWOType = mIWOType;
	}

	public String getMIWOStatus() {
		return MIWOStatus;
	}

	public void setMIWOStatus(String mIWOStatus) {
		MIWOStatus = mIWOStatus;
	}

	public String getMIResolutionType() {
		return MIResolutionType;
	}

	public void setMIResolutionType(String mIResolutionType) {
		MIResolutionType = mIResolutionType;
	}

	public String getMIDesc() {
		return MIDesc;
	}

	public void setMIDesc(String mIDesc) {
		MIDesc = mIDesc;
	}

	public String getUgyMegnevezese() {
		return ugyMegnevezese;
	}

	public void setUgyMegnevezese(String ugyMegnevezese) {
		this.ugyMegnevezese = ugyMegnevezese;
	}

	public String getNode() {
		return node;
	}

	public void setNode(String node) {
		this.node = node;
	}

	@Override
	public int compareTo(Object arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

	
	
	
	
	
	public int mezoIndexVissza(String s) {
		
		if (s.equals("Iktato")) { return 0;}
		if (s.equals("Subject Name")) { return 1;}
		if (s.equals("Contact Date")) { return 2;}
		if (s.equals("Eszkoz")) { return 3;}
		if (s.equals("Erintett Szolgaltatasok")) { return 4;}
		if (s.equals("Vtv Hiba")) { return 5;}
		if (s.equals("Hibajelenseg Kategoriaja")) { return 6;}
		if (s.equals("Hibajelenseg Megnevezese")) { return 7;}
		if (s.equals("Hiba Oka")) { return 8;}
		if (s.equals("Kivizsgalas Eredmenye")) { return 9;}
		if (s.equals("Nemo Otg Id")) { return 10;}
		if (s.equals("Et Id")) { return 11;}
		if (s.equals("Eszkozellenorzes Volt")) { return 12;}
		if (s.equals("Jelszintek Rendben")) { return 13;}
		if (s.equals("Self Inst Alatt Jel Hiba")) { return 14;}
		if (s.equals("Eventus Sd Azonosíto")) { return 15;}
		if (s.equals("Ml Complaint Code")) { return 16;}
		if (s.equals("Ml Wo Type")) { return 17;}
		if (s.equals("Ml Wo Status")) { return 18;}
		if (s.equals("Ml Resolution Code")) { return 19;}
		if (s.equals("Ml Descr")) { return 20;}
		if (s.equals("Ugy Megjegyzes")) { return 21;}
		if (s.equals("Node")) { return 22;}
		if (s.contentEquals("Hibakód/Problem Ticket Id")) {return 23;}
		
		return 1000;
		
	}
	
	
	public String getValueOf(String mezo) {
		
		return getMezoIndex(mezoIndexVissza(mezo));
	}
	
	public String getMezoIndex(int i) {
		
		
		switch(i) {	


		case 0: return iktato;
		case 1: return subject;
		case 2: return contactDate;
		case 3: return eszkoz;
		case 4: return erintett;
		case 5: return vtvHiba;
		case 6: return hibajelenseg;
		case 7: return hibajelensegMegnevezese;
		case 8: return hibaOka;
		case 9: return kivizsgalasEredmenye;
		case 10: return nemoOTGID;
		case 11: return etID;
		case 12: return eszkozellenorzesVolt;
		case 13: return jelszintekRendben;
		case 14: return selfInstal;
		case 15: return eventusIDAzonosito;
		case 16: return mlComplaintCoda;
		case 17: return MIWOType;
		case 18: return MIWOStatus;
		case 19: return MIResolutionType;
		case 20: return MIDesc;
		case 21: return ugyMegnevezese;
		case 22: return node;
		case 23: return hibaKod;
		
		default: return "1000";

	}
		
	}

	public String getHibaKod() {
		return hibaKod;
	}

	public void setHibaKod(String hibaKod) {
		this.hibaKod = hibaKod;
	}
	
	
	
	
}
