package com.cg.blogging.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cg.blogging.entities.Post;

@Repository
public interface PostJPARepository extends JpaRepository<Post,Integer>{
	
	@Query(value="select * from post where title LIKE %?1%",nativeQuery=true )
	public List<Post> getPostBySearchString(String searchStr);
	@Query(value="select * from post where blogger_id=?1")
	public List<Post> getPostByBlogger(int bloggerId);
	@Query(value="update post set upvote=?1 where post_id=?2")
	public void upVote(boolean upVote,int post_id);
	

}
