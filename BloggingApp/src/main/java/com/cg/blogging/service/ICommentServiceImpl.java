package com.cg.blogging.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cg.blogging.dao.CommentJPARepository;

@Service
public class ICommentServiceImpl implements ICommentService{
	
	@Autowired
	private CommentJPARepository commentRepo;
	

}
