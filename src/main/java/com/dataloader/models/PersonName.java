package com.dataloader.models;

import static com.dataloader.constants.ApplicationConstants.*;

public class PersonName {

	private String mode = "MERGE";
	private String entity = "PersonName";
	private String sourceSystemOwner;
	private String sourceSystemId;
	private String personId;
	private String PersonNumber;
	private String EffectiveStartDate;
	private String EffectiveEndDate = "4712/12/31";
	private String LegislationCode = "US";
	private String NameType = "GLOBAL";
	private String LastName;
	private String FirstName;
	private String MiddleNames;
	private String knownAs;
	private String Suffix;

	public String getPersonNumber() {
		return PersonNumber;
	}

	public String getEffectiveStartDate() {
		return EffectiveStartDate;
	}

	public String getLastName() {
		return LastName;
	}

	public String getFirstName() {
		return FirstName;
	}

	public String getMiddleNames() {
		return MiddleNames;
	}

	public void setPersonNumber(String personNumber) {
		PersonNumber = personNumber;
	}

	public void setEffectiveStartDate(String effectiveStartDate) {
		EffectiveStartDate = effectiveStartDate;
	}

	public void setLastName(String lastName) {
		LastName = lastName;
	}

	public void setFirstName(String firstName) {
		FirstName = firstName;
	}

	public void setMiddleNames(String middleNames) {
		MiddleNames = middleNames;
	}

	public String getSuffix() {
		return Suffix;
	}

	public void setSuffix(String suffix) {
		Suffix = suffix;
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

	public String getKnownAs() {
		return knownAs;
	}

	public void setKnownAs(String knownAs) {
		this.knownAs = knownAs;
	}

	@Override
	public String toString() {
		String string = mode + "|" + entity + "|" + sourceSystemOwner + "|" + sourceSystemId + "|" + personId + "|"
				+ PersonNumber + "|" + EffectiveStartDate + "|" + EffectiveEndDate + "|" + LegislationCode + "|"
				+ NameType + "|" + LastName + "|" + FirstName + "|" + MiddleNames + "|" + knownAs + "|" + Suffix;
		string = string.replace("null", EMPTY);
		return string;
	}
	
	

}
