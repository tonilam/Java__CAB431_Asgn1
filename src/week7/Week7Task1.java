package week7;

import java.io.File;

import config.AppConfig;
import lib.evaluation.Evaluator;

/**
 * <p>TASK 1: read a topic-doc-assignments file (e.g., topicdocassign.txt, the benchmark) 
 * and a retrieved topic-doc-assignments file (e.g., topicdocassigntest.txt, the output 
 * of an IR model); calculate three evaluation measures of Recall, Precision, and F-Measure.
 * <ul>
 * 	<li>Please download two topic-doc-assignment files, open and read through. The given 
 * 		topic-assignment files are in format of ¡§topic documentID Relevance judgment¡¨ using 1 
 * 		to indicate relevant and 0 for non-relevant.</li>
 * 	<li>Create a new class evaluator, read in two given topic-assignment files. Build up 
 * 		a set of relevant documents containing all relevant documents based on 
 * 		topic-doc-assignment file, a set of retrieved documents containing all retrieved 
 * 		documents based on a rank file.
 *	<li>Create a method to calculate Recall, a method to calculate Precision, and a method 
 *		to calculate F-measure. Display three evaluation measures.</li>
 * </ul>
 * @author Toni Lam
 *
 * @since 1.0
 * @version 2.0, Apr 23, 2017
 */
public class Week7Task1 {
	
	public static final String TOPIC = "R105";

	public static void main(String[] args) {
		File benchmark = new File(AppConfig.DEFAULT_RESOURCE_DIR + "evaluation//topicdocassign.txt");
		File irOutput = new File(AppConfig.DEFAULT_RESOURCE_DIR
								+ "evaluation//topicdocassigntest.txt");
		
		try {
			/**
			 * Evaluator may throw the following exception:
			 * IOException, NumberFormatException, RelevanceJudgmentException
			 */
			Evaluator evaluator = new Evaluator(TOPIC, benchmark, irOutput);
			int numOfRelevantDoc = evaluator.getNumOfRelevantDocuments();
			int numOfRetrievedAndRelevantDoc = evaluator.getNumOfRetrievedAndRelevantDocuments();
			double recall = evaluator.calculateRecall();
			double precision = evaluator.calculatePrecision();
			double fMeasure = evaluator.calculateFMeasure();
			
			System.out.format("The number of relevant documents = %d\n", numOfRelevantDoc);
			System.out.format("The number of retrieved relevant documents = %d\n", numOfRetrievedAndRelevantDoc);
			System.out.format("recall = %.6f\n", recall);
			System.out.format("precision = %.6f\n", precision);
			System.out.format("F-Measure = %.6f\n", fMeasure);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
