package com.dataloader;

import static com.dataloader.NeoGovDataWorkerObjectMappers.getAssignedPayrollObject;
import static com.dataloader.NeoGovDataWorkerObjectMappers.getAssignmentObject;
import static com.dataloader.NeoGovDataWorkerObjectMappers.getAssignmentSupervisorObject;
import static com.dataloader.NeoGovDataWorkerObjectMappers.getAssignmentWorkMeasureFteObject;
import static com.dataloader.NeoGovDataWorkerObjectMappers.getAssignmentWorkMeasureHeadObject;
import static com.dataloader.NeoGovDataWorkerObjectMappers.getPayrollAssignment;
import static com.dataloader.NeoGovDataWorkerObjectMappers.getPersonAddressObject;
import static com.dataloader.NeoGovDataWorkerObjectMappers.getPersonCitizenshipObject;
import static com.dataloader.NeoGovDataWorkerObjectMappers.getPersonEmailHomeObject;
import static com.dataloader.NeoGovDataWorkerObjectMappers.getPersonEmailWorkObject;
import static com.dataloader.NeoGovDataWorkerObjectMappers.getPersonEthnicityObject;
import static com.dataloader.NeoGovDataWorkerObjectMappers.getPersonLegislativeObject;
import static com.dataloader.NeoGovDataWorkerObjectMappers.getPersonNameObject;
import static com.dataloader.NeoGovDataWorkerObjectMappers.getPersonNationalIdentifierObject;
import static com.dataloader.NeoGovDataWorkerObjectMappers.getPersonPhoneDefaultObject;
import static com.dataloader.NeoGovDataWorkerObjectMappers.getPersonPhonePersonalObject;
import static com.dataloader.NeoGovDataWorkerObjectMappers.getSalaryObject;
import static com.dataloader.NeoGovDataWorkerObjectMappers.getUserObject;
import static com.dataloader.NeoGovDataWorkerObjectMappers.getWorkRelationshipObject;
import static com.dataloader.NeoGovDataWorkerObjectMappers.getWorkerObject;
import static com.dataloader.NeoGovDataWorkerObjectMappers.getWorktermsObject;
import static com.dataloader.constants.ApplicationConstants.EMPTY;
import static com.dataloader.constants.ApplicationConstants.WORKER_DETAILS_ZIP;
import static com.dataloader.constants.ApplicationConstants.WORKER_ZIP;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.ws.BindingProvider;
import javax.xml.ws.WebServiceRef;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import com.dataloader.models.AssignedPayroll;
import com.dataloader.models.Assignment;
import com.dataloader.models.AssignmentSupervisor;
import com.dataloader.models.AssignmentWorkMeasure;
import com.dataloader.models.JobInfo;
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
import com.dataloader.utils.DatFileHelper;
import com.dataloader.utils.FileUtils;
import com.dataloader.utils.JsonUtil;
import com.oracle.xmlns.apps.hcm.common.dataloader.core.dataloaderintegrationservice.HCMDataLoader;
import com.oracle.xmlns.apps.hcm.common.dataloader.core.dataloaderintegrationservice.HCMDataLoader_Service;
import com.oracle.xmlns.apps.hcm.common.dataloader.core.dataloaderintegrationservice.ServiceException;

import weblogic.wsee.jws.jaxws.owsm.SecurityPolicyFeature;

public class HcmDataLoader {

	private static final Logger log = LogManager.getLogger(HcmDataLoader.class);

	@WebServiceRef
	private static HCMDataLoader_Service hcmDataLoaderService;

	private static HCMDataLoader hcmLoaderService;

	private static Properties prop = new Properties();

