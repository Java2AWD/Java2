package dao;

import junit.framework.Assert;
import org.junit.Test;

public class JdbcDAOMySqlTest {
	@Test
	public void getConnectionTest () {
		JdbcDAOMySql jdbc = new JdbcDAOMySql();
		Assert.assertNotNull(jdbc.getConnection());
	}
}
