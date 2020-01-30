
public class LineFromOTGSMSExcel implements Comparable {
	
	private String ures;
	private String IKTSZ;
	private String ACCOUNT_NUMBER;
	private String CONTACT_TYPE;
	private String SUBJECT;
	private String STATUSZ;
	private String INDITAS;
	private String INDITAS_NAPJA;
	private String LEZARAS_NAPJA;
	private String Nemo_OTG_ID;
	private String INTERFACE_ID;
	private String OTG_STATUS_DATE;
	private String OTG_CLOSED;
	private String START_TIME;
	private String END_TIME;
	private String SMS_SENT_TO;
	private String otthoni1;
	private String otthoni2;
	private String mobil1;
	private String mobil2;
	private String business;
	private String munkahelyi;
	private String ADE;
	private String otgendDay;
	private String name;
	private String phone1;
	public String getUres() {
		return ures;
	}
	public void setUres(String ures) {
		this.ures = ures;
	}
	public String getIKTSZ() {
		return IKTSZ;
	}
	public void setIKTSZ(String iKTSZ) {
		IKTSZ = iKTSZ;
	}
	public String getACCOUNT_NUMBER() {
		return ACCOUNT_NUMBER;
	}
	public void setACCOUNT_NUMBER(String aCCOUNT_NUMBER) {
		ACCOUNT_NUMBER = aCCOUNT_NUMBER;
	}
	public String getCONTACT_TYPE() {
		return CONTACT_TYPE;
	}
	public void setCONTACT_TYPE(String cONTACT_TYPE) {
		CONTACT_TYPE = cONTACT_TYPE;
	}
	public String getSUBJECT() {
		return SUBJECT;
	}
	public void setSUBJECT(String sUBJECT) {
		SUBJECT = sUBJECT;
	}
	public String getSTATUSZ() {
		return STATUSZ;
	}
	public void setSTATUSZ(String sTATUSZ) {
		STATUSZ = sTATUSZ;
	}
	public String getINDITAS() {
		return INDITAS;
	}
	public void setINDITAS(String iNDITAS) {
		INDITAS = iNDITAS;
	}
	public String getINDITAS_NAPJA() {
		return INDITAS_NAPJA;
	}
	public void setINDITAS_NAPJA(String iNDITAS_NAPJA) {
		INDITAS_NAPJA = iNDITAS_NAPJA;
	}
	public String getLEZARAS_NAPJA() {
		return LEZARAS_NAPJA;
	}
	public void setLEZARAS_NAPJA(String lEZARAS_NAPJA) {
		LEZARAS_NAPJA = lEZARAS_NAPJA;
	}
	public String getNemo_OTG_ID() {
		return Nemo_OTG_ID;
	}
	public void setNemo_OTG_ID(String nemo_OTG_ID) {
		Nemo_OTG_ID = nemo_OTG_ID;
	}
	public String getINTERFACE_ID() {
		return INTERFACE_ID;
	}
	public void setINTERFACE_ID(String iNTERFACE_ID) {
		INTERFACE_ID = iNTERFACE_ID;
	}
	public String getOTG_STATUS_DATE() {
		return OTG_STATUS_DATE;
	}
	public void setOTG_STATUS_DATE(String oTG_STATUS_DATE) {
		OTG_STATUS_DATE = oTG_STATUS_DATE;
	}
	public String getOTG_CLOSED() {
		return OTG_CLOSED;
	}
	public void setOTG_CLOSED(String oTG_CLOSED) {
		OTG_CLOSED = oTG_CLOSED;
	}
	public String getSTART_TIME() {
		return START_TIME;
	}
	public void setSTART_TIME(String sTART_TIME) {
		START_TIME = sTART_TIME;
	}
	public String getEND_TIME() {
		return END_TIME;
	}
	public void setEND_TIME(String eND_TIME) {
		END_TIME = eND_TIME;
	}
	public String getSMS_SENT_TO() {
		return SMS_SENT_TO;
	}
	public void setSMS_SENT_TO(String sMS_SENT_TO) {
		SMS_SENT_TO = sMS_SENT_TO;
	}
	public String getOtthoni1() {
		return otthoni1;
	}
	public void setOtthoni1(String otthoni1) {
		this.otthoni1 = otthoni1;
	}
	public String getOtthoni2() {
		return otthoni2;
	}
	public void setOtthoni2(String otthoni2) {
		this.otthoni2 = otthoni2;
	}
	public String getMobil1() {
		return mobil1;
	}
	public void setMobil1(String mobil1) {
		this.mobil1 = mobil1;
	}
	public String getMobil2() {
		return mobil2;
	}
	public void setMobil2(String mobil2) {
		this.mobil2 = mobil2;
	}
	public String getBusiness() {
		return business;
	}
	public void setBusiness(String business) {
		this.business = business;
	}
	public String getMunkahelyi() {
		return munkahelyi;
	}
	public void setMunkahelyi(String munkahelyi) {
		this.munkahelyi = munkahelyi;
	}
	public String getOtgendDay() {
		return otgendDay;
	}
	public void setOtgendDay(String otgendDay) {
		this.otgendDay = otgendDay;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone1() {
		return phone1;
	}
	public void setPhone1(String phone1) {
		this.phone1 = phone1;
	}
	@Override
	public int compareTo(Object arg0) {
		// TODO Auto-generated method stub
		try {
			
			Integer t1 = Integer.parseInt(this.ACCOUNT_NUMBER);
			Integer t2 = Integer.parseInt(((LineFromOTGSMSExcel)arg0).getACCOUNT_NUMBER());
			
			return t1.compareTo(t2);
			
		}catch (Exception ex) {
		return ((LineFromOTGSMSExcel)(arg0)).getACCOUNT_NUMBER().compareTo(this.getACCOUNT_NUMBER());
		}
		
	}
	public String getADE() {
		return ADE;
	}
	public void setADE(String aDE) {
		ADE = aDE;
	}



}
