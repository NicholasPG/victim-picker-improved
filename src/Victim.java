import java.util.ArrayList;
import java.util.Date;

/*State
    name: String - name of the Victim
    section: int - section the Victim is in
    score: int -Victim's score
    lastPicked: Date -The most recent Date that the victim was picked
    absences: ArrayList<Date> - list of absences on the Victims record
    numberOfPicks: int - number of times the victim has been picked
Behavior
    A Constructor with name and section coming in as arguments.
    A Constructor with all states coming in as arguments.
    Getters for all instance data
    Setters for lastPicked, score, numberOfPicks, and name
*/

public class Victim {

    private String name;
    private final int section;
    private int score;
    private Date lastPicked;
    private ArrayList<Date> absences;
    private int numberOfPicks;


    //Constructor with just name and section
    public Victim(String name, int section) {
        this.name = name;
        this.section = section;
        absences = new ArrayList<Date>();
    }

    //constructor with every state as a parameter
    public Victim(String name, int section, int score, Date lastPicked, ArrayList<Date> absences, int numberOfPicks) {
        this.name = name;
        this.section = section;
        this.score = score;
        this.lastPicked = lastPicked;
        this.absences = absences;
        this.numberOfPicks = numberOfPicks;
    }

    //GETTERS
    public String getName() {
        return name;
    }
    public int getSection() {
        return section;
    }
    public int getScore() {
        return score;
    }
    public Date getLastPicked() {
        return lastPicked;
    }
    public ArrayList<Date> getAbsences() {
        return absences;
    }
    public int getNumberOfPicks() {
        return numberOfPicks;
    }

    //SETTERS
    public void setName(String name) {
        this.name = name;
    }
    public void setScore(int score) {
        this.score = score;
    }
    public void setLastPicked(Date lastPicked) {
        this.lastPicked = lastPicked;
    }
    public void setNumberOfPicks(int numberOfPicks) {
        this.numberOfPicks = numberOfPicks;
    }
}
