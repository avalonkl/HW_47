package core;

import java.io.*;
import java.net.URL;
import javax.xml.stream.*;

public class StAXParser {
    public static void main(String[] args) throws XMLStreamException, IOException {

        URL url = new URL("http://alex.academy/ebay.xml");

        final String[] element = {"orig-kw", "engine", "kadu-version", "response-time", "deals"};

        InputStream in = url.openStream();

        XMLInputFactory factory = XMLInputFactory.newInstance();
        XMLStreamReader reader = factory.createXMLStreamReader(in);
        int eventType = reader.getEventType();

        while (reader.hasNext()) {

            eventType = reader.next();

            if (eventType == XMLStreamReader.START_ELEMENT) {
                if (reader.getLocalName() == element[0]) {
                    System.out.println("Key Word: \t " + reader.getElementText());
                }
                if (reader.getLocalName() == element[1]) {
                    System.out.println("Engine: \t " + reader.getElementText());
                }
                if (reader.getLocalName() == element[2]) {
                    System.out.println("Version: \t " + reader.getElementText());
                }
                if (reader.getLocalName() == element[3]) {
                    System.out.println("Response time: \t " + reader.getElementText());
                }
                if (reader.getLocalName() == element[4]) {
                    System.out.println("Number of deals: " + reader.getAttributeValue(0));
                }
            }
        }
    }
}
