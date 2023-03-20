import java.util.Comparator;

public class AvengerComparatorFreqDescending implements Comparator<Avenger> {

	/**
	 * override compare method for sorting the least popular avenger
	 */
	
	@Override
	public int compare(Avenger a, Avenger b) {
		int freq1 = a.getFrequency();
		int freq2 = b.getFrequency();
		
		//if else statement that catches if the value of a - b is 0, 1, -1
		if(freq1-freq2 == 0) {
			int result;
			//if two objects have same frequency compare the length of word
			if(a.getHeroName().length() < b.getHeroName().length()) {
				result = b.compareTo(a);
			} else if (a.getHeroName().length() == b.getHeroName().length()){
				result = a.getHeroName().compareTo(b.getHeroName());
			} else {
				result = a.compareTo(b);
			}
			return result;
		}
		return freq1-freq2;
	}

}
