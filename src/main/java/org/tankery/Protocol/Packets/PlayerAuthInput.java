package org.tankery.Protocol.Packets;

import org.tankery.ClientSession;
import org.tankery.Entity;
import org.tankery.Main;
import org.tankery.Protocol.Packet;
import org.tankery.Protocol.PacketsHelper;
import org.tankery.Utils.ByteBuf;

public class PlayerAuthInput extends Packet {
    private Entity entity;
    public PlayerAuthInput(Entity entity) {
        this.entity = entity;
    }
    @Override
    public void write(ByteBuf buffer) {
        buffer.writeString(entity.getUuid().toString());

        buffer.writeFloat(entity.getRotation()[0]);
        buffer.writeFloat(entity.getRotation()[1]);
        buffer.writeFloat(entity.getRotation()[2]);

        buffer.writeFloat(entity.getVelocity()[0]);
        buffer.writeFloat(entity.getVelocity()[1]);
        buffer.writeFloat(entity.getVelocity()[2]);
    }

    @Override
    public void read(ByteBuf buffer) {
        buffer.writeFloat(entity.getPosition()[0]);
        buffer.writeFloat(entity.getPosition()[1]);
        buffer.writeFloat(entity.getPosition()[2]);

        buffer.writeFloat(entity.getRotation()[0]);
        buffer.writeFloat(entity.getRotation()[1]);
        buffer.writeFloat(entity.getRotation()[2]);

        buffer.writeFloat(entity.getVelocity()[0]);
        buffer.writeFloat(entity.getVelocity()[1]);
        buffer.writeFloat(entity.getVelocity()[2]);
    }

    @Override
    public void process(ClientSession client) {
        client.getEntity().setRotation(this.entity.getRotation().clone());
        client.getEntity().setVelocity(this.entity.getVelocity().clone());
        client.getEntity().setPosition(this.entity.getPosition().clone());

        for (ClientSession cl : Main.sessions) {
            if (!cl.equals(client)) {
                PacketsHelper.send(cl, new PlayerAuthInput(this.entity));
            }
        }
    }
}
