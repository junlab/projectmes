package com.example.DAO;


import java.util.Date;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.Entity.EndProd;
import com.example.Entity.Materials;
import com.example.Entity.OrderMate;
import com.example.Entity.ProdReq;
import com.example.Entity.TempIncome;
import com.example.Entity.TempProcess;

@Repository
public class ProdReqDAO {
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	private String namespace = "AllMapper.";
	
	public void insert(ProdReq prodReq) {
		this.sqlSessionTemplate.insert(namespace+"insert", prodReq);
		
		if(prodReq.getProdName().equals("안경")){
			this.sqlSessionTemplate.insert(namespace+"insert_order_glasses", prodReq);
		}else if(prodReq.getProdName().equals("볼펜")) {
			this.sqlSessionTemplate.insert(namespace+"insert_order_pen", prodReq);
		}
	}

	public List<ProdReq> add_list(ProdReq prodReq) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.selectList(namespace+"add_list", prodReq);
	}

	public void del_addlist(List<String> datelist) {
		// 발주날짜로 비교해서 제품수주, 원자재발주 리스트 삭제
		this.sqlSessionTemplate.delete(namespace+"del_addlist", datelist);
		System.out.println("db에 들어갔는지 체크");
		//this.sqlSessionTemplate.delete(namespace+"del_orderlist", datelist);
	}

	public List<OrderMate> order_list(OrderMate orderMate) {
		// TODO Auto-generated method stub	
		return sqlSessionTemplate.selectList(namespace+"order_list", orderMate);
	}

	public void insert_temp_income(TempIncome tempincome) {
		// TODO Auto-generated method stub
		this.sqlSessionTemplate.update(namespace+"insert_temp_income", tempincome);
	}

	public List<TempIncome> temp_incomelist(TempIncome tempincome) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.selectList(namespace+"temp_incomelist", tempincome);
	}

	public void insert_materials(Materials realMate) {
		// TODO Auto-generated method stub
		this.sqlSessionTemplate.update(namespace+"insert_materials", realMate);
		
		
		//this.sqlSessionTemplate.update(namespace+"change_tempincomelist", realMate);
		this.sqlSessionTemplate.delete(namespace+"delete_tempincomelist", realMate);
		
		this.sqlSessionTemplate.update(namespace+"change_orderincomelist", realMate);
		//this.sqlSessionTemplate.delete(namespace+"delete_orderincomelist", realMate);
		
	}

	public List<Materials> materials_list(Materials materials) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.selectList(namespace+"materials_list", materials);
	}
	
	
	
	
	public void insert_temp_abrasion(List<Materials> processMateList) { // 연마 버튼
		// TODO Auto-generated method stub
		for(Materials mate : processMateList) {
			if(mate.getParentNode().equals("안경테")) { // 안경테는 플라스틱 2개에 1개가 만들어지기 때문에 조건을 달아 구분
				this.sqlSessionTemplate.insert(namespace+"insert_temp_abrasion_glassesframe", mate);
				if((mate.getAmt()%2)!=0) { // 홀수일 경우
					this.sqlSessionTemplate.update(namespace+"update_materials_glassesframe", mate);
				}else { // 짝수일 경우
					this.sqlSessionTemplate.delete(namespace+"del_materials_abrasion", mate);
				}
			}else if(mate.getParentNode().equals("안경렌즈")) {
				this.sqlSessionTemplate.insert(namespace+"insert_temp_abrasion_lens", mate);
				this.sqlSessionTemplate.delete(namespace+"del_materials_abrasion", mate);
			}else{
				this.sqlSessionTemplate.insert(namespace+"insert_temp_abrasion", mate);
				this.sqlSessionTemplate.delete(namespace+"del_materials_abrasion", mate);
			}
			this.sqlSessionTemplate.update(namespace+"update_orderlist", mate);
		}
		
		//this.sqlSessionTemplate.update(namespace+"change_matelist", mate);
		System.out.println("보내기 성공");
	}

	public void insert_temp_assemble(List<Materials> processMateList) { // 조립 버튼
		
		int glassesFrameCnt=0;
		int glassesLensCnt=0;
		int glassesScrewCnt=0;
		int glassesNoseCnt=0;
		int penCoverCnt=0;
		int penBodyCnt=0;
		int penLeadCnt=0;
		int penSpringCnt=0;
		
		
		for(Materials mate : processMateList) { // 각각의 개수를 먼저 구한다.
			if(mate.getParentNode().equals("안경")) {
				if(mate.getMateName().equals("안경테")){
					glassesFrameCnt = mate.getAmt();
				}else if(mate.getMateName().equals("안경렌즈")) {
					glassesLensCnt = mate.getAmt();
				}else if(mate.getMateName().equals("나사")) {
					glassesScrewCnt = mate.getAmt();
				}else{
					glassesNoseCnt = mate.getAmt();
				}
			}else if(mate.getParentNode().equals("볼펜")) {
				if(mate.getMateName().equals("볼펜뚜껑")){
					penCoverCnt = mate.getAmt();
				}else if(mate.getMateName().equals("볼펜몸통")) {
					penBodyCnt = mate.getAmt();
				}else if(mate.getMateName().equals("볼펜심")) {
					penLeadCnt = mate.getAmt();
				}else{
					penSpringCnt = mate.getAmt();
				}
			}
		}
		
		for(Materials mate : processMateList) {
			if(mate.getParentNode().equals("안경")) { // 안경 조립일 경우
				if(mate.getMateName().equals("안경테")){
					if((glassesLensCnt==glassesFrameCnt*2)&&(glassesScrewCnt==glassesFrameCnt*2)&&(glassesNoseCnt==glassesFrameCnt*2)) { // 안경 조립 개수가 맞을때 수행
						this.sqlSessionTemplate.insert(namespace+"insert_temp_assemble_glasses", mate); // 임시 공정 품질검사 테이블에 넘김.
						this.sqlSessionTemplate.delete(namespace+"del_materials_assemble_glasses", mate);
					}else{
						System.out.println("개수가 맞지 않음");
					}
				}else{
					this.sqlSessionTemplate.delete(namespace+"del_materials_assemble_glasses", mate);
					//System.out.println("에러");
				}	
			}
			else if(mate.getParentNode().equals("볼펜")) { // 볼펜 조립일 경우
				if(mate.getMateName().equals("스프링")){
					if((penSpringCnt==penCoverCnt*2)&&(penSpringCnt==penLeadCnt*2)&&(penSpringCnt==penBodyCnt*2)) { // 볼펜 조립 개수가 맞을때 수행
						this.sqlSessionTemplate.insert(namespace+"insert_temp_assemble_pen", mate); // 임시 공정 품질검사 테이블에 넘김.
						this.sqlSessionTemplate.delete(namespace+"del_materials_assemble_pen", mate);
					}
				}else{
					this.sqlSessionTemplate.delete(namespace+"del_materials_assemble_pen", mate);
				}
			}
			else{ // 볼펜심일 경우
				if(mate.getMateName().equals("스프링")){
					this.sqlSessionTemplate.insert(namespace+"insert_temp_assemble_penlead", mate);
					this.sqlSessionTemplate.delete(namespace+"del_materials_assemble_pen", mate);
				}else {
					this.sqlSessionTemplate.update(namespace+"del_materials_assemble_pen", mate);
				}
			}
		}
		
		/*
		int glassesFrameCnt=0;
		int glassesLensCnt=0;
		int glassesScrewCnt=0;
		int glassesNoseCnt=0;
		int penCoverCnt=0;
		int penBodyCnt=0;
		int penLeadCnt=0;
		int penSpringCnt=0;
		
		
		for(Materials mate : processMateList) { // 각각의 개수를 먼저 구한다.
			if(mate.getParentNode().equals("안경")) {
				if(mate.getMateName().equals("안경테")){
					glassesFrameCnt = mate.getAmt();
				}else if(mate.getMateName().equals("안경렌즈")) {
					glassesLensCnt = mate.getAmt();
				}else if(mate.getMateName().equals("나사")) {
					glassesScrewCnt = mate.getAmt();
				}else{
					glassesNoseCnt = mate.getAmt();
				}
			}else if(mate.getParentNode().equals("볼펜")) {
				if(mate.getMateName().equals("볼펜뚜껑")){
					penCoverCnt = mate.getAmt();
				}else if(mate.getMateName().equals("볼펜몸통")) {
					penBodyCnt = mate.getAmt();
				}else if(mate.getMateName().equals("볼펜심")) {
					penLeadCnt = mate.getAmt();
				}else{
					penSpringCnt = mate.getAmt();
				}
			}
		}
		
		for(Materials mate : processMateList) {
			int prodcnt=0;
			if(mate.getParentNode().equals("안경")) { // 안경 조립일 경우
				if(mate.getMateName().equals("안경테")){
					for(int i=glassesFrameCnt; i>=1; i--) {
						if((glassesLensCnt>=i*2)&&(penBodyCnt>=i)&&(penLeadCnt>=i)) {
							prodcnt=i;
							mate.setAmt(prodcnt);
							this.sqlSessionTemplate.insert(namespace+"insert_temp_assemble_glasses", mate); // 임시 공정 품질검사 테이블에 넘김.
						}
					}
				}else{
					System.out.println(prodcnt);
					mate.setAmt(prodcnt);
					this.sqlSessionTemplate.update(namespace+"update_materials_assemble_glasses_others", mate);
				}	
			}
			else if(mate.getParentNode().equals("볼펜")) { // 볼펜 조립일 경우
				if(mate.getMateName().equals("볼펜뚜껑")){
					for(int i=penCoverCnt; i>=1; i--) {
						if((penSpringCnt>=i*2)) {
							prodcnt=i;
							mate.setAmt(prodcnt);
							this.sqlSessionTemplate.insert(namespace+"insert_temp_assemble_pen", mate); // 임시 공정 품질검사 테이블에 넘김.
							this.sqlSessionTemplate.update(namespace+"update_materials_assemble_pen_others", mate);
							//this.sqlSessionTemplate.update(namespace+"update_materials_assemble_spring", mate);
							
						}
					}
				}else if(mate.getMateName().equals("스프링")){
					System.out.println(prodcnt);
					mate.setAmt(prodcnt);
					this.sqlSessionTemplate.update(namespace+"update_materials_assemble_spring", mate);
				}else{
					this.sqlSessionTemplate.update(namespace+"update_materials_assemble_pen_others", mate);
				}
			}
		}
		*/
	}

	
	
	
	public List<TempProcess> temp_processlist(TempProcess tempprocess) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.selectList(namespace+"temp_processlist", tempprocess);
	}

	public void insert_assemble_mate(TempProcess assemblemate) {
		// TODO Auto-generated method stub
		this.sqlSessionTemplate.insert(namespace+"insert_assemble_mate", assemblemate);
		this.sqlSessionTemplate.delete(namespace+"delete_tempprocesslist", assemblemate);
		this.sqlSessionTemplate.update(namespace+"change_orderlist_process", assemblemate);
	}

	public void insert_prod(EndProd endpord) {
		// TODO Auto-generated method stub
		this.sqlSessionTemplate.insert(namespace+"insert_prod", endpord);
		this.sqlSessionTemplate.delete(namespace+"del_tempprocessprod", endpord);
		this.sqlSessionTemplate.delete(namespace+"del_prod_req", endpord);
	}


}
