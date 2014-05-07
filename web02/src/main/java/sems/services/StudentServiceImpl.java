package sems.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import sems.dao.StudentDao;
import sems.dao.UserDao;
import sems.vo.StudentVo;

@Service
public class StudentServiceImpl implements StudentsService {
	
	@Autowired
	PlatformTransactionManager txManager;
	
	@Autowired
	UserDao userDao;
	
	@Autowired
	StudentDao studentDao;

	/* @Transactional 애노테이션을 처리하려면,
	 *  스프링에 트랜잭션 처리자를 등록해야 한다.
	 *  <tx:annotation-driven />
	 *  
	 *  트랜잭션이 반드시 필요하다 => propagation=Propagation.REQUIRED
	 *  에러가 발생하면 롤백하겠다 => rollbackFor=Throwable.class
	 */
	@Transactional(
			propagation=Propagation.REQUIRED,
			rollbackFor=Throwable.class)
	@Override
	public void add(StudentVo student) {
		userDao.insert(student); // StudentVo는 UserVo의 자식이므로 형변환 가능
		studentDao.insert(student);

	}

}
