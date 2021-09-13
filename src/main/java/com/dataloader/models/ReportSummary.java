package com.dataloader.models;

import javax.xml.bind.annotation.XmlElement;

public class ReportSummary {

	private String importedStatus;
	private String loadedStatus;
	private String loadedCount;
	private String errorCount;

	@XmlElement(name = "IMPORTED_STATUS")
	public String getImportedStatus() {
		return importedStatus;
	}

	public void setImportedStatus(String importedStatus) {
		this.importedStatus = importedStatus;
	}

	@XmlElement(name = "LOADED_STATUS")
	public String getLoadedStatus() {
		return loadedStatus;
	}

	public void setLoadedStatus(String loadedStatus) {
		this.loadedStatus = loadedStatus;
	}

	@XmlElement(name = "LOADED_COUNT")
	public String getLoadedCount() {
		return loadedCount;
	}

	public void setLoadedCount(String loadedCount) {
		this.loadedCount = loadedCount;
	}

	@XmlElement(name = "ERROR_COUNT")
	public String getErrorCount() {
		return errorCount;
	}

	public void setErrorCount(String errorCount) {
		this.errorCount = errorCount;
	}
}
