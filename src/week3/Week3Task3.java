package week3;

import config.AppConfig;
import lib.preprocessing.BowCollection;
import lib.preprocessing.BowDocument;
import lib.preprocessing.StoppingWords;

/**
 * <p>TASK 3: Stopping words ¡V use given stopping words list to ignore/remove all stopping words from the term list of documents.</p>
 * <ul>
 * 	<li>Download the stopping words list from QUT Blackboard, read through first, compare with your notes of high frequency terms.</li>
 * 	<li>Update your program to read in given stopping words list and store to a list stopWordsList.<br>
 * 		<i>see {@link StoppingWords#StoppingWords(String)}</i></li>
 * 	<li>Update your program, when adding term to term map, check the term if or not exist in stopping words list, ignore such term if it is in.<br>
 * 		<i>see {@link StoppingWords#isStopWord(String)} and {@link BowCollection#parseCollection(boolean)}</i></li>
 * 	<li>Call the method displayDocInfo() again and compare the output with Task 2.</li>
 * </ul>
 * @author Toni Lam
 * @since 1.0
 * @version 2.0, Apr 23, 2017
 */
public class Week3Task3 extends Week3Task2 {
	
	public static void main(String[] args) {
		final boolean STOPWORD = true;
		final boolean STEMMING = false;

		bowCollection = new BowCollection(AppConfig.DEFAULT_DATASET_DIR, STOPWORD, STEMMING);
		
		for (BowDocument thisDoc: bowCollection.values()) {
			displayDocInfo(thisDoc.getDocId());
		}
	}
	
}
