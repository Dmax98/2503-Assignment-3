import java.util.Comparator;

public class AvengerComparatorFreqAscending implements Comparator<Avenger>{

	@Override
	public int compare(Avenger o1, Avenger o2) {
		if(o1.getFrequency() > o2.getFrequency()) {
			return 1;
		}else if(o1.getFrequency() < o2.getFrequency()) {
			return -1;
		}
		
		 int result = o1.getHeroAlias().length() - o2.getHeroAlias().length();
	        if(result == 0){
	            return o1.getHeroAlias().compareTo(o2.getHeroAlias());
	        }
	        return result;
	}

}
