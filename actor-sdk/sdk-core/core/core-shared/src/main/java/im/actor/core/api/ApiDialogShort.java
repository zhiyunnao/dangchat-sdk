package im.actor.core.api;
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

public class ApiDialogShort extends BserObject {

    private ApiPeer peer;
    private int counter;
    private long date;

    public ApiDialogShort(@NotNull ApiPeer peer, int counter, long date) {
        this.peer = peer;
        this.counter = counter;
        this.date = date;
    }

    public ApiDialogShort() {

    }

    @NotNull
    public ApiPeer getPeer() {
        return this.peer;
    }

    public int getCounter() {
        return this.counter;
    }

    public long getDate() {
        return this.date;
    }

    @Override
    public void parse(BserValues values) throws IOException {
        this.peer = values.getObj(1, new ApiPeer());
        this.counter = values.getInt(2);
        this.date = values.getLong(4);
    }

    @Override
    public void serialize(BserWriter writer) throws IOException {
        if (this.peer == null) {
            throw new IOException();
        }
        writer.writeObject(1, this.peer);
        writer.writeInt(2, this.counter);
        writer.writeLong(4, this.date);
    }

    @Override
    public String toString() {
        String res = "struct DialogShort{";
        res += "peer=" + this.peer;
        res += ", counter=" + this.counter;
        res += ", date=" + this.date;
        res += "}";
        return res;
    }

}
