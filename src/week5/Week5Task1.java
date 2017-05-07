package week5;

import config.AppConfig;
import lib.preprocessing.BowCollection;
import lib.preprocessing.DocumentFrequency;

/**
 * <p>TASK 1: Calculate Document-Frequency of each term and store them in a term:df HashMap
 * (in Java) / dictionary (in Python, C#). Call the created method then display a list of
 * TERM: DF for whole RCV1v2 document collection, and save the output into a text file
 * (file name is ¡§your full name_wk5_t1.txt¡¨).</p>
 * @author Toni Lam
 *
 * @since 1.0
 * @version 2.0, Apr 23, 2017
 */
public class Week5Task1 {
	
	public static void main(String[] args) {
		BowCollection bowCollection = new BowCollection(AppConfig.DEFAULT_DATASET_DIR);
		DocumentFrequency df = new DocumentFrequency();
		
		df.calculateDF(bowCollection);

		System.out.println(df.toString());
	}
}
