package week3;

import java.util.HashMap;

import config.AppConfig;
import lib.preprocessing.BowCollection;
import lib.preprocessing.BowDocument;

/**
 * <p>TASK 2: Tokenizing ¡V update Task 1 program to fill term:freq map for every document.</p>
 * <ul>
 * 	<li>You only need to tokenize the '&lt;text&gt;¡K&lt;/text&gt;' part of document, exclude all tags, and discard punctuations, numbers.<br>
 * 		<i>By using org.xml.sax.helpers.DefaultHandler, all the tags will be excluded.<br>
 * 		also see {@link BowCollection#parseCollection(boolean)}</i></li>
 * 	<li>Use addTerm() of BowDocument to add new term to term map or increase term frequency when the term occur again.<br>
 * 		see {@link BowDocument#addTerm(String)}</li>
 * 	<li>Create a method displayDocInfo(int aDocId) to display term list with a given docuemntID, by searching collection of BowDocument in Task 1, and calling getTermFreqMap() of found document. The output should be like:<br>
 * 	Doc docId has termCount different terms:<br>
 * 	Term1, 3<br>
 * 	Term2, 1<br>
 * 	Term3, 4<br>
 * 	¡K<br>
 * 	<i>see {@link #displayDocInfo(int)}</i></li>
 * 	<li>Please note the terms with high frequency.</li>
 * </ul>
 * @author Toni Lam
 * @since 1.0
 * @version 2.0, Apr 23, 2017
 */
public class Week3Task2 {
	static protected BowCollection bowCollection;

	public static void main(String[] args) {
		final boolean STOPWORD = false;
		final boolean STEMMING = false;
		
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
		
		HashMap<String, Integer> termFreqMap = bowCollection.get(aDocId).getTermFreqMap();
		System.out.format("Document %d has %d different terms:\n",
				aDocId, termFreqMap.size());
		for (String name : termFreqMap.keySet()) {
			System.out.format("%s,%s%d\n",
					name,
					(name.length() < ONE_TAP_SPACES)? "\t\t":"\t",
					termFreqMap.get(name));
		}
		System.out.println("\n\n");
	}

}
