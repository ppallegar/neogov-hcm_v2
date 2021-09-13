package com.dataloader;

import static com.dataloader.constants.ApplicationConstants.EMPTY;

import com.dataloader.models.AssignedPayroll;
import com.dataloader.models.Assignment;
import com.dataloader.models.AssignmentSupervisor;
import com.dataloader.models.AssignmentWorkMeasure;
import com.dataloader.models.NeoGovData;
import com.dataloader.models.PayrollAssignment;
import com.dataloader.models.PersonAddress;
import com.dataloader.models.PersonCitizenship;
import com.dataloader.models.PersonEmail;
import com.dataloader.models.PersonEthnicity;
import com.dataloader.models.PersonLegistlativeData;
import com.dataloader.models.PersonName;
import com.dataloader.models.PersonNationalIdentifier;
import com.dataloader.models.PersonPhone;
import com.dataloader.models.Salary;
import com.dataloader.models.User;
import com.dataloader.models.WorkRelationship;
import com.dataloader.models.WorkTerms;
import com.dataloader.models.Worker;
import com.dataloader.utils.DateTimeUtils;

public class NeoGovDataWorkerObjectMappers {

	private static String dateFormat_yyyyMMdd_slash = "yyyy/MM/dd";

	private static final String sourceSystemOwner = "CCOB_NEO";

	public static AssignedPayroll getAssignedPayrollObject(NeoGovData neoGovData) {
		AssignedPayroll assignedPayroll = new AssignedPayroll();
		assignedPayroll.setSourceSystemOwner(sourceSystemOwner);
		assignedPayroll.setSourceSystemId(neoGovData.getEmployeenumber() + "-PR-01");
		assignedPayroll.setAssignmentNumber("E" + neoGovData.getEmployeenumber());
		assignedPayroll.setEffectiveStartDate(
				DateTimeUtils.getFormattedDate(neoGovData.getStartDate(), dateFormat_yyyyMMdd_slash));
		assignedPayroll
				.setStartDate(DateTimeUtils.getFormattedDate(neoGovData.getStartDate(), dateFormat_yyyyMMdd_slash));
		assignedPayroll.setPayrollID(neoGovData.getPayrollId());
		assignedPayroll.setTimecardRequiredFlag(neoGovData.getTimecardRequired());
		return assignedPayroll;
	}

	public static PayrollAssignment getPayrollAssignment(NeoGovData neoGovData) {
		PayrollAssignment payrollAssignment = new PayrollAssignment();

		payrollAssignment.setEffectiveStartDate(
				DateTimeUtils.getFormattedDate(neoGovData.getStartDate(), dateFormat_yyyyMMdd_slash));
		payrollAssignment.setOvertimePeriodCode("");
		payrollAssignment.setTimeCardRequired(
				getTimeRequired(neoGovData.getTimecardRequired()));
		payrollAssignment.setAssignmentNumber("E" + neoGovData.getEmployeenumber());
		return payrollAssignment;

	}

	private static String getTimeRequired(String tcr) {
		if (tcr != null && !tcr.isEmpty()) {
			return tcr.equalsIgnoreCase("Y") ? "Yes" : (tcr.equalsIgnoreCase("N") ? "No" : EMPTY);
		}
		return EMPTY;
	}

	public static User getUserObject(NeoGovData neoGovData) {
		User user = new User();
		user.setPersonNumber(neoGovData.getEmployeenumber());
		user.setUserName(neoGovData.getUserName());

		return user;
	}

	public static Salary getSalaryObject(NeoGovData neoGovData) {
		Salary salary = new Salary();
		salary.setActionCode("HIRE");
		salary.setAssignmentNumber("E" + neoGovData.getEmployeenumber());
		salary.setDateFrom(DateTimeUtils.getFormattedDate(neoGovData.getStartDate(), dateFormat_yyyyMMdd_slash));
		salary.setNextSalReviewDate(
				DateTimeUtils.getFormattedDate(neoGovData.getNextReviewDate(), dateFormat_yyyyMMdd_slash));
		salary.setReasonCode(neoGovData.getAssignmentType());
		salary.setSalaryAmount(neoGovData.getOfferAmount());
		salary.setSalaryApproved("Y");
		//salary.setSalaryBasisName("CCOB Hourly Wages");
		salary.setSalaryBasisName(neoGovData.getSalaryBasisName());
		salary.setSourceSystemId(neoGovData.getEmployeenumber() + "-SAL-01");
		salary.setSourceSystemOwner(sourceSystemOwner);
		return salary;

	}

