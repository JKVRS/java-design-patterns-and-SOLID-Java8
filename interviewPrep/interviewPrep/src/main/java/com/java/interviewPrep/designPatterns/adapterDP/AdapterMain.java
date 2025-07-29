package com.java.interviewPrep.designPatterns.adapterDP;


/*
   The Adapter Pattern allows incompatible interfaces to work together.
   It acts as a bridge between the existing system (client) and the external/legacy/third-party system (adaptee).

 */

// Client side
interface MusicPlayerClient{
    void playMp3(String file);
}
class ClientMusic implements MusicPlayerClient{

    @Override
    public void playMp3(String file) {
        System.out.println("MP3 songs can play only from client side !!! "+ file);
    }
}

// Adapter class that adapt Third Party to client side
class MusicAdapter implements MusicPlayerClient{

    private final MusicPlayerThirdParty musicPlayerThirdParty;

    MusicAdapter(MusicPlayerThirdParty musicPlayerThirdParty) {
        this.musicPlayerThirdParty = musicPlayerThirdParty;
    }

    @Override
    public void playMp3(String file) {
        System.out.println("Adapter converts MP3 to MP4 format...");
        musicPlayerThirdParty.playMusicMP4("My file will play in MP4 now using adapter !!! "+file);
    }
}


// ThirdParty (adaptee) want to adapt ThirdParty
interface MusicPlayerThirdParty{
    void playMusicMP4(String file);
}
class ThirdPartyMusic implements MusicPlayerThirdParty{

    @Override
    public void playMusicMP4(String file) {
        System.out.println("MP4 type of Music can play from ThirdParty !!! "+file);
    }
}


public class AdapterMain {

    public static void main(String[] args) throws InterruptedException {
        MusicPlayerClient client = new ClientMusic();
        client.playMp3("Kaho n payar h.mp3");
        System.out.println("I want to play this in MP4 can u do that ? Please wait....");
        Thread.sleep(2000);
        MusicAdapter adapter = new MusicAdapter(new ThirdPartyMusic());
        adapter.playMp3("Kaho n payar h.mp3");
    }

}
