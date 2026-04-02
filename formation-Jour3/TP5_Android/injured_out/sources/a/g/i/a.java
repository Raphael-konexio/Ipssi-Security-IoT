package a.g.i;

import android.text.SpannableStringBuilder;
import java.util.Locale;
/* loaded from: classes.dex */
public final class a {

    /* renamed from: d  reason: collision with root package name */
    static final d f185d = e.f208c;
    private static final String e = Character.toString(8206);
    private static final String f = Character.toString(8207);
    static final a g = new a(false, 2, f185d);
    static final a h = new a(true, 2, f185d);

    /* renamed from: a  reason: collision with root package name */
    private final boolean f186a;

    /* renamed from: b  reason: collision with root package name */
    private final int f187b;

    /* renamed from: c  reason: collision with root package name */
    private final d f188c;

    /* renamed from: a.g.i.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static final class C0008a {

        /* renamed from: a  reason: collision with root package name */
        private boolean f189a;

        /* renamed from: b  reason: collision with root package name */
        private int f190b;

        /* renamed from: c  reason: collision with root package name */
        private d f191c;

        public C0008a() {
            c(a.e(Locale.getDefault()));
        }

        private static a b(boolean z) {
            return z ? a.h : a.g;
        }

        private void c(boolean z) {
            this.f189a = z;
            this.f191c = a.f185d;
            this.f190b = 2;
        }

