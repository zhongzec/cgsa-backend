package edu.usc.cgsa.web.dao;

import edu.usc.cgsa.web.model.Category;
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
public interface CategoryMapper {

  Long createTable();

  Long insert(Category cat);

  Long deleteById(Long id);

  Category findById(Long id);

  List<Category> findAll();

  List<Category> findAllByType(String type);
}
