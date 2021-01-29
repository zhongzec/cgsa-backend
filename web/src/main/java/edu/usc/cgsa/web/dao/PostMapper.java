package edu.usc.cgsa.web.dao;

import edu.usc.cgsa.web.model.Post;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Ronan
 * @email crnoogle@gmail.com
 * @date 5/16/20
 * @website
 */
@Mapper
@Repository
public interface PostMapper {

  Long createTable();

  Long insert(Post post);

  Long deleteById(Long id);

  Post findById(Long id);

  List<Post> findAll();

  List<Post> findByCategoryId(Long categoryId);
}