	public static AssignmentWorkMeasure getAssignmentWorkMeasureHeadObject(NeoGovData neoGovdata) {
		AssignmentWorkMeasure assignmentWorkMeasureHead = new AssignmentWorkMeasure();
		assignmentWorkMeasureHead.setSourceSystemOwner(sourceSystemOwner);
		assignmentWorkMeasureHead.setSourceSystemId(neoGovdata.getEmployeenumber() + "-AWMHEAD-01");
		assignmentWorkMeasureHead.setAssignmentNumber("E" + neoGovdata.getEmployeenumber());
		assignmentWorkMeasureHead.setEffectiveStartDate(
				DateTimeUtils.getFormattedDate(neoGovdata.getStartDate(), dateFormat_yyyyMMdd_slash));
		assignmentWorkMeasureHead.setReasonCode(neoGovdata.getAssignmentType());
		assignmentWorkMeasureHead.setUnit("HEAD");
		assignmentWorkMeasureHead.setValue("1");
		return assignmentWorkMeasureHead;
	}

	public static AssignmentWorkMeasure getAssignmentWorkMeasureFteObject(NeoGovData neoGovdata) {
		AssignmentWorkMeasure assignmentWorkMeasureFte = new AssignmentWorkMeasure();
		assignmentWorkMeasureFte.setSourceSystemOwner(sourceSystemOwner);
		assignmentWorkMeasureFte.setSourceSystemId(neoGovdata.getEmployeenumber() + "-AWMFTE-01");
		assignmentWorkMeasureFte.setAssignmentNumber("E" + neoGovdata.getEmployeenumber());
		assignmentWorkMeasureFte.setEffectiveStartDate(
				DateTimeUtils.getFormattedDate(neoGovdata.getStartDate(), dateFormat_yyyyMMdd_slash));
		assignmentWorkMeasureFte.setReasonCode(neoGovdata.getAssignmentType());
		assignmentWorkMeasureFte.setUnit("FTE");
		assignmentWorkMeasureFte.setValue(neoGovdata.getFte());
		return assignmentWorkMeasureFte;
	}

	public static AssignmentSupervisor getAssignmentSupervisorObject(NeoGovData neoGovdata) {
		AssignmentSupervisor assignmentSupervisor = new AssignmentSupervisor();
		assignmentSupervisor.setSourceSystemOwner(sourceSystemOwner);
		assignmentSupervisor.setSourceSystemId(neoGovdata.getEmployeenumber() + "-MGR-01");
		assignmentSupervisor.setPersonId(neoGovdata.getEmployeenumber() + "-Worker-01");
		assignmentSupervisor.setAssignmentNumber("E" + neoGovdata.getEmployeenumber());
		assignmentSupervisor.setEffectiveStartDate(
				DateTimeUtils.getFormattedDate(neoGovdata.getStartDate(), dateFormat_yyyyMMdd_slash));
		assignmentSupervisor.setManagerPersonNumber(neoGovdata.getManagerId());
		return assignmentSupervisor;
	}

