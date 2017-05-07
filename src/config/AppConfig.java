package config;

/**
 * AppConfig is used for storing the static values being used when the program is
 * executing. Most of them are the directory path where the resources files are stored.
 *  
 * @author Toni Lam
 * @since 1.0
 * @version 2.0, Apr 22, 2017
 *
 */
public class AppConfig {

	public final static String DEFAULT_RESOURCE_DIR = ".//src//resources//";
	public final static String DEFAULT_DATASET_DIR = DEFAULT_RESOURCE_DIR + "RCV1v2//";
	public final static String DEFAULT_STOPWORD_FILE = DEFAULT_RESOURCE_DIR + "stopwords//common-english-words.txt";
	public final static int VALID_WORD_LENGTH = 3;
	
	/**
	 * Constructor.
	 */
	public AppConfig() {
		super();
	}

}
