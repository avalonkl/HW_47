package core;

import javax.xml.parsers.*;
import org.w3c.dom.*;


public class DOMParser {

    public static void main(String[] args) throws Throwable, Exception,
            ParserConfigurationException {

        String url = "http://alex.academy/ebay.xml";

        String node = "kadu-response";

        String[][] elements = {
                {"Key Word: \t ", "orig-kw"},
                {"Engine: \t ", "engine"},
                {"Version: \t ", "kadu-version"},
                {"Response time: \t ", "response-time"},
                {"Number of deals: ", "deals"}
        };
        String attribute = "count";

        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

        DocumentBuilder db = dbf.newDocumentBuilder();

        Document doc = db.parse(url);

        doc.getDocumentElement().normalize();

        for (int i = 0; i < 4; i++){
            System.out.println(elements[i][0]
                    + ((Element) doc.getElementsByTagName(node).item(0)).getElementsByTagName(elements[i][1]).item(0)
                    .getChildNodes().item(0).getNodeValue());
        }

        System.out.println(elements[4][0]
                + ((Element) doc.getElementsByTagName(elements[4][1]).item(0)).getAttribute(attribute).trim());
    }
}