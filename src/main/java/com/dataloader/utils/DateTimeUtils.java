package com.dataloader.utils;

import static com.dataloader.constants.ApplicationConstants.EMPTY;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class DateTimeUtils {

	private static final Logger log = LogManager.getLogger(DateTimeUtils.class);

	public static String getFormattedDate(String date, String toFormat) {
		try {
			SimpleDateFormat formatter = new SimpleDateFormat(toFormat);
			Date dateOf = new SimpleDateFormat("MM/dd/yyyy").parse(date);
			String formattedDate = formatter.format(dateOf);
			return formattedDate;
		} catch (Exception e) {
			log.error("Exception while formatting date, value : " + date + " to " + toFormat);
			return EMPTY;
		}
	}
}
