package org.eclipse.milo.examples.server.nodes;

import org.eclipse.milo.opcua.sdk.server.nodes.UaFolderNode;
import org.eclipse.milo.opcua.sdk.server.nodes.UaNodeContext;
import org.eclipse.milo.opcua.stack.core.types.builtin.LocalizedText;
import org.eclipse.milo.opcua.stack.core.types.builtin.NodeId;
import org.eclipse.milo.opcua.stack.core.types.builtin.QualifiedName;

public class Folder {
    public static UaFolderNode Create(UaNodeContext uaNodeContext,
                                      NodeId nodeId,
                                      QualifiedName qualifiedName,
                                      String name) {
        UaFolderNode uaFolderNode = new UaFolderNode(
                uaNodeContext,
                nodeId,
                qualifiedName,
                LocalizedText.english(name)
        );

        return uaFolderNode;
    }
}
