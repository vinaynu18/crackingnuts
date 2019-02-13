public class SimpleDotCom {
    private int[] locationCells;
    private int numOfHits=0;

    public String checkYourSelf(String userGuess) {

        int guess = Integer.parseInt(userGuess);
        String result = "miss";
        for(int cell : locationCells){
            if(guess == cell){
                result = "hit";
                numOfHits++;
                break;
            }
        }
        if(numOfHits == locationCells.length){
            result = "kill";
        }
        System.out.println(result);
        return result;
    }

    public void setLocation(int[] locationCells) {
        this.locationCells = locationCells;
    }
}
