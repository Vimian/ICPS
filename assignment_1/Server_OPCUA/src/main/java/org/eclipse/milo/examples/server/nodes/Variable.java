package org.eclipse.milo.examples.server.nodes;

import com.google.common.collect.ImmutableSet;
import org.eclipse.milo.examples.server.AttributeLoggingFilter;
import org.eclipse.milo.examples.server.data.Access;
import org.eclipse.milo.examples.server.data.Datapoint;
import org.eclipse.milo.examples.server.data.Types;
import org.eclipse.milo.opcua.sdk.core.AccessLevel;
import org.eclipse.milo.opcua.sdk.server.nodes.UaNodeContext;
import org.eclipse.milo.opcua.sdk.server.nodes.UaObjectNode;
import org.eclipse.milo.opcua.sdk.server.nodes.UaVariableNode;
import org.eclipse.milo.opcua.stack.core.AttributeId;
import org.eclipse.milo.opcua.stack.core.Identifiers;
import org.eclipse.milo.opcua.stack.core.types.builtin.*;

import java.math.BigDecimal;

public class Variable {
    public static UaVariableNode Create(Datapoint datapoint,
                                        UaNodeContext uaNodeContext,
                                        NodeId nodeId,
                                        QualifiedName qualifiedName,
                                        String name) {
        ImmutableSet<AccessLevel> accessLevel = Access.valueOf(datapoint.getAccess().toUpperCase()).accessLevel;

        UaVariableNode.UaVariableNodeBuilder uaVariableNodeBuilder = new UaVariableNode.UaVariableNodeBuilder(uaNodeContext)
                .setNodeId(nodeId)
                .setAccessLevel(accessLevel)
                .setUserAccessLevel(accessLevel)
                .setBrowseName(qualifiedName)
                .setDisplayName(LocalizedText.english(name))
                .setTypeDefinition(Identifiers.BaseDataVariableType);

        if (datapoint.getValue() != null) {
            uaVariableNodeBuilder
                    .setDataType(Types.valueOf(datapoint.getType().toUpperCase()).nodeId);
        }

        UaVariableNode uaVariableNode = uaVariableNodeBuilder.build();

        if (datapoint.getValue() != null) {
            Variant variant;
            if (datapoint.getValue().getClass().equals(BigDecimal.class)) {
                BigDecimal bigDecimal = (BigDecimal)(datapoint.getValue());
                variant = new Variant(bigDecimal.doubleValue());
            } else {
                variant = new Variant(datapoint.getValue());
            }
            uaVariableNode.setValue(new DataValue(variant));
        }

        uaVariableNode.getFilterChain().addLast(new AttributeLoggingFilter(AttributeId.Value::equals));

        return uaVariableNode;
    }
}
