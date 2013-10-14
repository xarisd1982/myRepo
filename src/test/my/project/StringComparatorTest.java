package my.project;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.LineIterator;

public class StringComparatorTest {
	public static void main (String[] args) {
		StringComparatorTest test = new StringComparatorTest();
		test.testRemoveDuplicates();
		test.testGetSortedListOfStringsFromFile();
		test.testGetCommonObjects();
	}
	
	private void testRemoveDuplicates() {
		StringComparator stringComparator = new StringComparator();
		List<String> testList = new ArrayList<String>();
		testList.add("aaa");
		testList.add("aaa");
		stringComparator.removeDuplicates(testList);
		if (testList.size() == 2) {
			System.out.println("removeDuplicates() method failed");
		} else if (testList.size() == 1) {
			System.out.println("removeDuplicates() method passed");
		} 
	}
	
	private void testGetSortedListOfStringsFromFile() {
		StringComparator stringComparator = new StringComparator();
		List<String> listOfStrings = new ArrayList<String>();
		File file = new File("c:\\users\\xarisd\\desktop\\input1.txt");
		try {			
			for (LineIterator lineIterator = FileUtils.lineIterator(file, "UTF-8");lineIterator.hasNext();) {
				listOfStrings.add(lineIterator.next());
			}
			Collections.sort(listOfStrings);
		} catch (IOException e) {
			e.printStackTrace();
		}
		for (String string : stringComparator.getSortedListOfStringsFromFile(file)) {
			if (!string.equals(listOfStrings.remove(0))) {
				System.out.println("getSortedListOfStringsFromFile() method failed");
			}
		}
		System.out.println("getSortedListOfStringsFromFile() method passed");
	}
	
	private void testGetCommonObjects() {
		StringComparator stringComparator = new StringComparator();
		List<String> list1 = new ArrayList<String>();
		List<String> list2 = new ArrayList<String>();
		list1.add("aaa");
		list1.add("bbb");
		list1.add("ccc");
		list2.add("bbb");
		list2.add("ddd");
		List<String> resultList = stringComparator.getCommonObjects(list1, list2);
		if (resultList!=null && resultList.size()==1 && resultList.contains("bbb")) {
			System.out.println("testGetCommonObjects() method passed");
		} else {
			System.out.println("testGetCommonObjects() method failed");
		}
	}
	
}
