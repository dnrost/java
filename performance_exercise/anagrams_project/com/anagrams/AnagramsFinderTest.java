package com.anagrams;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Set;

import org.junit.Test;

public class AnagramsFinderTest {

	/**
	 * Test of the displayAnagrams() method
	 * @throws FileNotFoundException
	 */
	@Test
	public void testDisplayAnagrams() throws FileNotFoundException {
		HashMap<String, Set<String>> anagramsMap = AnagramsFinder
					.displayAnagrams("./test_resources/sample.txt");
		assertNotNull(anagramsMap.size());
		assertNotEquals(anagramsMap.size(), 0);
	}

}
