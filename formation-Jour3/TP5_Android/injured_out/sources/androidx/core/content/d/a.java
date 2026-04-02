package androidx.core.content.d;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.util.Xml;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    private static final ThreadLocal<TypedValue> f733a = new ThreadLocal<>();

    public static ColorStateList a(Resources resources, XmlPullParser xmlPullParser, Resources.Theme theme) {
        int next;
        AttributeSet asAttributeSet = Xml.asAttributeSet(xmlPullParser);
        do {
            next = xmlPullParser.next();
            if (next == 2) {
                break;
            }
        } while (next != 1);
        if (next == 2) {
            return b(resources, xmlPullParser, asAttributeSet, theme);
        }
        throw new XmlPullParserException("No start tag found");
    }

    public static ColorStateList b(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
        String name = xmlPullParser.getName();
        if (name.equals("selector")) {
            return e(resources, xmlPullParser, attributeSet, theme);
        }
        throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": invalid color state list tag " + name);
    }

    private static TypedValue c() {
        TypedValue typedValue = f733a.get();
        if (typedValue == null) {
            TypedValue typedValue2 = new TypedValue();
            f733a.set(typedValue2);
            return typedValue2;
        }
        return typedValue;
    }

    public static ColorStateList d(Resources resources, int i, Resources.Theme theme) {
        try {
            return a(resources, resources.getXml(i), theme);
        } catch (Exception e) {
            Log.e("CSLCompat", "Failed to inflate ColorStateList.", e);
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x008a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static android.content.res.ColorStateList e(android.content.res.Resources r17, org.xmlpull.v1.XmlPullParser r18, android.util.AttributeSet r19, android.content.res.Resources.Theme r20) {
        /*
            r0 = r17
            r1 = r19
            r2 = r20
            int r3 = r18.getDepth()
            r4 = 1
            int r3 = r3 + r4
            r5 = 20
            int[][] r6 = new int[r5]
            int[] r5 = new int[r5]
            r7 = 0
            r8 = 0
        L14:
            int r9 = r18.next()
            if (r9 == r4) goto Lc5
            int r10 = r18.getDepth()
            if (r10 >= r3) goto L23
            r11 = 3
            if (r9 == r11) goto Lc5
        L23:
            r11 = 2
            if (r9 != r11) goto Lc2
            if (r10 > r3) goto Lc2
            java.lang.String r9 = r18.getName()
            java.lang.String r10 = "item"
            boolean r9 = r9.equals(r10)
            if (r9 != 0) goto L36
            goto Lc2
        L36:
            int[] r9 = a.g.c.ColorStateListItem
            android.content.res.TypedArray r9 = h(r0, r2, r1, r9)
            int r10 = a.g.c.ColorStateListItem_android_color
            r11 = -1
            int r10 = r9.getResourceId(r10, r11)
            r12 = -65281(0xffffffffffff00ff, float:NaN)
            if (r10 == r11) goto L5b
            boolean r11 = f(r0, r10)
            if (r11 != 0) goto L5b
            android.content.res.XmlResourceParser r10 = r0.getXml(r10)     // Catch: java.lang.Exception -> L5b
            android.content.res.ColorStateList r10 = a(r0, r10, r2)     // Catch: java.lang.Exception -> L5b
            int r10 = r10.getDefaultColor()     // Catch: java.lang.Exception -> L5b
            goto L61
        L5b:
            int r10 = a.g.c.ColorStateListItem_android_color
            int r10 = r9.getColor(r10, r12)
        L61:
            r11 = 1065353216(0x3f800000, float:1.0)
            int r12 = a.g.c.ColorStateListItem_android_alpha
            boolean r12 = r9.hasValue(r12)
            if (r12 == 0) goto L72
            int r12 = a.g.c.ColorStateListItem_android_alpha
        L6d:
            float r11 = r9.getFloat(r12, r11)
            goto L7d
        L72:
            int r12 = a.g.c.ColorStateListItem_alpha
            boolean r12 = r9.hasValue(r12)
            if (r12 == 0) goto L7d
            int r12 = a.g.c.ColorStateListItem_alpha
            goto L6d
        L7d:
            r9.recycle()
            int r9 = r19.getAttributeCount()
            int[] r12 = new int[r9]
            r13 = 0
            r14 = 0
        L88:
            if (r13 >= r9) goto Lad
            int r15 = r1.getAttributeNameResource(r13)
            r4 = 16843173(0x10101a5, float:2.3694738E-38)
            if (r15 == r4) goto La9
            r4 = 16843551(0x101031f, float:2.3695797E-38)
            if (r15 == r4) goto La9
            int r4 = a.g.a.alpha
            if (r15 == r4) goto La9
            int r4 = r14 + 1
            boolean r16 = r1.getAttributeBooleanValue(r13, r7)
            if (r16 == 0) goto La5
            goto La6
        La5:
            int r15 = -r15
        La6:
            r12[r14] = r15
            r14 = r4
        La9:
            int r13 = r13 + 1
            r4 = 1
            goto L88
        Lad:
            int[] r4 = android.util.StateSet.trimStateSet(r12, r14)
            int r9 = g(r10, r11)
            int[] r5 = androidx.core.content.d.e.a(r5, r8, r9)
            java.lang.Object[] r4 = androidx.core.content.d.e.b(r6, r8, r4)
            r6 = r4
            int[][] r6 = (int[][]) r6
            int r8 = r8 + 1
        Lc2:
            r4 = 1
            goto L14
        Lc5:
            int[] r0 = new int[r8]
            int[][] r1 = new int[r8]
            java.lang.System.arraycopy(r5, r7, r0, r7, r8)
            java.lang.System.arraycopy(r6, r7, r1, r7, r8)
            android.content.res.ColorStateList r2 = new android.content.res.ColorStateList
            r2.<init>(r1, r0)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.content.d.a.e(android.content.res.Resources, org.xmlpull.v1.XmlPullParser, android.util.AttributeSet, android.content.res.Resources$Theme):android.content.res.ColorStateList");
    }

    private static boolean f(Resources resources, int i) {
        TypedValue c2 = c();
        resources.getValue(i, c2, true);
        int i2 = c2.type;
        return i2 >= 28 && i2 <= 31;
    }

    private static int g(int i, float f) {
        return (i & 16777215) | (Math.round(Color.alpha(i) * f) << 24);
    }

    private static TypedArray h(Resources resources, Resources.Theme theme, AttributeSet attributeSet, int[] iArr) {
        return theme == null ? resources.obtainAttributes(attributeSet, iArr) : theme.obtainStyledAttributes(attributeSet, iArr, 0, 0);
    }
}
