package cn.jxau.soft.utils;

import java.io.Serializable;

/**
 * 定义一个分页的Bean对象
 * 
 * @author cwq
 * @version V1.0 2017/7/17
 */
public class Pager implements Serializable {
	private static final long serialVersionUID = 7328663570786085486L;
	private Integer pageSize; // 每页容纳的新闻信息条数
	private Integer curPage; // 记录当前页码
	private Integer rowsCount; // 记录总数
	private Integer pageCount; // 总页数

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public Integer getCurPage() {
		return curPage;
	}

	public void setCurPage(Integer curPage) {
		this.curPage = curPage;
	}

	public Integer getRowsCount() {
		return rowsCount;
	}

	public void setRowsCount(Integer rowsCount) {
		this.rowsCount = rowsCount;
	}

	public void setPageCount(Integer pageCount) {
		this.pageCount = pageCount;
	}

	/**
	 * 总页数=(记录总条数/每页容纳新闻条数)+1
	 * @return 总页数
	 */
	public int getPageCount() {
		pageCount = rowsCount / pageSize;
		pageCount = (rowsCount % pageSize != 0) ? pageCount + 1 : pageCount;
		return pageCount;
	}

	@Override
	public String toString() {
		return "Pager [pageSize=" + pageSize + ", curPage=" + curPage
				+ ", rowsCount=" + rowsCount + ", pageCount=" + getPageCount() + "]";
	}
	
}
