package sems.dao;

import java.util.List;
import java.util.Map;

import sems.vo.SubjectVo;

// SubjectDao를 인터페이스로 만든다.
// 각 DBMS 별로 구현체를 만든다.
// Dao의 교체가 쉬워진다.

public interface SubjectDao {
	void insert(SubjectVo subject) throws Throwable;
	List<SubjectVo> list(Map<String,Integer> params) throws Throwable;
	SubjectVo detail(int no) throws Throwable;
	void update(SubjectVo subject) throws Throwable;
	void delete(int no) throws Throwable;
}









