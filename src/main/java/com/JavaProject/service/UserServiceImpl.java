package com.JavaProject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.JavaProject.entity.User;
import com.JavaProject.repository.UserRepo;
import com.JavaProject.factory.RepositoryFactory;

import jakarta.servlet.http.HttpSession;

@Service
public class UserServiceImpl implements UserService {
	private final RepositoryFactory repositoryFactory;
	@Autowired
	private UserRepo userRepo;

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	@Autowired
    public UserServiceImpl(RepositoryFactory repositoryFactory) {
        this.repositoryFactory = repositoryFactory;
    }
	@Override
	public User saveUser(User user) {

		String password=passwordEncoder.encode(user.getPassword());
		user.setPassword(password);
		user.setRole("ROLE_USER");
		UserRepo userRepo = repositoryFactory.createUserRepo();
        
		User newuser = userRepo.save(user);

		return newuser;
	}

	@Override
	public void removeSessionMessage() {

		HttpSession session = ((ServletRequestAttributes) (RequestContextHolder.getRequestAttributes())).getRequest()
				.getSession();

		session.removeAttribute("msg");
	}
	@Override
    public User getUserByEmail(String email) {
        return userRepo.findByEmail(email);
    }

}
