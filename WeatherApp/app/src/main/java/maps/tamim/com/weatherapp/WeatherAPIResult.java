package maps.tamim.com.weatherapp;

import java.util.ArrayList;
import java.util.List;

//Main result for API call
public class WeatherAPIResult {



    private City city;
    private String cod;
    private Double message;
    private Integer cnt;
    private java.util.List<maps.tamim.com.weatherapp.List> list = new ArrayList<maps.tamim.com.weatherapp.List>();

    /**
     *
     * @return
     * The city
     */
    public City getCity() {
        return city;
    }

    /**
     *
     * @param city
     * The city
     */
    public void setCity(City city) {
        this.city = city;
    }

    /**
     *
     * @return
     * The cod
     */
    public String getCod() {
        return cod;
    }

    /**
     *
     * @param cod
     * The cod
     */
    public void setCod(String cod) {
        this.cod = cod;
    }

    /**
     *
     * @return
     * The message
     */
    public Double getMessage() {
        return message;
    }

    /**
     *
     * @param message
     * The message
     */
    public void setMessage(Double message) {
        this.message = message;
    }

    /**
     *
     * @return
     * The cnt
     */
    public Integer getCnt() {
        return cnt;
    }

    /**
     *
     * @param cnt
     * The cnt
     */
    public void setCnt(Integer cnt) {
        this.cnt = cnt;
    }

    /**
     *
     * @return
     * The list
     */
    public java.util.List<maps.tamim.com.weatherapp.List> getList() {
        return list;
    }

    /**
     *
     * @param list
     * The list
     */
    public void setList(java.util.List<maps.tamim.com.weatherapp.List> list) {
        this.list = list;
    }
}
