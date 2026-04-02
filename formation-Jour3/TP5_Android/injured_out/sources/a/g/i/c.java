package a.g.i;

import android.os.Build;
import android.text.PrecomputedText;
import android.text.Spannable;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.MetricAffectingSpan;
/* loaded from: classes.dex */
public class c implements Spannable {
    private final Spannable f;
    private final a g;
    private final PrecomputedText h;

    /* loaded from: classes.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private final TextPaint f198a;

        /* renamed from: b  reason: collision with root package name */
        private final TextDirectionHeuristic f199b;

        /* renamed from: c  reason: collision with root package name */
        private final int f200c;

        /* renamed from: d  reason: collision with root package name */
        private final int f201d;

        /* renamed from: a.g.i.c$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public static class C0009a {

            /* renamed from: a  reason: collision with root package name */
            private final TextPaint f202a;

            /* renamed from: b  reason: collision with root package name */
            private TextDirectionHeuristic f203b;

            /* renamed from: c  reason: collision with root package name */
            private int f204c;

            /* renamed from: d  reason: collision with root package name */
            private int f205d;

            public C0009a(TextPaint textPaint) {
                this.f202a = textPaint;
                if (Build.VERSION.SDK_INT >= 23) {
                    this.f204c = 1;
                    this.f205d = 1;
                } else {
                    this.f205d = 0;
                    this.f204c = 0;
                }
                this.f203b = Build.VERSION.SDK_INT >= 18 ? TextDirectionHeuristics.FIRSTSTRONG_LTR : null;
            }

            public a a() {
                return new a(this.f202a, this.f203b, this.f204c, this.f205d);
            }

            public C0009a b(int i) {
                this.f204c = i;
                return this;
            }

            public C0009a c(int i) {
                this.f205d = i;
                return this;
            }

