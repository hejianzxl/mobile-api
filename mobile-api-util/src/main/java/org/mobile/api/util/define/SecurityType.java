package org.mobile.api.util.define;

public enum SecurityType {
	Test(-1, false), None(0, false), RegisteredDevice(256, false), User(512, true), UserTrustedDevice(1024, true),
	MobileOwner(2048, false), MobileOwnerTrustedDevice(4096, false), GuestLogin(16384, true), UserLogin(8192, true),
	UserLoginAndMobileOwner(UserLogin.code | MobileOwner.code, UserLogin.needUserToken | MobileOwner.needUserToken),
	Integrated(268435456, false);

	private int code;
	private boolean needUserToken;

	private SecurityType(int code, boolean needUserToken) {
		this.code = code;
		this.needUserToken = needUserToken;
	}

	public boolean check(int auth) {
		return (auth & this.code) == this.code;
	}

	public boolean check(SecurityType auth) {
		return (auth.code & this.code) == this.code;
	}

	public int authorize(int auth) {
		return auth | this.code;
	}

	public static boolean isNone(int auth) {
		return auth == 0;
	}

	public boolean isNeedUserToken() {
		return this.needUserToken;
	}

	public int getCode() {
		return this.code;
	}
}
