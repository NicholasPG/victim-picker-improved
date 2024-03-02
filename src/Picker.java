import java.util.ArrayList;
import java.util.Date;

/*
State
    victims: ArrayList<Victim> - stores all the victims that can be picked from
    pickedToday: ArrayList<Victim> - stores the list of victims that have been picked that day
    absentToday: ArrayList<Victim> - stores the list of victims that have been marked absent for that day

Behavior
    getPickedToday() - returns pickedToday ArrayList
    getAbsentToday() - returns absentToday ArrayList

    loadList(ArrayList<Victim>): loads victim list passed in as the victims ArrayList
                                         that is used to select victims

    resetPickedVictims() - clears the pickedToday ArrayList

    markAbsent(Victim) - adds the absent victim to the absentToday ArrayList,
                                      removes them from the pickedToday ArrayList, and
                                      sets today's date as an absence in the victim's object

    score(int) - adds number of points (passed in as argument) and increments the number of times picked for each
                        victim in the pickedToday ArrayList

    chooseOne() - picks one victim, adds them to the pickedToday ArrayList, and returns the victim

    chooseTwo() - picks two unique victims, adds them to the pickedToday ArrayList, and returns that list
 */

public class Picker {

    private ArrayList<Victim> victims;
    private ArrayList<Victim> pickedToday;
    private ArrayList<Victim> absentToday;

    //CONSTRUCTOR
    public Picker() {
        victims = new ArrayList<Victim>();
        pickedToday = new ArrayList<Victim>();
        absentToday = new ArrayList<Victim>();
    }

    //GETTERS
    public ArrayList<Victim> getPickedToday() {
        return pickedToday;
    }
    public ArrayList<Victim> getAbsentToday() {
        return absentToday;
    }

    /**
     * Pass in ArrayList of victims to load them into the victims ArrayList.
     */
    public void loadList(ArrayList<Victim> victims) {
        this.victims = victims;
    }

    /**
     * clears the pickedVictims ArrayList and adds 1 to the numberOfPicks variable ands sets today's date as
     * the lastPicked variable for each victim.
     */
    public void resetPickedVictims() {
        if (!pickedToday.isEmpty()) {
            //increases victim's numOfPicks
            pickedToday.getFirst().setNumberOfPicks(pickedToday.getFirst().getNumberOfPicks() + 1);
            //sets the victim's lastPicked to the current date
            pickedToday.getFirst().setLastPicked(new Date());
        }
        //empties the pickedToday ArrayList
        pickedToday.clear();
    }

    /**
     * pass in the absent victim to add them to the absentToday ArrayList, add this absence to their unique object,
     * and remove them from the pickedToday ArrayList.
     * @param absentVictim the Victim that is absent
    */
    public void markAbsent(Victim absentVictim) {
        //adds absent victim to the list of absent victims
        absentToday.add(absentVictim);
        //Removes the absent victim from the list of picked victims
        pickedToday.remove(absentVictim);
        //adds today's date to the list of victim's absences
        absentVictim.getAbsences().add(new Date());
    }

    /**
     * pass in the number of points to add it to the score of each Victim in the pickedToday ArrayList.
     * @param points the number of points added to each victims score
     */
    public void score(int points) {
        for (Victim victim : pickedToday) {
            //increases victim's score
            victim.setScore(victim.getScore() + points);
        }
    }

    /**
     * Picks one random victim with the lowest number of picks, adds them to the pickedToday ArrayList, and returns
     * the picked Victim.
     * @return The Victim that was picked
     */
   public Victim chooseOne() {
        ArrayList<Victim> validPicks = new ArrayList<Victim>();

        //Finds the lowest number of picks among all victims
        int minPicks = 999;
        for (Victim victim : victims) {
            if (pickedToday.contains(victim) || absentToday.contains(victim)) {
                continue;
            }
            if (victim.getNumberOfPicks() < minPicks) {
                minPicks = victim.getNumberOfPicks();
            }
        }
        //creates list of all valid victims based on number of times picked
        for (Victim victim : victims) {
            if (victim.getNumberOfPicks() == minPicks && !pickedToday.contains(victim) && !absentToday.contains(victim)) {
                validPicks.add(victim);
            }
        }
        //Picks one random victim from the valid victims ArrayList
        int victimIndex = (int)(Math.random() * validPicks.size());

        //adds victim to pickedToday ArrayList
        pickedToday.add(validPicks.get(victimIndex));
        //returns Victim picked
        return validPicks.get(victimIndex);
    }

    /**
     * Picks Two random victims with the lowest number of picks, adds them to the pickedToday ArrayList, and returns
     * the two picked Victims in an ArrayList.
     * @return The two victims that were picked
     */
    public ArrayList<Victim> chooseTwo() {
        ArrayList<Victim> picked = new ArrayList<Victim>();
        //picks two individual students
        picked.add(chooseOne());
        picked.add(chooseOne());
        //returns array of picked students
        return picked;
    }

    public ArrayList<Victim> getVictims() {
        return victims;
    }
}
