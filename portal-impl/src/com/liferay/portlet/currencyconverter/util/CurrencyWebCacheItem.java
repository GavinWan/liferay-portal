/**
 * Copyright (c) 2000-2009 Liferay, Inc. All rights reserved.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package com.liferay.portlet.currencyconverter.util;

import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.HttpUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Time;
import com.liferay.portal.kernel.webcache.WebCacheException;
import com.liferay.portal.kernel.webcache.WebCacheItem;
import com.liferay.portlet.currencyconverter.model.Currency;

import java.util.StringTokenizer;

/**
 * <a href="CurrencyWebCacheItem.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class CurrencyWebCacheItem implements WebCacheItem {

	public CurrencyWebCacheItem(String symbol) {
		_symbol = symbol;
	}

	public Object convert(String key) throws WebCacheException {
		String symbol = _symbol;
		double rate = 0.0;

		try {
			if (symbol.length() == 6) {
				String fromSymbol = symbol.substring(0, 3);
				String toSymbol = symbol.substring(3, 6);

				if (!CurrencyUtil.isCurrency(fromSymbol) ||
					!CurrencyUtil.isCurrency(toSymbol)) {

					throw new WebCacheException(symbol);
				}
			}
			else if (symbol.length() == 3) {
				if (!CurrencyUtil.isCurrency(symbol)) {
					throw new WebCacheException(symbol);
				}
			}
			else {
				throw new WebCacheException(symbol);
			}

			String text = HttpUtil.URLtoString(
				"http://finance.yahoo.com/d/quotes.csv?s=" +
					symbol + "=X&f=sl1d1t1c1ohgv&e=.csv");

			StringTokenizer st = new StringTokenizer(text, StringPool.COMMA);

			// Skip symbol

			st.nextToken();

			rate = GetterUtil.getDouble(
				st.nextToken().replace('"', ' ').trim());
		}
		catch (Exception e) {
			throw new WebCacheException(e);
		}

		return new Currency(symbol, rate);
	}

	public long getRefreshTime() {
		return _REFRESH_TIME;
	}

	private static final long _REFRESH_TIME = Time.MINUTE * 20;

	private String _symbol;

}