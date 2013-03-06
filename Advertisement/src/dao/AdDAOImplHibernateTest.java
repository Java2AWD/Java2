package dao;

import static org.junit.Assert.*;

import java.util.Collection;
import java.util.Date;
import java.util.Iterator;

import org.junit.Test;

import utils.TransactExecute;

import domain.Ad;

public class AdDAOImplHibernateTest {

	AdvertismentDAO dao = new AdDAOImplHibernate();
	@Test
	public final void testGetById() {
		Ad ad = new Ad();
		ad=dao.getById( 89);
		System.out.println(ad.getCategory_id());
			assertEquals(777, ad.getCategory_id());
	}

	@Test
	public final void testSave() {
		
		Date date = new Date();
		Ad ad = new Ad();
		ad.setMessage(" hibernate");
		ad.setUsers_id(4);
		ad.setCategory_id(4);
		ad.setDate(date);
		dao.save(ad);
		
		Ad fromDB = dao.getById(809);
		assertEquals(4, fromDB.getCategory_id() );
	}

	@Test
	public final void testUpdate() {
		Ad ad = new Ad();
		int id = 789;
		ad.setCategory_id(id);
		ad.setUsers_id(id);
		ad.setAdId(289);
		ad.setMessage("update");
		Date date = new Date();
		ad.setDate(date);
		dao.update(ad);
		Ad fromBD = dao.getById(289);
		assertEquals(789, fromBD.getCategory_id());
		;
	}

	@Test
	public  void testDeleteById() {
		int id = 189;
		dao.deleteById(id);
		//Ad fromBD = dao.getById(555);
	//	assertEquals(null, fromBD.getAdId());
	}
	@Test
	public final void testGetAllAds()
	{
		Collection ads =dao.getAllAds();
		Iterator iterator = ads.iterator();
		while(iterator.hasNext())
		{
			Ad ad = (Ad) iterator.next();
			System.out.println(ad.getAdId() + ad.getMessage() + ad.getDate() + ad.getUsers_id() + ad.getCategory_id());
		}
	}

}
