package Sandbox;

import org.htmlcleaner.CleanerProperties;
import org.htmlcleaner.DomSerializer;
import org.htmlcleaner.HtmlCleaner;
import org.htmlcleaner.TagNode;
import org.w3c.dom.Document;

import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathFactory;
import java.net.URL;

public class HtmlParcer {
    public static void main(String[] args) throws Exception{
        URL url = new URL("http://www.luxoft.com/careers/54768/java-developer/");
//        HttpURLConnection con = (HttpURLConnection) url.openConnection();
//        con.setRequestMethod("GET");
//        con.connect();
//
//        InputStream is = con.getInputStream();
//        BufferedReader br = new BufferedReader(new InputStreamReader(is));
//
//        String s;
//        StringBuilder stringBuilder = new StringBuilder();
//        while ((s = br.readLine()) != null) {
//            stringBuilder.append(s);
//        }


        HtmlCleaner cleaner = new HtmlCleaner();
        TagNode node = cleaner.clean(url);
        Document doc = new DomSerializer(new CleanerProperties()).createDOM(node);

        XPath xPath = XPathFactory.newInstance().newXPath();

        String findTitle = "//h2[contains(@class, 'mobile-back-after blue-title')]/text()";
        String str = xPath.evaluate(findTitle, doc);
        System.out.println(str);

        String findCity = "//span[contains(@itemprop, 'addressLocality')]/text()";
        str = xPath.evaluate(findCity, doc);
        System.out.println(str);

        String findDescription = "//div[contains(@span, 'addressLocality')]/text()";
        str = xPath.evaluate(findDescription, doc);
        System.out.println(str);
    }
}
