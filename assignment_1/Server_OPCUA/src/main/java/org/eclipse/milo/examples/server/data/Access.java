package org.eclipse.milo.examples.server.data;

import com.google.common.collect.ImmutableSet;
import org.eclipse.milo.opcua.sdk.core.AccessLevel;

public enum Access {
    R(AccessLevel.READ_ONLY),
    W(AccessLevel.WRITE_ONLY),
    RW(AccessLevel.READ_WRITE);

    public final ImmutableSet<AccessLevel> accessLevel;

    private Access(ImmutableSet<AccessLevel> accessLevel) {
        this.accessLevel = accessLevel;
    }
}
