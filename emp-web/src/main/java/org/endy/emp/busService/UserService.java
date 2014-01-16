package org.endy.emp.busService;

import javax.inject.Inject;

import org.endy.emp.daoService.UserDaoService;
import org.endy.emp.domain.User;
import org.endy.emp.security.BCrypt;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserService {
	
	@Inject
	private UserDaoService userDao;
	
	public void registUser(User user){
		//用户密码加密
		String salt = BCrypt.gensalt(12);
		user.setPassword(BCrypt.hashpw(user.getPassword(), salt));
		user.setUserType(1);
		user.setUserState(0);
		userDao.addUser(user);
	}
	
	public User login(String userName,String password){
		User user = userDao.queryUser(userName);
		if(user != null && BCrypt.checkpw(password, user.getPassword())){
			user.setPassword("");
			return user;
		};
		return null;
	}

}
