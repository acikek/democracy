package net.diamonddev.democracy.client;

import net.diamonddev.democracy.exception.GoofyAhhCrashException;
import net.diamonddev.democracy.network.CrashGamePacket;
import net.diamonddev.democracy.network.Netcode;
import net.diamonddev.democracy.network.OpenLinkPacket;
import net.minecraft.CrashReport;
import org.quiltmc.loader.api.ModContainer;
import org.quiltmc.qsl.base.api.entrypoint.client.ClientModInitializer;
import org.quiltmc.qsl.networking.api.client.ClientPlayNetworking;

import java.awt.*;
import java.net.URL;

public class DemocracyClient implements ClientModInitializer {
    @Override
    public void onInitializeClient(ModContainer mod) {
        ClientPlayNetworking.registerGlobalReceiver(Netcode.CRASH_PACKET_CHANNEL, ((client, handler, buf, responseSender) -> {
            CrashGamePacket.CrashGamePacketData data = CrashGamePacket.read(buf);
            client.delayCrash(new CrashReport(data.string, new GoofyAhhCrashException()));
        }));

        ClientPlayNetworking.registerGlobalReceiver(Netcode.SEND_LINK_CHANNEL, ((client, handler, buf, responseSender) -> {
            OpenLinkPacket.OpenLinkPacketData data = OpenLinkPacket.read(buf);
            openWebpage(data.link);
        }));
    }

    public static void openWebpage(String urlString) {
        try {
            Desktop.getDesktop().browse(new URL(urlString).toURI());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
