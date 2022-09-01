package com.service.tac.controller;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.service.tac.model.service.CardCompareService;
import com.service.tac.model.service.MemberService;
import com.service.tac.model.vo.Card;
import com.service.tac.model.vo.CardDetail;
import com.service.tac.model.vo.Member;

@Controller
public class CardCompareController {
	@Autowired
	CardCompareService cardCompareService;
	
	@Autowired
	MemberService memberService;
	
	
	@RequestMapping(value= {"/compare"}, method= RequestMethod.GET)
	public String compare(HttpServletRequest request, Model model) {
		int cardId = Integer.parseInt(request.getParameter("cardId"));
		
		try {
			Card info = cardCompareService.getCardInfo(cardId);
			ArrayList<CardDetail> list = cardCompareService.getDiscountInfoByCard(cardId);
			
			model.addAttribute("list", list);
			model.addAttribute("info", info);
			
			ArrayList<CardDetail> records1 = cardCompareService.getBenefitsByCateg1(cardId);
			ArrayList<CardDetail> records2 = cardCompareService.getBenefitsByCateg2(cardId);
			ArrayList<CardDetail> records3 = cardCompareService.getBenefitsByCateg3(cardId);
			ArrayList<CardDetail> records4 = cardCompareService.getBenefitsByCateg4(cardId);
			ArrayList<CardDetail> records5 = cardCompareService.getBenefitsByCateg5(cardId);
			ArrayList<CardDetail> records6 = cardCompareService.getBenefitsByCateg6(cardId);
			ArrayList<CardDetail> records7 = cardCompareService.getBenefitsByCateg7(cardId);
			ArrayList<CardDetail> records8 = cardCompareService.getBenefitsByCateg8(cardId);
			ArrayList<CardDetail> records9 = cardCompareService.getBenefitsByCateg9(cardId);
			ArrayList<CardDetail> records10 = cardCompareService.getBenefitsByCateg10(cardId);
			ArrayList<CardDetail> records11 = cardCompareService.getBenefitsByCateg11(cardId);
			ArrayList<CardDetail> records12 = cardCompareService.getBenefitsByCateg12(cardId);
			ArrayList<CardDetail> records13 = cardCompareService.getBenefitsByCateg13(cardId);
			ArrayList<CardDetail> records14 = cardCompareService.getBenefitsByCateg14(cardId);
			ArrayList<CardDetail> records15 = cardCompareService.getBenefitsByCateg15(cardId);
			ArrayList<CardDetail> records16 = cardCompareService.getBenefitsByCateg16(cardId);
			ArrayList<CardDetail> records17 = cardCompareService.getBenefitsByCateg17(cardId);
			ArrayList<CardDetail> records18 = cardCompareService.getBenefitsByCateg18(cardId);
			ArrayList<CardDetail> records19 = cardCompareService.getBenefitsByCateg19(cardId);
			ArrayList<CardDetail> records20 = cardCompareService.getBenefitsByCateg20(cardId);
			ArrayList<CardDetail> records21 = cardCompareService.getBenefitsByCateg21(cardId);
			ArrayList<CardDetail> records22 = cardCompareService.getBenefitsByCateg22(cardId);
			
			// 1번 카테고리
			if(records1.size()!=0) {
				int maxCount1 = records1.get(0).getMixCount();
				int maxDiscount1 = records1.get(0).getMaxDiscount();
				int minPayment1 = records1.get(0).getMinPayment();
				int discountPercent1 = records1.get(0).getDiscountPercent();
				int discount1 = 0;
				int maxDiscountMon1 = records1.get(0).getMaxDiscountMonth();
				int discountAmount1 = records1.get(0).getDiscountAmount();
				String name1 = records1.get(0).getLargeCategory().getLargeCategoryName();
				
				System.out.println(maxDiscountMon1);
				
				if(minPayment1 != 0) {
					if(maxCount1 != 0 && maxCount1 <= records1.size()) {						
						for(int i=0; i<maxCount1;i++) {
							if(records1.get(i).getConsume().getConsumePrice() >= minPayment1) {
								if(discountPercent1 != 0) discount1 += records1.get(i).getConsume().getConsumePrice() * discountPercent1/100;
								else if(discountAmount1 != 0) discount1 += discountAmount1;
								}//if			  
							 } 
						System.out.println("!!!!!!첫 for문!!!!!!!"+discount1);
						if(maxDiscount1!=0 && discount1 > maxDiscount1) discount1 = maxDiscount1;
						else if(maxDiscountMon1 !=0 && discount1 > maxDiscountMon1) discount1 = maxDiscountMon1;
						System.out.println("!!!!!!!!!!!!!!!!!!값 확인!!!!!!!!!!!!!!!!!!"+discount1);
					} else if(maxCount1==0) {
						for(int i=0; i<records1.size();i++) {
							if(records1.get(i).getConsume().getConsumePrice() >= minPayment1) {
								if(discountPercent1 != 0) discount1 += records1.get(i).getConsume().getConsumePrice() * discountPercent1/100;
								else if(discountAmount1 != 0) discount1 += discountAmount1;
								}//if
								} 
								System.out.println("!!!!!!두번째 for문!!!!!!!"+discount1);
								if(maxDiscount1!=0 && discount1 > maxDiscount1) discount1 = maxDiscount1;
								else if(maxDiscountMon1 !=0 && discount1 > maxDiscountMon1) discount1 = maxDiscountMon1;
								System.out.println("!!!!!!!!!!!!!!!!!!값 확인!!!!!!!!!!!!!!!!!!"+discount1);
						}
					
						
				}else {
					if(maxCount1 != 0 && maxCount1 <= records1.size()) {						
						for(int i=0; i<maxCount1;i++) {
							if(records1.get(i).getConsume().getConsumePrice() >= minPayment1) {
								if(discountPercent1 != 0) discount1 += records1.get(i).getConsume().getConsumePrice() * discountPercent1/100;
								else if(discountAmount1 != 0) discount1 += discountAmount1;
								}//if1
							} 
						System.out.println("!!!!!!세번째 for문!!!!!!!"+discount1);
						if(maxDiscount1!=0 && discount1 > maxDiscount1) discount1 = records1.get(0).getMaxDiscount();
						else if(maxDiscountMon1 !=0 && discount1 > maxDiscountMon1) discount1 = records1.get(0).getMaxDiscountMonth(); 
						System.out.println("!!!!!!!!!!!!!!!!!!!!!!값 확인!!!!!!!!!!!!!!!!!"+discount1);
						}
					else {
						for(int i=0; i<records1.size();i++) {
							if(records1.get(i).getConsume().getConsumePrice() >= minPayment1) {
								if(discountPercent1 != 0) discount1 += records1.get(i).getConsume().getConsumePrice() * discountPercent1/100;
								else if(discountAmount1 != 0) discount1 += discountAmount1;
								}//if
							} 
						System.out.println("!!!!!!네번째 for문!!!!!!!"+discount1);
						if(maxDiscount1!=0 && discount1 > maxDiscount1) discount1 = maxDiscount1;
							else if(maxDiscountMon1 !=0 && discount1 > maxDiscountMon1) discount1 = maxDiscountMon1; 
						System.out.println("!!!!!!!!!!!!!!!!!!!!!!값 확인!!!!!!!!!!!!!!!!!"+discount1);
							}// else
					}model.addAttribute("category1", name1);
					model.addAttribute("discount1", discount1);
			}
			
			// 2번 카테고리
			if(records2.size()!=0) {
				
				int maxCount2 = records2.get(0).getMixCount();
				int maxDiscount2 = records2.get(0).getMaxDiscount();
				int minPayment2 = records2.get(0).getMinPayment();
				int discountPercent2 = records2.get(0).getDiscountPercent();
				int discount2 = 0;
				int maxDiscountMon2 = records2.get(0).getMaxDiscountMonth();
				int discountAmount2 = records2.get(0).getDiscountAmount();
				String name2 = records2.get(0).getLargeCategory().getLargeCategoryName();
				System.out.println(maxDiscountMon2);
				System.out.println(maxDiscount2);
				
				if(minPayment2 != 0) {
					if(maxCount2 != 0 && maxCount2 <= records2.size()) {						
						for(int i=0; i<maxCount2;i++) {
							if(records2.get(i).getConsume().getConsumePrice() >= minPayment2) {
								if(discountPercent2 != 0) discount2 += records2.get(i).getConsume().getConsumePrice() * discountPercent2/100;
								else if(discountAmount2 != 0) discount2 += discountAmount2;
								}//if			  
							 } 
						System.out.println("!!!!!!첫 for문!!!!!!!"+discount2);
						if(maxDiscount2!=0 && discount2 > maxDiscount2) discount2 = maxDiscount2;
						else if(maxDiscountMon2 !=0 && discount2 > maxDiscountMon2) discount2 = maxDiscountMon2;
						System.out.println("!!!!!!!!!!!!!!!!!!값 확인!!!!!!!!!!!!!!!!!!"+discount2);
					} else {
						for(int i=0; i<records2.size();i++) {
							if(records2.get(i).getConsume().getConsumePrice() >= minPayment2) {
								if(discountPercent2 != 0) discount2 += records2.get(i).getConsume().getConsumePrice() * discountPercent2/100;
								else if(discountAmount2 != 0) discount2 += discountAmount2;
								}//if
								} 
								System.out.println("!!!!!!두번째 for문!!!!!!!"+discount2);
								if(maxDiscount2!=0 && discount2 > maxDiscount2) discount2 = maxDiscount2;
								else if(maxDiscountMon2 !=0 && discount2 > maxDiscountMon2) discount2 = maxDiscountMon2;
								System.out.println("!!!!!!!!!!!!!!!!!!값 확인!!!!!!!!!!!!!!!!!!"+discount2);
								} 
					
						
				}else {
					if(maxCount2 != 0 && maxCount2 <= records2.size()) {						
						for(int i=0; i<maxCount2;i++) {
							if(records2.get(i).getConsume().getConsumePrice() >= minPayment2) {
								if(discountPercent2 != 0) discount2 += records2.get(i).getConsume().getConsumePrice() * discountPercent2/100;
								else if(discountAmount2 != 0) discount2 += discountAmount2;
								}//if1
							} 
						System.out.println("!!!!!!세번째 for문!!!!!!!"+discount2);
						if(maxDiscount2!=0 && discount2 > maxDiscount2) discount2 = records2.get(0).getMaxDiscount();
						else if(maxDiscountMon2 !=0 && discount2 > maxDiscountMon2) discount2 = records2.get(0).getMaxDiscountMonth(); 
						System.out.println("!!!!!!!!!!!!!!!!!!!!!!값 확인!!!!!!!!!!!!!!!!!"+discount2);
						}
					else {
						for(int i=0; i<records2.size();i++) {
							if(records2.get(i).getConsume().getConsumePrice() >= minPayment2) {
								if(discountPercent2 != 0) discount2 += records2.get(i).getConsume().getConsumePrice() * discountPercent2/100;
								else if(discountAmount2 != 0) discount2 += discountAmount2;
								}//if
							} 
						System.out.println("!!!!!!네번째 for문!!!!!!!"+discount2);
						if(maxDiscount2!=0 && discount2 > maxDiscount2) discount2 = maxDiscount2;
							else if(maxDiscountMon2 !=0 && discount2 > maxDiscountMon2) discount2 = maxDiscountMon2; 
						System.out.println("!!!!!!!!!!!!!!!!!!!!!!값 확인!!!!!!!!!!!!!!!!!"+discount2);
							}// else
					}model.addAttribute("name2", name2);
					model.addAttribute("discount2", discount2);
				}
			// 3번 카테고리
			if(records3.size()!=0) {
				int maxCount3 = records3.get(0).getMixCount();
				int maxDiscount3 = records3.get(0).getMaxDiscount();
				int minPayment3 = records3.get(0).getMinPayment();
				int discountPercent3 = records3.get(0).getDiscountPercent();
				int discount3 = 0;
				int maxDiscountMon3 = records3.get(0).getMaxDiscountMonth();
				int discountAmount3 = records3.get(0).getDiscountAmount();
				String name3 = records3.get(0).getLargeCategory().getLargeCategoryName();
				System.out.println(maxDiscountMon3);
				
				if(minPayment3 != 0) {
					if(maxCount3 != 0  && maxCount3 <= records3.size()) {						
						for(int i=0; i<maxCount3;i++) {
							if(records3.get(i).getConsume().getConsumePrice() >= minPayment3) {
								if(discountPercent3 != 0) discount3 += records3.get(i).getConsume().getConsumePrice() * discountPercent3/100;
								else if(discountAmount3 != 0) discount3 += discountAmount3;
								}//if			  
							 } 
						System.out.println("!!!!!!첫 for문!!!!!!!"+discount3);
						if(maxDiscount3!=0 && discount3 > maxDiscount3) discount3 = maxDiscount3;
						else if(maxDiscountMon3 !=0 && discount3 > maxDiscountMon3) discount3 = maxDiscountMon3;
						System.out.println("!!!!!!!!!!!!!!!!!!값 확인!!!!!!!!!!!!!!!!!!"+discount3);
					} else if(maxCount3==0) {
						for(int i=0; i<records3.size();i++) {
							if(records3.get(i).getConsume().getConsumePrice() >= minPayment3) {
								if(discountPercent3 != 0) discount3 += records3.get(i).getConsume().getConsumePrice() * discountPercent3/100;
								else if(discountAmount3 != 0) discount3 += discountAmount3;
								}//if
								} 
								System.out.println("!!!!!!두번째 for문!!!!!!!"+discount3);
								if(maxDiscount3!=0 && discount3 > maxDiscount3) discount3 = maxDiscount3;
								else if(maxDiscountMon3 !=0 && discount3 > maxDiscountMon3) discount3 = maxDiscountMon3;
								System.out.println("!!!!!!!!!!!!!!!!!!값 확인!!!!!!!!!!!!!!!!!!"+discount3);
						}
					
						
				}else {
					if(maxCount3 != 0 && maxCount3 <= records3.size()) {						
						for(int i=0; i<maxCount3;i++) {
							if(records3.get(i).getConsume().getConsumePrice() >= minPayment3) {
								if(discountPercent3 != 0) discount3 += records3.get(i).getConsume().getConsumePrice() * discountPercent3/100;
								else if(discountAmount3 != 0) discount3 += discountAmount3;
								}//if1
							} 
						System.out.println("!!!!!!세번째 for문!!!!!!!"+discount3);
						if(maxDiscount3!=0 && discount3 >= maxDiscount3) discount3 = records3.get(0).getMaxDiscount();
						else if(maxDiscountMon3 !=0 && discount3 > maxDiscountMon3) discount3 = records3.get(0).getMaxDiscountMonth(); 
						System.out.println("!!!!!!!!!!!!!!!!!!!!!!값 확인!!!!!!!!!!!!!!!!!"+discount3);
						}
					else {
						for(int i=0; i<records3.size();i++) {
							if(records3.get(i).getConsume().getConsumePrice() >= minPayment3) {
								if(discountPercent3 != 0) discount3 += records3.get(i).getConsume().getConsumePrice() * discountPercent3/100;
								else if(discountAmount3 != 0) discount3 += discountAmount3;
								}//if
							} 
						System.out.println("!!!!!!네번째 for문!!!!!!!"+discount3);
						if(maxDiscount3!=0 && discount3 > maxDiscount3) discount3 = maxDiscount3;
							else if(maxDiscountMon3 !=0 && discount3 > maxDiscountMon3) discount3 = maxDiscountMon3; 
						System.out.println("!!!!!!!!!!!!!!!!!!!!!!값 확인!!!!!!!!!!!!!!!!!"+discount3);
							}// else
					}model.addAttribute("name3", name3);
					model.addAttribute("discount3", discount3);
			}
			// 4번 카테고리
			if(records4.size()!=0) {
				int maxCount4 = records4.get(0).getMixCount();
				int maxDiscount4 = records4.get(0).getMaxDiscount();
				int minPayment4 = records4.get(0).getMinPayment();
				int discountPercent4 = records4.get(0).getDiscountPercent();
				int discount4 = 0;
				int maxDiscountMon4 = records4.get(0).getMaxDiscountMonth();
				int discountAmount4 = records4.get(0).getDiscountAmount();
				String name4 = records4.get(0).getLargeCategory().getLargeCategoryName();
				System.out.println("4번 카테고리 월 최대 할인금액"+discountAmount4);
				System.out.println("4번 카테고리 회당 할인 금액 또는 퍼센트 : "+discountPercent4+" %"+discountAmount4+" 원");
				System.out.println(records4);
				if(minPayment4 != 0) {
					if(maxCount4 != 0 && maxCount4 <= records4.size()) {						
						for(int i=0; i<maxCount4;i++) {
							if(records4.get(i).getConsume().getConsumePrice() >= minPayment4) {
								if(discountPercent4 != 0) discount4 += records4.get(i).getConsume().getConsumePrice() * (100-discountPercent4)/100;
								else if(discountAmount4 != 0) discount4 += discountAmount4;
								}//if			  
							 } 
						System.out.println("!!!!!!첫 for문!!!!!!!"+discount4);
						if(maxDiscount4!=0 && discount4 > maxDiscount4) discount4 = maxDiscount4;
						else if(maxDiscountMon4 !=0 && discount4 > maxDiscountMon4) discount4 = maxDiscountMon4;
						System.out.println("!!!!!!!!!!!!!!!!!!값 확인!!!!!!!!!!!!!!!!!!"+discount4);
					} else {
						for(int i=0; i<records4.size();i++) {
							if(records4.get(i).getConsume().getConsumePrice() >= minPayment4) {
								if(discountPercent4 != 0) discount4 += records4.get(i).getConsume().getConsumePrice() * (100-discountPercent4)/100;
								else if(discountAmount4 != 0) discount4 += discountAmount4;
								}//if
								} 
								System.out.println("!!!!!!두번째 for문!!!!!!!"+discount4);
								if(maxDiscount4!=0 && discount4 > maxDiscount4) discount4 = maxDiscount4;
								else if(maxDiscountMon4 !=0 && discount4 > maxDiscountMon4) discount4 = maxDiscountMon4;
								System.out.println("!!!!!!!!!!!!!!!!!!값 확인!!!!!!!!!!!!!!!!!!"+discount4);
					}
					
						
				}else {
					if(maxCount4 != 0 && maxCount4 <= records4.size()) {						
						for(int i=0; i<maxCount4;i++) {
							if(records4.get(i).getConsume().getConsumePrice() >= minPayment4) {
								if(discountPercent4 != 0) {discount4 += records4.get(i).getConsume().getConsumePrice() * discountPercent4/100;
								System.out.println("할인받은 금액"+ discount4);}
								else if(discountAmount4 != 0) discount4 += discountAmount4;
								System.out.println("할인 받은 금액 "+ discount4);
								}//if1
							} 
						System.out.println("!!!!!!세번째 for문!!!!!!!"+discount4);
						if(maxDiscount4!=0 && discount4 > maxDiscount4) discount4 = records4.get(0).getMaxDiscount();
						else if(maxDiscountMon4 !=0 && discount4 > maxDiscountMon4) discount4 = records4.get(0).getMaxDiscountMonth(); 
						System.out.println("!!!!!!!!!!!!!!!!!!!!!!값 확인!!!!!!!!!!!!!!!!!"+discount4);
						}
					else {
						for(int i=0; i<records4.size();i++) {
							if(records4.get(i).getConsume().getConsumePrice() >= minPayment4) {
								if(discountPercent4 != 0) discount4 += records4.get(i).getConsume().getConsumePrice() * discountPercent4/100;
								else if(discountAmount4 != 0) discount4 += discountAmount4;
								}//if
							} 
						System.out.println("!!!!!!네번째 for문!!!!!!!"+discount4);
						if(maxDiscount4!=0 && discount4 > maxDiscount4) discount4 = maxDiscount4;
							else if(maxDiscountMon4 !=0 && discount4 > maxDiscountMon4) discount4 = maxDiscountMon4; 
						System.out.println("!!!!!!!!!!!!!!!!!!!!!!값 확인!!!!!!!!!!!!!!!!!"+discount4);
							}// else
					}model.addAttribute("name4", name4);
					model.addAttribute("discount4", discount4);
			}
			// 5번 카테고리
			if(records5.size()!=0) {
				int maxCount5 = records5.get(0).getMixCount();
				int maxDiscount5 = records5.get(0).getMaxDiscount();
				int minPayment5 = records5.get(0).getMinPayment();
				int discountPercent5 = records5.get(0).getDiscountPercent();
				int discount5 = 0;
				int maxDiscountMon5 = records5.get(0).getMaxDiscountMonth();
				int discountAmount5 = records5.get(0).getDiscountAmount();
				String name5 = records5.get(0).getLargeCategory().getLargeCategoryName();
				System.out.println(maxDiscountMon5);
				
				if(minPayment5 != 0) {
					if(maxCount5 != 0 && maxCount5 <= records5.size()) {						
						for(int i=0; i<maxCount5;i++) {
							if(records5.get(i).getConsume().getConsumePrice() >= minPayment5) {
								if(discountPercent5 != 0) discount5 += records5.get(i).getConsume().getConsumePrice() * discountPercent5/100;
								else if(discountAmount5 != 0) discount5 += discountAmount5;
								}//if			  
							 } 
						System.out.println("!!!!!!첫 for문!!!!!!!"+discount5);
						if(maxDiscount5!=0 && discount5 > maxDiscount5) discount5 = maxDiscount5;
						else if(maxDiscountMon5 !=0 && discount5 > maxDiscountMon5) discount5 = maxDiscountMon5;
						System.out.println("!!!!!!!!!!!!!!!!!!값 확인!!!!!!!!!!!!!!!!!!"+discount5);
					} else if(maxCount5==0) {
						for(int i=0; i<records5.size();i++) {
							if(records5.get(i).getConsume().getConsumePrice() >= minPayment5) {
								if(discountPercent5 != 0) discount5 += records5.get(i).getConsume().getConsumePrice() * discountPercent5/100;
								else if(discountAmount5 != 0) discount5 += discountAmount5;
								}//if
								} 
								System.out.println("!!!!!!두번째 for문!!!!!!!"+discount5);
								if(maxDiscount5!=0 && discount5 > maxDiscount5) discount5 = maxDiscount5;
								else if(maxDiscountMon5 !=0 && discount5 > maxDiscountMon5) discount5 = maxDiscountMon5;
								System.out.println("!!!!!!!!!!!!!!!!!!값 확인!!!!!!!!!!!!!!!!!!"+discount5);
						}
					
						
				}else {
					if(maxCount5 != 0 && maxCount5 <= records5.size()) {						
						for(int i=0; i<maxCount5;i++) {
							if(records5.get(i).getConsume().getConsumePrice() >= minPayment5) {
								if(discountPercent5 != 0) discount5 += records5.get(i).getConsume().getConsumePrice() * discountPercent5/100;
								else if(discountAmount5 != 0) discount5 += discountAmount5;
								}//if1
							} 
						System.out.println("!!!!!!세번째 for문!!!!!!!"+discount5);
						if(maxDiscount5!=0 && discount5 > maxDiscount5) discount5 = records5.get(0).getMaxDiscount();
						else if(maxDiscountMon5 !=0 && discount5 > maxDiscountMon5) discount5 = records5.get(0).getMaxDiscountMonth(); 
						System.out.println("!!!!!!!!!!!!!!!!!!!!!!값 확인!!!!!!!!!!!!!!!!!"+discount5);
						}
					else {
						for(int i=0; i<records5.size();i++) {
							if(records5.get(i).getConsume().getConsumePrice() >= minPayment5) {
								if(discountPercent5 != 0) discount5 += records5.get(i).getConsume().getConsumePrice() * discountPercent5/100;
								else if(discountAmount5 != 0) discount5 += discountAmount5;
								}//if
							} 
						System.out.println("!!!!!!네번째 for문!!!!!!!"+discount5);
						if(maxDiscount5!=0 && discount5 > maxDiscount5) discount5 = maxDiscount5;
							else if(maxDiscountMon5 !=0 && discount5 > maxDiscountMon5) discount5 = maxDiscountMon5; 
						System.out.println("!!!!!!!!!!!!!!!!!!!!!!값 확인!!!!!!!!!!!!!!!!!"+discount5);
							}// else
					}model.addAttribute("name5", name5);
					model.addAttribute("discount5", discount5);
			}
			//6번 카테고리
			if(records6.size()!=0) {
				int maxCount6 = records6.get(0).getMixCount();
				int maxDiscount6 = records6.get(0).getMaxDiscount();
				int minPayment6 = records6.get(0).getMinPayment();
				int discountPercent6 = records6.get(0).getDiscountPercent();
				int discount6 = 0;
				int maxDiscountMon6 = records6.get(0).getMaxDiscountMonth();
				int discountAmount6 = records6.get(0).getDiscountAmount();
				System.out.println(maxDiscountMon6);
				
				if(minPayment6 != 0) {
					if(maxCount6 != 0 && maxCount6 <= records6.size()) {						
						for(int i=0; i<maxCount6;i++) {
							if(records6.get(i).getConsume().getConsumePrice() >= minPayment6) {
								if(discountPercent6 != 0) discount6 += records6.get(i).getConsume().getConsumePrice() * discountPercent6/100;
								else if(discountAmount6 != 0) discount6 += discountAmount6;
								}//if			  
							 } 
						System.out.println("!!!!!!첫 for문!!!!!!!"+discount6);
						if(maxDiscount6!=0 && discount6 > maxDiscount6) discount6 = maxDiscount6;
						else if(maxDiscountMon6 !=0 && discount6 > maxDiscountMon6) discount6 = maxDiscountMon6;
						System.out.println("!!!!!!!!!!!!!!!!!!값 확인!!!!!!!!!!!!!!!!!!"+discount6);
					} else if(maxCount6==0) {
						for(int i=0; i<records6.size();i++) {
							if(records6.get(i).getConsume().getConsumePrice() >= minPayment6) {
								if(discountPercent6 != 0) discount6 += records6.get(i).getConsume().getConsumePrice() * discountPercent6/100;
								else if(discountAmount6 != 0) discount6 += discountAmount6;
								}//if
								} 
								System.out.println("!!!!!!두번째 for문!!!!!!!"+discount6);
								if(maxDiscount6!=0 && discount6 > maxDiscount6) discount6 = maxDiscount6;
								else if(maxDiscountMon6 !=0 && discount6 > maxDiscountMon6) discount6 = maxDiscountMon6;
								System.out.println("!!!!!!!!!!!!!!!!!!값 확인!!!!!!!!!!!!!!!!!!"+discount6);
						}
					
						
				}else {
					if(maxCount6 != 0 && maxCount6 <= records6.size()) {						
						for(int i=0; i<maxCount6;i++) {
							if(records6.get(i).getConsume().getConsumePrice() >= minPayment6) {
								if(discountPercent6 != 0) discount6 += records6.get(i).getConsume().getConsumePrice() * discountPercent6/100;
								else if(discountAmount6 != 0) discount6 += discountAmount6;
								}//if1
							} 
						System.out.println("!!!!!!세번째 for문!!!!!!!"+discount6);
						if(maxDiscount6!=0 && discount6 > maxDiscount6) discount6 = records6.get(0).getMaxDiscount();
						else if(maxDiscountMon6 !=0 && discount6 > maxDiscountMon6) discount6 = records6.get(0).getMaxDiscountMonth(); 
						System.out.println("!!!!!!!!!!!!!!!!!!!!!!값 확인!!!!!!!!!!!!!!!!!"+discount6);
						}
					else {
						for(int i=0; i<records6.size();i++) {
							if(records6.get(i).getConsume().getConsumePrice() >= minPayment6) {
								if(discountPercent6 != 0) discount6 += records6.get(i).getConsume().getConsumePrice() * discountPercent6/100;
								else if(discountAmount6 != 0) discount6 += discountAmount6;
								}//if
							} 
						System.out.println("!!!!!!네번째 for문!!!!!!!"+discount6);
						if(maxDiscount6!=0 && discount6 > maxDiscount6) discount6 = maxDiscount6;
							else if(maxDiscountMon6 !=0 && discount6 > maxDiscountMon6) discount6 = maxDiscountMon6; 
						System.out.println("!!!!!!!!!!!!!!!!!!!!!!값 확인!!!!!!!!!!!!!!!!!"+discount6);
							}// else
					}System.out.println(discount6);
			}
			// 7번 카테고리
			if(records7.size()!=0) {
				int maxCount7 = records7.get(0).getMixCount();
				int maxDiscount7 = records7.get(0).getMaxDiscount();
				int minPayment7 = records7.get(0).getMinPayment();
				int discountPercent7 = records7.get(0).getDiscountPercent();
				int discount7 = 0;
				int maxDiscountMon7 = records7.get(0).getMaxDiscountMonth();
				int discountAmount7 = records7.get(0).getDiscountAmount();
				System.out.println(maxDiscountMon7);
				
				if(minPayment7 != 0) {
					if(maxCount7 != 0 && maxCount7 <= records7.size()) {						
						for(int i=0; i<maxCount7;i++) {
							if(records7.get(i).getConsume().getConsumePrice() >= minPayment7) {
								if(discountPercent7 != 0) discount7 += records7.get(i).getConsume().getConsumePrice() * discountPercent7/100;
								else if(discountAmount7 != 0) discount7 += discountAmount7;
								}//if			  
							 } 
						System.out.println("!!!!!!첫 for문!!!!!!!"+discount7);
						if(maxDiscount7!=0 && discount7 > maxDiscount7) discount7 = maxDiscount7;
						else if(maxDiscountMon7 !=0 && discount7 > maxDiscountMon7) discount7 = maxDiscountMon7;
						System.out.println("!!!!!!!!!!!!!!!!!!값 확인!!!!!!!!!!!!!!!!!!"+discount7);
					} else if(maxCount7==0) {
						for(int i=0; i<records7.size();i++) {
							if(records7.get(i).getConsume().getConsumePrice() >= minPayment7) {
								if(discountPercent7 != 0) discount7 += records7.get(i).getConsume().getConsumePrice() * discountPercent7/100;
								else if(discountAmount7 != 0) discount7 += discountAmount7;
								}//if
								} 
								System.out.println("!!!!!!두번째 for문!!!!!!!"+discount7);
								if(maxDiscount7!=0 && discount7 > maxDiscount7) discount7 = maxDiscount7;
								else if(maxDiscountMon7 !=0 && discount7 > maxDiscountMon7) discount7 = maxDiscountMon7;
								System.out.println("!!!!!!!!!!!!!!!!!!값 확인!!!!!!!!!!!!!!!!!!"+discount7);
						}
					
						
				}else {
					if(maxCount7 != 0 && maxCount7 <= records7.size()) {						
						for(int i=0; i<maxCount7;i++) {
							if(records7.get(i).getConsume().getConsumePrice() >= minPayment7) {
								if(discountPercent7 != 0) discount7 += records7.get(i).getConsume().getConsumePrice() * discountPercent7/100;
								else if(discountAmount7 != 0) discount7 += discountAmount7;
								}//if1
							} 
						System.out.println("!!!!!!세번째 for문!!!!!!!"+discount7);
						if(maxDiscount7!=0 && discount7 > maxDiscount7) discount7 = records7.get(0).getMaxDiscount();
						else if(maxDiscountMon7 !=0 && discount7 > maxDiscountMon7) discount7 = records7.get(0).getMaxDiscountMonth(); 
						System.out.println("!!!!!!!!!!!!!!!!!!!!!!값 확인!!!!!!!!!!!!!!!!!"+discount7);
						}
					else {
						for(int i=0; i<records7.size();i++) {
							if(records7.get(i).getConsume().getConsumePrice() >= minPayment7) {
								if(discountPercent7 != 0) discount7 += records7.get(i).getConsume().getConsumePrice() * discountPercent7/100;
								else if(discountAmount7 != 0) discount7 += discountAmount7;
								}//if
							} 
						System.out.println("!!!!!!네번째 for문!!!!!!!"+discount7);
						if(maxDiscount7!=0 && discount7 > maxDiscount7) discount7 = maxDiscount7;
							else if(maxDiscountMon7 !=0 && discount7 > maxDiscountMon7) discount7 = maxDiscountMon7; 
						System.out.println("!!!!!!!!!!!!!!!!!!!!!!값 확인!!!!!!!!!!!!!!!!!"+discount7);
							}// else
					}System.out.println(discount7);
			}
			// 8번 카테고리
			if(records8.size()!=0) {
				int maxCount8 = records8.get(0).getMixCount();
				int maxDiscount8 = records8.get(0).getMaxDiscount();
				int minPayment8 = records8.get(0).getMinPayment();
				int discountPercent8 = records8.get(0).getDiscountPercent();
				int discount8 = 0;
				int maxDiscountMon8 = records8.get(0).getMaxDiscountMonth();
				int discountAmount8 = records8.get(0).getDiscountAmount();
				System.out.println(maxDiscountMon8);
				
				if(minPayment8 != 0) {
					if(maxCount8 != 0 && maxCount8 <= records8.size()) {						
						for(int i=0; i<maxCount8;i++) {
							if(records8.get(i).getConsume().getConsumePrice() >= minPayment8) {
								if(discountPercent8 != 0) discount8 += records8.get(i).getConsume().getConsumePrice() * discountPercent8/100;
								else if(discountAmount8 != 0) discount8 += discountAmount8;
								}//if			  
							 } 
						System.out.println("!!!!!!첫 for문!!!!!!!"+discount8);
						if(maxDiscount8!=0 && discount8 > maxDiscount8) discount8 = maxDiscount8;
						else if(maxDiscountMon8 !=0 && discount8 > maxDiscountMon8) discount8 = maxDiscountMon8;
						System.out.println("!!!!!!!!!!!!!!!!!!값 확인!!!!!!!!!!!!!!!!!!"+discount8);
					} else if(maxCount8==0) {
						for(int i=0; i<records8.size();i++) {
							if(records8.get(i).getConsume().getConsumePrice() >= minPayment8) {
								if(discountPercent8 != 0) discount8 += records8.get(i).getConsume().getConsumePrice() * discountPercent8/100;
								else if(discountAmount8 != 0) discount8 += discountAmount8;
								}//if
								} 
								System.out.println("!!!!!!두번째 for문!!!!!!!"+discount8);
								if(maxDiscount8!=0 && discount8 > maxDiscount8) discount8 = maxDiscount8;
								else if(maxDiscountMon8 !=0 && discount8 > maxDiscountMon8) discount8 = maxDiscountMon8;
								System.out.println("!!!!!!!!!!!!!!!!!!값 확인!!!!!!!!!!!!!!!!!!"+discount8);
						}
					
						
				}else {
					if(maxCount8 != 0  && maxCount8 <= records8.size()) {						
						for(int i=0; i<maxCount8;i++) {
							if(records8.get(i).getConsume().getConsumePrice() >= minPayment8) {
								if(discountPercent8 != 0) discount8 += records8.get(i).getConsume().getConsumePrice() * discountPercent8/100;
								else if(discountAmount8 != 0) discount8 += discountAmount8;
								}//if1
							} 
						System.out.println("!!!!!!세번째 for문!!!!!!!"+discount8);
						if(maxDiscount8!=0 && discount8 > maxDiscount8) discount8 = records8.get(0).getMaxDiscount();
						else if(maxDiscountMon8 !=0 && discount8 > maxDiscountMon8) discount8 = records8.get(0).getMaxDiscountMonth(); 
						System.out.println("!!!!!!!!!!!!!!!!!!!!!!값 확인!!!!!!!!!!!!!!!!!"+discount8);
						}
					else {
						for(int i=0; i<records8.size();i++) {
							if(records8.get(i).getConsume().getConsumePrice() >= minPayment8) {
								if(discountPercent8 != 0) discount8 += records8.get(i).getConsume().getConsumePrice() * discountPercent8/100;
								else if(discountAmount8 != 0) discount8 += discountAmount8;
								}//if
							} 
						System.out.println("!!!!!!네번째 for문!!!!!!!"+discount8);
						if(maxDiscount8!=0 && discount8 > maxDiscount8) discount8 = maxDiscount8;
							else if(maxDiscountMon8 !=0 && discount8 > maxDiscountMon8) discount8 = maxDiscountMon8; 
						System.out.println("!!!!!!!!!!!!!!!!!!!!!!값 확인!!!!!!!!!!!!!!!!!"+discount8);
							}// else
					}System.out.println(discount8);
			}
			// 9번 카테고리
			if(records9.size()!=0) {
				int maxCount9 = records9.get(0).getMixCount();
				int maxDiscount9 = records9.get(0).getMaxDiscount();
				int minPayment9 = records9.get(0).getMinPayment();
				int discountPercent9 = records9.get(0).getDiscountPercent();
				int discount9 = 0;
				int maxDiscountMon9 = records9.get(0).getMaxDiscountMonth();
				int discountAmount9 = records9.get(0).getDiscountAmount();
				System.out.println(maxDiscountMon9);
				
				if(minPayment9 != 0) {
					if(maxCount9 != 0  && maxCount9 <= records9.size()) {						
						for(int i=0; i<maxCount9;i++) {
							if(records9.get(i).getConsume().getConsumePrice() >= minPayment9) {
								if(discountPercent9 != 0) discount9 += records9.get(i).getConsume().getConsumePrice() * discountPercent9/100;
								else if(discountAmount9 != 0) discount9 += discountAmount9;
								}//if			  
							 } 
						System.out.println("!!!!!!첫 for문!!!!!!!"+discount9);
						if(maxDiscount9!=0 && discount9 > maxDiscount9) discount9 = maxDiscount9;
						else if(maxDiscountMon9 !=0 && discount9 > maxDiscountMon9) discount9 = maxDiscountMon9;
						System.out.println("!!!!!!!!!!!!!!!!!!값 확인!!!!!!!!!!!!!!!!!!"+discount9);
					} else if(maxCount9==0) {
						for(int i=0; i<records9.size();i++) {
							if(records9.get(i).getConsume().getConsumePrice() >= minPayment9) {
								if(discountPercent9 != 0) discount9 += records9.get(i).getConsume().getConsumePrice() * discountPercent9/100;
								else if(discountAmount9 != 0) discount9 += discountAmount9;
								}//if
								} 
								System.out.println("!!!!!!두번째 for문!!!!!!!"+discount9);
								if(maxDiscountMon9!=0 && discount9 > maxDiscountMon9) discount9 = maxDiscountMon9;
								else if(maxDiscountMon9 !=0 && discount9 > maxDiscountMon9) discount9 = maxDiscountMon9;
								System.out.println("!!!!!!!!!!!!!!!!!!값 확인!!!!!!!!!!!!!!!!!!"+discount9);
						}
					
						
				}else {
					if(maxCount9 != 0  && maxCount9 <= records9.size()) {						
						for(int i=0; i<maxCount9;i++) {
							if(records9.get(i).getConsume().getConsumePrice() >= minPayment9) {
								if(discountPercent9 != 0) discount9 += records9.get(i).getConsume().getConsumePrice() * discountPercent9/100;
								else if(discountAmount9 != 0) discount9 += discountAmount9;
								}//if1
							} 
						System.out.println("!!!!!!세번째 for문!!!!!!!"+discount9);
						if(maxDiscountMon9!=0 && discount9 > maxDiscountMon9) discount9 = records9.get(0).getMaxDiscount();
						else if(maxDiscountMon9 !=0 && discount9 > maxDiscountMon9) discount9 = records9.get(0).getMaxDiscountMonth(); 
						System.out.println("!!!!!!!!!!!!!!!!!!!!!!값 확인!!!!!!!!!!!!!!!!!"+discount9);
						}
					else {
						for(int i=0; i<records9.size();i++) {
							if(records9.get(i).getConsume().getConsumePrice() >= minPayment9) {
								if(discountPercent9 != 0) discount9 += records9.get(i).getConsume().getConsumePrice() * discountPercent9/100;
								else if(discountAmount9 != 0) discount9 += discountAmount9;
								}//if
							} 
						System.out.println("!!!!!!네번째 for문!!!!!!!"+discount9);
						if(maxDiscountMon9!=0 && discount9 > maxDiscountMon9) discount9 = maxDiscountMon9;
							else if(maxDiscountMon9 !=0 && discount9 > maxDiscountMon9) discount9 = maxDiscountMon9; 
						System.out.println("!!!!!!!!!!!!!!!!!!!!!!값 확인!!!!!!!!!!!!!!!!!"+discount9);
							}// else
					}System.out.println(discount9);
			}
			// 10번 카테고리
			if(records10.size()!=0) {
				int maxCount10 = records10.get(0).getMixCount();
				int maxDiscount10 = records10.get(0).getMaxDiscount();
				int minPayment10 = records10.get(0).getMinPayment();
				int discountPercent10 = records10.get(0).getDiscountPercent();
				int discount10 = 0;
				int maxDiscountMon10 = records10.get(0).getMaxDiscountMonth();
				int discountAmount10 = records10.get(0).getDiscountAmount();
				System.out.println(maxDiscountMon10);
				
				if(minPayment10 != 0) {
					if(maxCount10 != 0  && maxCount10 <= records10.size()) {						
						for(int i=0; i<maxCount10;i++) {
							if(records10.get(i).getConsume().getConsumePrice() >= minPayment10) {
								if(discountPercent10 != 0) discount10 += records10.get(i).getConsume().getConsumePrice() * discountPercent10/100;
								else if(discountAmount10 != 0) discount10 += discountAmount10;
								}//if			  
							 } 
						System.out.println("!!!!!!첫 for문!!!!!!!"+discount10);
						if(maxDiscount10!=0 && discount10 > maxDiscount10) discount10 = maxDiscount10;
						else if(maxDiscountMon10 !=0 && discount10 > maxDiscountMon10) discount10 = maxDiscountMon10;
						System.out.println("!!!!!!!!!!!!!!!!!!값 확인!!!!!!!!!!!!!!!!!!"+discount10);
					} else if(maxCount10==0) {
						for(int i=0; i<records10.size();i++) {
							if(records10.get(i).getConsume().getConsumePrice() >= minPayment10) {
								if(discountPercent10 != 0) discount10 += records10.get(i).getConsume().getConsumePrice() * discountPercent10/100;
								else if(discountAmount10 != 0) discount10 += discountAmount10;
								}//if
								} 
								System.out.println("!!!!!!두번째 for문!!!!!!!"+discount10);
								if(maxDiscount10!=0 && discount10 > maxDiscount10) discount10 = maxDiscount10;
								else if(maxDiscountMon10 !=0 && discount10 > maxDiscountMon10) discount10 = maxDiscountMon10;
								System.out.println("!!!!!!!!!!!!!!!!!!값 확인!!!!!!!!!!!!!!!!!!"+discount10);
						}
					
						
				}else {
					if(maxCount10 != 0  && maxCount10 <= records10.size()) {						
						for(int i=0; i<maxCount10;i++) {
							if(records10.get(i).getConsume().getConsumePrice() >= minPayment10) {
								if(discountPercent10 != 0) discount10 += records10.get(i).getConsume().getConsumePrice() * discountPercent10/100;
								else if(discountAmount10 != 0) discount10 += discountAmount10;
								}//if1
							} 
						System.out.println("!!!!!!세번째 for문!!!!!!!"+discount10);
						if(maxDiscount10!=0 && discount10 > maxDiscount10) discount10 = records10.get(0).getMaxDiscount();
						else if(maxDiscountMon10 !=0 && discount10 > maxDiscountMon10) discount10 = records10.get(0).getMaxDiscountMonth(); 
						System.out.println("!!!!!!!!!!!!!!!!!!!!!!값 확인!!!!!!!!!!!!!!!!!"+discount10);
						}
					else {
						for(int i=0; i<records10.size();i++) {
							if(records10.get(i).getConsume().getConsumePrice() >= minPayment10) {
								if(discountPercent10 != 0) discount10 += records10.get(i).getConsume().getConsumePrice() * discountPercent10/100;
								else if(discountAmount10 != 0) discount10 += discountAmount10;
								}//if
							} 
						System.out.println("!!!!!!네번째 for문!!!!!!!"+discount10);
						if(maxDiscount10!=0 && discount10 > maxDiscount10) discount10 = maxDiscount10;
							else if(maxDiscountMon10 !=0 && discount10 > maxDiscountMon10) discount10 = maxDiscountMon10; 
						System.out.println("!!!!!!!!!!!!!!!!!!!!!!값 확인!!!!!!!!!!!!!!!!!"+discount10);
							}// else
					}System.out.println(discount10);
			}
			// 11번 카테고리
			if(records11.size()!=0) {
				int maxCount11 = records11.get(0).getMixCount();
				int maxDiscount11 = records11.get(0).getMaxDiscount();
				int minPayment11 = records11.get(0).getMinPayment();
				int discountPercent11 = records11.get(0).getDiscountPercent();
				int discount11 = 0;
				int maxDiscountMon11 = records11.get(0).getMaxDiscountMonth();
				int discountAmount11 = records11.get(0).getDiscountAmount();
				System.out.println(maxDiscountMon11);
				
				if(minPayment11 != 0) {
					if(maxCount11 != 0  && maxCount11 <= records11.size()) {						
						for(int i=0; i<maxCount11;i++) {
							if(records11.get(i).getConsume().getConsumePrice() >= minPayment11) {
								if(discountPercent11 != 0) discount11 += records11.get(i).getConsume().getConsumePrice() * (100-discountPercent11)/100;
								else if(discountAmount11 != 0) discount11 += discountAmount11;
								}//if			  
							 } 
						System.out.println("!!!!!!첫 for문!!!!!!!"+discount11);
						if(maxDiscount11!=0 && discount11 > maxDiscount11) discount11 = maxDiscount11;
						else if(maxDiscountMon11 !=0 && discount11 > maxDiscountMon11) discount11 = maxDiscountMon11;
						System.out.println("!!!!!!!!!!!!!!!!!!값 확인!!!!!!!!!!!!!!!!!!"+discount11);
					} else if(maxCount11==0) {
						for(int i=0; i<records11.size();i++) {
							if(records11.get(i).getConsume().getConsumePrice() >= minPayment11) {
								if(discountPercent11 != 0) discount11 += records11.get(i).getConsume().getConsumePrice() * (100-discountPercent11)/100;
								else if(discountAmount11 != 0) discount11 += discountAmount11;
								}//if
								} 
								System.out.println("!!!!!!두번째 for문!!!!!!!"+discount11);
								if(maxDiscount11!=0 && discount11 > maxDiscount11) discount11 = maxDiscount11;
								else if(maxDiscountMon11 !=0 && discount11 > maxDiscountMon11) discount11 = maxDiscountMon11;
								System.out.println("!!!!!!!!!!!!!!!!!!값 확인!!!!!!!!!!!!!!!!!!"+discount11);
						}
					
						
				}else {
					if(maxCount11 != 0  && maxCount11 <= records11.size()) {						
						for(int i=0; i<maxCount11;i++) {
							if(records11.get(i).getConsume().getConsumePrice() >= minPayment11) {
								if(discountPercent11 != 0) discount11 += records11.get(i).getConsume().getConsumePrice() * discountPercent11/100;
								else if(discountAmount11 != 0) discount11 += discountAmount11;
								}//if1
							} 
						System.out.println("!!!!!!세번째 for문!!!!!!!"+discount11);
						if(maxDiscount11!=0 && discount11 > maxDiscount11) discount11 = records11.get(0).getMaxDiscount();
						else if(maxDiscountMon11 !=0 && discount11 > maxDiscountMon11) discount11 = records11.get(0).getMaxDiscountMonth(); 
						System.out.println("!!!!!!!!!!!!!!!!!!!!!!값 확인!!!!!!!!!!!!!!!!!"+discount11);
						}
					else {
						for(int i=0; i<records11.size();i++) {
							if(records11.get(i).getConsume().getConsumePrice() >= minPayment11) {
								if(discountPercent11 != 0) discount11 += records11.get(i).getConsume().getConsumePrice() * discountPercent11/100;
								else if(discountAmount11 != 0) discount11 += discountAmount11;
								}//if
							} 
						System.out.println("!!!!!!네번째 for문!!!!!!!"+discount11);
						if(maxDiscount11!=0 && discount11 > maxDiscount11) discount11 = maxDiscount11;
							else if(maxDiscountMon11 !=0 && discount11 > maxDiscountMon11) discount11 = maxDiscountMon11; 
						System.out.println("!!!!!!!!!!!!!!!!!!!!!!값 확인!!!!!!!!!!!!!!!!!"+discount11);
							}// else
					}System.out.println(discount11);
			}
			// 12번 카테고리
			if(records12.size()!=0) {
				int maxCount12 = records12.get(0).getMixCount();
				int maxDiscount12 = records12.get(0).getMaxDiscount();
				int minPayment12 = records12.get(0).getMinPayment();
				int discountPercent12 = records12.get(0).getDiscountPercent();
				int discount12 = 0;
				int maxDiscountMon12 = records12.get(0).getMaxDiscountMonth();
				int discountAmount12 = records12.get(0).getDiscountAmount();
				String name12 = records12.get(0).getLargeCategory().getLargeCategoryName();
				System.out.println(maxDiscountMon12);
				
				if(minPayment12 != 0) {
					if(maxCount12 != 0  && maxCount12 <= records12.size()) {						
						for(int i=0; i<maxCount12;i++) {
							if(records12.get(i).getConsume().getConsumePrice() >= minPayment12) {
								if(discountPercent12 != 0) discount12 += records12.get(i).getConsume().getConsumePrice() * discountPercent12/100;
								else if(discountAmount12 != 0) discount12 += discountAmount12;
								}//if			  
							 } 
						System.out.println("!!!!!!첫 for문!!!!!!!"+discount12);
						if(maxDiscount12!=0 && discount12 > maxDiscount12) discount12 = maxDiscount12;
						else if(maxDiscountMon12 !=0 && discount12 > maxDiscountMon12) discount12 = maxDiscountMon12;
						System.out.println("!!!!!!!!!!!!!!!!!!값 확인!!!!!!!!!!!!!!!!!!"+discount12);
					} else {
						for(int i=0; i<records12.size();i++) {
							if(records12.get(i).getConsume().getConsumePrice() >= minPayment12) {
								if(discountPercent12 != 0) discount12 += records12.get(i).getConsume().getConsumePrice() * discountPercent12/100;
								else if(discountAmount12 != 0) discount12 += discountAmount12;
								}//if
								} 
								System.out.println("!!!!!!두번째 for문!!!!!!!"+discount12);
								if(maxDiscount12!=0 && discount12 > maxDiscount12) discount12 = maxDiscount12;
								else if(maxDiscountMon12 !=0 && discount12 > maxDiscountMon12) discount12 = maxDiscountMon12;
								System.out.println("!!!!!!!!!!!!!!!!!!값 확인!!!!!!!!!!!!!!!!!!"+discount12);
						}
					
						
				}else {
					if(maxCount12 != 0  && maxCount12 <= records12.size()) {						
						for(int i=0; i<maxCount12;i++) {
							if(records12.get(i).getConsume().getConsumePrice() >= minPayment12) {
								if(discountPercent12 != 0) discount12 += records12.get(i).getConsume().getConsumePrice() * discountPercent12/100;
								else if(discountAmount12 != 0) discount12 += discountAmount12;
								}//if1
							} 
						System.out.println("!!!!!!세번째 for문!!!!!!!"+discount12);
						if(maxDiscount12!=0 && discount12 > maxDiscount12) discount12 = records12.get(0).getMaxDiscount();
						else if(maxDiscountMon12 !=0 && discount12 > maxDiscountMon12) discount12 = records12.get(0).getMaxDiscountMonth(); 
						System.out.println("!!!!!!!!!!!!!!!!!!!!!!값 확인!!!!!!!!!!!!!!!!!"+discount12);
						}
					else {
						for(int i=0; i<records12.size();i++) {
							if(records12.get(i).getConsume().getConsumePrice() >= minPayment12) {
								if(discountPercent12 != 0) discount12 += records12.get(i).getConsume().getConsumePrice() * discountPercent12/100;
								else if(discountAmount12 != 0) discount12 += discountAmount12;
								}//if
							} 
						System.out.println("!!!!!!네번째 for문!!!!!!!"+discount12);
						if(maxDiscount12!=0 && discount12 > maxDiscount12) discount12 = maxDiscount12;
							else if(maxDiscountMon12 !=0 && discount12 > maxDiscountMon12) discount12 = maxDiscountMon12; 
						System.out.println("!!!!!!!!!!!!!!!!!!!!!!값 확인!!!!!!!!!!!!!!!!!"+discount12);
							}// else
					}model.addAttribute("name12", name12);
					model.addAttribute("discount12", discount12);
			}
			// 13번 카테고리
			if(records13.size()!=0) {
				int maxCount13 = records13.get(0).getMixCount();
				int maxDiscount13 = records13.get(0).getMaxDiscount();
				int minPayment13 = records13.get(0).getMinPayment();
				int discountPercent13 = records13.get(0).getDiscountPercent();
				int discount13 = 0;
				int maxDiscountMon13 = records13.get(0).getMaxDiscountMonth();
				int discountAmount13 = records13.get(0).getDiscountAmount();
				System.out.println(maxDiscountMon13);
				
				if(minPayment13 != 0) {
					if(maxCount13 != 0  && maxCount13 <= records13.size()) {						
						for(int i=0; i<maxCount13;i++) {
							if(records13.get(i).getConsume().getConsumePrice() >= minPayment13) {
								if(discountPercent13 != 0) discount13 += records13.get(i).getConsume().getConsumePrice() * discountPercent13/100;
								else if(discountAmount13 != 0) discount13 += discountAmount13;
								}//if			  
							 } 
						System.out.println("!!!!!!첫 for문!!!!!!!"+discount13);
						if(maxDiscount13!=0 && discount13 > maxDiscount13) discount13 = maxDiscount13;
						else if(maxDiscountMon13 !=0 && discount13 > maxDiscountMon13) discount13 = maxDiscountMon13;
						System.out.println("!!!!!!!!!!!!!!!!!!값 확인!!!!!!!!!!!!!!!!!!"+discount13);
					} else {
						for(int i=0; i<records13.size();i++) {
							if(records13.get(i).getConsume().getConsumePrice() >= minPayment13) {
								if(discountPercent13 != 0) discount13 += records13.get(i).getConsume().getConsumePrice() * discountPercent13/100;
								else if(discountAmount13 != 0) discount13 += discountAmount13;
								}//if
								} 
								System.out.println("!!!!!!두번째 for문!!!!!!!"+discount13);
								if(maxDiscount13!=0 && discount13 > maxDiscount13) discount13 = maxDiscount13;
								else if(maxDiscountMon13 !=0 && discount13 > maxDiscountMon13) discount13 = maxDiscountMon13;
								System.out.println("!!!!!!!!!!!!!!!!!!값 확인!!!!!!!!!!!!!!!!!!"+discount13);
						}
					
						
				}else {
					if(maxCount13 != 0 && maxCount13 <= records13.size()) {						
						for(int i=0; i<maxCount13;i++) {
							if(records13.get(i).getConsume().getConsumePrice() >= minPayment13) {
								if(discountPercent13 != 0) discount13 += records13.get(i).getConsume().getConsumePrice() * discountPercent13/100;
								else if(discountAmount13 != 0) discount13 += discountAmount13;
								}//if1
							} 
						System.out.println("!!!!!!세번째 for문!!!!!!!"+discount13);
						if(maxDiscount13!=0 && discount13 > maxDiscount13) discount13 = records13.get(0).getMaxDiscount();
						else if(maxDiscountMon13 !=0 && discount13 > maxDiscountMon13) discount13 = records13.get(0).getMaxDiscountMonth(); 
						System.out.println("!!!!!!!!!!!!!!!!!!!!!!값 확인!!!!!!!!!!!!!!!!!"+discount13);
						}
					else {
						for(int i=0; i<records13.size();i++) {
							if(records13.get(i).getConsume().getConsumePrice() >= minPayment13) {
								if(discountPercent13 != 0) discount13 += records13.get(i).getConsume().getConsumePrice() * discountPercent13/100;
								else if(discountAmount13 != 0) discount13 += discountAmount13;
								}//if
							} 
						System.out.println("!!!!!!네번째 for문!!!!!!!"+discount13);
						if(maxDiscount13!=0 && discount13 > maxDiscount13) discount13 = maxDiscount13;
							else if(maxDiscountMon13 !=0 && discount13 > maxDiscountMon13) discount13 = maxDiscountMon13; 
						System.out.println("!!!!!!!!!!!!!!!!!!!!!!값 확인!!!!!!!!!!!!!!!!!"+discount13);
							}// else
					}System.out.println(discount13);
			}
			// 14번 카테고리
			if(records14.size()!=0) {
				int maxCount14 = records14.get(0).getMixCount();
				int maxDiscount14 = records14.get(0).getMaxDiscount();
				int minPayment14 = records14.get(0).getMinPayment();
				int discountPercent14 = records14.get(0).getDiscountPercent();
				int discount14 = 0;
				int maxDiscountMon14 = records14.get(0).getMaxDiscountMonth();
				int discountAmount14 = records14.get(0).getDiscountAmount();
				System.out.println(maxDiscountMon14);
				
				if(minPayment14 != 0) {
					if(maxCount14 != 0 && maxCount14 <= records14.size()) {						
						for(int i=0; i<maxCount14;i++) {
							if(records14.get(i).getConsume().getConsumePrice() >= minPayment14) {
								if(discountPercent14 != 0) discount14 += records14.get(i).getConsume().getConsumePrice() * discountPercent14/100;
								else if(discountAmount14 != 0) discount14 += discountAmount14;
								}//if			  
							 } 
						System.out.println("!!!!!!첫 for문!!!!!!!"+discount14);
						if(maxDiscount14!=0 && discount14 > maxDiscount14) discount14 = maxDiscount14;
						else if(maxDiscountMon14 !=0 && discount14 > maxDiscountMon14) discount14 = maxDiscountMon14;
						System.out.println("!!!!!!!!!!!!!!!!!!값 확인!!!!!!!!!!!!!!!!!!"+discount14);
					} else {
						for(int i=0; i<records14.size();i++) {
							if(records14.get(i).getConsume().getConsumePrice() >= minPayment14) {
								if(discountPercent14 != 0) discount14 += records14.get(i).getConsume().getConsumePrice() * discountPercent14/100;
								else if(discountAmount14 != 0) discount14 += discountAmount14;
								}//if
								} 
								System.out.println("!!!!!!두번째 for문!!!!!!!"+discount14);
								if(maxDiscount14!=0 && discount14 > maxDiscount14) discount14 = maxDiscount14;
								else if(maxDiscountMon14 !=0 && discount14 > maxDiscountMon14) discount14 = maxDiscountMon14;
								System.out.println("!!!!!!!!!!!!!!!!!!값 확인!!!!!!!!!!!!!!!!!!"+discount14);
						}
					
						
				}else {
					if(maxCount14 != 0 && maxCount14 <= records14.size()) {						
						for(int i=0; i<maxCount14;i++) {
							if(records14.get(i).getConsume().getConsumePrice() >= minPayment14) {
								if(discountPercent14 != 0) discount14 += records14.get(i).getConsume().getConsumePrice() * discountPercent14/100;
								else if(discountAmount14 != 0) discount14 += discountAmount14;
								}//if1
							} 
						System.out.println("!!!!!!세번째 for문!!!!!!!"+discount14);
						if(maxDiscount14!=0 && discount14 > maxDiscount14) discount14 = records14.get(0).getMaxDiscount();
						else if(maxDiscountMon14 !=0 && discount14 > maxDiscountMon14) discount14 = records14.get(0).getMaxDiscountMonth(); 
						System.out.println("!!!!!!!!!!!!!!!!!!!!!!값 확인!!!!!!!!!!!!!!!!!"+discount14);
						}
					else {
						for(int i=0; i<records14.size();i++) {
							if(records14.get(i).getConsume().getConsumePrice() >= minPayment14) {
								if(discountPercent14 != 0) discount14 += records14.get(i).getConsume().getConsumePrice() * discountPercent14/100;
								else if(discountAmount14 != 0) discount14 += discountAmount14;
								}//if
							} 
						System.out.println("!!!!!!네번째 for문!!!!!!!"+discount14);
						if(maxDiscount14!=0 && discount14 > maxDiscount14) discount14 = maxDiscount14;
							else if(maxDiscountMon14 !=0 && discount14 > maxDiscountMon14) discount14 = maxDiscountMon14; 
						System.out.println("!!!!!!!!!!!!!!!!!!!!!!값 확인!!!!!!!!!!!!!!!!!"+discount14);
							}// else
					}System.out.println(discount14);
			}
			// 15번 카테고리
			if(records15.size()!=0) {
				int maxCount15 = records15.get(0).getMixCount();
				int maxDiscount15 = records15.get(0).getMaxDiscount();
				int minPayment15 = records15.get(0).getMinPayment();
				int discountPercent15 = records15.get(0).getDiscountPercent();
				int discount15 = 0;
				int maxDiscountMon15 = records15.get(0).getMaxDiscountMonth();
				int discountAmount15 = records15.get(0).getDiscountAmount();
				System.out.println(maxDiscountMon15);
				
				if(minPayment15 != 0) {
					if(maxCount15 != 0 && maxCount15 <= records15.size()) {						
						for(int i=0; i<maxCount15;i++) {
							if(records15.get(i).getConsume().getConsumePrice() >= minPayment15) {
								if(discountPercent15 != 0) discount15 += records15.get(i).getConsume().getConsumePrice() * discountPercent15/100;
								else if(discountAmount15 != 0) discount15 += discountAmount15;
								}//if			  
							 } 
						System.out.println("!!!!!!첫 for문!!!!!!!"+discount15);
						if(maxDiscount15!=0 && discount15 > maxDiscount15) discount15 = maxDiscount15;
						else if(maxDiscountMon15 !=0 && discount15 > maxDiscountMon15) discount15 = maxDiscountMon15;
						System.out.println("!!!!!!!!!!!!!!!!!!값 확인!!!!!!!!!!!!!!!!!!"+discount15);
					} else {
						for(int i=0; i<records15.size();i++) {
							if(records15.get(i).getConsume().getConsumePrice() >= minPayment15) {
								if(discountPercent15 != 0) discount15 += records15.get(i).getConsume().getConsumePrice() * discountPercent15/100;
								else if(discountAmount15 != 0) discount15 += discountAmount15;
								}//if
								} 
								System.out.println("!!!!!!두번째 for문!!!!!!!"+discount15);
								if(maxDiscount15!=0 && discount15 > maxDiscount15) discount15 = maxDiscount15;
								else if(maxDiscountMon15 !=0 && discount15 > maxDiscountMon15) discount15 = maxDiscountMon15;
								System.out.println("!!!!!!!!!!!!!!!!!!값 확인!!!!!!!!!!!!!!!!!!"+discount15);
						}
					
						
				}else {
					if(maxCount15 != 0 && maxCount15 <= records15.size()) {						
						for(int i=0; i<maxCount15;i++) {
							if(records15.get(i).getConsume().getConsumePrice() >= minPayment15) {
								if(discountPercent15 != 0) discount15 += records15.get(i).getConsume().getConsumePrice() * discountPercent15/100;
								else if(discountAmount15 != 0) discount15 += discountAmount15;
								}//if1
							} 
						System.out.println("!!!!!!세번째 for문!!!!!!!"+discount15);
						if(maxDiscount15!=0 && discount15 > maxDiscount15) discount15 = records15.get(0).getMaxDiscount();
						else if(maxDiscountMon15 !=0 && discount15 > maxDiscountMon15) discount15 = records15.get(0).getMaxDiscountMonth(); 
						System.out.println("!!!!!!!!!!!!!!!!!!!!!!값 확인!!!!!!!!!!!!!!!!!"+discount15);
						}
					else {
						for(int i=0; i<records15.size();i++) {
							if(records15.get(i).getConsume().getConsumePrice() >= minPayment15) {
								if(discountPercent15 != 0) discount15 += records15.get(i).getConsume().getConsumePrice() * discountPercent15/100;
								else if(discountAmount15 != 0) discount15 += discountAmount15;
								}//if
							} 
						System.out.println("!!!!!!네번째 for문!!!!!!!"+discount15);
						if(maxDiscount15!=0 && discount15 > maxDiscount15) discount15 = maxDiscount15;
							else if(maxDiscountMon15 !=0 && discount15 > maxDiscountMon15) discount15 = maxDiscountMon15; 
						System.out.println("!!!!!!!!!!!!!!!!!!!!!!값 확인!!!!!!!!!!!!!!!!!"+discount15);
							}// else
					}System.out.println(discount15);
			}
			// 16번 카테고리
			if(records16.size()!=0) {
				int maxCount16 = records16.get(0).getMixCount();
				int maxDiscount16 = records16.get(0).getMaxDiscount();
				int minPayment16 = records16.get(0).getMinPayment();
				int discountPercent16 = records16.get(0).getDiscountPercent();
				int discount16 = 0;
				int maxDiscountMon16 = records16.get(0).getMaxDiscountMonth();
				int discountAmount16 = records16.get(0).getDiscountAmount();
				System.out.println(maxDiscountMon16);
				
				if(minPayment16 != 0) {
					if(maxCount16 != 0 && maxCount16 <= records16.size()) {						
						for(int i=0; i<maxCount16;i++) {
							if(records16.get(i).getConsume().getConsumePrice() >= minPayment16) {
								if(discountPercent16 != 0) discount16 += records16.get(i).getConsume().getConsumePrice() * discountPercent16/100;
								else if(discountAmount16 != 0) discount16 += discountAmount16;
								}//if			  
							 } 
						System.out.println("!!!!!!첫 for문!!!!!!!"+discount16);
						if(maxDiscount16!=0 && discount16 > maxDiscount16) discount16 = maxDiscount16;
						else if(maxDiscountMon16 !=0 && discount16 > maxDiscountMon16) discount16 = maxDiscountMon16;
						System.out.println("!!!!!!!!!!!!!!!!!!값 확인!!!!!!!!!!!!!!!!!!"+discount16);
					} else {
						for(int i=0; i<records16.size();i++) {
							if(records16.get(i).getConsume().getConsumePrice() >= minPayment16) {
								if(discountPercent16 != 0) discount16 += records16.get(i).getConsume().getConsumePrice() * discountPercent16/100;
								else if(discountAmount16 != 0) discount16 += discountAmount16;
								}//if
								} 
								System.out.println("!!!!!!두번째 for문!!!!!!!"+discount16);
								if(maxDiscount16!=0 && discount16 > maxDiscount16) discount16 = maxDiscount16;
								else if(maxDiscountMon16 !=0 && discount16 > maxDiscountMon16) discount16 = maxDiscountMon16;
								System.out.println("!!!!!!!!!!!!!!!!!!값 확인!!!!!!!!!!!!!!!!!!"+discount16);
						}
					
						
				}else {
					if(maxCount16 != 0 && maxCount16 <= records16.size()) {						
						for(int i=0; i<maxCount16;i++) {
							if(records16.get(i).getConsume().getConsumePrice() >= minPayment16) {
								if(discountPercent16 != 0) discount16 += records16.get(i).getConsume().getConsumePrice() * discountPercent16/100;
								else if(discountAmount16 != 0) discount16 += discountAmount16;
								}//if1
							} 
						System.out.println("!!!!!!세번째 for문!!!!!!!"+discount16);
						if(maxDiscount16!=0 && discount16 > maxDiscount16) discount16 = records16.get(0).getMaxDiscount();
						else if(maxDiscountMon16 !=0 && discount16 > maxDiscountMon16) discount16 = records16.get(0).getMaxDiscountMonth(); 
						System.out.println("!!!!!!!!!!!!!!!!!!!!!!값 확인!!!!!!!!!!!!!!!!!"+discount16);
						}
					else {
						for(int i=0; i<records16.size();i++) {
							if(records16.get(i).getConsume().getConsumePrice() >= minPayment16) {
								if(discountPercent16 != 0) discount16 += records16.get(i).getConsume().getConsumePrice() * discountPercent16/100;
								else if(discountAmount16 != 0) discount16 += discountAmount16;
								}//if
							} 
						System.out.println("!!!!!!네번째 for문!!!!!!!"+discount16);
						if(maxDiscount16!=0 && discount16 > maxDiscount16) discount16 = maxDiscount16;
							else if(maxDiscountMon16 !=0 && discount16 > maxDiscountMon16) discount16 = maxDiscountMon16; 
						System.out.println("!!!!!!!!!!!!!!!!!!!!!!값 확인!!!!!!!!!!!!!!!!!"+discount16);
							}// else
					}System.out.println(discount16);
			}
			// 17번 카테고리
			if(records17.size()!=0) {
				int maxCount17 = records17.get(0).getMixCount();
				int maxDiscount17 = records17.get(0).getMaxDiscount();
				int minPayment17 = records17.get(0).getMinPayment();
				int discountPercent17 = records17.get(0).getDiscountPercent();
				int discount17 = 0;
				int maxDiscountMon17 = records17.get(0).getMaxDiscountMonth();
				int discountAmount17 = records17.get(0).getDiscountAmount();
				System.out.println(maxDiscountMon17);
				
				if(minPayment17 != 0) {
					if(maxCount17 != 0 && maxCount17 <= records17.size()) {						
						for(int i=0; i<maxCount17;i++) {
							if(records17.get(i).getConsume().getConsumePrice() >= minPayment17) {
								if(discountPercent17 != 0) discount17 += records17.get(i).getConsume().getConsumePrice() * discountPercent17/100;
								else if(discountAmount17 != 0) discount17 += discountAmount17;
								}//if			  
							 } 
						System.out.println("!!!!!!첫 for문!!!!!!!"+discount17);
						if(maxDiscount17!=0 && discount17 > maxDiscount17) discount17 = maxDiscount17;
						else if(maxDiscountMon17 !=0 && discount17 > maxDiscountMon17) discount17 = maxDiscountMon17;
						System.out.println("!!!!!!!!!!!!!!!!!!값 확인!!!!!!!!!!!!!!!!!!"+discount17);
					} else {
						for(int i=0; i<records17.size();i++) {
							if(records17.get(i).getConsume().getConsumePrice() >= minPayment17) {
								if(discountPercent17 != 0) discount17 += records17.get(i).getConsume().getConsumePrice() * discountPercent17/100;
								else if(discountAmount17 != 0) discount17 += discountAmount17;
								}//if
								} 
								System.out.println("!!!!!!두번째 for문!!!!!!!"+discount17);
								if(maxDiscount17!=0 && discount17 > maxDiscount17) discount17 = maxDiscount17;
								else if(maxDiscountMon17 !=0 && discount17 > maxDiscountMon17) discount17 = maxDiscountMon17;
								System.out.println("!!!!!!!!!!!!!!!!!!값 확인!!!!!!!!!!!!!!!!!!"+discount17);
						}
					
						
				}else {
					if(maxCount17 != 0 && maxCount17 <= records17.size()) {						
						for(int i=0; i<maxCount17;i++) {
							if(records17.get(i).getConsume().getConsumePrice() >= minPayment17) {
								if(discountPercent17 != 0) discount17 += records17.get(i).getConsume().getConsumePrice() * discountPercent17/100;
								else if(discountAmount17 != 0) discount17 += discountAmount17;
								}//if1
							} 
						System.out.println("!!!!!!세번째 for문!!!!!!!"+discount17);
						if(maxDiscount17!=0 && discount17 > maxDiscount17) discount17 = records17.get(0).getMaxDiscount();
						else if(maxDiscountMon17 !=0 && discount17 > maxDiscountMon17) discount17 = records17.get(0).getMaxDiscountMonth(); 
						System.out.println("!!!!!!!!!!!!!!!!!!!!!!값 확인!!!!!!!!!!!!!!!!!"+discount17);
						}
					else {
						for(int i=0; i<records17.size();i++) {
							if(records17.get(i).getConsume().getConsumePrice() >= minPayment17) {
								if(discountPercent17 != 0) discount17 += records17.get(i).getConsume().getConsumePrice() * discountPercent17/100;
								else if(discountAmount17 != 0) discount17 += discountAmount17;
								}//if
							} 
						System.out.println("!!!!!!네번째 for문!!!!!!!"+discount17);
						if(maxDiscount17!=0 && discount17 > maxDiscount17) discount17 = maxDiscount17;
							else if(maxDiscountMon17 !=0 && discount17 > maxDiscountMon17) discount17 = maxDiscountMon17; 
						System.out.println("!!!!!!!!!!!!!!!!!!!!!!값 확인!!!!!!!!!!!!!!!!!"+discount17);
							}// else
					}System.out.println(discount17);
			}
			// 18번 카테고리
			if(records18.size()!=0) {
				int maxCount18 = records18.get(0).getMixCount();
				int maxDiscount18 = records18.get(0).getMaxDiscount();
				int minPayment18 = records18.get(0).getMinPayment();
				int discountPercent18 = records18.get(0).getDiscountPercent();
				int discount18 = 0;
				int maxDiscountMon18 = records18.get(0).getMaxDiscountMonth();
				int discountAmount18 = records18.get(0).getDiscountAmount();
				System.out.println(maxDiscountMon18);
				
				if(minPayment18 != 0) {
					if(maxCount18 != 0 && maxCount18 <= records18.size()) {						
						for(int i=0; i<maxCount18;i++) {
							if(records18.get(i).getConsume().getConsumePrice() >= minPayment18) {
								if(discountPercent18 != 0) discount18 += records18.get(i).getConsume().getConsumePrice() * discountPercent18/100;
								else if(discountAmount18 != 0) discount18 += discountAmount18;
								}//if			  
							 } 
						System.out.println("!!!!!!첫 for문!!!!!!!"+discount18);
						if(maxDiscount18!=0 && discount18 > maxDiscount18) discount18 = maxDiscount18;
						else if(maxDiscountMon18 !=0 && discount18 > maxDiscountMon18) discount18 = maxDiscountMon18;
						System.out.println("!!!!!!!!!!!!!!!!!!값 확인!!!!!!!!!!!!!!!!!!"+discount18);
					} else {
						for(int i=0; i<records18.size();i++) {
							if(records18.get(i).getConsume().getConsumePrice() >= minPayment18) {
								if(discountPercent18 != 0) discount18 += records18.get(i).getConsume().getConsumePrice() * discountPercent18/100;
								else if(discountAmount18 != 0) discount18 += discountAmount18;
								}//if
								} 
								System.out.println("!!!!!!두번째 for문!!!!!!!"+discount18);
								if(maxDiscount18!=0 && discount18 > maxDiscount18) discount18 = maxDiscount18;
								else if(maxDiscountMon18 !=0 && discount18 > maxDiscountMon18) discount18 = maxDiscountMon18;
								System.out.println("!!!!!!!!!!!!!!!!!!값 확인!!!!!!!!!!!!!!!!!!"+discount18);
						}
					
						
				}else {
					if(maxCount18 != 0 && maxCount18 <= records18.size()) {						
						for(int i=0; i<maxCount18;i++) {
							if(records18.get(i).getConsume().getConsumePrice() >= minPayment18) {
								if(discountPercent18 != 0) discount18 += records18.get(i).getConsume().getConsumePrice() * discountPercent18/100;
								else if(discountAmount18 != 0) discount18 += discountAmount18;
								}//if1
							} 
						System.out.println("!!!!!!세번째 for문!!!!!!!"+discount18);
						if(maxDiscount18!=0 && discount18 > maxDiscount18) discount18 = records18.get(0).getMaxDiscount();
						else if(maxDiscountMon18 !=0 && discount18 > maxDiscountMon18) discount18 = records18.get(0).getMaxDiscountMonth(); 
						System.out.println("!!!!!!!!!!!!!!!!!!!!!!값 확인!!!!!!!!!!!!!!!!!"+discount18);
						}
					else {
						for(int i=0; i<records18.size();i++) {
							if(records18.get(i).getConsume().getConsumePrice() >= minPayment18) {
								if(discountPercent18 != 0) discount18 += records18.get(i).getConsume().getConsumePrice() * discountPercent18/100;
								else if(discountAmount18 != 0) discount18 += discountAmount18;
								}//if
							} 
						System.out.println("!!!!!!네번째 for문!!!!!!!"+discount18);
						if(maxDiscount18!=0 && discount18 > maxDiscount18) discount18 = maxDiscount18;
							else if(maxDiscountMon18 !=0 && discount18 > maxDiscountMon18) discount18 = maxDiscountMon18; 
						System.out.println("!!!!!!!!!!!!!!!!!!!!!!값 확인!!!!!!!!!!!!!!!!!"+discount18);
							}// else
					}System.out.println(discount18);
			}
			// 19번 카테고리
			if(records19.size()!=0) {
				int maxCount19 = records19.get(0).getMixCount();
				int maxDiscount19 = records19.get(0).getMaxDiscount();
				int minPayment19 = records19.get(0).getMinPayment();
				int discountPercent19 = records19.get(0).getDiscountPercent();
				int discount19 = 0;
				int maxDiscountMon19 = records19.get(0).getMaxDiscountMonth();
				int discountAmount19 = records19.get(0).getDiscountAmount();
				System.out.println(maxDiscountMon19);
				
				if(minPayment19 != 0) {
					if(maxCount19 != 0 && maxCount19 <= records19.size()) {						
						for(int i=0; i<maxCount19;i++) {
							if(records19.get(i).getConsume().getConsumePrice() >= minPayment19) {
								if(discountPercent19 != 0) discount19 += records19.get(i).getConsume().getConsumePrice() * discountPercent19/100;
								else if(discountAmount19 != 0) discount19 += discountAmount19;
								}//if			  
							 } 
						System.out.println("!!!!!!첫 for문!!!!!!!"+discount19);
						if(maxDiscount19!=0 && discount19 > maxDiscount19) discount19 = maxDiscount19;
						else if(maxDiscountMon19 !=0 && discount19 > maxDiscountMon19) discount19 = maxDiscountMon19;
						System.out.println("!!!!!!!!!!!!!!!!!!값 확인!!!!!!!!!!!!!!!!!!"+discount19);
					} else {
						for(int i=0; i<records19.size();i++) {
							if(records19.get(i).getConsume().getConsumePrice() >= minPayment19) {
								if(discountPercent19 != 0) discount19 += records19.get(i).getConsume().getConsumePrice() * discountPercent19/100;
								else if(discountAmount19 != 0) discount19 += discountAmount19;
								}//if
								} 
								System.out.println("!!!!!!두번째 for문!!!!!!!"+discount19);
								if(maxDiscount19!=0 && discount19 > maxDiscount19) discount19 = maxDiscount19;
								else if(maxDiscountMon19 !=0 && discount19 > maxDiscountMon19) discount19 = maxDiscountMon19;
								System.out.println("!!!!!!!!!!!!!!!!!!값 확인!!!!!!!!!!!!!!!!!!"+discount19);
						}
					
						
				}else {
					if(maxCount19 != 0 && maxCount19 <= records19.size()) {						
						for(int i=0; i<maxCount19;i++) {
							if(records19.get(i).getConsume().getConsumePrice() >= minPayment19) {
								if(discountPercent19 != 0) discount19 += records19.get(i).getConsume().getConsumePrice() * discountPercent19/100;
								else if(discountAmount19 != 0) discount19 += discountAmount19;
								}//if1
							} 
						System.out.println("!!!!!!세번째 for문!!!!!!!"+discount19);
						if(maxDiscount19!=0 && discount19 > maxDiscount19) discount19 = records19.get(0).getMaxDiscount();
						else if(maxDiscountMon19 !=0 && discount19 > maxDiscountMon19) discount19 = records19.get(0).getMaxDiscountMonth(); 
						System.out.println("!!!!!!!!!!!!!!!!!!!!!!값 확인!!!!!!!!!!!!!!!!!"+discount19);
						}
					else {
						for(int i=0; i<records19.size();i++) {
							if(records19.get(i).getConsume().getConsumePrice() >= minPayment19) {
								if(discountPercent19 != 0) discount19 += records19.get(i).getConsume().getConsumePrice() * discountPercent19/100;
								else if(discountAmount19 != 0) discount19 += discountAmount19;
								}//if
							} 
						System.out.println("!!!!!!네번째 for문!!!!!!!"+discount19);
						if(maxDiscount19!=0 && discount19 > maxDiscount19) discount19 = maxDiscount19;
							else if(maxDiscountMon19 !=0 && discount19 > maxDiscountMon19) discount19 = maxDiscountMon19; 
						System.out.println("!!!!!!!!!!!!!!!!!!!!!!값 확인!!!!!!!!!!!!!!!!!"+discount19);
							}// else
					}System.out.println(discount19);
			}
			// 20번 카테고리
			if(records20.size()!=0) {
				int maxCount20 = records20.get(0).getMixCount();
				int maxDiscount20 = records20.get(0).getMaxDiscount();
				int minPayment20 = records20.get(0).getMinPayment();
				int discountPercent20 = records20.get(0).getDiscountPercent();
				int discount20 = 0;
				int maxDiscountMon20 = records20.get(0).getMaxDiscountMonth();
				int discountAmount20 = records20.get(0).getDiscountAmount();
				System.out.println(maxDiscountMon20);
				
				if(minPayment20 != 0) {
					if(maxCount20 != 0 && maxCount20 <= records20.size()) {						
						for(int i=0; i<maxCount20;i++) {
							if(records20.get(i).getConsume().getConsumePrice() >= minPayment20) {
								if(discountPercent20 != 0) discount20 += records20.get(i).getConsume().getConsumePrice() * discountPercent20/100;
								else if(discountAmount20 != 0) discount20 += discountAmount20;
								}//if			  
							 } 
						System.out.println("!!!!!!첫 for문!!!!!!!"+discount20);
						if(maxDiscount20!=0 && discount20 > maxDiscount20) discount20 = maxDiscount20;
						else if(maxDiscountMon20 !=0 && discount20 > maxDiscountMon20) discount20 = maxDiscountMon20;
						System.out.println("!!!!!!!!!!!!!!!!!!값 확인!!!!!!!!!!!!!!!!!!"+discount20);
					} else {
						for(int i=0; i<records20.size();i++) {
							if(records20.get(i).getConsume().getConsumePrice() >= minPayment20) {
								if(discountPercent20 != 0) discount20 += records20.get(i).getConsume().getConsumePrice() * discountPercent20/100;
								else if(discountAmount20 != 0) discount20 += discountAmount20;
								}//if
								} 
								System.out.println("!!!!!!두번째 for문!!!!!!!"+discount20);
								if(maxDiscount20!=0 && discount20 > maxDiscount20) discount20 = maxDiscount20;
								else if(maxDiscountMon20 !=0 && discount20 > maxDiscountMon20) discount20 = maxDiscountMon20;
								System.out.println("!!!!!!!!!!!!!!!!!!값 확인!!!!!!!!!!!!!!!!!!"+discount20);
						}
					
						
				}else {
					if(maxCount20 != 0 && maxCount20 <= records20.size()) {						
						for(int i=0; i<maxCount20;i++) {
							if(records20.get(i).getConsume().getConsumePrice() >= minPayment20) {
								if(discountPercent20 != 0) discount20 += records20.get(i).getConsume().getConsumePrice() * discountPercent20/100;
								else if(discountAmount20 != 0) discount20 += discountAmount20;
								}//if1
							} 
						System.out.println("!!!!!!세번째 for문!!!!!!!"+discount20);
						if(maxDiscount20!=0 && discount20 > maxDiscount20) discount20 = records20.get(0).getMaxDiscount();
						else if(maxDiscountMon20 !=0 && discount20 > maxDiscountMon20) discount20 = records20.get(0).getMaxDiscountMonth(); 
						System.out.println("!!!!!!!!!!!!!!!!!!!!!!값 확인!!!!!!!!!!!!!!!!!"+discount20);
						}
					else {
						for(int i=0; i<records20.size();i++) {
							if(records20.get(i).getConsume().getConsumePrice() >= minPayment20) {
								if(discountPercent20 != 0) discount20 += records20.get(i).getConsume().getConsumePrice() * discountPercent20/100;
								else if(discountAmount20 != 0) discount20 += discountAmount20;
								}//if
							} 
						System.out.println("!!!!!!네번째 for문!!!!!!!"+discount20);
						if(maxDiscount20!=0 && discount20 > maxDiscount20) discount20 = maxDiscount20;
							else if(maxDiscountMon20 !=0 && discount20 > maxDiscountMon20) discount20 = maxDiscountMon20; 
						System.out.println("!!!!!!!!!!!!!!!!!!!!!!값 확인!!!!!!!!!!!!!!!!!"+discount20);
							}// else
					}System.out.println(discount20);
			}
			// 21번 카테고리
			if(records21.size()!=0) {
				int maxCount21 = records21.get(0).getMixCount();
				int maxDiscount21 = records21.get(0).getMaxDiscount();
				int minPayment21 = records21.get(0).getMinPayment();
				int discountPercent21 = records21.get(0).getDiscountPercent();
				int discount21 = 0;
				int maxDiscountMon21 = records21.get(0).getMaxDiscountMonth();
				int discountAmount21 = records21.get(0).getDiscountAmount();
				System.out.println(maxDiscountMon21);
				
				if(minPayment21 != 0) {
					if(maxCount21 != 0 && maxCount21 <= records21.size()) {						
						for(int i=0; i<maxCount21;i++) {
							if(records21.get(i).getConsume().getConsumePrice() >= minPayment21) {
								if(discountPercent21 != 0) discount21 += records21.get(i).getConsume().getConsumePrice() * discountPercent21/100;
								else if(discountAmount21 != 0) discount21 += discountAmount21;
								}//if			  
							 } 
						System.out.println("!!!!!!첫 for문!!!!!!!"+discount21);
						if(maxDiscount21!=0 && discount21 > maxDiscount21) discount21 = maxDiscount21;
						else if(maxDiscountMon21 !=0 && discount21 > maxDiscountMon21) discount21 = maxDiscountMon21;
						System.out.println("!!!!!!!!!!!!!!!!!!값 확인!!!!!!!!!!!!!!!!!!"+discount21);
					} else {
						for(int i=0; i<records21.size();i++) {
							if(records1.get(i).getConsume().getConsumePrice() >= minPayment21) {
								if(discountPercent21 != 0) discount21 += records21.get(i).getConsume().getConsumePrice() * discountPercent21/100;
								else if(discountAmount21 != 0) discount21 += discountAmount21;
								}//if
								} 
								System.out.println("!!!!!!두번째 for문!!!!!!!"+discount21);
								if(maxDiscount21!=0 && discount21 > maxDiscount21) discount21 = maxDiscount21;
								else if(maxDiscountMon21 !=0 && discount21 > maxDiscountMon21) discount21 = maxDiscountMon21;
								System.out.println("!!!!!!!!!!!!!!!!!!값 확인!!!!!!!!!!!!!!!!!!"+discount21);
						}
					
						
				}else {
					if(maxCount21 != 0 && maxCount21 <= records21.size()) {						
						for(int i=0; i<maxCount21;i++) {
							if(records21.get(i).getConsume().getConsumePrice() >= minPayment21) {
								if(discountPercent21 != 0) discount21 += records21.get(i).getConsume().getConsumePrice() * discountPercent21/100;
								else if(discountAmount21 != 0) discount21 += discountAmount21;
								}//if1
							} 
						System.out.println("!!!!!!세번째 for문!!!!!!!"+discount21);
						if(maxDiscount21!=0 && discount21 > maxDiscount21) discount21 = records21.get(0).getMaxDiscount();
						else if(maxDiscountMon21 !=0 && discount21 > maxDiscountMon21) discount21 = records21.get(0).getMaxDiscountMonth(); 
						System.out.println("!!!!!!!!!!!!!!!!!!!!!!값 확인!!!!!!!!!!!!!!!!!"+discount21);
						}
					else {
						for(int i=0; i<records21.size();i++) {
							if(records21.get(i).getConsume().getConsumePrice() >= minPayment21) {
								if(discountPercent21 != 0) discount21 += records21.get(i).getConsume().getConsumePrice() * discountPercent21/100;
								else if(discountAmount21 != 0) discount21 += discountAmount21;
								}//if
							} 
						System.out.println("!!!!!!네번째 for문!!!!!!!"+discount21);
						if(maxDiscount21!=0 && discount21 > maxDiscount21) discount21 = maxDiscount21;
							else if(maxDiscountMon21 !=0 && discount21 > maxDiscountMon21) discount21 = maxDiscountMon21; 
						System.out.println("!!!!!!!!!!!!!!!!!!!!!!값 확인!!!!!!!!!!!!!!!!!"+discount21);
							}// else
					}System.out.println(discount21);
			}
			// 22번 카테고리
			if(records22.size()!=0) {
				int maxCount22 = records22.get(0).getMixCount();
				int maxDiscount22 = records22.get(0).getMaxDiscount();
				int minPayment22 = records22.get(0).getMinPayment();
				int discountPercent22 = records22.get(0).getDiscountPercent();
				int discount22 = 0;
				int maxDiscountMon22 = records22.get(0).getMaxDiscountMonth();
				int discountAmount22 = records22.get(0).getDiscountAmount();
				System.out.println(maxDiscountMon22);
				
				if(minPayment22 != 0) {
					if(maxCount22 != 0 && maxCount22 <= records22.size()) {						
						for(int i=0; i<maxCount22;i++) {
							if(records22.get(i).getConsume().getConsumePrice() >= minPayment22) {
								if(discountPercent22 != 0) discount22 += records22.get(i).getConsume().getConsumePrice() * discountPercent22/100;
								else if(discountAmount22 != 0) discount22 += discountAmount22;
								}//if			  
							 } 
						System.out.println("!!!!!!첫 for문!!!!!!!"+discount22);
						if(maxDiscount22!=0 && discount22 > maxDiscount22) discount22 = maxDiscount22;
						else if(maxDiscountMon22 !=0 && discount22 > maxDiscountMon22) discount22 = maxDiscountMon22;
						System.out.println("!!!!!!!!!!!!!!!!!!값 확인!!!!!!!!!!!!!!!!!!"+discount22);
					} else {
						for(int i=0; i<records22.size();i++) {
							if(records22.get(i).getConsume().getConsumePrice() >= minPayment22) {
								if(discountPercent22 != 0) discount22 += records22.get(i).getConsume().getConsumePrice() * discountPercent22/100;
								else if(discountAmount22 != 0) discount22 += discountAmount22;
								}//if
								} 
								System.out.println("!!!!!!두번째 for문!!!!!!!"+discount22);
								if(maxDiscount22!=0 && discount22 > maxDiscount22) discount22 = maxDiscount22;
								else if(maxDiscountMon22 !=0 && discount22 > maxDiscountMon22) discount22 = maxDiscountMon22;
								System.out.println("!!!!!!!!!!!!!!!!!!값 확인!!!!!!!!!!!!!!!!!!"+discount22);
						}
					
						
				}else {
					if(maxCount22 != 0 && maxCount22 <= records22.size()) {						
						for(int i=0; i<maxCount22;i++) {
							if(records22.get(i).getConsume().getConsumePrice() >= minPayment22) {
								if(discountPercent22 != 0) discount22 += records22.get(i).getConsume().getConsumePrice() * discountPercent22/100;
								else if(discountAmount22 != 0) discount22 += discountAmount22;
								}//if1
							} 
						System.out.println("!!!!!!세번째 for문!!!!!!!"+discount22);
						if(maxDiscount22!=0 && discount22 > maxDiscount22) discount22 = records22.get(0).getMaxDiscount();
						else if(maxDiscountMon22 !=0 && discount22 > maxDiscountMon22) discount22 = records22.get(0).getMaxDiscountMonth(); 
						System.out.println("!!!!!!!!!!!!!!!!!!!!!!값 확인!!!!!!!!!!!!!!!!!"+discount22);
						}
					else {
						for(int i=0; i<records22.size();i++) {
							if(records22.get(i).getConsume().getConsumePrice() >= minPayment22) {
								if(discountPercent22 != 0) discount22 += records22.get(i).getConsume().getConsumePrice() * discountPercent22/100;
								else if(discountAmount22 != 0) discount22 += discountAmount22;
								}//if
							} 
						System.out.println("!!!!!!네번째 for문!!!!!!!"+discount22);
						if(maxDiscount22!=0 && discount22 > maxDiscount22) discount22 = maxDiscount22;
							else if(maxDiscountMon22 !=0 && discount22 > maxDiscountMon22) discount22 = maxDiscountMon22; 
						System.out.println("!!!!!!!!!!!!!!!!!!!!!!값 확인!!!!!!!!!!!!!!!!!"+discount22);
							}// else
					}System.out.println(discount22);
				}
			}catch(SQLException e) {
			System.out.println(e.getMessage());
		}
			return "cardCompare1";
	}
	
	@RequestMapping(value = "/cardCompare", method = RequestMethod.GET)
	public String cardCompare() {
		
		return "cardCompare2";
	}
}