package org.tankery.Protocol.Packets;

import org.tankery.Entity;
import org.tankery.Protocol.Packet;
import org.tankery.Utils.ByteBuf;

public class EntityAction extends Packet {
    private Entity entity;
    Action action;
    public enum Action {
        Add,
        Remove
    }
    public EntityAction(Action action, Entity entity) {
        this.action = action;
        this.entity = entity;
    }
    @Override
    public void write(ByteBuf buffer) {
        buffer.writeInt(action.ordinal());
        buffer.writeString(entity.getUuid().toString());
    }
}
