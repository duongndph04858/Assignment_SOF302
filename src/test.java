import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import controller.test1;
import model.entity.USERS;

public class test {
public static void main(String[] args) {
	USERS u = new USERS();
	u.checkLogin("123", "123");
}
}
