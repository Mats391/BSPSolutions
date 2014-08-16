package eu.blackspectrum.bspsolutions.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerChangedWorldEvent;
import org.bukkit.event.player.PlayerFishEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.player.PlayerUnleashEntityEvent;

import eu.blackspectrum.bspsolutions.OfflineFactions;
import eu.blackspectrum.bspsolutions.plugins.AbandonPet;
import eu.blackspectrum.bspsolutions.plugins.BetterLeashes;
import eu.blackspectrum.bspsolutions.plugins.DieSilent;
import eu.blackspectrum.bspsolutions.plugins.DropAll;
import eu.blackspectrum.bspsolutions.plugins.FalseAccessBlocker;
import eu.blackspectrum.bspsolutions.plugins.FishFix;
import eu.blackspectrum.bspsolutions.plugins.ForceOpen;
import eu.blackspectrum.bspsolutions.plugins.NoLoginTp;
import eu.blackspectrum.bspsolutions.plugins.SaferSafeZones;

public class PlayerListener implements Listener
{


	@EventHandler(priority = EventPriority.NORMAL)
	public void onPlayerChangedWorld( final PlayerChangedWorldEvent event ) {
		SaferSafeZones.onPlayerChangedWorld( event );
	}




	@EventHandler(priority = EventPriority.NORMAL)
	public void onPlayerDeath( final PlayerDeathEvent event ) {
		DieSilent.onPlayerDeath( event );
		DropAll.onPlayerDeath( event );
	}




	@EventHandler(priority = EventPriority.NORMAL)
	public void onPlayerInteract( final PlayerInteractEvent event ) {
		FalseAccessBlocker.onPlayerInteractBlockCancelled( event );
		SaferSafeZones.onPlayerUseItem( event );
		ForceOpen.onOpenChest( event );

	}




	@EventHandler(priority = EventPriority.NORMAL)
	public void onPlayerInteractEntity( final PlayerInteractEntityEvent event ) {
		AbandonPet.onPetHit( event );
	}




	@EventHandler(priority = EventPriority.NORMAL)
	public void onPlayerJoin( final PlayerJoinEvent event ) {
		NoLoginTp.onPlayerJoin( event );
		SaferSafeZones.onPlayerJoin( event );

		OfflineFactions.Instance().removeFaction( event.getPlayer() );
	}




	@EventHandler(priority = EventPriority.NORMAL)
	public void onPlayerMove( final PlayerMoveEvent event ) {
		SaferSafeZones.onPlayerChunkMove( event );
	}




	@EventHandler(priority = EventPriority.NORMAL)
	public void onPlayerQuit( final PlayerQuitEvent event ) {
		NoLoginTp.onPlayerLogout( event );

		OfflineFactions.Instance().addFaction( event.getPlayer() );
	}




	@EventHandler(priority = EventPriority.NORMAL)
	public void onPlayerUnleashEntity( final PlayerUnleashEntityEvent event ) {
		BetterLeashes.onUnleash( event );
	}
	
	@EventHandler(priority = EventPriority.LOWEST)
	public void onPlayerFish(PlayerFishEvent event)
	{
		FishFix.onPlayerCatchFish( event );
	}

}
