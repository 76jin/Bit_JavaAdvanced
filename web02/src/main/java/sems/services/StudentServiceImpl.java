package sems.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

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

	@Override
	public void add(StudentVo student) {
		// 1. 트랜잭션을 정의한다.
		DefaultTransactionDefinition def = new DefaultTransactionDefinition();

		// 1)트랜잭션의 이름
		def.setName("tx1");

		// 2) 트랜잭션 관리 정책 (트랜잭션 반드시 요구됨 정책)
		// 		- Propagation : 전파하다.
		def.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);

		// 2. 트랜잭션 관리자로부터 트랜잭션 핸들러 얻기
		TransactionStatus status = txManager.getTransaction(def);
		try {
			userDao.insert(student); // StudentVo는 UserVo의 자식이므로 형변환 가능
			studentDao.insert(student);

			txManager.commit(status);

		} catch (Throwable ex) {
			txManager.rollback(status);
			throw new RuntimeException("학생 정보 입력 오류!", ex);
			// 메서드에 throws를 선언하지 않아도 이 예외를 DispatcherServlet에게 전달한다.
		}
	}

}
