package com.pet.controller;

import com.pet.admin.controller.action.adminLoginAction;
import com.pet.admin.controller.action.adminLoginFormAction;
import com.pet.admin.controller.action.helperDeleteAction;
import com.pet.admin.controller.action.helperInsertAction;
import com.pet.admin.controller.action.helperInsertFormAction;
import com.pet.admin.controller.action.helperListAction;
import com.pet.admin.controller.action.helperUpdateAction;
import com.pet.admin.controller.action.helperUpdateFormAction;
import com.pet.admin.controller.action.helperViewAction;
import com.pet.admin.controller.action.userDeleteAction;
import com.pet.admin.controller.action.userListAction;
import com.pet.controller.action.Action;
import com.pet.controller.action.IndexAction;
import com.pet.controller.action.findIdFormAction;
import com.pet.controller.action.idCheckFormAction;
import com.pet.controller.action.joinAction;
import com.pet.controller.action.joinFormAction;
import com.pet.controller.action.loginAction;
import com.pet.controller.action.loginFormAction;
import com.pet.controller.action.logoutAction;
import com.pet.controller.action.mypageFormAction;
import com.pet.controller.action.mypageUpdateAction;
import com.pet.controller.action.mypageUpdateFormAction;
import com.pet.controller.action.petAdoptDeleteAction;
import com.pet.controller.action.petAdoptListAction;
import com.pet.controller.action.petAdoptUpdateAction;
import com.pet.controller.action.petAdoptUpdateFormAction;
import com.pet.controller.action.petAdoptViewAction;
import com.pet.controller.action.petAdoptWriteAction;
import com.pet.controller.action.petAdoptWriteFormAction;
import com.pet.controller.action.petBoardDeleteAction;
import com.pet.controller.action.petBoardListAction;
import com.pet.controller.action.petBoardUpdateAction;
import com.pet.controller.action.petBoardUpdateFormAction;
import com.pet.controller.action.petBoardViewAction;
import com.pet.controller.action.petBoardWriteAction;
import com.pet.controller.action.petBoardWriteFormAction;
import com.pet.controller.action.petContestDeleteAction;
import com.pet.controller.action.petContestListAction;
import com.pet.controller.action.petContestUpdateAction;
import com.pet.controller.action.petContestUpdateFormAction;
import com.pet.controller.action.petContestViewAction;
import com.pet.controller.action.petContestWriteAction;
import com.pet.controller.action.petContestWriteFormAction;
import com.pet.controller.action.petDLoginAction;
import com.pet.controller.action.petDLoginFormAction;
import com.pet.controller.action.petDiaryCalendarAction;
import com.pet.controller.action.petDiaryDeleteAction;
import com.pet.controller.action.petDiaryUpdateAction;
import com.pet.controller.action.petDiaryUpdateFormAction;
import com.pet.controller.action.petDiaryViewAction;
import com.pet.controller.action.petDiaryWriteAction;
import com.pet.controller.action.petDiaryWriteFormAction;
import com.pet.controller.action.petQnaDViewAction;
import com.pet.controller.action.petQnaDeleteAction;
import com.pet.controller.action.petQnaListAction;
import com.pet.controller.action.petQnaRepAction;
import com.pet.controller.action.petQnaUpdateAction;
import com.pet.controller.action.petQnaUpdateFormAction;
import com.pet.controller.action.petQnaViewAction;
import com.pet.controller.action.petQnaWriteAction;
import com.pet.controller.action.petQnaWriteFormAction;
import com.pet.controller.action.petShopDeleteAction;
import com.pet.controller.action.petShopListAction;
import com.pet.controller.action.petShopMatchCancleAction;
import com.pet.controller.action.petShopMatchListAction;
import com.pet.controller.action.petShopUpdateAction;
import com.pet.controller.action.petShopUpdateFormAction;
import com.pet.controller.action.petShopViewAction;
import com.pet.controller.action.petShopWriteAction;
import com.pet.controller.action.petShopWriteFormAction;
import com.pet.controller.action.removeHelperAction;
import com.pet.controller.action.userMatchAction;
import com.pet.controller.action.userMatchListAction;

