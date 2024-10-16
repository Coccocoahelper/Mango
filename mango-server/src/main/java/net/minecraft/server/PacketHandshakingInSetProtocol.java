package net.minecraft.server;

import java.io.IOException;

public class PacketHandshakingInSetProtocol implements Packet<PacketHandshakingInListener> {

    private int a;
    public String hostname;
    public int port;
    private EnumProtocol d;

    public PacketHandshakingInSetProtocol() {
    }

    @Override
    public void a(PacketDataSerializer serializer) throws IOException {
        this.a = serializer.readVarInt();
        this.hostname = serializer.c(Short.MAX_VALUE); // Spigot
        this.port = serializer.readUnsignedShort();
        this.d = EnumProtocol.a(serializer.readVarInt());
    }

    @Override
    public void b(PacketDataSerializer serializer) throws IOException {
        serializer.b(this.a);
        serializer.a(this.hostname);
        serializer.writeShort(this.port);
        serializer.b(this.d.a());
    }

    @Override
    public void a(PacketHandshakingInListener packethandshakinginlistener) {
        packethandshakinginlistener.a(this);
    }

    public EnumProtocol a() {
        return this.d;
    }

    public int b() {
        return this.a;
    }
}