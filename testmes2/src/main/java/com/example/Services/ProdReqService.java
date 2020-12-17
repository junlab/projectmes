package com.example.Services;



import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.DAO.ProdReqDAO;
import com.example.Entity.EndProd;
import com.example.Entity.Materials;
import com.example.Entity.OrderMate;
import com.example.Entity.ProdReq;
import com.example.Entity.TempIncome;
import com.example.Entity.TempProcess;

@Service
public class ProdReqService {
	SimpleDateFormat transFormat = 
			new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	@Autowired
	ProdReqDAO prodReqDAO;
	
	@Transactional // 원래는 트랜잭션 처리를 해주는게 정상
	public void add(ProdReq prodReq) {
	   // TODO : 데이터 접근 객체를 호출
	   prodReq.setAddDate(transFormat.format(new Date()));
	   System.out.println(prodReq.getAddDate());
	   this.prodReqDAO.insert(prodReq);
	      
	}

	@Transactional
	public List<ProdReq> add_list(ProdReq prodReq) {
		// TODO Auto-generated method stub  
		List<ProdReq> listProd = this.prodReqDAO.add_list(prodReq);
		return listProd;
	}
	
	@Transactional
	public void del_addlist(List<String> datelist) {
		// TODO Auto-generated method stub
		this.prodReqDAO.del_addlist(datelist);
	}

	@Transactional
	public List<OrderMate> order_list(OrderMate orderMate) {
		// TODO Auto-generated method stub
		List<OrderMate> listOrder = this.prodReqDAO.order_list(orderMate);
		return listOrder;
	}

	@Transactional
	public void insert_temp_income(TempIncome tempincome) {
		// TODO Auto-generated method stub
		this.prodReqDAO.insert_temp_income(tempincome);
	}

	@Transactional
	public List<TempIncome> temp_incomelist(TempIncome tempincome) {
		// TODO Auto-generated method stub
		List<TempIncome> tempincomelist = this.prodReqDAO.temp_incomelist(tempincome);
		return tempincomelist;
	}

	@Transactional
	public void insert_materials(Materials realMate) {
		// TODO Auto-generated method stub
		this.prodReqDAO.insert_materials(realMate);
	}
	
	@Transactional
	public List<Materials> materials_list(Materials materials) {
		// TODO Auto-generated method stub
		List<Materials> listMaterials = this.prodReqDAO.materials_list(materials);
		return listMaterials;
	}

	@Transactional
	public void insert_tempprocess(List<Materials> processMateList) {
		// TODO Auto-generated method stub
		int abrasionCnt=0;
		int assembleCnt=0;
		int processMateListCnt = processMateList.size();

		for(Materials i : processMateList){   
			if(i.getProcessName().equals("연마")) {
				abrasionCnt++;
			}else if(i.getProcessName().equals("조립")) {
				assembleCnt++;
			}
			
			  System.out.println(i.getMateName());
			  System.out.println(i.getMateTypeName());
			  System.out.println(i.getProcessName());
			  System.out.println(i.getAmt());
			  System.out.println(i.getParentNode());
			  System.out.println(i.getAddDate());
		}
		
		System.out.println(abrasionCnt);
		
		if(processMateListCnt == abrasionCnt) { // 연마 공정일 경우
			this.prodReqDAO.insert_temp_abrasion(processMateList);
		}else if(processMateListCnt == assembleCnt) { // 조립 공정일 경우
			this.prodReqDAO.insert_temp_assemble(processMateList);
		}else{
			System.out.println("보내기 실패");
		}

	}

	@Transactional
	public List<TempProcess> temp_processlist(TempProcess tempprocess) {
		// TODO Auto-generated method stub
		List<TempProcess> listProcess = this.prodReqDAO.temp_processlist(tempprocess);
		return listProcess;
	}

	@Transactional
	public void insert_assemble_mate(TempProcess assemblemate) {
		// TODO Auto-generated method stub
		this.prodReqDAO.insert_assemble_mate(assemblemate);
	}

	public void insert_prod(EndProd endpord) {
		// TODO Auto-generated method stub
		this.prodReqDAO.insert_prod(endpord);
	}
	
	
	
	
	
	
}
