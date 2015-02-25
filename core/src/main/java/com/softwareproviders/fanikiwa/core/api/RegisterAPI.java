package com.softwareproviders.fanikiwa.core.api;


import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.Named;
import com.google.api.server.spi.response.NotFoundException;
import com.softwareproviders.fanikiwa.core.business.RegisterComponent;
import com.softwareproviders.fanikiwa.core.entity.Member;


@Api(name = "registerapi", version = "v1", description = "An API to register members")
public class RegisterAPI {
	
	@ApiMethod(name="add")
	public Member addMember(@Named("member") Member member) throws NotFoundException {
		RegisterComponent mserv = new RegisterComponent();
		try {
			return mserv.addMember(member);
		} catch (Exception e) {
			throw new NotFoundException(e);
		}
	}
}
