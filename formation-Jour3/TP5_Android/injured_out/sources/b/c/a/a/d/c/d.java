package b.c.a.a.d.c;
/* loaded from: classes.dex */
public abstract class d {
    /* JADX INFO: Access modifiers changed from: private */
    public static String d(char c2) {
        char[] cArr = {'\\', 'u', 0, 0, 0, 0};
        for (int i = 0; i < 4; i++) {
            cArr[5 - i] = "0123456789ABCDEF".charAt(c2 & 15);
            c2 = (char) (c2 >> 4);
        }
        return String.copyValueOf(cArr);
    }

    public int a(CharSequence charSequence, int i) {
        int length = charSequence.length();
        m.b(i, length, "index");
        while (i < length) {
            if (b(charSequence.charAt(i))) {
                return i;
            }
            i++;
        }
        return -1;
    }

    public abstract boolean b(char c2);
}
