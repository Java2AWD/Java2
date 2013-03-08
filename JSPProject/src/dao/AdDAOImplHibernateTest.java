package dao;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;

import org.hibernate.metamodel.relational.Size;
import org.infinispan.util.SysPropertyActions;
import org.junit.Test;

import utils.TaskExecute;
import utils.TransactExecute;

import domain.Ad;

public class AdDAOImplHibernateTest {

	AdvertismentDAO dao = new AdDAOImplHibernate();
	TransactExecute te = new TransactExecute();

	@Test
	public void testGetById() {
		TaskExecute task = new TaskExecute() {

			@Override
			public void execute() {
				Ad ad = new Ad();
				ad = dao.getById(89);
				System.out.println(ad.getCategory_id());
				assertEquals(777, ad.getCategory_id());
			}
		};

		te.executeTransact(task);
	}

	@Test
	public final void testSave() {
		TaskExecute task = new TaskExecute() {

			@Override
			public void execute() {
				Date date = new Date();
				Ad ad = new Ad();

				ad.setMessage(" hibernate");
				ad.setUsers_id(4);
				ad.setCategory_id(4);
				ad.setDate(date);
				int id = dao.create(ad);
				System.out.println(id);
			}
		};

		te.executeTransact(task);

		// assertEquals();
	}

	@Test
	public final void testUpdate() {
		TaskExecute task = new TaskExecute() {

			@Override
			public void execute() {
				Ad ad = new Ad();
				int id = 789;
				ad.setCategory_id(id);
				ad.setUsers_id(id);
				ad.setAdId(id);
				ad.setMessage("update");
				Date date = new Date();
				ad.setDate(date);
				dao.update(ad);
				Ad fromBD = dao.getById(289);
				assertEquals(789, fromBD.getCategory_id());
			}
		};
		te.executeTransact(task);

	}

	@Test
	public void testDeleteById() {
		TaskExecute task = new TaskExecute() {

			@Override
			public void execute() {
				int id = 801;
				dao.deleteById(id);
				//Ad fromBD = dao.getById(id);
				//assertEquals(null, fromBD.getAdId());
			}
		};
		te.executeTransact(task);
	}

	@Test
	public void testGetAllAdsFromDbByUserId() {
		TaskExecute task = new TaskExecute() {

			@Override
			public void execute() {
				List<Ad> adsList = new ArrayList<>();
				adsList = dao.getAllMessagesByUserId(123);
				for (Ad ad : adsList) {
					System.out.println("Ad_id : " + ad.getAdId());
				}
			}
		};
		te.executeTransact(task);
	}

	@Test
	public void testGetAllAdsByCategory_Id() {
		TaskExecute task = new TaskExecute() {

			@Override
			public void execute() {
				List<Ad> adsList = new ArrayList<>();
				adsList = dao.getAllMessagesByCategoryId(123);
				for (Ad ad : adsList) {
					System.out.println("Category_id : " + ad.getCategory_id());
				}
			}

		};
		te.executeTransact(task);
	}
}