package dao;

import static org.junit.Assert.*;

import org.junit.Test;

import domain.Ad;

public class AdDAOImplHibernateTest {

	@Test
	public final void testGetById() {
		fail("Not yet implemented");
	}

	@Test
	public final void testSave() {
		
		AdvertismentDAO dao = new AdDAOImplHibernate(); 
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
		fail("Not yet implemented");
	}

	@Test
	public final void testDeleteById() {
		fail("Not yet implemented");
	}

}
