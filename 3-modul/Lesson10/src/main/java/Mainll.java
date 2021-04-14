import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.ArrayList;
import java.util.List;

public class Mainll extends TelegramLongPollingBot { 
    public static void main(String[] args) {
        ApiContextInitializer.init();
        TelegramBotsApi api = new TelegramBotsApi();
        try {
            api.registerBot(new Mainll());
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
        SendMessage sendMessage = new SendMessage();
        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        sendMessage.setReplyMarkup(replyKeyboardMarkup);
        replyKeyboardMarkup.setSelective(true);
        replyKeyboardMarkup.setResizeKeyboard(true);
        replyKeyboardMarkup.setOneTimeKeyboard(false);
        // Klaviatura qatorlari listi
        List<KeyboardRow> keyboard = new ArrayList<>();
        // Klaviatura birinchi qatori
        KeyboardRow keyboardFirstRow = new KeyboardRow();
// Birinchi qatorga tugma qo'shish
        keyboardFirstRow.add(new

                KeyboardButton("Salom"));
        // Klaviatura ikkinchi qatori
        KeyboardRow keyboardSecondRow = new KeyboardRow();
// Ikkinchi qatorga tugma qo'shish
        keyboardSecondRow.add(new
                KeyboardButton("Yordam"));
// Barcha qatorlarni qatorlar listiga qo'shish
        keyboard.add(keyboardFirstRow);
        keyboard.add(keyboardSecondRow);
// qatorlar listini klaviatura sifatida o'rnatish
        replyKeyboardMarkup.setKeyboard(keyboard);

    }

    @Override
    public String getBotToken() {
        return "1734985167:AAF15FLQ045BjRTHDa8JBH9ArGumSac1bv0";
    }

    @Override
    public void onUpdateReceived(Update update) {
        String inputText = update.getMessage().getText();
        SendMessage sendMessage = new SendMessage();
        if (inputText.equals("/start")) {
            sendMessage.setText("Assalomu Alaykum Va Raxmatulloh");
            sendMessage.setChatId(update.getMessage().getChatId());
        }
    }

    @Override
    public String getBotUsername() {
        return "Khusinovbot";
    }

}
