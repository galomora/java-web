package ec.casabaca.roster.web.teams.flow;

import java.io.Serializable;

import javax.enterprise.inject.Produces;
import javax.faces.flow.Flow;
import javax.faces.flow.builder.FlowBuilder;
import javax.faces.flow.builder.FlowBuilderParameter;
import javax.faces.flow.builder.FlowDefinition;

public class TeamsFlow implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Produces
	@FlowDefinition
	public Flow defineFlow (@FlowBuilderParameter FlowBuilder flowBuilder) {
		String flowId = "teamsFlow";
		flowBuilder.id("", flowId);
        flowBuilder.viewNode(flowId, "/teamsFlow/teamsFlow.xhtml").markAsStartNode();
        flowBuilder.returnNode("returnFromTeamsFlow").
                fromOutcome("#{teamsFlowBean.returnFromFlow}");
        return flowBuilder.getFlow();
	}
}
