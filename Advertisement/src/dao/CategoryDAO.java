package dao;

import domain.Category;

public interface CategoryDAO {

	Category getById(Long id);

	void save(Category category);

	void update(Category category);

	void deleteById(Long id);

}
