package dao;

import static org.junit.Assert.*;

import java.util.Date;

import junit.framework.Assert;

import org.junit.Test;

import dao.CategoryDAOHibernateImpl;
import domain.Category;

public class CategoryDAOHibernateImplTest {

	@Test
	public void testGetById() {
		CategoryDAOHibernateImpl dao = new CategoryDAOHibernateImpl();
		assertNotNull(dao.getById((long) 1));
	}

	@Test
	public void testSave() {
		Category category = new Category();
		category.setName("Hibernate");
		category.setDescription(new Date().toString());
		
		CategoryDAOHibernateImpl dao = new CategoryDAOHibernateImpl();
		dao.save(category);
		long id = category.getCategory_id();
		assertNotNull(dao.getById(id).getCategory_id());
	}

	@Test
	public void testUpdate() {
		CategoryDAOHibernateImpl dao = new CategoryDAOHibernateImpl();
		Category category = dao.getById((long) 1);
		String category_description = "Data " +  new Date().toString();
		category.setDescription(category_description);
		dao.update(category);
		Category newCategory = dao.getById((long) 1);
		assertTrue(newCategory.getDescription().equals(category_description));
	}

	@Test
	public void testDeleteById() {
		CategoryDAOHibernateImpl dao = new CategoryDAOHibernateImpl();
		
		Category category = new Category();
		category.setName("Hibernate");
		category.setDescription("Ahahahahhahahahah!");	
		dao.save(category);
		long id = category.getCategory_id();
		dao.deleteById(id);
		Assert.assertNull(dao.getById(id));
	}

}
