package ro.pub.cs.systems.eim.refacerecolocviuocw;

public class Information {

    private String temperature;
    private String windSpeed;
    private String generalState;
    private String pressure;
    private String humidity;
    private static final String urlStart = "https://www.countryflags.io/";
    private static final String urlEnd = "/flat/64.png";
    private String countryCode;

    public Information() {}

    public Information(String temperature, String windSpeed, String generalState, String pressure, String humidity, String countryCode) {
        this.temperature = temperature;
        this.windSpeed = windSpeed;
        this.generalState = generalState;
        this.pressure = pressure;
        this.humidity = humidity;
        this.countryCode = countryCode;
    }

    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    public String getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(String windSpeed) {
        this.windSpeed = windSpeed;
    }

    public String getGeneralState() {
        return generalState;
    }

    public void setGeneralState(String generalState) {
        this.generalState = generalState;
    }

    public String getPressure() {
        return pressure;
    }

    public void setPressure(String pressure) {
        this.pressure = pressure;
    }

    public String getHumidity() {
        return humidity;
    }

    public void setHumidity(String humidity) {
        this.humidity = humidity;
    }

    @Override
    public String toString() {
        return
                "Information : "
                + "Temperature : " + this.temperature + ", "
                + "Wind Speed : " + this.windSpeed + ", "
                + "General State : " + this.generalState + ", "
                + "Pressure : " + this.pressure + ", "
                + "Humidity : " + this.humidity + ", "
                + "URL , " + urlStart + this.countryCode + urlEnd;
    }
}
