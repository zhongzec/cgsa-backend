package edu.usc.cgsa.web.dao;

import edu.usc.cgsa.web.model.BoardMember;
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
public interface BoardMemberMapper {

  Long createTable();

  Long insert(BoardMember bm);

  Long deleteById(Long id);

  BoardMember findById(Long id);

  List<BoardMember> findAll();
}
