package com.dataloader.utils;

import static com.dataloader.constants.ApplicationConstants.NEW_LINE;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.dataloader.models.AssignedPayroll;
import com.dataloader.models.Assignment;
import com.dataloader.models.AssignmentSupervisor;
import com.dataloader.models.AssignmentWorkMeasure;
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

public class DatFileHelper {

	private static final Logger log = LogManager.getLogger(DatFileHelper.class);

	private static final String WORKER_DAT = "Worker.dat";
	private static final String SALARY_DAT = "Salary.dat";
	private static final String PAYROLL_DAT = "AssignedPayroll.dat";
	private static final String USER_DAT = "User.dat";
	private static final String PAYROLL_ASSIGNMENT_DAT = "PayrollAssignmentDetails.dat";
	private static final String WORKER_ZIP = "Worker.zip";
	private static final String WORKER_DETAILS_ZIP = "Workerdetails.zip";

	private static final String purgeOption = "SET PURGE_FUTURE_CHANGES N\n";

	private static final String workerMetadata = "METADATA|Worker|SourceSystemOwner|SourceSystemId|PersonNumber|EffectiveStartDate|StartDate|EffectiveEndDate|DateOfBirth|CategoryCode|ActionCode|ReasonCode"
			+ "\n";

	private static final String workRelationshipMetadata = "METADATA|WorkRelationship|SourceSystemOwner|SourceSystemId|PersonId(SourceSystemId)|PersonNumber|LegalEmployerName|DateStart|WorkerType|ActualTerminationDate|EnterpriseSeniorityDate|LegalEmployerSeniorityDate|PrimaryFlag|ActionCode|ReasonCode|FLEX:PER_PPS_LEG_DDF|_I9_STATUS(PER_PPS_LEG_DDF=US)|medicalInsuranceAvailable(PER_PPS_LEG_DDF=US)|medicalInsuranceAvailabilityDa(PER_PPS_LEG_DDF=US)|_NEW_HIRE_STATUS(PER_PPS_LEG_DDF=US)"
			+ "\n";

	private static final String personEmailMetadata = "METADATA|PersonEmail|SourceSystemOwner|SourceSystemId|PersonId(SourceSystemId)|PersonNumber|DateFrom|DateTo|EmailType|EmailAddress|PrimaryFlag"
			+ "\n";

	private static final String personNameMetadata = "METADATA|PersonName|SourceSystemOwner|SourceSystemId|PersonId(SourceSystemId)|PersonNumber|EffectiveStartDate|EffectiveEndDate|LegislationCode|NameType|LastName|FirstName|MiddleNames|KnownAs|Suffix"
			+ "\n";

	private static final String personCitizenshipDMetadata = "METADATA|PersonCitizenship|SourceSystemOwner|SourceSystemId|PersonId(SourceSystemId)|PersonNumber|DateFrom|DateTo|LegislationCode|CitizenshipStatus"
			+ "\n";

	private static final String personLegislativeDataMetadata = "METADATA|PersonLegislativeData|SourceSystemOwner|SourceSystemId|PersonId(SourceSystemId)|PersonNumber|EffectiveStartDate|EffectiveEndDate|LegislationCode|Sex|MaritalStatus|HighestEducationLevel|VeteranSelfIdentification(PER_PERSON_LEGISLATIVE_DATA_LEG_DDF=US)|FLEX:PER_PERSON_LEGISLATIVE_DATA_LEG_DDF"
			+ "\n";

	private static final String personAddressMetadata = "METADATA|PersonAddress|SourceSystemOwner|SourceSystemId|EffectiveStartDate|EffectiveEndDate|PersonNumber|AddressType|AddressLine1|AddressLine2|AddressLine3|Region1|Region2|Region3|TownOrCity|PostalCode|Country|PrimaryFlag"
			+ "\n";

	private static final String personPhoneMetadata = "METADATA|PersonPhone|SourceSystemOwner|SourceSystemId|PersonId(SourceSystemId)|PersonNumber|DateFrom|LegislationCode|PhoneType|CountryCodeNumber|AreaCode|PhoneNumber|PrimaryFlag"
			+ "\n";

