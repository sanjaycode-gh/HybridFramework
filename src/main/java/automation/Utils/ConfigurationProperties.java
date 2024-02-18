package automation.Utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("config.properties")
public class ConfigurationProperties {

    @Value("${browserName}")
    private String browserName;

    @Value("${url}")
    private String url;

    @Value("${swaglabsLogo}")
    private String swaglabsLogo;

    @Value("${orderMessage}")
    private String orderMessage;

    @Value("${firstName}")
    private String firstName;

    @Value("${lastName}")
    private String lastName;

    @Value("${zip}")
    private String zip;



    public String getBrowserName(){
        return browserName;
    }

    public void setBrowserName(String browserName){
        this.browserName = browserName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getSwaglabsLogo() {
        return swaglabsLogo;
    }

    public void setSwaglabsLogo(String swaglabsLogo) {
        this.swaglabsLogo = swaglabsLogo;
    }

    public String getOrderMessage() {
        return orderMessage;
    }

    public void setOrderMessage(String orderMessage) {
        this.orderMessage = orderMessage;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }
}
