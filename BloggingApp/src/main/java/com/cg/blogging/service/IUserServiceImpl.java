package com.cg.blogging.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cg.blogging.dao.UserJPARepository;

@Service
public class IUserServiceImpl {
	
	@Autowired
	private UserJPARepository userRepo;

}
