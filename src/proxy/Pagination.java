package proxy;

import javax.servlet.http.HttpServletRequest;

import lombok.Data;
import service.CustomerServiceImpl;
import service.ProductServiceImpl;

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
	        String _pageNum = request.getParameter("page_num");
	        pageNum = (_pageNum == null) ? 1 : Integer.parseInt(_pageNum);
	        System.out.println("페이지번호: "+pageNum);
	        
	        String _pageSize = request.getParameter("page_size");
	        pageSize = (_pageSize == null) ? 5 : Integer.parseInt(_pageSize);
	        System.out.println("페이지사이즈: "+pageSize);
	        
	        String _blockSize = request.getParameter("block_size");
	        blockSize = (_blockSize == null) ? 5 : Integer.parseInt(_blockSize);
	        System.out.println("블록사이즈: "+blockSize);
	        
	        System.out.println("페이지네이션 cmd===="+request.getParameter("cmd"));
	        switch(request.getParameter("cmd")){
	        case "access": case "cus_list":
	        	rowCount = CustomerServiceImpl.getInstance()
	        			.countCustomers(null);
	        	System.out.println("커스토머 전체 카운트: "+rowCount);
	        break;
	        case "PRO_LIST":
	        	rowCount = ProductServiceImpl.getInstance()
    					.countProduct(null);
	        	System.out.println("프로덕트 전체 카운트: "+rowCount);
			break;
	        }
	        
	        int nmg = rowCount % pageSize;
	        int pageCount = (nmg == 0)?rowCount / pageSize:rowCount / pageSize+1;
			System.out.println("전체 페이지수: "+pageCount);
			startRow = (pageNum -1) *pageSize + 1;
			System.out.println("스타트로우: "+startRow);
			endRow = (rowCount > pageNum * pageSize)? pageNum * pageSize: rowCount;
			System.out.println("엔드로우: "+endRow);
			
			// 김창하의 블록넘버 방식
			int blockNum = (pageNum-1)/blockSize;
			if(existPrev) {
				startPage = blockNum*blockSize+1;
				
			}else {
				startPage = 1;
			}
			endPage = startPage+(blockSize-1);
			// 김이레의 매쓰함수 방식
			endPage = (int)(Math.ceil(pageNum / (double) blockSize) * blockSize);
			startPage = (endPage - blockSize) + 1;
			// 김승아의 얼추이해한 방식
			startPage = pageNum -((pageNum-1)%blockSize);
			endPage = startPage+(blockSize-1);
			// 위 세조건 모두 공통
			if(endPage>pageCount) {
				endPage = pageCount;
			}
			
			existPrev = (startPage - pageSize) > 0;
			existNext = (startPage + pageSize) <= pageCount;
			prevBlock = startPage - pageSize; 
			nextBlock = startPage + pageSize;
		}
}