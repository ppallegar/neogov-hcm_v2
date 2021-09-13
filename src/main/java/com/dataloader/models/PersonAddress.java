package com.dataloader.models;

import static com.dataloader.constants.ApplicationConstants.EMPTY;

public class PersonAddress {

	private final String mode = "MERGE";
	private final String entity = "PersonAddress";
	private String sourceSystemOwner;
	private String sourceSystemId;
	private String effectiveStartDate;
	private String effectiveEndDate = "4712/12/31";
	private String personNumber;
	private String addressType;
	private String addressLine1;
	private String addressLine2;
	private String addressLine3;
	private String region1;
	private String region2;
	private String region3;
	private String townOrCity;
	private String postalCode;
	private String country;
	private String primaryFlag;

	public String getPersonNumber() {
		return personNumber;
	}

	public String getEffectiveStartDate() {
		return effectiveStartDate;
	}

	public String getAddressLine1() {
		return addressLine1;
	}

	public String getAddressLine2() {
		return addressLine2;
	}

	public String getTownOrCity() {
		return townOrCity;
	}

	public String getRegion2() {
		return region2;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public String getRegion1() {
		return region1;
	}

	public String getPrimaryFlag() {
		return primaryFlag;
	}

	public void setPersonNumber(String personNumber) {
		this.personNumber = personNumber;
	}

	public void setEffectiveStartDate(String effectiveStartDate) {
		this.effectiveStartDate = effectiveStartDate;
	}

	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}

	public void setTownOrCity(String townOrCity) {
		this.townOrCity = townOrCity;
	}

	public void setRegion2(String region2) {
		this.region2 = region2;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public void setRegion1(String region1) {
		this.region1 = region1;
	}

	public void setPrimaryFlag(String primaryFlag) {
		this.primaryFlag = primaryFlag;
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

	public String getAddressType() {
		return addressType;
	}

	public void setAddressType(String addressType) {
		this.addressType = addressType;
	}

	public String getAddressLine3() {
		return addressLine3;
	}

	public void setAddressLine3(String addressLine3) {
		this.addressLine3 = addressLine3;
	}

	public String getRegion3() {
		return region3;
	}

	public void setRegion3(String region3) {
		this.region3 = region3;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	@Override
	public String toString() {
		String string = mode + "|" + entity + "|" + sourceSystemOwner + "|" + sourceSystemId + "|" + effectiveStartDate
				+ "|" + effectiveEndDate + "|" + personNumber + "|" + addressType + "|" + addressLine1 + "|"
				+ addressLine2 + "|" + addressLine3 + "|" + region1 + "|" + region2 + "|" + region3 + "|" + townOrCity
				+ "|" + postalCode + "|" + country + "|" + primaryFlag ;
		string = string.replace("null", EMPTY);
		return string;
	}

}
