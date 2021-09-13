package com.dataloader.models;

import static com.dataloader.constants.ApplicationConstants.EMPTY;

public class AssignmentSupervisor {

	private final String mode = "MERGE";
	private final String entity = "AssignmentSupervisor";
	private String sourceSystemOwner;
	private String sourceSystemId;
	private String personId;
	private String effectiveStartDate;
	private String effectiveEndDate = "4712/12/31";
	private String managerType = "LINE_MANAGER";
	private String managerPersonNumber;
	private String primaryFlag = "Y";
	private String assignmentNumber;
	private String replaceFirstEffectiveStartDate = "Y";

	public String getAssignmentNumber() {
		return assignmentNumber;
	}

	public void setAssignmentNumber(String assignmentNumber) {
		this.assignmentNumber = assignmentNumber;
	}

	public String getManagerPersonNumber() {
		return managerPersonNumber;
	}

	public void setManagerPersonNumber(String managerPersonNumber) {
		this.managerPersonNumber = managerPersonNumber;
	}

	public String getEffectiveStartDate() {
		return effectiveStartDate;
	}

	public void setEffectiveStartDate(String effectiveStartDate) {
		this.effectiveStartDate = effectiveStartDate;
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

	@Override
	public String toString() {
		String string = mode + "|" + entity + "|" + sourceSystemOwner + "|" + sourceSystemId + "|" + personId + "|"
				+ effectiveStartDate + "|" + effectiveEndDate + "|" + managerType + "|" + managerPersonNumber + "|"
				+ primaryFlag + "|" + assignmentNumber + "|" + replaceFirstEffectiveStartDate;
		string = string.replace("null", EMPTY);
		return string;
	}
	

}
