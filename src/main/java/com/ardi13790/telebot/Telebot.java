/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ardi13790.telebot;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Message;

public class Telebot extends TelegramLongPollingBot {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/telebot";
    private static final String DB_USERNAME = "root";
    private static final String DB_PASSWORD = "";

    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage()&& update.getMessage().hasText()) {
            long chatId = update.getMessage().getChatId();
            String messageText = update.getMessage().getText();
            String firstname = update.getMessage().getFrom().getFirstName();
            Date date = new Date();

            if(!isUserRegistered(chatId)){
                if (messageText.equalsIgnoreCase("/join")) {
                    // Add member to the database
                    saveMember(chatId, firstname);
                    saveMessage(chatId, messageText, firstname, date);
                    sendReply(chatId, "Anda berhasil bergabung!");
                }else{
                    sendReply(chatId, "Selamat datang! Silahkan bergabung terlebih dahulu.");
                }
            }else{
                if(messageText.equalsIgnoreCase("/start")){
                    sendReply(chatId, "Selamat datang! Anda sudah bergabung.");
                }else if(messageText.equalsIgnoreCase("/join")){
                    sendReply(chatId, "Anda tidak perlu bergabung, Anda sudah bergabung.");
                }else if(messageText.equalsIgnoreCase("/commandfromdb")){
                    String message = getCommandListFromDatabase();
                    sendReply(chatId, message);
                }else if(messageText.equalsIgnoreCase("/info")){
                    sendReply(chatId, "Chat ID anda adalah "+chatId+"\nFirstname anda adalah "+firstname);
                }else if(messageText.equalsIgnoreCase("/leave")){
                    deleteMember(chatId);
                    sendReply(chatId, "Anda berhasil keluar!");
                }else{
                    String replyMessage = getReplyMessage(messageText);
                    if (replyMessage != null) {
                        SendMessage message = new SendMessage();
                        message.setChatId(chatId);
                        message.setText(replyMessage);
                        try {
                            execute(message);
                        } catch (TelegramApiException e) {
                            e.printStackTrace();
                        }
                    }else{
                        sendReply(chatId, "Bot tidak paham command tersebut!");
                    }
                }
                saveMessage(chatId, messageText, firstname, date);
            }
        }
    }
    
            
    public void sendBroadcast(String message) {
        try (
            Connection conn = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD)) {
            
            String query = "SELECT chat_id FROM members";
            
            PreparedStatement statement = conn.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                String chatId = resultSet.getString("chat_id");

                SendMessage sendMessage = new SendMessage();
                sendMessage.setChatId(chatId);
                sendMessage.setText(message);

                try {
                    execute(sendMessage);
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Broadcast Gagal");
        } finally{
            JOptionPane.showMessageDialog(null, "Broadcast Berhasil");
        }
    }

    private String getCommandListFromDatabase() {
        StringBuilder commands = new StringBuilder();

        try {
            Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
            String query = "SELECT * FROM keyword";
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery(query);

            
            
            while (resultSet.next()) {
                String command = resultSet.getString("command");
                String keterangan = resultSet.getString("keterangan");
                commands.append(command).append(" - ");
                commands.append(keterangan).append("\n");
            }

            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
           e.printStackTrace();
        }

        if (commands.length() == 0) {
            return "No commands found.";
        } else {
            return commands.toString();
        }
    }
    
    
     private String getReplyMessage(String command) {
        try(Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD)) {
            String query = "SELECT reply FROM keyword WHERE command = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, command);

            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return resultSet.getString("reply");
            }

            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
    
    private boolean isUserRegistered(long chatId) {
        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD)) {
            String query = "SELECT * FROM members WHERE chat_id = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setLong(1, chatId);
            ResultSet resultSet = statement.executeQuery();
            return resultSet.next();
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    private void sendReply(long chatId, String message) {
        SendMessage reply = new SendMessage();
        reply.setChatId(String.valueOf(chatId));
        reply.setText(message);
        try {
            execute(reply);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    private void saveMember(long chatId, String firstname) {
        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD)) {
            String query = "INSERT INTO members (chat_id, firstname) VALUES (?, ?)";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setLong(1, chatId);
            statement.setString(2, firstname);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    private void saveMessage(long chatId, String message, String firstname, Date date) {
        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD)) {
            String query = "INSERT INTO message (chat_id, message, firstname, date) VALUES (?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setLong(1, chatId);
            statement.setString(2, message);
            statement.setString(3, firstname);
            statement.setTimestamp(4, new Timestamp(date.getTime()));
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    private void deleteMember(long chatId){
        try(Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD)){
            String query = "DELETE FROM members WHERE chat_id = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setLong(1, chatId);
            statement.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public String getBotToken() {
        return "";
    }

    @Override
    public String getBotUsername() {
        return "ardi13790_bot";
    }
}
