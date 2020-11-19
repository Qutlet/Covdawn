package com.example.covdown.data;

import android.content.Context;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import java.io.InputStream;
import java.util.ArrayList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

public class BazaSzpitali {

    private static BazaSzpitali self = new BazaSzpitali();
    public static BazaSzpitali get() {return self;}

    private ArrayList<Szpital> szpitale = new ArrayList<>(4);

    public void getSzpitale(Context context,String zadWoj) {
        try {
            szpitale.clear();
            InputStream path = context.getAssets().open("szpitale.xml");
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(path);
            doc.getDocumentElement().normalize();
            NodeList nodeList = doc.getElementsByTagName("wojewodzctwo");

            for (int itr = 0; itr < nodeList.getLength(); itr++) {
                Node node = nodeList.item(itr);
                if (node.getAttributes().getNamedItem("name").getNodeValue().equals(zadWoj)){


                        Element woj = (Element) node;
                        NodeList szpitalLista = woj.getElementsByTagName("szpital");


                        for (int i = 0; i < szpitalLista.getLength(); i++) {
                            Node szpital = szpitalLista.item(i);

                            if (node.getNodeType() == Node.ELEMENT_NODE) {
                                Element eElement = (Element) szpital;

                                szpitale.add(i,new Szpital(eElement.getElementsByTagName("nazwa").item(0).getTextContent(),
                                        eElement.getElementsByTagName("numer").item(0).getTextContent(),
                                        eElement.getElementsByTagName("latitude").item(0).getTextContent(),
                                        eElement.getElementsByTagName("longitude").item(0).getTextContent()));

                            }
                        }





                }
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Szpital getSzpitale(int index) {
        return szpitale.get(index);
    }


}