            public C0009a d(TextDirectionHeuristic textDirectionHeuristic) {
                this.f203b = textDirectionHeuristic;
                return this;
            }
        }

        public a(PrecomputedText.Params params) {
            this.f198a = params.getTextPaint();
            this.f199b = params.getTextDirection();
            this.f200c = params.getBreakStrategy();
            this.f201d = params.getHyphenationFrequency();
            int i = Build.VERSION.SDK_INT;
        }

        a(TextPaint textPaint, TextDirectionHeuristic textDirectionHeuristic, int i, int i2) {
            if (Build.VERSION.SDK_INT >= 29) {
                new PrecomputedText.Params.Builder(textPaint).setBreakStrategy(i).setHyphenationFrequency(i2).setTextDirection(textDirectionHeuristic).build();
            }
            this.f198a = textPaint;
            this.f199b = textDirectionHeuristic;
            this.f200c = i;
            this.f201d = i2;
        }

        public boolean a(a aVar) {
            if ((Build.VERSION.SDK_INT < 23 || (this.f200c == aVar.b() && this.f201d == aVar.c())) && this.f198a.getTextSize() == aVar.e().getTextSize() && this.f198a.getTextScaleX() == aVar.e().getTextScaleX() && this.f198a.getTextSkewX() == aVar.e().getTextSkewX()) {
                if ((Build.VERSION.SDK_INT < 21 || (this.f198a.getLetterSpacing() == aVar.e().getLetterSpacing() && TextUtils.equals(this.f198a.getFontFeatureSettings(), aVar.e().getFontFeatureSettings()))) && this.f198a.getFlags() == aVar.e().getFlags()) {
                    int i = Build.VERSION.SDK_INT;
                    if (i >= 24) {
                        if (!this.f198a.getTextLocales().equals(aVar.e().getTextLocales())) {
                            return false;
                        }
                    } else if (i >= 17 && !this.f198a.getTextLocale().equals(aVar.e().getTextLocale())) {
                        return false;
                    }
                    return this.f198a.getTypeface() == null ? aVar.e().getTypeface() == null : this.f198a.getTypeface().equals(aVar.e().getTypeface());
                }
                return false;
            }
            return false;
        }

        public int b() {
            return this.f200c;
        }

        public int c() {
            return this.f201d;
        }

        public TextDirectionHeuristic d() {
            return this.f199b;
        }

        public TextPaint e() {
            return this.f198a;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj instanceof a) {
                a aVar = (a) obj;
                if (a(aVar)) {
                    return Build.VERSION.SDK_INT < 18 || this.f199b == aVar.d();
                }
                return false;
            }
            return false;
        }

        public int hashCode() {
            int i = Build.VERSION.SDK_INT;
            if (i >= 24) {
                return a.g.j.d.b(Float.valueOf(this.f198a.getTextSize()), Float.valueOf(this.f198a.getTextScaleX()), Float.valueOf(this.f198a.getTextSkewX()), Float.valueOf(this.f198a.getLetterSpacing()), Integer.valueOf(this.f198a.getFlags()), this.f198a.getTextLocales(), this.f198a.getTypeface(), Boolean.valueOf(this.f198a.isElegantTextHeight()), this.f199b, Integer.valueOf(this.f200c), Integer.valueOf(this.f201d));
            }
            if (i >= 21) {
                return a.g.j.d.b(Float.valueOf(this.f198a.getTextSize()), Float.valueOf(this.f198a.getTextScaleX()), Float.valueOf(this.f198a.getTextSkewX()), Float.valueOf(this.f198a.getLetterSpacing()), Integer.valueOf(this.f198a.getFlags()), this.f198a.getTextLocale(), this.f198a.getTypeface(), Boolean.valueOf(this.f198a.isElegantTextHeight()), this.f199b, Integer.valueOf(this.f200c), Integer.valueOf(this.f201d));
            }
            if (i < 18 && i < 17) {
                return a.g.j.d.b(Float.valueOf(this.f198a.getTextSize()), Float.valueOf(this.f198a.getTextScaleX()), Float.valueOf(this.f198a.getTextSkewX()), Integer.valueOf(this.f198a.getFlags()), this.f198a.getTypeface(), this.f199b, Integer.valueOf(this.f200c), Integer.valueOf(this.f201d));
            }
            return a.g.j.d.b(Float.valueOf(this.f198a.getTextSize()), Float.valueOf(this.f198a.getTextScaleX()), Float.valueOf(this.f198a.getTextSkewX()), Integer.valueOf(this.f198a.getFlags()), this.f198a.getTextLocale(), this.f198a.getTypeface(), this.f199b, Integer.valueOf(this.f200c), Integer.valueOf(this.f201d));
        }

        /* JADX WARN: Removed duplicated region for block: B:14:0x00e3  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public java.lang.String toString() {
            /*
                Method dump skipped, instructions count: 329
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: a.g.i.c.a.toString():java.lang.String");
        }
    }

    public a a() {
        return this.g;
    }

    public PrecomputedText b() {
        Spannable spannable = this.f;
        if (spannable instanceof PrecomputedText) {
            return (PrecomputedText) spannable;
        }
        return null;
    }

    @Override // java.lang.CharSequence
    public char charAt(int i) {
        return this.f.charAt(i);
    }

    @Override // android.text.Spanned
    public int getSpanEnd(Object obj) {
        return this.f.getSpanEnd(obj);
    }

    @Override // android.text.Spanned
    public int getSpanFlags(Object obj) {
        return this.f.getSpanFlags(obj);
    }

    @Override // android.text.Spanned
    public int getSpanStart(Object obj) {
        return this.f.getSpanStart(obj);
    }

    @Override // android.text.Spanned
    public <T> T[] getSpans(int i, int i2, Class<T> cls) {
        return Build.VERSION.SDK_INT >= 29 ? (T[]) this.h.getSpans(i, i2, cls) : (T[]) this.f.getSpans(i, i2, cls);
    }

    @Override // java.lang.CharSequence
    public int length() {
        return this.f.length();
    }

    @Override // android.text.Spanned
    public int nextSpanTransition(int i, int i2, Class cls) {
        return this.f.nextSpanTransition(i, i2, cls);
    }

    @Override // android.text.Spannable
    public void removeSpan(Object obj) {
        if (obj instanceof MetricAffectingSpan) {
            throw new IllegalArgumentException("MetricAffectingSpan can not be removed from PrecomputedText.");
        }
        if (Build.VERSION.SDK_INT >= 29) {
            this.h.removeSpan(obj);
        } else {
            this.f.removeSpan(obj);
        }
    }

    @Override // android.text.Spannable
    public void setSpan(Object obj, int i, int i2, int i3) {
        if (obj instanceof MetricAffectingSpan) {
            throw new IllegalArgumentException("MetricAffectingSpan can not be set to PrecomputedText.");
        }
        if (Build.VERSION.SDK_INT >= 29) {
            this.h.setSpan(obj, i, i2, i3);
        } else {
            this.f.setSpan(obj, i, i2, i3);
        }
    }

    @Override // java.lang.CharSequence
    public CharSequence subSequence(int i, int i2) {
        return this.f.subSequence(i, i2);
    }

    @Override // java.lang.CharSequence
    public String toString() {
        return this.f.toString();
    }
}
