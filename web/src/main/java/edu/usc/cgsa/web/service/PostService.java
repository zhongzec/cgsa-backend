package edu.usc.cgsa.web.service;

import edu.usc.cgsa.web.model.Post;

import java.sql.SQLException;
import java.util.List;

/**
 * @author Ronan
 * @email crnoogle@gmail.com
 * @date 5/16/20
 * @website
 */
public interface PostService {

  Long insert(Post post) throws SQLException;

  Long deleteById(Long id) throws SQLException;

  Post findById(Long id) throws SQLException;

  List<Post> findAll() throws SQLException;

  List<Post> findByCategoryId(Long categoryId) throws SQLException;
}