	private static final String personEthnicityMetadata = "METADATA|PersonEthnicity|SourceSystemOwner|SourceSystemId|PersonId(SourceSystemId)|PersonNumber|LegislationCode|Ethnicity|PrimaryFlag"
			+ "\n";

	private static final String personNationalIdentifierMetadata = "METADATA|PersonNationalIdentifier|SourceSystemOwner|SourceSystemId|PersonId(SourceSystemId)|PersonNumber|LegislationCode|NationalIdentifierType|NationalIdentifierNumber|PrimaryFlag"
			+ "\n";
	
	//taxReportingUnit has been moved from work terms to assignment on 19-08-2021
	private static final String workTermsMetadata = "METADATA|WorkTerms|SourceSystemOwner|SourceSystemId|PersonId(SourceSystemId)|PeriodOfServiceId(SourceSystemId)|PersonNumber|LegalEmployerName|DateStart|EffectiveStartDate|EffectiveSequence|EffectiveEndDate|ActionCode|ReasonCode|AssignmentNumber|AssignmentName|AssignmentType|WorkerType|PrimaryWorkTermsFlag|EffectiveLatestChange|AssignmentStatusTypeCode|PersonTypeCode|BusinessUnitId|PositionCode|PositionOverrideFlag|WorkerCategory|AssignmentCategory|PermanentTemporary|FullPartTime|ManagerFlag|HourlySalariedCode|NormalHours|ProjectedEndDate"
			+ "\n";

	private static final String assignmentWorkMeasureMetada = "METADATA|AssignmentWorkMeasure|SourceSystemOwner|SourceSystemId|AssignmentNumber|EffectiveStartDate|EffectiveEndDate|Unit|Value|ActionCode|ReasonCode"
			+ "\n";

	private static final String assignmentSupervisorMetadata = "METADATA|AssignmentSupervisor|SourceSystemOwner|SourceSystemId|PersonId(SourceSystemId)|EffectiveStartDate|EffectiveEndDate|ManagerType|ManagerPersonNumber|PrimaryFlag|AssignmentNumber|ReplaceFirstEffectiveStartDate"
			+ "\n";
	
	//Added taxReportingUnit from work terms to assignment on 19-08-2021
	private static final String assignmentMetadata = "METADATA|Assignment|SourceSystemOwner|SourceSystemId|PersonId(SourceSystemId)|PeriodOfServiceId(SourceSystemId)|WorkTermsAssignmentId(SourceSystemId)|PersonNumber|LegalEmployerName|DateStart|EffectiveStartDate|EffectiveSequence|EffectiveEndDate|ActionCode|ReasonCode|AssignmentNumber|AssignmentName|WorkTermsNumber|AssignmentType|WorkerType|PrimaryAssignmentFlag|PrimaryFlag|EffectiveLatestChange|AssignmentStatusTypeCode|PersonTypeCode|BusinessUnitId|PositionCode|PositionOverrideFlag|WorkerCategory|AssignmentCategory|PermanentTemporary|FullPartTime|ManagerFlag|HourlySalariedCode|NormalHours|ProjectedEndDate|Frequency|PeopleGroup|FLEX:PER_ASG_LEG_DDF|ACAFullTime(PER_ASG_LEG_DDF=US)|TaxReportingUnit|GradeId"
			+ "\n";

	private static final String salaryMetadata = "METADATA|Salary|SourceSystemOwner|SourceSystemId|AssignmentNumber|DateFrom|SalaryAmount|SalaryBasisName|ActionCode|ActionReasonCode|SalaryApproved|NextSalReviewDate|MultipleComponents"
			+ "\n";

	private static final String payrollMetadata = "METADATA|AssignedPayroll|SourceSystemOwner|SourceSystemId|EffectiveStartDate|AssignmentNumber|PayrollId|LegislativeDataGroupName|StartDate|TimecardRequiredFlag|EffectiveEndDate"
			+ "\n";

	private static final String userMetadata = "METADATA|User|PersonNumber|Username|GenerateUserAccount\n";

