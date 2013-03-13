package dao;



import java.util.Date;

import junit.framework.Assert;

import org.junit.Test;

import domain.Ad;



public class AdvertisementDAOHibernateImplTest {

	@Test
	public void testGetById() {
		AdDAOImplHibernate dao = new AdDAOImplHibernate();
		Assert.assertNotNull(dao.getById(2));
	}

	@Test
	public void testSave() {
		Ad ad = new Ad();
		ad.setMessage("This is messageH");
		ad.setDate(new Date());
		ad.setCategory_id(1);
		ad.setUsers_id(2);
		
		AdDAOImplHibernate dao = new AdDAOImplHibernate();
		dao.save(ad);
		int id = ad.getAdId();
		Assert.assertNotNull(dao.getById(id));
	}

	@Test
	public void testUpdate() {
		AdDAOImplHibernate dao = new AdDAOImplHibernate();
		Ad ad = dao.getById(4);
		String message = "IzmenenijaHib";
		ad.setMessage(message);
		dao.update(ad);
		Ad newAd = dao.getById(4);
		Assert.assertTrue(newAd.getMessage().equals(message));
	}

	@Test
	public void testDeleteById() {
		AdDAOImplHibernate dao = new AdDAOImplHibernate();
		
		Ad ad = new Ad();
		ad.setMessage("Delete this rowH");
		ad.setDate(new Date());
		ad.setCategory_id(1);
		ad.setUsers_id(2);
		dao.save(ad);
		int id = ad.getAdId();
		dao.deleteById(id);
		Assert.assertNull(dao.getById(id));
	}

}
