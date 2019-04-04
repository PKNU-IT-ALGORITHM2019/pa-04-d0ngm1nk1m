package Algorithm;

public class IP_Info implements Comparable <IP_Info> {

	String IP;
	String Time;
	String URL;
	String Status;
	String Time_half1;
	String Time_half2;
	int num = 0;

	public IP_Info(String ip, String t, String u, String s) {
		IP = new String(ip);
		Time = new String(t);
		URL = new String(u);
		Status = new String(s);
		String []mon = {"Jan","Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
		int num1 = Time.indexOf("/");
		int num2 = Time.indexOf("/", num1 + 1);
		int num3 = Time.indexOf(":");
		String date = Time.substring(0, num1);
		String month = Time.substring(num1 + 1, num2);
		String year = Time.substring(num2 + 1, num3);
		String time = Time.substring(num3 + 1);
		for(int i = 0; i < 12; i++)
			if(month.equalsIgnoreCase(mon[i])) {
				month = Integer.toString(i + 1);
				Time_half1 = new String(year.concat(month));
				Time_half1 = new String(Time_half1.concat(date));
				Time_half2 = new String(time);
				break;
			}
	}
	
	public String getIP() {
		return IP;
	}
	
	public String getTime_half1() {
		return Time_half1;
	}
	
	public String getTime_half2() {
		return Time_half2;
	}

	@Override
	public int compareTo(IP_Info o) {
		if(this.Time_half1.equalsIgnoreCase(o.Time_half1))
			return this.Time_half2.compareToIgnoreCase(o.Time_half2);
		return this.Time_half1.compareToIgnoreCase(o.Time_half1);
	}

}
