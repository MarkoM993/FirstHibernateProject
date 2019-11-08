package automobili;

import controller.HibernateDAO;
import model.Car;

public class GlavnaHibernateKlasa {

	public static void main(String[] args) {

		HibernateDAO dao = new HibernateDAO();
		
	//	Car car = new Car("maseratti","ghilbi", 2016, 0.18 , true);
	//	dao.snimiAutoUBazu(car);
		
		Car car = dao.vratiAuto(2);
		
		dao.deleteCar(car.getId());
	}

}
