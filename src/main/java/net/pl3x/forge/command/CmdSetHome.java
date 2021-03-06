package net.pl3x.forge.command;

import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.server.MinecraftServer;
import net.minecraft.world.World;
import net.pl3x.forge.Location;
import net.pl3x.forge.configuration.Lang;
import net.pl3x.forge.data.PlayerData;

public class CmdSetHome extends CommandBase {
    public CmdSetHome() {
        super("sethome", "Sets a home");
    }

    @Override
    public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException {
        World world = sender.getEntityWorld();
        if (world.isRemote) {
            return; // do not process client side
        }

        EntityPlayerMP player = getCommandSenderAsPlayer(sender);
        PlayerData playerData = getPlayerData(player);

        if (playerData.getHomes().size() >= 5) {
            Lang.send(player, Lang.INSTANCE.data.HOME_LIMIT_REACHED);
            return;
        }

        String homeName = args.length > 0 ? args[0].toLowerCase() : "home";
        if (playerData.getHome(homeName) != null) {
            Lang.send(player, Lang.INSTANCE.data.HOME_ALREADY_SET);
            return;
        }

        playerData.addHome(homeName, new Location(player));
        Lang.send(player, Lang.INSTANCE.data.HOME_CREATED);
    }
}
