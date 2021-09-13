package com.dataloader.models;

import static com.dataloader.constants.ApplicationConstants.EMPTY;

public class AssignmentWorkMeasure {

	private final String mode = "MERGE";
	private final String entity = "AssignmentWorkMeasure";
	private String sourceSystemOwner;
	private String sourceSystemId;
	private String AssignmentNumber;
	private String EffectiveStartDate;
	private String EffectiveEndDate = "4712/12/31";
	private String Unit;
	private String Value;
	private String ActionCode = "HIRE";
	private String ReasonCode;

	public String getAssignmentNumber() {
		return AssignmentNumber;
	}

	public void setAssignmentNumber(String assignmentNumber) {
		AssignmentNumber = assignmentNumber;
	}

	public String getEffectiveStartDate() {
		return EffectiveStartDate;
	}

	public void setEffectiveStartDate(String effectiveStartDate) {
		EffectiveStartDate = effectiveStartDate;
	}

	public String getReasonCode() {
		return ReasonCode;
	}

	public void setReasonCode(String reasonCode) {
		ReasonCode = reasonCode;
	}

	public String getUnit() {
		return Unit;
	}

	public void setUnit(String unit) {
		Unit = unit;
	}

	public String getValue() {
		return Value;
	}

	public void setValue(String value) {
		Value = value;
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

	@Override
	public String toString() {
		String string = mode + "|" + entity + "|" + sourceSystemOwner + "|" + sourceSystemId + "|" + AssignmentNumber + "|"
				+ EffectiveStartDate + "|" + EffectiveEndDate + "|" + Unit + "|" + Value + "|" + ActionCode + "|"
				+ ReasonCode;
		string = string.replace("null", EMPTY);
		return string;
	}
	

}
