package de.scribble.lp.tasmod.savestates.motion;

import de.scribble.lp.tasmod.savestates.motion.ClientMotionServer.Saver;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class MotionPacketHandler implements IMessageHandler<MotionPacket, IMessage>{

	@Override
	public IMessage onMessage(MotionPacket message, MessageContext ctx) {
		if(ctx.side.isServer()) {
			ClientMotionServer.getMotion().put(ctx.getServerHandler().player, new Saver(message.getX(), message.getY(), message.getZ(), message.getRx(), message.getRy(), message.getRz()));
		}
		return null;
	}

}
