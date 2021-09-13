package com.dataloader.models;

import static com.dataloader.constants.ApplicationConstants.EMPTY;

public class AssignedPayroll {

	private final String mode = "MERGE";
	private final String entity = "AssignedPayroll";
	private String sourceSystemOwner;
	private String sourceSystemId;
	private String effectiveStartDate;
	private String assignmentNumber;
	private String payrollID;
	private String legislativeDataGroupName = "US Legislative Data Group";
	private String startDate;
	private String timecardRequiredFlag;
	private String effectiveEndDate = "4712/12/31";

	public String getAssignmentNumber() {
		return assignmentNumber;
	}

	public void setAssignmentNumber(String assignmentNumber) {
		this.assignmentNumber = assignmentNumber;
	}

	public String getEffectiveStartDate() {
		return effectiveStartDate;
	}

	public void setEffectiveStartDate(String effectiveStartDate) {
		this.effectiveStartDate = effectiveStartDate;
	}

	public String getPayrollID() {
		return payrollID;
	}

	public void setPayrollID(String payrollID) {
		this.payrollID = payrollID;
	}

	public String getTimecardRequiredFlag() {
		return timecardRequiredFlag;
	}

	public void setTimecardRequiredFlag(String timecardRequiredFlag) {
		this.timecardRequiredFlag = timecardRequiredFlag;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
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

	@Override
	public String toString() {
		String string = mode + "|" + entity + "|" + sourceSystemOwner + "|" + sourceSystemId + "|" + effectiveStartDate + "|"
				+ assignmentNumber + "|" + payrollID + "|" + legislativeDataGroupName + "|" + startDate + "|"
				+ timecardRequiredFlag + "|" + effectiveEndDate;
		string = string.replace("null", EMPTY);
		return string;
	}
	
	

}
