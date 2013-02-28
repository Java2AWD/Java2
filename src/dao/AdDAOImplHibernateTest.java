package dao;

import static org.junit.Assert.*;

import org.junit.Test;

import domain.Ad;

public class AdDAOImplHibernateTest {

	AdvertismentDAO dao = new AdDAOImplHibernate();
	@Test
	public final void testGetById() {
		Ad ad = new Ad();
		ad=dao.getById((long) 89);
		System.out.println(ad.getCategory_id());
			assertEquals(1, ad.getCategory_id());
	}

	@Test
	public final void testSave() {
		
		 
		Ad ad = new Ad();
		ad.setMessage("privet from hibernate");
		ad.setUsers_id(3);
		ad.setCategory_id(3);
		dao.save(ad);
		
		Ad fromDB = dao.getById((long) 2);
		assertEquals("3", fromDB.getUsers_id() );
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
