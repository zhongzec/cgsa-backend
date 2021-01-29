package edu.usc.cgsa.web.service;

import edu.usc.cgsa.web.model.Category;

import java.sql.SQLException;
import java.util.List;

/**
 * @author Ronan
 * @email crnoogle@gmail.com
 * @date 5/16/20
 * @website
 */
public interface CategoryService {

  Long insert(Category category) throws SQLException;

  Long deleteById(Long id) throws SQLException;

  Category findById(Long id) throws SQLException;

  List<Category> findAll() throws SQLException;

  List<Category> findAllByType(String type) throws SQLException;
}