	public static void main(String[] args) {
		init();

		String folderPath = prop.getProperty("folder.path.archive.outputfiles");
		File inputFiles[] = FileUtils.getMatchedFileInDirectory(prop.getProperty("folder.path.inputs"),
				prop.getProperty("input.filename.pattern"));

		log.info("Matched files with file name pattern : " + prop.getProperty("input.filename.pattern"));

		if (inputFiles.length == 0) {
			log.info("There are no files with the provided filename pattern "
					+ prop.getProperty("input.filename.pattern") + " in folder path : "
					+ prop.getProperty("folder.path.inputs"));
		}
		for (File file : inputFiles) {
			ArrayList<JobInfo> jobInfos = new ArrayList<>();
			JobInfo jobInfo = new JobInfo();
			log.info("File Name : " + file.getName());
			try {
				log.info("Parsing json file and preparing data objects from it....");
				List<NeoGovData> dataObjects = JsonUtil.getNeoGovDataObjects(file.getAbsolutePath());
				String workerDatFile = prepareCandidateWorkerDatFile(dataObjects);
				File zipFile = FileUtils.zipMultpleFiles(Arrays.asList(workerDatFile), WORKER_ZIP);

				/**
				 * Processing Worker file
				 */
				jobInfo = processJob(zipFile, file, "Workers");
				log.info("Status of " + zipFile.getName() + " after processing : " + jobInfo);
				archiveZipFiles(zipFile, folderPath);

				HashMap<Boolean, ArrayList<NeoGovData>> dataObjectsLoadedStatusMap = prepareDataObjectsLoadedStatusMap(
						dataObjects);
				if (jobInfo.getJobStatus().equalsIgnoreCase("COMPLETED")) {
					jobInfos.add(jobInfo);

					if (dataObjectsLoadedStatusMap.containsKey(Boolean.TRUE)) {
						zipFile = prepareWorkerDetailsZipFile(dataObjectsLoadedStatusMap.get(Boolean.TRUE));
						/**
						 * Processing WorkerAddress, salary and payroll files together
						 */
						jobInfo = processJob(zipFile, file, "WorkerDetails");
						jobInfos.add(jobInfo);
						log.info("Status of " + zipFile.getName() + " after processing : " + jobInfo);
						archiveZipFiles(zipFile, folderPath);
					}
				}
				archiveJsonInputFiles(file, prop.getProperty("folder.path.archive.inputfiles"));
				sendErrorReport(dataObjectsLoadedStatusMap, file, jobInfos);
			} catch (Exception e) {
				log.error("Exception in main method : " + e.getMessage());
			}
		}

	}

	private static String prepareUsersDatFile(List<NeoGovData> dataObjects) {
		List<User> users = new ArrayList<>();

		for (NeoGovData neoGovdata : dataObjects) {

			User personAddress = getUserObject(neoGovdata);
			users.add(personAddress);

		}
		return DatFileHelper.createUserDatFile(users);
	}

	private static File prepareWorkerDetailsZipFile(List<NeoGovData> filteredDataObjects) {
		File zipFile;

		/**
		 * Preparing Worker Address file
		 */
		String addrDatFile = prepareCandidateAddressDatFile(filteredDataObjects);

		/**
		 * Preparing candidate salary file
		 */
		String salaryDatFile = prepareCandidateSalaryDatFile(filteredDataObjects);

		/**
		 * Preparing candidate payroll file
		 */
		String payrollDatFile = prepareCandidatePayrollDatFile(filteredDataObjects);

		/**
		 * Preparing Users dat file
		 */
		String usersDatFile = prepareUsersDatFile(filteredDataObjects);

		/**
		 * Preparing PayrollAssignmentDetails dat file
		 */
		String payrolAssignmentDatFile = preparePayrollAssignmentDatFile(filteredDataObjects);

		zipFile = FileUtils.zipMultpleFiles(
				Arrays.asList(addrDatFile, salaryDatFile, payrollDatFile, usersDatFile, payrolAssignmentDatFile),
				WORKER_DETAILS_ZIP);
		return zipFile;
	}

	/**
	 * This method filters the successfully loaded worker details
	 * 
	 * @param dataObjects
	 * @return
	 */
	private static HashMap<Boolean, ArrayList<NeoGovData>> prepareDataObjectsLoadedStatusMap(
			List<NeoGovData> dataObjects) {
		ProfileService profileService = new ProfileService();
		HashMap<Boolean, ArrayList<NeoGovData>> dataObjectsLoadedStatusMap = new HashMap<>();

		dataObjects.forEach(dataObject -> {
			String personNumber = dataObject.getEmployeenumber();
			boolean isLoadedSuccessfully = profileService.findWorkerProfile(personNumber, prop);
			if (dataObjectsLoadedStatusMap.containsKey(isLoadedSuccessfully)) {
				ArrayList<NeoGovData> list = dataObjectsLoadedStatusMap.get(isLoadedSuccessfully);
				list.add(dataObject);
				dataObjectsLoadedStatusMap.put(isLoadedSuccessfully, list);
			} else
				dataObjectsLoadedStatusMap.put(isLoadedSuccessfully, new ArrayList<>(Arrays.asList(dataObject)));
		});

		return dataObjectsLoadedStatusMap;
	}

