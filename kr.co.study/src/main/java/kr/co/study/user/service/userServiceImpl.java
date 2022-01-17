package kr.co.study.user.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.study.user.dao.userDAO;
import kr.co.study.user.vo.userVO;

@Service
public class userServiceImpl implements userService {
	@Autowired
	userDAO dao;
	@Override
	public ArrayList<userVO> userList() {
		return dao.userList();
	}
}
