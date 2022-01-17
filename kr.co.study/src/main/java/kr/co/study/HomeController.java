package kr.co.study;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.co.study.service.boardService;
import kr.co.study.user.service.userService;
import kr.co.study.user.vo.userVO;
import kr.co.study.vo.boardVO;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	@Inject
	boardService se;
	@Inject
	userService ue;
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
		
		
	}
	
	@RequestMapping(value = "board.do", method = RequestMethod.GET)
	public String board1(Model mo) {
		ArrayList<boardVO> List = se.List();
		if (List != null) {
			mo.addAttribute("List", List);
		}else {
			System.out.println("::: boardList controller error :::");
		}
		
		ArrayList<userVO> userList = ue.userList();
		if (userList != null) {
			mo.addAttribute("userList", userList);
		}else {
			System.out.println("::: userList controller error :::");
		}
		
		return "board";
	}
	
	@RequestMapping(value = "board.do", method= RequestMethod.POST)
	public ArrayList<boardVO> board(Model mo) {
		ArrayList<boardVO> List = se.List();
		if (List != null) {
			mo.addAttribute("List", List);
		}else {
			System.out.println("::: boardList controller error :::");
		}
		
		return List;
	}
	
}
