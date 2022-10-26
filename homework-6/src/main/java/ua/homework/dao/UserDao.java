package ua.homework.dao;

import ua.homework.domain.User;
import ua.homework.shared.AbstractCRUD;

public interface UserDao extends AbstractCRUD<User>{
	User getUserByEmail(String email);

}
