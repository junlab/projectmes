package com.example.Controller;

import com.example.Entity.EndProd;
import com.example.Entity.Materials;
import com.example.Entity.OrderMate;
import com.example.Entity.ProdReq;
import com.example.Entity.TempIncome;
import com.example.Entity.TempProcess;
import com.example.Entity.Test;
import com.example.Services.ProdReqService;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class ProductReqController {
	

	@Autowired
	private ProdReqService prodReqService;

	
	  @Transactional
	  @RequestMapping(value = "/add", method = RequestMethod.POST)
	  @ResponseBody
	  public void add(HttpServletRequest request,ProdReq prodReq) {
		  
		  prodReq.setProdName(request.getParameter("prodName"));
		  prodReq.setAmount(Integer.parseInt(request.getParameter("amount")));

		  this.prodReqService.add(prodReq);
		 
	  }
	  
	  @Transactional
	  @RequestMapping(value = "/addlist", method = RequestMethod.POST)
	  @ResponseBody
	  public List<ProdReq> addlist(HttpServletRequest request, ProdReq prodReq) { 
		  List<ProdReq> listProd = this.prodReqService.add_list(prodReq);
		  Collections.sort(listProd);
		  
		  return listProd;
	  } 
	  
	  @Transactional
	  @RequestMapping(value = "/del_addlist", method = RequestMethod.POST)
	  @ResponseBody
	  public void del_addlist(HttpServletRequest request,
			  @RequestBody HashMap<String, ArrayList<String>> map){

		  List<String> datelist = map.get("del_id");

		  this.prodReqService.del_addlist(datelist);
		  
	  }

	  @RequestMapping(value="/index") 
	  public String index() {  
		return "index";
		
	  }
	  
	  @RequestMapping(value="/releaseproduct") 
	  public String release_product() {  
		return "release_product";
		
	  }
	  
	  @RequestMapping(value="/addform") 
	  public String addForm() {  
		return "order_product";
		
	  }
	  
	  @RequestMapping(value="/orderlistform") 
	  public String orderlistForm() {  
		return "materials_income";
		
	  }
	  
	  @RequestMapping(value="/matetestform") 
	  public String matetestForm() {  
		return "materials_quality_test";
		
	  }
	  
	  @RequestMapping(value="/directwork") 
	  public String directworkForm() {  
		return "direct_work";
		
	  }
	  
	  @RequestMapping(value="/tempprocess") 
	  public String tempProcessForm() {  
		return "process_quality_test";
		
	  }
	  
	  @Transactional
	  @RequestMapping(value = "/orderlist", method = RequestMethod.POST)
	  @ResponseBody
	  public List<OrderMate> orderlist(HttpServletRequest request, OrderMate orderMate) { // 서비스 객체 호출 
		  List<OrderMate> listOrder = this.prodReqService.order_list(orderMate);
		  
		  return listOrder;
	  } 
	  
	  @Transactional
	  @RequestMapping(value = "/insert_temp_income", method = RequestMethod.POST)
	  @ResponseBody
	  public void insert_temp_income(HttpServletRequest request,
			  @RequestBody HashMap<String, ArrayList<String>> map){

		  List<String> tempincomelist = map.get("temp_income_id");

		  TempIncome tempIncome = new TempIncome(tempincomelist.get(0), tempincomelist.get(1), 
				  tempincomelist.get(2), Integer.parseInt(tempincomelist.get(3)));

		  this.prodReqService.insert_temp_income(tempIncome);
		  
	  }
	  
	  @Transactional
	  @RequestMapping(value = "/tempincomelist", method = RequestMethod.POST)
	  @ResponseBody
	  public List<TempIncome> temp_incomelist(HttpServletRequest request, TempIncome tempincome) { // 서비스 객체 호출 
		  List<TempIncome> tempincomelist = this.prodReqService.temp_incomelist(tempincome);
		  
		  return tempincomelist;
	  } 
	  
	  @Transactional
	  @RequestMapping(value = "/insert_materials", method = RequestMethod.POST)
	  @ResponseBody
	  public void insert_materials(HttpServletRequest request,
			  @RequestBody HashMap<String, ArrayList<String>> map){

		  List<String> mateincomelist = map.get("materials_id");

		  Materials realMate = new Materials(mateincomelist.get(0), mateincomelist.get(1), 
				  mateincomelist.get(2), Integer.parseInt(mateincomelist.get(3)));

		  this.prodReqService.insert_materials(realMate);
	  }
	  
	  @Transactional
	  @RequestMapping(value = "/marterialslist", method = RequestMethod.POST)
	  @ResponseBody
	  public List<Materials> materialslist(HttpServletRequest request, Materials materials) { // 서비스 객체 호출 
		  List<Materials> listMaterials = this.prodReqService.materials_list(materials);
		  
		  return listMaterials;
	  } 
	  
	  
	  @Transactional
	  @RequestMapping(value = "/insert_tempprocess", method = RequestMethod.POST)
	  @ResponseBody
	  public void insert_tempprocess(HttpServletRequest request,
			  @RequestBody HashMap<String, ArrayList<ArrayList<String>>> map){

		  System.out.println("innsert_tempprocess");
		  
		  List<Materials> processMateList = new ArrayList<Materials>();
			
		  for(int i=0; i<map.get("temp_process_id").size(); i++) {
			List<String> matelist = map.get("temp_process_id").get(i); //map.get(i).get(Integer.toString(i));
		  	Materials tempProcessMate = new Materials(matelist.get(0), matelist.get(1), matelist.get(2),
		  										Integer.parseInt(matelist.get(3)), matelist.get(4), matelist.get(5));
		 	processMateList.add(tempProcessMate); 
		  }

		  this.prodReqService.insert_tempprocess(processMateList);
	  }
	  
	  @Transactional
	  @RequestMapping(value = "/tempprocesslist", method = RequestMethod.POST)
	  @ResponseBody
	  public List<TempProcess> temp_processlist(HttpServletRequest request, TempProcess tempprocess) { // 서비스 객체 호출 
		  List<TempProcess> tempprocesslist = this.prodReqService.temp_processlist(tempprocess);
		  
		  return tempprocesslist;
	  }
	  
	  @Transactional
	  @RequestMapping(value = "/insert_assemble_mate", method = RequestMethod.POST)
	  @ResponseBody
	  public void insert_assemble_mate(HttpServletRequest request, @RequestBody HashMap<String, ArrayList<String>> map){ // 안경, 볼펜이 아닌 반제품 품질검사 통과

		  List<String> assemblelist = map.get("assemblemate_id");

		  TempProcess assemblemate = new TempProcess(assemblelist.get(0), Integer.parseInt(assemblelist.get(1)), 
				  assemblelist.get(2));

		  this.prodReqService.insert_assemble_mate(assemblemate);
	  }
	  
	  @Transactional
	  @RequestMapping(value = "/insert_prod", method = RequestMethod.POST)
	  @ResponseBody
	  public void insert_prod(HttpServletRequest request, @RequestBody HashMap<String, ArrayList<String>> map){ // 안경, 볼펜이 아닌 반제품 품질검사 통과

		  List<String> prodlist = map.get("prod_success_id");

		  EndProd endprod = new EndProd(prodlist.get(0), Integer.parseInt(prodlist.get(1)), 
				  prodlist.get(2));

		  this.prodReqService.insert_prod(endprod);
	  }
	  
	  @Transactional
	  @RequestMapping(value = "/prodlist", method = RequestMethod.POST)
	  @ResponseBody
	  public List<EndProd> prodlist(HttpServletRequest request, EndProd endprod) { // 서비스 객체 호출 
		  List<EndProd> listEndProd = this.prodReqService.endprod_list(endprod);

		  
		  return listEndProd;
	  }
	  
	  @Transactional
	  @RequestMapping(value = "/release_prod", method = RequestMethod.POST)
	  @ResponseBody
	  public void release_prod(HttpServletRequest request, @RequestBody HashMap<String, ArrayList<String>> map){

		  List<String> endprod = map.get("del_endprod_id");
		  EndProd delprod = new EndProd(endprod.get(0), Integer.parseInt(endprod.get(1)), endprod.get(2));
		  this.prodReqService.release_prod(delprod);
		  
	  }


}
