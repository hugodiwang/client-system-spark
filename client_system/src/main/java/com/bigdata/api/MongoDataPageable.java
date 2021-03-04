package com.bigdata.api;


import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.io.Serializable;

public class MongoDataPageable implements Pageable, Serializable {
  private static final long serialVersionUID = 1L;

  public Integer getPagenumber() {
    return pagenumber;
  }

  public void setPagenumber(Integer pagenumber) {
    this.pagenumber = pagenumber;
  }

  public Integer getPagesize() {
    return pagesize;
  }

  public void setPagesize(Integer pagesize) {
    this.pagesize = pagesize;
  }

  public void setSort(Sort sort) {
    this.sort = sort;
  }

  private Integer pagenumber=1;
  private Integer pagesize= 10;
  private Sort sort;


  public int getPageNumber() {
    return getPagenumber();
  }

  public int getPageSize() {
    return getPagesize();
  }

  public int getOffset() {
    return (getPageNumber()-1 )* getPagesize();
  }

  public Sort getSort() {
    return sort;
  }

  public Pageable next() {
    return null;
  }

  public Pageable previousOrFirst() {
    return null;
  }

  public Pageable first() {
    return null;
  }

  public boolean hasPrevious() {
    return false;
  }
}
