package ch.cyberduck.core.features;

/*
 * Copyright (c) 2002-2016 iterate GmbH. All rights reserved.
 * https://cyberduck.io/
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
 */

import ch.cyberduck.core.Path;
import ch.cyberduck.core.cryptomator.CryptoAuthenticationException;
import ch.cyberduck.core.cryptomator.VaultException;
import ch.cyberduck.core.exception.BackgroundException;
import ch.cyberduck.core.exception.LoginCanceledException;
import ch.cyberduck.core.exception.NotfoundException;

import java.util.EnumSet;

public interface Vault {

    /**
     * Create and open new vault
     *
     * @return Open vault
     * @throws VaultException                Failure parsing master key
     * @throws LoginCanceledException        User dismissed passphrase prompt
     * @throws BackgroundException           Failure reading master key from server
     * @throws NotfoundException             No master key file in home
     * @throws CryptoAuthenticationException Failure opening master key file
     */
    Vault create() throws BackgroundException;

    /**
     * Open existing vault
     *
     * @return Open vault
     * @throws VaultException                Failure parsing master key
     * @throws LoginCanceledException        User dismissed passphrase prompt
     * @throws BackgroundException           Failure reading master key from server
     * @throws NotfoundException             No master key file in home
     * @throws CryptoAuthenticationException Failure opening master key file
     */
    Vault load() throws BackgroundException;

    /**
     * Close vault
     */
    void close();

    void delete() throws BackgroundException;
    /**
     * @param file File or directory
     * @return True if the file is part of the vault
     */
    boolean contains(Path file);

    Path encrypt(Path file) throws BackgroundException;

    Path encrypt(Path file, EnumSet<Path.Type> type) throws BackgroundException;

    Path decrypt(Path directory, Path file) throws BackgroundException;

    @SuppressWarnings("unchecked")
    <T> T getFeature(Class<T> type, T delegate);

    Vault DISABLED = new Vault() {
        @Override
        public Vault create() throws BackgroundException {
            return this;
        }

        @Override
        public Vault load() throws BackgroundException {
            return this;
        }

        @Override
        public void close() {
            //
        }

        @Override
        public void delete() throws BackgroundException {
            //
        }

        @Override
        public boolean contains(final Path file) {
            return false;
        }

        @Override
        public Path encrypt(final Path file) throws BackgroundException {
            return file;
        }

        @Override
        public Path encrypt(final Path file, final EnumSet<Path.Type> type) throws BackgroundException {
            return file;
        }

        @Override
        public Path decrypt(final Path directory, final Path file) throws BackgroundException {
            return file;
        }

        @Override
        public <T> T getFeature(final Class<T> type, final T delegate) {
            return delegate;
        }
    };
}
