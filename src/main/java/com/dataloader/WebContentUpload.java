package com.dataloader;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import oracle.stellent.ridc.IdcClient;
import oracle.stellent.ridc.IdcClientException;
import oracle.stellent.ridc.IdcClientManager;
import oracle.stellent.ridc.IdcContext;
import oracle.stellent.ridc.model.DataBinder;
import oracle.stellent.ridc.model.TransferFile;
import oracle.stellent.ridc.protocol.ServiceResponse;

public class WebContentUpload {

	private static final Logger log = LogManager.getLogger(WebContentUpload.class);

	public static String uploadContent(String path, String url, String userId, String pwd, File zipFile)
			throws Exception {
		String cId = "NEO";

		try {

			Calendar calendar = Calendar.getInstance();
			java.util.Date now = calendar.getTime();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
			String formattedDate = sdf.format(now);
			cId = cId + formattedDate;
			log.info("Content Id: " + cId);
			IdcClientManager m_clientManager = new IdcClientManager();
			IdcClient idcClient = m_clientManager.createClient(url);
			// IdcClient idcClient =
			// m_clientManager.createClient("https://hcie-dev1.fs.us2.oraclecloud.com/cs/idcplg");
			// // replace with relevant URL
			IdcContext userContext = new IdcContext(userId, pwd); // replace with relevant username password
			// IdcContext userContext = new IdcContext("SIVA", "Welcome3D"); // replace with
			// relevant username password
			String businessUnitName = zipFile.getName();
			checkin(idcClient, userContext, zipFile, // Replace with fully qualified path to source file
					"Document", // content type
					businessUnitName, // doc title
					// docTitle,
					userContext.getUser(), // author
					"FAFusionImportExport", // security group
					"hcm$/dataloader$/import$", // account
					cId);// dDocName - this is the ContentId ;
		} catch (IdcClientException e) {
			e.printStackTrace();
		}
		return cId;
	}

	/**
	 * * Method description * * @param idcClient * @param userContext * @param
	 * sourceFileFQP fully qualified path to source content * @param contentType
	 * content type * @param dDocTitle doc title * @param dDocAuthor author * @param
	 * dSecurityGroup security group * @param dDocAccount account * @param dDocName
	 * dDocName * * @throws IdcClientException
	 */
	private static void checkin(IdcClient idcClient, IdcContext userContext, File sourceFile, String contentType,
			String dDocTitle, String dDocAuthor, String dSecurityGroup, String dDocAccount, String dDocName)
			throws IdcClientException {
		InputStream is = null;
		try {
			is = new FileInputStream(sourceFile);
			TransferFile primaryFile = new TransferFile();
			primaryFile.setInputStream(is);
			primaryFile.setContentType(contentType);
			primaryFile.setFileName(sourceFile.getName());
			primaryFile.setContentLength(sourceFile.length()); // note!!! when using HTTP protocol (not intradoc/jaxws)
																// - one
			// must explicitly // set the Content Length when supplying an
			// InputStream to the transfer file // e.g.
			// primaryFile.setContentLength(xxx); // otherwise, a 0-byte
			// file results on the server
			DataBinder request = idcClient.createBinder();
			request.putLocal("IdcService", "CHECKIN_UNIVERSAL");
			request.addFile("primaryFile", primaryFile);
			request.putLocal("dDocTitle", dDocTitle);
			request.putLocal("dDocAuthor", dDocAuthor);
			request.putLocal("dDocType", contentType);
			request.putLocal("dSecurityGroup", dSecurityGroup); // if server is setup to use accounts - an account MUST
																// be specified // even if it is the empty string;
																// supplying null results in Content server //
																// attempting to apply an account named "null" to the
																// content!
			request.putLocal("dDocAccount", dDocAccount == null ? "" : dDocAccount);
			if (dDocName != null && dDocName.trim().length() > 0) {
				request.putLocal("dDocName", dDocName);
			} // execute the request
			ServiceResponse response = idcClient.sendRequest(userContext, request); // throws IdcClientException // get
																					// the binder - get a binder closes
																					// the response automatically
			DataBinder responseBinder = response.getResponseAsBinder(); // throws IdcClientException

			log.info(
					"Response Status Code from the Content Server: " + responseBinder.getLocalData().get("StatusCode"));
			log.info("Response Status from the Content Server: " + responseBinder.getLocalData().get("dStatus"));
			log.info("Response Status Message from the Content Server: "
					+ responseBinder.getLocalData().get("StatusMessage"));

		} catch (IOException e) {
			e.printStackTrace(System.out);
		} finally {
			if (is != null) {
				try {
					is.close();
				} catch (IOException ignore) {
				}
			}
		}
	}
}
