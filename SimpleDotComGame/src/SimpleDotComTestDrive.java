public class SimpleDotComTestDrive {

    public static void main(String[] args) {

        SimpleDotCom dot = new SimpleDotCom();
        int[] locationCells = {2,3,4};
        dot.setLocation(locationCells);
        String userGuess = "2";

        String result = dot.checkYourSelf(userGuess);

        String testResult = "failed";
        if(result.equals("hit")){
            testResult = "passed";
        }

        System.out.println(testResult);
    }
}
