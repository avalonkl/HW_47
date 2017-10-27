package core;

import java.io.IOException;
import javax.xml.parsers.*;
import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;

public class SAXParser2 extends DefaultHandler {

    public static void main(String[] args) throws IOException, SAXException,
            ParserConfigurationException {
        String url = "http://alex.academy/ebay.xml";

        final String[] element = {"orig-kw", "engine", "kadu-version", "response-time", "deals"};
        final String attribute_01 = "count";

        SAXParserFactory f = SAXParserFactory.newInstance();

        SAXParser p = f.newSAXParser();

        DefaultHandler h = new DefaultHandler() {

            boolean handler[] = {false, false, false, false, false};
            String attribute_count = null;

            public void startElement(String a, String b, String c, Attributes d)
                    throws SAXException {

                for (int i = 0; i < 5; i++) {
                    if (c.equalsIgnoreCase(element[i])) {
                        handler[i] = true;
                    }
                }
                if (c.equalsIgnoreCase(element[4])) {
                    handler[4] = true;
                    attribute_count = d.getValue(attribute_01);
                }
            }

            public void endElement(String a, String b, String c)
                    throws SAXException {
            }

            public void characters(char ch[], int start, int length)
                    throws SAXException {

                if (handler[0]) {
                    System.out.println("Key Word: \t " + new String(ch, start, length));
                    handler[0] = false;
                }
                if (handler[1]) {
                    System.out.println("Engine: \t " + new String(ch, start, length));
                    handler[1] = false;
                }
                if (handler[2]) {
                    System.out.println("Version: \t " + new String(ch, start, length));
                    handler[2] = false;
                }
                if (handler[3]) {
                    System.out.println("Response time:\t " + new String(ch, start, length));
                    handler[3] = false;
                }

                if (handler[4]) {
                    System.out.println("Number of deals: " + attribute_count);
                    handler[4] = false;
                }
            }
        };
        p.parse(url, h);
    }
}
