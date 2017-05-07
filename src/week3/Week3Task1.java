package week3;

import config.AppConfig;
import lib.preprocessing.BowCollection;
import lib.preprocessing.BowDocument;

/**
 * <p>TASK 1: Parsing - read files from RCV1v2, find the documentID and record it to
 * a collection of BowDocument Objects.</p>
 * <ul>
 * 	<li>The documentID is simply assigned by the 'itemid' in &lt;newsitem&gt;<br>
 * 		<i>see BowDocument#setItemId(int)</i></li>
 *	<li>In this step, the created BowDocument can be initialed with found documentID and an empty Map (e.g., HashMap, or dictionary) of key value pair of (String term: int frequency).<br>
 *		<i>see {@link BowDocument#BowDocument(String)}</i></li>
 *	<li>Build up a collection of BowDocument for given dataset, this collection should be a map structure with documentID as key and BowDocument object as value.<br>
 *		<i>see {@link BowCollection}</i></li>
 *	<li>Create a method (or function) to print out all documentIDs by iterating above collection and calling BowDocument¡¦s method getDocId().<br>
 *		<i>see {@link #printDocumentIds(BowCollection)}</i></li>
 * </ul>
 * @see BowDocument#setitemId(int) for objective 1
 * @author Toni Lam
 * @since 1.0
 * @version 2.0, Apr 23, 2017
 */
public class Week3Task1 {

	public static void main(String[] args) {
		final boolean STOPWORD = false;
		final boolean STEMMING = false;
		
		BowCollection bowCollection = new BowCollection(AppConfig.DEFAULT_DATASET_DIR,
				STOPWORD, STEMMING);
		printDocumentIds(bowCollection);
	}
	
	/**
	 * It prints all the documentIDs of the BowDocument from the given BowCollection. 
	 * @since 2.0
	 *
	 * @param bowCollection is the collection that stored all the bowDocument in the data set.
	 */
	public static void printDocumentIds(BowCollection bowCollection) {
		int counter = 1;
		System.out.format("There are total %d documents in the data set.\n",
				bowCollection.size());
		System.out.println("Doc\tdocumentID");
		System.out.println("---\t----------");
		for (BowDocument thisDoc : bowCollection.values()) {
			System.out.format("#%d\t%d\n", counter++, thisDoc.getDocId());
		}
	}

}
