package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import dto.Student;

public class Studentdao {
	EntityManagerFactory e = Persistence.createEntityManagerFactory("dev");
	EntityManager m = e.createEntityManager();
	EntityTransaction t = m.getTransaction();

	public void save(Student s) {
		t.begin();
		m.persist(s);
		t.commit();
	}

	public List<Student> Fetchall() {
// Query q=m.createNamedQuery("select a from Student a");
		return m.createQuery("select a from Student a").getResultList();
	}

	public Student find(int id) {
		return m.find(Student.class, id);
	}

	public void Delete(int id) {
		t.begin();
		m.remove(m.find(Student.class, id));
		t.commit();
		
	}

}