package proxy;

import javax.servlet.http.HttpServletRequest;

import lombok.Data;
import service.CustomerServiceImpl;

@Data
public class Pagination implements Proxy{
	  private int pageNum, pageSize, blockSize,
      startRow,endRow,startPage,endPage,
      prevBlock, nextBlock,rowCount;
	  private boolean existPrev, existNext;
	
	@Override
	public void carryOut(Object o) {
		 System.out.println("페이지네이션 캐리아웃 내부");
	        HttpServletRequest request = (HttpServletRequest)o;
	        System.out.println("----request.getParameter(\"page_num\")-----"
	                             +request.getParameter("page_num"));
	        String _pageNum = request.getParameter("page_num");
	        pageNum = (_pageNum == null) ? 1 : Integer.parseInt(_pageNum);
	        System.out.println("페이지번호: "+pageNum);
	        String _pageSize = request.getParameter("page_size");
	        pageSize = (_pageSize == null) ? 5 : Integer.parseInt(_pageSize);
	        System.out.println("페이지사이즈: "+pageSize);
	        String _blockSize = request.getParameter("block_size");
	        blockSize = (_blockSize == null) ? 5 : Integer.parseInt(_blockSize);
	        System.out.println("블록사이즈: "+blockSize);
	        rowCount = CustomerServiceImpl.getInstance()
	                        .countCustomers(null);
	        System.out.println("전체 카운트: "+rowCount);
	        int nmg = rowCount / pageSize;
	        int pageCount = 0;
	        if(nmg==0){
	        	pageCount = rowCount / pageSize;
	        }else{
	        	pageCount = rowCount / pageSize+1;
	        }
	        // int pageCount = (nmg == 0)?rowCount / pageSize:rowCount / pageSize+1;
	        startRow = (pageNum -1)*pageSize+1;
	        endRow = (rowCount > pageNum * pageSize)?pageNum * pageSize : rowCount ;
	        
	        int blockNum = (pageNum-1)/blockSize;
	        if(existPrev) {
	            startPage = blockNum*blockSize+1;
	            
	        }else {
	            startPage = 1;
	        }
	        endPage = startPage+(blockSize-1);
	        
	        prevBlock = startPage - pageSize;
	        nextBlock = startPage + pageSize;
	        
	        existPrev = (startPage - pageSize) > 0;
	        existNext = (startPage + pageSize) <= pageCount;
	        prevBlock = startPage - pageSize; 
	        nextBlock = startPage + pageSize;
	    }
}