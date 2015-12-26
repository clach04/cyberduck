package ch.cyberduck.core.openstack;

import ch.cyberduck.core.Credentials;
import ch.cyberduck.core.DisabledCancelCallback;
import ch.cyberduck.core.DisabledHostKeyCallback;
import ch.cyberduck.core.DisabledLoginCallback;
import ch.cyberduck.core.DisabledPasswordStore;
import ch.cyberduck.core.DisabledTranscriptListener;
import ch.cyberduck.core.Host;
import ch.cyberduck.core.Local;
import ch.cyberduck.core.Path;
import ch.cyberduck.core.Profile;
import ch.cyberduck.core.ProfileReaderFactory;
import ch.cyberduck.core.ProtocolFactory;
import ch.cyberduck.core.features.Location;

import org.junit.Test;

import java.util.EnumSet;

import ch.iterate.openstack.swift.model.Region;

import static org.junit.Assert.*;

/**
 * @version $Id$
 */
public class SwiftRegionServiceTest {

    @Test
    public void testLookupDefault() throws Exception {
        final SwiftSession session = new SwiftSession(
                new Host(new SwiftProtocol(), "identity.api.rackspacecloud.com",
                        new Credentials(
                                System.getProperties().getProperty("rackspace.key"), System.getProperties().getProperty("rackspace.secret")
                        )));
        session.open(new DisabledHostKeyCallback(), new DisabledTranscriptListener());
        session.login(new DisabledPasswordStore(), new DisabledLoginCallback(), new DisabledCancelCallback());
        final Region lookup = new SwiftRegionService(session).lookup(Location.unknown);
        assertTrue(lookup.isDefault());
        assertEquals("DFW", lookup.getRegionId());
        assertNotNull(lookup.getCDNManagementUrl());
        assertNotNull(lookup.getStorageUrl());
    }

    @Test
    public void testLookupHp() throws Exception {
        final SwiftProtocol protocol = new SwiftProtocol() {
            @Override
            public String getContext() {
                return "/v2.0/tokens";
            }
        };
        final Host host = new Host(protocol, "region-a.geo-1.identity.hpcloudsvc.com", 35357);
        host.setCredentials(System.getProperties().getProperty("hpcloud.key"), System.getProperties().getProperty("hpcloud.secret"));
        final SwiftSession session = new SwiftSession(host);
        session.open(new DisabledHostKeyCallback(), new DisabledTranscriptListener());
        session.login(new DisabledPasswordStore(), new DisabledLoginCallback(), new DisabledCancelCallback());
        final Region lookup = new SwiftRegionService(session).lookup(Location.unknown);
        assertEquals("region-a.geo-1", lookup.getRegionId());
        assertNotNull(lookup.getStorageUrl());
        assertNotNull(lookup.getCDNManagementUrl());
    }

    @Test
    public void testFindDefaultLocationInBookmark() throws Exception {
        ProtocolFactory.register(new SwiftProtocol());
        final Profile profile = ProfileReaderFactory.get().read(
                new Local("../profiles/Rackspace US (IAD).cyberduckprofile"));
        final SwiftSession session = new SwiftSession(
                new Host(profile, "identity.api.rackspacecloud.com",
                        new Credentials(
                                System.getProperties().getProperty("rackspace.key"), System.getProperties().getProperty("rackspace.secret")
                        ))) {

        };
        assertEquals("IAD", session.getHost().getRegion());
        final Region location = new SwiftRegionService(session).lookup(new Path("/test.cyberduck.ch",
                EnumSet.of(Path.Type.directory, Path.Type.volume)));
        assertNotNull(location);
        assertEquals("IAD", location.getRegionId());
    }
}
