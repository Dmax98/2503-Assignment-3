import java.util.Comparator;

public class AvengerComparatorFreqAscending implements Comparator<Avenger> {
	
	@Override
	/**
	 * Total order:
	 * ascending order of total frequency 
	 * in case of tie, in ascending order of last name length
	 * in case of tie, in ascending alphabetical order of last name
	 */
	public int compare(Avenger a1, Avenger a2) {
		int diff = a1.getFrequency() - a2.getFrequency();
		if (diff == 0) {
			diff = a1.getHeroName().length() - a2.getHeroName().length();
			if (diff == 0)
				return a1.getHeroName().compareTo(a2.getHeroName());
		}
		return diff;
	}
}
