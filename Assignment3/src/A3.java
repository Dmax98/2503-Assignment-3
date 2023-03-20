
import java.util.Scanner;

/**
 * COMP 2503 Winter 2023 Assignment 3
 * 
 * This program must read a input stream and keeps track of the frequency at
 * which an avenger is mentioned either by name or alias. The program uses a BST
 * for storing the data. Multiple BSTs with alternative orderings are
 * constructed to show the required output.
 * 
 * @author Maryam Elahi
 * @date Winter 2023
 */

public class A3 {

	public String[][] avengerRoster = { { "captainamerica", "rogers" }, { "ironman", "stark" },
			{ "blackwidow", "romanoff" }, { "hulk", "banner" }, { "blackpanther", "tchalla" }, { "thor", "odinson" },
			{ "hawkeye", "barton" }, { "warmachine", "rhodes" }, { "spiderman", "parker" },
			{ "wintersoldier", "barnes" } };

	private int topN = 4;
	private int totalwordcount = 0;
	private Scanner input = new Scanner(System.in);
//	private BST<Avenger> alphabticalBST = new BST<>();
//	private BST<Avenger> mentionBST = new BST<Avenger>(new AvengerComparatorMentionOrder());
//	private BST<Avenger> mostPopularBST = new BST<Avenger>(new AvengerComparatorFreqDesc());
//	private BST<Avenger> leastPopularBST = new BST<Avenger>(new AvengerComparatorFreqAsc());

	public static void main(String[] args) {
		A3 a1 = new A3();
		a1.run();
	}

	public void run() {
		readInput();
		createdAlternativeOrderBSTs();
		printResults();
	}

	private void createdAlternativeOrderBSTs() {
		/* TODO:
		 *   - delete the avenger "hawkeye"/"barton" from the alphabetical tree
		 *   use the tree iterator to do an in-order traversal of the alphabetical tree,
		 *   and add avengers to the other trees
		 */
	}

	/**
	 * read the input stream and keep track how many times avengers are mentioned by
	 * alias or last name.
	 */
	private void readInput() {
		/*
		 * While the scanner object has not reached end of stream, 
		 * 	- read a word. 
		 * 	- clean up the word 
		 * 	- if the word is not empty, add the word count. 
		 * 	- Check if the word is either an avenger alias or last name then 
		 *  - Create a new avenger object with the corresponding alias and last name. 
		 *  - if this avenger has already been mentioned, increase the frequency count 
		 *  for the object already in the list. 
		 *  - if this avenger has not been mentioned before, add the 
		 *  newly created avenger to the list, remember to set the frequency and the mention order.
		 * (Remember to keep track of the mention order by setting the mention order for each new avenger.)
		 */
	}

	/**
	 * print the results
	 */
	private void printResults() {
		System.out.println("Total number of words: " + totalwordcount);
		// TODO: Print the number of mentioned avengers after deleting "Barton".
		//System.out.println("Number of Avengers Mentioned: " + ??);
		System.out.println();

		System.out.println("All avengers in the order they appeared in the input stream:");
		// TODO: Print the list of avengers in the order they appeared in the input
		// Make sure you follow the formatting example in the sample output
		//
		System.out.println();

		System.out.println("Top " + topN + " most popular avengers:");
		// TODO: Print the most popular avengers, see the instructions for tie breaking
		// Make sure you follow the formatting example in the sample output
		//
		System.out.println();

		System.out.println("Top " + topN + " least popular avengers:");
		// TODO: Print the least popular avengers, see the instructions for tie breaking
		// Make sure you follow the formatting example in the sample output
		//
		System.out.println();

		System.out.println("All mentioned avengers in alphabetical order:");
		// TODO: Print the list of avengers in alphabetical order
		//
		System.out.println();

		// TODO: Print the actual height and the optimal height for each of the four trees.
//		System.out.println("Height of the mention order tree is : " + ??
//				+ " (Optimal height for this tree is : " + ?? + ")");
//		System.out.println("Height of the alphabetical tree is : " + ??
//				+ " (Optimal height for this tree is : " + ?? + ")");
//		System.out.println("Height of the most frequent tree is : " + ??
//				+ " (Optimal height for this tree is : " + ?? + ")");
//		System.out.println("Height of the least frequent tree is : " + ??
//				+ " (Optimal height for this tree is : " + ?? + ")");
	}
}
