package com.oracle.uk.ocs.osbutil.xmlcache.tests;

import junit.framework.TestCase;

import org.apache.xmlbeans.XmlObject;

import com.oracle.uk.ocs.osbutil.xmlcache.XmlCacheException;
import com.oracle.uk.ocs.osbutil.xmlcache.XmlCacheUtilityOSBFacade;

public class XmlCacheUtilityOSBFacadeTest extends TestCase {
	

	public void testGetXml() {
		try {
			XmlObject xml = XmlCacheUtilityOSBFacade.getXml("test");
			assertNotNull(xml);
			assertEquals("MyRootNode", xml.getDomNode().getChildNodes().item(0).getLocalName());
		} catch (XmlCacheException e) {
			fail("XmlCacheException whilst retrieving test XML");
		}
	}
	
	public void testGetXml_NoSuchXml() {
		try {
			XmlCacheUtilityOSBFacade.getXml("none");
			fail("Expected to get exception!");
		} catch (XmlCacheException e) {
		}
	}
	
}
