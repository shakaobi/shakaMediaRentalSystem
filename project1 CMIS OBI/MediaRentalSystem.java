import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static javax.swing.JOptionPane.*;

public class MediaRentalSystem {
    public static final String WELCOME = "Welcome to Media Rental System";
    private Manager manager;

    private void go() {
        manager = new Manager();
        gui();
    }    

    private void gui() {
        JFrame frame = new JFrame(WELCOME);//Frame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("Menu");//new menu
        JMenuItem menuItem1 = new JMenuItem("Load Menu objects...");
        JMenuItem menuItem2 = new JMenuItem("Find Menu objects...");
        JMenuItem menuItem3 = new JMenuItem("Rent Menu objects...");
        JSeparator menuSep = new JSeparator();
        JMenuItem menuItem4 = new JMenuItem("Quit");
        menuItem1.addActionListener(e -> manager.loadData());
        menuItem2.addActionListener(e -> findGUI(frame));
        menuItem3.addActionListener(e -> rentGUI(frame));
        menuItem4.addActionListener(e -> exitGUI(frame));
        menu.add(menuItem1);
        menu.add(menuItem2);
        menu.add(menuItem3);
        menu.add(menuSep);
        menu.add(menuItem4);
        menuBar.add(menu);
        frame.setJMenuBar(menuBar);
        frame.setSize(600, 400);// sets size of the window
        frame.setVisible(true);// makes it visible
    }

    private void findGUI(JFrame frame) {
        List<Media> selectedMedia;

        do {
            String searchTitle = showInputDialog(frame, "Enter the title");//prompt title
            if (searchTitle == null || searchTitle.length() == 0)
                break;

            selectedMedia = manager.findItems(searchTitle);//checking for title
            if (selectedMedia.size() > 0) {
                String mediaMsg = "";
                for (Media m : selectedMedia)
                    mediaMsg += m + "\n";
                mediaMsg = mediaMsg.substring(0, mediaMsg.length() - 1);
                showMessageDialog(frame, mediaMsg);
                break;
            } else {//error message
                showMessageDialog(frame, String.format("There is no media with this title: %s", searchTitle), "Error", ERROR_MESSAGE);
            }
        } while (selectedMedia.isEmpty());
    }

    private void rentGUI(JFrame frame) {
        String searchId = showInputDialog(frame, "Enter the id");//prompts id
        if (searchId == null)
            return;
        int id;
        try {//checking for errors
            id = Integer.parseInt(searchId);
        } catch (NumberFormatException e) {
            showMessageDialog(frame, String.format("%s is not numeric.", searchId), "Error", ERROR_MESSAGE);
            return;
        }

        Media item = manager.rentItem(id);
        if(item != null){//message i rented or not available 
            showMessageDialog(frame, String.format("Media was successfully rented. Rental fee = $%.2f", item.calculateRentalFee()));
        }
        else{
            showMessageDialog(frame, String.format("%d was not found or is not available.", id), "Error", ERROR_MESSAGE);
        }
    }
     // exit event handle
    private void exitGUI(JFrame frame) {
        showMessageDialog(frame, "Good bye.", "exit", INFORMATION_MESSAGE);
        System.exit(0);
    }

    public static void main(String[] args) {
        new MediaRentalSystem().go();
    }

}