

public class Avenger implements Comparable<Avenger>{
    
    private String heroName;
    private String heroAlias;
    private int frequency;

    public Avenger(String heroName, String heroAlias) {
        this.heroName = heroName;
        this.heroAlias = heroAlias;
    }

    public String getHeroName() {
        return heroName;
    }

    public void setHeroName(String heroName) {
        this.heroName = heroName;
    }

    public String getHeroAlias() {
        return heroAlias;
    }

    public void setHeroAlias(String heroAlias) {
        this.heroAlias = heroAlias;
    }

    public int getFrequency() {
        return frequency;
    }

    public void setFrequency(int frequency) {
        this.frequency = frequency;
    }
    
    public void incrementFrequency(){
        this.frequency+=1;
    }

    @Override
    public int compareTo(Avenger avenger) {
        return this.getHeroName().compareTo(avenger.getHeroName());
    }
    
    
    
    public boolean equals(Avenger avenger) {
		return this.getHeroName().equals(avenger.getHeroName()) && this.getHeroAlias().equals(avenger.getHeroName());
	}

	@Override
	public String toString() { 
		String format = heroName + " aka " + heroAlias
                + " mentioned " + frequency + " time(s)";
		return format;
	}
}
