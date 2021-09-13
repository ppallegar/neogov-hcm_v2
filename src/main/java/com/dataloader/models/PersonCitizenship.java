package com.dataloader.models;

import static com.dataloader.constants.ApplicationConstants.EMPTY;

public class PersonCitizenship {

	private String mode = "MERGE";
	private String entity = "PersonCitizenship";
	private String sourceSystemOwner;
	private String sourceSystemId;
	private String personId;
	private String personNumber;
	private String dateFrom;
	private String dateTo = "4712/12/31";
	private String legislationCode = "US";
	private String citizenshipStatus = "A";

	public String getPersonNumber() {
		return personNumber;
	}

	public void setPersonNumber(String personNumber) {
		this.personNumber = personNumber;
	}

	public String getDateFrom() {
		return dateFrom;
	}

	public void setDateFrom(String dateFrom) {
		this.dateFrom = dateFrom;
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
				+ personNumber + "|" + dateFrom + "|" + dateTo + "|" + legislationCode + "|" + citizenshipStatus;
		string = string.replace("null", EMPTY);
		return string;
	}
	
	

}