	/**
	 * This method initializes the configuration file and also initializes the HCM
	 * loader service
	 */
	private static void init() {

		HcmDataLoader hcmDL = new HcmDataLoader();
		String configFile = "config.properties";

		InputStream inputStream = hcmDL.getClass().getClassLoader().getResourceAsStream(configFile);

		log.info("Initializing configuration file properties....");
		try {
			prop.load(inputStream);

			hcmDataLoaderService = new HCMDataLoader_Service(
					new URL(prop.getProperty("hcm.cloud.url") + "/hcmCommonDataLoader/HCMDataLoader?wsdl"));
			SecurityPolicyFeature[] securityFeatures = new SecurityPolicyFeature[] {
					new SecurityPolicyFeature("oracle/wss11_username_token_with_message_protection_client_policy") };
			hcmLoaderService = initializeHCMLoader(securityFeatures);

		} catch (IOException e) {
			log.error("Exception in init method - {}", e);
			e.printStackTrace();
		}
	}

	private static void archiveZipFiles(File zipFile, String folderPath) {
		zipFile.renameTo(new File(folderPath + zipFile.getName() + "-" + getCurrentTimeStamp() + ".zip"));

	}

	private static void archiveJsonInputFiles(File file, String folderPath) {
		file.renameTo(new File(folderPath + file.getName()));

	}

	/**
	 * This method uploads the file to content server, then import it and later
	 * sends the error reports based on the job status.
	 * 
	 * @param zipFile
	 * @param file
	 * @return
	 * @throws Exception
	 * @throws ServiceException
	 * @throws InterruptedException
	 * @throws ParserConfigurationException
	 * @throws SAXException
	 * @throws IOException
	 */
	private static JobInfo processJob(File zipFile, File file, String jobType) throws Exception, ServiceException,
			InterruptedException, ParserConfigurationException, SAXException, IOException {

		log.info("Uploading " + zipFile + " to content server....");
		String contentId = WebContentUpload.uploadContent(zipFile.getAbsolutePath(),
				prop.getProperty("hcm.cloud.url") + "/cs/idcplg", prop.getProperty("hcm.cloud.username"),
				prop.getProperty("hcm.cloud.password"), zipFile);
		log.info("Content Id:" + contentId);

		log.info("Invoking importAndLoadData webservice to load and process " + zipFile + " file....");
		String processId = hcmLoaderService.importAndLoadData(contentId, EMPTY);
		log.info("Response of importAndLoadData webservice, ProcessId : " + processId);

		String status = getJobStatus(processId);

		JobInfo jobinfo = new JobInfo();
		jobinfo.setContentId(contentId);
		jobinfo.setJobStatus(status);
		jobinfo.setJobType(jobType);

		return jobinfo;

	}

	/**
	 * This method reads the flags from properties file wheter to send or not the
	 * error reports and send s based on that.
	 * 
	 * @param zipFile
	 * @param dataObjectsLoadedStatusMap
	 * @param jobInfo
	 * @param inputFile
	 * @param inputFile
	 * @param reportService
	 * @param contentId
	 * @throws IOException
	 */
	private static void sendErrorReport(HashMap<Boolean, ArrayList<NeoGovData>> dataObjectsLoadedStatusMap,
			File inputFile, List<JobInfo> jobInfos) throws IOException {
		ReportService reportService = new ReportService();
		reportService.scheduleReport(prop, dataObjectsLoadedStatusMap, inputFile, jobInfos);
	}

	/**
	 * This method fetches the job status using processId for every specified time
	 * interval.
	 * 
	 * @param processId
	 * @return
	 * @throws InterruptedException
	 * @throws ParserConfigurationException
	 * @throws SAXException
	 * @throws IOException
	 * @throws ServiceException
	 */
	private static String getJobStatus(String processId)
			throws InterruptedException, ParserConfigurationException, SAXException, IOException, ServiceException {
		String status = EMPTY;
		boolean jobStatus = false;
		String timeIntervalStr = prop.getProperty("time.interval", "10000");
		long timeInterval = Long
				.parseLong(timeIntervalStr != null && !timeIntervalStr.isEmpty() ? timeIntervalStr : "10000");

		while (!jobStatus) {
			log.info("Waiting for " + (timeInterval / 1000) + " secs, to fetch the status again... ");
			TimeUnit.MILLISECONDS.sleep(timeInterval);
			status = invokeGetDataSetStatus(hcmLoaderService, processId, timeInterval);
			if ("COMPLETED".equalsIgnoreCase(status) || "ERROR".equalsIgnoreCase(status))
				jobStatus = true;
			log.info("HcmDataLoad job success status : " + jobStatus);
		}
		return status;
	}

	/**
	 * This method prepares the Salary dat file.
	 * 
	 * @param dataObjects
	 * @return
	 */
	private static String prepareCandidateSalaryDatFile(List<NeoGovData> dataObjects) {

		List<Salary> salaries = new ArrayList<>();

		for (NeoGovData neoGovData : dataObjects) {

			Salary salary = getSalaryObject(neoGovData);
			salaries.add(salary);

		}
		return DatFileHelper.createSalaryDatFile(salaries);
	}

