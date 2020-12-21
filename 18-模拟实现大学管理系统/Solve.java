import java.io.*;
import javax.xml.parsers.*;
import org.w3c.dom.*;
import org.xml.sax.SAXException;

public class Solve {

    public static void main(String[] args) {
        try {
            //创建解析器工厂
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            //通过解析器工厂获得DOM解析器
            DocumentBuilder db = dbf.newDocumentBuilder();
            //解析指定XML文档，得到DOM节点树
            Document doc = db.parse("University.xml");
            //得到根节点
            NodeList vehicles = doc.getChildNodes();
            System.out.println("大学管理系统中共有" + vehicles.getLength() + "种人员类型！");
            System.out.println("分别为：");
            NodeList peopleList = doc.getElementsByTagName("University");
            for(int i = 0; i < peopleList.getLength(); i++){
                Node people = peopleList.item(i);
                for (Node node = people.getFirstChild(); node != null; node = node.getNextSibling()) {
                    //根据节点类型进行判断，显示元素节点信息，如 <oil>20</oil>
                    if (node.getNodeType() == Node.ELEMENT_NODE){
                        String name = node.getNodeName();
                        System.out.println("  " + name + "  ");
                    }
                }
            }
            //得到所有<student>节点列表信息
            NodeList studentList = doc.getElementsByTagName("student");
            System.out.println("大学管理系统中共有" + studentList.getLength() + "位学生！");
            //遍历所有学生
            for (int i = 0; i < studentList.getLength(); i++) {
                //获取索引为i的卡车
                Node student = studentList.item(i);
                //获取卡车属性值并显示
                Element element = (Element) student;
                String idValue = element.getAttribute("id");
                //以下通过属性名获得属性节点，再通过getNodeValue()获得属性值
                //Node attr = element.getAttributeNode("id");
                //String idValue = attr.getNodeValue();
                System.out.println("id 为" + idValue + "的学生信息为：");
                //获取索引为i的卡车详细信息并输出
                for (Node node = student.getFirstChild(); node != null; node = node.getNextSibling()) {
                    //根据节点类型进行判断，显示元素节点信息，如 <oil>20</oil>
                    if (node.getNodeType() == Node.ELEMENT_NODE){
                        //元素节点的节点名为标签名，如oil
                        String name = node.getNodeName();
                        //元素节点<oil>20</oil>下第一个子节点为文本节点20，得到节点值20
                        String value = node.getFirstChild().getNodeValue();
                        System.out.println("  " + name + "：" + value + "；");
                    }
                }
            }
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}