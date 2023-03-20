import java.util.Comparator;

public class Avenger implements Comparable <Avenger>{

	//Initialize variables
	private String heroName;
	private String heroAlias;
	private int frequency;
	
	/**
	 * Constructor for Avenger class
	 * @param alias - String input
	 * @param name -  String input
	 */
	public Avenger(String alias, String name) {
		heroName = name;
		heroAlias = alias;
		frequency = 0;
	}

	/**
	 * Comparable override to sort object alphabetically
	 */
	@Override
	public int compareTo(Avenger a) {
		return this.heroAlias.compareTo(a.getHeroAlias());
	}

	/**
	 * Instantiate Avenger object and calling Comparator
	 */
	public static Comparator<Avenger> MostPopular = new Comparator<Avenger>() {
		/*
		 * Comparator override to sort object based on frequency
		 */
		public int compare(Avenger a, Avenger b) {
			int freq1 = a.getFrequency();
			int freq2 = b.getFrequency();

			if (freq2 - freq1 == 0) {
				return a.getHeroAlias().compareTo(b.getHeroAlias());
			}
			return freq2 - freq1;
		}
	};

	
	/*
	 * Override equals method that must return true if two Avenger objects have the same alias
	 */
	@Override
	public boolean equals(Object o) {
	if(o == this) { return true;}
	if(o == null) { return false; }
	if(this.getClass() != o.getClass()) { return false; }
	if(this.getHeroAlias() == ((Avenger) o).getHeroAlias()) { return true; }
	Avenger p = (Avenger)o;
	return this.getHeroAlias().equals(p.getHeroAlias());
	}
	
	//Getter for frequency
	public int getFrequency() {return frequency;}
	
	//Getter for hero name
	public String getHeroName() {return heroName;}
	
	//Getter for hero alias
	public String getHeroAlias() {return heroAlias;}
	
	//Increase frequency
	public void addFrequency() {frequency++;}
	
	/*
	 * String override to a specific format
	 */
	@Override
	public String toString() {
		return heroAlias + " aka " + heroName + " mentioned " + frequency + " time(s)";
	}
}
