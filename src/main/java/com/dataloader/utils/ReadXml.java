package com.dataloader.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import com.dataloader.models.PersonData;
import com.dataloader.models.PersonsData;
import com.dataloader.models.ReportSummaries;
import com.dataloader.models.ReportSummary;

public class ReadXml {

	public static List<ReportSummary> readSummaryReport(String details) {
		List<ReportSummary> reportSummaries = null;
		Boolean flag = true;
		try {
			StringReader reader = new StringReader(details.trim());
			JAXBContext context = JAXBContext.newInstance(ReportSummaries.class);
			Unmarshaller un = context.createUnmarshaller();
			ReportSummaries reportSummariesData = (ReportSummaries) un.unmarshal(reader);
			reportSummaries = reportSummariesData.getReportSummaries();
		} catch (JAXBException e) {
			flag = false;
			if (e.getCause().getMessage().equals("Content is not allowed in trailing section.")) {
				flag = true;
			}
		}
		return flag == true ? reportSummaries : null;

	}

	public static List<PersonData> readPersonData(String details) {
		List<PersonData> personsDataList = null;
		Boolean flag = true;
		try {
			StringReader reader = new StringReader(details.trim());
			JAXBContext context = JAXBContext.newInstance(PersonsData.class);
			Unmarshaller un = context.createUnmarshaller();
			PersonsData personsData = (PersonsData) un.unmarshal(reader);
			personsDataList = personsData.getPersonDataList();
		} catch (JAXBException e) {
			flag = false;
			if (e.getCause().getMessage().equals("Content is not allowed in trailing section.")) {
				flag = true;
			}
		}
		return flag == true ? personsDataList : null;

	}
	
	public String getFileContent(File fileName) {
		BufferedReader reader = null;
		char[] buffer = new char[1024];
		StringBuffer fileContent = new StringBuffer();
		try {
			String line = null;
			reader = new BufferedReader(new FileReader(fileName));
			while ((line = reader.readLine()) != null) {
				if (line.length() > 0) {
					fileContent.append(line);
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return fileContent.toString();
	}
}
