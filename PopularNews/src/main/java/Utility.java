import java.util.*;

public class Utility {


    //Method for separating words from all news

    static List<String> listOfWords(List<String> list) {

        List<String> words = new ArrayList<>();

        for (String s1 : list) {
            String[] arrOfWords = s1.split(" ");
            List<String> l1 = Arrays.asList(arrOfWords);
            words.addAll(l1);

        }

        return words;
    }

    //Method for getting news which is most popular

    public static  String getPopularNewsAmongAll(Map<String, Integer> mapData, String mostOccuredWord) {
        int value = 0;
        String mostPopular="";
        for (Map.Entry<String, Integer> val : mapData.entrySet()) {
            if (val.getKey().contains(mostOccuredWord )) {
                if ( val.getValue()>value){
                    value=val.getValue();
                    mostPopular=val.getKey();
                }
            }

        }
        System.out.println("Most populaR TEST DATA:"+mostPopular);
        return mostPopular;
    }


    //Method for printing words and its Occurances

    static Map<String, Integer> findWordHavingMaxCount(List<String> wordList) {

        Map<String, Integer> wordMap = new HashMap<>();
        for (String i : wordList) {
            Integer j = wordMap.get(i);
            wordMap.put(i, (j == null) ? 1 : j + 1);
        }
        wordMap.entrySet().stream().forEach(System.out::println);
        return wordMap;
    }


    //Method for Getting the word having maximum count

    public static String getMaxCountWordInMap(Map<String, Integer> countMap) {

        String key = "";
        Integer value = 0;

        // Occurances of elements

        for (Map.Entry<String, Integer> val : countMap.entrySet()) {
            if (val.getValue() > value) {
                value = val.getValue();
                key = val.getKey();
            }
            System.out.println("Word " + val.getKey() + " "
                    + "repeated"
                    + ": " + val.getValue() + " times");
        }
        return key;
    }

}