	private static final String payrollAssignmentMetadata = "METADATA|PayrollAssignmentDetails|EffectiveStartDate|TimecardRequiredFlag|AssignmentNumber|OvertimePeriodCode|LegislativeDataGroupName"
			+ "\n";

	public static String createAddressDatFile(List<PersonAddress> personAddresses) {

		try (BufferedWriter writer = new BufferedWriter(new FileWriter(WORKER_DAT))) {

			writer.write(purgeOption);
			writer.write(NEW_LINE);

			writer.write(personAddressMetadata);
			for (PersonAddress address : personAddresses) {
				writer.write(address.toString());
				writer.write(NEW_LINE);
			}
			writer.write(NEW_LINE);
		} catch (IOException e) {
			log.info("Exception while writing to a Worker.dat file");
			e.printStackTrace();
		}
		return WORKER_DAT;

	}

	public static String createSalaryDatFile(List<Salary> salaries) {

		try (BufferedWriter writer = new BufferedWriter(new FileWriter(SALARY_DAT))) {

			writer.write(purgeOption);
			writer.write(NEW_LINE);

			writer.write(salaryMetadata);
			for (Salary salary : salaries) {
				writer.write(salary.toString());
				writer.write(NEW_LINE);
			}
			writer.write(NEW_LINE);
		} catch (IOException e) {
			log.info("Exception while writing to a Salary.dat file");
			e.printStackTrace();
		}
		return SALARY_DAT;

	}

	public static String createPayrollDatFile(List<AssignedPayroll> payrolls) {

		try (BufferedWriter writer = new BufferedWriter(new FileWriter(PAYROLL_DAT))) {

			writer.write(purgeOption);
			writer.write(NEW_LINE);

			writer.write(payrollMetadata);
			for (AssignedPayroll payroll : payrolls) {
				writer.write(payroll.toString());
				writer.write(NEW_LINE);
			}
			writer.write(NEW_LINE);
		} catch (IOException e) {
			log.info("Exception while writing to a AssignedPayroll.dat file");
			e.printStackTrace();
		}
		return PAYROLL_DAT;

	}

