package org.eclipse.milo.examples.server.data;

import org.eclipse.milo.opcua.stack.core.Identifiers;
import org.eclipse.milo.opcua.stack.core.types.builtin.NodeId;

public enum Types {
    STRING(Identifiers.String),
    BOOLEAN(Identifiers.Boolean),
    INTEGER(Identifiers.UInteger),
    SIGNED_INTEGER(Identifiers.Integer),
    DOUBLE(Identifiers.Double);

    public final NodeId nodeId;

    private Types(NodeId nodeId) {
        this.nodeId = nodeId;
    }
}
