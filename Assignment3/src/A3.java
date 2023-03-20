
import java.util.Iterator;
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
	private BST<Avenger> alphabticalBST = new BST<>();
	private BST<Avenger> mentionBST = new BST<Avenger>(new AvengerComparatorMentionOrder());
	private BST<Avenger> mostPopularBST = new BST<Avenger>(new AvengerComparatorFreqDescending());
	private BST<Avenger> leastPopularBST = new BST<Avenger>(new AvengerComparatorFreqAscending());

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
		
		Iterator<Avenger> it = mentionBST.iterator();
		
		while(it.hasNext()) {
			Avenger avenger = it.next();
			alphabticalBST.add(avenger);
			mostPopularBST.add(avenger);
			leastPopularBST.add(avenger);
		}	
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
		
		while (input.hasNext()) {
			
			String word = cleanWord(input.next());

			if (word.length() > 0) {
				totalwordcount++;
				for (String[] avenger : avengerRoster) {
                    if (word.equals(avenger[0]) || word.equals(avenger[1])) {
                        if (isAlreadyPresent(word)) {
                            Avenger avenger1 = null;
                            if ((avenger1 = getAvenger(word)) != null) {
                                avenger1.addFrequency();
                            }
                        } else {
                        	Avenger newAvenger = new Avenger(avenger[0], avenger[1]);
                        	newAvenger.addFrequency();
                        	mentionBST.add(newAvenger);
                        }
                    }
                }
			}
		}
	}
	
	private boolean isAlreadyPresent(String value) {
		
		Iterator<Avenger> it = mentionBST.iterator();
    	while(it.hasNext()) {
    		Avenger avenger = it.next();
    		if(avenger != null) {
    			if (avenger.getHeroName().equals(value) || avenger.getHeroAlias().equals(value)) {
                    return true;
                }
    		}
    	}
    	
        return false;
    }
	
    private Avenger getAvenger(String value) {
    	
    	Iterator<Avenger> it = mentionBST.iterator();
    	while(it.hasNext()) {
    		Avenger avenger = it.next();
    		if (avenger.getHeroName().equals(value) || avenger.getHeroAlias().equals(value)) {
                return avenger;
            }
    	}
        return null;
    }
	
	private String cleanWord(String next) {
		// First, if there is an apostrophe, the substring
		// before the apostrophe is used and the rest is ignored.
		// Words are converted to all lowercase.
		// All other punctuation and numbers are skipped.
		String ret;
		int inx = next.indexOf('\'');
		if (inx != -1)
			ret = next.substring(0, inx).toLowerCase().trim().replaceAll("[^a-z]", "");
		else
			ret = next.toLowerCase().trim().replaceAll("[^a-z]", "");
		return ret;
	}

	/**
	 * print the results
	 */
	private void printResults() {
		System.out.println("Total number of words: " + totalwordcount);
		System.out.println("Number of Avengers Mentioned: " + mentionBST.size());
		System.out.println();

		System.out.println("All avengers in the order they appeared in the input stream:");
		Iterator<Avenger> it = mentionBST.iterator();
		while(it.hasNext()) {
			System.out.println(it.next().toString());
		}
		System.out.println();

		System.out.println("Top " + topN + " most popular avengers:");
		// TODO: Print the most popular avengers, see the instructions for tie breaking
		// Make sure you follow the formatting example in the sample output
		int counter = 0;
		Iterator<Avenger> it2 = mostPopularBST.iterator();
		while(it2.hasNext()) {
			if(counter == 4) {
				break;
			}
			System.out.println(it2.next().toString());
			counter++;
		}
		System.out.println();

		System.out.println("Top " + topN + " least popular avengers:");
		// TODO: Print the least popular avengers, see the instructions for tie breaking
		// Make sure you follow the formatting example in the sample output
		int counter1 = 0;
		Iterator<Avenger> it3 = leastPopularBST.iterator();
		while(it3.hasNext()) {
			if(counter1 == 4) {
				break;
			}
			System.out.println(it3.next().toString());
			counter1++;
		}
		System.out.println();

		System.out.println("All mentioned avengers in alphabetical order:");
		// TODO: Print the list of avengers in alphabetical order
		Iterator<Avenger> it4 = alphabticalBST.iterator();
		while(it4.hasNext()) {
			System.out.println(it4.next().toString());
		}
		System.out.println();
		
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
