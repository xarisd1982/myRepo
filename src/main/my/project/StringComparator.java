package my.project;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.LineIterator;

public class StringComparator {
	public static void main (String[] args) {
		if (args.length != 3) {
			System.out.println("Illegal argument number. Please run as:");
			System.out.println("java StringComparator inputFilePath1 inputFilePath2 resultfilePath");
			System.exit(0);
		}
		StringComparator stringComparator = new StringComparator();
		List<String> file1List = stringComparator.getSortedListOfStringsFromFile(stringComparator.getFileFromString(args[0]));
		List<String> file2List = stringComparator.getSortedListOfStringsFromFile(stringComparator.getFileFromString(args[1]));
		List<String> resultFileList = stringComparator.getCommonObjects(file1List, file2List);
		resultFileList = stringComparator.removeDuplicates(resultFileList);
		Collections.sort(resultFileList);
		try {
			FileUtils.writeLines(stringComparator.getFileFromString(args[2]), "UTF-8", resultFileList, true);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	protected List<String> getCommonObjects (List<String> list1, List<String> list2) {
		List<String> resultFileList = new ArrayList<String>();
		for (String aString : list1) {
			if (list2.contains(aString)) {
				resultFileList.add(aString);
			}
		}
		return resultFileList;
	}
	
	protected List<String> getSortedListOfStringsFromFile(File file) {
		List<String> listOfStrings = new ArrayList<String>();
		try {			
			for (LineIterator lineIterator = FileUtils.lineIterator(file, "UTF-8");lineIterator.hasNext();) {
				listOfStrings.add(lineIterator.next());
			}
			Collections.sort(listOfStrings);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return listOfStrings;
	}

	protected List<String> removeDuplicates(List<String> list) {
		HashSet<String> hs = new HashSet<String>();
		hs.addAll(list);
		list.clear();
		list.addAll(hs);
		return list;
	}
	
	private File getFileFromString(String filePath) {
		File file = new File(filePath);
		return file;
	}
}
