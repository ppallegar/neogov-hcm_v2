package com.dataloader.models;

import static com.dataloader.constants.ApplicationConstants.EMPTY;

public class Worker {

	private String mode = "MERGE";
	private String entity = "Worker";
	private String sourceSystemOwner;
	private String sourceSystemId;
	private String personNumber;
	private String effectiveStartDate;
	private String startDate;
	private String effectiveEndDate = "4712/12/31";
	private String dateOfBirth;
	private String categoryCode = "PER_EIT";
	private String actionCode = "HIRE";
	private String reasonCode;

	public String getPersonNumber() {
		return personNumber;
	}

	public String getEffectiveStartDate() {
		return effectiveStartDate;
	}

	public String getStartDate() {
		return startDate;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public String getReasonCode() {
		return reasonCode;
	}

	public void setPersonNumber(String personNumber) {
		this.personNumber = personNumber;
	}

	public void setEffectiveStartDate(String effectiveStartDate) {
		this.effectiveStartDate = effectiveStartDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public void setReasonCode(String reasonCode) {
		this.reasonCode = reasonCode;
	}

	public String getSourceSystemId() {
		return sourceSystemId;
	}

	public void setSourceSystemId(String sourceSystemId) {
		this.sourceSystemId = sourceSystemId;
	}

	public String getSourceSystemOwner() {
		return sourceSystemOwner;
	}

	public void setSourceSystemOwner(String sourceSystemOwner) {
		this.sourceSystemOwner = sourceSystemOwner;
	}

	public String getEntity() {
		return entity;
	}

	@Override
	public String toString() {
		String string = mode + "|" + entity + "|" + sourceSystemOwner + "|" + sourceSystemId + "|" + personNumber + "|"
				+ effectiveStartDate + "|" + startDate + "|" + effectiveEndDate + "|" + dateOfBirth + "|" + categoryCode
				+ "|" + actionCode + "|" + reasonCode;
		string = string.replace("null", EMPTY);
		return string;
	}
	
	

}
