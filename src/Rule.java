import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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


    public boolean matches(List<String> facts){
        //Hay que revisar esto TODO
        //Si todas las condiciones estan contenidas en los hechos, entonces matchea
        return conditions.stream().allMatch(condition -> facts.contains(condition));
    }

    public String run(){
        return result;
    }

    @Override
    public String toString(){
        return conditions.stream().collect(Collectors.joining(", ")) + " -> " + result;
    }
}
