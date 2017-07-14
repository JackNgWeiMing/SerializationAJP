package Practical7;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Acer
 */
public class DataAnalysis {

    private static final String REGEX_NRIC = "S\\d{7}[a-zA-Z]";
    private static final String REGEX_PRICE = "\\$\\d+(.\\d{1,2})?";
    private static Pattern patternNric;
    private static Pattern patternPrice;

    static {
        patternNric = Pattern.compile(REGEX_NRIC);
        patternPrice = Pattern.compile(REGEX_PRICE);
    }

    public static ArrayList<String> matchNric(String input) {
        ArrayList<String> resultList = new ArrayList<>();
        Matcher matcher = patternNric.matcher(input);
        while (matcher.find()) {
            resultList.add(matcher.group());
        }
//        System.out.println(resultList);
        return resultList;
    }

    public static ArrayList<Double> matchPrice(String input) {
        ArrayList<Double> resultList = new ArrayList<>();
        Matcher matcher = patternPrice.matcher(input);
        while (matcher.find()) {
            resultList.add(Double.parseDouble(matcher.group().substring(1)));
        }
//        System.out.println(resultList);
        return resultList;
    }

    public static void main(String[] args) {

        String inputText = "S1234567A $10\n"
                + "S2344779Z $20.50\n"
                + "T1238B $10.5\n"
                + "P11Z 11";
        Double sum = 0.0;
        ArrayList<String> nric = matchNric(inputText);
        ArrayList<Double> price = matchPrice(inputText);

        System.out.println(nric);
        for (Double d : price) {
            sum += d;
        }

        System.out.println(sum);
    }
}
