package dtonic.io.NiFiClient;

import com.github.hermannpencole.nifi.swagger.*;
import com.github.hermannpencole.nifi.swagger.auth.*;
import com.github.hermannpencole.nifi.swagger.client.AccessApi;
import com.github.hermannpencole.nifi.swagger.client.ProcessGroupsApi;
import com.github.hermannpencole.nifi.swagger.client.ProcessorsApi;
import com.github.hermannpencole.nifi.swagger.client.model.*;

public class ConfigNiFi {

  private String username = "admin";
  private String password = "ctsBtRBKHRAx69EqUghvvgEvjnaLjFEB";
  private ApiClient nifiServer = new ApiClient();
  private AccessApi apiInstance = new AccessApi();

  public void setNifi() {
    this.nifiServer.setBasePath("https://110.45.181.70:8443/nifi-api");
    this.nifiServer.setVerifyingSsl(false);
    this.apiInstance.setApiClient(this.nifiServer);
  }

  public String tokenSetting() {
    OAuth auth = (OAuth) this.nifiServer.getAuthentication("auth");
    String token =
      this.apiInstance.createAccessToken(this.username, this.password);
    auth.setAccessToken(token);
    return token;
  }

  public ApiClient getNifiServer() {
    return this.nifiServer;
  }

  public AccessApi getApiInstance() {
    return this.apiInstance;
  }
}
