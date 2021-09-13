package com.dataloader.models;

import static com.dataloader.constants.ApplicationConstants.EMPTY;

public class PersonLegistlativeData {

	private String mode = "MERGE";
	private String entity = "PersonLegislativeData";
	private String sourceSystemOwner;
	private String sourceSystemId;
	private String personId;
	private String personNumber;
	private String effectiveStartDate;
	private String effectiveEndDate = "4712/12/31";
	private String legislationCode = "US";
	private String sex;
	private String maritalStatus;
	private String highestEducationLevel;
	private String veteranSelfIdentification;
	private String flex_per_person_legistlative_data_leg_ddf = "US";

	public String getPersonNumber() {
		return personNumber;
	}

	public String getEffectiveStartDate() {
		return effectiveStartDate;
	}

	public String getSex() {
		return sex;
	}

	public String getMaritalStatus() {
		return maritalStatus;
	}

	public String getHighestEducationLevel() {
		return highestEducationLevel;
	}

	public void setPersonNumber(String personNumber) {
		this.personNumber = personNumber;
	}

	public void setEffectiveStartDate(String effectiveStartDate) {
		this.effectiveStartDate = effectiveStartDate;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public void setMaritalStatus(String maritalStatus) {
		this.maritalStatus = maritalStatus;
	}

	public void setHighestEducationLevel(String highestEducationLevel) {
		this.highestEducationLevel = highestEducationLevel;
	}

	public String getVeteranSelfIdentification() {
		return veteranSelfIdentification;
	}

	public void setVeteranSelfIdentification(String veteranSelfIdentification) {
		this.veteranSelfIdentification = veteranSelfIdentification;
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
				+ personNumber + "|" + effectiveStartDate + "|" + effectiveEndDate + "|" + legislationCode + "|" + sex
				+ "|" + maritalStatus + "|" + highestEducationLevel + "|" + veteranSelfIdentification + "|"
				+ flex_per_person_legistlative_data_leg_ddf;
		string = string.replace("null", EMPTY);
		return string;
	}

	

}
