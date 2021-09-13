package com.dataloader;

import static com.dataloader.constants.ApplicationConstants.EMPTY;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import javax.xml.namespace.QName;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.dataloader.models.JobInfo;
import com.dataloader.models.NeoGovData;
import com.dataloader.models.ReportSummary;
import com.dataloader.utils.ReadXml;
import com.oracle.xmlns.oxp.service.v2.AccessDeniedException_Exception;
import com.oracle.xmlns.oxp.service.v2.ArrayOfEMailDeliveryOption;
import com.oracle.xmlns.oxp.service.v2.ArrayOfParamNameValue;
import com.oracle.xmlns.oxp.service.v2.ArrayOfString;
import com.oracle.xmlns.oxp.service.v2.DeliveryChannels;
import com.oracle.xmlns.oxp.service.v2.EMailDeliveryOption;
import com.oracle.xmlns.oxp.service.v2.InvalidParametersException_Exception;
import com.oracle.xmlns.oxp.service.v2.ObjectFactory;
import com.oracle.xmlns.oxp.service.v2.OperationFailedException_Exception;
import com.oracle.xmlns.oxp.service.v2.ParamNameValue;
import com.oracle.xmlns.oxp.service.v2.ParamNameValues;
import com.oracle.xmlns.oxp.service.v2.ReportRequest;
import com.oracle.xmlns.oxp.service.v2.ReportResponse;
import com.oracle.xmlns.oxp.service.v2.ReportService_Service;
import com.oracle.xmlns.oxp.service.v2.ScheduleRequest;
import com.oracle.xmlns.oxp.service.v2.ScheduleService;
import com.oracle.xmlns.oxp.service.v2.ScheduleService_Service;

public class ReportService {

	private static final Logger log = LogManager.getLogger(ReportService.class);

	/**
	 * This method sends the error reports.
	 * 
	 * @param prop
	 * 
	 * @param contentId
	 * @param prop
	 * @param zipFile
	 * @param dataObjectsLoadedStatusMap
	 * @param file
	 * @param jobInfos
	 * @throws IOException
	 */
	public void scheduleReport(Properties prop, HashMap<Boolean, ArrayList<NeoGovData>> dataObjectsLoadedStatusMap,
			File file, List<JobInfo> jobInfos) throws IOException {

		log.info("In scheduleReport function ");
		QName qName = new QName("http://xmlns.oracle.com/oxp/service/v2", "ScheduleService");
		ScheduleService_Service scheduleServiceClient = null;
		ObjectFactory of = new ObjectFactory();
		ScheduleRequest scheduleRequest = of.createScheduleRequest();
		ReportRequest reporeq = of.createReportRequest();
		try {

			scheduleServiceClient = new ScheduleService_Service(
					new URL(prop.getProperty("hcm.cloud.url") + "/xmlpserver/services/v2/ScheduleService?WSDL"), qName);
			ScheduleService scheduleService = scheduleServiceClient.getScheduleService();
			log.info("Error report path : " + prop.getProperty("hcm.cloud.report.path"));
			reporeq.setReportAbsolutePath(prop.getProperty("hcm.cloud.report.path"));
			reporeq.setReportRawData("");
			reporeq.setSizeOfDataChunkDownload(-1);
			reporeq.setFlattenXML(true);
			reporeq.setByPassCache(true);
			reporeq.setAttributeTemplate(prop.getProperty("hcm.cloud.report.template"));
			reporeq.setAttributeFormat("pdf");
			reporeq.setAttributeLocale("en-US");

			ArrayList<ParamNameValue> list = new ArrayList<ParamNameValue>();
			ArrayOfString arrayOfString = new ArrayOfString();
			arrayOfString.getItem().add(jobInfos.get(0).getContentId());

			String nameParam = new String("P_CONTENTID");
			boolean multiValueParam = false;
			ParamNameValue paramNameValue = new ParamNameValue();
			paramNameValue.setName(nameParam);
			paramNameValue.setValues(arrayOfString);
			paramNameValue.setMultiValuesAllowed(multiValueParam);
			list.add(paramNameValue);
			
			if (jobInfos.size() > 1) {
				arrayOfString.getItem().add(jobInfos.get(1).getContentId());
				String nameParam1 = new String("P_CONTENTID1");
				boolean multiValueParam1 = false;
				ParamNameValue paramNameValue1 = new ParamNameValue();
				paramNameValue1.setName(nameParam1);
				paramNameValue1.setValues(arrayOfString);
				paramNameValue1.setMultiValuesAllowed(multiValueParam1);
				list.add(paramNameValue1);
			}

			ArrayOfParamNameValue arrayOfParamNameValue = new ArrayOfParamNameValue();
			arrayOfParamNameValue.getItem().addAll(list);
//			ArrayOfParamNameValue arrayOfParamNameValue = new ArrayOfParamNameValue();
//			ParamNameValue paramNameValue1 = constructParamNameValueObject(jobInfos.get(0).getContentId(),
//					"P_CONTENTID");
//			arrayOfParamNameValue.getItem().add(paramNameValue1);
//			if (jobInfos.size() > 1)
//				arrayOfParamNameValue.getItem()
//						.add(constructParamNameValueObject(jobInfos.get(1).getContentId(), "P_CONTENTID1"));
			ParamNameValues paramNameValuesList = new ParamNameValues();
			paramNameValuesList.setListOfParamNameValues(arrayOfParamNameValue);

			reporeq.setParameterNameValues(paramNameValuesList);
			scheduleRequest.setReportRequest(reporeq);
			scheduleRequest.setUserJobName("NEWHIRE INTEGRATION");
			scheduleRequest.setStartDate(new Date().toString());
			scheduleRequest.setNotifyWhenFailed(true);
			scheduleRequest.setNotifyWhenSuccess(false);
			scheduleRequest.setNotifyWhenSkipped(true);
			scheduleRequest.setSaveDataOption(true);
			scheduleRequest.setSaveOutputOption(true);

			DeliveryChannels deliveryChannels = new DeliveryChannels();
			EMailDeliveryOption eMailDeliveryOption = new EMailDeliveryOption();
			eMailDeliveryOption.setEmailFrom(prop.getProperty("hcm.cloud.email.from"));
			eMailDeliveryOption.setEmailTo(prop.getProperty("hcm.cloud.email.to"));
			eMailDeliveryOption.setEmailReplyTo(prop.getProperty("hcm.cloud.email.replyto"));
			eMailDeliveryOption.setEmailServerName(prop.getProperty("hcm.cloud.email.servername"));

			String propSubject = prop.getProperty("hcm.cloud.email.worker.subject");

			eMailDeliveryOption.setEmailSubject(propSubject);
			log.info("Email Subject : " + propSubject);
			String emailBody = constructEmailBody(jobInfos, prop, dataObjectsLoadedStatusMap, file);
			log.info("Email body : " + emailBody);
			eMailDeliveryOption.setEmailBody(emailBody);
			ArrayOfEMailDeliveryOption arrayOfEMailDeliveryOption = new ArrayOfEMailDeliveryOption();
			arrayOfEMailDeliveryOption.getItem().add(eMailDeliveryOption);
			deliveryChannels.setEmailOptions(arrayOfEMailDeliveryOption);
			scheduleRequest.setDeliveryChannels(deliveryChannels);
			String reportResponse = null;
			try {
				reportResponse = scheduleService.scheduleReport(scheduleRequest, prop.getProperty("hcm.cloud.username"),
						prop.getProperty("hcm.cloud.password"));
				log.info("ScheduleReport webservice response : " + reportResponse);
			} catch (AccessDeniedException_Exception | InvalidParametersException_Exception
					| OperationFailedException_Exception e) {
				log.error(e);
			}

		} catch (MalformedURLException e1) {
			log.error(e1);
		}
	}

