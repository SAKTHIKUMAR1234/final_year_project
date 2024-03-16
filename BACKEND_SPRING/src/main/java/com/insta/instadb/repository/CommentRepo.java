package com.insta.instadb.repository;

import com.insta.instadb.entity.Comments;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepo extends JpaRepository<Comments, Long> {

    List<Comments> findAllByMedia_Id(Long id);
}
