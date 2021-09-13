package com.dataloader.models;

import static com.dataloader.constants.ApplicationConstants.EMPTY;

public class Assignment {

	private final String mode = "MERGE";
	private final String entity = "Assignment";
	private String sourceSystemOwner;
	private String sourceSystemId;
	private String personId;
	private String periodOfServiceId;
	private String workTermsAssignmentId;
	private String personNumber;
	private String legalEmployerName = "City and County of Broomfield";
	private String dateStart;
	private String effectiveStartDate;
	private String effectiveSequence = "1";
	private String effectiveEndDate = "4712/12/31";
	private String actionCode = "HIRE";
	private String reasonCode;
	private String assignmentNumber;
	private String assignmentName;
	private String workTermsNumber;
	private String assignmentType = "E";
	private String workerType = "E";
	private String primaryAssignmentFlag = "Y";
	private String primaryFlag = "Y";
	private String effectiveLatestChange = "Y";
	private String assignmentStatusTypeCode = "ACTIVE_PROCESS";
	private String personTypeCode = "Employee";
	private String businessUnitShortCode;
	private String positionCode;
	private String positionOverrideFlag;
	private String workerCategory;
	private String assignmentCategory;
	private String permanentTemporary;
	private String fullPartTime;
	private String managerFlag;
	private String hourlySalariedCode;
	private String normalHours;
	private String projectedEndDate;
	private String frequency;
	private String peopleGroup;
	private String flex_per_pps_leg_ddf = "US";
	private String acaFullTime;
	private String businessUnitId;
	private String taxReportingUnit;
	private String gradeId;
	
	public String getPersonNumber() {
		return personNumber;
	}

	public void setPersonNumber(String personNumber) {
		this.personNumber = personNumber;
	}

	public String getDateStart() {
		return dateStart;
	}

	public void setDateStart(String dateStart) {
		this.dateStart = dateStart;
	}

	public String getEffectiveStartDate() {
		return effectiveStartDate;
	}

	public void setEffectiveStartDate(String effectiveStartDate) {
		this.effectiveStartDate = effectiveStartDate;
	}

	public String getReasonCode() {
		return reasonCode;
	}

	public void setReasonCode(String reasonCode) {
		this.reasonCode = reasonCode;
	}

	public String getAssignmentNumber() {
		return assignmentNumber;
	}

	public void setAssignmentNumber(String assignmentNumber) {
		this.assignmentNumber = assignmentNumber;
	}

	public String getAssignmentName() {
		return assignmentName;
	}

	public void setAssignmentName(String assignmentName) {
		this.assignmentName = assignmentName;
	}

	public String getWorkTermsNumber() {
		return workTermsNumber;
	}

	public void setWorkTermsNumber(String workTermsNumber) {
		this.workTermsNumber = workTermsNumber;
	}

	public String getBusinessUnitShortCode() {
		return businessUnitShortCode;
	}

	public void setBusinessUnitShortCode(String businessUnitShortCode) {
		this.businessUnitShortCode = businessUnitShortCode;
	}

	public String getPositionCode() {
		return positionCode;
	}

	public void setPositionCode(String positionCode) {
		this.positionCode = positionCode;
	}

	public String getWorkerCategory() {
		return workerCategory;
	}

	public void setWorkerCategory(String workerCategory) {
		this.workerCategory = workerCategory;
	}

	public String getAssignmentCategory() {
		return assignmentCategory;
	}

	public void setAssignmentCategory(String assignmentCategory) {
		this.assignmentCategory = assignmentCategory;
	}

	public String getPermanentTemporary() {
		return permanentTemporary;
	}

	public void setPermanentTemporary(String permanentTemporary) {
		this.permanentTemporary = permanentTemporary;
	}

	public String getFullPartTime() {
		return fullPartTime;
	}

	public void setFullPartTime(String fullPartTime) {
		this.fullPartTime = fullPartTime;
	}

	public String getManagerFlag() {
		return managerFlag;
	}

