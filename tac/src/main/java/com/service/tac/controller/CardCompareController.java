package com.service.tac.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.service.tac.model.service.CardCompareService;
import com.service.tac.model.service.MemberService;
import com.service.tac.model.vo.Calculation;
import com.service.tac.model.vo.Card;
import com.service.tac.model.vo.CardDetail;
import com.service.tac.model.vo.ConsumeAnalysis_LargeSum;
import com.service.tac.model.vo.Member;

@Controller
public class CardCompareController {
	@Autowired
	CardCompareService cardCompareService;

	@Autowired
	MemberService memberService;

	@RequestMapping(value = { "/compare" }, method = RequestMethod.GET)
	public String compare(HttpServletRequest request, HttpSession session, Model model, @Param("cardId") int cardId,
			@Param("memberId") String memberId) {
		cardId = Integer.parseInt(request.getParameter("cardId"));
		System.out.println(cardId);
		Member member = (Member) session.getAttribute("member");
		memberId = member.getMemberId();
		String memberName = member.getName();
		List<HashMap<String, Object>> bList = new ArrayList<HashMap<String, Object>>();

		// 대분류 통계
		ArrayList<ConsumeAnalysis_LargeSum> AnalLargeSum = new ArrayList<ConsumeAnalysis_LargeSum>();
		try {
			HashMap<String, Object> hmap = new HashMap<>();
			AnalLargeSum = cardCompareService.AnalyseLC_SUM(memberId);
//			System.out.println("나의 대분류-----------------------------------------------------------------------");
			for (ConsumeAnalysis_LargeSum temp : AnalLargeSum) {
//				System.out.println(temp.toString());
				if (temp.getSum() != 0) {
					hmap.put(temp.getLCname(), temp.getCount() + ", " + temp.getSum() + ", " + temp.getImage());
				}
			}
//			System.out.println("--------------------------------------------------------------------------");
			bList.add(hmap);
			System.out.println(bList);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		Gson gson = new GsonBuilder().create();
		String json = gson.toJson(bList);
		model.addAttribute("Object", json);
		model.addAttribute("memberName",memberName);

		try {
			Card info = cardCompareService.getCardInfo(cardId);
			ArrayList<CardDetail> list = cardCompareService.getDiscountInfoByCard(cardId);
			System.out.println(list);

//			System.out.println("여기까지 왔음" + member);

			//System.out.println(memberId);

			model.addAttribute("list", list);
			model.addAttribute("info", info);

			ArrayList<CardDetail> records1 = cardCompareService.getBenefitsByCateg1(cardId, memberId);
			ArrayList<CardDetail> records2 = cardCompareService.getBenefitsByCateg2(cardId, memberId);
			ArrayList<CardDetail> records3 = cardCompareService.getBenefitsByCateg3(cardId, memberId);
			ArrayList<CardDetail> records4 = cardCompareService.getBenefitsByCateg4(cardId, memberId);
			ArrayList<CardDetail> records5 = cardCompareService.getBenefitsByCateg5(cardId, memberId);
			ArrayList<CardDetail> records6 = cardCompareService.getBenefitsByCateg6(cardId, memberId);
			ArrayList<CardDetail> records7 = cardCompareService.getBenefitsByCateg7(cardId, memberId);
			ArrayList<CardDetail> records8 = cardCompareService.getBenefitsByCateg8(cardId, memberId);
			ArrayList<CardDetail> records9 = cardCompareService.getBenefitsByCateg9(cardId, memberId);
			ArrayList<CardDetail> records10 = cardCompareService.getBenefitsByCateg10(cardId, memberId);
			ArrayList<CardDetail> records11 = cardCompareService.getBenefitsByCateg11(cardId, memberId);
			ArrayList<CardDetail> records12 = cardCompareService.getBenefitsByCateg12(cardId, memberId);
			ArrayList<CardDetail> records13 = cardCompareService.getBenefitsByCateg13(cardId, memberId);
			ArrayList<CardDetail> records14 = cardCompareService.getBenefitsByCateg14(cardId, memberId);
			ArrayList<CardDetail> records15 = cardCompareService.getBenefitsByCateg15(cardId, memberId);
			ArrayList<CardDetail> records16 = cardCompareService.getBenefitsByCateg16(cardId, memberId);
			ArrayList<CardDetail> records17 = cardCompareService.getBenefitsByCateg17(cardId, memberId);
			ArrayList<CardDetail> records18 = cardCompareService.getBenefitsByCateg18(cardId, memberId);
			ArrayList<CardDetail> records19 = cardCompareService.getBenefitsByCateg19(cardId, memberId);
			ArrayList<CardDetail> records20 = cardCompareService.getBenefitsByCateg20(cardId, memberId);
			ArrayList<CardDetail> records21 = cardCompareService.getBenefitsByCateg21(cardId, memberId);
			ArrayList<CardDetail> records22 = cardCompareService.getBenefitsByCateg22(cardId, memberId);

			// 1번 카테고리
			if (records1.size() != 0) {
				int maxCount1 = records1.get(0).getMixCount();
				int maxDiscount1 = records1.get(0).getMaxDiscount();
				int minPayment1 = records1.get(0).getMinPayment();
				int discountPercent1 = records1.get(0).getDiscountPercent();
				int tempDiscount = 0;
				
				int discount1 = 0;
				int maxDiscountMon1 = records1.get(0).getMaxDiscountMonth();
				int discountAmount1 = records1.get(0).getDiscountAmount();
				String name1 = cardCompareService.getLargeCategoryName(records1.get(0).getLargeCategoryId());
				
				if(maxCount1 != 0 && maxCount1 <= records1.size()) {
					for(int i=0; i<maxCount1; i++) {
						if(records1.get(i).getConsume().getConsumePrice() >= minPayment1) {
							if(discountPercent1 !=0 ) {
								if (records1.get(i).getConsume().getConsumePrice() * discountPercent1 * 0.01 > maxDiscount1  && maxDiscount1 !=0) {
									tempDiscount = maxDiscount1;
									
									discount1 += tempDiscount;
								}else {
									discount1 += records1.get(i).getConsume().getConsumePrice() * discountPercent1 * 0.01;
									
								}
							}else if (discountAmount1 != 0)
								discount1 += discountAmount1;
						}
					} if(maxDiscountMon1 != 0 && discount1 > maxDiscountMon1) {
						discount1 = maxDiscountMon1;
					}
				}//maxCount10 != 0
				else {
					for(int i = 0; i < records1.size(); i++) {
							if(records1.get(i).getConsume().getConsumePrice() >= minPayment1) {
								if (discountPercent1 != 0) {
									if (records1.get(i).getConsume().getConsumePrice() * discountPercent1 * 0.01 >= maxDiscount1 && maxDiscount1 !=0) {
										tempDiscount = maxDiscount1;
										
										discount1 += tempDiscount;
									}else {
										discount1 += records1.get(i).getConsume().getConsumePrice()*discountPercent1 / 100;
										
									}
									
								}
								else if (discountAmount1 != 0)
									discount1 += discountAmount1;
							} 
						} if(maxDiscountMon1 != 0 && discount1 > maxDiscountMon1) {
							discount1 = maxDiscountMon1;
						}
				}//maxCount10 == 0 || maxCount > records.size()
				model.addAttribute("name1", name1);
				model.addAttribute("discount1", discount1);
			}

			// 2번 카테고리
			if (records2.size() != 0) {

				int maxCount2 = records2.get(0).getMixCount();
				int maxDiscount2 = records2.get(0).getMaxDiscount();
				int minPayment2 = records2.get(0).getMinPayment();
				int discountPercent2 = records2.get(0).getDiscountPercent();
				int tempDiscount = 0;
				
				int discount2 = 0;
				int maxDiscountMon2 = records2.get(0).getMaxDiscountMonth();
				int discountAmount2 = records2.get(0).getDiscountAmount();
				String name2 = cardCompareService.getLargeCategoryName(records2.get(0).getLargeCategoryId());
				

				if(maxCount2 != 0 && maxCount2 <= records2.size()) {
					for(int i=0; i<maxCount2; i++) {
						if(records2.get(i).getConsume().getConsumePrice() >= minPayment2) {
							if(discountPercent2 !=0 ) {
								if (records2.get(i).getConsume().getConsumePrice() * discountPercent2 * 0.01 > maxDiscount2 && maxDiscount2!=0) {
									tempDiscount = maxDiscount2;
									
									discount2 += tempDiscount;
								}else {
									discount2 += records2.get(i).getConsume().getConsumePrice() * discountPercent2 * 0.01;
									
								}
							}else if (discountAmount2 != 0)
								discount2 += discountAmount2;
						}
					} if(maxDiscountMon2 != 0 && discount2 > maxDiscountMon2) {
						discount2 = maxDiscountMon2;
					}
				}//maxCount != 0
				else {
					for(int i = 0; i < records2.size(); i++) {
							if(records2.get(i).getConsume().getConsumePrice() >= minPayment2) {
								if (discountPercent2 != 0) {
									if (records2.get(i).getConsume().getConsumePrice() * discountPercent2 * 0.01 > maxDiscount2 && maxDiscount2!=0) {
										tempDiscount = maxDiscount2;
										
										discount2 += tempDiscount;
									}else {
										discount2 += records2.get(i).getConsume().getConsumePrice()*discountPercent2 / 100;
										
									}
									
								}
								else if (discountAmount2 != 0)
									discount2 += discountAmount2;
							} 
						} if(maxDiscountMon2 != 0 && discount2 > maxDiscountMon2) {
							discount2 = maxDiscountMon2;
						}
				}//maxCount == 0
				model.addAttribute("name2", name2);
				model.addAttribute("discount2", discount2);
			}
			// 3번 카테고리
			if (records3.size() != 0) {
				int maxCount3 = records3.get(0).getMixCount();
				int maxDiscount3 = records3.get(0).getMaxDiscount();
				int minPayment3 = records3.get(0).getMinPayment();
				int discountPercent3 = records3.get(0).getDiscountPercent();
				int tempDiscount = 0;
				
				int discount3 = 0;
				int maxDiscountMon3 = records3.get(0).getMaxDiscountMonth();
				int discountAmount3 = records3.get(0).getDiscountAmount();
				String name3 = cardCompareService.getLargeCategoryName(records3.get(0).getLargeCategoryId());
				

				if(maxCount3 != 0 && maxCount3 <= records3.size()) {
					for(int i=0; i<maxCount3; i++) {
						if(records3.get(i).getConsume().getConsumePrice() >= minPayment3) {
							if(discountPercent3 !=0 ) {
								if (records3.get(i).getConsume().getConsumePrice() * discountPercent3 * 0.01 > maxDiscount3 && maxDiscount3!=0) {
									tempDiscount = maxDiscount3;
									discount3 += tempDiscount;
									
								}else {
									discount3 += records3.get(i).getConsume().getConsumePrice() * discountPercent3 * 0.01;
									
								}
								
							}else if (discountAmount3 != 0)
								discount3 += discountAmount3;
						}
					} if(maxDiscountMon3 != 0 && discount3 > maxDiscountMon3) {
						discount3 = maxDiscountMon3;
					}
				}//maxCount10 != 0
				else {
					for(int i = 0; i < records3.size(); i++) {
							if(records3.get(i).getConsume().getConsumePrice() >= minPayment3) {
								if (discountPercent3 != 0) {
									if (records3.get(i).getConsume().getConsumePrice() * discountPercent3 * 0.01 > maxDiscount3 && maxDiscount3 !=0) {
										tempDiscount = maxDiscount3;
										discount3 += tempDiscount;
									}else {
										discount3 += records3.get(i).getConsume().getConsumePrice() * discountPercent3 / 100;																			
									} 
									
								}
								else if (discountAmount3 != 0)
									discount3 += discountAmount3;
							} 
						} if(maxDiscountMon3 != 0 && discount3 > maxDiscountMon3) {
							discount3 = maxDiscountMon3;
						}
				}//maxCount10 == 0
				model.addAttribute("name3", name3);
				model.addAttribute("discount3", discount3);
			}
			// 4번 카테고리
			if (records4.size() != 0) {
				int maxCount4 = records4.get(0).getMixCount();
				int maxDiscount4 = records4.get(0).getMaxDiscount();
				int minPayment4 = records4.get(0).getMinPayment();
				int discountPercent4 = records4.get(0).getDiscountPercent();
				int tempDiscount = 0;
				
				int discount4 = 0;
				int maxDiscountMon4 = records4.get(0).getMaxDiscountMonth();
				int discountAmount4 = records4.get(0).getDiscountAmount();
				String name4 = cardCompareService.getLargeCategoryName(records4.get(0).getLargeCategoryId());
				
				if(maxCount4 != 0 && maxCount4 <= records4.size()) {
					for(int i=0; i<maxCount4; i++) {
						if(records4.get(i).getConsume().getConsumePrice() >= minPayment4) {
							if(discountPercent4 !=0 ) {
								if (records4.get(i).getConsume().getConsumePrice() * discountPercent4 * 0.01 > maxDiscount4 && maxDiscount4 != 0) {
									tempDiscount = maxDiscount4;
																	
									discount4 += tempDiscount;
								}else {
									discount4 += records4.get(i).getConsume().getConsumePrice() * discountPercent4 * 0.01;
									
								}
							}else if (discountAmount4 != 0)
								discount4 += discountAmount4;
						}
					} if(maxDiscountMon4 != 0 && discount4 > maxDiscountMon4) {
						discount4 = maxDiscountMon4;
					}
				}//maxCount != 0
				else {
					for(int i = 0; i < records4.size(); i++) {
							if(records4.get(i).getConsume().getConsumePrice() >= minPayment4) {
								if (discountPercent4 != 0) {
									if (records4.get(i).getConsume().getConsumePrice() * discountPercent4 * 0.01 > maxDiscount4 && maxDiscount4 != 0) {
										tempDiscount = maxDiscount4;
										
										discount4 += tempDiscount;
									}else {
										discount4 += records4.get(i).getConsume().getConsumePrice()*discountPercent4 / 100;
										
									}
									
								}
								else if (discountAmount4 != 0)
									discount4 += discountAmount4;
							} 
						} if(maxDiscountMon4 != 0 && discount4 > maxDiscountMon4) {
							discount4 = maxDiscountMon4;
						}
				}//maxCount == 0
				model.addAttribute("name4", name4);
				model.addAttribute("discount4", discount4);
			}
			// 5번 카테고리
			if (records5.size() != 0) {
				int maxCount5 = records5.get(0).getMixCount();
				int maxDiscount5 = records5.get(0).getMaxDiscount();
				int minPayment5 = records5.get(0).getMinPayment();
				int discountPercent5 = records5.get(0).getDiscountPercent();
				int tempDiscount = 0;
				int discount5 = 0;
				int maxDiscountMon5 = records5.get(0).getMaxDiscountMonth();
				int discountAmount5 = records5.get(0).getDiscountAmount();
				String name5 = cardCompareService.getLargeCategoryName(records5.get(0).getLargeCategoryId());
				

				if(maxCount5 != 0 && maxCount5 <= records5.size()) {
					for(int i=0; i<maxCount5; i++) {
						if(records5.get(i).getConsume().getConsumePrice() >= minPayment5) {
							if(discountPercent5 !=0 ) {
								if (records5.get(i).getConsume().getConsumePrice() * discountPercent5 * 0.01 > maxDiscount5 && maxDiscount5!=0) {
									tempDiscount = maxDiscount5;
									
									discount5 += tempDiscount;
								}else {
									discount5 += records5.get(i).getConsume().getConsumePrice() * discountPercent5 * 0.01;
									
								}
							}else if (discountAmount5 != 0)
								discount5 += discountAmount5;
						}
					} if(maxDiscountMon5 != 0 && discount5 > maxDiscountMon5) {
						discount5 = maxDiscountMon5;
					}
				}//maxCount10 != 0
				else {
					for(int i = 0; i < records5.size(); i++) {
							if(records5.get(i).getConsume().getConsumePrice() >= minPayment5) {
								if (discountPercent5 != 0) {
									if (records5.get(i).getConsume().getConsumePrice() * discountPercent5 * 0.01 > maxDiscount5 && maxDiscount5!=0) {
										tempDiscount = maxDiscount5;
										
										discount5 += tempDiscount;
									}else {
										discount5 += records5.get(i).getConsume().getConsumePrice()*discountPercent5 / 100;
										
									}
									
								}
								else if (discountAmount5 != 0)
									discount5 += discountAmount5;
							} 
						} if(maxDiscountMon5 != 0 && discount5 > maxDiscountMon5) {
							discount5 = maxDiscountMon5;
						}
				}//maxCount10 == 0
				model.addAttribute("name5", name5);
				model.addAttribute("discount5", discount5);
			}

			// 6번 카테고리
			if (records6.size() != 0) {
				int maxCount6 = records6.get(0).getMixCount();
				int maxDiscount6 = records6.get(0).getMaxDiscount();
				int minPayment6 = records6.get(0).getMinPayment();
				int discountPercent6 = records6.get(0).getDiscountPercent();
				int tempDiscount = 0;
				int discount6 = 0;
				int maxDiscountMon6 = records6.get(0).getMaxDiscountMonth();
				int discountAmount6 = records6.get(0).getDiscountAmount();
				String name6 = cardCompareService.getLargeCategoryName(records6.get(0).getLargeCategoryId());
				

				if(maxCount6 != 0 && maxCount6 <= records6.size()) {
					for(int i=0; i<maxCount6; i++) {
						if(records6.get(i).getConsume().getConsumePrice() >= minPayment6) {
							if(discountPercent6 !=0 ) {
								if (records6.get(i).getConsume().getConsumePrice() * discountPercent6 * 0.01 > maxDiscount6 && maxDiscount6 != 0) {
									tempDiscount = maxDiscount6;
									
									discount6 += tempDiscount;
								}else {
									discount6 += records6.get(i).getConsume().getConsumePrice() * discountPercent6 * 0.01;									
								}
							}else if (discountAmount6 != 0)
								discount6 += discountAmount6;
						}
					} if(maxDiscountMon6 != 0 && discount6 > maxDiscountMon6) {
						discount6 = maxDiscountMon6;
					}
				}//maxCount != 0
				else {
					for(int i = 0; i < records6.size(); i++) {
							if(records6.get(i).getConsume().getConsumePrice() >= minPayment6) {
								if (discountPercent6 != 0) {
									if (records6.get(i).getConsume().getConsumePrice() * discountPercent6 * 0.01 > maxDiscount6 && maxDiscount6 != 0) {
										tempDiscount = maxDiscount6;
										
										discount6 += tempDiscount;
									}else {
										discount6 += records6.get(i).getConsume().getConsumePrice()*discountPercent6 / 100;										
									}
									
								}
								else if (discountAmount6 != 0)
									discount6 += discountAmount6;
							} 
						} if(maxDiscountMon6 != 0 && discount6 > maxDiscountMon6) {
							discount6 = maxDiscountMon6;
						}
				}//maxCount == 0
				model.addAttribute("name6", name6);
				model.addAttribute("discount6", discount6);
			}
			// 7번 카테고리
			if (records7.size() != 0) {
				int maxCount7 = records7.get(0).getMixCount();
				int maxDiscount7 = records7.get(0).getMaxDiscount();
				int minPayment7 = records7.get(0).getMinPayment();
				int discountPercent7 = records7.get(0).getDiscountPercent();
				int tempDiscount = 0;
				int discount7 = 0;
				int maxDiscountMon7 = records7.get(0).getMaxDiscountMonth();
				int discountAmount7 = records7.get(0).getDiscountAmount();
				String name7 = cardCompareService.getLargeCategoryName(records7.get(0).getLargeCategoryId());
				

				if(maxCount7 != 0 && maxCount7 <= records7.size()) {
					for(int i=0; i<maxCount7; i++) {
						if(records7.get(i).getConsume().getConsumePrice() >= minPayment7) {
							if(discountPercent7 !=0 ) {
								if (records7.get(i).getConsume().getConsumePrice() * discountPercent7 * 0.01 > maxDiscount7 && maxDiscount7 !=0) {
									tempDiscount = maxDiscount7;
									
									discount7 += tempDiscount;
								}else {
									discount7 += records7.get(i).getConsume().getConsumePrice() * discountPercent7 * 0.01;									
								}
							}else if (discountAmount7 != 0)
								discount7 += discountAmount7;
						}
					} if(maxDiscountMon7 != 0 && discount7 > maxDiscountMon7) {
						discount7 = maxDiscountMon7;
					}
				}//maxCount != 0
				else {
					for(int i = 0; i < records7.size(); i++) {
							if(records7.get(i).getConsume().getConsumePrice() >= minPayment7) {
								if (discountPercent7 != 0) {
									if (records7.get(i).getConsume().getConsumePrice() * discountPercent7 * 0.01 > maxDiscount7 && maxDiscount7 !=0) {
										tempDiscount = maxDiscount7;
										
										discount7 += tempDiscount;
									}else {
										discount7 += records7.get(i).getConsume().getConsumePrice()*discountPercent7 / 100;
										
									}
									
								}
								else if (discountAmount7 != 0)
									discount7 += discountAmount7;
							} 
						} if(maxDiscountMon7 != 0 && discount7 > maxDiscountMon7) {
							discount7 = maxDiscountMon7;
						}
				}//maxCount == 0
				model.addAttribute("name8", name7);
				model.addAttribute("discount8", discount7);
			}

			// 8번 카테고리
			if (records8.size() != 0) {
				int maxCount8 = records8.get(0).getMixCount();
				int maxDiscount8 = records8.get(0).getMaxDiscount();
				int minPayment8 = records8.get(0).getMinPayment();
				int discountPercent8 = records8.get(0).getDiscountPercent();
				int tempDiscount = 0;
				int discount8 = 0;
				int maxDiscountMon8 = records8.get(0).getMaxDiscountMonth();
				int discountAmount8 = records8.get(0).getDiscountAmount();
				String name8 = cardCompareService.getLargeCategoryName(records8.get(0).getLargeCategoryId());
			

				if(maxCount8 != 0 && maxCount8 <= records8.size()) {
					for(int i=0; i<maxCount8; i++) {
						if(records8.get(i).getConsume().getConsumePrice() >= minPayment8) {
							if(discountPercent8 !=0 ) {
								if (records8.get(i).getConsume().getConsumePrice() * discountPercent8 * 0.01 > maxDiscount8 && maxDiscount8 != 0) {
									tempDiscount = maxDiscount8;
									
									discount8 += tempDiscount;
								}else {
									discount8 += records8.get(i).getConsume().getConsumePrice() * discountPercent8 * 0.01;
								}
							}else if (discountAmount8 != 0)
								discount8 += discountAmount8;
						}
					} if(maxDiscountMon8 != 0 && discount8 > maxDiscountMon8) {
						discount8 = maxDiscountMon8;
					}
				}//maxCount != 0
				else {
					for(int i = 0; i < records8.size(); i++) {
							if(records8.get(i).getConsume().getConsumePrice() >= minPayment8) {
								if (discountPercent8 != 0) {
									if (records8.get(i).getConsume().getConsumePrice() * discountPercent8 * 0.01 > maxDiscount8 && maxDiscount8 != 0) {
										tempDiscount = maxDiscount8;
										
										discount8 += tempDiscount;
									}else {
										discount8 += records8.get(i).getConsume().getConsumePrice()*discountPercent8 / 100;
										
									}
									
								}
								else if (discountAmount8 != 0)
									discount8 += discountAmount8;
							} 
						} if(maxDiscountMon8 != 0 && discount8 > maxDiscountMon8) {
							discount8 = maxDiscountMon8;
						}
				}//maxCount == 0
				model.addAttribute("name8", name8);
				model.addAttribute("discount8", discount8);
			}
				

			// 9번 카테고리
			if (records9.size() != 0) {
				int maxCount9 = records9.get(0).getMixCount();
				int maxDiscount9 = records9.get(0).getMaxDiscount();
				int minPayment9 = records9.get(0).getMinPayment();
				int discountPercent9 = records9.get(0).getDiscountPercent();
				int tempDiscount = 0;
				int discount9 = 0;
				int maxDiscountMon9 = records9.get(0).getMaxDiscountMonth();
				int discountAmount9 = records9.get(0).getDiscountAmount();
				String name9 = cardCompareService.getLargeCategoryName(records9.get(0).getLargeCategoryId());
				

				if(maxCount9 != 0 && maxCount9 <= records9.size()) {
					for(int i=0; i<maxCount9; i++) {
						if(records9.get(i).getConsume().getConsumePrice() >= minPayment9) {
							if(discountPercent9 !=0 ) {
								if (records9.get(i).getConsume().getConsumePrice() * discountPercent9 * 0.01 > maxDiscount9 && maxDiscount9 !=0) {
									tempDiscount = maxDiscount9;
									
									discount9 += tempDiscount;
								}else {
									discount9 += records9.get(i).getConsume().getConsumePrice() * discountPercent9 * 0.01;									
								}
							}else if (discountAmount9 != 0)
								discount9 += discountAmount9;
						}
					} if(maxDiscountMon9 != 0 && discount9 > maxDiscountMon9) {
						discount9 = maxDiscountMon9;
					}
				}//maxCount != 0
				else {
					for(int i = 0; i < records9.size(); i++) {
							if(records9.get(i).getConsume().getConsumePrice() >= minPayment9) {
								if (discountPercent9 != 0) {
									if (records9.get(i).getConsume().getConsumePrice() * discountPercent9 * 0.01 > maxDiscount9 && maxDiscount9 !=0) {
										tempDiscount = maxDiscount9;
										
										discount9 += tempDiscount;
									}else {
										discount9 += records9.get(i).getConsume().getConsumePrice()*discountPercent9 / 100;
										
									}
								
								}
								else if (discountAmount9 != 0)
									discount9 += discountAmount9;
							} 
						} if(maxDiscountMon9 != 0 && discount9 > maxDiscountMon9) {
							discount9 = maxDiscountMon9;
						}
				}//maxCount == 0
				model.addAttribute("name9", name9);
				model.addAttribute("discount9", discount9);
			}

			// 10번 카테고리
			if (records10.size() != 0) {
				System.out.println(records10);
				int maxCount10 = records10.get(0).getMixCount();
				int maxDiscount10 = records10.get(0).getMaxDiscount();
				int minPayment10 = records10.get(0).getMinPayment();
				int discountPercent10 = records10.get(0).getDiscountPercent();
				
				int tempDiscount = 0;
				int discount10 = 0;
				int maxDiscountMon10 = records10.get(0).getMaxDiscountMonth();
				int discountAmount10 = records10.get(0).getDiscountAmount();
				String name10 = cardCompareService.getLargeCategoryName(records10.get(0).getLargeCategoryId());
				
				
				if(maxCount10 != 0 && maxCount10 <= records10.size()) {
					for(int i=0; i<maxCount10; i++) {
						if(records10.get(i).getConsume().getConsumePrice() >= minPayment10) {
							if(discountPercent10 !=0 ) {
								if (records10.get(i).getConsume().getConsumePrice() * discountPercent10 * 0.01 > maxDiscount10 && maxDiscount10 !=0) {
									tempDiscount = maxDiscount10;
									
									discount10 += tempDiscount;
								}else {
									discount10 += records10.get(i).getConsume().getConsumePrice() * discountPercent10 * 0.01;
									
								}
							}else if (discountAmount10 != 0)
								discount10 += discountAmount10;
						}
					} if(maxDiscountMon10 != 0 && discount10 > maxDiscountMon10) {
						discount10 = maxDiscountMon10;
					}
				}//maxCount10 != 0
				else {
					for(int i = 0; i < records10.size(); i++) {
							if(records10.get(i).getConsume().getConsumePrice() >= minPayment10) {
								if (discountPercent10 != 0) {
									if (records10.get(i).getConsume().getConsumePrice() * discountPercent10 * 0.01 > maxDiscount10 && maxDiscount10 !=0) {
										tempDiscount = maxDiscount10;
										
										discount10 += tempDiscount;
									}else {
										discount10 += records10.get(i).getConsume().getConsumePrice()*discountPercent10 / 100;
										
									}
									
								}
								else if (discountAmount10 != 0)
									discount10 += discountAmount10;
							} 
						} if(maxDiscountMon10 != 0 && discount10 > maxDiscountMon10) {
							discount10 = maxDiscountMon10;
						}
				}//maxCount10 == 0
				
				model.addAttribute("name10", name10);
				model.addAttribute("discount10", discount10);
			}
			// 11번 카테고리
			if (records11.size() != 0) {
				int maxCount11 = records11.get(0).getMixCount();
				int maxDiscount11 = records11.get(0).getMaxDiscount();
				int minPayment11 = records11.get(0).getMinPayment();
				int discountPercent11 = records11.get(0).getDiscountPercent();
				int tempDiscount = 0;
				int discount11 = 0;
				int maxDiscountMon11 = records11.get(0).getMaxDiscountMonth();
				int discountAmount11 = records11.get(0).getDiscountAmount();
				String name11 = cardCompareService.getLargeCategoryName(records11.get(0).getLargeCategoryId());
				

				if(maxCount11 != 0 && maxCount11 <= records11.size()) {
					for(int i=0; i<maxCount11; i++) {
						if(records11.get(i).getConsume().getConsumePrice() >= minPayment11) {
							if(discountPercent11 !=0 ) {
								if (records11.get(i).getConsume().getConsumePrice() * discountPercent11 * 0.01 > maxDiscount11 && maxDiscount11 !=0) {
									tempDiscount = maxDiscount11;
									
									discount11 += tempDiscount;
								}else {
									discount11 += records11.get(i).getConsume().getConsumePrice() * discountPercent11 * 0.01;
									
								}
							}else if (discountAmount11 != 0)
								discount11 += discountAmount11;
						}
					} if(maxDiscountMon11 != 0 && discount11 > maxDiscountMon11) {
						discount11 = maxDiscountMon11;
					}
				}//maxCount != 0
				else {
					for(int i = 0; i < records11.size(); i++) {
							if(records11.get(i).getConsume().getConsumePrice() >= minPayment11) {
								if (discountPercent11 != 0) {
									if (records11.get(i).getConsume().getConsumePrice() * discountPercent11 * 0.01 > maxDiscount11 && maxDiscount11 !=0) {
										tempDiscount = maxDiscount11;
										
										discount11 += tempDiscount;
									}else {
										discount11 += records11.get(i).getConsume().getConsumePrice()*discountPercent11 / 100;
										
									}
									
								}
								else if (discountAmount11 != 0)
									discount11 += discountAmount11;
							} 
						} if(maxDiscountMon11 != 0 && discount11 > maxDiscountMon11) {
							discount11 = maxDiscountMon11;
						}
				}//maxCount10 == 0
				model.addAttribute("name11", name11);
				model.addAttribute("discount11", discount11);
			}

			// 12번 카테고리
			if (records12.size() != 0) {
				int maxCount12 = records12.get(0).getMixCount();
				int maxDiscount12 = records12.get(0).getMaxDiscount();
				int minPayment12 = records12.get(0).getMinPayment();
				int discountPercent12 = records12.get(0).getDiscountPercent();
				int tempDiscount = 0;
				int discount12 = 0;
				int maxDiscountMon12 = records12.get(0).getMaxDiscountMonth();
				int discountAmount12 = records12.get(0).getDiscountAmount();
				String name12 = cardCompareService.getLargeCategoryName(records12.get(0).getLargeCategoryId());
				

				if(maxCount12 != 0 && maxCount12 <= records12.size()) {
					for(int i=0; i<maxCount12; i++) {
						if(records12.get(i).getConsume().getConsumePrice() >= minPayment12) {
							if(discountPercent12 !=0 ) {
								if (records12.get(i).getConsume().getConsumePrice() * discountPercent12 * 0.01 > maxDiscount12 && maxDiscount12 !=0) {
									tempDiscount = maxDiscount12;
									
									discount12 += tempDiscount;
								}else {
									discount12 += records12.get(i).getConsume().getConsumePrice() * discountPercent12 * 0.01;
									
								}
							}else if (discountAmount12 != 0)
								discount12 += discountAmount12;
						}
					} if(maxDiscountMon12 != 0 && discount12 > maxDiscountMon12) {
						discount12 = maxDiscountMon12;
					}
				}//maxCount != 0
				else {
					for(int i = 0; i < records12.size(); i++) {
							if(records12.get(i).getConsume().getConsumePrice() >= minPayment12) {
								if (discountPercent12 != 0) {
									if (records12.get(i).getConsume().getConsumePrice() * discountPercent12 * 0.01 > maxDiscount12 && maxDiscount12 !=0) {
										tempDiscount = maxDiscount12;
										
										discount12 += tempDiscount;
									}else {
										discount12 += records12.get(i).getConsume().getConsumePrice()*discountPercent12 / 100;
										
									}
									
								}
								else if (discountAmount12 != 0)
									discount12 += discountAmount12;
							} 
						} if(maxDiscountMon12 != 0 && discount12 > maxDiscountMon12) {
							discount12 = maxDiscountMon12;
						}
				}//maxCount10 == 0
				model.addAttribute("name12", name12);
				model.addAttribute("discount12", discount12);
			}
			// 13번 카테고리
			if (records13.size() != 0) {
				int maxCount13 = records13.get(0).getMixCount();
				int maxDiscount13 = records13.get(0).getMaxDiscount();
				int minPayment13 = records13.get(0).getMinPayment();
				int discountPercent13 = records13.get(0).getDiscountPercent();
				int tempDiscount = 0;
				int discount13 = 0;
				int maxDiscountMon13 = records13.get(0).getMaxDiscountMonth();
				int discountAmount13 = records13.get(0).getDiscountAmount();
				String name13 = cardCompareService.getLargeCategoryName(records13.get(0).getLargeCategoryId());
				

				if(maxCount13 != 0 && maxCount13 <= records13.size()) {
					for(int i=0; i<maxCount13; i++) {
						if(records13.get(i).getConsume().getConsumePrice() >= minPayment13) {
							if(discountPercent13 !=0 ) {
								if (records13.get(i).getConsume().getConsumePrice() * discountPercent13 * 0.01 > maxDiscount13 && maxDiscount13 !=0) {
									tempDiscount = maxDiscount13;
									
									discount13 += tempDiscount;
								}else {
									discount13 += records13.get(i).getConsume().getConsumePrice() * discountPercent13 * 0.01;
									
								}
							}else if (discountAmount13 != 0)
								discount13 += discountAmount13;
						}
					} if(maxDiscountMon13 != 0 && discount13 > maxDiscountMon13) {
						discount13 = maxDiscountMon13;
					}
				}//maxCount != 0
				else {
					for(int i = 0; i < records13.size(); i++) {
							if(records13.get(i).getConsume().getConsumePrice() >= minPayment13) {
								if (discountPercent13 != 0) {
									if (records13.get(i).getConsume().getConsumePrice() * discountPercent13 * 0.01 > maxDiscount13 && maxDiscount13 !=0) {
										tempDiscount = maxDiscount13;
										
										discount13 += tempDiscount;
									}else {
										discount13 += records13.get(i).getConsume().getConsumePrice()*discountPercent13 / 100;
										
									}
									
								}
								else if (discountAmount13 != 0)
									discount13 += discountAmount13;
							} 
						} if(maxDiscountMon13 != 0 && discount13 > maxDiscountMon13) {
							discount13 = maxDiscountMon13;
						}
				}//maxCount == 0
				model.addAttribute("name13", name13);
				model.addAttribute("discount13", discount13);
			}

			// 14번 카테고리
			if (records14.size() != 0) {
				int maxCount14 = records14.get(0).getMixCount();
				int maxDiscount14 = records14.get(0).getMaxDiscount();
				int minPayment14 = records14.get(0).getMinPayment();
				int discountPercent14 = records14.get(0).getDiscountPercent();
				int tempDiscount = 0;
				int discount14 = 0;
				int maxDiscountMon14 = records14.get(0).getMaxDiscountMonth();
				int discountAmount14 = records14.get(0).getDiscountAmount();
				String name14 = cardCompareService.getLargeCategoryName(records14.get(0).getLargeCategoryId());
				

				if(maxCount14 != 0 && maxCount14 <= records14.size()) {
					for(int i=0; i<maxCount14; i++) {
						if(records14.get(i).getConsume().getConsumePrice() >= minPayment14) {
							if(discountPercent14 !=0 ) {
								if (records14.get(i).getConsume().getConsumePrice() * discountPercent14 * 0.01 > maxDiscount14 && maxDiscount14 !=0) {
									tempDiscount = maxDiscount14;
									
									discount14 += tempDiscount;
								}else {
									discount14 += records14.get(i).getConsume().getConsumePrice() * discountPercent14 * 0.01;
									
								}
							}else if (discountAmount14 != 0)
								discount14 += discountAmount14;
						}
					} if(maxDiscountMon14 != 0 && discount14 > maxDiscountMon14) {
						discount14 = maxDiscountMon14;
					}
				}//maxCount != 0
				else {
					for(int i = 0; i < records14.size(); i++) {
							if(records14.get(i).getConsume().getConsumePrice() >= minPayment14) {
								if (discountPercent14 != 0) {
									if (records14.get(i).getConsume().getConsumePrice() * discountPercent14 * 0.01 > maxDiscount14 && maxDiscount14 !=0) {
										tempDiscount = maxDiscount14;
										
										discount14 += tempDiscount;
									}else {
										discount14 += records14.get(i).getConsume().getConsumePrice()*discountPercent14 / 100;
									}
									
								}
								else if (discountAmount14 != 0)
									discount14 += discountAmount14;
							} 
						} if(maxDiscountMon14 != 0 && discount14 > maxDiscountMon14) {
							discount14 = maxDiscountMon14;
						}
				}//maxCount10 == 0
				model.addAttribute("name14", name14);
				model.addAttribute("discount14", discount14);
			}

			// 15번 카테고리
			if (records15.size() != 0) {
				int maxCount15 = records15.get(0).getMixCount();
				int maxDiscount15 = records15.get(0).getMaxDiscount();
				int minPayment15 = records15.get(0).getMinPayment();
				int discountPercent15 = records15.get(0).getDiscountPercent();
				int tempDiscount = 0;
				int discount15 = 0;
				int maxDiscountMon15 = records15.get(0).getMaxDiscountMonth();
				int discountAmount15 = records15.get(0).getDiscountAmount();
				String name15 = cardCompareService.getLargeCategoryName(records15.get(0).getLargeCategoryId());
				

				if(maxCount15 != 0 && maxCount15 <= records15.size()) {
					for(int i=0; i<maxCount15; i++) {
						if(records15.get(i).getConsume().getConsumePrice() >= minPayment15) {
							if(discountPercent15 !=0 ) {
								if (records15.get(i).getConsume().getConsumePrice() * discountPercent15 * 0.01 > maxDiscount15 && maxDiscount15 !=0) {
									tempDiscount = maxDiscount15;
									
									discount15 += tempDiscount;
								}else {
									discount15 += records15.get(i).getConsume().getConsumePrice() * discountPercent15 * 0.01;
									
								}
							}else if (discountAmount15 != 0)
								discount15 += discountAmount15;
						}
					} if(maxDiscountMon15 != 0 && discount15 > maxDiscountMon15) {
						discount15 = maxDiscountMon15;
					}
				}//maxCount != 0
				else {
					for(int i = 0; i < records15.size(); i++) {
							if(records15.get(i).getConsume().getConsumePrice() >= minPayment15) {
								if (discountPercent15 != 0) {
									if (records15.get(i).getConsume().getConsumePrice() * discountPercent15 * 0.01 > maxDiscount15 && maxDiscount15 !=0) {
										tempDiscount = maxDiscount15;
										
										discount15 += tempDiscount;
									}else {
										discount15 += records15.get(i).getConsume().getConsumePrice()*discountPercent15 / 100;
										
									}
									
								}
								else if (discountAmount15 != 0)
									discount15 += discountAmount15;
							} 
						} if(maxDiscountMon15 != 0 && discount15 > maxDiscountMon15) {
							discount15 = maxDiscountMon15;
						}
				}//maxCount10 == 0
				model.addAttribute("name15", name15);
				model.addAttribute("discount15", discount15);
			}

			// 16번 카테고리
			if (records16.size() != 0) {
				int maxCount16 = records16.get(0).getMixCount();
				int maxDiscount16 = records16.get(0).getMaxDiscount();
				int minPayment16 = records16.get(0).getMinPayment();
				int discountPercent16 = records16.get(0).getDiscountPercent();
				int tempDiscount = 0;
				int discount16 = 0;
				int maxDiscountMon16 = records16.get(0).getMaxDiscountMonth();
				int discountAmount16 = records16.get(0).getDiscountAmount();
				String name16 = cardCompareService.getLargeCategoryName(records16.get(0).getLargeCategoryId());
				

				if(maxCount16 != 0 && maxCount16 <= records16.size()) {
					for(int i=0; i<maxCount16; i++) {
						if(records16.get(i).getConsume().getConsumePrice() >= minPayment16) {
							if(discountPercent16 !=0 ) {
								if (records16.get(i).getConsume().getConsumePrice() * discountPercent16 * 0.01 > maxDiscount16 && maxDiscount16 !=0) {
									tempDiscount = maxDiscount16;
									
									discount16 += tempDiscount;
								}else {
									discount16 += records16.get(i).getConsume().getConsumePrice() * discountPercent16 * 0.01;
									
								}
							}else if (discountAmount16 != 0)
								discount16 += discountAmount16;
						}
					} if(maxDiscountMon16 != 0 && discount16 > maxDiscountMon16) {
						discount16 = maxDiscountMon16;
					}
				}//maxCount != 0
				else {
					for(int i = 0; i < records16.size(); i++) {
							if(records16.get(i).getConsume().getConsumePrice() >= minPayment16) {
								if (discountPercent16 != 0) {
									if (records16.get(i).getConsume().getConsumePrice() * discountPercent16 * 0.01 > maxDiscount16 && maxDiscount16 !=0) {
										tempDiscount = maxDiscount16;
										
										discount16 += tempDiscount;
									}else {
										discount16 += records16.get(i).getConsume().getConsumePrice()*discountPercent16 / 100;
									
									}
								}
								else if (discountAmount16 != 0)
									discount16 += discountAmount16;
							} 
						} if(maxDiscountMon16 != 0 && discount16 > maxDiscountMon16) {
							discount16 = maxDiscountMon16;
						}
				}//maxCount10 == 0
				model.addAttribute("name16", name16);
				model.addAttribute("discount", discount16);
			}

			// 17번 카테고리
			if (records17.size() != 0) {
				int maxCount17 = records17.get(0).getMixCount();
				int maxDiscount17 = records17.get(0).getMaxDiscount();
				int minPayment17 = records17.get(0).getMinPayment();
				int discountPercent17 = records17.get(0).getDiscountPercent();
				int tempDiscount = 0;
				int discount17 = 0;
				int maxDiscountMon17 = records17.get(0).getMaxDiscountMonth();
				int discountAmount17 = records17.get(0).getDiscountAmount();
				String name17 = cardCompareService.getLargeCategoryName(records17.get(0).getLargeCategoryId());
				

				if(maxCount17 != 0 && maxCount17 <= records17.size()) {
					for(int i=0; i<maxCount17; i++) {
						if(records17.get(i).getConsume().getConsumePrice() >= minPayment17) {
							if(discountPercent17 !=0 ) {
								if (records17.get(i).getConsume().getConsumePrice() * discountPercent17 * 0.01 > maxDiscount17 && maxDiscount17 !=0) {
									tempDiscount = maxDiscount17;
									
									discount17 += tempDiscount;
								}else {
									discount17 += records17.get(i).getConsume().getConsumePrice() * discountPercent17 * 0.01;
									
								}
							}else if (discountAmount17 != 0)
								discount17 += discountAmount17;
						}
					} if(maxDiscountMon17 != 0 && discount17 > maxDiscountMon17) {
						discount17 = maxDiscountMon17;
					}
				}//maxCount != 0
				else {
					for(int i = 0; i < records17.size(); i++) {
							if(records17.get(i).getConsume().getConsumePrice() >= minPayment17) {
								if (discountPercent17 != 0) {
									if (records17.get(i).getConsume().getConsumePrice() * discountPercent17 * 0.01 > maxDiscount17 && maxDiscount17 !=0) {
										tempDiscount = maxDiscount17;
										
										discount17 += tempDiscount;
									}else {
										discount17 += records17.get(i).getConsume().getConsumePrice()*discountPercent17 / 100;
										
									}
									
								}
								else if (discountAmount17 != 0)
									discount17 += discountAmount17;
							} 
						} if(maxDiscountMon17 != 0 && discount17 > maxDiscountMon17) {
							discount17 = maxDiscountMon17;
						}
				}//maxCount10 == 0
				model.addAttribute("name17", name17);
				model.addAttribute("discount17", discount17);
			}

			// 18번 카테고리
			if (records18.size() != 0) {
				int maxCount18 = records18.get(0).getMixCount();
				int maxDiscount18 = records18.get(0).getMaxDiscount();
				int minPayment18 = records18.get(0).getMinPayment();
				int discountPercent18 = records18.get(0).getDiscountPercent();
				int tempDiscount = 0;
				int discount18 = 0;
				int maxDiscountMon18 = records18.get(0).getMaxDiscountMonth();
				int discountAmount18 = records18.get(0).getDiscountAmount();
				String name18 = cardCompareService.getLargeCategoryName(records18.get(0).getLargeCategoryId());
				

				if(maxCount18 != 0 && maxCount18 <= records18.size()) {
					for(int i=0; i<maxCount18; i++) {
						if(records18.get(i).getConsume().getConsumePrice() >= minPayment18) {
							if(discountPercent18 !=0 ) {
								if (records18.get(i).getConsume().getConsumePrice() * discountPercent18 * 0.01 > maxDiscount18 && maxDiscount18 !=0) {
									tempDiscount = maxDiscount18;
									
									discount18 += tempDiscount;
								}else {
									discount18 += records18.get(i).getConsume().getConsumePrice() * discountPercent18 * 0.01;
								
								}
							}else if (discountAmount18 != 0)
								discount18 += discountAmount18;
						}
					} if(maxDiscountMon18 != 0 && discount18 > maxDiscountMon18) {
						discount18 = maxDiscountMon18;
					}
				}//maxCount != 0
				else {
					for(int i = 0; i < records18.size(); i++) {
							if(records18.get(i).getConsume().getConsumePrice() >= minPayment18) {
								if (discountPercent18 != 0) {
									if (records18.get(i).getConsume().getConsumePrice() * discountPercent18 * 0.01 > maxDiscount18 && maxDiscount18 !=0) {
										tempDiscount = maxDiscount18;
										
										discount18 += tempDiscount;
									}else {
										discount18 += records18.get(i).getConsume().getConsumePrice()*discountPercent18 / 100;
										
									}
									
								}
								else if (discountAmount18 != 0)
									discount18 += discountAmount18;
							} 
						} if(maxDiscountMon18 != 0 && discount18 > maxDiscountMon18) {
							discount18 = maxDiscountMon18;
						}
				}//maxCount10 == 0
				model.addAttribute("name18", name18);
				model.addAttribute("discount", discount18);
			}

			// 19번 카테고리
			if (records19.size() != 0) {
				int maxCount19 = records19.get(0).getMixCount();
				int maxDiscount19 = records19.get(0).getMaxDiscount();
				int minPayment19 = records19.get(0).getMinPayment();
				int discountPercent19 = records19.get(0).getDiscountPercent();
				int tempDiscount = 0;
				int discount19 = 0;
				int maxDiscountMon19 = records19.get(0).getMaxDiscountMonth();
				int discountAmount19 = records19.get(0).getDiscountAmount();
				String name19 = cardCompareService.getLargeCategoryName(records19.get(0).getLargeCategoryId());
				

				if(maxCount19 != 0 && maxCount19 <= records19.size()) {
					for(int i=0; i<maxCount19; i++) {
						if(records19.get(i).getConsume().getConsumePrice() >= minPayment19) {
							if(discountPercent19 !=0 ) {
								if (records19.get(i).getConsume().getConsumePrice() * discountPercent19 * 0.01 > maxDiscount19 && maxDiscount19 !=0) {
									tempDiscount = maxDiscount19;
									
									discount19 += tempDiscount;
								}else {
									discount19 += records19.get(i).getConsume().getConsumePrice() * discountPercent19 * 0.01;
								
								}
							}else if (discountAmount19 != 0)
								discount19 += discountAmount19;
						}
					} if(maxDiscountMon19 != 0 && discount19 > maxDiscountMon19) {
						discount19 = maxDiscountMon19;
					}
				}//maxCount != 0
				else {
					for(int i = 0; i < records19.size(); i++) {
							if(records19.get(i).getConsume().getConsumePrice() >= minPayment19) {
								if (discountPercent19 != 0) {
									if (records19.get(i).getConsume().getConsumePrice() * discountPercent19 * 0.01 > maxDiscount19 && maxDiscount19 !=0) {
										tempDiscount = maxDiscount19;
										
										discount19 += tempDiscount;
									}else {
										discount19 += records19.get(i).getConsume().getConsumePrice()*discountPercent19 / 100;										
									}
								}
								else if (discountAmount19 != 0)
									discount19 += discountAmount19;
							} 
						} if(maxDiscountMon19 != 0 && discount19 > maxDiscountMon19) {
							discount19 = maxDiscountMon19;
						}
				}//maxCount10 == 0
				model.addAttribute("name19", name19);
				model.addAttribute("discount19", discount19);
			}
			// 20번 카테고리
			if (records20.size() != 0) {
				int maxCount20 = records20.get(0).getMixCount();
				int maxDiscount20 = records20.get(0).getMaxDiscount();
				int minPayment20 = records20.get(0).getMinPayment();
				int discountPercent20 = records20.get(0).getDiscountPercent();
				int tempDiscount = 0;
				int discount20 = 0;
				int maxDiscountMon20 = records20.get(0).getMaxDiscountMonth();
				int discountAmount20 = records20.get(0).getDiscountAmount();
				String name20 = cardCompareService.getLargeCategoryName(records20.get(0).getLargeCategoryId());
				

				if(maxCount20 != 0 && maxCount20 <= records20.size()) {
					for(int i=0; i<maxCount20; i++) {
						if(records20.get(i).getConsume().getConsumePrice() >= minPayment20) {
							if(discountPercent20 !=0 ) {
								if (records20.get(i).getConsume().getConsumePrice() * discountPercent20 * 0.01 > maxDiscount20 && maxDiscount20 !=0) {
									tempDiscount = maxDiscount20;
									
									discount20 += tempDiscount;
								}else {
									discount20 += records20.get(i).getConsume().getConsumePrice() * discountPercent20 * 0.01;
									
								}
							}else if (discountAmount20 != 0)
								discount20 += discountAmount20;
						}
					} if(maxDiscountMon20 != 0 && discount20 > maxDiscountMon20) {
						discount20 = maxDiscountMon20;
					}
				}//maxCount != 0
				else {
					for(int i = 0; i < records20.size(); i++) {
							if(records20.get(i).getConsume().getConsumePrice() >= minPayment20) {
								if (discountPercent20 != 0) {
									if (records20.get(i).getConsume().getConsumePrice() * discountPercent20 * 0.01 > maxDiscount20 && maxDiscount20 !=0) {
										tempDiscount = maxDiscount20;
										
										discount20 += tempDiscount;
									}else {
										discount20 += records20.get(i).getConsume().getConsumePrice()*discountPercent20 / 100;
										
									}
									
								}
								else if (discountAmount20 != 0)
									discount20 += discountAmount20;
							} 
						} if(maxDiscountMon20 != 0 && discount20 > maxDiscountMon20) {
							discount20 = maxDiscountMon20;
						}
				}//maxCount10 == 0
				model.addAttribute("name20", name20);
				model.addAttribute("discount20", discount20);
			}

			// 21번 카테고리
			if (records21.size() != 0) {
				int maxCount21 = records21.get(0).getMixCount();
				int maxDiscount21 = records21.get(0).getMaxDiscount();
				int minPayment21 = records21.get(0).getMinPayment();
				int discountPercent21 = records21.get(0).getDiscountPercent();
				int tempDiscount = 0;
				int discount21 = 0;
				int maxDiscountMon21 = records21.get(0).getMaxDiscountMonth();
				int discountAmount21 = records21.get(0).getDiscountAmount();
				String name21 = cardCompareService.getLargeCategoryName(records21.get(0).getLargeCategoryId());
			

				if(maxCount21 != 0 && maxCount21 <= records21.size()) {
					for(int i=0; i<maxCount21; i++) {
						if(records21.get(i).getConsume().getConsumePrice() >= minPayment21) {
							if(discountPercent21 !=0 ) {
								if (records21.get(i).getConsume().getConsumePrice() * discountPercent21 * 0.01 > maxDiscount21 && maxDiscount21 !=0) {
									tempDiscount = maxDiscount21;
									
									discount21 += tempDiscount;
								}else {
									discount21 += records21.get(i).getConsume().getConsumePrice() * discountPercent21 * 0.01;
									
								}
							}else if (discountAmount21 != 0)
								discount21 += discountAmount21;
						}
					} if(maxDiscountMon21 != 0 && discount21 > maxDiscountMon21) {
						discount21 = maxDiscountMon21;
					}
				}//maxCount != 0
				else {
					for(int i = 0; i < records21.size(); i++) {
							if(records21.get(i).getConsume().getConsumePrice() >= minPayment21) {
								if (discountPercent21 != 0) {
									if (records21.get(i).getConsume().getConsumePrice() * discountPercent21 * 0.01 > maxDiscount21 && maxDiscount21 !=0) {
										tempDiscount = maxDiscount21;
										
										discount21 += tempDiscount;
									}else {
										discount21 += records21.get(i).getConsume().getConsumePrice()*discountPercent21 / 100;
										
									}
								
								}
								else if (discountAmount21 != 0)
									discount21 += discountAmount21;
							} 
						} if(maxDiscountMon21 != 0 && discount21 > maxDiscountMon21) {
							discount21 = maxDiscountMon21;
						}
				}//maxCount10 == 0
				model.addAttribute("name21", name21);
				model.addAttribute("discount21", discount21);
			}

			// 22번 카테고리
			if (records22.size() != 0) {
				int maxCount22 = records22.get(0).getMixCount();
				int maxDiscount22 = records22.get(0).getMaxDiscount();
				int minPayment22 = records22.get(0).getMinPayment();
				int discountPercent22 = records22.get(0).getDiscountPercent();
				int tempDiscount = 0;
				int discount22 = 0;
				int maxDiscountMon22 = records22.get(0).getMaxDiscountMonth();
				int discountAmount22 = records22.get(0).getDiscountAmount();
				String name22 = cardCompareService.getLargeCategoryName(records22.get(0).getLargeCategoryId());
				

				if(maxCount22 != 0 && maxCount22 <= records22.size()) {
					for(int i=0; i<maxCount22; i++) {
						if(records22.get(i).getConsume().getConsumePrice() >= minPayment22) {
							if(discountPercent22 !=0 ) {
								if (records22.get(i).getConsume().getConsumePrice() * discountPercent22 * 0.01 > maxDiscount22 && maxDiscount22 !=0) {
									tempDiscount = maxDiscount22;
									
									discount22 += tempDiscount;
								}else {
									discount22 += records22.get(i).getConsume().getConsumePrice() * discountPercent22 * 0.01;
									
								}
							}else if (discountAmount22 != 0)
								discount22 += discountAmount22;
						}
					} if(maxDiscountMon22 != 0 && discount22 > maxDiscountMon22) {
						discount22 = maxDiscountMon22;
					}
				}//maxCount != 0
				else {
					for(int i = 0; i < records22.size(); i++) {
							if(records22.get(i).getConsume().getConsumePrice() >= minPayment22) {
								if (discountPercent22 != 0) {
									if (records22.get(i).getConsume().getConsumePrice() * discountPercent22 * 0.01 > maxDiscount22 && maxDiscount22 !=0) {
										tempDiscount = maxDiscount22;
										
										discount22 += tempDiscount;
									}else {
										discount22 += records22.get(i).getConsume().getConsumePrice()*discountPercent22 / 100;
									
									}
									
								}
								else if (discountAmount22 != 0)
									discount22 += discountAmount22;
							} 
						} if(maxDiscountMon22 != 0 && discount22 > maxDiscountMon22) {
							discount22 = maxDiscountMon22;
						}
				}//maxCount10 == 0
				model.addAttribute("name22", name22);
				model.addAttribute("discount22", discount22);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return "cardCompare1";
	}

	@RequestMapping(value = "/cardCompare", method = RequestMethod.GET)
	public String cardCompare(HttpServletRequest request, Model model) {
		int cardId = Integer.parseInt(request.getParameter("cardId"));
		HttpSession session = request.getSession();
		Member member = (Member) session.getAttribute("member");
		HashMap<String, Object> map1 = new HashMap<>();
		HashMap<String, Object> map2 = new HashMap<>();
		ArrayList<Calculation> al1 = new ArrayList<Calculation>();
		ArrayList<Calculation> al2 = new ArrayList<Calculation>();
		try {
			map1.put("cardId", cardId);
			map1.put("memberId", member.getMemberId());
			map2.put("cardId", member.getCardId());
			map2.put("memberId", member.getMemberId());
			al1 = cardCompareService.getBenefitsByCategory(map1);
			al2 = cardCompareService.getBenefitsByCategory(map2);

			HashMap<Integer, Integer> chk1 = new HashMap<>();
			HashMap<Integer, Integer> chk2 = new HashMap<>();
			int tmp = 0;
			// chk에 카테고리별 최대 할인 횟수 추가
			for (int i = 0; i < al1.size(); i++) {
				if (tmp != al1.get(i).getLargeCategoryId()) {
					tmp = al1.get(i).getLargeCategoryId();
					chk1.put(tmp, al1.get(i).getMaxCount());
				}
			}
			
			tmp = 0;
			for (int i = 0; i < al2.size(); i++) {
				if (tmp != al2.get(i).getLargeCategoryId()) {
					tmp = al2.get(i).getLargeCategoryId();
					chk2.put(tmp, al2.get(i).getMaxCount());
				}
			}
			// 날짜 순으로 최대 할인 횟수를 넘어섰을 경우에 삭제
			for (int i = 0; i < al1.size(); i++) {
				if (chk1.get(al1.get(i).getLargeCategoryId()) > 0) {
					chk1.replace(al1.get(i).getLargeCategoryId(), chk1.get(al1.get(i).getLargeCategoryId()) - 1);
				}else {
					al1.remove(i);
					if(i == al1.size() - 1) {
						break;
					}
					--i;
				}
			}
			for (int i = 0; i < al2.size(); i++) {
				if (chk2.get(al2.get(i).getLargeCategoryId()) > 0) {
					chk2.replace(al2.get(i).getLargeCategoryId(), chk2.get(al2.get(i).getLargeCategoryId()) - 1);
				}else {
					al2.remove(i);
					if(i == al2.size() - 1) {
						break;
					}
					i--;
				}
			}
			// 같은 카테고리 항목에 대한 할인이 여러개 있을 경우 통합
			for (int i = 0; i < al1.size(); ++i) {
				for (int j = i + 1; j < al1.size(); j++) {
					if (al1.get(i).getLargeCategoryId() == al1.get(j).getLargeCategoryId()) {
						al1.get(i).setCategoryDiscountPrice(al1.get(i).getCategoryDiscountPrice() + al1.get(j).getCategoryDiscountPrice());
						al1.remove(j);
						j--;
					}
				}
			}
			for (int i = 0; i < al2.size(); ++i) {
				for (int j = i + 1; j < al2.size(); j++) {
					if (al2.get(i).getLargeCategoryId() == al2.get(j).getLargeCategoryId()) {
						al2.get(i).setCategoryDiscountPrice(al2.get(i).getCategoryDiscountPrice() + al2.get(j).getCategoryDiscountPrice());
						al2.remove(j);
						j--;
					}
				}
			}
			
			// 월 최대 할인 금액을 넘어선 경우 월 최대 할인 금액으로 치환
			for(int i = 0; i < al1.size(); i++){
				if(al1.get(i).getMaxDiscountMonth() < al1.get(i).getCategoryDiscountPrice()) {
					al1.get(i).setCategoryDiscountPrice(al1.get(i).getMaxDiscountMonth());
				}
			}
			for(int i = 0; i < al2.size(); i++){
				if(al2.get(i).getMaxDiscountMonth() < al2.get(i).getCategoryDiscountPrice()) {
					al2.get(i).setCategoryDiscountPrice(al2.get(i).getMaxDiscountMonth());
				}
			}
			
			model.addAttribute("myCard", al2);
			model.addAttribute("selectCard", al1);
			Card info = cardCompareService.getCardInfo(cardId);
			Card myInfo = cardCompareService.getCardInfo(member.getCardId());
			model.addAttribute("info", info);
			model.addAttribute("myInfo", myInfo);
			ArrayList<Calculation> al3 = new ArrayList<>(); 
			for(int i = 0; i < al1.size(); i++) {
				al3.add(al1.get(i));
			}
			ArrayList<Calculation> al4 = new ArrayList<>(); 
			for(int i = 0; i < al2.size(); i++) {
				al4.add(al2.get(i));
			}
			ArrayList<Calculation> compare = new ArrayList<>();
			ArrayList<Integer> alTmp = new ArrayList<>();
			
			// 비교와 그래프 작성으로 위해 공통으로 할인된 카테고리와 각각의 카테고리 분리
			for (int i = 0; i < al3.size(); i++) {
				for (int j = 0; j < al4.size(); j++) {
					if (al3.get(i).getLargeCategoryId() == al4.get(j).getLargeCategoryId()) {
						int n = al3.get(i).getCategoryDiscountPrice() - al4.get(j).getCategoryDiscountPrice();
						compare.add(new Calculation(al3.get(i).getLargeCategoryName(),
								al3.get(i).getLargeCategoryImage(), n, al3.get(i).getCategoryDiscountPrice(), al4.get(j).getCategoryDiscountPrice()));
						alTmp.add(al3.get(i).getLargeCategoryId());
					}
				}
			}
			loop: for (int i = 0; i < al3.size(); i++) {
				for (int j = 0; j < alTmp.size(); j++) {
					if (al3.get(i).getLargeCategoryId() == alTmp.get(j)) {
						al3.remove(i);
						if (i > 0) {
							--i;
							continue loop;
						}
					}
				}
			}
			loop: for (int i = 0; i < al4.size(); i++) {
				for (int j = 0; j < alTmp.size(); j++) {
					if (al4.get(i).getLargeCategoryId() == alTmp.get(j)) {
						al4.remove(i);
						if (i > 0) {
							--i;
							continue loop;
						}
					}
				}
			}
			int sum = 0;
			for(int i = 0; i < al1.size(); i++) {
				sum += al1.get(i).getCategoryDiscountPrice();
			}
			for(int i = 0; i < al2.size(); i++) {
				sum -= al2.get(i).getCategoryDiscountPrice();
			}
			model.addAttribute("compareConsume", compare);
			model.addAttribute("onlyMyCard", al4);
			model.addAttribute("onlySelectCard", al3);
			model.addAttribute("comparePrice", sum);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return "cardCompare2";
	}
}