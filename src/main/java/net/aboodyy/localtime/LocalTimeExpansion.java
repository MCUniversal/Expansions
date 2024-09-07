/*

    LocalTime Expansion - Provides PlaceholderAPI placeholders to give player's local time
    Copyright (C) 2020 aBooDyy

    This program is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with this program.  If not, see <https://www.gnu.org/licenses/>.

 */

package net.aboodyy.localtime;

import me.clip.placeholderapi.PlaceholderAPIPlugin;
import me.clip.placeholderapi.expansion.Cacheable;
import me.clip.placeholderapi.expansion.Configurable;
import me.clip.placeholderapi.expansion.PlaceholderExpansion;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.HandlerList;

import java.util.HashMap;
import java.util.Map;
import java.util.TimeZone;

@SuppressWarnings("unused")
public class LocalTimeExpansion extends PlaceholderExpansion implements Cacheable, Configurable {

    private DateManager dateManager;

    @Override
    public String getIdentifier() {
        return "lab";
    }

    @Override
    public String getAuthor() {
        return "hetmastertje";
    }

    @Override
    public String getVersion() {
        return "1.0";
    }

    @Override
    public boolean register() {
        dateManager = new DateManager();
        Bukkit.getPluginManager().registerEvents(dateManager, PlaceholderAPIPlugin.getInstance());

        return super.register();
    }

    public Map<String, Object> getDefaults() {
        Map<String, Object> defaults = new HashMap<>();
        defaults.put("date_format", "dd/MM/yyyy hh:mma");

        return defaults;
    }

    public void clear() {
        dateManager.clear();
        HandlerList.unregisterAll(dateManager);
    }

    @Override
    public String onPlaceholderRequest(Player p, String identifier) {
        if (identifier.equalsIgnoreCase("formatUUID"))
            return dateManager.getConfig().getString("server.formatUUID");

        else if (identifier.equalsIgnoreCase("uuid"))
            return dateManager.getConfig().getString("server.uuid");

        return null;
    }
}
