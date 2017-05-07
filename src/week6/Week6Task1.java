package week6;

import config.AppConfig;
import lib.preprocessing.BowCollection;
import lib.preprocessing.BowDocument;

/**
 * <p>TASK 1: Calculate and store the average document length in given documents set.</p>
 * <ul>
 * 	<li>In the BowDocument class, add a field (class variable) of docLength, write accessor
 * 		(get) and mutator (set) methods for it.</li>
 *  <li>Modify the processor class, while parsing every input documents, for BowDocument
 *  	object creation, call mutator method of docLength to save the document length to
 *  	the BowDocument object. In the same time, sum up every BowDocument¡¦s docLength as
 *  	totalDocLength, then in the end the parsing all input document, calculate the
 *  	average document length. You may keep the <i>avgdl</i> as processor class variable
 *  	for later use. Or you can create a method taking a BowDocument collection as a
 *		parameter, then calculate the average document length for it.</li>
 *	<li>Print out a list of docID : docLength, and average document length for given
 * 		document collection.</li>
 * </ul>
 * @author Toni Lam
 *
 * @since 1.0
 * @version 2.0, Apr 23, 2017
 */
public class Week6Task1 {

	public static void main(String[] args) {
		BowCollection bowCollection = new BowCollection(AppConfig.DEFAULT_DATASET_DIR);
		
		for (BowDocument thisDoc : bowCollection.values()) {
			System.out.printf("Document %s has a document length of %d.\n",
							  thisDoc.getDocId(),
							  thisDoc.getWordCount());
		}
		System.out.printf("\nThese %d documents have an average document length of %d.\n",
						  bowCollection.size(),
						  bowCollection.getAverageDocLength());
	}
	
}