	/**
	 * This method prepares the payroll assignment dat file
	 * @param dataObjects
	 * @return
	 */
	private static String preparePayrollAssignmentDatFile(List<NeoGovData> dataObjects) {

		List<PayrollAssignment> payrollAssignments = new ArrayList<>();

		for (NeoGovData neoGovData : dataObjects) {

			PayrollAssignment payrollAssignment = getPayrollAssignment(neoGovData);
			payrollAssignments.add(payrollAssignment);

		}
		return DatFileHelper.createPayrollAssignmentDatFile(payrollAssignments);
	}

	/**
	 * This method prepares the address dat file.
	 * 
	 * @param dataObjects
	 * @return
	 */
	private static String prepareCandidateAddressDatFile(List<NeoGovData> dataObjects) {

		List<PersonAddress> personAddresses = new ArrayList<>();

		for (NeoGovData neoGovdata : dataObjects) {

			PersonAddress personAddress = getPersonAddressObject(neoGovdata);
			personAddresses.add(personAddress);

		}
		return DatFileHelper.createAddressDatFile(personAddresses);
	}

	/**
	 * This method prepares the payroll dat file.
	 * 
	 * @param dataObjects
	 * @return
	 */
	private static String prepareCandidatePayrollDatFile(List<NeoGovData> dataObjects) {

		List<AssignedPayroll> payrolls = new ArrayList<>();

		for (NeoGovData neoGovData : dataObjects) {

			AssignedPayroll payroll = getAssignedPayrollObject(neoGovData);
			payrolls.add(payroll);

		}
		return DatFileHelper.createPayrollDatFile(payrolls);
	}

	/**
	 * This method prepares the worker dat file.
	 * 
	 * @param dataObjects
	 * @return
	 */
	private static String prepareCandidateWorkerDatFile(List<NeoGovData> dataObjects) {

		List<Worker> workers = new ArrayList<>();
		List<WorkRelationship> workRelationships = new ArrayList<>();
		List<PersonEmail> personEmailWorks = new ArrayList<>();
		List<PersonEmail> personEmailHomes = new ArrayList<>();
		List<PersonName> personNames = new ArrayList<>();
		List<PersonCitizenship> personCitizenships = new ArrayList<>();
		List<PersonLegistlativeData> personLegistlativeDatas = new ArrayList<>();
		List<PersonNationalIdentifier> personNationalIdentifiers = new ArrayList<>();
		List<PersonPhone> personPhonePersonals = new ArrayList<>();
		List<PersonPhone> personPhoneDefaults = new ArrayList<>();
		List<PersonEthnicity> personEthnicitys = new ArrayList<>();
		List<Assignment> assignments = new ArrayList<>();
		List<WorkTerms> workTermss = new ArrayList<>();
		List<AssignmentSupervisor> assignmentSupervisors = new ArrayList<>();
		List<AssignmentWorkMeasure> assignmentWorkMeasureFtes = new ArrayList<>();
		List<AssignmentWorkMeasure> assignmentWorkMeasureHeads = new ArrayList<>();

		for (NeoGovData neoGovdata : dataObjects) {

			Worker worker = getWorkerObject(neoGovdata);
			workers.add(worker);

			WorkRelationship workRelationShip = getWorkRelationshipObject(neoGovdata);
			workRelationships.add(workRelationShip);

			if (neoGovdata.getEmail() != null && !neoGovdata.getEmail().isEmpty()) {
				PersonEmail personEmailWork = getPersonEmailWorkObject(neoGovdata);
				personEmailWork.setPrimaryFlag("Y");
				personEmailWorks.add(personEmailWork);

			}

			if (neoGovdata.getEmail() != null && !neoGovdata.getEmail().isEmpty()) {
				PersonEmail personEmailHome = getPersonEmailHomeObject(neoGovdata);
				personEmailHome.setPrimaryFlag("N");
				personEmailHomes.add(personEmailHome);
			}

			PersonName personName = getPersonNameObject(neoGovdata);
			personNames.add(personName);

			PersonCitizenship personCitizenship = getPersonCitizenshipObject(neoGovdata);
			personCitizenships.add(personCitizenship);

			PersonLegistlativeData personLegistlativeData = getPersonLegislativeObject(neoGovdata);
			personLegistlativeDatas.add(personLegistlativeData);

			PersonNationalIdentifier personNationalIdentifier = getPersonNationalIdentifierObject(neoGovdata);
			personNationalIdentifiers.add(personNationalIdentifier);

			if (neoGovdata.getPhonePersonal() != null && !neoGovdata.getPhonePersonal().isEmpty()) {
				PersonPhone personPhonePersonal = getPersonPhonePersonalObject(neoGovdata);
				personPhonePersonals.add(personPhonePersonal);
			}

			PersonPhone personPhoneDefault = getPersonPhoneDefaultObject(neoGovdata);
			personPhoneDefaults.add(personPhoneDefault);

			PersonEthnicity personEthnicity = getPersonEthnicityObject(neoGovdata);
			personEthnicitys.add(personEthnicity);

			WorkTerms workTerms = getWorktermsObject(neoGovdata);
			workTermss.add(workTerms);

			Assignment assignment = getAssignmentObject(neoGovdata);
			assignments.add(assignment);

			if (neoGovdata.getManagerId() != null && !neoGovdata.getManagerId().isEmpty()) {
				AssignmentSupervisor assignmentSupervisor = getAssignmentSupervisorObject(neoGovdata);
				assignmentSupervisors.add(assignmentSupervisor);
			}

			AssignmentWorkMeasure assignmentWorkMeasureFte = getAssignmentWorkMeasureFteObject(neoGovdata);
			assignmentWorkMeasureFtes.add(assignmentWorkMeasureFte);

			AssignmentWorkMeasure assignmentWorkMeasureHead = getAssignmentWorkMeasureHeadObject(neoGovdata);
			assignmentWorkMeasureHeads.add(assignmentWorkMeasureHead);

		}

		String datFile = DatFileHelper.createWorkerDatFile(workers, workRelationships, personEmailWorks,
				personEmailHomes, personNames, personCitizenships, personLegistlativeDatas, personNationalIdentifiers,
				personPhonePersonals, personPhoneDefaults, personEthnicitys, assignments, workTermss,
				assignmentSupervisors, assignmentWorkMeasureFtes, assignmentWorkMeasureHeads);

		return datFile;
	}

