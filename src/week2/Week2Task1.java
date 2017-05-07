package week2;

import config.AppConfig;
import lib.preprocessing.BowCollection;
import lib.preprocessing.BowDocument;

/**
 * <p>Task 1 for Week 2 practical: Write a program that loads (read) RCV1v2 collection,
 * and prints out the <b>itemid</b> and the number of words in &lt;<b>text</b>&gt; of each
 * file.</p>
 * @author Toni Lam
 * @since 1.0
 * @version 2.0, 13 March 2017
 */
public class Week2Task1 {
    
    public static void main(String[] args) {
		final boolean STOPWORD = false;
		final boolean STEMMING = false;
		
		BowCollection bowCollection = new BowCollection(AppConfig.DEFAULT_DATASET_DIR,
				STOPWORD, STEMMING);
		
		for (BowDocument doc : bowCollection.values()) {
			System.out.format("Document with itemid = %d contains %d words.\n",
					doc.getItemId(), doc.getWordCount());
		}
    }
      
}
