package dtonic.io.getprocessor;

import com.github.hermannpencole.nifi.swagger.*;
import com.github.hermannpencole.nifi.swagger.client.ProcessGroupsApi;
import com.github.hermannpencole.nifi.swagger.client.model.*;

public class getprocessor {

  private ProcessorsEntity result;

  public ProcessorsEntity getProcessorInfo(
    ProcessGroupsApi apiInstance,
    String id,
    Boolean includeBoolean
  ) {
    try {
      ProcessorsEntity result = apiInstance.getProcessors(id, includeBoolean);
      this.result = result;
    } catch (ApiException e) {
      System.err.println(
        "Exception when calling ProcessGroupsApi#getProcessors"
      );
    }
    return this.result;
  }
}
