package pdm.pratica09;

public class City {
    private String name;
    private String weather;
    public City(String name) {
        this.name = name;
        this.weather = null;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setWeather(String weather) {
        this.weather = weather;
    }
    public String getName() {
        return this.name;
    }
    public String getWeather() {
        return this.weather;
    }
}
