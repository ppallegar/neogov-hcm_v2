package com.dataloader.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.regex.Pattern;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class FileUtils {

	public static File[] getMatchedFileInDirectory(String directoryPath, String fileNamePattern) {
		String fileName[] = fileNamePattern.split("\\*");
		String fileNameSuffix = fileName[1] + "$";
		String fileNamePrefix = "^" + fileName[0];
		final Pattern fileExtnPtrn = Pattern.compile(fileNamePrefix + "([a-zA-Z0-9_ -])*" + fileNameSuffix);
		File dir = new File(directoryPath);
		File[] matchedFiles = dir.listFiles(new FilenameFilter() {
			public boolean accept(File dir, String name) {
				return fileExtnPtrn.matcher(name).matches();
			}
		});
		return matchedFiles;
	}
	
	public static String zipFile(String fileNameIn, String fileNameOut) {
		try {
			byte[] buffer = new byte[1024];
			FileOutputStream fos = new FileOutputStream(fileNameOut);
			ZipOutputStream zos = new ZipOutputStream(fos);

			// add worker.dat
			ZipEntry ze = new ZipEntry(fileNameIn);
			zos.putNextEntry(ze);
			FileInputStream in = new FileInputStream(fileNameIn);

			int len;
			while ((len = in.read(buffer)) > 0) {
				zos.write(buffer, 0, len);
			}

			in.close();
			zos.closeEntry();
			zos.close();
		} catch (IOException e) {
			System.out.println("Exception while zipping file " + e.getMessage());
			e.printStackTrace();
		}
		return fileNameOut;
	}

	public static File zipMultpleFiles(List<String> fileNamesIn, String fileNameOut) {
		try {
			byte[] buffer = new byte[1024];
			FileOutputStream fos = new FileOutputStream(fileNameOut);
			ZipOutputStream zos = new ZipOutputStream(fos);

			// adding list of files to single zip
			for (int i = 0; i < fileNamesIn.size(); i++) {
				ZipEntry ze = new ZipEntry(fileNamesIn.get(i));
				zos.putNextEntry(ze);
				FileInputStream in = new FileInputStream(fileNamesIn.get(i));

				int len;
				while ((len = in.read(buffer)) > 0) {
					zos.write(buffer, 0, len);
				}

				in.close();
			}
			zos.closeEntry();
			zos.close();
		} catch (IOException e) {
			System.out.println("Exception while zipping multiple files " + e.getMessage());
			e.printStackTrace();
		}
		return new File(fileNameOut);
	}

	public static void archiveFile(String fileNameIn, String fileNameOut) throws IOException {

		Path temp = Files.move(Paths.get(fileNameIn), Paths.get(fileNameOut));

		if (temp != null) {
			System.out.println("File renamed and moved successfully");
		} else {
			System.out.println("Failed to move the file");
		}

	}

	public void deleteFile(String fileNameIn) throws IOException {

		File file = new File(fileNameIn);

		if (file.delete()) {
			System.out.println("File deleted successfully");
		} else {
			System.out.println("Failed to delete the file");
		}

	}

}
