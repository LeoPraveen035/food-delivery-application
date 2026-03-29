import java.util.List;

import com.tap.dao.UserDAO;
import com.tap.daoimpl.UserDAOImpl;
import com.tap.model.User;

public class Launch {

	public static void main(String[] args) {
		
		
		UserDAO impl = new UserDAOImpl();
		List<User> user = impl.getAllUser();
		
		for(User u: user) {
			System.out.println(u);
		}
		
		

	}

}
