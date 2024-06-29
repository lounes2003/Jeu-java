package Representation;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
/* cette classe represente l'affichage des images depuis le terminal
En utilisant javax on a :
la méthode paintcomponent qui permet d'afficher le panel ainsi que l'endroit dans lequel la photo sera mise
La méthode Showimageinframe affiche l'image sur la fenetre
*/
public class ImageDisplay extends JPanel {
    private Image image;

    public ImageDisplay(String imagePath) {
        try {
            image = ImageIO.read(new File(imagePath));
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Erreur lors du chargement de l'image.");
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (image != null) {
            int x = (getWidth() - image.getWidth(this)) / 2;
            int y = (getHeight() - image.getHeight(this)) / 2;
            g.drawImage(image, x, y, this);
        }
    }

    // Méthode pour afficher l'image dans un JFrame
    public void showImageInFrame() {
        JFrame frame = new JFrame("Affichage d'image");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(700, 600);
        frame.add(this);
        frame.setVisible(true);
    }
}
