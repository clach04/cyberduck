package ch.cyberduck.ui.cocoa;

import ch.cyberduck.core.transfer.DownloadTransfer;
import ch.cyberduck.core.transfer.SyncTransfer;
import ch.cyberduck.core.transfer.Transfer;
import ch.cyberduck.core.transfer.UploadTransfer;

/**
 * @version $Id$
 */
public final class TransferPromptControllerFactory {

    private TransferPromptControllerFactory() {
        //
    }

    public static TransferPromptController create(final WindowController parent, final Transfer transfer) {
        if(transfer instanceof DownloadTransfer) {
            return new DownloadPromptController(parent, transfer);
        }
        if(transfer instanceof UploadTransfer) {
            return new UploadPromptController(parent, transfer);
        }
        if(transfer instanceof SyncTransfer) {
            return new SyncPromptController(parent, transfer);
        }
        throw new IllegalArgumentException(transfer.toString());
    }
}
