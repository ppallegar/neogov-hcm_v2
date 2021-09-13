package com.dataloader.models;

import javax.xml.bind.annotation.XmlElement;

public class PersonData {

	private String personNumer;
	private String contentId;

	@XmlElement(name = "PERSON_NUMBER")
	public String getPersonNumer() {
		return personNumer;
	}

	public void setPersonNumer(String personNumer) {
		this.personNumer = personNumer;
	}

	@XmlElement(name = "P_CONTENTID")
	public String getContentId() {
		return contentId;
	}

	public void setContentId(String contentId) {
		this.contentId = contentId;
	}
}