public class ActionFactory {
	private ActionFactory() {
		
	}
	private static ActionFactory instance = new ActionFactory();
	public static ActionFactory getInstance() {
		return instance;
	}
	public Action getAction(String command) {
		Action ac = null;
		if (command.equals("index"))  ac = new IndexAction();
		else if(command.equals("login_form")) ac = new loginFormAction();
		else if(command.equals("login")) ac = new loginAction();
		else if(command.equals("logout")) ac = new logoutAction();
		else if(command.equals("find_id_form")) ac = new findIdFormAction();
		else if(command.equals("join_form")) ac = new joinFormAction();
		else if(command.equals("id_check_form")) ac = new idCheckFormAction();
		else if(command.equals("join")) ac = new joinAction();
		// diary
		else if(command.equals("pet_diary_calendar")) ac = new petDiaryCalendarAction();
		else if(command.equals("pet_diary_view")) ac = new petDiaryViewAction();
		else if(command.equals("pet_diary_delete")) ac = new petDiaryDeleteAction();
		else if(command.equals("pet_diary_write_form")) ac = new petDiaryWriteFormAction();
		else if(command.equals("pet_diary_write")) ac = new petDiaryWriteAction();
		else if(command.equals("pet_diary_update_form")) ac = new petDiaryUpdateFormAction();
		else if(command.equals("pet_diary_update")) ac = new petDiaryUpdateAction();
		// shop
		else if(command.equals("shop_list")) ac = new petShopListAction();
		else if(command.equals("shop_write_form")) ac = new petShopWriteFormAction();
		else if(command.equals("shop_write")) ac = new petShopWriteAction();
		else if(command.equals("shop_view")) ac = new petShopViewAction();
		else if(command.equals("shop_delete")) ac = new petShopDeleteAction();
		else if(command.equals("shop_update_form")) ac = new petShopUpdateFormAction();
		else if(command.equals("shop_update")) ac = new petShopUpdateAction();
		else if(command.equals("shop_match_list")) ac = new petShopMatchListAction();
		else if(command.equals("shop_match_cancle")) ac = new petShopMatchCancleAction();
		// admin
		else if(command.equals("admin_login_form")) ac = new adminLoginFormAction();
		else if(command.equals("admin_login")) ac = new adminLoginAction();
		else if(command.equals("user_list"))	ac = new userListAction();	
		else if(command.equals("user_delete"))	ac = new userDeleteAction();	

		// helper
		else if(command.equals("helper_list")) ac = new helperListAction();
		else if(command.equals("helper_view")) ac = new helperViewAction();
		else if(command.equals("helper_delete")) ac = new helperDeleteAction();
		else if(command.equals("helper_insert_form")) ac = new helperInsertFormAction();
		else if(command.equals("helper_insert")) ac = new helperInsertAction();
		else if(command.equals("helper_update_form")) ac = new helperUpdateFormAction();
		else if(command.equals("helper_update")) ac = new helperUpdateAction();
		else if(command.equals("user_match")) ac = new userMatchAction();
		else if(command.equals("user_match_list")) ac = new userMatchListAction();
		// user mypage
		else if(command.equals("mypage_form")) ac = new mypageFormAction();
		else if(command.equals("mypage_update_form")) ac = new mypageUpdateFormAction();
		else if(command.equals("mypage_update")) ac = new mypageUpdateAction();
		else if(command.equals("remove_helper")) ac = new removeHelperAction();
		// adopt
		else if(command.equals("pet_adopt_list")) ac = new petAdoptListAction();
		else if(command.equals("pet_adopt_view")) ac = new petAdoptViewAction();
		else if(command.equals("pet_adopt_write_form")) ac = new petAdoptWriteFormAction();
		else if(command.equals("pet_adopt_write")) ac = new petAdoptWriteAction();
		else if(command.equals("pet_adopt_delete")) ac = new petAdoptDeleteAction();
		else if(command.equals("pet_adopt_update_form")) ac = new petAdoptUpdateFormAction();
		else if(command.equals("pet_adopt_update")) ac = new petAdoptUpdateAction();
		// board
		else if(command.equals("pet_board_list")) ac = new petBoardListAction();
		else if(command.equals("pet_board_write_form")) ac = new petBoardWriteFormAction();
		else if(command.equals("pet_board_write")) ac = new petBoardWriteAction();
		else if(command.equals("pet_board_view")) ac = new petBoardViewAction();
		else if(command.equals("pet_board_update_form")) ac = new petBoardUpdateFormAction();
		else if(command.equals("pet_board_update")) ac = new petBoardUpdateAction();
		else if(command.equals("pet_board_delete")) ac = new petBoardDeleteAction();				
		// Q&A
		else if(command.equals("pet_qna_list")) ac = new petQnaListAction();
		else if(command.equals("pet_qna_write_form")) ac = new petQnaWriteFormAction();	
		else if(command.equals("pet_qna_write")) ac = new petQnaWriteAction();	
		else if(command.equals("pet_qna_view")) ac = new petQnaViewAction();	
		else if(command.equals("pet_qna_update_form")) ac = new petQnaUpdateFormAction();	
		else if(command.equals("pet_qna_update")) ac = new petQnaUpdateAction();	
		else if(command.equals("pet_qna_delete")) ac = new petQnaDeleteAction();
			
		else if(command.equals("p_helper_login_form")) ac = new petDLoginFormAction();
		else if(command.equals("p_helper_login")) ac = new petDLoginAction();
		else if(command.equals("helper_qna_dview")) ac = new petQnaDViewAction();	
		else if(command.equals("pet_qna_rep")) ac = new petQnaRepAction();
		
		// contest
		else if(command.equals("pet_contest_list")) ac = new petContestListAction();
		else if(command.equals("pet_contest_view")) ac = new petContestViewAction();
		else if(command.equals("pet_contest_write_form")) ac = new petContestWriteFormAction();
		else if(command.equals("pet_contest_write")) ac = new petContestWriteAction();
		else if(command.equals("pet_contest_delete")) ac = new petContestDeleteAction();
		else if(command.equals("pet_contest_update_form")) ac = new petContestUpdateFormAction();
		else if(command.equals("pet_contest_update")) ac = new petContestUpdateAction();
		
		return ac;
		
	}
}
