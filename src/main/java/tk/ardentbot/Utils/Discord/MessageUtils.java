package tk.ardentbot.Utils.Discord;

import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.entities.Guild;
import net.dv8tion.jda.core.entities.User;
import tk.ardentbot.Core.CommandExecution.BaseCommand;
import tk.ardentbot.Core.Translation.Language;

import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class MessageUtils {
    public static EmbedBuilder getDefaultEmbed(Guild guild, User author, BaseCommand baseCommand) throws Exception {
        final Random random = new Random();
        final float hue = random.nextFloat();
        final float saturation = (random.nextInt(2000) + 1000) / 10000f;
        final float luminance = 2f;
        final Color color = Color.getHSBColor(hue, saturation, luminance);

        Language language = GuildUtils.getLanguage(guild);
        EmbedBuilder builder = new EmbedBuilder();
        builder.setColor(color);
        builder.setFooter(baseCommand.getTranslation("other", language, "requestedby").getTranslation().replace
                ("{0}", author.getName() + "#" + author.getDiscriminator()), author.getAvatarUrl());
        return builder;
    }

    public static String listWithCommas(ArrayList<String> strings) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < strings.size(); i++) {
            sb.append(strings.get(i));
            if (i < (strings.size() - 1)) sb.append(", ");
        }
        return sb.toString();
    }
}