        public a a() {
            return (this.f190b == 2 && this.f191c == a.f185d) ? b(this.f189a) : new a(this.f189a, this.f190b, this.f191c);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b {
        private static final byte[] f = new byte[1792];

        /* renamed from: a  reason: collision with root package name */
        private final CharSequence f192a;

        /* renamed from: b  reason: collision with root package name */
        private final boolean f193b;

        /* renamed from: c  reason: collision with root package name */
        private final int f194c;

        /* renamed from: d  reason: collision with root package name */
        private int f195d;
        private char e;

        static {
            for (int i = 0; i < 1792; i++) {
                f[i] = Character.getDirectionality(i);
            }
        }

        b(CharSequence charSequence, boolean z) {
            this.f192a = charSequence;
            this.f193b = z;
            this.f194c = charSequence.length();
        }

        private static byte c(char c2) {
            return c2 < 1792 ? f[c2] : Character.getDirectionality(c2);
        }

        private byte f() {
            char charAt;
            int i = this.f195d;
            do {
                int i2 = this.f195d;
                if (i2 <= 0) {
                    break;
                }
                CharSequence charSequence = this.f192a;
                int i3 = i2 - 1;
                this.f195d = i3;
                charAt = charSequence.charAt(i3);
                this.e = charAt;
                if (charAt == '&') {
                    return (byte) 12;
                }
            } while (charAt != ';');
            this.f195d = i;
            this.e = ';';
            return (byte) 13;
        }

        private byte g() {
            char charAt;
            do {
                int i = this.f195d;
                if (i >= this.f194c) {
                    return (byte) 12;
                }
                CharSequence charSequence = this.f192a;
                this.f195d = i + 1;
                charAt = charSequence.charAt(i);
                this.e = charAt;
            } while (charAt != ';');
            return (byte) 12;
        }

        private byte h() {
            char charAt;
            int i = this.f195d;
            while (true) {
                int i2 = this.f195d;
                if (i2 <= 0) {
                    break;
                }
                CharSequence charSequence = this.f192a;
                int i3 = i2 - 1;
                this.f195d = i3;
                char charAt2 = charSequence.charAt(i3);
                this.e = charAt2;
                if (charAt2 == '<') {
                    return (byte) 12;
                }
                if (charAt2 == '>') {
                    break;
                } else if (charAt2 == '\"' || charAt2 == '\'') {
                    char c2 = this.e;
                    do {
                        int i4 = this.f195d;
                        if (i4 > 0) {
                            CharSequence charSequence2 = this.f192a;
                            int i5 = i4 - 1;
                            this.f195d = i5;
                            charAt = charSequence2.charAt(i5);
                            this.e = charAt;
                        }
                    } while (charAt != c2);
                }
            }
            this.f195d = i;
            this.e = '>';
            return (byte) 13;
        }

        private byte i() {
            char charAt;
            int i = this.f195d;
            while (true) {
                int i2 = this.f195d;
                if (i2 >= this.f194c) {
                    this.f195d = i;
                    this.e = '<';
                    return (byte) 13;
                }
                CharSequence charSequence = this.f192a;
                this.f195d = i2 + 1;
                char charAt2 = charSequence.charAt(i2);
                this.e = charAt2;
                if (charAt2 == '>') {
                    return (byte) 12;
                }
                if (charAt2 == '\"' || charAt2 == '\'') {
                    char c2 = this.e;
                    do {
                        int i3 = this.f195d;
                        if (i3 < this.f194c) {
                            CharSequence charSequence2 = this.f192a;
                            this.f195d = i3 + 1;
                            charAt = charSequence2.charAt(i3);
                            this.e = charAt;
                        }
                    } while (charAt != c2);
                }
            }
        }

        byte a() {
            char charAt = this.f192a.charAt(this.f195d - 1);
            this.e = charAt;
            if (Character.isLowSurrogate(charAt)) {
                int codePointBefore = Character.codePointBefore(this.f192a, this.f195d);
                this.f195d -= Character.charCount(codePointBefore);
                return Character.getDirectionality(codePointBefore);
            }
            this.f195d--;
            byte c2 = c(this.e);
            if (this.f193b) {
                char c3 = this.e;
                return c3 == '>' ? h() : c3 == ';' ? f() : c2;
            }
            return c2;
        }

        byte b() {
            char charAt = this.f192a.charAt(this.f195d);
            this.e = charAt;
            if (Character.isHighSurrogate(charAt)) {
                int codePointAt = Character.codePointAt(this.f192a, this.f195d);
                this.f195d += Character.charCount(codePointAt);
                return Character.getDirectionality(codePointAt);
            }
            this.f195d++;
            byte c2 = c(this.e);
            if (this.f193b) {
                char c3 = this.e;
                return c3 == '<' ? i() : c3 == '&' ? g() : c2;
            }
            return c2;
        }

        int d() {
            this.f195d = 0;
            int i = 0;
            int i2 = 0;
            int i3 = 0;
            while (this.f195d < this.f194c && i == 0) {
                byte b2 = b();
                if (b2 != 0) {
                    if (b2 == 1 || b2 == 2) {
                        if (i3 == 0) {
                            return 1;
                        }
                    } else if (b2 != 9) {
                        switch (b2) {
                            case 14:
                            case 15:
                                i3++;
                                i2 = -1;
                                break;
                            case 16:
                            case 17:
                                i3++;
                                i2 = 1;
                                break;
                            case 18:
                                i3--;
                                i2 = 0;
                                break;
                        }
                    }
                } else if (i3 == 0) {
                    return -1;
                }
                i = i3;
            }
            if (i == 0) {
                return 0;
            }
            if (i2 != 0) {
                return i2;
            }
            while (this.f195d > 0) {
                switch (a()) {
                    case 14:
                    case 15:
                        if (i == i3) {
                            return -1;
                        }
                        break;
                    case 16:
                    case 17:
                        if (i == i3) {
                            return 1;
                        }
                        break;
                    case 18:
                        i3++;
                        continue;
                }
                i3--;
            }
            return 0;
        }

        int e() {
            this.f195d = this.f194c;
            int i = 0;
            int i2 = 0;
            while (this.f195d > 0) {
                byte a2 = a();
                if (a2 != 0) {
                    if (a2 == 1 || a2 == 2) {
                        if (i == 0) {
                            return 1;
                        }
                        if (i2 == 0) {
                            i2 = i;
                        }
                    } else if (a2 != 9) {
                        switch (a2) {
                            case 14:
                            case 15:
                                if (i2 == i) {
                                    return -1;
                                }
                                i--;
                                break;
                            case 16:
                            case 17:
                                if (i2 == i) {
                                    return 1;
                                }
                                i--;
                                break;
                            case 18:
                                i++;
                                break;
                            default:
                                if (i2 != 0) {
                                    break;
                                } else {
                                    i2 = i;
                                    break;
                                }
                        }
                    } else {
                        continue;
                    }
                } else if (i == 0) {
                    return -1;
                } else {
                    if (i2 == 0) {
                        i2 = i;
                    }
                }
            }
            return 0;
        }
    }

    a(boolean z, int i, d dVar) {
        this.f186a = z;
        this.f187b = i;
        this.f188c = dVar;
    }

    private static int a(CharSequence charSequence) {
        return new b(charSequence, false).d();
    }

    private static int b(CharSequence charSequence) {
        return new b(charSequence, false).e();
    }

    public static a c() {
        return new C0008a().a();
    }

    static boolean e(Locale locale) {
        return f.b(locale) == 1;
    }

    private String f(CharSequence charSequence, d dVar) {
        boolean a2 = dVar.a(charSequence, 0, charSequence.length());
        return (this.f186a || !(a2 || b(charSequence) == 1)) ? this.f186a ? (!a2 || b(charSequence) == -1) ? f : "" : "" : e;
    }

    private String g(CharSequence charSequence, d dVar) {
        boolean a2 = dVar.a(charSequence, 0, charSequence.length());
        return (this.f186a || !(a2 || a(charSequence) == 1)) ? this.f186a ? (!a2 || a(charSequence) == -1) ? f : "" : "" : e;
    }

    public boolean d() {
        return (this.f187b & 2) != 0;
    }

    public CharSequence h(CharSequence charSequence) {
        return i(charSequence, this.f188c, true);
    }

    public CharSequence i(CharSequence charSequence, d dVar, boolean z) {
        if (charSequence == null) {
            return null;
        }
        boolean a2 = dVar.a(charSequence, 0, charSequence.length());
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (d() && z) {
            spannableStringBuilder.append((CharSequence) g(charSequence, a2 ? e.f207b : e.f206a));
        }
        if (a2 != this.f186a) {
            spannableStringBuilder.append(a2 ? (char) 8235 : (char) 8234);
            spannableStringBuilder.append(charSequence);
            spannableStringBuilder.append((char) 8236);
        } else {
            spannableStringBuilder.append(charSequence);
        }
        if (z) {
            spannableStringBuilder.append((CharSequence) f(charSequence, a2 ? e.f207b : e.f206a));
        }
        return spannableStringBuilder;
    }
}
