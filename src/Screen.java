/**
 * Gregorio Lozada Oct 27, 2018
 *
 * Screen: A class that extends implements the interface ScreenSpec. Its constructor takes in a
 * string called resolution, and two ints called refreshRate and responseTime that are used to
 * initialize its private fields. Screen also defines the methods in the ScreenSpec interface and
 * overrides Object's toString method.
 *
 * Instructions to create this class were provided by Oracle Academy.
 */

public class Screen implements ScreenSpec {

  String resolution;
  int refreshRate;
  int responseTime;

  /***
   * Takes in the string parameter resolution and the two ints refreshRate and responseTime,
   * and sets the private fields of the same name with their values
   *
   * @param resolution screen resolution
   * @param refreshRate screen refresh rate
   * @param responseTime screen response time
   */
  public Screen(String resolution, int refreshRate, int responseTime) {
    this.resolution = resolution;
    this.refreshRate = refreshRate;
    this.responseTime = responseTime;
  }

  public String getResolution() {
    return resolution;
  }

  public int getRefreshRate() {
    return refreshRate;
  }

  public int getResponseTime() {
    return responseTime;
  }

  /**
   * Override toString to return the screen's information such as resolution, refresh rate, and
   * response time.
   *
   * @return the information of the specific instance of this class
   */
  public String toString() {
    String screenInfo;

    screenInfo = "Resolution : " + resolution + "\n" +
        "Refresh rate : " + refreshRate + "\n" +
        "Response time : " + responseTime;

    return screenInfo;
  }
}
