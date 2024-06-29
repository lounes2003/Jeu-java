package Representation;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/*
 * La classe Sound gère la lecture de fichiers audio.
 * Elle offre la possibilité de jouer de la musique à partir d'un fichier spécifié.
 */
public class Sound {

    /*
     * Lance la lecture de la musique à partir d'un chemin de fichier spécifique.
     * Le chemin actuel pointe vers un fichier WAV situé dans les téléchargements de l'utilisateur.
     *
     * @throws UnsupportedAudioFileException Si le format du fichier audio n'est pas supporté.
     * @throws IOException Si une erreur d'entrée/sortie se produit, notamment si le fichier n'est pas trouvé.
     * @throws LineUnavailableException Si les ressources audio nécessaires ne sont pas disponibles.
     */
    public void playmusic() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        Scanner scanner = new Scanner(System.in);
        File file = new File("C://Users//boudi/Downloads/one-piece-ost-overtaken-epic-version-drums-of-liberation_5l459AZK.wav");

        if (!file.exists()) {
            System.out.println("Fichier non trouvé : " + file.getAbsolutePath());
            return;
        }

        AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
        Clip clip = AudioSystem.getClip();
        clip.open(audioStream);

        System.out.println("Voulez-vous mettre le son ? (O/N)");
        String choix = scanner.next().toUpperCase();

        if (choix.equals("O")) {
            clip.start();
            System.out.println("Le son est en cours de lecture.");
        } else {
            System.out.println("Le son ne sera pas joué.");
        }
    }
}
