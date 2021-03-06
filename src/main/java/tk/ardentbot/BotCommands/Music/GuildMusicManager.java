package tk.ardentbot.BotCommands.Music;

import com.sedmelluq.discord.lavaplayer.player.AudioPlayer;
import com.sedmelluq.discord.lavaplayer.player.AudioPlayerManager;
import net.dv8tion.jda.core.entities.MessageChannel;

public class GuildMusicManager {
    /**
     * Track scheduler for the player.
     */
    public final TrackScheduler scheduler;
    /**
     * Audio player for the guild.
     */
    final AudioPlayer player;

    /**
     * Creates a player and a track scheduler.
     *
     * @param manager Audio player manager to use for creating the player.
     */
    public GuildMusicManager(AudioPlayerManager manager, MessageChannel channel) {
        player = manager.createPlayer();
        scheduler = new TrackScheduler(player, channel);
        player.addListener(scheduler);
    }

    /**
     * @return Wrapper around AudioPlayer to use it as an AudioSendHandler.
     */
    AudioPlayerSendHandler getSendHandler() {
        return new AudioPlayerSendHandler(player);
    }
}
