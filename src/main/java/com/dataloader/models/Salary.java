package com.dataloader.models;

import static com.dataloader.constants.ApplicationConstants.EMPTY;

public class Salary {

	private final String mode = "MERGE";
	private final String entity = "Salary";
	private String sourceSystemOwner;
	private String sourceSystemId;
	private String assignmentNumber;
	private String dateFrom;
	private String salaryAmount;
	private String salaryBasisName;
	private String actionCode;
	private String reasonCode;
	private String salaryApproved;
	private String nextSalReviewDate;
	private String multipleComponents = "N";

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

	public String getAssignmentNumber() {
		return assignmentNumber;
	}

	public void setAssignmentNumber(String assignmentNumber) {
		this.assignmentNumber = assignmentNumber;
	}

	public String getDateFrom() {
		return dateFrom;
	}

	public void setDateFrom(String dateFrom) {
		this.dateFrom = dateFrom;
	}

	public String getSalaryAmount() {
		return salaryAmount;
	}

	public void setSalaryAmount(String salaryAmount) {
		this.salaryAmount = salaryAmount;
	}

	public String getSalaryBasisName() {
		return salaryBasisName;
	}

	public void setSalaryBasisName(String salaryBasisName) {
		this.salaryBasisName = salaryBasisName;
	}

	public String getActionCode() {
		return actionCode;
	}

	public void setActionCode(String actionCode) {
		this.actionCode = actionCode;
	}

	public String getReasonCode() {
		return reasonCode;
	}

	public void setReasonCode(String reasonCode) {
		this.reasonCode = reasonCode;
	}

	public String getSalaryApproved() {
		return salaryApproved;
	}

	public void setSalaryApproved(String salaryApproved) {
		this.salaryApproved = salaryApproved;
	}

	public String getNextSalReviewDate() {
		return nextSalReviewDate;
	}

	public void setNextSalReviewDate(String nextSalReviewDate) {
		this.nextSalReviewDate = nextSalReviewDate;
	}

	public String getMultipleComponents() {
		return multipleComponents;
	}

	public void setMultipleComponents(String multipleComponents) {
		this.multipleComponents = multipleComponents;
	}

	@Override
	public String toString() {
		String string = mode + "|" + entity + "|" + sourceSystemOwner + "|" + sourceSystemId + "|" + assignmentNumber
				+ "|" + dateFrom + "|" + salaryAmount + "|" + salaryBasisName + "|" + actionCode + "|" + reasonCode
				+ "|" + salaryApproved + "|" + nextSalReviewDate + "|" + multipleComponents;
		string = string.replace("null", EMPTY);
		return string;
	}

}
