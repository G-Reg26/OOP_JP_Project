/**
 * Gregorio Lozada Oct 27, 2018
 *
 * AudioPlayer: A class that extends product and implements the interface MultiMediaControl. Its
 * constructor takes in a string called name that is passed to Product's constructor, and a String
 * called audioSpecification that initializes the private field of the same name. AudioPlayer also
 * defines the methods in the MultimediaControl interface and overrides Object's toString method.
 *
 * Instructions to create this class were provided by Oracle Academy.
 */

public class AudioPlayer extends Product implements MultimediaControl {

  private String audioSpecification;
  private ItemType mediaType;

  /***
   * Takes in the string name and passes name to Audio Player's super class as well as take in the
   * string audioSpecification and sets the private field of the same name and set mediaType to
   * AUDIO.
   *
   * @param name name of the Audio Player object
   * @param audioSpecification audio specification of the Audio Player
   */
  AudioPlayer(String name, String audioSpecification) {
    super(name);
    this.audioSpecification = audioSpecification;

    mediaType = ItemType.AUDIO;
  }

  public void play() {
    System.out.println("Playing");
  }

  public void stop() {
    System.out.println("Stopping");
  }

  public void previous() {
    System.out.println("Previous");
  }

  public void next() {
    System.out.println("Next");
  }

  /**
   * Override toString to return the audio player's information such as audio specification, and
   * type.
   *
   * @return the information of the specific instance of this class
   */
  public String toString() {
    String audioPlayerInfo;

    audioPlayerInfo = super.toString() + "\n" +
        "Audio Spec : " + audioSpecification + "\n" +
        "Type : " + mediaType;

    return audioPlayerInfo;
  }
}
