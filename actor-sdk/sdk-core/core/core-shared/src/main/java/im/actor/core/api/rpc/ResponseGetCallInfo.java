package im.actor.core.api.rpc;
/*
 *  Generated by the Actor API Scheme generator.  DO NOT EDIT!
 */

import im.actor.runtime.bser.*;
import im.actor.runtime.collections.*;
import static im.actor.runtime.bser.Utils.*;
import im.actor.core.network.parser.*;
import org.jetbrains.annotations.Nullable;
import org.jetbrains.annotations.NotNull;
import com.google.j2objc.annotations.ObjectiveCName;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;
import im.actor.core.api.*;

public class ResponseGetCallInfo extends Response {

    public static final int HEADER = 0xa2e;
    public static ResponseGetCallInfo fromBytes(byte[] data) throws IOException {
        return Bser.parse(new ResponseGetCallInfo(), data);
    }

    private ApiPeer peer;
    private List<ApiGroupOutPeer> groups;
    private List<ApiUserOutPeer> users;
    private String eventBusId;

    public ResponseGetCallInfo(@NotNull ApiPeer peer, @NotNull List<ApiGroupOutPeer> groups, @NotNull List<ApiUserOutPeer> users, @NotNull String eventBusId) {
        this.peer = peer;
        this.groups = groups;
        this.users = users;
        this.eventBusId = eventBusId;
    }

    public ResponseGetCallInfo() {

    }

    @NotNull
    public ApiPeer getPeer() {
        return this.peer;
    }

    @NotNull
    public List<ApiGroupOutPeer> getGroups() {
        return this.groups;
    }

    @NotNull
    public List<ApiUserOutPeer> getUsers() {
        return this.users;
    }

    @NotNull
    public String getEventBusId() {
        return this.eventBusId;
    }

    @Override
    public void parse(BserValues values) throws IOException {
        this.peer = values.getObj(1, new ApiPeer());
        List<ApiGroupOutPeer> _groups = new ArrayList<ApiGroupOutPeer>();
        for (int i = 0; i < values.getRepeatedCount(2); i ++) {
            _groups.add(new ApiGroupOutPeer());
        }
        this.groups = values.getRepeatedObj(2, _groups);
        List<ApiUserOutPeer> _users = new ArrayList<ApiUserOutPeer>();
        for (int i = 0; i < values.getRepeatedCount(3); i ++) {
            _users.add(new ApiUserOutPeer());
        }
        this.users = values.getRepeatedObj(3, _users);
        this.eventBusId = values.getString(4);
    }

    @Override
    public void serialize(BserWriter writer) throws IOException {
        if (this.peer == null) {
            throw new IOException();
        }
        writer.writeObject(1, this.peer);
        writer.writeRepeatedObj(2, this.groups);
        writer.writeRepeatedObj(3, this.users);
        if (this.eventBusId == null) {
            throw new IOException();
        }
        writer.writeString(4, this.eventBusId);
    }

    @Override
    public String toString() {
        String res = "tuple GetCallInfo{";
        res += "}";
        return res;
    }

    @Override
    public int getHeaderKey() {
        return HEADER;
    }
}
