package com.service.tac.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;
import org.python.core.PyFunction;
import org.python.core.PyInteger;
import org.python.core.PyObject;
import org.python.util.PythonInterpreter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.google.gson.Gson;
import com.service.tac.model.service.CategoryService;
import com.service.tac.model.service.ConsumeService;
import com.service.tac.model.vo.Consume;

@Controller
@RequestMapping("/consume")
public class ConsumeController {
	
	@Autowired
	ConsumeService consumeService;
	
	@Autowired
	CategoryService CategoryService;
	
	@PostMapping("/register")
	@ResponseBody
	public String addConsumeInfo(@RequestParam Map<String, Object> map) {
		Consume consume = new Consume(
				Integer.parseInt((String) map.get("price")), 
				(String) map.get("consumeDate"), 
				Integer.parseInt((String)map.get("largeCategoryId")), 
				Integer.parseInt((String)map.get("smallCategoryId")), 
				(String) map.get("memberId"));
		try {
			consumeService.addConsumeInfo(consume);
			return "";  
		} catch (SQLException e) {
			e.printStackTrace();
			return "/error";
		}
	}
	
	
	@PostMapping("/getConsume")
	@ResponseBody
	public ArrayList<HashMap<String,Object>> getConsume(@RequestParam Map<String, Object> map) {
		String memberId = (String) map.get("memberId");
		ArrayList<HashMap<String, Object>> hm = null;
		try {
			hm = consumeService.getConsume(memberId);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return hm;
	}
	
	@DeleteMapping("/deleteConsume")
	public String deleteConsume(@RequestParam Map<String, Object> map) {
		int consumeId =  Integer.parseInt((String) map.get("consumeId"));
		try {
			consumeService.deleteConsumeInfo(consumeId);
			return "";
		} catch (SQLException e) {
			e.printStackTrace();
			return "/error";
		}
	}
	
	@PutMapping("/update")
	public String updateConsumeInfo(@RequestParam Map<String, Object> map) {
		Consume consume = new Consume(Integer.parseInt((String) map.get("consumeId")), (String) map.get("consumeDate"));
		try {
			consumeService.updateConsumeInfo(consume);
			return "";
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return "/error";
		}
	}
	
	@PostMapping("/uploadExcelFile")
	public void uploadExcelFile(MultipartHttpServletRequest request, Model model, HttpServletResponse response) {
		System.out.println("uploadExcelFile");
		// 파이썬 테스트
		PythonInterpreter intPre;
		intPre = new PythonInterpreter();
		System.out.println("파이선 불러오기");
		intPre.execfile("src/main/webapp/resources/python/test.py");
		intPre.exec("print(testFunc(5,10))");
		
		PyFunction pyFunction = (PyFunction) intPre.get("testFunc", PyFunction.class);
		int a = 10;
		int b = 20;
		PyObject pyobj = pyFunction.__call__(new PyInteger(a), new PyInteger(b));
		System.out.println(pyobj.toString());
		intPre.close();
		
		String memberId = request.getParameter("member");
		response.setCharacterEncoding("UTF-8");
		try {
			PrintWriter printWriter = response.getWriter();
			JSONObject jsonObject = new JSONObject();
			
			MultipartFile file = null;
	      	Iterator<String> iterator = request.getFileNames();
	        if(iterator.hasNext()) {
	            file = request.getFile(iterator.next());
	        }
	        ArrayList<Consume> list = consumeService.uploadExcelFile(file);
	        if(list !=null) {
				jsonObject.put("rs", "0000");
	        }else {
	        	jsonObject.put("rs", "9999");
	        }		    
	        printWriter.print(new Gson().toJsonTree(list).getAsJsonArray());
	        for(int i = 0; i < list.size(); i++) {
	        	list.get(i).setMemberId(memberId);
	        	list.get(i).setLargeCategoryId(CategoryService.getLargeCategoryIdByName(list.get(i).getLargeCategoryName()));
	        	list.get(i).setSmallCategoryId(CategoryService.getSmallCategoryIdByLarge(list.get(i).getLargeCategoryId()));
	        	consumeService.addConsumeInfo(list.get(i));
	        }
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
    }
}
