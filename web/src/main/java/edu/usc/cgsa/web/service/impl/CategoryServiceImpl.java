package edu.usc.cgsa.web.service.impl;

import edu.usc.cgsa.web.dao.CategoryMapper;
import edu.usc.cgsa.web.model.Category;
import edu.usc.cgsa.web.service.CategoryService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Ronan
 * @email crnoogle@gmail.com
 * @date 8/25/20
 * @website
 */
@Service
public class CategoryServiceImpl implements CategoryService {

  private final CategoryMapper catMapper;

  public CategoryServiceImpl(CategoryMapper catMapper) {
    this.catMapper = catMapper;
    catMapper.createTable();
  }

  @Override
  public Long insert(Category category) {
    return catMapper.insert(category);
  }

  @Override
  public Long deleteById(Long id) {
    return catMapper.deleteById(id);
  }

  @Override
  public Category findById(Long id) {
    return catMapper.findById(id);
  }

  @Override
  public List<Category> findAll() {
    return catMapper.findAll();
  }

  @Override
  public List<Category> findAllByType(String type) {
    return catMapper.findAllByType(type);
  }
}
