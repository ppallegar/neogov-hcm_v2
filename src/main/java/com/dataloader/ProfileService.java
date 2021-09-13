package com.dataloader;

import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.xml.namespace.QName;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.dataloader.models.PersonData;
import com.dataloader.utils.ReadXml;
import com.oracle.xmlns.oxp.service.v2.AccessDeniedException_Exception;
import com.oracle.xmlns.oxp.service.v2.ArrayOfParamNameValue;
import com.oracle.xmlns.oxp.service.v2.ArrayOfString;
import com.oracle.xmlns.oxp.service.v2.InvalidParametersException_Exception;
import com.oracle.xmlns.oxp.service.v2.ObjectFactory;
import com.oracle.xmlns.oxp.service.v2.OperationFailedException_Exception;
import com.oracle.xmlns.oxp.service.v2.ParamNameValue;
import com.oracle.xmlns.oxp.service.v2.ParamNameValues;
import com.oracle.xmlns.oxp.service.v2.ReportRequest;
import com.oracle.xmlns.oxp.service.v2.ReportResponse;
import com.oracle.xmlns.oxp.service.v2.ReportService_Service;

public class ProfileService {
	private static final Logger log = LogManager.getLogger(ProfileService.class);

	/**
	 * This method check whether person data is available or not using person number
	 * 
	 * @param personNumber
	 * @param prop
	 * @return
	 */
	public boolean findWorkerProfile(String personNumber, Properties prop) {

		PersonData personData = getPersonData(personNumber, prop);
		if (personData == null)
			return false;
		if (personData.getPersonNumer() == null || personData.getPersonNumer().isEmpty()
				|| (personData.getPersonNumer() != null && !personData.getPersonNumer().equalsIgnoreCase(personNumber)))
			return false;

		return true;
	}

	/**
	 * This method fetches the Person data using web service
	 * 
	 * @param personNumber
	 * @param prop
	 * @return
	 */
	private PersonData getPersonData(String personNumber, Properties prop) {
		log.info("In findWorkerProfile method, Person Number : " + personNumber);
		QName qName = new QName("http://xmlns.oracle.com/oxp/service/v2", "ReportService");
		ReportService_Service reportServiceClient = null;
		List<PersonData> personsData = new ArrayList<>();
		ObjectFactory of = new ObjectFactory();
		ReportRequest reporeq = of.createReportRequest();

		try {

			reportServiceClient = new ReportService_Service(
					new URL(prop.getProperty("hcm.cloud.url") + "/xmlpserver/services/v2/ReportService?WSDL"), qName);
			com.oracle.xmlns.oxp.service.v2.ReportService reportService = reportServiceClient.getReportService();
			log.info("Person number report path : " + prop.getProperty("hcm.cloud.personnumber.report.path"));
			reporeq.setReportAbsolutePath(prop.getProperty("hcm.cloud.personnumber.report.path"));
			reporeq.setReportRawData("");
			reporeq.setSizeOfDataChunkDownload(-1);
			reporeq.setFlattenXML(true);
			reporeq.setByPassCache(true);
			ArrayOfString arrayOfString = new ArrayOfString();
			arrayOfString.getItem().add(personNumber);// list of ssn values or ssn
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
				log.info("Person data Response :\n" + reportResponseString);
				personsData = ReadXml.readPersonData(reportResponseString);

			} catch (UnsupportedEncodingException e) {
				log.error(e);
			}

		} catch (MalformedURLException e1) {
			log.error(e1);
		}

		if (personsData != null)
			return personsData.get(0);
		return null;
	}
}
