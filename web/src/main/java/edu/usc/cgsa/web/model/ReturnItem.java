package edu.usc.cgsa.web.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class ReturnItem {
  private String header;
  private List<Item> items;
}
