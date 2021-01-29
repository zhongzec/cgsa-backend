package edu.usc.cgsa.web.model;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Ronan
 * @email crnoogle@gmail.com
 * @date 5/16/20
 * @website
 */
@Data
@NoArgsConstructor
public class BoardMember {
  private Long id;
  private String name;
  private String nameEn;
  // img url
  private String img;
  private String title;
  private String titleEn;
  private String duty;
  private String college;
  private String major;
  private String linkedin;
  private String priority;
}
