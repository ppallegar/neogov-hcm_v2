package com.dataloader.models;

import static com.dataloader.constants.ApplicationConstants.EMPTY;

public class PayrollAssignment {

	private final String mode = "MERGE";
	private final String entity = "PayrollAssignmentDetails";
	private String effectiveStartDate;
	private String timeCardRequired;
	private String assignmentNumber;
	private String overtimePeriodCode = "";
	private String legislativeDataGroupName = "US Legislative Data Group";

	public String getEffectiveStartDate() {
		return effectiveStartDate;
	}

	public void setEffectiveStartDate(String effectiveStartDate) {
		this.effectiveStartDate = effectiveStartDate;
	}

	public String getTimeCardRequired() {
		return timeCardRequired;
	}

	public void setTimeCardRequired(String timeCardRequired) {
		this.timeCardRequired = timeCardRequired;
	}

	public String getAssignmentNumber() {
		return assignmentNumber;
	}

	public void setAssignmentNumber(String assignmentNumber) {
		this.assignmentNumber = assignmentNumber;
	}

	public String getOvertimePeriodCode() {
		return overtimePeriodCode;
	}

	public void setOvertimePeriodCode(String overtimePeriodCode) {
		this.overtimePeriodCode = overtimePeriodCode;
	}

	
	@Override
	public String toString() {
		String string = mode + "|" + entity + "|" + effectiveStartDate + "|" + timeCardRequired + "|" + assignmentNumber + "|"
				+ overtimePeriodCode + "|" + legislativeDataGroupName;
		string = string.replace("null", EMPTY);
		return string;
	}
	

}
