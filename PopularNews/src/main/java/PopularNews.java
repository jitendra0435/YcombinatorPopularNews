import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.*;

public class PopularNews extends Utility{


    public static void main(String[] args) {

        List<String> newsList = new ArrayList();
        List<Integer> scoreList = new ArrayList<>();


        System.setProperty("webdriver.chrome.driver", "/home/admin1/Documents/chromedriver/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://news.ycombinator.com/news");

        List<WebElement> newsElements = driver.findElements(By.cssSelector("a.storylink"));
        List<WebElement> scoreElements = driver.findElements(By.cssSelector("tr td span.score"));


        for (WebElement webElementHeader : newsElements) {

            System.out.println(webElementHeader.getText());
            newsList.add(webElementHeader.getText());
        }

        for (WebElement webElementPoints : scoreElements) {

            System.out.println(webElementPoints.getText().substring(0, webElementPoints.getText().length() - 7));
            scoreList.add(Integer.parseInt(webElementPoints.getText().substring(0, webElementPoints.getText().length() - 7)));
        }


        Map<String, Integer> newsHeaderMap = new HashMap<>();
        Iterator<String> newsIterator = newsList.iterator();
        Iterator<Integer> scorePointIterator = scoreList.iterator();

        while (newsIterator.hasNext() && scorePointIterator.hasNext()) {

            newsHeaderMap.put(newsIterator.next(), scorePointIterator.next());

        }

       newsHeaderMap.entrySet().stream().forEach(System.out::println);

        List<String> wordList = listOfWords(newsList);

        wordList.stream().forEach(System.out::println);

        Map<String, Integer> wordCountMap = findWordHavingMaxCount(wordList);
        String countWordInMap = getMaxCountWordInMap(wordCountMap);

        System.out.println("Word which repeating More Times:->" + countWordInMap);
        String popularNewsHeading = getPopularNewsAmongAll(newsHeaderMap, countWordInMap);

        System.out.println(popularNewsHeading);
    }
}

