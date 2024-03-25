package org.example.bot;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

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

        try {
            // URL API, с которым вы хотите взаимодействовать
            URL url = new URL("https://api.kanye.rest");

            // Открытие соединения
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            // Установка метода запроса (GET, POST, PUT, DELETE и т. д.)
            connection.setRequestMethod("GET");

            // Чтение ответа
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuilder response = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }



            reader.close();
            String chadID = update.getMessage().getChatId().toString();
            String text = update.getMessage().getText();
            SendMessage sendMessage = new SendMessage();
            sendMessage.setChatId(chadID);
            sendMessage.setText(response.toString());
            // Вывод ответа
            try {
                this.execute(sendMessage);
            }catch (TelegramApiException e){    throw new RuntimeException(e);
            }

            // Закрытие соединения
            connection.disconnect();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
