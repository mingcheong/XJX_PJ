package com.safetys.zhjg.statistic.util;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.safetys.framework.system.model.FkAreaModel;

public class ImpAreaXml {
	
	@SuppressWarnings("unchecked")
	public List<FkAreaModel> getChildren(List<Element> elements){
		List<FkAreaModel> as = new ArrayList<FkAreaModel>();
        for(int i = 0 ; i<elements.size();i++){  
            /**取得节点名字*/  
            /**遍历循环获取根节点下的所有属性*/  
            List<Attribute> list = elements.get(i).attributes();  
            FkAreaModel a = new FkAreaModel();
            for(Attribute a2 :list){
                /**getName获取属性名，getValue获取属性值*/  
                if(a2.getName().equals("id")){
                	a.setAreaCode(a2.getValue().trim());
                }
                if(a2.getName().equals("name")){
                	a.setAreaName(a2.getValue().trim());
                }
            }
            List<Element> children = elements.get(i).elements();
            if(children!=null&&children.size()>0){
            	a.setChildren(getChildren(children));
            }
            as.add(a);
        }
		return as;
	}
	
	@SuppressWarnings({ "unchecked" })  
    public List<FkAreaModel> readXML(String path) throws IOException{  
		List<FkAreaModel> as = new ArrayList<FkAreaModel>();
        StringBuilder sb = new StringBuilder();  
        try {  
            /**创建一个SAXReader对象*/  
            SAXReader saxReader = new SAXReader();  
            /**读取XML文件*/  
            Document document = saxReader.read(new File(path));  
            /**读取文件的第一个根节点*/  
            Element root = document.getRootElement();  
            /**第一个根节点的名字*/  
            sb.append("<"+root.getName());  
              
            /**遍历循环获取根节点下的所有属性*/  
            List<Attribute> a1list = root.attributes();  
            for(Attribute a : a1list){  
                /**getName获取属性名，getValue获取属性值*/  
                sb.append(" "+a.getName()+"=\""+a.getValue()+"\"");  
            }  
              
                  
            sb.append(">/n");  
            /**取得root节点下面的节点*/  
            List<Element> list = root.elements();
            for(int i = 0 ; i<list.size();i++){  
                /**取得节点名字*/  
//                sb.append("/t<"+list.get(i).getName());  
                /**遍历循环获取根节点下的所有属性*/  
                List<Attribute> l2list = list.get(i).attributes();  
                FkAreaModel a = new FkAreaModel();
                for(Attribute a2 :l2list){  
                    /**getName获取属性名，getValue获取属性值*/  
                    if(a2.getName().equals("id")){
                    	a.setAreaCode(a2.getValue().trim());
                    }
                    if(a2.getName().equals("name")){
                    	a.setAreaName(a2.getValue().trim());
                    }
                } 
                
                  
                List<Element> rl = list.get(i).elements();
                if(rl!=null&&rl.size()>0){
                	a.setChildren(getChildren(rl));
                }
                as.add(a);
            }  
        } catch (Exception e) {  
            System.out.println("error");  
        }  
//        return sb.toString();
        return as;
    }  
	/**mian函数*/  
    public static void main(String[] args) {  
//        ImpAreaXml d = new ImpAreaXml();  
//        String out;
//		try {
//			out = d.readXML("D://项目包//滁州//city.xml");
//			System.out.println(out);  
//		} catch (IOException e) {
//			e.printStackTrace();
//		}  
    }  
}
