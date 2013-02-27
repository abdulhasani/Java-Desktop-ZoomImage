/*
 * |----------------JMat (Java Master)-------------------------------------|
 * |Setiap Manusia Yang Menata Hidupnya adalah Programmer                  |
 * |Hak Cipta Hanya Milik Allah SWT, Hamba-Nya Hanya Memanfaatkan.         |
 * |Manusia Tidak Bisa Mewujudkan Apa-apa, Manusia Hanya Bisa Merencanakan.| 
 * |----------------JMat (Java Master)-------------------------------------| 
 */
package san.jmat.render.combo;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import javax.swing.DefaultListCellRenderer;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JList;

/**
 *
 * @author joker
 */
public class ComboZoomOut extends DefaultListCellRenderer{
    private ImageIcon imageIcon;
    public ComboZoomOut() {
         imageIcon=new ImageIcon(getClass().getResource("/san/jmat/image/min.png"));
    }

    @Override
    public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
        JLabel label = (JLabel) super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
        if (isSelected) {
            label.setBackground(new Color(124, 89, 255, 255));
        } else {
            if(index%2==1){
                label.setBackground(Color.LIGHT_GRAY);
            }
            else{
                label.setBackground(Color.DARK_GRAY);
            }
        }
        label.setForeground(Color.green);
        label.setFont(label.getFont().deriveFont(Font.BOLD));
        label.setIcon(imageIcon);
        return label;
    }
    
}
