package ch.cyberduck.ui.cocoa.threading;

import ch.cyberduck.core.Session;
import ch.cyberduck.core.Path;

import com.apple.cocoa.foundation.NSBundle;

/*
 *  Copyright (c) 2006 David Kocher. All rights reserved.
 *  http://cyberduck.ch/
 *
 *  This program is free software; you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation; either version 2 of the License, or
 *  (at your option) any later version.
 *
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  Bug fixes, suggestions and comments should be sent to:
 *  dkocher@cyberduck.ch
 */

/**
 * @version $Id$
 */
public class BackgroundException extends Exception {

    private String message;

    private Path path;

    private Session session;

    public BackgroundException(Session session, Path path, String message, Exception cause) {
        super(cause);
        this.session = session;
        this.path = path;
        this.message = message;
    }

    public String getMessage() {
        return NSBundle.localizedString(this.message, "Error", "");
    }

    public Throwable getCause() {
        return super.getCause();
    }

    public Path getPath() {
        return this.path;
    }

    public Session getSession() {
        return this.session;
    }
}
