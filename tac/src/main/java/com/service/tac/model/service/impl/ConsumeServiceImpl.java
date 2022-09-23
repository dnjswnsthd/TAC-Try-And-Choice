package com.service.tac.model.service.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.service.tac.model.dao.ConsumeDAO;
import com.service.tac.model.service.ConsumeService;
import com.service.tac.model.vo.Consume;

@Service
public class ConsumeServiceImpl implements ConsumeService {
	
	@Autowired
	private ConsumeDAO consumeDAO;

	@Override
	public int addConsumeInfo(Consume consume) throws SQLException {
		return consumeDAO.addConsumeInfo(consume);
	}

	@Override
	public ArrayList<HashMap<String, Object>> getConsume(String memberId) throws SQLException {
		return consumeDAO.getConsume(memberId);
	}

	@Override
	public int updateConsumeInfo(Consume consume) throws SQLException {
		return consumeDAO.updateConsumeInfo(consume);
	}

	@Override
	public int deleteConsumeInfo(int consumeId) throws SQLException {
		return consumeDAO.deleteConsumeInfo(consumeId);
	}

	@Override
	public ArrayList<Consume> uploadExcelFile(MultipartFile excelFile) {
		ArrayList<Consume> list = new ArrayList<Consume>();
        try {
            OPCPackage opcPackage = OPCPackage.open(excelFile.getInputStream());
            XSSFWorkbook workbook = new XSSFWorkbook(opcPackage);
            
            // 첫번째 시트 불러오기
            XSSFSheet sheet = workbook.getSheetAt(0);
            
            for(int i=1; i<sheet.getLastRowNum() + 1; i++) {
            	Consume consume = new Consume();
                XSSFRow row = sheet.getRow(i);
                
                // 행이 존재하기 않으면 패스
                if(null == row) {
                    continue;
                }	
                // 행의 1번째 열(결제 날짜) 
                XSSFCell cell = row.getCell(0);
                if(null != cell)
					/* consume.setConsumeDate(String.valueOf(cell.getNumericCellValue())); */
                	consume.setConsumeDate(cell.getStringCellValue());
                // 행의 5번째 열(카테고리)
                cell = row.getCell(4);
                if(null != cell)
                	consume.setLaregeCategoryName(cell.getStringCellValue());
                // 행의 10번째 열(금액)
                cell = row.getCell(10);
                if(null != cell)
                	consume.setConsumePrice((int)cell.getNumericCellValue());

                list.add(consume);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
	}

}
