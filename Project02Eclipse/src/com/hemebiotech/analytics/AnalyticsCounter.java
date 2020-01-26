package com.hemebiotech.analytics;

import java.io.FileWriter;
import java.util.TreeMap;

public class AnalyticsCounter {

	static String fileResult = "C:/Users/sandr/git/Project_DA_Java_EN_Come_to_the_Rescue_of_a_Java_Application/Project02Eclipse/src/com/hemebiotech/analytics/resultOut.txt";
	static String filepath = "C:/Users/sandr/git/Project_DA_Java_EN_Come_to_the_Rescue_of_a_Java_Application/Project02Eclipse/src/com/hemebiotech/analytics/symptoms.txt";

	public static void main(String args[]) throws Exception {

		ReadSymptomDataFromFile symptom = new ReadSymptomDataFromFile(filepath);

		TreeMap<String, Integer> map = symptom.GetSymptoms();

		FileWriter result = new FileWriter(fileResult);

		result.write("Symptom List :\n");

		for (String aSymptom : map.keySet()) {
			result.write(aSymptom + " = " + map.get(aSymptom) + ";\n");
		}
		result.close();

	}

}
