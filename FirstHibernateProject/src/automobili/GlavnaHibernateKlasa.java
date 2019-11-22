package automobili;

import java.util.ArrayList;
import java.util.List;

import controller.HibernateDAO;
import model.Car;
import model.User;
import model.VisitCard;
import model.VrstaVozila;

public class GlavnaHibernateKlasa {

	public static void main(String[] args) {

		HibernateDAO dao = new HibernateDAO();
		
		User user = dao .vratiUsera(1);
		System.out.println("Zdravo " + user.getUserName());
		
		
		
		
		
		/*Car auto1 = dao.vratiAuto(2);
		Car auto2 = dao.vratiAuto(3);
		Car auto3 = dao.vratiAuto(5);

		List<Car> ruziniAutomobili = new ArrayList<Car>();
		
		ruziniAutomobili.add(auto1);
		ruziniAutomobili.add(auto2);
		ruziniAutomobili.add(auto3);
		
		if(dao.daLiUserImaDovoljnoParaZaAutomobile(user, ruziniAutomobili)) {
			
			dao.spojUseraIAuto(user, ruziniAutomobili);
		}
*/
		
		
		
		
		
		
		/*Car car1 = new Car("crysler", "300c", 2019, 35000, false, VrstaVozila.PUTNICKO);
		Car car2 = new Car("dodge", "caliber", 2017, 10000, false, VrstaVozila.PUTNICKO);
		Car car3 = new Car("lexus", "lc500", 2019, 110000, true, VrstaVozila.PUTNICKO);
		Car car4 = new Car("lada", "niva", 2019, 19000, false, VrstaVozila.TERENAC);
		
		dao.snimiAutoUBazu(car1);
		dao.snimiAutoUBazu(car2);
		dao.snimiAutoUBazu(car3);
		dao.snimiAutoUBazu(car4);*/


		
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
