package com.qf.pojo;

import com.github.pagehelper.PageSerializable;

/**
 * @author Administrator
 * @version V1.0
 * @Project mybatisdemo2
 * @Package com.qf.pojo
 * @Description:
 * @Date 2022/5/16 19:43
 */

public class PageInfo<T> extends PageSerializable<T> {
    private int pageNum;
    private int pageSize;
    private int size;

    private int startRow;
    private int endRow;
    private int pages;

    private int prePage;
    private int nextPage;

    private boolean isFirstPage = false;
    private boolean isLastPage = false;
    private boolean hasPreviousPage = false;
    private boolean hasNextPage = false;

    private int navigatePages;
    private int [] navigatepageNums;
    private int navigateFirstPage;
    private int navigateLastPage;
}
