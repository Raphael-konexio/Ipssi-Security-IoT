package com.google.android.gms.common.util;

import android.text.TextUtils;
import java.util.regex.Pattern;
/* loaded from: classes.dex */
public class k {
    static {
        Pattern.compile("\\$\\{(.*?)\\}");
    }

    public static String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return str;
    }

    public static boolean b(String str) {
        return str == null || str.trim().isEmpty();
    }
}
