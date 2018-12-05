package web.entity;

import java.io.Serializable;

public class Page implements Serializable{
	 private static final long serialVersionUID = -3198048449643774660L; 
     
	    private int pageNow = 1; // 当前页数 
	   
	    private int pageSize = 4; // 每页显示记录的条数 
	   
	    private int totalCount; // 总的记录条数 
	   
	    private int totalPageCount; // 总的页数 
	   /*
	    * @SuppressWarnings("unused") 
	    * 屏蔽java编译中的一些警告信息。unused这个参数是屏蔽：定义的变量在代码中若还未使用且无法访问时。
	    * java在编译的时候会出现这样的警告，加上这个注解之后就是告诉编译器，忽略这些警告，
	    * 编译的过程中将不会出现这种类型的警告 
	    */
	    @SuppressWarnings("unused") 
	    private int startPos; // 开始位置，从0开始 
	 
	       
	    /**
	     * 通过构造函数 传入  总记录数  和  当前页
	     * @param totalCount
	     * @param pageNow
	     */ 
	    public Page(int totalCount, int pageNow,int pageSize) { 
	        this.totalCount = totalCount; 
	        this.pageNow = pageNow; 
	        this.pageSize=pageSize;
	    } 
	       
	    /**
	     * 取得总页数，总页数=总记录数/每页显示记录的条数  
	     * @return
	     */ 
	    public int getTotalPageCount() { 
	        totalPageCount = getTotalCount() / getPageSize(); 
	        return (totalCount % pageSize == 0) ? totalPageCount  //总页数
	                : totalPageCount + 1; 
	    } 
	   
	    public void setTotalPageCount(int totalPageCount) { 
	        this.totalPageCount = totalPageCount; 
	    } 
	   
	    public int getPageNow() { 
	        return pageNow; 
	    } 
	   
	    public void setPageNow(int pageNow) { 
	        this.pageNow = pageNow; 
	    } 
	   
	    public int getPageSize() { 
	        return pageSize; 
	    } 
	   
	    public void setPageSize(int pageSize) { 
	        this.pageSize = pageSize; 
	    } 
	   
	    public int getTotalCount() { 
	        return totalCount; 
	    } 
	   
	    public void setTotalCount(int totalCount) { 
	        this.totalCount = totalCount; 
	    } 
	    /**
	     * 取得选择记录的初始位置
	     * @return
	     */ 
	    public int getStartPos() { 
	        return (pageNow - 1) * pageSize; 
	    } 
	   
	    public void setStartPos(int startPos) { 
	        this.startPos = startPos; 
	    }  

}
