package ua.com.shami.serialnotification.repository;

import org.springframework.data.repository.CrudRepository;
import ua.com.shami.serialnotification.model.User;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Long> {
    Optional<User> findByTelegramId(Long telegramId);
}
