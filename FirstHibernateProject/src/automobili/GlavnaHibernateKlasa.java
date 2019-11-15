package automobili;

import controller.HibernateDAO;
import model.Car;
import model.User;
import model.VisitCard;
import model.VrstaVozila;

public class GlavnaHibernateKlasa {

	public static void main(String[] args) {

		HibernateDAO dao = new HibernateDAO();
		
		Car car1 = new Car("crysler", "300c", 2019, 35000, false, VrstaVozila.PUTNICKO);
		Car car2 = new Car("dodge", "caliber", 2017, 10000, false, VrstaVozila.PUTNICKO);
		Car car3 = new Car("lexus", "lc500", 2019, 110000, true, VrstaVozila.PUTNICKO);
		Car car4 = new Car("lada", "niva", 2019, 19000, false, VrstaVozila.TERENAC);
		
		dao.snimiAutoUBazu(car1);
		dao.snimiAutoUBazu(car2);
		dao.snimiAutoUBazu(car3);
		dao.snimiAutoUBazu(car4);


		
		/*Car car = new Car("land rover", "discovery", 2018, 39990, false, VrstaVozila.SUV);
		
		VisitCard visitCard = new VisitCard();
			visitCard.setIme("Ruzica");
			visitCard.setEmail("ruza@gmail.com");
			visitCard.setBrojTelefona("0641234567");
		
		User user = new User();
			user.setUserName("ruza");
			user.setPassword("ruzaprogramer123");
			user.setNovcanik(100000);
			user.setVisitCard(visitCard);
			
			
			
		dao.snimiAutoUBazu(car);
		dao.snimiUsera(user);*/
		
		
	
	}

}