	private ParamNameValue constructParamNameValueObject(String contentIdFieldName, String contentId) {
		ArrayOfString arrayOfString = new ArrayOfString();
		arrayOfString.getItem().add(contentId);

		String nameParam = new String(contentIdFieldName);
		boolean multiValueParam = false;
		ParamNameValue paramNameValue = new ParamNameValue();
		paramNameValue.setName(nameParam);
		paramNameValue.setValues(arrayOfString);
		paramNameValue.setMultiValuesAllowed(multiValueParam);
		return paramNameValue;
	}

	/**
	 * This method constructs the email body.
	 * 
	 * @param contentId
	 * @param prop
	 * @param dataObjectsLoadedStatusMap
	 * @param file
	 * @return
	 * @throws IOException
	 */
	private String constructEmailBody(List<JobInfo> jobInfos, Properties prop,
			HashMap<Boolean, ArrayList<NeoGovData>> dataObjectsLoadedStatusMap, File file) throws IOException {
		String emailBody = "Dear CCOB HR Team,\n\n" + prop.getProperty("hcm.cloud.email.body");
		StringBuilder sb = new StringBuilder();
		sb.append("\n\n");
		if (dataObjectsLoadedStatusMap.containsKey(Boolean.TRUE)) {
			sb.append("Details of the successfully loaded persons data : \n");
			String personsData = EMPTY;
			List<NeoGovData> successfullyLoadedDataObjects = dataObjectsLoadedStatusMap.get(Boolean.TRUE);
			personsData = getPersonsString(personsData, successfullyLoadedDataObjects);
			sb.append(personsData + "\n\n");
		}
		if (dataObjectsLoadedStatusMap.containsKey(Boolean.FALSE)) {
			sb.append("Details of the failed persons data : \n");
			String personsData = EMPTY;
			List<NeoGovData> successfullyLoadedDataObjects = dataObjectsLoadedStatusMap.get(Boolean.FALSE);
			personsData = getPersonsString(personsData, successfullyLoadedDataObjects);
			sb.append(personsData + "\n\n");
		}

		sb.append("Processed input file : \n");
		sb.append(file.getName() + "\n\n");
		emailBody += sb.toString();
		for (JobInfo jobInfo : jobInfos) {
			ReportSummary reportSummary = reportSummaryData(jobInfo.getContentId(), prop);
			emailBody += "Status of the " + jobInfo.getJobType() + " job : \n";
			emailBody += constructJobStatusBody(reportSummary);
		}
		return emailBody;
	}

