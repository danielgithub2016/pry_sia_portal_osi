package net.royal.erp.asistencia.dominio.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class DtoCargoSIGED {

	    private Integer  pageNum;
	    private Integer  pageSize;
	    private Integer  size;
	    private Integer  startRow;
	    private Integer  endRow;
	    private Integer  total;
	    private Integer  pages;
	    public List<DtoCargoDetalleSIGED> list;
	    
	    @JsonIgnore
	    private Integer  prePage;
	    
	    @JsonIgnore
	    private Integer  nextPage;
	    
	    @JsonIgnore
	    public boolean isFirstPage;
	    
	    @JsonIgnore
	    public boolean isLastPage;
	    
	    @JsonIgnore
	    public boolean hasPreviousPage;
	    
	    @JsonIgnore
	    public boolean hasNextPage;
	    
	    @JsonIgnore
	    private Integer  navigatePages;
	    
	    @JsonIgnore
	    public List<Object> navigatepageNums;
	    
	    @JsonIgnore
	    private Integer  navigateFirstPage;
	    
	    @JsonIgnore
	    private Integer  navigateLastPage;
	    
	    @JsonIgnore
	    private Integer  firstPage;
	    
	    @JsonIgnore
	    private Integer  lastPage;
	    
	    
		public Integer getPageNum() {
			return pageNum;
		}
		public void setPageNum(Integer pageNum) {
			this.pageNum = pageNum;
		}
		public Integer getPageSize() {
			return pageSize;
		}
		public void setPageSize(Integer pageSize) {
			this.pageSize = pageSize;
		}
		public Integer getSize() {
			return size;
		}
		public void setSize(Integer size) {
			this.size = size;
		}
		public Integer getStartRow() {
			return startRow;
		}
		public void setStartRow(Integer startRow) {
			this.startRow = startRow;
		}
		public Integer getEndRow() {
			return endRow;
		}
		public void setEndRow(Integer endRow) {
			this.endRow = endRow;
		}
		public Integer getTotal() {
			return total;
		}
		public void setTotal(Integer total) {
			this.total = total;
		}
		public Integer getPages() {
			return pages;
		}
		public void setPages(Integer pages) {
			this.pages = pages;
		}
		public List<DtoCargoDetalleSIGED> getList() {
			return list;
		}
		public void setList(List<DtoCargoDetalleSIGED> list) {
			this.list = list;
		}
		public Integer getPrePage() {
			return prePage;
		}
		public void setPrePage(Integer prePage) {
			this.prePage = prePage;
		}
		public Integer getNextPage() {
			return nextPage;
		}
		public void setNextPage(Integer nextPage) {
			this.nextPage = nextPage;
		}
		public boolean isFirstPage() {
			return isFirstPage;
		}
		public void setFirstPage(boolean isFirstPage) {
			this.isFirstPage = isFirstPage;
		}
		public boolean isLastPage() {
			return isLastPage;
		}
		public void setLastPage(boolean isLastPage) {
			this.isLastPage = isLastPage;
		}
		public boolean isHasPreviousPage() {
			return hasPreviousPage;
		}
		public void setHasPreviousPage(boolean hasPreviousPage) {
			this.hasPreviousPage = hasPreviousPage;
		}
		public boolean isHasNextPage() {
			return hasNextPage;
		}
		public void setHasNextPage(boolean hasNextPage) {
			this.hasNextPage = hasNextPage;
		}
		public Integer getNavigatePages() {
			return navigatePages;
		}
		public void setNavigatePages(Integer navigatePages) {
			this.navigatePages = navigatePages;
		}
		public List<Object> getNavigatepageNums() {
			return navigatepageNums;
		}
		public void setNavigatepageNums(List<Object> navigatepageNums) {
			this.navigatepageNums = navigatepageNums;
		}
		public Integer getNavigateFirstPage() {
			return navigateFirstPage;
		}
		public void setNavigateFirstPage(Integer navigateFirstPage) {
			this.navigateFirstPage = navigateFirstPage;
		}
		public Integer getNavigateLastPage() {
			return navigateLastPage;
		}
		public void setNavigateLastPage(Integer navigateLastPage) {
			this.navigateLastPage = navigateLastPage;
		}
		public Integer getFirstPage() {
			return firstPage;
		}
		public void setFirstPage(Integer firstPage) {
			this.firstPage = firstPage;
		}
		public Integer getLastPage() {
			return lastPage;
		}
		public void setLastPage(Integer lastPage) {
			this.lastPage = lastPage;
		}
}
