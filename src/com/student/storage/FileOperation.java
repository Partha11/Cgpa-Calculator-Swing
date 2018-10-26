package com.student.storage;

import com.student.models.*;
import java.io.*;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.*;
import javax.xml.transform.stream.*;
import org.xml.sax.*;
import org.w3c.dom.*;

public class FileOperation {

	public static final String FILENAME = "studentinfo.xml";
    
    public boolean isFileAvailable() {
    	
    	File tmp = new File(FILENAME);
    	boolean ifExists = false;
    	
    	if (tmp.exists()) {
    		
    		if (tmp.isDirectory())
    			
    			ifExists = false;
    		
    		else
    			
    			ifExists = true;
    	}
    	
    	return ifExists;
    }

    public StudentInfo readFile() {

        File xmlFile = new File(FILENAME);
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder;
        StudentInfo studentInfo;
        
        try {

            dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(xmlFile);
            doc.getDocumentElement().normalize();

            NodeList nodeList = doc.getElementsByTagName("student");
            studentInfo = getStudent(nodeList.item(0));
        } 
        
        catch (SAXException | ParserConfigurationException | IOException e1) {
            
            studentInfo = null;
            e1.printStackTrace();
        }

        return studentInfo;
    }

    private static StudentInfo getStudent(Node node) {
        
        StudentInfo studentInfo;

        String name = "";
        String batch = "";
        String regNo = "";
        String session = "";
        
        if (node.getNodeType() == Node.ELEMENT_NODE) {

            Element element = (Element) node;
            name = getTagValue("name", element);
            batch = getTagValue("batch", element);
            regNo = getTagValue("regNo", element);
            session = getTagValue("session", element);
        }

        studentInfo = new StudentInfo(regNo, session, name, batch);

        return studentInfo;
    }


    private static String getTagValue(String tag, Element element) {

        NodeList nodeList = element.getElementsByTagName(tag).item(0).getChildNodes();
        Node node = (Node) nodeList.item(0);
        
        return node.getNodeValue();
    }

    public void writeFile(StudentInfo studentInfo) {

        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder;

        try {
            
            documentBuilder = documentBuilderFactory.newDocumentBuilder();
            Document doc = documentBuilder.newDocument();
            Element mainRootElement = doc.createElementNS("https://tiptoptips.info", "student");
            doc.appendChild(mainRootElement);
 
            // append child elements to root element
            mainRootElement.appendChild(getStudent(doc, "1", 
                                                        studentInfo.getStudentName(), studentInfo.getStudentBatch(), 
                                                        studentInfo.getStudentRegNo(),
                                                        studentInfo.getStudentSession()));
 
            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes"); 
            DOMSource input = new DOMSource(doc);
            Result output = new StreamResult(new File(FILENAME));
            transformer.transform(input, output);
        } 
        
        catch (Exception e) {
            
            e.printStackTrace();
        }
    }

    private static Node getStudent(Document doc, String id, String name, String batch, String regNo, String session) {
        
        Element student = doc.createElement("info");
        student.setAttribute("id", id);
        student.appendChild(getStudentElement(doc, student, "name", name));
        student.appendChild(getStudentElement(doc, student, "batch", batch));
        student.appendChild(getStudentElement(doc, student, "regNo", regNo));
        student.appendChild(getStudentElement(doc, student, "session", session));

        return student;
    }
 
    // utility method to create text node
    private static Node getStudentElement(Document doc, Element element, String name, String value) {
        
        Element node = doc.createElement(name);
        node.appendChild(doc.createTextNode(value));
        return node;
    }
}