	public void setManagerFlag(String managerFlag) {
		this.managerFlag = managerFlag;
	}

	public String getHourlySalariedCode() {
		return hourlySalariedCode;
	}

	public void setHourlySalariedCode(String hourlySalariedCode) {
		this.hourlySalariedCode = hourlySalariedCode;
	}

	public String getNormalHours() {
		return normalHours;
	}

	public void setNormalHours(String normalHours) {
		this.normalHours = normalHours;
	}

	public String getProjectedEndDate() {
		return projectedEndDate;
	}

	public void setProjectedEndDate(String projectedEndDate) {
		this.projectedEndDate = projectedEndDate;
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

	public String getPeriodOfServiceId() {
		return periodOfServiceId;
	}

	public void setPeriodOfServiceId(String periodOfServiceId) {
		this.periodOfServiceId = periodOfServiceId;
	}

	public String getPersonId() {
		return personId;
	}

	public void setPersonId(String personId) {
		this.personId = personId;
	}

	public String getWorkTermsAssignmentId() {
		return workTermsAssignmentId;
	}

	public void setWorkTermsAssignmentId(String workTermsAssignmentId) {
		this.workTermsAssignmentId = workTermsAssignmentId;
	}

	public String getFrequency() {
		return frequency;
	}

	public void setFrequency(String frequency) {
		this.frequency = frequency;
	}

	public String getAcaFullTime() {
		return acaFullTime;
	}

	public void setAcaFullTime(String acaFullTime) {
		this.acaFullTime = acaFullTime;
	}

	public String getPeopleGroup() {
		return peopleGroup;
	}

	public void setPeopleGroup(String peopleGroup) {
		this.peopleGroup = peopleGroup;
	}

	public String getBusinessUnitId() {
		return businessUnitId;
	}

	public void setBusinessUnitId(String businessUnitId) {
		this.businessUnitId = businessUnitId;
	}
	
	
	public String getTaxReportingUnit() {
		return taxReportingUnit;
	}

	public void setTaxReportingUnit(String taxReportingUnit) {
		this.taxReportingUnit = taxReportingUnit;
	}
	
	
	public String getPositionOverrideFlag() {
		return positionOverrideFlag;
	}

	public void setPositionOverrideFlag(String positionOverrideFlag) {
		this.positionOverrideFlag = positionOverrideFlag;
	}
	
	
	public String getGradeId() {
		return gradeId;
	}

	public void setGradeId(String gradeId) {
		this.gradeId = gradeId;
	}

	@Override
	public String toString() {
		//Added taxReportingUnit from work terms to assignment on 19-08-2021
		String string = mode + "|" + entity + "|" + sourceSystemOwner + "|" + sourceSystemId + "|" + personId + "|"
				+ periodOfServiceId + "|" + workTermsAssignmentId + "|" + personNumber + "|" + legalEmployerName + "|"
				+ dateStart + "|" + effectiveStartDate + "|" + effectiveSequence + "|" + effectiveEndDate + "|"
				+ actionCode + "|" + reasonCode + "|" + assignmentNumber + "|" + assignmentName + "|" + workTermsNumber
				+ "|" + assignmentType + "|" + workerType + "|" + primaryAssignmentFlag + "|" + primaryFlag + "|"
				+ effectiveLatestChange + "|" + assignmentStatusTypeCode + "|" + personTypeCode + "|"
				+ businessUnitId + "|" + positionCode + "|" + positionOverrideFlag + "|" + workerCategory + "|"
				+ assignmentCategory + "|" + permanentTemporary + "|" + fullPartTime + "|" + managerFlag + "|"
				+ hourlySalariedCode + "|" + normalHours + "|" + projectedEndDate + "|" + frequency + "|" + peopleGroup
				+ "|" + flex_per_pps_leg_ddf + "|" + acaFullTime + "|" + taxReportingUnit + "|" + gradeId;
		string = string.replace("null", EMPTY);
		return string;
	}
	
	

}
