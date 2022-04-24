package get_pc_info;

import java.net.InterfaceAddress;	//����ӿڵ�ַ
import java.net.NetworkInterface;	//�ಥ��ı��ؽӿ�
import java.net.SocketException;	
import java.util.Enumeration;	//��������һϵ�е�����Ԫ��
import java.util.Iterator;
import java.util.List;
 
public class pc_info 
{
  public static void main(String[] args) throws Exception 
  {
    Enumeration<NetworkInterface> en = NetworkInterface.getNetworkInterfaces();
    
    while (en.hasMoreElements()) 
    {
      NetworkInterface ni = en.nextElement();
      printParameter(ni);
 
    }
  }
 
  public static void printParameter(NetworkInterface ni) throws SocketException 
  {
    System.out.println("�������ƣ� " + ni.getName());//��ȡ������ӿڵ����ơ�
    System.out.println("���Ի������֣� " + ni.getDisplayName());//�˿��Կ���������
    
    if(ni.isUp())
    	System.out.println("��������ʹ�ã�");
    else
    	System.out.println("����û��ʹ�ã�");
 
    if(ni.supportsMulticast())
    	System.out.println("�������֧�ֶಥ��");
    else
    	System.out.println("���������֧�ֶಥ��");
    
    if(ni.isVirtual())
    	System.out.println("����������");
    else
    	System.out.println("��������������");
    
    System.out.println(" MAX��ַ ��" + ni.getHardwareAddress());
 
    System.out.println("���������һЩ��ϸ��Ϣ��");
    List<InterfaceAddress> list = ni.getInterfaceAddresses();
    Iterator<InterfaceAddress> it = list.iterator();
 
    while (it.hasNext()) 
    {
      InterfaceAddress ia = it.next();
      System.out.println(" ip��ַ�� " + ia.getAddress());
      System.out.println("�㲥��ַ��" + ia.getBroadcast());
      System.out.println("");
    }
    
  }
}
 

   