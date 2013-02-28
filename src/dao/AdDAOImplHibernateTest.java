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
		;
	}

	@Test
	public final void testDeleteById() {
		fail("Not yet implemented");
	}

}
