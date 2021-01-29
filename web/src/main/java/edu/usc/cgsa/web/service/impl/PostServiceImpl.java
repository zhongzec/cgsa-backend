package edu.usc.cgsa.web.service.impl;

import edu.usc.cgsa.web.dao.PostMapper;
import edu.usc.cgsa.web.model.Post;
import edu.usc.cgsa.web.service.PostService;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

/**
 * @author Ronan
 * @email crnoogle@gmail.com
 * @date 8/25/20
 * @website
 */
@Service
public class PostServiceImpl implements PostService {

  private final PostMapper postMapper;

  public PostServiceImpl(PostMapper postMapper) {
    this.postMapper = postMapper;
    postMapper.createTable();
  }

  @Override
  public Long insert(Post post) {
    return postMapper.insert(post);
  }

  @Override
  public Long deleteById(Long id) {
    return postMapper.deleteById(id);
  }

  @Override
  public Post findById(Long id) {
    return postMapper.findById(id);
  }

  @Override
  public List<Post> findAll() {
    return postMapper.findAll();
  }

  @Override
  public List<Post> findByCategoryId(Long categoryId) throws SQLException {
    return postMapper.findByCategoryId(categoryId);
  }
}
