package com.dataloader.models;

import static com.dataloader.constants.ApplicationConstants.*;

public class PersonNationalIdentifier {

	private String mode = "MERGE";
	private String entity = "PersonNationalIdentifier";
	private String sourceSystemOwner;
	private String sourceSystemId;
	private String personId;
	private String personNumber;
	private String legislationCode = "US";
	private String nationalIdentifierType = "SSN";
	private String nationalIdentifierNumber;
	private String primaryFlag = "Y";

	public String getNationalIdentifierNumber() {
		return nationalIdentifierNumber;
	}

	public void setNationalIdentifierNumber(String nationalIdentifierNumber) {
		this.nationalIdentifierNumber = nationalIdentifierNumber;
	}

	public String getPersonNumber() {
		return personNumber;
	}

	public void setPersonNumber(String personNumber) {
		this.personNumber = personNumber;
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
				+ personNumber + "|" + legislationCode + "|" + nationalIdentifierType + "|" + nationalIdentifierNumber
				+ "|" + primaryFlag;
		string = string.replace("null", EMPTY);
		return string;
	}
	

}
