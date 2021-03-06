/**
 *
 * Copyright (c) 2014 CoderKiss
 *
 * CoderKiss[AT]gmail.com
 *
 */

package me.dawson.kisstools.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.webkit.MimeTypeMap;

public class CommonUtil {
	public static final String TAG = "CommonUtil";

	public static long valueOfLong(String text) {
		long value = -1;
		try {
			value = Long.valueOf(text);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return value;
	}

	public static void showIME(Context context) {
		InputMethodManager imm = (InputMethodManager) context
				.getSystemService(Context.INPUT_METHOD_SERVICE);
		imm.toggleSoftInput(InputMethodManager.SHOW_FORCED,
				InputMethodManager.HIDE_NOT_ALWAYS);
	}

	public static void hideIME(Context context, View view) {
		InputMethodManager imm = (InputMethodManager) context
				.getSystemService(Context.INPUT_METHOD_SERVICE);
		imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
	}

	public final static String getMimeType(String url) {
		String extension = MimeTypeMap.getFileExtensionFromUrl(url);
		String mimeType = MimeTypeMap.getSingleton().getMimeTypeFromExtension(
				extension);
		return mimeType;
	}

	public static void startActivity(Context context, Intent intent) {
		if (context == null || intent == null) {
			return;
		}

		if (!(context instanceof Activity)) {
			intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		}

		try {
			context.startActivity(intent);
		} catch (Exception e) {

		}
	}

	public static int getUid(Context context) {
		try {
			PackageManager pm = context.getPackageManager();
			ApplicationInfo ai = pm.getApplicationInfo(
					context.getPackageName(), PackageManager.GET_ACTIVITIES);
			return ai.uid;
		} catch (NameNotFoundException e) {
			e.printStackTrace();
		}
		return 0;
	}
}