	public static Assignment getAssignmentObject(NeoGovData neoGovdata) {
		Assignment assignment = new Assignment();
		assignment.setSourceSystemOwner(sourceSystemOwner);
		assignment.setSourceSystemId(neoGovdata.getEmployeenumber() + "-ASSGN-01");
		assignment.setPersonId(neoGovdata.getEmployeenumber() + "-Worker-01");
		assignment.setPeriodOfServiceId(neoGovdata.getEmployeenumber() + "-WRL-01");
		assignment.setWorkTermsAssignmentId(neoGovdata.getEmployeenumber() + "-WT-01");
		assignment.setAssignmentCategory(neoGovdata.getAssignmentCategory());
		assignment.setAssignmentName(neoGovdata.getPositionTitle());
		assignment.setAssignmentNumber("E" + neoGovdata.getEmployeenumber());
		//assignment.setBusinessUnitShortCode("City and County of Broomfield");
		assignment.setBusinessUnitId(neoGovdata.getBusinessUnitId());
		assignment.setDateStart(DateTimeUtils.getFormattedDate(neoGovdata.getStartDate(), dateFormat_yyyyMMdd_slash));
		assignment.setEffectiveStartDate(
				DateTimeUtils.getFormattedDate(neoGovdata.getStartDate(), dateFormat_yyyyMMdd_slash));
		assignment.setFrequency("Y");
		assignment.setFullPartTime(neoGovdata.getPositionFullTimeFlag());
		assignment.setHourlySalariedCode(neoGovdata.getHourlySalaried());
		assignment.setManagerFlag(neoGovdata.getManager());
		assignment.setNormalHours(neoGovdata.getHours());
		assignment.setPeopleGroup(neoGovdata.getPeopleGroup());
		assignment.setPermanentTemporary(
				neoGovdata.getAssignmentType() != null && neoGovdata.getAssignmentType().equals("CCOB_TEMP") ? "T"
						: "R");
		assignment.setPersonNumber(neoGovdata.getEmployeenumber());
		assignment.setPositionOverrideFlag("Y");
		assignment.setPositionCode(neoGovdata.getPositionCode());
		assignment.setProjectedEndDate(
				DateTimeUtils.getFormattedDate(neoGovdata.getProjectedEndDate(), dateFormat_yyyyMMdd_slash));
		assignment.setReasonCode(neoGovdata.getAssignmentType());
		assignment.setWorkerCategory(neoGovdata.getWorkerCategory() != null && !neoGovdata.getWorkerCategory().isEmpty()
				? neoGovdata.getWorkerCategory()
				: "E");
		assignment.setWorkTermsNumber("ET" + neoGovdata.getEmployeenumber());
		assignment.setAcaFullTime(neoGovdata.getAcaFulltime());
		//Added taxReportingUnit from work terms to assignment on 19-08-2021
		assignment.setTaxReportingUnit("City and County of Broomfield");
		assignment.setGradeId(neoGovdata.getGradeId());
		return assignment;
	}

	public static WorkTerms getWorktermsObject(NeoGovData neoGovdata) {
		WorkTerms workTerms = new WorkTerms();
		workTerms.setSourceSystemOwner(sourceSystemOwner);
		workTerms.setSourceSystemId(neoGovdata.getEmployeenumber() + "-WT-01");
		workTerms.setPersonId(neoGovdata.getEmployeenumber() + "-Worker-01");
		workTerms.setPeriodOfServiceId(neoGovdata.getEmployeenumber() + "-WRL-01");
		workTerms.setActionCode("HIRE");
		workTerms.setAssignmentCategory(neoGovdata.getAssignmentCategory());
		workTerms.setAssignmentName(neoGovdata.getPositionTitle());
		workTerms.setAssignmentNumber("ET" + neoGovdata.getEmployeenumber());
		workTerms.setAssignmentStatusTypeCode("ACTIVE_PROCESS");
		workTerms.setAssignmentType("ET");
		//workTerms.setBusinessUnitShortCode("City and County of Broomfield");
		workTerms.setBusinessUnitId(neoGovdata.getBusinessUnitId());
		workTerms.setDateStart(DateTimeUtils.getFormattedDate(neoGovdata.getStartDate(), dateFormat_yyyyMMdd_slash));
		workTerms.setEffectiveEndDate("4712/12/31");
		workTerms.setEffectiveLatestChange("Y");
		workTerms.setEffectiveSequence("1");
		workTerms.setEffectiveStartDate(
				DateTimeUtils.getFormattedDate(neoGovdata.getStartDate(), dateFormat_yyyyMMdd_slash));
		workTerms.setFullPartTime(neoGovdata.getPositionFullTimeFlag());
		workTerms.setHourlySalariedCode(neoGovdata.getHourlySalaried());
		workTerms.setLegalEmployerName("City and County of Broomfield");
		workTerms.setManagerFlag(neoGovdata.getManager());
		workTerms.setNormalHours(neoGovdata.getHours());
		workTerms.setPermanentTemporary(
				neoGovdata.getAssignmentType() != null && neoGovdata.getAssignmentType().equals("CCOB_TEMP") ? "T"
						: "R");
		workTerms.setPersonNumber(neoGovdata.getEmployeenumber());
		workTerms.setPersonTypeCode("Employee");
		workTerms.setPositionCode(neoGovdata.getPositionCode());
		workTerms.setPositionOverrideFlag("Y");
		workTerms.setPrimaryWorkTermsFlag("Y");
		workTerms.setProjectedEndDate(
				DateTimeUtils.getFormattedDate(neoGovdata.getProjectedEndDate(), dateFormat_yyyyMMdd_slash));
		workTerms.setReasonCode(neoGovdata.getAssignmentType());
		//taxReportingUnit has been moved from work terms to assignment on 19-08-2021
		//workTerms.setTaxReportingUnit("City and County of Broomfield");
		workTerms.setWorkerCategory(neoGovdata.getWorkerCategory() != null && !neoGovdata.getWorkerCategory().isEmpty()
				? neoGovdata.getWorkerCategory()
				: "E");
		workTerms.setWorkerType("E");
		return workTerms;
	}

