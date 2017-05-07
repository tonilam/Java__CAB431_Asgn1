package week7;

import java.io.File;
import java.util.Map.Entry;

import config.AppConfig;
import lib.evaluation.RankingMap;

/**
 * <p>TASK 2: read two top-10 ranking result files (e.g., rank1.txt, and rank2.txt), 
 * calculate average Precision.</p>
 * <ul>
 * 	<li>Please download two top-10 ranking result files, open and read through. The given 
 * 		top-10 ranking result files are in format of ¡§rankingNo documentId¡¨.</li>
 * 	<li>Create a method to parse two ranking result file and generate a HashMap (dictionary in Python) of rankingNo:documentId pair.</li>
 * 	<li>Create a method to calculate Recall and Precision at fixed rank positions i.e. 1-10, taking a set of relevant documents built in task 1 and HashMap of rankingNo:documentId as two parameters. Then calculate the average precision. Print out the results.</li>
 * </ul>
 * @author Toni Lam
 *
 * @since 1.0
 * @version 2.0, Apr 23, 2017
 */
public class Week7Task2 {

	public static void main(String[] args) {
		File rankfile1 = new File(AppConfig.DEFAULT_RESOURCE_DIR + "//evaluation//rank1.txt");
		File rankfile2 = new File(AppConfig.DEFAULT_RESOURCE_DIR + "//evaluation//rank2.txt");

		System.out.println("/------------------------------------------\\");
		System.out.println("| Calculate ranking effectiveness of rank1 |");
		System.out.println("\\------------------------------------------/");
		showRankingEffectiveness(rankfile1);

		System.out.println("/------------------------------------------\\");
		System.out.println("| Calculate ranking effectiveness of rank2 |");
		System.out.println("\\------------------------------------------/");
		showRankingEffectiveness(rankfile2);

	}
	
	/**
	 * It shows the ranking effectiveness of a given file. 
	 * @since 1.0
	 *
	 * @param rankfile is the data source of the ranking file.
	 */
	private static void showRankingEffectiveness(File rankfile) {
		final File relevantDoc = new File(AppConfig.DEFAULT_RESOURCE_DIR + "//evaluation//topicdocassign.txt");
		RankingMap<Integer, Integer> ranking = new RankingMap<Integer, Integer>();
		int currentPosition;
		
		try {
			/**
			 * RankingMap may throw the following exceptions:
			 * IOException, FileNotFoundException
			 */
			ranking.loadFromFile(rankfile);
			ranking.identifyRelevantDoc(relevantDoc);
			for (Entry<Integer, Integer> record : ranking.entrySet()) {
				currentPosition = record.getKey();
				System.out.format("At position %2d, precision=%.6f recall=%.6f\n",
						currentPosition,
						ranking.calculateFixedRankPositionPrecision(currentPosition),
						ranking.calculateFixedRankPositionRecall(currentPosition)
						);
			}
			System.out.format("\nIn top-10, average precision = %.6f\n\n\n",
					ranking.getAveragePrecision());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
