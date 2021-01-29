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
public class Department {
  private Long id;
  /* department name */
  private String deptName;
  private String deptNameEn;
  /* group img url */
  private String deptImg;
  /* keyword array */
  private String keyword;
  private String keywordEn;
  /* short info */
  private String shortInfo;
  private String shortInfoEn;
  /* short description */
  private String detail;
  private String detailEn;
}
