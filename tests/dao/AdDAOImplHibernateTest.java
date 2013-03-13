package dao;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Test;

import domain.Ad;

public class AdDAOImplHibernateTest {

	AdvertismentDAO dao = new AdDAOImplHibernate();
	@Test
	public final void testGetById() {
		Ad ad = new Ad();
		ad=dao.getById( 89);
		System.out.println(ad.getCategory_id());
			assertEquals(123, ad.getCategory_id());
	}

	@Test
	public final void testSave() {
		
		 Date date = new Date();
		Ad ad = new Ad();
		ad.setMessage("privet from hibernate");
		ad.setUsers_id(3);
		ad.setCategory_id(3);
		ad.setDate(date);
		dao.save(ad);
		
		Ad fromDB = dao.getById(89);
		assertEquals(123, fromDB.getUsers_id() );
	}

	@Test
	public final void testUpdate() {
		Ad ad = new Ad();
		int id = 777;
		ad.setCategory_id(id);
		ad.setAdId(89);
		ad.setMessage("update");
		Date date = new Date();
		ad.setDate(date);
		dao.update(ad);
		Ad fromBD = dao.getById(89);
		assertEquals(777, fromBD.getCategory_id());
		;
	}

	@Test
	public final void testDeleteById() {
		int id = 189;
		dao.deleteById(id);
		//Ad fromBD = dao.getById(555);
	//	assertEquals(null, fromBD.getAdId());
	}

}
