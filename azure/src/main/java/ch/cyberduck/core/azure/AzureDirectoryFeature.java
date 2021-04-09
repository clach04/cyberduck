package ch.cyberduck.core.azure;

/*
 * Copyright (c) 2002-2014 David Kocher. All rights reserved.
 * http://cyberduck.io/
 *
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * Bug fixes, suggestions and comments should be sent to:
 * feedback@cyberduck.io
 */

import ch.cyberduck.core.DisabledConnectionCallback;
import ch.cyberduck.core.Path;
import ch.cyberduck.core.PathAttributes;
import ch.cyberduck.core.PathContainerService;
import ch.cyberduck.core.exception.BackgroundException;
import ch.cyberduck.core.exception.NotfoundException;
import ch.cyberduck.core.features.Directory;
import ch.cyberduck.core.features.Write;
import ch.cyberduck.core.io.DefaultStreamCloser;
import ch.cyberduck.core.transfer.TransferStatus;

import org.apache.commons.io.input.NullInputStream;
import org.apache.commons.lang3.StringUtils;

import java.net.URISyntaxException;
import java.util.EnumSet;

import com.microsoft.azure.storage.OperationContext;
import com.microsoft.azure.storage.StorageException;
import com.microsoft.azure.storage.blob.BlobRequestOptions;
import com.microsoft.azure.storage.blob.CloudBlobContainer;

public class AzureDirectoryFeature implements Directory<Void> {

    private final PathContainerService containerService
        = new AzurePathContainerService();

    private final AzureSession session;
    private final OperationContext context;

    private Write<Void> writer;

    public AzureDirectoryFeature(final AzureSession session, final OperationContext context) {
        this.session = session;
        this.context = context;
        this.writer = new AzureWriteFeature(session, context);
    }

    @Override
    public Path mkdir(final Path folder, final String region, final TransferStatus status) throws BackgroundException {
        try {
            final BlobRequestOptions options = new BlobRequestOptions();
            if(containerService.isContainer(folder)) {
                // Container name must be lower case.
                final CloudBlobContainer container = session.getClient().getContainerReference(containerService.getContainer(folder).getName());
                container.create(options, context);
                return folder.withAttributes(new AzureAttributesFinderFeature(session, context).find(folder));
            }
            else {
                status.setChecksum(writer.checksum(folder, status).compute(new NullInputStream(0L), status));
                final EnumSet<Path.Type> type = EnumSet.copyOf(folder.getType());
                type.add(Path.Type.placeholder);
                new DefaultStreamCloser().close(writer.write(folder.withType(type), status, new DisabledConnectionCallback()));
                return folder.withAttributes(new AzureAttributesFinderFeature(session, context).find(folder));
            }
        }
        catch(URISyntaxException e) {
            throw new NotfoundException(e.getMessage(), e);
        }
        catch(StorageException e) {
            throw new AzureExceptionMappingService().map("Cannot create folder {0}", e, folder);
        }
    }

    @Override
    public boolean isSupported(final Path workdir, final String name) {
        if(workdir.isRoot()) {
            // Empty argument if not known in validation
            if(StringUtils.isNotBlank(name)) {
                // Container names must be lowercase, between 3-63 characters long and must start with a letter or
                // number. Container names may contain only letters, numbers, and the dash (-) character.
                if(StringUtils.length(name) > 63) {
                    return false;
                }
                if(StringUtils.length(name) < 3) {
                    return false;
                }
                return StringUtils.isAlphanumeric(StringUtils.removeAll(name, "-"));
            }
        }
        return true;
    }

    @Override
    public Directory<Void> withWriter(final Write<Void> writer) {
        this.writer = writer;
        return this;
    }
}
