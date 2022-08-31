package dtonic.io;

import com.github.hermannpencole.nifi.swagger.*;
import com.github.hermannpencole.nifi.swagger.auth.*;
import com.github.hermannpencole.nifi.swagger.client.AccessApi;
import com.github.hermannpencole.nifi.swagger.client.ProcessGroupsApi;
import com.github.hermannpencole.nifi.swagger.client.ProcessorsApi;
import com.github.hermannpencole.nifi.swagger.client.model.*;
import dtonic.io.NiFiClient.ConfigNiFi;
import dtonic.io.createprocessor.createProcessorGroup;
import dtonic.io.createprocessor.createprocessor;
import dtonic.io.getprocessor.getprocessor;
import java.io.File;
import java.util.*;

/**
 * Hello world!
 *
 */
public class App {

  public static void main(String[] args) {
    // NiFi Server Setting
    ConfigNiFi configNifi = new ConfigNiFi();
    configNifi.setNifi();
    createProcessorGroup pg = new createProcessorGroup();
    try {
      ProcessGroupEntity result = pg.createPipeline(
        "test1",
        "testComment",
        "f2fb02b1-0182-1000-73e8-f99257e66c8b",
        configNifi
      );
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println(e.getResponseBody());
      // e.printStackTrace();
    }
  }
}
