package com.anagrams;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

/**
 * 
 * @author Aicha
 *
 */
public class AnagramsFinder {

	/**
	 * Print anagrams existing in a the file passed as parameter
	 * @param pathFile
	 * @return
	 * @throws FileNotFoundException
	 */
	static HashMap<String, Set<String>> displayAnagrams(String pathFile) throws FileNotFoundException {

		// hashMap who will hold all the anagrams of the file
		HashMap<String, Set<String>> anagramsMap = new HashMap<>();
		Scanner scan = new Scanner(new File(pathFile));
		try {
			while (scan.hasNext()) {
				String word = scan.next();
				String sortedWord = sortWord(word);
				Set<String> wordsSet = anagramsMap.get(sortedWord);
				if(wordsSet != null) {
					wordsSet.add(word);
				} else {
					wordsSet =  new HashSet<>();
					wordsSet.add(word);
					anagramsMap.put(sortedWord, wordsSet);
				}
			}
		} finally {
			scan.close();
		}
		
		System.out.println("existing anagrams in file " + pathFile + " are: \n");

		List<Set<String>> listResults = new ArrayList<Set<String>>(anagramsMap.values());
		for (Set<String> wordsSet : listResults) {
			Set<String> wordsTreeSet = new TreeSet<String>(wordsSet); // to sort the Set
			if(wordsTreeSet.size() > 1) {
				for (String string : wordsTreeSet) {
					System.out.print(string + " ");
				}
			}
			System.out.println("");
		}

		return anagramsMap;
	}
	
	/**
	 * alphabetical sorting of the word
	 * @param word
	 * @return String
	 */
	static String sortWord(String word) {
		char[] wordArray = word.toCharArray();
		Arrays.sort(wordArray);
		return new String(wordArray);
	}
	
	/**
	 * The main method :)
	 * @param args
	 */
	public static void main(String[] args) {
		// args is to  specify the pathFile
			if (args == null || args.length == 0) {
		        System.out.println("You have to specify a path file");;
		    } else  
			try {
				AnagramsFinder.displayAnagrams(args[0]);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
	}

}