	public static PersonEthnicity getPersonEthnicityObject(NeoGovData neoGovdata) {
		PersonEthnicity personEthnicity = new PersonEthnicity();
		personEthnicity.setSourceSystemOwner(sourceSystemOwner);
		personEthnicity.setSourceSystemId(neoGovdata.getEmployeenumber() + "-PECT-01");
		personEthnicity.setPersonId(neoGovdata.getEmployeenumber() + "-Worker-01");
		personEthnicity.setEthnicity(neoGovdata.getEthnicity());
		personEthnicity.setPersonNumber(neoGovdata.getEmployeenumber());
		return personEthnicity;
	}

	public static PersonPhone getPersonPhoneDefaultObject(NeoGovData neoGovdata) {
		PersonPhone personPhoneDefault = new PersonPhone();
		personPhoneDefault.setSourceSystemOwner(sourceSystemOwner);
		personPhoneDefault.setSourceSystemId(neoGovdata.getEmployeenumber() + "-WPHONE-01");
		personPhoneDefault.setPersonId(neoGovdata.getEmployeenumber() + "-Worker-01");
		personPhoneDefault.setAreaCode(neoGovdata.getPhoneAreaCode());
		personPhoneDefault.setPhoneType("W1");
		personPhoneDefault
				.setDateFrom(DateTimeUtils.getFormattedDate(neoGovdata.getStartDate(), dateFormat_yyyyMMdd_slash));
		personPhoneDefault.setPersonNumber(neoGovdata.getEmployeenumber());
		personPhoneDefault.setPhoneNumber(neoGovdata.getPhone());
		personPhoneDefault.setPrimaryFlag("Y");
		return personPhoneDefault;
	}

	public static PersonPhone getPersonPhonePersonalObject(NeoGovData neoGovdata) {
		PersonPhone personPhonePersonal = new PersonPhone();
		personPhonePersonal.setSourceSystemOwner(sourceSystemOwner);
		personPhonePersonal.setSourceSystemId(neoGovdata.getEmployeenumber() + "-HPHONE-01");
		personPhonePersonal.setPersonId(neoGovdata.getEmployeenumber() + "-Worker-01");
		personPhonePersonal.setAreaCode(neoGovdata.getPhonePersonalAreaCode());
		personPhonePersonal.setPhoneType("H1");
		personPhonePersonal
				.setDateFrom(DateTimeUtils.getFormattedDate(neoGovdata.getStartDate(), dateFormat_yyyyMMdd_slash));
		personPhonePersonal.setPersonNumber(neoGovdata.getEmployeenumber());
		personPhonePersonal.setPhoneNumber(neoGovdata.getPhonePersonal());
		personPhonePersonal.setPrimaryFlag("N");
		return personPhonePersonal;
	}

