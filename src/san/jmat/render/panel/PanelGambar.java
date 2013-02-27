/*
 * |----------------JMat (Java Master)-------------------------------------|
 * |Setiap Manusia Yang Menata Hidupnya adalah Programmer                  |
 * |Hak Cipta Hanya Milik Allah SWT, Hamba-Nya Hanya Memanfaatkan.         |
 * |Manusia Tidak Bisa Mewujudkan Apa-apa, Manusia Hanya Bisa Merencanakan.| 
 * |----------------JMat (Java Master)-------------------------------------| 
 */
package san.jmat.render.panel;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import javax.swing.JFrame;
import javax.swing.JPanel;
import san.jmat.program.Program;

/**
 *
 * @author joker
 */
public class PanelGambar extends JPanel {
    //untuk menampung gambar asli sebelum diedit

    private Image gambarAsil;
    //untuk menampung gambar setelah diedit
    private Image gambarSementara;
    //untuk input gambar dari user
    private BufferedImage bufferedImage;
    private Graphics2D graphics2D;
    //mendeteksi apakah akan memasukkan foto
    private boolean deteksiFoto = false;
    //scala gambar widht and height
    private int scalaX = 0;
    private int scalaY = 0;
   

    public PanelGambar() {
        deteksiFoto = true;
        this.setVisible(true);
    }

   

    public void setBufferedImage(BufferedImage bufferedImage) {
        this.bufferedImage = bufferedImage;
        
        gambarAsil = this.bufferedImage;
        gambarSementara = this.bufferedImage;
        this.setSize(this.bufferedImage.getWidth(), this.bufferedImage.getHeight());
        
    }

    @Override
    protected void paintComponent(Graphics g) {
        
        //Perlu diketahui kita akan memperbesar atau memperkecil suatu gambar
        //bukan memperbesar atau memperkecil panel yang menampung gambar
        //tersebut.

        Graphics2D create = (Graphics2D) g.create();
        if (deteksiFoto) {
            bufferedImage = new BufferedImage(this.getWidth(), this.getHeight(), BufferedImage.TYPE_INT_RGB);
            graphics2D = bufferedImage.createGraphics();
            graphics2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                    RenderingHints.VALUE_ANTIALIAS_ON);
            graphics2D.drawImage(gambarSementara, 0, 0, gambarSementara.getWidth(this),
                    gambarSementara.getHeight(this), this);
            create.drawImage(bufferedImage, 0, 0, this);
        }
        

    }
    //Jadi bukan gambar yang mengikuti ukuran panel tapi sebaliknya.

    private void resize() {
        setSize(gambarSementara.getWidth(this),
                gambarSementara.getHeight(this));
        
    }

    private float ubahScala(int us) {
        return us / 100f;
    }

    public void zoomIn(int zoom) {
        scalaX = (int) (gambarSementara.getWidth(this) * ubahScala(zoom));
        scalaY = (int) (gambarSementara.getHeight(this) * ubahScala(zoom));
        gambarSementara = gambarSementara.getScaledInstance(
                (int) (gambarSementara.getWidth(this) + scalaX),
                (int) (gambarSementara.getHeight(this) + scalaY),
                Image.SCALE_AREA_AVERAGING);
        resize();
    }

    public void zoomOut(int zoom) {
        scalaX = (int) (gambarSementara.getWidth(this) * ubahScala(zoom));
        scalaY = (int) (gambarSementara.getHeight(this) * ubahScala(zoom));
        gambarSementara = gambarSementara.getScaledInstance(
                (int) (gambarSementara.getWidth(this) - scalaX),
                (int) (gambarSementara.getHeight(this) - scalaY),
                Image.SCALE_AREA_AVERAGING);
        resize();
    }

    public void reset() {
        gambarSementara = gambarAsil;
        resize();
    }
}
