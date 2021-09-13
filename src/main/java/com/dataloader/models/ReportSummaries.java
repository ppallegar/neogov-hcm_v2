package com.dataloader.models;

import java.util.List;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "ROWSET")
public class ReportSummaries {
	private List<ReportSummary> reportSummaries;
	
	@XmlElement(name = "ROW")
	public List<ReportSummary> getReportSummaries() {
		return reportSummaries;
	}

	public void setReportSummaries(List<ReportSummary> reportSummaries) {
		this.reportSummaries = reportSummaries;
	}

}
