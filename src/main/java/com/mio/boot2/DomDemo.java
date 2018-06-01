package com.mio.boot2;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class DomDemo {

	  public static void main(String[] args) {  
	        //1.获取jaxp工厂  
	        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();  
	        try {  
	            //2.获取解析器  
	            DocumentBuilder builder = factory.newDocumentBuilder();  
	            //3.用解析器加载xml文档--->Document  
	            Document document = builder.parse(new File("src/students.xml"));  
	            //4.获得所有学生集合  
	            NodeList studentList = document.getElementsByTagName("student");  
	            //5.遍历学生集合  
	            for(int i = 0; i < studentList.getLength(); i ++){  
	                //通过下标获得各个学生  
	                Element stuElm = (Element)studentList.item(i);  
	                //获取每个学生的学号属性  
	                String number = stuElm.getAttribute("number");  
	                System.out.println("学号:" + number);  
	                //获取每个学生下的所有子节点(包括空白)  
	                NodeList childrenList = stuElm.getChildNodes();  
	                //便利子节点集合获取元素  
	                int length = childrenList.getLength();  
	                for(int j = 0; j < length; j ++){  
	                    Node node = childrenList.item(j);  
	                    //判断子节点是不是element元素类型(因为遍历过程中会遍历出空格和换行)  
	                    if(node.getNodeType() == Node.ELEMENT_NODE){  
	                        Element child = (Element) node;  
	                        switch (child.getNodeName()) {  
	                        case "name":  
	                            String name = child.getTextContent();  
	                            System.out.println("姓名:" + name);  
	                            break;  
	                        case "age":  
	                            String age = child.getTextContent();  
	                            System.out.println("年龄:" + age);  
	                            break;  
	                        case "sex":  
	                            String sex = child.getTextContent();  
	                            System.out.println("性别:" + sex);  
	                            break;  
	                        default:  
	                            break;  
	                        }  
	                    }  
	                      
	                }  
	            }  
	        } catch (Exception e) {  
	            e.printStackTrace();  
	        }  
	    } 
}
