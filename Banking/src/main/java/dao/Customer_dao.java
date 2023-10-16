package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import dto.Customer;

public class Customer_dao {

	EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
	EntityManager em = emf.createEntityManager();
	EntityTransaction et = em.getTransaction();

	public void save(Customer customer) {
		et.begin();
		em.persist(customer);
		et.commit();

	}

	public List<Customer> fetch(long mobile) {

		List<Customer> list = em.createQuery("select x from Customer x where mob=?1").setParameter(1, mobile)
				.getResultList();

		return list;
	}

	public List<Customer> fetch(String email) {
		
			List<Customer> list = em.createQuery("select x from Customer x where email=?1").setParameter(1, email).getResultList();

			return list;
		}
	
	public Customer fetchbyCustid(long custid)
	{
		Customer customer = em.find(Customer.class, custid);
		return customer;
		 
	}
	public void update(Customer customer) {
		et.begin();
		em.merge(customer);
		et.commit();

	}

	
}
