package org.tankery.Protocol;

import org.tankery.ClientSession;
import org.tankery.Utils.ByteBuf;

import java.nio.ByteBuffer;

public class Packet {
    public void read(ByteBuf buffer) {}
    public void write(ByteBuf buffer) {}
    public void process(ClientSession client) {}
}