	private String getPersonsString(String personsData, List<NeoGovData> successfullyLoadedDataObjects) {
		List<String> successfullyLoadedPersonsList = getAllPersonNameList(successfullyLoadedDataObjects);
		if (successfullyLoadedPersonsList != null && !successfullyLoadedPersonsList.isEmpty()) {
			for (String x : successfullyLoadedPersonsList) {
				personsData += x + ", ";
			}
			if (personsData.endsWith(", "))
				personsData = personsData.substring(0, personsData.length() - 2);
		}
		return personsData;
	}

	private String constructJobStatusBody(ReportSummary reportSummary) {
		StringBuilder sb = new StringBuilder();
		sb.append("IMPORTED_STATUS : " + reportSummary.getImportedStatus() + "\n");
		sb.append("LOADED_STATUS   : " + reportSummary.getLoadedStatus() + "\n");
		sb.append("LOADED_COUNT    : " + reportSummary.getLoadedCount() + "\n");
		sb.append("ERROR_COUNT     :" + reportSummary.getErrorCount() + "\n\n");
		return sb.toString();
	}

	/**
	 * This method fetches the report summary data by invoking the runReport
	 * webservice.
	 * 
	 * @param contentId
	 * @param prop
	 * @return
	 * @throws IOException
	 */
	public ReportSummary reportSummaryData(String contentId, Properties prop) throws IOException {

		log.info("In reportSummaryData method, P_CONTENTID : " + contentId);
		QName qName = new QName("http://xmlns.oracle.com/oxp/service/v2", "ReportService");
		ReportService_Service reportServiceClient = null;
		List<ReportSummary> reportSummaries = new ArrayList<ReportSummary>();
		ObjectFactory of = new ObjectFactory();
		ReportRequest reporeq = of.createReportRequest();

		try {

			reportServiceClient = new ReportService_Service(
					new URL(prop.getProperty("hcm.cloud.url") + "/xmlpserver/services/v2/ReportService?WSDL"), qName);
			com.oracle.xmlns.oxp.service.v2.ReportService reportService = reportServiceClient.getReportService();
			log.info("Summary report path : " + prop.getProperty("hcm.cloud.summary.report.path"));
			reporeq.setReportAbsolutePath(prop.getProperty("hcm.cloud.summary.report.path"));
			reporeq.setReportRawData("");
			reporeq.setSizeOfDataChunkDownload(-1);
			reporeq.setFlattenXML(true);
			reporeq.setByPassCache(true);
			ArrayOfString arrayOfString = new ArrayOfString();
			// contentId = "abcd";
			arrayOfString.getItem().add(contentId);// list of ssn values or ssn
													// value

			String nameParam = new String("P_CONTENTID");
			boolean multiValueParam = false;
			ParamNameValue paramNameValue = new ParamNameValue();
			paramNameValue.setName(nameParam);
			paramNameValue.setValues(arrayOfString);
			paramNameValue.setMultiValuesAllowed(multiValueParam);

			ArrayOfParamNameValue arrayOfParamNameValue = new ArrayOfParamNameValue();
			arrayOfParamNameValue.getItem().add(paramNameValue);
			ParamNameValues paramNameValuesList = new ParamNameValues();
			paramNameValuesList.setListOfParamNameValues(arrayOfParamNameValue);

			reporeq.setParameterNameValues(paramNameValuesList);

			ReportResponse reportResponse = null;
			try {
				reportResponse = reportService.runReport(reporeq, prop.getProperty("hcm.cloud.username"),
						prop.getProperty("hcm.cloud.password"));
			} catch (AccessDeniedException_Exception | InvalidParametersException_Exception
					| OperationFailedException_Exception e) {
				log.error(e);
			}

			try {
				String reportResponseString = new String(reportResponse.getReportBytes(), "UTF-8");
				log.info("Report Summary Response :\n" + reportResponseString);
				reportSummaries = ReadXml.readSummaryReport(reportResponseString);

			} catch (UnsupportedEncodingException e) {
				log.error(e);
			}

		} catch (MalformedURLException e1) {
			log.error(e1);
		}
		ReportSummary reportSummary = reportSummaries.get(0);
		if (reportSummary.getLoadedStatus().equalsIgnoreCase("IN_PROGRESS")) {
			log.info("Loaded status : IN_PROGRESS, Running Summary Report again for " + contentId + " ");
			try {
				TimeUnit.MILLISECONDS.sleep(10000);
			} catch (InterruptedException e) {
				log.error(e);
			}
			return reportSummaryData(contentId, prop);
		}

		return reportSummary;
	}

	/**
	 * This method gets all the list of person names from provided list.
	 * 
	 * @param dataObjects
	 * @return
	 */
	private static List<String> getAllPersonNameList(List<NeoGovData> dataObjects) {
		ArrayList<String> personStringList = new ArrayList<>();
		for (NeoGovData neoData : dataObjects) {
			personStringList
					.add(neoData.getLastname() + "_" + neoData.getFirstname() + "_" + neoData.getEmployeenumber());
		}
		return personStringList;
	}

}
