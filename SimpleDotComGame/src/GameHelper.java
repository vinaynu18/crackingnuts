import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GameHelper {

    public String getUserInput(String enter_a_number) {
        String inputLine = null;
        System.out.println(enter_a_number + "  ");

        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        try {
            inputLine = buffer.readLine();
            if(inputLine.length() == 0){
                return null;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


        return inputLine;
    }
}
