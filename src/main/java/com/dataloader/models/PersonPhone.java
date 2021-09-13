package com.dataloader.models;

import static com.dataloader.constants.ApplicationConstants.EMPTY;

public class PersonPhone {

	private final String mode = "MERGE";
	private final String entity = "PersonPhone";
	private String sourceSystemOwner;
	private String sourceSystemId;
	private String personId;
	private String personNumber;
	private String dateFrom;
	private String legislationCode = "US";
	private String phoneType;
	private String countryCodeNumber = "1";
	private String areaCode;
	private String phoneNumber;
	private String primaryFlag;

	public String getPersonNumber() {
		return personNumber;
	}

	public String getDateFrom() {
		return dateFrom;
	}

	public String getAreaCode() {
		return areaCode;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPersonNumber(String personNumber) {
		this.personNumber = personNumber;
	}

	public void setDateFrom(String dateFrom) {
		this.dateFrom = dateFrom;
	}

	public void setAreaCode(String areaCode) {
		this.areaCode = areaCode;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getPhoneType() {
		return phoneType;
	}

	public void setPhoneType(String phoneType) {
		this.phoneType = phoneType;
	}

	public String getSourceSystemOwner() {
		return sourceSystemOwner;
	}

	public void setSourceSystemOwner(String sourceSystemOwner) {
		this.sourceSystemOwner = sourceSystemOwner;
	}

	public String getSourceSystemId() {
		return sourceSystemId;
	}

	public void setSourceSystemId(String sourceSystemId) {
		this.sourceSystemId = sourceSystemId;
	}

	public String getPersonId() {
		return personId;
	}

	public void setPersonId(String personId) {
		this.personId = personId;
	}

	public String getPrimaryFlag() {
		return primaryFlag;
	}

	public void setPrimaryFlag(String primaryFlag) {
		this.primaryFlag = primaryFlag;
	}

	@Override
	public String toString() {
		String string = mode + "|" + entity + "|" + sourceSystemOwner + "|" + sourceSystemId + "|" + personId + "|"
				+ personNumber + "|" + dateFrom + "|" + legislationCode + "|" + phoneType + "|" + countryCodeNumber
				+ "|" + areaCode + "|" + phoneNumber + "|" + primaryFlag;
		string = string.replace("null", EMPTY);
		return string;
	}

}
