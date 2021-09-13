package com.dataloader.models;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "ROWSET")
public class PersonsData {

	private List<PersonData> personDataList;

	@XmlElement(name = "ROW")
	public List<PersonData> getPersonDataList() {
		return personDataList;
	}

	public void setPersonDataList(List<PersonData> personDataList) {
		this.personDataList = personDataList;
	}


}
