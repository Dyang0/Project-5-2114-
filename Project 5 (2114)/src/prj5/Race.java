package prj5;

public class Race {
    private String raceName;
    private int cases;
    private int deathCount;

    public Race(String name, int c, int death) {
        raceName = name;
        cases = c;
        deathCount = death;
    }


    public String getRaceName() {
        return raceName;
    }


    public int getDeathCount() {
        return deathCount;
    }
    
    public int getCases() {
        return cases;
    }

}
