package com.google.firebase.database.p.g0;

import java.util.regex.Pattern;
/* loaded from: classes.dex */
public class m {

    /* renamed from: a  reason: collision with root package name */
    private static final Pattern f2195a = Pattern.compile("[\\[\\]\\.#$]");

    static {
        Pattern.compile("[\\[\\]\\.#\\$\\/\\u0000-\\u001F\\u007F]");
    }

    private static boolean a(String str) {
        return !f2195a.matcher(str).find();
    }

    public static void b(String str) {
        if (a(str)) {
            return;
        }
        throw new com.google.firebase.database.c("Invalid Firebase Database path: " + str + ". Firebase Database paths must not contain '.', '#', '$', '[', or ']'");
    }

    public static void c(String str) {
        int i;
        if (!str.startsWith(".info")) {
            i = str.startsWith("/.info") ? 6 : 6;
            b(str);
        }
        i = 5;
        str = str.substring(i);
        b(str);
    }
}
