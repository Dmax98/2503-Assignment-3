import java.util.Comparator;

public class AvengerComparatorFreqDescending implements Comparator<Avenger>{

	@Override
	public int compare(Avenger o1, Avenger o2) {
		
		if(o1.getFrequency() > o2.getFrequency()) {
			return -1;
		}
		if(o1.getFrequency() < o2.getFrequency()) {
			return 1;
		}
		return o1.compareTo(o2);
		
	}
	
}
