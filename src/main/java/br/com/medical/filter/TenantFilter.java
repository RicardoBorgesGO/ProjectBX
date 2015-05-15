package br.com.medical.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import br.com.auth.constant.ParamName;
import br.com.medical.dao.ITenantDAO;
import br.com.medical.dao.impl.TenantDAOImpl;

public class TenantFilter implements Filter {

	private ITenantDAO tenantDAO = new TenantDAOImpl();
	
	@Override
	public void destroy() {
		
	}

	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) servletRequest;
		
		Cookie[] cookies = request.getCookies();
		
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if (cookie.getName().equals(ParamName.SESSION_COOKIE)) {
					try {
						JSONObject jsonObject = new JSONObject(cookie.getValue());
						String tenant = jsonObject.get(ParamName.TENANT).toString();
						
						tenantDAO.setTenant(tenant);
					} catch (JSONException e) {
						e.printStackTrace();
					}
				}
			}
		}
		filterChain.doFilter(servletRequest, servletResponse);
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
