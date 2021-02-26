package com.cg.blogging.service;

import java.util.List;

import com.cg.blogging.entities.Blogger;
import com.cg.blogging.entities.Post;
import com.cg.blogging.exception.IdNotFoundException;

public interface IPostService {
	
    public Post addPost(Post post) throws IdNotFoundException;
	public Post updatePost(Post post) throws IdNotFoundException;
	public Post deletePost(int id) throws IdNotFoundException;
	public List<Post> getPostBySearchString(String searchStr) throws IdNotFoundException;
	public List<Post> getPostByBlogger(Blogger blogger) throws IdNotFoundException;
	public void upVote(boolean upVote,Post post);
	

}
