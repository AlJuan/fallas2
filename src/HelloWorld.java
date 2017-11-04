import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class HelloWorld {
    public static void main(String[] args) {

        //C1!
        List<String> facts = new ArrayList<>();
        facts.add("r");
        facts.add("p");
        facts.add("q");

        List<Rule> rules = buildRules();
        List<Rule> rulesHistory = new ArrayList<>();
        String result = inferenceLoop(facts, rules, rulesHistory);
        System.out.println(result);
        System.out.println(rulesHistory.isEmpty() ? "Did not run any rules" : "Rules: ");
        rulesHistory.stream().forEach(rule -> System.out.println(rule.toString()));
    }

    private static String inferenceLoop(List<String> facts, List<Rule> rules, List<Rule> rulesHistory) {
        //K = matching rules
        List<Rule> matchingRules = findMatchingRules(facts, rules, rulesHistory);
        String result = "no result found";
        while (!matchingRules.isEmpty()){
            Rule rule = selectRuleToRun(matchingRules);
            result = rule.run();
            rulesHistory.add(rule);
            facts.add(result);
            matchingRules = findMatchingRules(facts, rules, rulesHistory);
        }

        return result;
    }

    private static Rule selectRuleToRun(List<Rule> matchingRules) {
        //Choose R1 "Primera regla dispara"
        return matchingRules.get(0);
    }

    private static List<Rule> buildRules() {
        Rule[] rulesArray = {
                Rule.of("s", new String[]{"p", "q"}),
                Rule.of("t", new String[]{"r"}),
                Rule.of("u", new String[]{"s", "t"}),
                Rule.of("v", new String[]{"s", "r"}),
        };
        return Arrays.asList(rulesArray);

    }

    private static List<Rule> findMatchingRules(List<String> params, List<Rule> rules, List<Rule> alreadyRunRules) {
        return rules.stream()
                .filter(rule -> !alreadyRunRules.contains(rule)) //if it was not run...
                .filter(rule -> rule.matches(params)) //and it matches params
                .collect(Collectors.toList());
    }
}