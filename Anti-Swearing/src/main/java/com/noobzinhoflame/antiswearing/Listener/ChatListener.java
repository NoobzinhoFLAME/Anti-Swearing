package com.noobzinhoflame.antiswearing.Listener;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import java.util.List;

public class ChatListener implements Listener {

    public List<String> PalavrasOfensivas;

    public ChatListener(List<String> palavrasOfensivas) {
        this.PalavrasOfensivas = palavrasOfensivas;
    }

    @EventHandler
    public void onPlayerChat(AsyncPlayerChatEvent event) {
        String message = event.getMessage();

        for (String word : message.split(" ")) {
            if (PalavrasOfensivas.contains(word.toLowerCase())) {
                event.getPlayer().sendMessage("§4§lAVISO §cVocê utilizou uma palavra bloqueada no chat!");
                message = message.replace(word, censorWord(word));
            }
        }
        event.setMessage(message);
    }

    private String censorWord(String word) {
        StringBuilder censored = new StringBuilder();
        for (int i = 0; i < word.length(); i++) {
            censored.append("*");
        }
        return censored.toString();
    }
}
