package pti.sb_airport2_mvc.db;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.SelectionQuery;
import org.springframework.stereotype.Repository;

import pti.sb_airport2_mvc.model.Flight;

@Repository
public class Database {
private SessionFactory sessionFactory;
	
	public Database(){
		
		Configuration config = new Configuration();
		config.configure();
		
		sessionFactory = config.buildSessionFactory();
	}

	public List<Flight> getAllFlights() {
		
			List<Flight> flights = null;
			
			Session session = sessionFactory.openSession();
			Transaction tx = session.beginTransaction();
		
			SelectionQuery<Flight> query = session.createSelectionQuery("Select f FROM Flight f ", Flight.class);
			
			flights = query.getResultList();
			
			
		tx.commit();
		session.close();
		
		return flights;
	}
}
