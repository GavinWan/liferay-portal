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

package com.liferay.portlet.blogs.model.impl;

import com.liferay.portal.kernel.bean.ReadOnlyBeanHandler;
import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.model.impl.BaseModelImpl;

import com.liferay.portlet.blogs.model.BlogsEntry;
import com.liferay.portlet.blogs.model.BlogsEntrySoap;
import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.model.impl.ExpandoBridgeImpl;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * <a href="BlogsEntryModelImpl.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is a model that represents the <code>BlogsEntry</code> table
 * in the database.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.liferay.portlet.blogs.model.BlogsEntry
 * @see com.liferay.portlet.blogs.model.BlogsEntryModel
 * @see com.liferay.portlet.blogs.model.impl.BlogsEntryImpl
 *
 */
public class BlogsEntryModelImpl extends BaseModelImpl {
	public static final String TABLE_NAME = "BlogsEntry";
	public static final Object[][] TABLE_COLUMNS = {
			{ "uuid_", new Integer(Types.VARCHAR) },
			

			{ "entryId", new Integer(Types.BIGINT) },
			

			{ "groupId", new Integer(Types.BIGINT) },
			

			{ "companyId", new Integer(Types.BIGINT) },
			

			{ "userId", new Integer(Types.BIGINT) },
			

			{ "userName", new Integer(Types.VARCHAR) },
			

			{ "createDate", new Integer(Types.TIMESTAMP) },
			

			{ "modifiedDate", new Integer(Types.TIMESTAMP) },
			

			{ "title", new Integer(Types.VARCHAR) },
			

			{ "urlTitle", new Integer(Types.VARCHAR) },
			

			{ "content", new Integer(Types.CLOB) },
			

			{ "displayDate", new Integer(Types.TIMESTAMP) },
			

			{ "draft", new Integer(Types.BOOLEAN) },
			

			{ "allowTrackbacks", new Integer(Types.BOOLEAN) },
			

			{ "trackbacks", new Integer(Types.CLOB) }
		};
	public static final String TABLE_SQL_CREATE = "create table BlogsEntry (uuid_ VARCHAR(75) null,entryId LONG not null primary key,groupId LONG,companyId LONG,userId LONG,userName VARCHAR(75) null,createDate DATE null,modifiedDate DATE null,title VARCHAR(150) null,urlTitle VARCHAR(150) null,content TEXT null,displayDate DATE null,draft BOOLEAN,allowTrackbacks BOOLEAN,trackbacks TEXT null)";
	public static final String TABLE_SQL_DROP = "drop table BlogsEntry";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.portal.util.PropsUtil.get(
				"value.object.finder.cache.enabled.com.liferay.portlet.blogs.model.BlogsEntry"),
			true);

	public static BlogsEntry toModel(BlogsEntrySoap soapModel) {
		BlogsEntry model = new BlogsEntryImpl();

		model.setUuid(soapModel.getUuid());
		model.setEntryId(soapModel.getEntryId());
		model.setGroupId(soapModel.getGroupId());
		model.setCompanyId(soapModel.getCompanyId());
		model.setUserId(soapModel.getUserId());
		model.setUserName(soapModel.getUserName());
		model.setCreateDate(soapModel.getCreateDate());
		model.setModifiedDate(soapModel.getModifiedDate());
		model.setTitle(soapModel.getTitle());
		model.setUrlTitle(soapModel.getUrlTitle());
		model.setContent(soapModel.getContent());
		model.setDisplayDate(soapModel.getDisplayDate());
		model.setDraft(soapModel.getDraft());
		model.setAllowTrackbacks(soapModel.getAllowTrackbacks());
		model.setTrackbacks(soapModel.getTrackbacks());

		return model;
	}

	public static List<BlogsEntry> toModels(BlogsEntrySoap[] soapModels) {
		List<BlogsEntry> models = new ArrayList<BlogsEntry>(soapModels.length);

		for (BlogsEntrySoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.portal.util.PropsUtil.get(
				"lock.expiration.time.com.liferay.portlet.blogs.model.BlogsEntry"));

	public BlogsEntryModelImpl() {
	}

	public long getPrimaryKey() {
		return _entryId;
	}

	public void setPrimaryKey(long pk) {
		setEntryId(pk);
	}

	public Serializable getPrimaryKeyObj() {
		return new Long(_entryId);
	}

	public String getUuid() {
		return GetterUtil.getString(_uuid);
	}

	public void setUuid(String uuid) {
		if ((uuid != null) && (uuid != _uuid)) {
			_uuid = uuid;
		}
	}

	public long getEntryId() {
		return _entryId;
	}

	public void setEntryId(long entryId) {
		if (entryId != _entryId) {
			_entryId = entryId;
		}
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		if (groupId != _groupId) {
			_groupId = groupId;
		}
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		if (companyId != _companyId) {
			_companyId = companyId;
		}
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		if (userId != _userId) {
			_userId = userId;
		}
	}

	public String getUserName() {
		return GetterUtil.getString(_userName);
	}

	public void setUserName(String userName) {
		if (((userName == null) && (_userName != null)) ||
				((userName != null) && (_userName == null)) ||
				((userName != null) && (_userName != null) &&
				!userName.equals(_userName))) {
			_userName = userName;
		}
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		if (((createDate == null) && (_createDate != null)) ||
				((createDate != null) && (_createDate == null)) ||
				((createDate != null) && (_createDate != null) &&
				!createDate.equals(_createDate))) {
			_createDate = createDate;
		}
	}

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		if (((modifiedDate == null) && (_modifiedDate != null)) ||
				((modifiedDate != null) && (_modifiedDate == null)) ||
				((modifiedDate != null) && (_modifiedDate != null) &&
				!modifiedDate.equals(_modifiedDate))) {
			_modifiedDate = modifiedDate;
		}
	}

	public String getTitle() {
		return GetterUtil.getString(_title);
	}

	public void setTitle(String title) {
		if (((title == null) && (_title != null)) ||
				((title != null) && (_title == null)) ||
				((title != null) && (_title != null) && !title.equals(_title))) {
			_title = title;
		}
	}

	public String getUrlTitle() {
		return GetterUtil.getString(_urlTitle);
	}

	public void setUrlTitle(String urlTitle) {
		if (((urlTitle == null) && (_urlTitle != null)) ||
				((urlTitle != null) && (_urlTitle == null)) ||
				((urlTitle != null) && (_urlTitle != null) &&
				!urlTitle.equals(_urlTitle))) {
			_urlTitle = urlTitle;
		}
	}

	public String getContent() {
		return GetterUtil.getString(_content);
	}

	public void setContent(String content) {
		if (((content == null) && (_content != null)) ||
				((content != null) && (_content == null)) ||
				((content != null) && (_content != null) &&
				!content.equals(_content))) {
			_content = content;
		}
	}

	public Date getDisplayDate() {
		return _displayDate;
	}

	public void setDisplayDate(Date displayDate) {
		if (((displayDate == null) && (_displayDate != null)) ||
				((displayDate != null) && (_displayDate == null)) ||
				((displayDate != null) && (_displayDate != null) &&
				!displayDate.equals(_displayDate))) {
			_displayDate = displayDate;
		}
	}

	public boolean getDraft() {
		return _draft;
	}

	public boolean isDraft() {
		return _draft;
	}

	public void setDraft(boolean draft) {
		if (draft != _draft) {
			_draft = draft;
		}
	}

	public boolean getAllowTrackbacks() {
		return _allowTrackbacks;
	}

	public boolean isAllowTrackbacks() {
		return _allowTrackbacks;
	}

	public void setAllowTrackbacks(boolean allowTrackbacks) {
		if (allowTrackbacks != _allowTrackbacks) {
			_allowTrackbacks = allowTrackbacks;
		}
	}

	public String getTrackbacks() {
		return GetterUtil.getString(_trackbacks);
	}

	public void setTrackbacks(String trackbacks) {
		if (((trackbacks == null) && (_trackbacks != null)) ||
				((trackbacks != null) && (_trackbacks == null)) ||
				((trackbacks != null) && (_trackbacks != null) &&
				!trackbacks.equals(_trackbacks))) {
			_trackbacks = trackbacks;
		}
	}

	public BlogsEntry toEscapedModel() {
		if (isEscapedModel()) {
			return (BlogsEntry)this;
		}
		else {
			BlogsEntry model = new BlogsEntryImpl();

			model.setNew(isNew());
			model.setEscapedModel(true);

			model.setUuid(HtmlUtil.escape(getUuid()));
			model.setEntryId(getEntryId());
			model.setGroupId(getGroupId());
			model.setCompanyId(getCompanyId());
			model.setUserId(getUserId());
			model.setUserName(HtmlUtil.escape(getUserName()));
			model.setCreateDate(getCreateDate());
			model.setModifiedDate(getModifiedDate());
			model.setTitle(HtmlUtil.escape(getTitle()));
			model.setUrlTitle(HtmlUtil.escape(getUrlTitle()));
			model.setContent(HtmlUtil.escape(getContent()));
			model.setDisplayDate(getDisplayDate());
			model.setDraft(getDraft());
			model.setAllowTrackbacks(getAllowTrackbacks());
			model.setTrackbacks(HtmlUtil.escape(getTrackbacks()));

			model = (BlogsEntry)Proxy.newProxyInstance(BlogsEntry.class.getClassLoader(),
					new Class[] { BlogsEntry.class },
					new ReadOnlyBeanHandler(model));

			return model;
		}
	}

	public ExpandoBridge getExpandoBridge() {
		if (_expandoBridge == null) {
			_expandoBridge = new ExpandoBridgeImpl(BlogsEntry.class.getName(),
					getPrimaryKey());
		}

		return _expandoBridge;
	}

	public Object clone() {
		BlogsEntryImpl clone = new BlogsEntryImpl();

		clone.setUuid(getUuid());
		clone.setEntryId(getEntryId());
		clone.setGroupId(getGroupId());
		clone.setCompanyId(getCompanyId());
		clone.setUserId(getUserId());
		clone.setUserName(getUserName());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setTitle(getTitle());
		clone.setUrlTitle(getUrlTitle());
		clone.setContent(getContent());
		clone.setDisplayDate(getDisplayDate());
		clone.setDraft(getDraft());
		clone.setAllowTrackbacks(getAllowTrackbacks());
		clone.setTrackbacks(getTrackbacks());

		return clone;
	}

	public int compareTo(Object obj) {
		if (obj == null) {
			return -1;
		}

		BlogsEntryImpl blogsEntry = (BlogsEntryImpl)obj;

		int value = 0;

		value = DateUtil.compareTo(getDisplayDate(), blogsEntry.getDisplayDate());

		value = value * -1;

		if (value != 0) {
			return value;
		}

		return 0;
	}

	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		BlogsEntryImpl blogsEntry = null;

		try {
			blogsEntry = (BlogsEntryImpl)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long pk = blogsEntry.getPrimaryKey();

		if (getPrimaryKey() == pk) {
			return true;
		}
		else {
			return false;
		}
	}

	public int hashCode() {
		return (int)getPrimaryKey();
	}

	private String _uuid;
	private long _entryId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private String _title;
	private String _urlTitle;
	private String _content;
	private Date _displayDate;
	private boolean _draft;
	private boolean _allowTrackbacks;
	private String _trackbacks;
	private transient ExpandoBridge _expandoBridge;
}