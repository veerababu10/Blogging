package com.cg.blogging.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cg.blogging.dao.PostJPARepository;
import com.cg.blogging.entities.Blogger;
import com.cg.blogging.entities.Post;
import com.cg.blogging.exception.IdNotFoundException;

@Service
public class IPostServiceImpl implements IPostService{
	
	@Autowired
	private PostJPARepository  postRepo;

	@Override
	public Post addPost(Post post) throws IdNotFoundException {
		if(post.getTitle().length()==0)
		{
		  throw new IdNotFoundException("adding post failed,check your post details");
		}
		else {
			Post addPost=postRepo.save(post);
			return addPost;		
		}
	}

	@Override
	public Post updatePost(Post post) throws IdNotFoundException {
		Post existingPost=postRepo.findById(post.getPostId()).orElse(new Post());	
		if(existingPost.getPostId()!=0)
		{
		    return postRepo.save(post);
		}
		else
		{
		    throw new IdNotFoundException("post can not be updated.no post found");
		}
	}

	@Override
	public Post deletePost(int id) throws IdNotFoundException {
		Post deletedPost=postRepo.findById(id).orElse(new Post());
		if(deletedPost.getPostId()!=0) {
			postRepo.deleteById(id);
			return deletedPost;
		}
		else {
			    throw new IdNotFoundException("deletion failed,no post found with given id " +id);
			}
	}
		
	@Override
	public List<Post> getPostBySearchString(String searchStr) throws IdNotFoundException {
		List<Post> matchingPostsList=new ArrayList<Post>();
		matchingPostsList=postRepo.getPostBySearchString(searchStr);
		if(matchingPostsList.isEmpty()) {
			throw new IdNotFoundException("no posts found with given search string " +searchStr );
		}
		else {
			return matchingPostsList;
		}
	}

	