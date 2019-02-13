public class SimpleDotComGame {

    public static void main(String[] args) {
        SimpleDotCom dot = new SimpleDotCom();
        int numOfGuesses = 0;

        GameHelper helper = new GameHelper();
        int number = (int)Math.random()*5;
        int[] locations = {number, number+1, number+2};
        dot.setLocation(locations);
        boolean gameIsAlive = true;

        while(gameIsAlive == true){
            String guess = helper.getUserInput("Enter a number");
            String result = dot.checkYourSelf(guess);
            numOfGuesses++;
            if(result.equals("kill")){
                gameIsAlive = false;
                System.out.println("you have made "+ numOfGuesses + " of Guesses");
            }
        }


    }
}
