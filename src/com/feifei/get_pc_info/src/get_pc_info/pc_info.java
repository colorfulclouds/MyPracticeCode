package get_pc_info;

import java.net.InterfaceAddress;	//网络接口地址
import java.net.NetworkInterface;	//多播组的本地接口
import java.net.SocketException;	
import java.util.Enumeration;	//用来生成一系列的连续元素
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
    System.out.println("网卡名称： " + ni.getName());//获取此网络接口的名称。
    System.out.println("个性化的名字： " + ni.getDisplayName());//人可以看懂的名称
    
    if(ni.isUp())
    	System.out.println("网卡正在使用！");
    else
    	System.out.println("网卡没用使用！");
 
    if(ni.supportsMulticast())
    	System.out.println("这个网卡支持多播！");
    else
    	System.out.println("这个网卡不支持多播！");
    
    if(ni.isVirtual())
    	System.out.println("虚拟网卡！");
    else
    	System.out.println("不是虚拟网卡！");
    
    System.out.println(" MAX地址 ：" + ni.getHardwareAddress());
 
    System.out.println("这个网卡的一些详细信息：");
    List<InterfaceAddress> list = ni.getInterfaceAddresses();
    Iterator<InterfaceAddress> it = list.iterator();
 
    while (it.hasNext()) 
    {
      InterfaceAddress ia = it.next();
      System.out.println(" ip地址： " + ia.getAddress());
      System.out.println("广播地址：" + ia.getBroadcast());
      System.out.println("");
    }
    
  }
}
 

   