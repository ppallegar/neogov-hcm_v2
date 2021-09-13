package com.dataloader.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.dataloader.models.NeoGovData;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.stream.JsonReader;

public class JsonUtil {

	private static final Logger log = LogManager.getLogger(JsonUtil.class);
	public static List<NeoGovData> getNeoGovDataObjects(String jsonFilePath) {
		List<NeoGovData> dataList = new ArrayList<>();
		try (JsonReader jsonReader = new JsonReader(
				new InputStreamReader(new FileInputStream(jsonFilePath), StandardCharsets.UTF_8))) {
			Gson gson = new GsonBuilder().create();
			jsonReader.beginArray();
			while (jsonReader.hasNext()) {
				NeoGovData neoGovData = gson.fromJson(jsonReader, NeoGovData.class);
				dataList.add(neoGovData);
			}
			jsonReader.endArray();
			log.info("Total entries : " + dataList.size());
		} catch (UnsupportedEncodingException e) {
			log.error(e.getMessage());
		} catch (FileNotFoundException e) {
			log.error(e.getMessage());
		} catch (IOException e) {
			log.error(e.getMessage());
		}
		return dataList;
	}
}
