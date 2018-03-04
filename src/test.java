import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

public class test {
	@Autowired
	static
	HashMap<Integer, String> h;
public static void main(String[] args) {
	 Map<Integer, String> gioitinh = h;
	gioitinh.put(1, "Nữ");
	gioitinh.put(0, "Nam");
System.out.println(gioitinh.values());
}
}
