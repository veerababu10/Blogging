package com.cg.blogging.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cg.blogging.dao.AdminJPARepository;

@Service
public class IAdminServiceImpl implements IAdminService{
	
	@Autowired
	private AdminJPARepository adminRepo;
	
	

}
