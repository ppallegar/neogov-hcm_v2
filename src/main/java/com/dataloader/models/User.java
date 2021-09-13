package com.dataloader.models;

import static com.dataloader.constants.ApplicationConstants.EMPTY;

public class User {

	private String mode = "MERGE";
	private String entity = "User";
	private String personNumber;
	private String userName;
	private String generateUserAccount = "Y";

	public String getPersonNumber() {
		return personNumber;
	}

	public void setPersonNumber(String personNumber) {
		this.personNumber = personNumber;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Override
	public String toString() {
		String string = mode + "|" + entity + "|" + personNumber + "|" + userName + "|" + generateUserAccount;
		string = string.replace("null", EMPTY);
		return string;
	}

}
