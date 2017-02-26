package net.pocketdreams.sequinland.net.translator.pocket;

import com.flowpowered.network.Message;

import net.glowstone.GlowServer;
import net.glowstone.net.message.handshake.HandshakeMessage;
import net.glowstone.net.message.login.LoginStartMessage;
import net.marfgamer.jraknet.RakNetPacket;
import net.pocketdreams.sequinland.net.PocketSession;
import net.pocketdreams.sequinland.net.protocol.packets.LoginPacket;
import net.pocketdreams.sequinland.net.translator.PEToPCTranslator;

public class PELoginPacketTranslator implements PEToPCTranslator<RakNetPacket> {
    @Override
    public Message[] translate(PocketSession session, RakNetPacket packet) {
        LoginPacket pePacket = (LoginPacket) packet;
        HandshakeMessage handshake = new HandshakeMessage(GlowServer.PROTOCOL_VERSION, pePacket.serverAddress, 25565, 2); // 2 = PLAY
        LoginStartMessage login = new LoginStartMessage(pePacket.username);
        return new Message[] { handshake, login };
    }
}