	public static String createWorkerDatFile(List<Worker> workers, List<WorkRelationship> workRelationships,
			List<PersonEmail> personEmailWorks, List<PersonEmail> personEmailHomes, List<PersonName> personNames,
			List<PersonCitizenship> personCitizenships, List<PersonLegistlativeData> personLegistlativeDatas,
			List<PersonNationalIdentifier> personNationalIdentifiers, List<PersonPhone> personPhonePersonals,
			List<PersonPhone> personPhoneDefaults, List<PersonEthnicity> personEthnicitys, List<Assignment> assignments,
			List<WorkTerms> workTermss, List<AssignmentSupervisor> assignmentSupervisors,
			List<AssignmentWorkMeasure> assignmentWorkMeasureFtes,
			List<AssignmentWorkMeasure> assignmentWorkMeasureHeads) {

		try (BufferedWriter writer = new BufferedWriter(new FileWriter(WORKER_DAT))) {

			// write purge option
			writer.write(purgeOption);
			writer.write(NEW_LINE);

			// write Worker metadata
			writer.write(workerMetadata);
			for (Worker worker : workers) {
				writer.write(worker.toString());
				writer.write(NEW_LINE);
			}
			writer.write(NEW_LINE);

			writer.write(workRelationshipMetadata);
			for (WorkRelationship workRelationship : workRelationships) {
				writer.write(workRelationship.toString());
				writer.write(NEW_LINE);
			}
			writer.write(NEW_LINE);

			writer.write(personEmailMetadata);
			for (PersonEmail personEmailWork : personEmailWorks) {
				writer.write(personEmailWork.toString());
				writer.write(NEW_LINE);
			}

			for (PersonEmail personEmailHome : personEmailHomes) {
				writer.write(personEmailHome.toString());
				writer.write(NEW_LINE);
			}
			writer.write(NEW_LINE);

			writer.write(personNameMetadata);
			for (PersonName personName : personNames) {
				writer.write(personName.toString());
				writer.write(NEW_LINE);
			}
			writer.write(NEW_LINE);

			writer.write(personCitizenshipDMetadata);
			for (PersonCitizenship personCitizenship : personCitizenships) {
				writer.write(personCitizenship.toString());
				writer.write(NEW_LINE);
			}
			writer.write(NEW_LINE);

			writer.write(personLegislativeDataMetadata);
			for (PersonLegistlativeData personLegistlativeData : personLegistlativeDatas) {
				writer.write(personLegistlativeData.toString());
				writer.write(NEW_LINE);
			}
			writer.write(NEW_LINE);

			writer.write(personNationalIdentifierMetadata);
			for (PersonNationalIdentifier personNationalIdentifier : personNationalIdentifiers) {
				writer.write(personNationalIdentifier.toString());
				writer.write(NEW_LINE);
			}
			writer.write(NEW_LINE);

			writer.write(personPhoneMetadata);
			for (PersonPhone personPhonePersonal : personPhonePersonals) {
				writer.write(personPhonePersonal.toString());
				writer.write(NEW_LINE);
			}
			for (PersonPhone personPhoneDefault : personPhoneDefaults) {
				writer.write(personPhoneDefault.toString());
				writer.write(NEW_LINE);
			}
			writer.write(NEW_LINE);

			writer.write(personEthnicityMetadata);
			for (PersonEthnicity personEthnicity : personEthnicitys) {
				writer.write(personEthnicity.toString());
				writer.write(NEW_LINE);
			}
			writer.write(NEW_LINE);

			writer.write(assignmentMetadata);
			for (Assignment assignment : assignments) {
				writer.write(assignment.toString());
				writer.write(NEW_LINE);
			}
			writer.write(NEW_LINE);

			writer.write(workTermsMetadata);
			for (WorkTerms workTerms : workTermss) {
				writer.write(workTerms.toString());
				writer.write(NEW_LINE);
			}
			writer.write(NEW_LINE);

			writer.write(assignmentSupervisorMetadata);
			for (AssignmentSupervisor assignmentSupervisor : assignmentSupervisors) {
				writer.write(assignmentSupervisor.toString());
				writer.write(NEW_LINE);
			}
			writer.write(NEW_LINE);

			writer.write(assignmentWorkMeasureMetada);
			for (AssignmentWorkMeasure assignmentWorkMeasureFte : assignmentWorkMeasureFtes) {
				writer.write(assignmentWorkMeasureFte.toString());
				writer.write(NEW_LINE);
			}
			for (AssignmentWorkMeasure assignmentWorkMeasureHead : assignmentWorkMeasureHeads) {
				writer.write(assignmentWorkMeasureHead.toString());
				writer.write(NEW_LINE);
			}
			writer.write(NEW_LINE);

		} catch (IOException e) {
			log.info("Exception while writing to a worker.dat file");
			e.printStackTrace();
		}

		return WORKER_DAT;
	}

	public static String createUserDatFile(List<User> users) {
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(USER_DAT))) {

			writer.write(purgeOption);
			writer.write(NEW_LINE);

			writer.write(userMetadata);
			for (User user : users) {
				writer.write(user.toString());
				writer.write(NEW_LINE);
			}
			writer.write(NEW_LINE);
		} catch (IOException e) {
			log.info("Exception while writing to a User.dat file");
			e.printStackTrace();
		}
		return USER_DAT;
	}

	public static String createPayrollAssignmentDatFile(List<PayrollAssignment> payrollAssignments) {
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(PAYROLL_ASSIGNMENT_DAT))) {

			writer.write(purgeOption);
			writer.write(NEW_LINE);

			writer.write(payrollAssignmentMetadata);
			for (PayrollAssignment payrollAssignment : payrollAssignments) {
				writer.write(payrollAssignment.toString());
				writer.write(NEW_LINE);
			}
			writer.write(NEW_LINE);
		} catch (IOException e) {
			log.info("Exception while writing to a " + PAYROLL_ASSIGNMENT_DAT + " file");
			e.printStackTrace();
		}
		return PAYROLL_ASSIGNMENT_DAT;
	}

}
