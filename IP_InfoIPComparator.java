package Algorithm;

import java.util.Comparator;

public class IP_InfoIPComparator implements Comparator<IP_Info> {

	@Override
	public int compare(IP_Info o1, IP_Info o2) {
		
		if(o1 == null || o2 == null)
			return 0;
		
		String ip1 = o1.getIP();
		String th1 = o1.getTime_half1();
		String th2 = o1.getTime_half2();
		
		String ip2 = o2.getIP();
		String ht1 = o2.getTime_half1();
		String ht2 = o2.getTime_half2();
		
		if(ip1.equalsIgnoreCase(ip2)) {
			if(th1.equalsIgnoreCase(ht1)) {
				return th2.compareToIgnoreCase(ht2);
			}
			return th1.compareToIgnoreCase(ht1);
		}
		return ip1.compareToIgnoreCase(ip2);
	}
}
