package ua.com.shami.serialnotification.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.com.shami.serialnotification.model.User;
import ua.com.shami.serialnotification.repository.UserRepository;

import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    private final Logger LOG = LogManager.getLogger(UserService.class);

    public User getUserOrCreateIfNotExist(Long telegramId, Long chatId) {
        Optional<User> userOptional = userRepository.findByTelegramId(telegramId);
        User user;
        if (userOptional.isPresent()) {
            user = userOptional.get();
        }
        else {
            user = new User();
            user.setTelegramId(telegramId);

            LOG.debug("Created new user telegramId={}, id={}", user.getTelegramId(), user.getId());
        }

        user.setTelegramChatId(chatId);

        return userRepository.save(user);
    }
}
