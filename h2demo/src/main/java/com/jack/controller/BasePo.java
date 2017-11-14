package com.jack.controller;

/**
 * Description
 * <p>
 * </p>
 * Date: 2017/7/26
 *
 * @author: 李伟健
 */
public class BasePo {

    private Integer pageNum = 1;

    private Integer pageSize = 15;

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        if (pageNum != null) {
            this.pageNum = pageNum;
        }
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        if (pageSize != null) {
            this.pageSize = pageSize;
        }
    }
}
