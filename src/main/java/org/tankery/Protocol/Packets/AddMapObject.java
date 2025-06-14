package org.tankery.Protocol.Packets;

import org.tankery.Protocol.Packet;
import org.tankery.Utils.ByteBuf;

public class AddMapObject extends Packet {
    private int id;
    private float[] pos;
    private float[] rot;

    public AddMapObject(int id, float[] pos, float[] rot) {
        this.id = id;
        this.pos = pos;
        this.rot = rot;
    }
    @Override
    public void write(ByteBuf buffer) {
        buffer.writeInt(id);
        buffer.writeFloat(pos[0]);
        buffer.writeFloat(pos[1]);
        buffer.writeFloat(pos[2]);
        buffer.writeFloat(rot[0]);
        buffer.writeFloat(rot[1]);
        buffer.writeFloat(rot[2]);
    }
}
