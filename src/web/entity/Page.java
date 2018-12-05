package web.entity;

import java.io.Serializable;

public class Page implements Serializable{
	 private static final long serialVersionUID = -3198048449643774660L; 
     
	    private int pageNow = 1; // ��ǰҳ�� 
	   
	    private int pageSize = 4; // ÿҳ��ʾ��¼������ 
	   
	    private int totalCount; // �ܵļ�¼���� 
	   
	    private int totalPageCount; // �ܵ�ҳ�� 
	   /*
	    * @SuppressWarnings("unused") 
	    * ����java�����е�һЩ������Ϣ��unused������������Σ�����ı����ڴ���������δʹ�����޷�����ʱ��
	    * java�ڱ����ʱ�����������ľ��棬�������ע��֮����Ǹ��߱�������������Щ���棬
	    * ����Ĺ����н���������������͵ľ��� 
	    */
	    @SuppressWarnings("unused") 
	    private int startPos; // ��ʼλ�ã���0��ʼ 
	 
	       
	    /**
	     * ͨ�����캯�� ����  �ܼ�¼��  ��  ��ǰҳ
	     * @param totalCount
	     * @param pageNow
	     */ 
	    public Page(int totalCount, int pageNow,int pageSize) { 
	        this.totalCount = totalCount; 
	        this.pageNow = pageNow; 
	        this.pageSize=pageSize;
	    } 
	       
	    /**
	     * ȡ����ҳ������ҳ��=�ܼ�¼��/ÿҳ��ʾ��¼������  
	     * @return
	     */ 
	    public int getTotalPageCount() { 
	        totalPageCount = getTotalCount() / getPageSize(); 
	        return (totalCount % pageSize == 0) ? totalPageCount  //��ҳ��
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
	     * ȡ��ѡ���¼�ĳ�ʼλ��
	     * @return
	     */ 
	    public int getStartPos() { 
	        return (pageNow - 1) * pageSize; 
	    } 
	   
	    public void setStartPos(int startPos) { 
	        this.startPos = startPos; 
	    }  

}
