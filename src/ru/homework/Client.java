package ru.homework;

import javax.swing.*;
import java.awt.*;

public class Client extends JFrame {
      private JLabel jLabel;
      private JButton jButton;
      private JPanel jPanel;
    private JPanel jPanelTexting;
      private JTextField jTextField;
      private JTextArea jTextArea;

    public static void main(String[] args) {
        SwingUtilities.invokeLater( () -> new Client().createFrame());
    }

    public  void createFrame(){
        setTitle("Chat for our geek gang");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(0,0,400,300);

        //// кнопка отправки сообщения
        jButton = new JButton("Send");
        jButton.addActionListener(e -> sendMsg());

        ///// текстовая область с прокруткой
        jTextArea = new JTextArea(10,20);
        jTextArea.setLineWrap(true);
        jTextArea.setEnabled(false);
        Font font = new Font("Arial", Font.BOLD, 18);
        jTextArea.setFont(font);
        JScrollPane jsp = new JScrollPane(jTextArea);


        jLabel = new JLabel("Texting...");/// в задание нет просто ориентир для пользователя
        ///// поле для написания сообщения и Listener кнопке Enter
        jTextField = new JTextField(30);
        jTextField.addActionListener(e -> sendMsg());

         /////////// отдельная внутрення панель для окна набора текста, кнопки и лейбла
         jPanelTexting = new JPanel(new BorderLayout());
        jPanelTexting.add(jLabel, BorderLayout.WEST);
        jPanelTexting.add(jTextField, BorderLayout.CENTER);
        jPanelTexting.add(jButton,  BorderLayout.EAST);
        ///// собираем в эту панель все объекты
        jPanel = new JPanel(new BorderLayout());
        jPanel.add(jsp, BorderLayout.CENTER);
        jPanel.add(jPanelTexting,BorderLayout.SOUTH);
        add(jPanel);


        setAlwaysOnTop(true);/// устанавливаем что бы окно было всегда поверх других. Для переписка так удобнее
        setVisible(true);
    }

    //// метод для отправки сообщения
    public void sendMsg(){
       jTextArea.append(jTextField.getText() + "\n");
       jTextField.setText("");
        jTextField.grabFocus();
    }
}
