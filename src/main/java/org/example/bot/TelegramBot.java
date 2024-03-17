package org.example.bot;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class TelegramBot extends TelegramLongPollingBot {
    @java.lang.Override
    public java.lang.String getBotUsername() {
        return "newOAIP_bot";
    }

    @java.lang.Override
    public java.lang.String getBotToken() {
        return "7141978787:AAGAZK5XnJW8VmAKUyKjm51dLLOd5PfUH3k";
    }

    @java.lang.Override
    public void onUpdateReceived(Update update) {
        String chadID = update.getMessage().getChatId().toString();
        String text = update.getMessage().getText();
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chadID);
        sendMessage.setText(text);
        try {
            this.execute(sendMessage);
        }catch (TelegramApiException e){
            throw new RuntimeException(e);
        }
    }
}