	public static PersonAddress getPersonAddressObject(NeoGovData neoGovdata) {
		PersonAddress personAddress = new PersonAddress();
		personAddress.setSourceSystemOwner(sourceSystemOwner);
		personAddress.setSourceSystemId(neoGovdata.getEmployeenumber() + "-PADD-01");
		personAddress.setAddressLine1(neoGovdata.getAddress1());
		personAddress.setAddressLine2(neoGovdata.getAddress2());
		personAddress.setAddressLine3(EMPTY);
		personAddress.setAddressType("HOME");
		personAddress.setEffectiveStartDate(
				DateTimeUtils.getFormattedDate(neoGovdata.getStartDate(), dateFormat_yyyyMMdd_slash));
		personAddress.setPersonNumber(neoGovdata.getEmployeenumber());
		personAddress.setPostalCode(neoGovdata.getPostalCode());
		personAddress.setPrimaryFlag("Y");
		personAddress.setRegion1(neoGovdata.getCounty());
		personAddress.setRegion2(neoGovdata.getState());
		personAddress.setRegion3(EMPTY);
		personAddress.setCountry("US");
		personAddress.setTownOrCity(neoGovdata.getCity());
		return personAddress;
	}

	public static PersonNationalIdentifier getPersonNationalIdentifierObject(NeoGovData neoGovdata) {
		PersonNationalIdentifier personNationalIdentifier = new PersonNationalIdentifier();
		personNationalIdentifier.setSourceSystemOwner(sourceSystemOwner);
		personNationalIdentifier.setSourceSystemId(neoGovdata.getEmployeenumber() + "-PNI-01");
		personNationalIdentifier.setPersonId(neoGovdata.getEmployeenumber() + "-Worker-01");
		personNationalIdentifier.setNationalIdentifierNumber(neoGovdata.getSsn());
		personNationalIdentifier.setPersonNumber(neoGovdata.getEmployeenumber());
		return personNationalIdentifier;
	}

	public static PersonLegistlativeData getPersonLegislativeObject(NeoGovData neoGovdata) {
		PersonLegistlativeData personLegistlativeData = new PersonLegistlativeData();
		personLegistlativeData.setSourceSystemOwner(sourceSystemOwner);
		personLegistlativeData.setSourceSystemId(neoGovdata.getEmployeenumber() + "-PLG-01");
		personLegistlativeData.setPersonId(neoGovdata.getEmployeenumber() + "-Worker-01");
		personLegistlativeData.setEffectiveStartDate(
				DateTimeUtils.getFormattedDate(neoGovdata.getStartDate(), dateFormat_yyyyMMdd_slash));
		personLegistlativeData.setHighestEducationLevel(neoGovdata.getHighestEducation());
		personLegistlativeData.setMaritalStatus(neoGovdata.getMaritalStatus());
		personLegistlativeData.setPersonNumber(neoGovdata.getEmployeenumber());
		personLegistlativeData.setSex(neoGovdata.getGender());
		personLegistlativeData.setVeteranSelfIdentification(neoGovdata.getVeteranSelfId());
		return personLegistlativeData;
	}

	public static PersonCitizenship getPersonCitizenshipObject(NeoGovData neoGovdata) {
		PersonCitizenship personCitizenship = new PersonCitizenship();
		personCitizenship.setSourceSystemOwner(sourceSystemOwner);
		personCitizenship.setSourceSystemId(neoGovdata.getEmployeenumber() + "-CSHIP-01");
		personCitizenship.setPersonId(neoGovdata.getEmployeenumber() + "-Worker-01");
		personCitizenship
				.setDateFrom(DateTimeUtils.getFormattedDate(neoGovdata.getStartDate(), dateFormat_yyyyMMdd_slash));
		personCitizenship.setPersonNumber(neoGovdata.getEmployeenumber());
		return personCitizenship;
	}

	public static PersonName getPersonNameObject(NeoGovData neoGovdata) {
		PersonName personName = new PersonName();
		personName.setSourceSystemOwner(sourceSystemOwner);
		personName.setSourceSystemId(neoGovdata.getEmployeenumber() + "-Name-01");
		personName.setPersonId(neoGovdata.getEmployeenumber() + "-Worker-01");
		personName.setEffectiveStartDate(
				DateTimeUtils.getFormattedDate(neoGovdata.getStartDate(), dateFormat_yyyyMMdd_slash));
		personName.setFirstName(neoGovdata.getFirstname());
		personName.setLastName(neoGovdata.getLastname());
		personName.setMiddleNames(neoGovdata.getMiddleInitial());
		personName.setSuffix(neoGovdata.getSuffix());
		personName.setPersonNumber(neoGovdata.getEmployeenumber());
		personName.setKnownAs(neoGovdata.getKnownAs());
		return personName;
	}

