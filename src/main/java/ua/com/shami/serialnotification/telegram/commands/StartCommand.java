package ua.com.shami.serialnotification.telegram.commands;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.telegram.telegrambots.extensions.bots.commandbot.commands.BotCommand;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Chat;
import org.telegram.telegrambots.meta.api.objects.User;
import org.telegram.telegrambots.meta.bots.AbsSender;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import ua.com.shami.serialnotification.service.UserService;

public final class StartCommand extends BotCommand {

    private static final String LOGTAG = "STARTCOMMAND";

    private final Logger LOG = LogManager.getLogger(StartCommand.class);
    private UserService userService;

    public StartCommand(UserService userService) {
        super("start", "start using bot \n");
        this.userService = userService;
    }

    /**
     * implemented method of class BotCommand, in which the command entered by the user is processed
     *
     * @param absSender - sends a response to the user
     * @param user      - the user who executed the command
     * @param chat      - bot and user chat
     * @param strings   - arguments passed with the command
     */
    @Override
    public void execute(AbsSender absSender, User user, Chat chat, String[] strings) {
        userService.getUserOrCreateIfNotExist(Long.valueOf(user.getId()),
                chat.getId());

        StringBuilder messageText = new StringBuilder();
        SendMessage message = new SendMessage();
        message.setChatId(chat.getId().toString());
        messageText.append("Welcome to Serial Notification bot");
        message.setText(messageText.toString());

        try {
            absSender.execute(message);
        } catch (TelegramApiException e) {
            LOG.error(e);
        }
    }
}
