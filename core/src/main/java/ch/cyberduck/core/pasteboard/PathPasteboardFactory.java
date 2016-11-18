package ch.cyberduck.core.pasteboard;

import ch.cyberduck.core.Host;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class PathPasteboardFactory {

    private static final Map<Host, PathPasteboard> pasteboards
            = new HashMap<Host, PathPasteboard>();

    private PathPasteboardFactory() {
        //
    }

    /**
     * Factory to create a pasteboard for a session
     *
     * @param session Session instance
     * @return Pasteboard for a given session
     */
    public static PathPasteboard getPasteboard(final Host session) {
        if(!pasteboards.containsKey(session)) {
            pasteboards.put(session, new PathPasteboard(session));
        }
        return pasteboards.get(session);
    }

    /**
     * @return All available pasteboards
     */
    public static List<PathPasteboard> allPasteboards() {
        return new ArrayList<PathPasteboard>(pasteboards.values());
    }

    /**
     * Delete this pasteboard
     */
    public static void delete(final Host session) {
        if(pasteboards.containsKey(session)) {
            pasteboards.get(session).clear();
        }
        pasteboards.remove(session);
    }
}