/**
 * Copyright (c) 2000-2012 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.portalweb.portlet.documentlibrary.usecase.demo1;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class MoveDMFolder1Document2NewFolderHomeDADTest extends BaseTestCase {
	public void testMoveDMFolder1Document2NewFolderHomeDAD()
		throws Exception {
		selenium.open("/web/guest/home/");
		loadRequiredJavaScriptModules();

		for (int second = 0;; second++) {
			if (second >= 90) {
				fail("timeout");
			}

			try {
				if (selenium.isVisible("link=Documents and Media Test Page")) {
					break;
				}
			}
			catch (Exception e) {
			}

			Thread.sleep(1000);
		}

		selenium.clickAt("link=Documents and Media Test Page",
			RuntimeVariables.replace("Documents and Media Test Page"));
		selenium.waitForPageToLoad("30000");
		loadRequiredJavaScriptModules();
		assertEquals(RuntimeVariables.replace("Mine"),
			selenium.getText("//div[@id='_20_folderContainer']/ul/li[3]/a"));
		selenium.clickAt("//div[@id='_20_folderContainer']/ul/li[3]/a",
			RuntimeVariables.replace("Mine"));

		for (int second = 0;; second++) {
			if (second >= 90) {
				fail("timeout");
			}

			try {
				if (RuntimeVariables.replace("Mine")
										.equals(selenium.getText(
								"//div[@id='_20_folderContainer']/ul/li[contains(@class,'selected')]/a"))) {
					break;
				}
			}
			catch (Exception e) {
			}

			Thread.sleep(1000);
		}

		assertEquals(RuntimeVariables.replace("Mine"),
			selenium.getText(
				"//div[@id='_20_folderContainer']/ul/li[contains(@class,'selected')]/a"));
		Thread.sleep(5000);
		assertEquals(RuntimeVariables.replace("DM Document2 Title"),
			selenium.getText(
				"//div[@data-title='DM Document2 Title']/a/span[2]"));
		selenium.mouseDown("//div[@data-title='DM Document2 Title']/a/span[2]");

		for (int second = 0;; second++) {
			if (second >= 90) {
				fail("timeout");
			}

			try {
				if (selenium.isVisible(
							"//div[@class='yui3-dd-proxy active-area-proxy']")) {
					break;
				}
			}
			catch (Exception e) {
			}

			Thread.sleep(1000);
		}

		assertEquals(RuntimeVariables.replace("1 item is ready to be moved."),
			selenium.getText("//div[@class='yui3-dd-proxy active-area-proxy']"));
		Thread.sleep(5000);
		selenium.mouseMoveAt("//div[@id='_20_folderContainer']/ul/li[1]/a[2]",
			RuntimeVariables.replace("5,15"));

		for (int second = 0;; second++) {
			if (second >= 90) {
				fail("timeout");
			}

			try {
				if (RuntimeVariables.replace(
							"1 item is ready to be moved to \"Home\".")
										.equals(selenium.getText(
								"//div[@class='yui3-dd-proxy active-area-proxy']"))) {
					break;
				}
			}
			catch (Exception e) {
			}

			Thread.sleep(1000);
		}

		assertEquals(RuntimeVariables.replace(
				"1 item is ready to be moved to \"Home\"."),
			selenium.getText("//div[@class='yui3-dd-proxy active-area-proxy']"));
		selenium.mouseUp("//div[@id='_20_folderContainer']/ul/li[1]/a[2]");

		for (int second = 0;; second++) {
			if (second >= 90) {
				fail("timeout");
			}

			try {
				if (RuntimeVariables.replace("DM Document2 Title")
										.equals(selenium.getText(
								"//li[@class='move-file']"))) {
					break;
				}
			}
			catch (Exception e) {
			}

			Thread.sleep(1000);
		}

		assertEquals(RuntimeVariables.replace("DM Document2 Title"),
			selenium.getText("//li[@class='move-file']"));
		assertEquals(RuntimeVariables.replace("Home"),
			selenium.getText("//a[@id='_20_folderName']"));
		selenium.clickAt("//input[@value='Move']",
			RuntimeVariables.replace("Move"));
		selenium.waitForPageToLoad("30000");
		loadRequiredJavaScriptModules();
		assertEquals(RuntimeVariables.replace(
				"Your request completed successfully."),
			selenium.getText("//div[@class='portlet-msg-success']"));
	}
}