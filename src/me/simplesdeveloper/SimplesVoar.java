package me.simplesdeveloper;

import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class SimplesVoar extends JavaPlugin {

    @Override
    public void onEnable() {
        Bukkit.getConsoleSender().sendMessage("§a[SimplesVoar] Plugin Iniciado!");
    }

    @Override
    public void onDisable() {
        Bukkit.getConsoleSender().sendMessage("§c[SimplesVoar] Plugin desabilitado!");
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args)
    {
        Player player = (Player) sender;

        if ( command.getName().equalsIgnoreCase("voar") ) {

            if(player.hasPermission("simplesdeveloper.svoar"))
            {
                if(!player.getAllowFlight())
                {

                    player.sendMessage("§aAgora você pode voar!");
                    player.setAllowFlight(true);
                    player.setFlying(true);
                    player.getPlayer().getWorld().playSound(player.getPlayer().getLocation(), Sound.FIREWORK_LAUNCH , 1, 1);
                    player.setHealthScale(2);
                    player.setHealth(20);

                }else {

                    player.sendMessage("§cHabilidade de voar desabilitada");
                    player.setAllowFlight(false);
                    player.setFlying(false);
                    player.getPlayer().getWorld().playSound(player.getPlayer().getLocation(), Sound.FIREWORK_TWINKLE , 1, 1);
                    player.setHealthScale(20);
                    player.setHealth(20);

                }

            } else {

                player.sendMessage("§cSem permissao para voar");
                player.getPlayer().getWorld().playSound(player.getPlayer().getLocation(), Sound.VILLAGER_HIT , 1, 1);

            }


        }

        return true;

    }

}
