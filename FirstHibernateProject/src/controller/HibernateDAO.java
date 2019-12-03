package controller;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import model.Car;
import model.User;

public class HibernateDAO {

	SessionFactory factory = new Configuration().configure().buildSessionFactory();

	public boolean snimiAutoUBazu(Car car) {

		Session sesija = factory.openSession();
		sesija.beginTransaction();

		try {
			sesija.save(car);
			sesija.getTransaction().commit();
			return true;
		} catch (Exception e) {
			sesija.getTransaction().rollback();
			return false;
		} finally {
			sesija.close();
		}
	}

	public boolean snimiUsera(User user) {

		Session sesija = factory.openSession();
		sesija.beginTransaction();

		try {
			sesija.save(user);
			sesija.getTransaction().commit();
			return true;
		} catch (Exception e) {
			sesija.getTransaction().rollback();
			return false;
		} finally {
			sesija.close();
		}
	}

	public Car vratiAuto(int id) {
		Session sesija = factory.openSession();
		sesija.beginTransaction();

		Car car = null;
		try {
			car = sesija.get(Car.class, id);
			sesija.getTransaction().commit();
			return car;
		} catch (Exception e) {
			sesija.getTransaction().rollback();
			return car;
		} finally {
			sesija.close();
		}
	}

	public User vratiUsera(int id) {
		Session sesija = factory.openSession();
		sesija.beginTransaction();

		User user = null;
		try {
			user = sesija.get(User.class, id);
			sesija.getTransaction().commit();
			return user;
		} catch (Exception e) {
			sesija.getTransaction().rollback();
			return user;
		} finally {
			sesija.close();
		}
	}

	public void updateCarPrice(int id, double novaCena) {
		Session sesija = factory.openSession();
		sesija.beginTransaction();

		Car car = null;
		try {
			car = sesija.get(Car.class, id);
			car.setCena(novaCena);
			sesija.saveOrUpdate(car);
			sesija.getTransaction().commit();
		} catch (Exception e) {
			sesija.getTransaction().rollback();
		} finally {
			sesija.close();
		}
	}

	public void deleteCar(int id) {
		Session sesija = factory.openSession();
		sesija.beginTransaction();

		Car car = null;
		try {
			car = sesija.get(Car.class, id);
			sesija.delete(car);
			sesija.getTransaction().commit();
		} catch (Exception e) {
			sesija.getTransaction().rollback();
		} finally {
			sesija.close();
		}
	}

	public boolean daLiUserImaDovoljnoParaZaAutomobile(User user, List<Car> listaAutomobila) {
		Session sesija = factory.openSession();
		sesija.beginTransaction();

		double novcanik = user.getNovcanik();		
		double krajnjaCena = 0;
		
		for(Car car: listaAutomobila) {
			krajnjaCena += car.getCena();
		}
		
		try {
			if(novcanik >= krajnjaCena) {
				System.out.println("Kupili ste automobile!");
				sesija.getTransaction().commit();
				return true;
			}else {
				System.out.println("Nemate dovoljno novca");
				sesija.getTransaction().commit();
				return false;
			}
			
		} catch (Exception e) {
			sesija.getTransaction().rollback();
			return false;
		} finally {
			sesija.close();
		}
	}
	
	public void spojUseraIAuto(User user, List<Car> listaAutomobila) {
		Session sesija = factory.openSession();
		sesija.beginTransaction();

		user.setAutomobili(listaAutomobila);
		
		double krajnjaCena = 0;
		
		
		user.setNovcanik(user.getNovcanik() - krajnjaCena);
		try {
			for(Car car: listaAutomobila) {
				car.setKorisnik(user);
				sesija.update(car);
				krajnjaCena += car.getCena();
			}
			sesija.update(user);
			sesija.getTransaction().commit();
			System.out.println("Sve je OK");
		} catch (Exception e) {
			sesija.getTransaction().rollback();
		} finally {
			sesija.close();
		}
	}
	
	public void izlistajAutomobile(User user) {
		Session sesija = factory.openSession();
		sesija.beginTransaction();

		List<Car> automobili = new ArrayList<Car>();
		
		try {
			//lazy initialize - rucno preuzimanje liste koje je obavezno
			
			/*User u = sesija.get(User.class, user.getIdUser());
			
			//u.getAutomobili().size();
			
			Hibernate.initialize(u);*/
			
			automobili = user.getAutomobili();
			
			System.out.println("Korisnik " + user.getUserName() + " je kupio/la ");
			
			
			for(Car car: automobili) {
				System.out.println(car.getMarka() + " " + car.getModel());
			}
			sesija.getTransaction().commit();
		} catch (Exception e) {
			sesija.getTransaction().rollback();
		} finally {
			sesija.close();
		}
	
	}
	
	public List<Car> dajMiSveAutomobileIzBaze(){
		Session sesija = factory.openSession();
			sesija.beginTransaction();

		List<Car> automobili = new ArrayList<Car>();
		
		
		try {
			String upit = "FROM Car";
			Query query = sesija.createQuery(upit);
			
			automobili = query.getResultList();
			
			sesija.getTransaction().commit();
			return automobili;

		} catch (Exception e) {
			sesija.getTransaction().rollback();
			return null;
		} finally {
			sesija.close();
		}
		
	}
	
	public List<Car> DajMiSveJeftinijeAutomobile(double odabranaCena){
		Session sesija = factory.openSession();
			sesija.beginTransaction();

		List<Car> automobili = new ArrayList<Car>();
		
		
		try {
			String upit = "FROM Car WHERE cena < :Snupi";
			Query query = sesija.createQuery(upit);
			query.setParameter("Snupi", odabranaCena);
			
			automobili = query.getResultList();
			
			sesija.getTransaction().commit();
			return automobili;

		} catch (Exception e) {
			sesija.getTransaction().rollback();
			return null;
		} finally {
			sesija.close();
		}
		
	}
		
	

	// Metoda za 1 to 1
	/*
	 * public void linkujUseraIAuto (int idCar, int idUser) { Session sesija =
	 * factory.openSession(); sesija.beginTransaction();
	 * 
	 * Car car = null; User user = null;
	 * 
	 * try { car = sesija.get(Car.class, idCar); user = sesija.get(User.class,
	 * idUser);
	 * 
	 * car.setKorisnik(user); user.setAuto(car);
	 * 
	 * sesija.update(user); sesija.update(car);
	 * 
	 * sesija.getTransaction().commit(); } catch (Exception e) {
	 * sesija.getTransaction().rollback(); }finally { sesija.close(); } }
	 */

}
