/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package demo;

/**
 *
 * @author ADMIN
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

public class Jnotepad extends JFrame {

    private JMenuBar mBar;
    private JMenu mFile, mEdit, mFormat, mView, mHelp,mZoom;
    private JMenuItem itemNew, itemOpen, itemSave, itemSaveAs, itemPageSetup, itemPrint, itemExit;
    private JMenuItem itemUndo, itemCut, itemCopy, itemPaste, itemDelete, itemSearch, itemFind, itemReplace, itemGoto, itemSelect, itemTime;
    private JMenuItem itemFont, itemView,itemZoomOn,itemZoomIn, itemSend, itemAbout;
    private JCheckBoxMenuItem itemWord, itemBar;

    private JTextArea txtEditor;

    public Jnotepad(String title) {
        super(title);
        createMenu();
        txtEditor = new JTextArea();
        JScrollPane scrollEditor = new JScrollPane(txtEditor);
        add(scrollEditor);
        txtEditor.setFont(new Font("Arial", Font.PLAIN, 20));
        setSize(700, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Đặt vị trí cửa sổ giữa màn hình
    }

    private void createMenu() {
        
        mBar = new JMenuBar();

        mFile = new JMenu("File");
        mEdit = new JMenu("Edit");
        mFormat = new JMenu("Format");
        mView = new JMenu("View");
        mHelp = new JMenu("Help");

        mBar.add(mFile);
        mBar.add(mEdit);
        mBar.add(mFormat);
        mBar.add(mView);
        mBar.add(mHelp);
        
        itemNew = new JMenuItem("New");
        itemOpen = new JMenuItem("Open...");
        itemSave = new JMenuItem("Save");
        itemSaveAs = new JMenuItem("Save As...");
        itemPageSetup = new JMenuItem("Page Setup...");
        itemPrint = new JMenuItem("Print...");
        itemExit = new JMenuItem("Exit");

        mFile.add(itemNew);
        mFile.add(itemOpen);
        mFile.add(itemSave);
        mFile.add(itemSaveAs);
        mFile.addSeparator(); 
        mFile.add(itemPageSetup);
        mFile.add(itemPrint);
        mFile.addSeparator();
        mFile.add(itemExit);

        itemUndo = new JMenuItem("Undo");
        itemCut = new JMenuItem("Cut");
        itemCopy = new JMenuItem("Copy");
        itemPaste = new JMenuItem("Paste");
        itemDelete = new JMenuItem("Delete");
        itemSearch = new JMenuItem("Search");
        itemFind = new JMenuItem("Find");
        itemReplace = new JMenuItem("Replace");
        itemGoto = new JMenuItem("Goto");
        itemSelect = new JMenuItem("Select");
        itemTime = new JMenuItem("Time");

        mEdit.add(itemUndo);
        mEdit.add(itemCut);
        mEdit.add(itemCopy);
        mEdit.add(itemPaste);
        mEdit.add(itemDelete);
        mEdit.addSeparator();
        mEdit.add(itemSearch);
        mEdit.add(itemFind);
        mEdit.add(itemReplace);
        mEdit.add(itemGoto);
        mEdit.add(itemSelect);
        mEdit.add(itemTime);

        itemFont = new JMenuItem("Font");
        itemWord = new JCheckBoxMenuItem("Word Wrap");

        mFormat.add(itemFont);
        mFormat.add(itemWord);

        mZoom = new JMenu("Zoom");
        mZoom.add(itemZoomIn=new JMenuItem("Zoom In"));
        mZoom.add(itemZoomOn=new JMenuItem("Zoom On"));
        itemBar = new JCheckBoxMenuItem("Status Bar");

        mView.add(mZoom);
        mView.add(itemBar);

        itemAbout = new JMenuItem("About");

        mHelp.add(itemAbout);

        
        setJMenuBar(mBar);

        itemNew.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, KeyEvent.CTRL_DOWN_MASK));
        itemOpen.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, KeyEvent.CTRL_DOWN_MASK));
        itemSave.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, KeyEvent.CTRL_DOWN_MASK));
        itemSaveAs.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, KeyEvent.CTRL_DOWN_MASK + KeyEvent.SHIFT_DOWN_MASK));
        itemExit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, KeyEvent.CTRL_DOWN_MASK));

        itemExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        
        itemAbout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(Jnotepad.this, "", "", JOptionPane.INFORMATION_MESSAGE);
            }
        });
    }

    public static void main(String[] args) {
        Jnotepad notepad = new Jnotepad("Demo Notepad");
        notepad.setVisible(true);
    }
}