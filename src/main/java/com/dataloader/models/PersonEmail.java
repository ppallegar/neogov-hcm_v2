package com.dataloader.models;

import static com.dataloader.constants.ApplicationConstants.EMPTY;

public class PersonEmail {

	private String mode = "MERGE";
	private String entity = "PersonEmail";
	private String sourceSystemOwner;
	private String sourceSystemId;
	private String personId;
	private String personNumber;
	private String dateFrom;
	private String dateTo = "4712/12/31";
	private String emailType;
	private String emailAddress;
	private String primaryFlag;

	public String getPersonNumber() {
		return personNumber;
	}

	public String getDateFrom() {
		return dateFrom;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setPersonNumber(String personNumber) {
		this.personNumber = personNumber;
	}

	public void setDateFrom(String dateFrom) {
		this.dateFrom = dateFrom;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getEmailType() {
		return emailType;
	}

	public void setEmailType(String emailType) {
		this.emailType = emailType;
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

	@Override
	public String toString() {
		String string = mode + "|" + entity + "|" + sourceSystemOwner + "|" + sourceSystemId + "|" + personId + "|"
				+ personNumber + "|" + dateFrom + "|" + dateTo + "|" + emailType + "|" + emailAddress + "|"
				+ getPrimaryFlag();
		string = string.replace("null", EMPTY);
		return string;
	}

	public String getPrimaryFlag() {
		return primaryFlag;
	}

	public void setPrimaryFlag(String primaryFlag) {
		this.primaryFlag = primaryFlag;
	}

}
