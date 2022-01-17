package kr.co.study.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.study.dao.boardDAO;
import kr.co.study.vo.boardVO;


@Service
public class boardServiceImpl implements boardService {
	@Autowired
	boardDAO dao;
	@Override
	public ArrayList<boardVO> List() {
		return dao.boardList();
	}
}
