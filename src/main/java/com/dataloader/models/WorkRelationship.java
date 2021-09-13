package com.dataloader.models;

import static com.dataloader.constants.ApplicationConstants.EMPTY;

public class WorkRelationship {

	private String mode = "MERGE";
	private String entity = "WorkRelationship";
	private String sourceSystemOwner;
	private String sourceSystemId;
	private String personId;
	private String personNumber;
	private String legalEmployerName = "City and County of Broomfield";
	private String dateStart;
	private String workerType = "E";
	private String actualTerminationDate;
	private String enterpriseSeniorityDate;
	private String legalEmployerSeniorityDate;
	private String primaryFlag = "Y";
	private String actionCode = "HIRE";
	private String reasonCode;
	private String flex_per_pps_leg_ddf = "US";
	private String i9_STATUS;
	private String medicalInsuranceAvailable;
	private String medicalInsuranceAvailabilityDa;
	private String nEW_HIRE_STATUS = "INCL";

	public String getPersonNumber() {
		return personNumber;
	}

	public String getDateStart() {
		return dateStart;
	}

	public String getReasonCode() {
		return reasonCode;
	}

	public String getI9_STATUS() {
		return i9_STATUS;
	}

	public String getMedicalInsuranceAvailable() {
		return medicalInsuranceAvailable;
	}

	public String getMedicalInsuranceAvailabilityDa() {
		return medicalInsuranceAvailabilityDa;
	}

	public void setPersonNumber(String personNumber) {
		this.personNumber = personNumber;
	}

	public void setDateStart(String dateStart) {
		this.dateStart = dateStart;
	}

	public void setReasonCode(String reasonCode) {
		this.reasonCode = reasonCode;
	}

	public void setI9_STATUS(String i9_STATUS) {
		this.i9_STATUS = i9_STATUS;
	}

	public void setMedicalInsuranceAvailable(String medicalInsuranceAvailable) {
		this.medicalInsuranceAvailable = medicalInsuranceAvailable;
	}

	public void setMedicalInsuranceAvailabilityDate(String medicalInsuranceAvailabilityDa) {
		this.medicalInsuranceAvailabilityDa = medicalInsuranceAvailabilityDa;
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

	public String getPersonId() {
		return personId;
	}

	public void setPersonId(String personId) {
		this.personId = personId;
	}

	public String getLegalEmployerSeniorityDate() {
		return legalEmployerSeniorityDate;
	}

	public void setLegalEmployerSeniorityDate(String legalEmployerSeniorityDate) {
		this.legalEmployerSeniorityDate = legalEmployerSeniorityDate;
	}
	
	@Override
	public String toString() {
		String string = mode + "|" + entity + "|" + sourceSystemOwner + "|" + sourceSystemId + "|" + personId + "|"
				+ personNumber + "|" + legalEmployerName + "|" + dateStart + "|" + workerType + "|"
				+ actualTerminationDate + "|" + enterpriseSeniorityDate + "|" + getLegalEmployerSeniorityDate() + "|"
				+ primaryFlag + "|" + actionCode + "|" + reasonCode + "|" + flex_per_pps_leg_ddf + "|" + i9_STATUS + "|"
				+ medicalInsuranceAvailable + "|" + medicalInsuranceAvailabilityDa + "|" + nEW_HIRE_STATUS;
		string = string.replace("null", EMPTY);
		return string;
	}

	

	
	
	

}
