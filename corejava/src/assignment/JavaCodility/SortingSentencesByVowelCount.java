package assignment.JavaCodility;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class SortingSentencesByVowelCount {

	public int vowelCount(String sentence) {
		int count = 0;

		String caseSensitiveSentence = sentence.toLowerCase();

		for (int i = 0; i < caseSensitiveSentence.length(); i++) {
			char ch = caseSensitiveSentence.charAt(i);

			if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
				count++;
			}
		}
		return count;
	}

	public static void main(String[] args) {

		List<String> sentences = new ArrayList<String>();
		sentences.add("My name is Varnika");
		sentences.add("I am a Software Developer");
		sentences.add("What is your name ?");
		sentences.add("What do you do");
		sentences.add("Do you live here itself or somewhere else");
		sentences.add("Please finish your work");

		System.out.println(sentences);

		SortingSentencesByVowelCount sc = new SortingSentencesByVowelCount();
		Map<String, Integer> sentencesWithCount = new HashMap<String, Integer>();

		for (String sent : sentences) {
			sentencesWithCount.put(sent, sc.vowelCount(sent));
		}

		Map<String, Integer> sentencesAfterSorting = sentencesWithCount.entrySet().stream()
				.sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));

		System.out.println(sentencesAfterSorting);

	}

}
