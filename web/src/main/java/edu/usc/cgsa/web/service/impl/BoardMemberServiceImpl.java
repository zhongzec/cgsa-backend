package edu.usc.cgsa.web.service.impl;

import edu.usc.cgsa.web.dao.BoardMemberMapper;
import edu.usc.cgsa.web.model.BoardMember;
import edu.usc.cgsa.web.service.BoardMemberService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Ronan
 * @email crnoogle@gmail.com
 * @date 5/16/20
 * @website
 */
@Service
public class BoardMemberServiceImpl implements BoardMemberService {

  private final BoardMemberMapper bmMapper;

  public BoardMemberServiceImpl(BoardMemberMapper bmMapper) {
    this.bmMapper = bmMapper;
    bmMapper.createTable();
  }

  @Override
  public Long insert(BoardMember boardMember) {
    return bmMapper.insert(boardMember);
  }

  @Override
  public Long deleteById(Long id) {
    return bmMapper.deleteById(id);
  }

  @Override
  public BoardMember findById(Long id) {
    return bmMapper.findById(id);
  }

  @Override
  public List<BoardMember> findAll() {
    return bmMapper.findAll();
  }
}
