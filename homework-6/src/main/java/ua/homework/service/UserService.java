package ua.homework.service;

import ua.homework.domain.User;
import ua.homework.shared.AbstractCRUD;

public interface UserService extends AbstractCRUD<User>{
	User getUserByEmail(String email);
}
