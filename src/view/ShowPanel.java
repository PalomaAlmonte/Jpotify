package view;

import model.Song;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * this class is a container which shows songs, albums, playlists and  etc in the middle part of the program
 */
public class ShowPanel extends JPanel {

    private Color background;
    private JButton[] songButtons;
    private JButton[] albumButtons;
    ArrayList<Song> songs = new ArrayList<>();
    HashMap<String,ArrayList<Song>> Albums;


    public ShowPanel() {

        super();
        background = new Color(33,33,33);
        this.setLayout(new FlowLayout());
        this.setBackground(background);

    }

    public void setSongs(ArrayList<Song> songs){

        this.songs = songs;
        songButtons = new JButton[songs.size()];

        for(int i = 0; i < songs.size() ; i++){

//            songButtons[i].addActionListener((ActionListener) this);
            songButtons[i] = new JButton();
            songButtons[i].setSize(100,50);


            ImageIcon imgIcon = new ImageIcon(songs.get(i).getArtwork());
            Image img = imgIcon.getImage().getScaledInstance(40,40,i);
            Icon icon = new ImageIcon(img);
            songButtons[i].setIcon(icon);


            songButtons[i].setText(songs.get(i).getTitle() + "\n" + songs.get(i).getArtistName() + "\n" + songs.get(i).getAlbumName());
            add(songButtons[i]);
            this.add(Box.createRigidArea(new Dimension(10, 10)));
        }
        setVisible(true);
    }

    public void setAlbums(HashMap<String,ArrayList<Song>> Albums){

        this.Albums = Albums;
        albumButtons = new JButton[Albums.size()];

        for(int i = 0; i < Albums.size() ; i++){

//            songButtons[i].addActionListener((ActionListener) this);
            albumButtons[i] = new JButton();
            albumButtons[i].setSize(100,50);


            ImageIcon imgIcon = new ImageIcon(Albums.get(i).get(0).getArtwork()); // problem here
            Image img = imgIcon.getImage().getScaledInstance(40,40,i);
            Icon icon = new ImageIcon(img);
            albumButtons[i].setIcon(icon);

            albumButtons[i].setText(Albums.keySet().toArray()[i].toString());

            add(albumButtons[i]);
            this.add(Box.createRigidArea(new Dimension(10, 10)));
        }
        this.setVisible(true);

    }
}