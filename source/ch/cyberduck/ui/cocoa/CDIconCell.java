package ch.cyberduck.ui.cocoa;

/*
 *  Copyright (c) 2005 David Kocher. All rights reserved.
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

import ch.cyberduck.core.DownloadQueue;
import ch.cyberduck.core.Queue;
import ch.cyberduck.core.SyncQueue;
import ch.cyberduck.core.UploadQueue;

import com.apple.cocoa.application.NSEvent;
import com.apple.cocoa.application.NSImage;
import com.apple.cocoa.application.NSText;
import com.apple.cocoa.application.NSView;
import com.apple.cocoa.application.NSWorkspace;
import com.apple.cocoa.foundation.NSCoder;
import com.apple.cocoa.foundation.NSPoint;
import com.apple.cocoa.foundation.NSRect;
import com.apple.cocoa.foundation.NSSize;

/**
 * @version $Id$
 */
public class CDIconCell extends CDTableCell {

    private Queue queue;

    public CDIconCell() {
        super();
    }

    protected CDIconCell(NSCoder decoder, long token) {
        super(decoder, token);
    }

    protected void encodeWithCoder(NSCoder encoder) {
        super.encodeWithCoder(encoder);
    }

    public void setObjectValue(Object q) {
        this.queue = (Queue) q;
    }

    private static final NSImage arrowUpIcon = NSImage.imageNamed("arrowUp.tiff");
    private static final NSImage arrowDownIcon = NSImage.imageNamed("arrowDown.tiff");
    private static final NSImage syncIcon = NSImage.imageNamed("sync32.tiff");
    private static final NSImage multipleDocumentsIcon = NSImage.imageNamed("multipleDocuments32.tiff");
    private static final NSImage folderIcon = NSImage.imageNamed("folder32.tiff");
    private static final NSImage notFoundIcon = NSImage.imageNamed("notfound.tiff");

    private static final float SPACE = 4;

    static {
        arrowUpIcon.setSize(new NSSize(32f, 32f));
        arrowDownIcon.setSize(new NSSize(32f, 32f));
        syncIcon.setSize(new NSSize(32f, 32f));
        notFoundIcon.setSize(new NSSize(32f, 32f));
    }

    public void editWithFrameInView(NSRect nsRect, NSView nsView, NSText nsText, Object object, NSEvent nsEvent) {
        super.editWithFrameInView(nsRect, nsView, nsText, object, nsEvent);
    }

    public void drawInteriorWithFrameInView(NSRect cellFrame, NSView controlView) {
        if(queue != null) {
            NSPoint cellPoint = cellFrame.origin();
            // drawing file icon
            NSImage fileIcon = notFoundIcon;
            if(queue.getRoot().getLocal().exists()) {
                if(queue.numberOfRoots() == 1) {
                    fileIcon = queue.getRoot().getLocal().isFile() ? NSWorkspace.sharedWorkspace().iconForFile(
                            queue.getRoot().getLocal().getAbsolute()) : folderIcon;
                }
                else {
                    fileIcon = multipleDocumentsIcon;
                }
            }
            NSImage arrowIcon = null;
            if(queue instanceof DownloadQueue) {
                arrowIcon = arrowDownIcon;
            }
            else if(queue instanceof UploadQueue) {
                arrowIcon = arrowUpIcon;
            }
            else if(queue instanceof SyncQueue) {
                arrowIcon = syncIcon;
                fileIcon = folderIcon;
            }
            fileIcon.setScalesWhenResized(true);
            fileIcon.setSize(new NSSize(32f, 32f));

            fileIcon.compositeToPoint(new NSPoint(cellPoint.x() + SPACE,
                    cellPoint.y() + 32 + SPACE),
                    NSImage.CompositeSourceOver);
            if(arrowIcon != null) {
                arrowIcon.compositeToPoint(new NSPoint(cellPoint.x() + SPACE * 3,
                        cellPoint.y() + 32 + SPACE * 4),
                        NSImage.CompositeSourceOver);
            }
        }
    }
}
