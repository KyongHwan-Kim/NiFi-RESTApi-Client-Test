package dtonic.io.createprocessor;

import com.github.hermannpencole.nifi.swagger.ApiException;
import com.github.hermannpencole.nifi.swagger.client.ProcessGroupsApi;
import com.github.hermannpencole.nifi.swagger.client.model.PositionDTO;
import com.github.hermannpencole.nifi.swagger.client.model.ProcessGroupDTO;
import com.github.hermannpencole.nifi.swagger.client.model.ProcessGroupEntity;
import com.github.hermannpencole.nifi.swagger.client.model.RevisionDTO;
import dtonic.io.NiFiClient.ConfigNiFi;

public class createProcessorGroup {

  public ProcessGroupEntity createPipeline(
    String pipelineName,
    String pipelineDetail,
    String processorGroupId,
    ConfigNiFi nifiServer
  ) {
    ProcessGroupEntity body = new ProcessGroupEntity();
    ProcessGroupDTO processorGroupSetting = new ProcessGroupDTO();
    RevisionDTO processorGroupRevision = new RevisionDTO();
    PositionDTO processorGroupPosition = new PositionDTO();

    processorGroupSetting.setName(pipelineName);
    //TODO: Comment는 생성할때 넣을 수 없고, 만약에 쓰려면 Update를 해주어야함.ㅋ
    processorGroupSetting.setComments(pipelineDetail);
    processorGroupRevision.setVersion(0L);
    processorGroupRevision.setClientId(processorGroupId);
    //TODO: NiFi UI를 들어갈 일은 없겠지만, 한곳에만 계속 생성되면 조금 그렇다.
    processorGroupPosition.setX(0.1);
    processorGroupPosition.setY(0.1);

    body.setComponent(processorGroupSetting);
    body.setRevision(processorGroupRevision);
    ProcessGroupsApi apiInstace = new ProcessGroupsApi(
      nifiServer.getNifiServer()
    );
    ProcessGroupEntity result = apiInstace.createProcessGroup(
      processorGroupId,
      body
    );
    return result;
  }
}