	private static String getCurrentTimeStamp() {
		Calendar calendar = Calendar.getInstance();
		java.util.Date now = calendar.getTime();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		String formattedDate = sdf.format(now);
		return formattedDate;
	}

	private static HCMDataLoader initializeHCMLoader(SecurityPolicyFeature[] securityFeatures) {
		HCMDataLoader hcmLoaderService = hcmDataLoaderService.getHCMDataLoaderSoapHttpPort(securityFeatures);
		BindingProvider wsbp = (BindingProvider) hcmLoaderService;
		Map<String, Object> requestContext = wsbp.getRequestContext();
		requestContext.put(BindingProvider.USERNAME_PROPERTY, prop.getProperty("hcm.cloud.username"));
		requestContext.put(BindingProvider.PASSWORD_PROPERTY, prop.getProperty("hcm.cloud.password"));
		return hcmLoaderService;
	}

	/**
	 * This method invokes getDataSetStatus webserivice and sends response.
	 * 
	 * @param hcmLoaderService
	 * @param processId
	 * @param timeInterval
	 * @return
	 * @throws ParserConfigurationException
	 * @throws SAXException
	 * @throws IOException
	 * @throws ServiceException
	 */
	public static String invokeGetDataSetStatus(HCMDataLoader hcmLoaderService, String processId, long timeInterval)
			throws ParserConfigurationException, SAXException, IOException, ServiceException {

		String response = hcmLoaderService.getDataSetStatus("ProcessId=" + processId);
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		org.w3c.dom.Document document = builder.parse(new InputSource(new StringReader(response)));
		NodeList flowList = document.getElementsByTagName("DATA_SET_STATUS");
		NodeList childList;

		for (int i = 0; i < flowList.getLength(); i++) {

			childList = flowList.item(i).getChildNodes();
			for (int j = 0; j < childList.getLength(); j++) {

				Node childNode = childList.item(j);
				if ("DATA_SET".equals(childNode.getNodeName())) {
					NodeList dataSeteChildNodes = childNode.getChildNodes();
					{
						for (int k = 0; k < dataSeteChildNodes.getLength(); k++) {

							{
								Node childDSNode = dataSeteChildNodes.item(k);
								if ("STATUS".equals(childDSNode.getNodeName())) {
									String status = dataSeteChildNodes.item(k).getTextContent().trim();
									log.info("Current Status of the Data Set ***" + status + "***");

									if ("COMPLETED".equalsIgnoreCase(status) || "ERROR".equalsIgnoreCase(status)) {
										return status;
									}
								}
							}
						}
					}
				}
			}
		}

		return EMPTY;
	}

}
