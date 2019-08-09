package com.gctech.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.gctech.common.core.domain.BaseEntity;

/**
 * httplog记录表 log_httplog
 * 
 * @author ruoyi
 * @date 2019-08-01
 */
public class LogHttplog extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** 主键 */
	private Long id;
	/** ts */
	private String ts;
	/** uid */
	private String uid;
	/** orig_h */
	private String origH;
	/** orig_p */
	private String origP;
	/** resp_h */
	private String respH;
	/** resp_p */
	private String respP;
	/** trans_depth */
	private String transDepth;
	/** method */
	private String method;
	/** host */
	private String host;
	/** referrer */
	private String referrer;
	/** request_body_len */
	private String requestBodyLen;
	/** response_body_len */
	private String responseBodyLen;
	/** uri */
	private String uri;
	/** user_agent */
	private String userAgent;
	/** tags */
	private String tags;
	/** header_host */
	private String headerHost;
	/** header_accept */
	private String headerAccept;
	/** header_accept_encoding */
	private String headerAcceptEncoding;
	/** header_accept_language */
	private String headerAcceptLanguage;
	/** header_connection */
	private String headerConnection;
	/** orig_fuids */
	private String origFuids;
	/** orig_mime_types */
	private String origMimeTypes;
	/** post_body */
	private String postBody;
	/** header_cookie */
	private String headerCookie;
	/** header_content_type */
	private String headerContentType;

	public void setId(Long id) 
	{
		this.id = id;
	}

	public Long getId() 
	{
		return id;
	}
	public void setTs(String ts) 
	{
		this.ts = ts;
	}

	public String getTs() 
	{
		return ts;
	}
	public void setUid(String uid) 
	{
		this.uid = uid;
	}

	public String getUid() 
	{
		return uid;
	}
	public void setOrigH(String origH) 
	{
		this.origH = origH;
	}

	public String getOrigH() 
	{
		return origH;
	}
	public void setOrigP(String origP) 
	{
		this.origP = origP;
	}

	public String getOrigP() 
	{
		return origP;
	}
	public void setRespH(String respH) 
	{
		this.respH = respH;
	}

	public String getRespH() 
	{
		return respH;
	}
	public void setRespP(String respP) 
	{
		this.respP = respP;
	}

	public String getRespP() 
	{
		return respP;
	}
	public void setTransDepth(String transDepth) 
	{
		this.transDepth = transDepth;
	}

	public String getTransDepth() 
	{
		return transDepth;
	}
	public void setMethod(String method) 
	{
		this.method = method;
	}

	public String getMethod() 
	{
		return method;
	}
	public void setHost(String host) 
	{
		this.host = host;
	}

	public String getHost() 
	{
		return host;
	}
	public void setReferrer(String referrer) 
	{
		this.referrer = referrer;
	}

	public String getReferrer() 
	{
		return referrer;
	}
	public void setRequestBodyLen(String requestBodyLen) 
	{
		this.requestBodyLen = requestBodyLen;
	}

	public String getRequestBodyLen() 
	{
		return requestBodyLen;
	}
	public void setResponseBodyLen(String responseBodyLen) 
	{
		this.responseBodyLen = responseBodyLen;
	}

	public String getResponseBodyLen() 
	{
		return responseBodyLen;
	}
	public void setUri(String uri) 
	{
		this.uri = uri;
	}

	public String getUri() 
	{
		return uri;
	}
	public void setUserAgent(String userAgent) 
	{
		this.userAgent = userAgent;
	}

	public String getUserAgent() 
	{
		return userAgent;
	}
	public void setTags(String tags) 
	{
		this.tags = tags;
	}

	public String getTags() 
	{
		return tags;
	}
	public void setHeaderHost(String headerHost) 
	{
		this.headerHost = headerHost;
	}

	public String getHeaderHost() 
	{
		return headerHost;
	}
	public void setHeaderAccept(String headerAccept) 
	{
		this.headerAccept = headerAccept;
	}

	public String getHeaderAccept() 
	{
		return headerAccept;
	}
	public void setHeaderAcceptEncoding(String headerAcceptEncoding) 
	{
		this.headerAcceptEncoding = headerAcceptEncoding;
	}

	public String getHeaderAcceptEncoding() 
	{
		return headerAcceptEncoding;
	}
	public void setHeaderAcceptLanguage(String headerAcceptLanguage) 
	{
		this.headerAcceptLanguage = headerAcceptLanguage;
	}

	public String getHeaderAcceptLanguage() 
	{
		return headerAcceptLanguage;
	}
	public void setHeaderConnection(String headerConnection) 
	{
		this.headerConnection = headerConnection;
	}

	public String getHeaderConnection() 
	{
		return headerConnection;
	}
	public void setOrigFuids(String origFuids) 
	{
		this.origFuids = origFuids;
	}

	public String getOrigFuids() 
	{
		return origFuids;
	}
	public void setOrigMimeTypes(String origMimeTypes) 
	{
		this.origMimeTypes = origMimeTypes;
	}

	public String getOrigMimeTypes() 
	{
		return origMimeTypes;
	}
	public void setPostBody(String postBody) 
	{
		this.postBody = postBody;
	}

	public String getPostBody() 
	{
		return postBody;
	}
	public void setHeaderCookie(String headerCookie) 
	{
		this.headerCookie = headerCookie;
	}

	public String getHeaderCookie() 
	{
		return headerCookie;
	}
	public void setHeaderContentType(String headerContentType) 
	{
		this.headerContentType = headerContentType;
	}

	public String getHeaderContentType() 
	{
		return headerContentType;
	}

    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("ts", getTs())
            .append("uid", getUid())
            .append("origH", getOrigH())
            .append("origP", getOrigP())
            .append("respH", getRespH())
            .append("respP", getRespP())
            .append("transDepth", getTransDepth())
            .append("method", getMethod())
            .append("host", getHost())
            .append("referrer", getReferrer())
            .append("requestBodyLen", getRequestBodyLen())
            .append("responseBodyLen", getResponseBodyLen())
            .append("uri", getUri())
            .append("userAgent", getUserAgent())
            .append("tags", getTags())
            .append("headerHost", getHeaderHost())
            .append("headerAccept", getHeaderAccept())
            .append("headerAcceptEncoding", getHeaderAcceptEncoding())
            .append("headerAcceptLanguage", getHeaderAcceptLanguage())
            .append("headerConnection", getHeaderConnection())
            .append("origFuids", getOrigFuids())
            .append("origMimeTypes", getOrigMimeTypes())
            .append("postBody", getPostBody())
            .append("headerCookie", getHeaderCookie())
            .append("headerContentType", getHeaderContentType())
            .toString();
    }
}
