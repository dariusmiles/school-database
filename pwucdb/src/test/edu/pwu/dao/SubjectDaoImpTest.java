package test.edu.pwu.dao;

import static org.junit.Assert.*;

import main.edu.pwu.dao.SubjectDaoImp;
import main.edu.pwu.model.Subject;
import main.edu.pwu.model.Subject.SUBJECT_TYPE;

import org.junit.Test;

public class SubjectDaoImpTest {

	@Test
	public void testGet() {
		SubjectDaoImp subjectDao = new SubjectDaoImp();
		Subject subject = subjectDao.get("Comm II");
		
		assertEquals("Comm II", subject.getCode());
		assertEquals("Communication Arts II", subject.getTitle());
		assertEquals(null,subject.getDescription());
		Integer units = 3;
		assertEquals(units, subject.getUnits());
		assertEquals(SUBJECT_TYPE.ACADEMIC, subject.getType());
	}
	
	@Test
	public void testGetNull(){
		SubjectDaoImp subjectDao = new SubjectDaoImp();
		assertEquals(null, subjectDao.get("dfagda"));
	}

}
