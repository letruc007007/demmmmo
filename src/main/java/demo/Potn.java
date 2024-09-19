/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package demo;

import javax.swing.*;
import java.awt.*;
import static java.nio.file.Files.size;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class Potn extends JDialog {
    private JList<String> lstFont, lstStyle, lstSize;
    private JButton btOK, btCancel;
    private int[] fontStyle = {Font.PLAIN, Font.ITALIC, Font.BOLD, Font.BOLD + Font.ITALIC};
    private JLabel lbPreView; // Thêm JLabel để hiển thị preview
    private Font font;

    private Jnotepad parent;

    public Potn(Frame owner, boolean modal) {
        super(owner, modal);
        setTitle("Font");
        parent = (Jnotepad) owner;
        createGUI();
        processEvent();
        setSize(400, 300);
        setLocationRelativeTo(owner); 
    }

    private void createGUI() {
        JPanel p = new JPanel();
        p.setLayout(null);

        lstFont = new JList<>();
        JScrollPane scrollPaneFont = new JScrollPane(lstFont);
        p.add(scrollPaneFont);
        scrollPaneFont.setBounds(5, 5, 150, 200);

        String[] fonts = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
        DefaultListModel<String> modelFont = new DefaultListModel<>();
        for (String f : fonts) {
            modelFont.addElement(f);
        }
        lstFont.setModel(modelFont);

        lstStyle = new JList(new Object[]{"Regular", "Italic", "Bold", "Bold Italic"});
        JScrollPane scrollPaneStyle = new JScrollPane(lstStyle);
        p.add(scrollPaneStyle);
        scrollPaneStyle.setBounds(160,5,  150, 80); 

        lstSize = new JList(new Object[]{"8", "9", "10", "12", "14", "16", "18", "20", "24", "28"});
        JScrollPane scrollPaneSize = new JScrollPane(lstSize);
        p.add(scrollPaneSize);
        scrollPaneSize.setBounds(315, 5, 50, 100);
       
        p.add(btOK = new JButton("OK"));
        p.add(btCancel = new JButton("Cancel"));

        btOK.setBounds(165, 210, 100, 40);
        btCancel.setBounds(275, 210, 100, 40);

        lbPreView = new JLabel("AaBbCcXxYyZz");
        lbPreView.setBounds(220, 80, 150, 120);
        p.add(lbPreView);

        add(p);
    }

    private void processEvent() {
        lstSize.addListSelectionListener(new ListSelectionListener(){
            @Override
            public void valueChanged(ListSelectionEvent e) {
                preViewFont();
            }
        });
        lstFont.addListSelectionListener(new ListSelectionListener(){
            @Override
            public void valueChanged(ListSelectionEvent e) {
                preViewFont();
            }
        });
        lstStyle.addListSelectionListener(new ListSelectionListener(){
            @Override
            public void valueChanged(ListSelectionEvent e) {
                preViewFont();
            }
        });
        
        btOK.addActionListener(e -> {
            if (font != null) {
                parent.txtEditor.setFont(font);
            }
            dispose(); // Đóng hộp thoại
        });

        btCancel.addActionListener(e -> dispose()); // Đóng hộp thoại khi nhấn Cancel
    }

    public static void main(String[] args){
        Potn dlg = new Potn(null, true);
        dlg.setLocationRelativeTo(null);
        dlg.setVisible(true);
    }

    private void preViewFont() {
        String fontName = lstFont.getSelectedValue();
            int Style = fontStyle[lstStyle.getSelectedIndex()];
            int Size = Integer.parseInt(lstSize.getSelectedValue().toString());
            lbPreView.setFont(font=new Font(fontName,Style,Size));
            lbPreView.setText("AaBbCcXxYyZz");
        
    }
}

