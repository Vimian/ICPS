package org.eclipse.milo.examples.server.nodes;

import org.eclipse.milo.opcua.sdk.core.Reference;
import org.eclipse.milo.opcua.sdk.server.UaNodeManager;
import org.eclipse.milo.opcua.sdk.server.nodes.UaFolderNode;
import org.eclipse.milo.opcua.sdk.server.nodes.UaNodeContext;
import org.eclipse.milo.opcua.stack.core.Identifiers;
import org.eclipse.milo.opcua.stack.core.types.builtin.LocalizedText;
import org.eclipse.milo.opcua.stack.core.types.builtin.NodeId;
import org.eclipse.milo.opcua.stack.core.types.builtin.QualifiedName;

public class Folder {
    public static void Create(UaNodeContext context, NodeId nodeId, QualifiedName qualifiedName, String name, UaNodeManager uaNodeManager) {
        UaFolderNode folderNode = new UaFolderNode(
                context,
                nodeId,
                qualifiedName,
                LocalizedText.english(name)
        );

        uaNodeManager.addNode(folderNode);

        // Make sure our new folder shows up under the server's Objects folder.
        folderNode.addReference(new Reference(
                folderNode.getNodeId(),
                Identifiers.Organizes,
                Identifiers.ObjectsFolder.expanded(),
                false
        ));

        // Add the rest of the nodes
        //addVariableNodes(folderNode);
    }
}
