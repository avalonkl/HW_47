package core;
import javax.xml.parsers.*;
import javax.xml.xpath.*;
import org.w3c.dom.Document;

public class DOMXPathParser {

    public static void main(String[] args) throws Throwable, Exception,
            ParserConfigurationException {

        String url = "http://alex.academy/ebay.xml";

        String[] xpath_element = {"//server/orig-kw", "//server/engine", "//server/kadu-version", "//response-time", "//deals/@count"};
        String[] elements = {"Key Word: \t ", "Engine: \t ", "Version: \t ", "Response time: \t ", "Number of deals: "};

        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

        DocumentBuilder db = dbf.newDocumentBuilder();

        Document doc = db.parse(url);

        doc.getDocumentElement().normalize();

        XPathFactory xPathfactory = XPathFactory.newInstance();
        XPath xpath = xPathfactory.newXPath();

        String element = "";
        for (int i = 0; i < 5; i++){
            element = xpath.compile(xpath_element[i]).evaluate(doc);
            System.out.println(elements[i] + element);
        }
    }
}
