package com.cg.blogging.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cg.blogging.dao.BloggerJPARepository;


@Service
public class IBloggerServiceImpl implements IBloggerService{
	
	@Autowired
	private BloggerJPARepository bloggerRepo;
	

}
