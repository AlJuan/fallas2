import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Rule {

    List<String> conditions;
    String result;

    private Rule (List<String> conditions, String result){
        this.conditions = conditions;
        this.result = result;
    }

    public static Rule of(String result, String... conditionsArray){
        return new Rule(Arrays.asList(conditionsArray), result);
    }


    public String run(){
        //TODO
        return "";
    }
}
