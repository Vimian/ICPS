package org.eclipse.milo.examples.server.nodes;

import org.eclipse.milo.opcua.sdk.server.nodes.UaNodeContext;
import org.eclipse.milo.opcua.sdk.server.nodes.UaObjectNode;
import org.eclipse.milo.opcua.stack.core.types.builtin.LocalizedText;
import org.eclipse.milo.opcua.stack.core.types.builtin.NodeId;
import org.eclipse.milo.opcua.stack.core.types.builtin.QualifiedName;

public class Object {
    public static UaObjectNode Create(UaNodeContext uaNodeContext,
                               NodeId nodeId,
                               QualifiedName qualifiedName,
                               String name) {
        UaObjectNode uaObjectNode = new UaObjectNode.UaObjectNodeBuilder(uaNodeContext)
                .setNodeId(nodeId)
                .setBrowseName(qualifiedName)
                .setDisplayName(LocalizedText.english(name))
                .build();

        return uaObjectNode;
    }
}
