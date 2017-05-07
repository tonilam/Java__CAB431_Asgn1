package week4;

import java.util.HashMap;

import config.AppConfig;
import lib.preprocessing.BowCollection;
import lib.preprocessing.BowDocument;
import lib.preprocessing.Stemmer;

/**
 * <p>TASK 1: Stemming ¡V using porter2 stemming algorithm to update BowDocument¡¦s term list
 * (e.g., HashMap or dictionary)</p>
 * <ul>
 * 	<li>Declare and initialize a SnowballStemmer variable and call above method to stem every term before storing it in BowDocument. (if you have not remove less-than-three-letters-word in last week tasks, then you can remove them in this week tasks)<br>
 * 		<i>see {@link Stemmer#Stemmer(boolean)}</i></li>
 * 	<li>Output updated term list of every BowDocument in the collection of 10 given input files.</li>
 * 	<li>Compare with last week output to see what a stemmer doing in text pre-processing.</li>
 * </ul>
 * @author Toni Lam
 *
 * @since 1.0
 * @version 2.0, Apr 23, 2017
 */
public class Week4Task1 {
	
	static protected BowCollection bowCollection;
	
	public static void main(String[] args) {
		final boolean STOPWORD = true;
		final boolean STEMMING = true;

		bowCollection = new BowCollection(AppConfig.DEFAULT_DATASET_DIR, STOPWORD, STEMMING);
		
		for (BowDocument thisDoc: bowCollection.values()) {
			displayDocInfo(thisDoc.getDocId());
		}
	}
	
	/**
	 * It prints the statistic of a given document ID on the console.
	 * @since 1.0
	 * 
	 * @param aDocId is the document ID we want to print its statistic. It should not be null.
	 */
	public static void displayDocInfo(int aDocId) {
		final int ONE_TAP_SPACES = 7;
		
		HashMap<String, Integer> termFreqMap = bowCollection.get(aDocId).getSortedTermFreqMap();
		System.out.format("Document %d contains %d terms and has total %d words.\n",
				aDocId, termFreqMap.size(), bowCollection.get(aDocId).getWordCount());
		for (String name : termFreqMap.keySet()) {
			System.out.format("%s,%s%d\n",
					name,
					(name.length() < ONE_TAP_SPACES)? "\t\t":"\t",
					termFreqMap.get(name));
		}
		System.out.println("\n\n");
	}
	
}
