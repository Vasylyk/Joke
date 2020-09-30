import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.net.URL;

public class Joke {

    private static Document getPage() throws IOException {
        String url = "http://anekdotov.net/";
        Document page = Jsoup.parse(new URL(url), 3000);
        return page;
    }

    public static void main(String[] args) throws IOException {
        Document page = getPage();
        Elements jokes = page.select("div[class=anekdot]");
        int numberOfJokes = jokes.size();
        int randomJoke = (int) (Math.random()*numberOfJokes);
        System.out.println(jokes.eq(randomJoke).text());

    }
}