	public static PersonEmail getPersonEmailHomeObject(NeoGovData neoGovdata) {
		PersonEmail personEmailHome = new PersonEmail();
		personEmailHome.setSourceSystemOwner(sourceSystemOwner);
		personEmailHome.setSourceSystemId(neoGovdata.getEmployeenumber() + "-EHOME-01");
		personEmailHome.setPersonId(neoGovdata.getEmployeenumber() + "-Worker-01");
		personEmailHome
				.setDateFrom(DateTimeUtils.getFormattedDate(neoGovdata.getStartDate(), dateFormat_yyyyMMdd_slash));
		personEmailHome.setEmailAddress(neoGovdata.getEmailHome());
		personEmailHome.setPersonNumber(neoGovdata.getEmployeenumber());
		personEmailHome.setEmailType("H1");
		return personEmailHome;
	}

	public static PersonEmail getPersonEmailWorkObject(NeoGovData neoGovdata) {
		PersonEmail personEmailWork = new PersonEmail();
		personEmailWork.setSourceSystemOwner(sourceSystemOwner);
		personEmailWork.setSourceSystemId(neoGovdata.getEmployeenumber() + "-EWORK-01");
		personEmailWork.setPersonId(neoGovdata.getEmployeenumber() + "-Worker-01");
		personEmailWork
				.setDateFrom(DateTimeUtils.getFormattedDate(neoGovdata.getStartDate(), dateFormat_yyyyMMdd_slash));
		personEmailWork.setEmailAddress(neoGovdata.getEmail());
		personEmailWork.setPersonNumber(neoGovdata.getEmployeenumber());
		personEmailWork.setEmailType("W1");
		return personEmailWork;
	}

	public static WorkRelationship getWorkRelationshipObject(NeoGovData neoGovdata) {
		WorkRelationship workRelationShip = new WorkRelationship();
		workRelationShip.setSourceSystemOwner(sourceSystemOwner);
		workRelationShip.setSourceSystemId(neoGovdata.getEmployeenumber() + "-WRL-01");
		workRelationShip.setPersonId(neoGovdata.getEmployeenumber() + "-Worker-01");
		workRelationShip.setPersonNumber(neoGovdata.getEmployeenumber());
		workRelationShip.setMedicalInsuranceAvailabilityDate(
				DateTimeUtils.getFormattedDate(neoGovdata.getMedicalDate(), dateFormat_yyyyMMdd_slash));
		workRelationShip.setI9_STATUS(neoGovdata.getI9().contentEquals("V") ? "V" : EMPTY);
		workRelationShip.setReasonCode(neoGovdata.getAssignmentType());
		workRelationShip.setMedicalInsuranceAvailable(neoGovdata.getMedicalAvailable());
		workRelationShip.setLegalEmployerSeniorityDate(
				DateTimeUtils.getFormattedDate(neoGovdata.getSeniorityDate(), dateFormat_yyyyMMdd_slash));
		workRelationShip
				.setDateStart(DateTimeUtils.getFormattedDate(neoGovdata.getStartDate(), dateFormat_yyyyMMdd_slash));
		return workRelationShip;
	}

	public static Worker getWorkerObject(NeoGovData neoGovdata) {
		Worker worker = new Worker();
		worker.setSourceSystemOwner(sourceSystemOwner);
		worker.setSourceSystemId(neoGovdata.getEmployeenumber() + "-Worker-01");
		worker.setPersonNumber(neoGovdata.getEmployeenumber());
		worker.setEffectiveStartDate(
				DateTimeUtils.getFormattedDate(neoGovdata.getStartDate(), dateFormat_yyyyMMdd_slash));
		String dob = DateTimeUtils.getFormattedDate(neoGovdata.getBirthDate(), dateFormat_yyyyMMdd_slash);
		worker.setDateOfBirth(dob != null && !dob.isEmpty() ? dob : "");// "1980/01/01"
		worker.setReasonCode(neoGovdata.getAssignmentType());
		worker.setStartDate(DateTimeUtils.getFormattedDate(neoGovdata.getStartDate(), dateFormat_yyyyMMdd_slash));
		return worker;
	}

}
