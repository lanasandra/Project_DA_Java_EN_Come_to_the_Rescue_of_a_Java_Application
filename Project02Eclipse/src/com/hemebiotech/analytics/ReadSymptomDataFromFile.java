package com.hemebiotech.analytics;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.TreeMap;

public class ReadSymptomDataFromFile implements ISymptomReader {

	String filepath;
	String fileResult;

	public ReadSymptomDataFromFile(String filepath) {
		this.filepath = filepath;
	}

	/**
	 * With the method GetSymptoms, we first of all import the text file into a list
	 * and we read all lines at once with readAllLines. Then, we create a TreeMap :
	 * if the line already contains the name, we increment the counter related to
	 * the key. If not, we add only one to the value related to the key. This method
	 * returns the treeMap with key and values.
	 * 
	 * @return
	 * @throws Exception
	 */

	public TreeMap<String, Integer> GetSymptoms() throws Exception {

		List<String> listsymptom = Files.readAllLines(Paths.get(filepath));

		TreeMap<String, Integer> mapSymptom = new TreeMap<>();

		for (String name : listsymptom) {

			if (mapSymptom.containsKey(name)) {

				mapSymptom.put(name, mapSymptom.get(name) + 1);
			} else {

				mapSymptom.put(name, 1);
			}
		}
		return mapSymptom;
	}
}
