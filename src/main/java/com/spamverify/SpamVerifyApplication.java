package com.spamverify;

import java.util.*;

public class SpamVerifyApplication {

	//    //Expected Output
	//    //
	//    //spam
	//    //spam
	//    //not_spam
	//    //spam
	//    //not_spam
	//    //spam


	public static void main(String[] args) {

		List<String> subjects = Arrays.asList(
				"gwnpnzijd gwnpnzijd gwnpnzijd gwnpnzijd gwnpnzijd gwnpnzijd gwnpnzijd gwnpnzijd gwnpnzijd",
				"gwnpnzijd gwnpnzijd gwnpnzijd gwnpnzijd gwnpnzijd gwnpnzijd gwnpnzijd gwnpnzijd gwnpnzijd",
				"alcgxovldqfzaor hdigyojknvi ztpcmxlvovafh phvshyfiqqtqbxjj qngqjhwkcexec dkmzakbzrkjwqdy",
				"gwnpnzijd gwnpnzijd gwnpnzijd gwnpnzijd gwnpnzijd gwnpnzijd gwnpnzijd gwnpnzijd gwnpnzijd",
				"ssjoatryxmbwxbw xnagmaygz fnzpqftobtaotua xmwvzllkujidh kzwzcltgqngguft ahalwvjwqncksiz",
				"gwnpnzijd gwnpnzijd gwnpnzijd gwnpnzijd gwnpnzijd gwnpnzijd gwnpnzijd gwnpnzijd gwnpnzijd"
		);

		List<String> spam_words = List.of("gwnpnzijd");

		List<String> results = execute(subjects, spam_words);

        for (String result : results) {
            System.out.println(result);
        }
	}

	public static List<String> execute(List<String> subjects, List<String> spam_words) {
		List<String> results = new ArrayList<>();

		for (String sub : subjects) {
			boolean isSpam = verify(sub, spam_words);
			results.add(isSpam ? "spam" : "not-spam");
		}

		return results;
	}

	public static boolean verify(String line, List<String> spam_words) {
		String[] words = line.split(" ");
		Set<String> uniqueWords = new HashSet<>(Arrays.asList(words));

		for (String word : uniqueWords) {
			if (Collections.frequency(Arrays.asList(words), word) >= 2 && spam_words.contains(word)) {
				return true;
			}
		}

		return false;
	}

}
